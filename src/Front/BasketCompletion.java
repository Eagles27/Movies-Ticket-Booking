package Front;

import bdd.mySQL;

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
    private JLabel JLabelMessage;

    private String Title;
    private int NumberTicketA, NumberTicketC;
    private String Seance;


    public BasketCompletion(String Title, String Date, String Seance, int NumberTicketA, int NumberTicketC, Double Price, int movie, int[] index) {
        JFrame window = new JFrame();
        window.setContentPane(panel1);
        window.setTitle("Basket");
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        this.Title = Title;
        this.NumberTicketA = NumberTicketA;
        this.NumberTicketC = NumberTicketC;
        this.Seance = Seance;

        Update(Title, Date, Seance, NumberTicketA, NumberTicketC, Price);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SelectDate(movie, NumberTicketA, Date, NumberTicketC, index);
                window.dispose();

            }
        });
        GOButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!(textField1.getText().isEmpty() || textField2.getText().isEmpty())) {
                    new PaymentCompleted(window);
                    PlaceConfirmed();
                } else JLabelMessage.setText("Please fill all information");

            }
        });
    }

    public BasketCompletion(String Title, String Date, String Seance, int NumberTicketA, int NumberTicketC, Double Price, int movie, int[] index, int id) {
        JFrame window = new JFrame();
        window.setContentPane(panel1);
        window.setTitle("Basket");
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        this.Title = Title;
        this.NumberTicketA = NumberTicketA;
        this.NumberTicketC = NumberTicketC;
        this.Seance = Seance;

        Update(Title, Date, Seance, NumberTicketA, NumberTicketC, Price);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SelectDate(movie, NumberTicketA, Date, NumberTicketC, index, id);
                window.dispose();

            }
        });

        GOButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!(textField1.getText().isEmpty() || textField2.getText().isEmpty())) {
                    new PaymentCompleted(window);
                    PlaceConfirmed();
                } else JLabelMessage.setText("Please fill all information");

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

    private void PlaceConfirmed() {
        bdd.mySQL bdd = new mySQL();

        int Ticket = NumberTicketA + NumberTicketC;
        int capacity = Integer.parseInt(bdd.select("SELECT session.placeAmount FROM session, movie WHERE session.idmovie = movie.idmovie AND session.startingTime = '" + Seance + "'AND movie.name = '" + Title + "'"));

        bdd.insert1("UPDATE session,movie SET session.placeAmount = '" + (capacity - Ticket) + "'WHERE session.idmovie = movie.idmovie AND session.startingTime = '" + Seance + "'AND movie.name = '" + Title + "'");

    }


}
