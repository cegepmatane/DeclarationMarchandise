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
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
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
			public void handle(ActionEvent event) 
			{
				try {
					Controleur.getInstance().actionRetourEnArriere();
				} catch (SQLException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
		
		grid.add(labelTitreAfficherItem, 0, 0);
		
		addTextField(grid, nomBateau, "Nom : ", 0, 2);
		addTextField(grid, nomMarchandise, "Marchandise : ", 0, 4);
		addTextField(grid, descriptionMarchandise, "Description : ", 0, 6);
		addTextField(grid, typeMarchandise, "Type : ", 0, 8);
		addTextField(grid, paysOrigineMatierePremiere, "Pays d'origine MP : ", 0, 10);
		addTextField(grid, paysOrigineAssemblage, "Pays d'origine Assemblage : ", 0, 12);
		
		grid.add(btnActionRetourEnArriere, 0, 13);

		this.getChildren().add(grid);
	}
	
    private void addTextField(GridPane grid, TextField textField,String texteLabel, int colonne, int ligne){
        grid.add(new Label(texteLabel), colonne, ligne);
        grid.add(textField, colonne+1, ligne);
    }
}
