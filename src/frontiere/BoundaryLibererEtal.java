package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		boolean vendeurReconnu=false;
		String[] donneesEtal=new String[5];
		String etalOccupe;
		String produit;
		String quantiteInitial;
		String quantiteVendu;
		vendeurReconnu=controlLibererEtal.isVendeur(nomVendeur);
		if (!vendeurReconnu) {
			System.out.println("Mais vous n'etes pas inscrit sur notre marché aujourd'hui !");
		} else {
			donneesEtal=controlLibererEtal.libererEtal(nomVendeur);
			etalOccupe=donneesEtal[0];
			if (etalOccupe!=null&&etalOccupe.equals("true")) {
				produit=donneesEtal[2];
				quantiteInitial=donneesEtal[3];
				quantiteVendu=donneesEtal[4];
				System.out.println("Vous avez vendu "+ quantiteVendu+" sur "+quantiteInitial+" "+produit+".\n");
				System.out.println("Au revoir "+ nomVendeur+" passez une bonne journée .\n");
			}
		}
	}

}
