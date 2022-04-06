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
    private JButton eraseButton;
    private JLabel JLabelNumberCTicket;

    private ArrayList<String> listSession;
    private int numberOfChildrenTicket;
    private int numberOfTicket;


    public SelectDate(int movie, int numberOfTicket, String date, int numberOfChildrenTicket, int[] index) {
        JFrame window = new JFrame();
        this.numberOfTicket = numberOfTicket;
        this.numberOfChildrenTicket = numberOfChildrenTicket;
        window.setContentPane(SelectDataPane);
        window.setTitle("SelectDate");
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        //Backup Movie
        ListMovies movies = new ListMovies();
        JLabelTitle.setText(movies.getMovieName(movie));
        JLabelNumberTicket.setText(String.valueOf(numberOfTicket));
        JLabelNumberCTicket.setText(String.valueOf(numberOfChildrenTicket));
        JLabelDate.setText("Available film sessions on " + date + " :");

        //Session
        mySQL bdd = new mySQL();
        listSession = bdd.multipleSelect("SELECT session.startingTime FROM session JOIN movie ON session.idmovie = movie.idmovie WHERE movie.name='" + movies.getMovieName(movie) + "'");
        JRsession1.setText(listSession.get(0));
        JRsession2.setText(listSession.get(1));
        JRsession3.setText(listSession.get(2));
        JRsession4.setText(listSession.get(3));
        JRsession5.setText(listSession.get(4));

        NoSession();

        JLabelPrice.setText("£" + String.valueOf(priceCalcul()));


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.dispose();
                new BuyPage(movie, numberOfTicket, numberOfChildrenTicket, date, numberOfChildrenTicket, index);

            }
        });

        JRsession1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRsession2.setEnabled(false);
                JRsession3.setEnabled(false);
                JRsession4.setEnabled(false);
                JRsession5.setEnabled(false);
            }
        });
        JRsession2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRsession1.setEnabled(false);
                JRsession3.setEnabled(false);
                JRsession4.setEnabled(false);
                JRsession5.setEnabled(false);
            }
        });
        JRsession3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRsession2.setEnabled(false);
                JRsession1.setEnabled(false);
                JRsession4.setEnabled(false);
                JRsession5.setEnabled(false);
            }
        });
        JRsession4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRsession2.setEnabled(false);
                JRsession3.setEnabled(false);
                JRsession1.setEnabled(false);
                JRsession5.setEnabled(false);
            }
        });
        JRsession5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRsession2.setEnabled(false);
                JRsession3.setEnabled(false);
                JRsession4.setEnabled(false);
                JRsession1.setEnabled(false);
            }
        });
        eraseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Reset();
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
        JLabelName.setText(user.getSurname() + " " + user.getName());

        //Backup Movie
        ListMovies movies = new ListMovies();
        JLabelTitle.setText(movies.getMovieName(movie));
        JLabelNumberTicket.setText(String.valueOf(numberOfTicket));
        JLabelNumberCTicket.setText(String.valueOf(numberOfChildrenTicket));
        JLabelDate.setText("Available film sessions on " + date + " :");

        //Session
        mySQL bdd = new mySQL();
        listSession = bdd.multipleSelect("SELECT session.startingTime FROM session JOIN movie ON session.idmovie = movie.idmovie WHERE movie.name='" + movies.getMovieName(movie) + "'");
        JRsession1.setText(listSession.get(0));
        JRsession2.setText(listSession.get(1));
        JRsession3.setText(listSession.get(2));
        JRsession4.setText(listSession.get(3));
        JRsession5.setText(listSession.get(4));

        NoSession();

        //Price
        JLabelPrice.setText("£" + String.valueOf(priceCalcul(-1)));


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.dispose();
                new BuyPage(user.getMail(), movie, numberOfTicket, numberOfChildrenTicket, date, index);

            }
        });

        JRsession1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRsession2.setEnabled(false);
                JRsession3.setEnabled(false);
                JRsession4.setEnabled(false);
                JRsession5.setEnabled(false);
            }
        });
        JRsession2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRsession1.setEnabled(false);
                JRsession3.setEnabled(false);
                JRsession4.setEnabled(false);
                JRsession5.setEnabled(false);
            }
        });
        JRsession3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRsession2.setEnabled(false);
                JRsession1.setEnabled(false);
                JRsession4.setEnabled(false);
                JRsession5.setEnabled(false);
            }
        });
        JRsession4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRsession2.setEnabled(false);
                JRsession3.setEnabled(false);
                JRsession1.setEnabled(false);
                JRsession5.setEnabled(false);
            }
        });
        JRsession5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRsession2.setEnabled(false);
                JRsession3.setEnabled(false);
                JRsession4.setEnabled(false);
                JRsession1.setEnabled(false);
            }
        });

        eraseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Reset();
            }
        });
    }


    //Function button
    private void NoSession() {
        if (JRsession1.getText().equals("No more dates available")) JRsession1.setEnabled(false);
        if (JRsession2.getText().equals("No more dates available")) JRsession2.setEnabled(false);
        if (JRsession3.getText().equals("No more dates available")) JRsession3.setEnabled(false);
        if (JRsession4.getText().equals("No more dates available")) JRsession4.setEnabled(false);
        if (JRsession5.getText().equals("No more dates available")) JRsession5.setEnabled(false);
    }

    private void Reset() {
        JRsession1.setSelected(false);
        JRsession2.setSelected(false);
        JRsession3.setSelected(false);
        JRsession4.setSelected(false);
        JRsession5.setSelected(false);

        JRsession1.setEnabled(true);
        JRsession2.setEnabled(true);
        JRsession3.setEnabled(true);
        JRsession4.setEnabled(true);
        JRsession5.setEnabled(true);

        NoSession();
    }

    //Functions prices
    private double priceCalcul() {
        return 7.50 * numberOfChildrenTicket + 11.50 * numberOfTicket;
    }

    private double priceCalcul(int id) {
        return 5.00 * numberOfChildrenTicket + 9.50 * numberOfTicket;
    }


}
