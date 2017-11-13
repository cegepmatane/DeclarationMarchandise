package modele;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DeclarationDAO 
{
	private static DeclarationDAO instance;
	private Connection connection;
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
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception evenement) {
            evenement.printStackTrace();
        }
    }
    
    public List<Declaration> afficherListeDeclaration(){
        List<Declaration> listeDeclaration = new ArrayList<>();

        try{
            System.out.println("Creating statement...");
            Statement requete = connection.createStatement();
            String sql = "SELECT * FROM declaration";
            ResultSet rs = requete.executeQuery(sql);

            while (rs.next()){
            	
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

            requete.close();
        }
        catch (Exception evenement){
            evenement.printStackTrace();
        }

        return listeDeclaration;
    }
    
    public void modifierDeclaration(Declaration declaration){
    	
   	 try{
         Statement requete = connection.createStatement();
         
         //String sqlAjouterHistorique = "INSERT INTO `historique`(`idDeclaration`, `nomBateau`, `nomMarchandise`, `descriptionMarchandise`, `typeMarchandise`, `paysOrigineMatierePremiere`, `paysOrigineAssemblage`) VALUES ( \"" + declaration.getIdDeclaration() + "\" , \"" + declaration.getNomBateau() + "\", \"" + declaration.getNomMarchandise() + "\", \"" + declaration.getDescriptionMarchandise() + "\", \"" + declaration.getTypeMarchandise() + "\", \"" + declaration.getPaysOrigineMatierePremiere() + "\", \"" + declaration.getPaysOrigineAssemblage() + "\")";
         String sqlModifierDeclaration = "UPDATE declaration SET nomBateau=\"" + declaration.getNomBateau() + "\",nomMarchandise=\"" + declaration.getNomMarchandise() + "\",descriptionMarchandise=\"" + declaration.getDescriptionMarchandise() + "\",typeMarchandise=\"" + declaration.getTypeMarchandise() +"\",paysOrigineMatierePremiere=\"" + declaration.getPaysOrigineMatierePremiere() + "\",paysOrigineAssemblage=\"" + declaration.getPaysOrigineAssemblage() + "\" WHERE idDeclaration=" + declaration.getIdDeclaration() + "";
         requete.executeUpdate(sqlModifierDeclaration); //updateQuery
         requete.close();
     }
     catch (Exception evenement){
         evenement.printStackTrace();
     }
        
    }
    
    public void ajoutHistorique(Declaration declaration){
    	 try{
             Statement requete = connection.createStatement();
             
             String sqlAjouterHistorique = "INSERT INTO `historique`(`idDeclaration`, `nomBateau`, `nomMarchandise`, `descriptionMarchandise`, `typeMarchandise`, `paysOrigineMatierePremiere`, `paysOrigineAssemblage`) VALUES ( \"" + declaration.getIdDeclaration() + "\" , \"" + declaration.getNomBateau() + "\", \"" + declaration.getNomMarchandise() + "\", \"" + declaration.getDescriptionMarchandise() + "\", \"" + declaration.getTypeMarchandise() + "\", \"" + declaration.getPaysOrigineMatierePremiere() + "\", \"" + declaration.getPaysOrigineAssemblage() + "\")";
             requete.executeUpdate(sqlAjouterHistorique); //updateQuery
             requete.close();
         }
         catch (Exception evenement){
             evenement.printStackTrace();
         }
    }

	public void supprimerDeclaration(int id) {
        try{
            Statement requete = connection.createStatement();

            String REQUETE_SUPPRIMER_DECLARATION = "DELETE FROM `declaration` WHERE `declaration`.`idDeclaration` = " + id;
            requete.executeUpdate(REQUETE_SUPPRIMER_DECLARATION);
            requete.close();
        }
        catch (Exception evenement){
            evenement.printStackTrace();
        }
	}

	public void ajouterDeclaration(Declaration declaration) throws SQLException {
        Statement requete = connection.createStatement();

        String sqlAjouterDeclaration = "INSERT INTO `declaration` (`idDeclaration`, `nomBateau`, `nomMarchandise`, `descriptionMarchandise`, `typeMarchandise`, `paysOrigineMatierePremiere`, `paysOrigineAssemblage`) VALUES (null, '" + declaration.getNomBateau() + "', '" + declaration.getNomMarchandise() + "', '" + declaration.getDescriptionMarchandise() + "', '" + declaration.getTypeMarchandise() + "', '" + declaration.getPaysOrigineMatierePremiere() + "', '" + declaration.getPaysOrigineAssemblage() + "');";
        requete.executeUpdate(sqlAjouterDeclaration);
        requete.close();
    }

}
