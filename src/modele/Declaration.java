package modele;

public class Declaration 
{
	private int idDeclaration;
	private String nomBateau;
	private String nomMarchandise;
	private String descriptionMarchandise;
	private String typeMarchandise;
	private String paysOrigineMatierePremiere;
	private String paysOrigineAssemblage;
	
	public Declaration()
	{
		
	}

	public int getIdDeclaration() {
		return idDeclaration;
	}

	public void setIdDeclaration(int idDeclaration) {
		this.idDeclaration = idDeclaration;
	}

	public String getNomBateau() {
		return nomBateau;
	}

	public void setNomBateau(String nomBateau) {
		this.nomBateau = nomBateau;
	}

	public String getNomMarchandise() {
		return nomMarchandise;
	}

	public void setNomMarchandise(String nomMarchandise) {
		this.nomMarchandise = nomMarchandise;
	}

	public String getDescriptionMarchandise() {
		return descriptionMarchandise;
	}

	public void setDescriptionMarchandise(String descriptionMarchandise) {
		this.descriptionMarchandise = descriptionMarchandise;
	}

	public String getTypeMarchandise() {
		return typeMarchandise;
	}

	public void setTypeMarchandise(String typeMarchandise) {
		this.typeMarchandise = typeMarchandise;
	}

	public String getPaysOrigineMatierePremiere() {
		return paysOrigineMatierePremiere;
	}

	public void setPaysOrigineMatierePremiere(String paysOrigineMatierePremiere) {
		this.paysOrigineMatierePremiere = paysOrigineMatierePremiere;
	}

	public String getPaysOrigineAssemblage() {
		return paysOrigineAssemblage;
	}

	public void setPaysOrigineAssemblage(String paysOrigineAssemblage) {
		this.paysOrigineAssemblage = paysOrigineAssemblage;
	}
	
	
}
