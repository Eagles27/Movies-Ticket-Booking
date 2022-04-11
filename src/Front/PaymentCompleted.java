package Front;

import javax.swing.*;

public class PaymentCompleted extends JFrame {
    private JPanel panel1;
    private JProgressBar progressBar1;
    private JLabel JLabelMessage;
    private JLabel JLabelIcon;
    private JLabel JLabelMail;
    private JLabel JLabelRedirection;

    public PaymentCompleted(JFrame pastWindow) {
        JFrame window = new JFrame();
        window.setContentPane(panel1);
        window.setTitle("3DSecure");
        window.setSize(300, 400);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        JLabelIcon.setVisible(false);
        JLabelMessage.setVisible(false);
        JLabelMail.setVisible(false);
        JLabelRedirection.setVisible(false);


        new Thread(new Runnable() {
            public void run() {
                progressBar1.setStringPainted(true);
                progressBar1.setMaximum(500);
                progressBar1.setVisible(true);
                loop();
                progressBar1.setVisible(false);
                JLabelIcon.setVisible(true);
                JLabelMessage.setVisible(true);
                JLabelMail.setVisible(true);
                JLabelRedirection.setVisible(true);

                try {
                    Thread.sleep(5000);
                    new WelcomePage();
                    window.dispose();
                    pastWindow.dispose();
                } catch (InterruptedException ignored) {

                }
            }
        }).start();






    }


    public void loop() {
        int i = 0;
        while (i <= 500) {
            progressBar1.setValue(i);
            i += 10;
            try {
                Thread.sleep(120);
            } catch (Exception ignored) {

            }
        }
    }
}

