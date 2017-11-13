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

public class PanneauAjouterItem extends Region {

    private TextField champNomBateau;
    private TextField champNomMarchandise;
    private TextField champDescriptionMarchandise;
    private TextField champTypeMarchandise;
    private TextField champPaysOrigineMatierePremiere;
    private TextField champPaysOrigineAssemblage;

    public PanneauAjouterItem() {
        super();

        ConstruirePanneau();
    }

    private void ConstruirePanneau() {
        GridPane grille = new GridPane();
        grille.setHgap(10);
        grille.setVgap(10);
        grille.setPadding(new Insets(25, 25, 25, 25));

        Label labelTitreAjouterItem = new Label("Ajouter");

        champNomBateau = new TextField();
        champNomMarchandise = new TextField();
        champDescriptionMarchandise = new TextField();
        champTypeMarchandise = new TextField();
        champPaysOrigineMatierePremiere = new TextField();
        champPaysOrigineAssemblage = new TextField();

        Button btnActionRetourEnArriere = new Button("Retour");
        btnActionRetourEnArriere.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent action) {

                try {
                    Controleur.getInstance().actionRetourEnArriere();
                } catch (ClassNotFoundException | SQLException evenement) {
                    // TODO Auto-generated catch block
                    evenement.printStackTrace();
                }

            }
        });

        Button BtnActionSauvegardeeModification = new Button("Sauvegarde");
        BtnActionSauvegardeeModification.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent action) {
                String nomBateau = champNomBateau.getText();
                String nomMarchandise = champNomMarchandise.getText();
                String descriptionMarchandise = champDescriptionMarchandise.getText();
                String typeMarchandise = champTypeMarchandise.getText();
                String paysOrigineMatierePremiere = champPaysOrigineMatierePremiere.getText();
                String paysOrigineAssemblage = champPaysOrigineAssemblage.getText();
                Declaration declaration = new Declaration();
                declaration.setNomBateau(nomBateau);
                declaration.setNomMarchandise(nomMarchandise);
                declaration.setDescriptionMarchandise(descriptionMarchandise);
                declaration.setTypeMarchandise(typeMarchandise);
                declaration.setPaysOrigineMatierePremiere(paysOrigineMatierePremiere);
                declaration.setPaysOrigineAssemblage(paysOrigineAssemblage);
                try {
                    DeclarationDAO.getInstance().ajouterDeclaration(declaration);
                    Controleur.getInstance().actionRetourEnArriere();
                } catch (ClassNotFoundException | SQLException evenement) {
                    evenement.printStackTrace();
                }
            }
        });

        grille.add(labelTitreAjouterItem, 0, 0);
        grille.add(btnActionRetourEnArriere, 0, 7);
        grille.add(BtnActionSauvegardeeModification, 2, 7);

        this.getChildren().add(grille);
        addTextField(grille, champNomBateau,"Nom du bateau : " ,0,1);
        addTextField(grille, champNomMarchandise,"Nom de la marchandise : " ,0,2);
        addTextField(grille, champDescriptionMarchandise,"Description de la marchandise : ",0,3);
        addTextField(grille, champTypeMarchandise,"Type de marchandise : ",0,4);
        addTextField(grille, champPaysOrigineMatierePremiere,"Pays origine de la matière première : ",0,5);
        addTextField(grille, champPaysOrigineAssemblage,"Pays origine de l'assemblage : ",0,6);
    }

    private void addTextField(GridPane grille, TextField texte,String texteLabel, int colonne, int ligne){
        grille.add(new Label(texteLabel), colonne, ligne);
        grille.add(texte, colonne+1, ligne);
    }
}
