package my.swing;

import javax.swing.*;

public class HelloFrame extends JFrame {

    public HelloFrame() {
        this.setLayout(null);
        this.setBounds(20,20, 120, 110);

        JButton btn = new JButton();
        btn.setBounds(10,10, 100, 40);
        btn.setText("Click me");
        btn.addActionListener(e -> {
            btn.setText("Hello, world!");
        });

        this.add(btn);
    }

    public static void main(String[] args) {
        HelloFrame frame = new HelloFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
