package frontiere;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;

//TODO pa d'entité dans une frontière

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public boolean acheterProduit(String nomAcheteur) {
		String produit;
		Gaulois[] gaulois;
		int numVendeur;
		int quantiteAcheter = 0;
		String nomVendeur;
		int quantiteVendeur;
		if (!controlAcheterProduit.isHabitant(nomAcheteur)) {
			System.out.println("Je suis désolé " + nomAcheteur
					+ " mais il faut être un habitant de notre village pour commercer ici.");
			return false;

		} else {
			produit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?");
			gaulois = controlAcheterProduit.appartientProduit(produit);
			if (gaulois == null) {
				System.out.println("Désolé, personne ne vend ce produit au marché.");
			} else {
				System.out.println("Chez quel commerçant voulez-vous acheter des fleurs ?");
				for (int i = 0; i < gaulois.length; i++) {
					System.out.println((i + 1) + " - " + gaulois[i].getNom() + "\n");
				}
				numVendeur = Clavier.entrerEntier("");
				nomVendeur = gaulois[numVendeur - 1].getNom();
				if (!controlAcheterProduit.isHabitant(nomVendeur)) {
					System.out.println("Je suis désolé " + nomVendeur
							+ " mais il faut être un habitant de notre village pour commercer ici.");
					return false;
				}
				System.out.println("Panoramix se déplace jusqu'à l'étal du vendeur Bonemine");
				System.out.println("Bonjour " + nomAcheteur);
				quantiteAcheter = Clavier.entrerEntier("Combien de fleurs voulez-vous acheter ?");
				quantiteVendeur = controlAcheterProduit.acheterProduit(quantiteAcheter, gaulois[numVendeur - 1]);
				if (quantiteVendeur == 0) {
					;
					System.out.println(nomAcheteur + " veut acheter " + quantiteAcheter + " " + produit
							+ ", malheureusement il n’y en a plus !");
					return false;
				} else if (quantiteVendeur < quantiteAcheter) {
					System.out.println(nomAcheteur + " veut acheter " + quantiteAcheter + " " + produit
							+ ", malheureusement " + nomVendeur + " n’en a plus que " + quantiteVendeur + ". "
							+ nomAcheteur + " achète tout le stock de " + nomVendeur + ".\n");
				} else {
					System.out.println(
							nomAcheteur + " achète " + quantiteAcheter + " " + produit + " à " + nomVendeur + "\n");

				}

			}
		}
		return true;
	}
}
