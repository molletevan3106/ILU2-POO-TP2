package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean nomVendeurConnu;
		boolean etalDisonible;
		nomVendeurConnu=controlPrendreEtal.verifierIdentite(nomVendeur);
		if (!nomVendeurConnu) {
			System.out.println("Je suis désolée "+nomVendeur+" mais il faut être un habitant de notre village pour commercer ici.\n");
		} else {
			System.out.println("Bonjour "+nomVendeur+" ,je vais regarder si je peux vous trouver un étal.\n");
			etalDisonible=controlPrendreEtal.resteEtals();
			if (!etalDisonible) {
				System.out.println("Désolée "+nomVendeur+" je n'ai plus d'étal qui ne soit pas déjà occupé. \n");
			} else {
				this.installerVendeur(nomVendeur);
			}
			
		}
	}

	private void installerVendeur(String nomVendeur) {
		int numeroEtal=-1;
		System.out.println("C'est parfait, il me reste un étal pour vous !\n");
		System.out.println("Il me faudrait quelques renseignements .");
		String produit = Clavier.entrerChaine("Quel produit souhaitez-vous vendre ?");
		int nbProduit=Clavier.entrerEntier("Combien souhaitez-vous en vendre ?");
		numeroEtal=controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if (numeroEtal!=-1) {
			numeroEtal++;
			System.out.println("Le vendeur "+nomVendeur+" s'est installé à l'étal n°"+numeroEtal+"\n");
		}
	}
}
