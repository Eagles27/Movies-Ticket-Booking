package Front;

import Back.ClientInfo;
import Back.ListMovies;
import bdd.mySQL;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SelectDate extends JFrame {
    private JPanel SelectDataPane;
    private JButton proceedToPaymentButton;
    private JRadioButton JRsession1;
    private JRadioButton JRsession2;
    private JRadioButton JRsession3;
    private JRadioButton JRsession4;
    private JRadioButton JRsession5;
    private JButton button1;
    private JLabel JLabelTitle;
    private JLabel JLabelNumberTicket;
    private JLabel JLabelName;
    private JLabel JLabelMember;
    private JLabel JLabelDate;

    private ArrayList<String> listSession = new ArrayList<>();


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

        //Session
        mySQL bdd = new mySQL();
        listSession = bdd.multipleSelect("SELECT session.startingTime FROM session JOIN movie ON session.idmovie = movie.idmovie WHERE movie.name='"+movies.getMovieName(movie)+"'");
        JRsession1.setText(listSession.get(0));
        JRsession2.setText(listSession.get(1));
        JRsession3.setText(listSession.get(2));
        JRsession4.setText(listSession.get(3));
        JRsession5.setText(listSession.get(4));


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

        //Session
        mySQL bdd = new mySQL();
        listSession = bdd.multipleSelect("SELECT session.startingTime FROM session JOIN movie ON session.idmovie = movie.idmovie WHERE movie.name='"+movies.getMovieName(movie)+"'");
        JRsession1.setText(listSession.get(0));
        JRsession2.setText(listSession.get(1));
        JRsession3.setText(listSession.get(2));
        JRsession4.setText(listSession.get(3));
        JRsession5.setText(listSession.get(4));



        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.dispose();
                new BuyPage(user.getMail(), movie, numberOfTicket, date, age, index);

            }
        });
    }


}
