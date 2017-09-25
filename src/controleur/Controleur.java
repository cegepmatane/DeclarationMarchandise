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

	public void actionRetourEnArriere() {
		// TODO Auto-generated method stub
		
	}

	public void actionAjouterItem() {
		// TODO Auto-generated method stub
		
	}

	public void actionModifierItem(Declaration declaration) {
		// TODO Auto-generated method stub
		
	}

	public void actionAfficherItem(Declaration declaration) {
		// TODO Auto-generated method stub
		
	}
}
