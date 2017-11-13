package vue;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;

public class PanneauHeader extends Region
{
	public PanneauHeader()
	{
		super();
		
		ConstruirePanneau();
	}

	private void ConstruirePanneau() 
	{
		HBox boite = new HBox();
		
		Label labelNomProgramme = new Label();
		labelNomProgramme.setId("labelNomProgramme");
		labelNomProgramme.setText("Liste des declarations");
		boite.getChildren().add(labelNomProgramme);
		
		//TODO: add Logo;
		
		this.getChildren().add(boite);
	}
}
