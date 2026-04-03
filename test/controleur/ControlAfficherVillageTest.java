package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
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
		assertTrue(cav.donnerNomsVillageois().length==1);
		Gaulois bonemine=new Gaulois("Bonemine", 10);
		village.ajouterHabitant(bonemine);
		assertFalse(cav2.donnerNomsVillageois().length==2);
	}

	@Test
	void testDonnerNomVillage() {
		ControlAfficherVillage cav= new ControlAfficherVillage(village);
		assertTrue(cav.donnerNomVillage()==village.getNom());
	}

	@Test
	void testDonnerNbEtals() {
		ControlAfficherVillage cav= new ControlAfficherVillage(village);
		assertTrue(cav.donnerNbEtals()==nbetal);
	}

}
