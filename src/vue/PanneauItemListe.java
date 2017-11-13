package vue;

import java.sql.SQLException;

import controleur.Controleur;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import modele.Declaration;

public class PanneauItemListe extends Region
{
	private HBox declarationBoite;
	private String nomItem;
	
	public PanneauItemListe(Declaration declaration)
	{
		super();
		this.nomItem = declaration.getNomBateau();
		
		ConstruirePanneau(declaration);
	}

	private void ConstruirePanneau(Declaration declaration) 
	{
		declarationBoite = new HBox();
		
		Label label = new Label(this.nomItem);
		declarationBoite.getChildren().add(label);
		
		Button btnActionAfficher = new Button("Afficher");
		btnActionAfficher.setOnAction(new EventHandler<ActionEvent>() 
		{
			@Override
			public void handle(ActionEvent event) 
			{
				try {
					Controleur.getInstance().actionAfficherItem(declaration);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		declarationBoite.getChildren().add(btnActionAfficher);
		
		Button btnActionModifier = new Button("Modifier");
		btnActionModifier.setOnAction(new EventHandler<ActionEvent>() 
		{
			@Override
			public void handle(ActionEvent event) 
			{
				try {
					Controleur.getInstance().actionModifierItem(declaration);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		declarationBoite.getChildren().add(btnActionModifier);

		Button btnActionSupprimer = new Button("Supprimer");
		btnActionSupprimer.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				try{
					Controleur.getInstance().actionSupprimerItem(declaration);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		declarationBoite.getChildren().add(btnActionSupprimer);
		
		this.getChildren().add(declarationBoite);
	}

}
