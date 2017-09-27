package controleur;

import java.sql.SQLException;


import modele.Declaration;
import vue.VuePrincipale;

public class Controleur 
{
	
	protected static Controleur instance;
	private VuePrincipale vuePrincipale = null;
	
	public Controleur() {}
	
	public static Controleur getInstance() throws ClassNotFoundException, SQLException
	{
		if(instance == null) instance = new Controleur();
		return instance;
	}
	
	public void setVuePrincipale(VuePrincipale vuePrincipale)
	{
		this.vuePrincipale = vuePrincipale;
	}

	public void actionRetourEnArriere() throws SQLException 
	{
		this.vuePrincipale.construirePanneauListe();
	}

	public void actionAjouterItem() {
		// TODO Auto-generated method stub
		
	}

	public void actionModifierItem(Declaration declaration) {
		this.vuePrincipale.construirePanneauModifierListe(declaration);
		
	}
	

	public void actionAfficherItem(Declaration declaration) 
	{
		this.vuePrincipale.construirePanneauAfficherListe(declaration);
	}
}
