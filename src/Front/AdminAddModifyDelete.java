package Front;

import bdd.mySQL;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminAddModifyDelete extends JFrame {
    private JPanel panel1;
    private JTextField JLabelTitle;
    private JTextField scheduledProjectionTextField1;
    private JTextField typeHereTheRoomTextField;
    private JButton confirmButton;
    private JTextField nameOfTheMovieTextField;
    private JTextField scheduledProjectionTextField;
    private JTextField typeHereTheRoomTextField2;
    private JButton nextButton;
    private JButton DELETEALLButton;
    private JTextField JLabelTitleDelete;
    private JButton DELETEONLYTHISONEButton;
    private JTextField scheduledProjectionTextField2;
    private JButton a6Button;
    private JComboBox comboBoxYears;
    private JComboBox comboBoxMonths;
    private JComboBox comboBoxDay;
    private JTextField JLabelGenre;
    private JTextField JLabelDuration;

    private String Title;
    private String Genre;
    private String Duration;
    private String DateReleased;


    public AdminAddModifyDelete() {
        JFrame window = new JFrame();
        window.setContentPane(panel1);
        window.setTitle("ADMIN ModifyDelete");
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
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bdd.mySQL BDD = new mySQL();
                Title = JLabelTitle.getText().toUpperCase();
                Genre = JLabelGenre.getText();
                Duration = JLabelDuration.getText();
                DateReleased = comboBoxYears.getSelectedItem().toString();
                BDD.insert1("INSERT INTO movie (name,genre,duration,released) VALUES('" + Title + "'," + "'" + Genre + "','" + Duration + "','" + DateReleased + "')");

            }
        });
        DELETEALLButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bdd.mySQL BDD = new mySQL();
                BDD.insert1("DELETE FROM movie WHERE name = '" + JLabelTitleDelete.getText().toUpperCase() + "'");
            }
        });
    }
}
