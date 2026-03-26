package frontiere;

import java.util.Iterator;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche;
		String vendeur;
		String quantite;
		String produit;
		infosMarche=controlAfficherMarche.donnerInfosMarche();
		if (infosMarche.length==0) {
			System.out.println("Le marché est vide, revenez plus tard.\n");
		}else {
			System.out.println(nomAcheteur+" vous trouverez au marché :");
			for (int i=0; i+2 < infosMarche.length&&infosMarche[i+2]!=null;i+=3) {
				vendeur=infosMarche[i];
				quantite=infosMarche[i+1];
				produit=infosMarche[i+2];
				System.out.println("- "+vendeur+" qui vend "+quantite+" "+produit+".");
			}
		}
	}
}
