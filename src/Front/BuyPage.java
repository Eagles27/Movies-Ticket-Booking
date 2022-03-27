package Front;

import Back.ClientInfo;
import Back.ListMovies;

import javax.swing.*;

public class BuyPage extends JFrame {
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JRadioButton radioButton4;
    private JRadioButton radioButton5;
    private JTextField TextFieldTicket;
    private JTextField TextFieldAge;
    private JButton ButtonNext;
    private JButton button1;
    private JPanel panelBuy;
    private JTextField TextFieldDate;
    private JButton buttonErase;
    private JLabel JLabelName;
    private JLabel JLabelMember;
    private JLabel JLabelError;

    private int numberOfTicket;
    private String date;
    private int age;


    public BuyPage() {
        JFrame window = new JFrame();
        window.setContentPane(panelBuy);
        window.setTitle("BUY");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Update();
        window.setVisible(true);
        button1.addActionListener(e -> {
            new WelcomePage();
            window.dispose();
        });

        radioButton1.addActionListener(e -> {
            radioButton2.setEnabled(false);
            radioButton3.setEnabled(false);
            radioButton4.setEnabled(false);
            radioButton5.setEnabled(false);
        });
        radioButton2.addActionListener(e -> {
            radioButton1.setEnabled(false);
            radioButton3.setEnabled(false);
            radioButton4.setEnabled(false);
            radioButton5.setEnabled(false);

        });
        radioButton3.addActionListener(e -> {
            radioButton2.setEnabled(false);
            radioButton1.setEnabled(false);
            radioButton4.setEnabled(false);
            radioButton5.setEnabled(false);
        });
        radioButton4.addActionListener(e -> {
            radioButton2.setEnabled(false);
            radioButton3.setEnabled(false);
            radioButton1.setEnabled(false);
            radioButton5.setEnabled(false);
        });
        radioButton5.addActionListener(e -> {
            radioButton2.setEnabled(false);
            radioButton3.setEnabled(false);
            radioButton4.setEnabled(false);
            radioButton1.setEnabled(false);
        });

        buttonErase.addActionListener(e -> {
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

            JLabelError.setText("");
            TextFieldDate.setText("");
            TextFieldAge.setText("");
            TextFieldTicket.setText("");
        });


        ButtonNext.addActionListener(e -> {
            boolean NULL = (TextFieldTicket.getText().isEmpty() || TextFieldDate.getText().isEmpty() || TextFieldAge.getText().isEmpty());

            if (ChoiceMovie() != -1 && !NULL) {
                numberOfTicket = Integer.parseInt(TextFieldTicket.getText());
                date = TextFieldDate.getText();
                age = Integer.parseInt(TextFieldAge.getText());
                window.dispose();
                new SelectDate(ChoiceMovie(),numberOfTicket,date,age);
            }
            else JLabelError.setText("Please fill all information");
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


        button1.addActionListener(e -> {
            new WelcomePage();
            window.dispose();
        });

        radioButton1.addActionListener(e -> {
            radioButton2.setEnabled(false);
            radioButton3.setEnabled(false);
            radioButton4.setEnabled(false);
            radioButton5.setEnabled(false);
        });
        radioButton2.addActionListener(e -> {
            radioButton1.setEnabled(false);
            radioButton3.setEnabled(false);
            radioButton4.setEnabled(false);
            radioButton5.setEnabled(false);

        });
        radioButton3.addActionListener(e -> {
            radioButton2.setEnabled(false);
            radioButton1.setEnabled(false);
            radioButton4.setEnabled(false);
            radioButton5.setEnabled(false);
        });
        radioButton4.addActionListener(e -> {
            radioButton2.setEnabled(false);
            radioButton3.setEnabled(false);
            radioButton1.setEnabled(false);
            radioButton5.setEnabled(false);
        });
        radioButton5.addActionListener(e -> {
            radioButton2.setEnabled(false);
            radioButton3.setEnabled(false);
            radioButton4.setEnabled(false);
            radioButton1.setEnabled(false);
        });

        buttonErase.addActionListener(e -> {
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

            JLabelError.setText("");
            TextFieldDate.setText("");
            TextFieldAge.setText("");
            TextFieldTicket.setText("");
        });


        ButtonNext.addActionListener(e -> {
            boolean NULL = (TextFieldAge.getText().isEmpty() || TextFieldDate.getText().isEmpty() || TextFieldTicket.getText().isEmpty());
            if (ChoiceMovie() != -1 && !NULL) {
                numberOfTicket = Integer.parseInt(TextFieldTicket.getText());
                date = TextFieldDate.getText();
                age = Integer.parseInt(TextFieldAge.getText());
                window.dispose();
                new SelectDate(ChoiceMovie(),numberOfTicket,date,age);
            }
            else JLabelError.setText("Please fill all information");
        });
    }

    public BuyPage(int Imovie,int InumberOfTicket, String Idate, int Iage) {
        JFrame window = new JFrame();
        window.setContentPane(panelBuy);
        window.setTitle("BUY");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Update();
        CheckBox(Imovie);
        TextFieldTicket.setText(String.valueOf(InumberOfTicket));
        TextFieldDate.setText(Idate);
        TextFieldAge.setText(String.valueOf(Iage));
        window.setVisible(true);

        button1.addActionListener(e -> {
            new WelcomePage();
            window.dispose();
        });

        radioButton1.addActionListener(e -> {
            radioButton2.setEnabled(false);
            radioButton3.setEnabled(false);
            radioButton4.setEnabled(false);
            radioButton5.setEnabled(false);
        });
        radioButton2.addActionListener(e -> {
            radioButton1.setEnabled(false);
            radioButton3.setEnabled(false);
            radioButton4.setEnabled(false);
            radioButton5.setEnabled(false);

        });
        radioButton3.addActionListener(e -> {
            radioButton2.setEnabled(false);
            radioButton1.setEnabled(false);
            radioButton4.setEnabled(false);
            radioButton5.setEnabled(false);
        });
        radioButton4.addActionListener(e -> {
            radioButton2.setEnabled(false);
            radioButton3.setEnabled(false);
            radioButton1.setEnabled(false);
            radioButton5.setEnabled(false);
        });
        radioButton5.addActionListener(e -> {
            radioButton2.setEnabled(false);
            radioButton3.setEnabled(false);
            radioButton4.setEnabled(false);
            radioButton1.setEnabled(false);
        });

        buttonErase.addActionListener(e -> {
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

            JLabelError.setText("");
            TextFieldDate.setText("");
            TextFieldAge.setText("");
            TextFieldTicket.setText("");
        });


        ButtonNext.addActionListener(e -> {
            boolean NULL = (TextFieldAge.getText().isEmpty() || TextFieldDate.getText().isEmpty() || TextFieldTicket.getText().isEmpty());
            if (ChoiceMovie() != -1 && !NULL) {
                numberOfTicket = Integer.parseInt(TextFieldTicket.getText());
                date = TextFieldDate.getText();
                age = Integer.parseInt(TextFieldAge.getText());
                window.dispose();
                new SelectDate(ChoiceMovie(),numberOfTicket,date,age);
            }
            else JLabelError.setText("Please fill all information");
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

    private void CheckBox(int movie) {
        if (movie == 0) {
            radioButton1.setSelected(true);
            radioButton2.setEnabled(false);
            radioButton3.setEnabled(false);
            radioButton4.setEnabled(false);
            radioButton5.setEnabled(false);
        }
        else if (movie == 1) {
            radioButton2.setSelected(true);
            radioButton1.setEnabled(false);
            radioButton3.setEnabled(false);
            radioButton4.setEnabled(false);
            radioButton5.setEnabled(false);
        }
        else if (movie == 2) {
            radioButton3.setSelected(true);
            radioButton2.setEnabled(false);
            radioButton1.setEnabled(false);
            radioButton4.setEnabled(false);
            radioButton5.setEnabled(false);
        }
        else if (movie == 3) {
            radioButton4.setSelected(true);
            radioButton2.setEnabled(false);
            radioButton1.setEnabled(false);
            radioButton3.setEnabled(false);
            radioButton5.setEnabled(false);
        }
        else if (movie == 4) {
            radioButton5.setSelected(true);
            radioButton2.setEnabled(false);
            radioButton3.setEnabled(false);
            radioButton1.setEnabled(false);
            radioButton4.setEnabled(false);
        }

    }
}
