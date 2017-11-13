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
import modele.DeclarationDAO;

public class PanneauModifierItem extends Region
{
Declaration declaration;
	
	TextField nomBateau = new TextField();
	TextField nomMarchandise = new TextField();
	TextField descriptionMarchandise = new TextField();
	TextField typeMarchandise = new TextField();
	TextField paysOrigineMatierePremiere = new TextField();
	TextField paysOrigineAssemblage = new TextField();
	
	
	public PanneauModifierItem(Declaration declaration)
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
		this.nomMarchandise.setText(declaration.getNomMarchandise());
		this.descriptionMarchandise.setText(declaration.getDescriptionMarchandise());
		this.typeMarchandise.setText(declaration.getTypeMarchandise());
		this.paysOrigineMatierePremiere.setText(declaration.getPaysOrigineMatierePremiere());
		this.paysOrigineAssemblage.setText(declaration.getPaysOrigineAssemblage());
		
		
		Label labelTitreAfficherItem = new Label("Afficher une marchandise");
		
		Button boutonActionRetourEnArriere = new Button("Retour");
		boutonActionRetourEnArriere.setOnAction(new EventHandler<ActionEvent>() 
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
		
		Button boutonActionSauvegarder = new Button("Sauvegarder");
		boutonActionSauvegarder.setOnAction(new EventHandler<ActionEvent>() 
		{
			@Override
			public void handle(ActionEvent action) 
			{
				DeclarationDAO.getInstance().ajoutHistorique(declaration);
				
				declaration.setNomBateau(nomBateau.getText());
				declaration.setNomMarchandise(nomMarchandise.getText());
				declaration.setDescriptionMarchandise(descriptionMarchandise.getText());
				declaration.setTypeMarchandise(typeMarchandise.getText());
				declaration.setPaysOrigineMatierePremiere(paysOrigineMatierePremiere.getText());
				declaration.setPaysOrigineAssemblage(paysOrigineAssemblage.getText());
				
				DeclarationDAO.getInstance().modifierDeclaration(declaration);
			}
		});
		
		
		
		grille.add(labelTitreAfficherItem, 0, 0);
		
		addTextField(grille, nomBateau, "Nom : ", 0, 2);
		addTextField(grille, nomMarchandise, "Marchandise : ", 0, 4);
		addTextField(grille, descriptionMarchandise, "Description : ", 0, 6);
		addTextField(grille, typeMarchandise, "Type : ", 0, 8);
		addTextField(grille, paysOrigineMatierePremiere, "Pays d'origine MP : ", 0, 10);
		addTextField(grille, paysOrigineAssemblage, "Pays d'origine Assemblage : ", 0, 12);
		
		grille.add(boutonActionRetourEnArriere, 0, 13);
		grille.add(boutonActionSauvegarder, 1, 13);

		this.getChildren().add(grille);
	}
	
    private void addTextField(GridPane grille, TextField textField,String texteLabel, int colonne, int ligne){
        grille.add(new Label(texteLabel), colonne, ligne);
        grille.add(textField, colonne+1, ligne);
    }
}
