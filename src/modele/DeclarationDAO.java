package modele;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DeclarationDAO 
{
	private static DeclarationDAO instance;
	private Connection conn;
    static final String DB_URL = "jdbc:mysql://localhost/portmatane";
    static final String USER = "root";
    static final String PASS = "";

    public static DeclarationDAO getInstance(){
        if (instance == null) instance = new DeclarationDAO();
        return instance;
    }

    public DeclarationDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
