package Front;

import Back.ClientInfo;
import Back.ListMovies;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuyPage extends JFrame {
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JRadioButton radioButton4;
    private JRadioButton radioButton5;
    private JTextField testTextField;
    private JTextField textField2;
    private JButton ButtonNext;
    private JButton button1;
    private JPanel panelBuy;
    private JTextField textField3;
    private JButton buttonErase;
    private JLabel JLabelName;
    private JLabel JLabelMember;


    public BuyPage() {
        JFrame window = new JFrame();
        window.setContentPane(panelBuy);
        window.setTitle("BUY");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Update();
        window.setVisible(true);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new WelcomePage();
                window.dispose();
            }
        });

        radioButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                radioButton2.setEnabled(false);
                radioButton3.setEnabled(false);
                radioButton4.setEnabled(false);
                radioButton5.setEnabled(false);
            }
        });
        radioButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                radioButton1.setEnabled(false);
                radioButton3.setEnabled(false);
                radioButton4.setEnabled(false);
                radioButton5.setEnabled(false);

            }
        });
        radioButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                radioButton2.setEnabled(false);
                radioButton1.setEnabled(false);
                radioButton4.setEnabled(false);
                radioButton5.setEnabled(false);
            }
        });
        radioButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                radioButton2.setEnabled(false);
                radioButton3.setEnabled(false);
                radioButton1.setEnabled(false);
                radioButton5.setEnabled(false);
            }
        });
        radioButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                radioButton2.setEnabled(false);
                radioButton3.setEnabled(false);
                radioButton4.setEnabled(false);
                radioButton1.setEnabled(false);
            }
        });

        buttonErase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                radioButton1.setSelected(false);
                radioButton2.setSelected(false);
                radioButton3.setSelected(false);
                radioButton4.setSelected(false);
                radioButton5.setSelected(false);

                radioButton1.setEnabled(true);
                radioButton2.setEnabled(true);
                radioButton3.setEnabled(true);
                radioButton4.setEnabled(true);
                radioButton5.setEnabled(true);
            }
        });


        ButtonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ChoiceMovie() != -1) {
                    window.dispose();
                    new SelectDate();
                }
            }
        });
    }

    public BuyPage(String inputEmail) {
        JFrame window = new JFrame();
        window.setContentPane(panelBuy);
        window.setTitle("BUY");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);

        ClientInfo clientInfo = new ClientInfo(inputEmail);
        JLabelMember.setText(clientInfo.getMember());
        JLabelName.setText(clientInfo.getSurname() + " " + clientInfo.getName());

        Update();
        window.setVisible(true);


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new WelcomePage();
                window.dispose();
            }
        });

        radioButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                radioButton2.setEnabled(false);
                radioButton3.setEnabled(false);
                radioButton4.setEnabled(false);
                radioButton5.setEnabled(false);
            }
        });
        radioButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                radioButton1.setEnabled(false);
                radioButton3.setEnabled(false);
                radioButton4.setEnabled(false);
                radioButton5.setEnabled(false);

            }
        });
        radioButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                radioButton2.setEnabled(false);
                radioButton1.setEnabled(false);
                radioButton4.setEnabled(false);
                radioButton5.setEnabled(false);
            }
        });
        radioButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                radioButton2.setEnabled(false);
                radioButton3.setEnabled(false);
                radioButton1.setEnabled(false);
                radioButton5.setEnabled(false);
            }
        });
        radioButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                radioButton2.setEnabled(false);
                radioButton3.setEnabled(false);
                radioButton4.setEnabled(false);
                radioButton1.setEnabled(false);
            }
        });

        buttonErase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                radioButton1.setSelected(false);
                radioButton2.setSelected(false);
                radioButton3.setSelected(false);
                radioButton4.setSelected(false);
                radioButton5.setSelected(false);

                radioButton1.setEnabled(true);
                radioButton2.setEnabled(true);
                radioButton3.setEnabled(true);
                radioButton4.setEnabled(true);
                radioButton5.setEnabled(true);
            }
        });


        ButtonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ChoiceMovie() != -1) {
                    window.dispose();
                    new SelectDate();
                }
            }
        });
    }

    private void Update() {
        ListMovies listMovies = new ListMovies();
        radioButton1.setText(listMovies.getListMoviesName().get(0));
        radioButton2.setText(listMovies.getListMoviesName().get(1));
        radioButton3.setText(listMovies.getListMoviesName().get(2));
        radioButton4.setText(listMovies.getListMoviesName().get(3));
        radioButton5.setText(listMovies.getListMoviesName().get(4));

    }

    private int ChoiceMovie() {
        if (radioButton1.isSelected()) return 0;
        else if (radioButton2.isSelected()) return 1;
        else if (radioButton3.isSelected()) return 2;
        else if (radioButton4.isSelected()) return 3;
        else if (radioButton5.isSelected()) return 4;

        else return -1;
    }
}
