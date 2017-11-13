package vue;

import java.sql.SQLException;

import controleur.Controleur;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import modele.Declaration;

public class PanneauAfficherItem extends Region
{
	Declaration declaration;
	
	TextField nomBateau = new TextField();
	TextField nomMarchandise = new TextField();
	TextField descriptionMarchandise = new TextField();
	TextField typeMarchandise = new TextField();
	TextField paysOrigineMatierePremiere = new TextField();
	TextField paysOrigineAssemblage = new TextField();
	
	
	public PanneauAfficherItem(Declaration declaration)
	{
		super();
		this.declaration = declaration;
		ConstruirePanneau();
	}

	private void ConstruirePanneau() 
	{
		GridPane grille = new GridPane();
		grille.setHgap(10);
		grille.setVgap(10);
		grille.setPadding(new Insets(25, 25, 25, 25));
		
		this.nomBateau.setText(declaration.getNomBateau());
		this.nomBateau.setEditable(false);
		this.nomMarchandise.setText(declaration.getNomMarchandise());
		this.nomMarchandise.setEditable(false);
		this.descriptionMarchandise.setText(declaration.getDescriptionMarchandise());
		this.descriptionMarchandise.setEditable(false);
		this.typeMarchandise.setText(declaration.getTypeMarchandise());
		this.typeMarchandise.setEditable(false);
		this.paysOrigineMatierePremiere.setText(declaration.getPaysOrigineMatierePremiere());
		this.paysOrigineMatierePremiere.setEditable(false);
		this.paysOrigineAssemblage.setText(declaration.getPaysOrigineAssemblage());
		this.paysOrigineAssemblage.setEditable(false);
		
		
		Label labelTitreAfficherItem = new Label("Afficher une marchandise");
		
		Button btnActionRetourEnArriere = new Button("Retour");
		btnActionRetourEnArriere.setOnAction(new EventHandler<ActionEvent>() 
		{
			@Override
			public void handle(ActionEvent action) 
			{
				try {
					Controleur.getInstance().actionRetourEnArriere();
				} catch (SQLException | ClassNotFoundException evenement) {
					// TODO Auto-generated catch block
					evenement.printStackTrace();
				}
			}
		});
		
		
		
		grille.add(labelTitreAfficherItem, 0, 0);
		
		addTextField(grille, nomBateau, "Nom : ", 0, 2);
		addTextField(grille, nomMarchandise, "Marchandise : ", 0, 4);
		addTextField(grille, descriptionMarchandise, "Description : ", 0, 6);
		addTextField(grille, typeMarchandise, "Type : ", 0, 8);
		addTextField(grille, paysOrigineMatierePremiere, "Pays d'origine MP : ", 0, 10);
		addTextField(grille, paysOrigineAssemblage, "Pays d'origine Assemblage : ", 0, 12);
		
		grille.add(btnActionRetourEnArriere, 0, 13);

		this.getChildren().add(grille);
	}
	
    private void addTextField(GridPane grille, TextField texte,String texteLabel, int colonne, int ligne){
        grille.add(new Label(texteLabel), colonne, ligne);
        grille.add(texte, colonne+1, ligne);
    }
}
