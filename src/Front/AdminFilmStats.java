package Front;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminFilmStats extends JFrame{
    private JPanel panel1;
    private JButton button1;

    public AdminFilmStats(){
        JFrame window = new JFrame();
        window.setContentPane(panel1);
        window.setTitle("ADMIN Stats");
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminFirst();
                window.dispose();
            }
        });
    }

}
