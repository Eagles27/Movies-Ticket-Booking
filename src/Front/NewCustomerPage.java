package Front;

import Back.login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class NewCustomerPage extends JFrame {
    private JTextField JTextFieldName;
    private JTextField JTextFieldFirstName;
    private JTextField JTextFieldBirth;
    private JTextField JtextFieldMail;
    private JPasswordField JTextFieldPassword;
    private JPasswordField JTextFieldConfirm;
    private JRadioButton sendMeTheNewsletterRadioButton;
    private JRadioButton acceptTheCGURadioButton;
    private JButton VALIDATEButton;
    private JButton button1;
    private JPanel NewCustomerPage;
    private JLabel JLabelWrongPassword;
    private JLabel JLabelCGUConfirm;


    public NewCustomerPage(){
        JFrame window = new JFrame();
        window.setContentPane(NewCustomerPage);
        window.setTitle("SignUP");
        window.setSize(300,500);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        VALIDATEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                boolean NoNULL = (JTextFieldName.getText().isEmpty() && JTextFieldFirstName.getText().isEmpty() && JTextFieldBirth.getText().isEmpty() && JtextFieldMail.getText().isEmpty() && JTextFieldPassword.getText().isEmpty());

                if(Arrays.equals(JTextFieldPassword.getPassword(), JTextFieldConfirm.getPassword()) && NoNULL && acceptTheCGURadioButton.isSelected()){
                    Back.login client = new login(JTextFieldName.getText(),JTextFieldFirstName.getText(),JTextFieldBirth.getText(),JtextFieldMail.getText(),JTextFieldPassword.getText());
                    client.signUp();
                }

                else if (!Arrays.equals(JTextFieldPassword.getPassword(), JTextFieldConfirm.getPassword())){
                    JLabelCGUConfirm.setText("");
                    JLabelWrongPassword.setText("Wrong password, try again.");
                }

                else if(!acceptTheCGURadioButton.isSelected()){
                    JLabelWrongPassword.setText("");
                    JLabelCGUConfirm.setText("Please accept the CGU");
                }

                else{
                    JLabelCGUConfirm.setText("");
                    JLabelWrongPassword.setText("Please fill all the fields");
                }

            }
        });
    }
}
