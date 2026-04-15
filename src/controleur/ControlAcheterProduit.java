package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean isHabitant(String nom) {
		boolean habitant;
		habitant=controlVerifierIdentite.verifierIdentite(nom);
		return habitant;
	}
	public Gaulois[] appartientProduit(String produit) {
		return village.rechercherVendeursProduit(produit);
	}
	
	public int acheterProduit(String vendeur, int quantite) {
		Etal etalVendeur=null;
		int quantiteAcheter=0;
		etalVendeur=controlTrouverEtalVendeur.trouverEtalVendeur(vendeur);
		if(etalVendeur!=null) {
			quantiteAcheter=etalVendeur.acheterProduit(quantite);
		}
		return quantiteAcheter;
	}
}
