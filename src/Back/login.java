package Back;

import bdd.mySQL;

import java.util.Locale;

public class login {

    private final int admin = 0;
    private final int member = 1;
    private String mail;
    private String password;
    private String name;
    private String surname;
    private String birthdate;

    public login(String name, String surname, String bitrhdate, String mail, String password) {
        this.name = name.toUpperCase(Locale.ROOT);
        this.surname = surname;
        this.birthdate = bitrhdate;
        this.mail = mail;
        this.password = Hashing.doHashing(password);
    }

    public login(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }

    public void signUp() {
        bdd.mySQL bdd = new mySQL();
        bdd.insert1("INSERT INTO client (name,surname,birthdate,email,password,admin,member) VALUES('" + name + "'," + "'" + surname + "','" + birthdate + "','" + mail + "','" + password + "','" + admin + "','" + member + "'" + ")");
    }

    public boolean signIn() {
        bdd.mySQL bdd = new mySQL();
        String bddMail = bdd.select("SELECT email FROM client WHERE email = '" + mail + "'");
        String bddPassword = bdd.select("SELECT password FROM client WHERE password = '" + password + "'");

        return mail.equals(bddMail) && password.equals(bddPassword);

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        password = Hashing.doHashing(password);
    }
}
