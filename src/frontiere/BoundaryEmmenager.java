package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println("Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					StringBuilder question2=new StringBuilder();
					int force=-1;
					question2.append("Bienvenue villageois ");
					question2.append(nomVisiteur);
					question2.append("\n");
					question2.append("Quelle est votre force ?");
					question2.append("\n");
					force =Clavier.entrerEntier(question2.toString());
					controlEmmenager.ajouterGaulois(nomVisiteur, force);
					break;

				default:
					System.out.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		int forceDruide=-1;
		int effetPotionMax=-2;
		int effetPotionMin=-1;
		System.out.println("Bienvenue druide "+nomVisiteur+"\n");
		forceDruide=Clavier.entrerEntier("Quelle est votre force ?");
		do{
			effetPotionMin=Clavier.entrerEntier("Quelle est la force de potion la plus faible que vous produisez ?");
			effetPotionMax=Clavier.entrerEntier("Quelle est la force de potion la plus forte que vous produisez ?");
			if (effetPotionMax<effetPotionMin) {
				System.out.println("Attention Druide, vous vous etes trompe entre le minimum et le maximum \n");
			}
			
		}while (effetPotionMax<effetPotionMin);
		
		controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, effetPotionMin, effetPotionMax);
		
	}
}
