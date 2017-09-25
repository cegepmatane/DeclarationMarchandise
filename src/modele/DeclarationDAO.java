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
    
    public List<Declaration> afficherListeArmateur(){
        List<Declaration> listeDeclaration = new ArrayList<>();

        try{
            System.out.println("Creating statement...");
            Statement stmt = conn.createStatement();
            String sql = "SELECT idDeclaration, nom FROM declaration";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                
                String nom = rs.getString("nom");

                Declaration declaration = new Declaration();
                
                declaration.setIdDeclaration(rs.getInt("idDeclaration"));
                declaration.setNomBateau(rs.getString("nomBateau"));
                declaration.setNomMarchandise(rs.getString("nomMarchandise"));
                declaration.setDescriptionMarchandise(rs.getString("descriptionMarchandise"));
                declaration.setTypeMarchandise(rs.getString("typeMarchandise"));
                declaration.setPaysOrigineMatierePremiere(rs.getString("paysOrigineMatierePremiere"));
                declaration.setPaysOrigineAssemblage(rs.getString("paysOrigineAssemblage"));
                
                listeDeclaration.add(declaration);
            }

            stmt.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return listeDeclaration;
    }

}
