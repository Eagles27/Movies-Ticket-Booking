package Front;

import Back.ClientInfo;
import Back.login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class NewCustomerPage extends JFrame {
    private JTextField JTextFieldName;
    private JTextField JTextFieldFirstName;
    private JTextField JtextFieldMail;
    private JPasswordField JTextFieldPassword;
    private JPasswordField JTextFieldConfirm;
    private JRadioButton sendMeTheNewsletterRadioButton;
    private JRadioButton acceptTheCGURadioButton;
    private JButton VALIDATEButton;
    private JButton buttonExit;
    private JPanel NewCustomerPage;
    private JLabel JLabelWrongPassword;
    private JLabel JLabelCGUConfirm;
    private JComboBox comboBoxYears;
    private JComboBox comboBoxMonths;
    private JComboBox comboBoxDay;


    public NewCustomerPage() {
        JFrame window = new JFrame();
        window.setContentPane(NewCustomerPage);
        window.setTitle("SignUP");
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        VALIDATEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String date = comboBoxYears.getSelectedItem().toString() + "-" + comboBoxMonths.getSelectedItem().toString() + "-" + comboBoxDay.getSelectedItem().toString();
                boolean NULL = (JTextFieldName.getText().isEmpty() || JTextFieldFirstName.getText().isEmpty() || JtextFieldMail.getText().isEmpty() || JTextFieldPassword.getText().isEmpty());

                ClientInfo user = new ClientInfo(); user.setMail(JtextFieldMail.getText());
                boolean Registered = user.AlreadyRegistered();

                if (NULL) {
                    reset();
                    JLabelWrongPassword.setText("Please fill all the fields");
                } else if (Registered) {
                    reset();
                    JLabelCGUConfirm.setText("Mail already registered");
                } else if (!Arrays.equals(JTextFieldPassword.getPassword(), JTextFieldConfirm.getPassword())) {
                    reset();
                    JLabelWrongPassword.setText("Wrong password, try again.");

                } else if (!acceptTheCGURadioButton.isSelected()) {
                    reset();
                    JLabelCGUConfirm.setText("Please accept the CGU");

                } else {
                    Back.login client = new login(JTextFieldName.getText(), JTextFieldFirstName.getText(), date, JtextFieldMail.getText(), JTextFieldPassword.getText());
                    client.signUp();
                    new BuyPage(JtextFieldMail.getText());
                    window.dispose();
                }


            }
        });
        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new WelcomePage();
                window.dispose();
            }
        });
    }


    private void reset() {
        JLabelCGUConfirm.setText(" ");
        JLabelWrongPassword.setText(" ");
    }
}
