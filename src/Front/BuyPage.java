package Front;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuyPage extends JFrame {
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JRadioButton radioButton4;
    private JRadioButton radioButton5;
    private JRadioButton radioButton6;
    private JRadioButton radioButton7;
    private JRadioButton radioButton8;
    private JRadioButton radioButton9;
    private JRadioButton radioButton10;
    private JTextField textField1;
    private JTextField textField2;
    private JButton ButtonNext;
    private JButton button1;
    private JPanel panelBuy;


    public BuyPage(){
        JFrame window = new JFrame();
        window.setContentPane(panelBuy);
        window.setTitle("BUY");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(800,300);
        window.setVisible(true);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new WelcomePage();
                window.dispose();
            }
        });
    }
}
