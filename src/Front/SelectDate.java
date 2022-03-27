package Front;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectDate extends JFrame{
    private JPanel SelectDataPane;
    private JButton proceedToPaymentButton;
    private JRadioButton heureSéance1RadioButton;
    private JRadioButton heureSéance2RadioButton;
    private JRadioButton heureSéance3RadioButton;
    private JRadioButton heureSéance4RadioButton;
    private JRadioButton heureSéance5RadioButton;
    private JButton button1;



    public SelectDate(int movie,int numberOfTicket, String date, int age){
        JFrame window = new JFrame();
        window.setContentPane(SelectDataPane);
        window.setTitle("SelectDate");
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.dispose();
                new BuyPage(movie,numberOfTicket,date,age);

            }
        });
    }
}
