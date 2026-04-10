package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {
	private Village village;
    private ControlTrouverEtalVendeur control;
    private Gaulois vendeur;
    @BeforeEach
	void setUp() {
        village = new Village("Village", 10, 2);

        Chef chef = new Chef("Abraracourcix", 10, village);
        village.setChef(chef);

        vendeur = new Gaulois("Ordralfabétix", 10);
        village.ajouterHabitant(vendeur);

        control = new ControlTrouverEtalVendeur(village);
    }
	@Test
	void testControlTrouverEtalVendeur() {
		assertNotNull(control, "Constructeur ne renvoie pas null");
	}

	@Test
	void testTrouverEtalVendeur_ok() {
	    village.installerVendeur(vendeur, "poisson", 10);

	    Etal etal = control.trouverEtalVendeur("Ordralfabétix");

	    assertNotNull(etal);
	}
	
	@Test
	void testTrouverEtalVendeur_pasDEtal() {
	    Etal etal = control.trouverEtalVendeur("Ordralfabétix");

	    assertNull(etal);
	}

}
