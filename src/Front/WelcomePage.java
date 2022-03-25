package Front;

import Back.Hashing;
import Back.login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePage extends JFrame {
    private JTextField mailField;
    private JPasswordField passwordField;
    private JButton ButtonNew;
    private JButton ButtonLogin;
    private JPanel panelLogin;
    private JButton buttonBuy;
    private JLabel DescriptionF1;
    private JLabel DescriptionF2;
    private JLabel DescriptionF3;


    private String mail, password;


    public WelcomePage() {
        JFrame frame = new JFrame();
        frame.setContentPane(panelLogin);
        frame.setTitle("Welcome");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 300);
        frame.setVisible(true);


        buttonBuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mail = mailField.getText();
                password = Hashing.doHashing(passwordField.getText());
                Back.login test = new login(mail, password);
                System.out.println(test.signIn());
                new BuyPage();
                frame.dispose();

            }
        });
    }
}
