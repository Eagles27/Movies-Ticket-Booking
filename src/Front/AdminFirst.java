package Front;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminFirst extends JFrame{


    private JPanel panel1;
    private JButton button1;
    private JButton modifyAddDeleteAButton;
    private JButton showStatisticsButton;
    private JButton showChiffreDAffaireButton;
    private JButton createAnOfferButton;
    private JTextField nameOfTheSelectedTextField;

    public AdminFirst(){
        JFrame window = new JFrame();
        window.setContentPane(panel1);
        window.setTitle("ADMIN Home");
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new WelcomePage();
                window.dispose();
            }
        });

        modifyAddDeleteAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminAddModifyDelete();
                window.dispose();
            }
        });
        createAnOfferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminOffer();
                window.dispose();
            }
        });
        showStatisticsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminFilmStats();
                window.dispose();
            }
        });
        showChiffreDAffaireButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminCA();
                window.dispose();
            }
        });
    }
}
