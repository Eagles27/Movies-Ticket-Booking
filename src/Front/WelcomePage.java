package Front;

import Back.ClientInfo;
import Back.Hashing;
import Back.ListMovies;
import Back.login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePage extends JFrame {
    private JTextField mailField;
    private JPasswordField passwordField;
    private JButton ButtonNew;
    private JButton ButtonLogin;
    private JPanel panelLogin;
    private JButton buttonBuy;
    private JLabel TitleF1;
    private JLabel ReleaseF1;
    private JLabel ReleaseF2;
    private JLabel ReleaseF3;
    private JLabel Title2;
    private JLabel Title3;
    private JLabel JLabelError;
    private JLabel JLabelIm1;
    private JLabel JLabelIm2;
    private JLabel JLabelIm3;
    private JLabel JLabelGenre1;
    private JLabel JLabelDuration1;
    private JLabel JLabelGenre2;
    private JLabel JLabelDuration2;
    private JLabel JLabelGenre3;
    private JLabel JLabelDuration3;


    public WelcomePage() {
        JFrame frame = new JFrame();
        frame.setContentPane(panelLogin);
        frame.setTitle("Welcome");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        update();

        frame.setVisible(true);


        buttonBuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BuyPage();
                frame.dispose();
            }
        });
        ButtonNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NewCustomerPage();
                frame.dispose();
            }
        });
        ButtonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login user = new login(mailField.getText(), passwordField.getText());
                ClientInfo root = new ClientInfo(mailField.getText());

                boolean ISadmin = root.isAdmin() && ((Hashing.doHashing(passwordField.getText())).equals(root.getPassword()));

                if (ISadmin) {
                    System.out.println("Admin");
                } else if (user.signIn()) {
                    new BuyPage(mailField.getText());
                    frame.dispose();
                } else JLabelError.setText("Wrong Information");
            }
        });
    }

    private void update() {
        ListMovies list = new ListMovies();

        TitleF1.setText(list.getListMoviesName().get(0));
        JLabelGenre1.setText(list.getListMoviesGenre().get(0));
        ReleaseF1.setText(list.getListMoviesReleased().get(0));
        JLabelDuration1.setText(list.getListMoviesDuration().get(0)+"min");
        JLabelIm1.setIcon(new ImageIcon(list.getListMoviesImages().get(0)));


        Title2.setText(list.getListMoviesName().get(1));
        JLabelGenre2.setText(list.getListMoviesGenre().get(1));
        ReleaseF2.setText(list.getListMoviesReleased().get(1));
        JLabelDuration2.setText(list.getListMoviesDuration().get(1)+"min");
        JLabelIm2.setIcon(new ImageIcon(list.getListMoviesImages().get(1)));


        Title3.setText(list.getListMoviesName().get(2));
        JLabelGenre3.setText(list.getListMoviesGenre().get(2));
        ReleaseF3.setText(list.getListMoviesReleased().get(2));
        JLabelDuration3.setText(list.getListMoviesDuration().get(2)+"min");
        JLabelIm3.setIcon(new ImageIcon(list.getListMoviesImages().get(2)));

    }
}
