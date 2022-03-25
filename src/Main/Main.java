package Main;

import Back.login;

public class Main {

    public static void main(String[] args) {

        boolean validation;

        login test = new login("Antoine", "Alouche", "ke@mail.fr", "test");
        test.signUp();
        validation = test.signIn();

        System.out.println(validation);

    }
}