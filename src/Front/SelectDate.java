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
    private JLabel JLabelPrice;

    private ArrayList<String> listSession = new ArrayList<>();
    private int numberOfChildrenTicket;
    private int numberOfTicket;


    public SelectDate(int movie, int numberOfTicket, String date, int numberOfChildrenTicket, int[] index) {
        JFrame window = new JFrame();
        this.numberOfChildrenTicket = numberOfChildrenTicket;
        this.numberOfTicket = numberOfTicket;
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

        JLabelPrice.setText("£"+String.valueOf(priceCalcul()));



        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.dispose();
                new BuyPage(movie, numberOfTicket, date, numberOfChildrenTicket, index);

            }
        });
    }

    public SelectDate(int movie, int numberOfTicket, String date, int numberOfChildrenTicket, int[] index, int id) {
        JFrame window = new JFrame();
        this.numberOfTicket = numberOfTicket;
        this.numberOfChildrenTicket = numberOfChildrenTicket;
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

        //Price
        JLabelPrice.setText("£"+String.valueOf(priceCalcul(-1)));



        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.dispose();
                new BuyPage(user.getMail(), movie, numberOfTicket, date, numberOfChildrenTicket, index);

            }
        });
    }


    //Functions prices
    private double priceCalcul(){
        return 7.50 * numberOfChildrenTicket + 11.50 * numberOfTicket;
    }
    private double priceCalcul(int id){
        return 5.00 * numberOfChildrenTicket + 9.50 * numberOfTicket;
    }



}
