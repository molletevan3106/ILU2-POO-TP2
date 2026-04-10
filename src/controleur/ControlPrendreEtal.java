package controleur;

import personnages.Gaulois;
import villagegaulois.Village;

public class ControlPrendreEtal {
	private Village village;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlPrendreEtal(ControlVerifierIdentite controlVerifierIdentite,
			Village village) {
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.village = village;
	}

	public boolean resteEtals() {
		boolean etalDisponible;
		etalDisponible=village.rechercherEtalVide();
		return etalDisponible;
	}

	public int prendreEtal(String nomVendeur, String produit, int nbProduit) {
	    Gaulois gaulois = village.trouverHabitant(nomVendeur);

	    if (gaulois == null) {
	        return -1;
	    }

	    return village.installerVendeur(gaulois, produit, nbProduit);
	}
	public boolean verifierIdentite(String nomVendeur) {
		boolean nomVendeurConnu;
		nomVendeurConnu=controlVerifierIdentite.verifierIdentite(nomVendeur);
		return nomVendeurConnu;
	}
}
