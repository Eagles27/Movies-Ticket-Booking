package bdd;

import java.sql.*;
import java.util.ArrayList;

public class mySQL {

    public String select(String query) {
        // Variables
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/filmsproject";
            String user = "root";
            String password = "27Maxecq-";

            // create a connection to the database
            conn = DriverManager.getConnection(url, user, password);
            // more processing here
            // ...
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                // Instructions
                return rs.getString(1);

            }
            conn.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return "";
    }

    public ArrayList<String> multipleSelect(String query) {
        // Variables
        ArrayList<String> output = new ArrayList<>();

        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/filmsproject";
            String user = "root";
            String password = "27Maxecq-";

            // create a connection to the database
            conn = DriverManager.getConnection(url, user, password);
            // more processing here
            // ...
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                // Instructions
                output.add(rs.getString(1));
            }

            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return output;
    }

    public void insert1(String query) {
        // Variables
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/filmsproject";
            String user = "root";
            String password = "27Maxecq-";

            // create a connection to the database
            conn = DriverManager.getConnection(url, user, password);
            // more processing here
            // ...
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);

            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
