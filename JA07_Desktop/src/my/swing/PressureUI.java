package my.swing;

import javax.swing.*;

public class PressureUI extends JFrame {

    Meter meter = new Meter();

    public PressureUI() {
        this.setLayout(null);
        this.setBounds(20,20, 180, 300);

        JButton btn = new JButton();
        btn.setBounds(10,10, 140, 40);
        btn.setText("Get data");


        JTextField txt1 = new JTextField();
        txt1.setBounds(10,60, 140, 20);

        JTextField txt2 = new JTextField();
        txt2.setBounds(10,90, 140, 20);

        JTextField txt3 = new JTextField();
        txt3.setBounds(10,120, 140, 20);

        JTextField txt4 = new JTextField();
        txt4.setBounds(10,150, 140, 20);

        JTextField txt5 = new JTextField();
        txt5.setBounds(10,180, 140, 20);
        
        this.add(btn);
        this.add(txt1);
        this.add(txt2);
        this.add(txt3);
        this.add(txt4);
        this.add(txt5);

        btn.addActionListener(e -> {
            String result = meter.get(1);
            txt1.setText(result);
        });

    }

    public static void main(String[] args) {
        PressureUI frame = new PressureUI();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
