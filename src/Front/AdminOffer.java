package Front;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminOffer extends JFrame{
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton CONFIRMButton;
    private JButton a6Button;

    public AdminOffer(){
        JFrame window = new JFrame();
        window.setContentPane(panel1);
        window.setTitle("ADMIN Offer");
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        a6Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminFirst();
                window.dispose();
            }
        });
    }
}
