package Main;

import Back.login;
import Front.BuyPage;
import Front.WelcomePage;
import bdd.mySQL;

public class Main {

    public static void main(String[] args) {

        boolean validation;
        mySQL bdd = new mySQL();

        validation = bdd.Exist("SELECT * from client where email = 'x'");

        System.out.println(validation);

        new WelcomePage();



    }
}