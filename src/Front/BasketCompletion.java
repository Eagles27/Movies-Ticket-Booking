package Front;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BasketCompletion extends JFrame {
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton GOButton;
    private JButton button1;
    private JLabel JLabelTitle;
    private JLabel JLabelDate;
    private JLabel JLabelTicketA;
    private JLabel JLabelTicketC;
    private JLabel JLabelPrice;


    public BasketCompletion(String Title, String Date, String Seance, int NumberTicketA, int NumberTicketC, Double Price) {
        JFrame window = new JFrame();
        window.setContentPane(panel1);
        window.setTitle("Basket");
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        Update(Title, Date, Seance, NumberTicketA, NumberTicketC, Price);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }


    private void Update(String Title, String Date, String Seance, int NumberTicketA, int NumberTicketC, Double Price) {

        JLabelTitle.setText(Title);
        JLabelDate.setText(Date + " " + Seance);
        JLabelTicketA.setText(String.valueOf(NumberTicketA));
        JLabelTicketC.setText(String.valueOf(NumberTicketC));
        JLabelPrice.setText("£" + Price);
    }


}
