package my.swing;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class PressureUI extends JFrame {

    Meter meter = new Meter();
    List<JTextField> displays = new ArrayList<>();
    //Потоко-базопасное "целое", не требует блокировок
    AtomicInteger counter = new AtomicInteger();

    public PressureUI() {
        this.setLayout(null);
        this.setBounds(20,20, 180, 300);

        JButton btn = new JButton();
        btn.setBounds(10,10, 140, 40);
        btn.setText("Get data");

        JTextField txt1 = new JTextField();
        txt1.setBounds(10,60, 140, 20);
        displays.add(txt1);

        JTextField txt2 = new JTextField();
        txt2.setBounds(10,90, 140, 20);
        displays.add(txt2);

        JTextField txt3 = new JTextField();
        txt3.setBounds(10,120, 140, 20);
        displays.add(txt3);

        JTextField txt4 = new JTextField();
        txt4.setBounds(10,150, 140, 20);
        displays.add(txt4);

        JTextField txt5 = new JTextField();
        txt5.setBounds(10,180, 140, 20);
        displays.add(txt5);

        JProgressBar bar = new JProgressBar();
        bar.setBounds(10,210, 140, 15);
        bar.setIndeterminate(true);
        bar.setVisible(false);
        
        this.add(btn);
        this.add(txt1);
        this.add(txt2);
        this.add(txt3);
        this.add(txt4);
        this.add(txt5);
        this.add(bar);

        //Экзекьютор, которые следит за показом прогресс бара
        ScheduledExecutorService watch = Executors.newScheduledThreadPool(1);
        watch.scheduleAtFixedRate(() ->{
            System.out.println("Executor is on");
            if (counter.get() == 0) {
                SwingUtilities.invokeLater(() -> {
                    bar.setVisible(false);
                });
            }
        },1,1, TimeUnit.SECONDS);

        btn.addActionListener(e -> {
            displays.forEach(d ->{
                d.setText("Wait...");
            });

            bar.setVisible(true);
            counter.set(5);

            //Запрос показаний датчиков в параллельных потоках
            for(int n=1; n<6; n++) {
                final int i = n;
                new Thread(() -> {
                    String result = meter.get(i);
                    //Так нельзя: thread affinity
                    //displays.get(i - 1).setText(result);
                    //Вызов исполнения на основном потоке:
                    SwingUtilities.invokeLater(() -> {
                        displays.get(i - 1).setText(result);
                    });
                    counter.decrementAndGet();
                }).start();

            }
        });

    }

    public static void main(String[] args) {
        PressureUI frame = new PressureUI();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
