package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	private Village village;
	private Village village2;
	private Chef abraracourcix;
	private int nbetal;
	@BeforeEach
	void setUp() {
		System.out.println("Initialisation ...");
		nbetal=5;
		village= new Village("le village des irréductibles",10,nbetal);
		village2= new Village("le village des irréductibles",1,nbetal);
		abraracourcix=new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		
	}

	@Test
	void testControlAfficherVillage() {
		ControlAfficherVillage cav= new ControlAfficherVillage(village);
		assertNotNull(cav, "Constructeur ne renvoie pas null");
	}

	@Test
	void testDonnerNomsVillageois() {
		ControlAfficherVillage cav= new ControlAfficherVillage(village);
		ControlAfficherVillage cav2= new ControlAfficherVillage(village2);
		assertEquals(1, cav.donnerNomsVillageois().length);
		Druide panoramix=new Druide("Panoramix", 10,1,5);
		Gaulois bonemine=new Gaulois("Bonemine",1);
		village.ajouterHabitant(panoramix);
		village.ajouterHabitant(bonemine);
		assertEquals(3, cav.donnerNomsVillageois().length);
	}

	@Test
	void testDonnerNomVillage() {
		ControlAfficherVillage cav= new ControlAfficherVillage(village);
		assertEquals(village.getNom(), cav.donnerNomVillage());
	}

	@Test
	void testDonnerNbEtals() {
		ControlAfficherVillage cav= new ControlAfficherVillage(village);
		 assertEquals(nbetal, cav.donnerNbEtals());
		 Village villageZero = new Village("vide", 10, 0);
		  ControlAfficherVillage cav1 = new ControlAfficherVillage(villageZero);

		    assertEquals(0, cav1.donnerNbEtals());
	}

}
