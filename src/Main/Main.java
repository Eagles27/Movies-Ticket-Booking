package Main;

import bdd.mySQL;

public class Main {

    public static void main(String[] args) {
	// write your code here

        mySQL bdd = new mySQL();
        String[] test;
        //bdd.insert1("Insert into client (name,surname) Values(\"Victoria\",\"Robert\")");
        test = bdd.multipleSelect("SELECT name FROM client");

        for(String i : test) System.out.println(i);

        //System.out.println(test[2]);

    }
}