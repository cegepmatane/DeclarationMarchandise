package vue;


import java.sql.SQLException;
import java.util.List;

import controleur.Controleur;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import modele.Declaration;

public class PanneauListe extends Region
{
	private ListView<PanneauItemListe> panneauListeItem;
	private List<Declaration> liste;
	
	public PanneauListe(List<Declaration> list)
	{
		super();
		this.liste = liste;
		ConstruirePanneau();
	}

	private void ConstruirePanneau() 
	{
		VBox boite = new VBox();
		boite.setPadding(new Insets(10));
		boite.setPrefSize(400, (600-30));
		
		Button boutonActionAjouterItem = new Button("Ajouter");
		boutonActionAjouterItem.setPrefSize(200, 15);
		boutonActionAjouterItem.setOnAction(new EventHandler<ActionEvent>() 
		{
			@Override
			public void handle(ActionEvent action) 
			{
				try {
					Controleur.getInstance().actionAjouterItem();
				} catch (ClassNotFoundException | SQLException evenement) {
					// TODO Auto-generated catch block
					evenement.printStackTrace();
				}
			}
		});
		boite.getChildren().add(boutonActionAjouterItem);
		
		panneauListeItem = new ListView<PanneauItemListe>();
		panneauListeItem.setPrefSize(400, 600 - 30);
		construireVueListeItem(liste);
		
		
		boite.getChildren().add(panneauListeItem);
		this.getChildren().add(boite);
	}
	
	private void construireVueListeItem(List<Declaration> liste)
	{
		
		for(Declaration declaration : liste)
		{
			panneauListeItem.getItems().add(new PanneauItemListe(declaration));
		}

	}
	
	
}
