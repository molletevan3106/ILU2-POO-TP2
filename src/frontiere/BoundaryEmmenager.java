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
		StringBuilder question=new StringBuilder();
		StringBuilder question1=new StringBuilder();
		StringBuilder question2=new StringBuilder();
		int effetPotionMax=-2;
		int effetPotionMin=-1;
		question.append("Bienvenue druide ");
		question.append(nomVisiteur);
		question.append("\n");
		question.append("Quelle est votre force ?");
		question.append("\n");
		forceDruide=Clavier.entrerEntier(question.toString());
		while (effetPotionMax<effetPotionMin) {
			question1.append("Quelle est la force de potion la plus faible que vous produisez ?");
			effetPotionMin=Clavier.entrerEntier(question1.toString());
			question1.append("\n");
			question2.append("Quelle est la force de potion la plus forte que vous produisez ?");
			effetPotionMax=Clavier.entrerEntier(question2.toString());
			question2.append("\n");
			if (effetPotionMax<effetPotionMin) {
				question1.append("Attention Druide, vous vous etes trompe entre le minimum et le maximum");
				question1.append("\n");
			}
		}
		controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, effetPotionMin, effetPotionMax);
		
	}
}
