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
    private JLabel JLabelPlace1;
    private JLabel JLabelPlace2;
    private JLabel JLabelPlace3;
    private JLabel JLabelPlace5;
    private JLabel JLabelPlace4;
    private JLabel JLabelMessage;

    private ArrayList<String> listSession;
    private ArrayList<String> lisSessionP;
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

        Update(movie, date);

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
        proceedToPaymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Confirmation()) {
                    window.dispose();
                    ListMovies movies = new ListMovies();
                    new BasketCompletion(movies.getMovieName(movie), date, ChoiceSession(), numberOfTicket, numberOfChildrenTicket, priceCalcul(), movie, index);
                }

                else JLabelMessage.setText("Please select a session");
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

        //Client Info
        ClientInfo user = new ClientInfo(id);
        JLabelMember.setText(user.getMember());
        JLabelName.setText(user.getSurname() + " " + user.getName());

        Update(movie, date);

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

        proceedToPaymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Confirmation()) {
                    window.dispose();
                    ListMovies movies = new ListMovies();
                    new BasketCompletion(movies.getMovieName(movie), date, ChoiceSession(), numberOfTicket, numberOfChildrenTicket, priceCalcul(id), movie, index, id);
                } else JLabelMessage.setText("Please select a session");

            }
        });
    }


    //Functions displays
    private void Update(int movie, String date) {
        //Backup Movie
        ListMovies movies = new ListMovies();
        JLabelTitle.setText(movies.getMovieName(movie));
        JLabelNumberTicket.setText(String.valueOf(numberOfTicket));
        JLabelNumberCTicket.setText(String.valueOf(numberOfChildrenTicket));
        JLabelDate.setText("Available film sessions on " + date + " :");

        //Session
        mySQL bdd = new mySQL();
        listSession = bdd.multipleSelect("SELECT session.startingTime FROM session JOIN movie ON session.idmovie = movie.idmovie WHERE movie.name='" + movies.getMovieName(movie) + "'");
        lisSessionP = bdd.multipleSelect("SELECT session.placeAmount FROM session JOIN movie ON session.idmovie = movie.idmovie WHERE movie.name='" + movies.getMovieName(movie) + "'");
        JRsession1.setText(listSession.get(0));
        JRsession2.setText(listSession.get(1));
        JRsession3.setText(listSession.get(2));
        JRsession4.setText(listSession.get(3));
        JRsession5.setText(listSession.get(4));

        JLabelPlace1.setText("Number of seats left: " + lisSessionP.get(0));
        JLabelPlace2.setText("Number of seats left: " + lisSessionP.get(1));
        JLabelPlace3.setText("Number of seats left: " + lisSessionP.get(2));
        JLabelPlace4.setText("Number of seats left: " + lisSessionP.get(3));
        JLabelPlace5.setText("Number of seats left: " + lisSessionP.get(4));
    }

    private String ChoiceSession() {
        if (JRsession1.isSelected()) return JRsession1.getText();
        if (JRsession2.isSelected()) return JRsession2.getText();
        ;
        if (JRsession3.isSelected()) return JRsession3.getText();
        ;
        if (JRsession4.isSelected()) return JRsession4.getText();
        ;
        if (JRsession5.isSelected()) return JRsession5.getText();
        ;
        return "";
    }

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

        JLabelMessage.setText("");

        NoSession();
    }

    private boolean Confirmation() {
        if (JRsession1.isSelected()) return true;
        else if (JRsession2.isSelected()) return true;
        else if (JRsession3.isSelected()) return true;
        else if (JRsession4.isSelected()) return true;
        else return JRsession5.isSelected();
    }

    //Functions prices
    private double priceCalcul() {
        return 7.50 * numberOfChildrenTicket + 11.50 * numberOfTicket;
    }

    private double priceCalcul(int id) {
        return 5.00 * numberOfChildrenTicket + 9.50 * numberOfTicket;
    }


}
