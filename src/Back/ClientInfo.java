package Back;

import bdd.mySQL;

public class ClientInfo {

    private int clientID;
    private String name;
    private String surname;
    private String birthdate;
    private String admin;
    private String password;
    private String member;
    private String mail;

    public ClientInfo(String mailInput) {
        bdd.mySQL bdd = new mySQL();
        clientID = Integer.parseInt(bdd.select("SELECT idclient FROM client WHERE email ='" + mailInput + "'"));
        name = bdd.select("SELECT name FROM client WHERE idclient ='" + clientID + "'");
        surname = bdd.select("SELECT surname FROM client WHERE idclient ='" + clientID + "'");
        birthdate = bdd.select("SELECT birthdate FROM client WHERE idclient ='" + clientID + "'");
        admin = bdd.select("SELECT admin FROM client WHERE idclient ='" + clientID + "'");
        member = bdd.select("SELECT member FROM client WHERE idclient ='" + clientID + "'");
        password = bdd.select("SELECT password FROM client WHERE idclient ='" + clientID + "'");

    }

    public ClientInfo(int id) {
        clientID = id;
        bdd.mySQL bdd = new mySQL();
        mail = bdd.select("SELECT email FROM client WHERE idclient ='" + clientID + "'");
        name = bdd.select("SELECT name FROM client WHERE idclient ='" + clientID + "'");
        surname = bdd.select("SELECT surname FROM client WHERE idclient ='" + clientID + "'");
        birthdate = bdd.select("SELECT birthdate FROM client WHERE idclient ='" + clientID + "'");
        admin = bdd.select("SELECT admin FROM client WHERE idclient ='" + clientID + "'");
        member = bdd.select("SELECT member FROM client WHERE idclient ='" + clientID + "'");
        password = bdd.select("SELECT password FROM client WHERE idclient ='" + clientID + "'");

    }

    public int getClientID() {
        return clientID;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAdmin() {
        return admin;
    }

    public String getMember() {
        return member;
    }

    public String getPassword() {
        return password;
    }

    public String getMail() {
        return mail;
    }

    public boolean isAdmin() {
        return Boolean.parseBoolean(admin);
    }

    public boolean isMember() {
        return Boolean.parseBoolean(member);
    }
}
