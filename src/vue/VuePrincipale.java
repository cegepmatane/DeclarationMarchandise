package vue;

import java.sql.SQLException;

import controleur.Controleur;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import modele.Declaration;
import modele.DeclarationDAO;

public class VuePrincipale extends Application
{
	private PanneauHeader panneauHeader;
	private PanneauListe panneauListe;
	private PanneauModifierItem panneauModifierItem;
	private PanneauSupprimerItem panneauSupprimerItem;
	private BorderPane panneauPrincipale;
	private PanneauAjouterItem panneauAjouterItem;
	private PanneauAfficherItem panneauAfficherItem;
	
	
	
	@Override
	public void start(Stage scenePrincipale) throws SQLException, ClassNotFoundException
	{
		Controleur.getInstance().setVuePrincipale(this);
		
		panneauHeader = new PanneauHeader();
		panneauListe = new PanneauListe(DeclarationDAO.getInstance().afficherListeDeclaration());
		
		panneauPrincipale = new BorderPane();
		
		Scene scene = new Scene(panneauPrincipale, 400, 600);
		
		panneauHeader.setPrefSize(scene.getWidth(), 30);
		panneauHeader.setStyle("-fx-background-color: #40A497");
		panneauListe.setPrefSize(scene.getWidth(), (scene.getHeight() - 30));
		panneauListe.setStyle("-fx-background-color: #279385");
		
		panneauPrincipale.setPrefSize(scene.getWidth(), scene.getHeight());
		panneauPrincipale.setTop(panneauHeader);
		panneauPrincipale.setCenter(panneauListe);
		
		scenePrincipale.setScene(scene);
		scenePrincipale.show();
	}
	
	public void construirePanneauAfficherListe(Declaration declaration)
	{
		panneauAfficherItem = new PanneauAfficherItem(declaration);
		
		panneauPrincipale.setCenter(panneauAfficherItem);
	}
	
	public void construirePanneauModifierListe(Declaration declaration)
	{
		panneauModifierItem = new PanneauModifierItem(declaration);
		
		panneauPrincipale.setCenter(panneauModifierItem);
	}

	public void construirePanneauSupprimerItem(int id){
		panneauSupprimerItem = new PanneauSupprimerItem(id);

		panneauPrincipale.setCenter(panneauSupprimerItem);
	}

	public void construirePanneauListe(){
		panneauListe = new PanneauListe(DeclarationDAO.getInstance().afficherListeDeclaration());
		
		panneauPrincipale.setCenter(panneauListe);
	}

	public void construirePanneauAjouterItem() 
	{
		panneauAjouterItem = new PanneauAjouterItem();
		
		panneauPrincipale.setCenter(panneauAjouterItem);
	}
	
}

