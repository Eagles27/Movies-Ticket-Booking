package Front;

import Back.ClientInfo;
import Back.ListMovies;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectDate extends JFrame {
    private JPanel SelectDataPane;
    private JButton proceedToPaymentButton;
    private JRadioButton heureSéance1RadioButton;
    private JRadioButton heureSéance2RadioButton;
    private JRadioButton heureSéance3RadioButton;
    private JRadioButton heureSéance4RadioButton;
    private JRadioButton heureSéance5RadioButton;
    private JButton button1;
    private JLabel JLabelTitle;
    private JLabel JLabelNumberTicket;
    private JLabel JLabelName;
    private JLabel JLabelMember;
    private JLabel JLabelDate;


    public SelectDate(int movie, int numberOfTicket, String date, int age, int[] index) {
        JFrame window = new JFrame();
        window.setContentPane(SelectDataPane);
        window.setTitle("SelectDate");
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        //Backup Movie
        ListMovies movies = new ListMovies();
        JLabelTitle.setText(movies.getMovieName(movie));
        JLabelNumberTicket.setText(String.valueOf(numberOfTicket));
        JLabelDate.setText("Available film sessions on " + date + " :");

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.dispose();
                new BuyPage(movie, numberOfTicket, date, age, index);

            }
        });
    }

    public SelectDate(int movie, int numberOfTicket, String date, int age, int[] index, int id) {
        JFrame window = new JFrame();
        window.setContentPane(SelectDataPane);
        window.setTitle("SelectDate");
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        ClientInfo user = new ClientInfo(id);
        JLabelMember.setText(user.getMember());
        JLabelName.setText(user.getName() + user.getSurname());
        //Backup Movie
        ListMovies movies = new ListMovies();
        JLabelTitle.setText(movies.getMovieName(movie));
        JLabelNumberTicket.setText(String.valueOf(numberOfTicket));
        JLabelDate.setText("Available film sessions on " + date + " :");


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.dispose();
                new BuyPage(user.getMail(), movie, numberOfTicket, date, age, index);

            }
        });
    }


}
