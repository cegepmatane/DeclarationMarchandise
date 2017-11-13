package vue;

import controleur.Controleur;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import modele.Declaration;
import modele.DeclarationDAO;


public class PanneauSupprimerItem extends Region {

	private Declaration declaration;

    public PanneauSupprimerItem(Declaration declaration) {
        super();
        construirePanneau();
        this.declaration = declaration;
    }

    private void construirePanneau()
    {
        GridPane grille = new GridPane();
        grille.setHgap(10);
        grille.setVgap(10);
        grille.setPadding(new Insets(25, 25, 25, 25));

        Label labelTitreSupprimerItem = new Label("Supprimer la marchandise selectionnee ?");

        Button boutonActionRetourEnArriere = new Button("Annuler");
        boutonActionRetourEnArriere.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                try {
                    Controleur.getInstance().actionRetourEnArriere();
                } catch (Exception evenement) {
                    evenement.printStackTrace();
                }
            }
        });

        Button boutonActionSupprimer = new Button("Supprimer");
        boutonActionSupprimer.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent action)
            {
                try {
                	DeclarationDAO.getInstance().ajoutHistorique(declaration);
                    DeclarationDAO.getInstance().supprimerDeclaration(declaration.getIdDeclaration());
                    Controleur.getInstance().actionRetourEnArriere();
                } catch (Exception evenement) {
                    evenement.printStackTrace();
                }
            }
        });

        grille.add(labelTitreSupprimerItem, 0, 0);
        grille.add(boutonActionRetourEnArriere, 0, 1);
        grille.add(boutonActionSupprimer, 2, 1);

        this.getChildren().add(grille);
    }
}