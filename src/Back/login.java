package Back;

import bdd.mySQL;

public class login {

    private String mail;
    private String password;
    private String name;
    private String surname;

    public login(String name, String surname, String mail, String password) {
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.password = Hashing.doHashing(password);
    }

    public login(String mail, String password){
        this.mail = mail;
        this.password = password;
    }

    public void signUp() {
        bdd.mySQL bdd = new mySQL();
        bdd.insert1("INSERT INTO client (name,surname,email,password) VALUES('" + name + "'," + "'" + surname + "','" + mail + "','" + password + "'" + ")");
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
