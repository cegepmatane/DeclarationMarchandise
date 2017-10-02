package vue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

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
            public void handle(ActionEvent event) {

                try {
                    Controleur.getInstance().actionRetourEnArriere();
                } catch (ClassNotFoundException | SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        });

        Button BtnActionSauvegardeeModification = new Button("Sauvegarde");
        BtnActionSauvegardeeModification.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
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
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        grid.add(labelTitreAjouterItem, 0, 0);
        grid.add(btnActionRetourEnArriere, 0, 7);
        grid.add(BtnActionSauvegardeeModification, 2, 7);

        this.getChildren().add(grid);
        grid.add(champNomBateau,0,1);
        grid.add(champNomMarchandise,0,2);
        grid.add(champDescriptionMarchandise,0,3);
        grid.add(champTypeMarchandise,0,4);
        grid.add(champPaysOrigineMatierePremiere,0,5);
        grid.add(champPaysOrigineAssemblage,0,6);
    }
}
