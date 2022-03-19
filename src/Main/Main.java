package Main;

import Back.login;

public class Main {

    public static void main(String[] args) {

        boolean validation;

        login test = new login("Evga", "Kith", "ke@mail.fr", "root");
        validation = test.signIn();

        System.out.println(validation);

    }
}