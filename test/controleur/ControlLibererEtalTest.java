package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

class ControlLibererEtalTest {

    private Village village;
    private ControlTrouverEtalVendeur controlTrouver;
    private ControlLibererEtal control;
    private Gaulois vendeur;

    @BeforeEach
    void setUp() {
        village = new Village("Village", 10, 2);

        Chef chef = new Chef("Abraracourcix", 10, village);
        village.setChef(chef);

        vendeur = new Gaulois("Ordralfabétix", 10);
        village.ajouterHabitant(vendeur);

        controlTrouver = new ControlTrouverEtalVendeur(village);
        control = new ControlLibererEtal(controlTrouver);
    }

	@Test
	void testControlLibererEtal() {
		assertNotNull(controlTrouver, "Constructeur ne renvoie pas null");
	}

	@Test
	void testIsVendeur() {
		assertFalse(control.isVendeur("Ordralfabétix"));
		village.installerVendeur(vendeur, "poisson", 10);
		assertTrue(control.isVendeur("Ordralfabétix"));
	}
    @Test
    void testLibererEtal() {
        village.installerVendeur(vendeur, "poisson", 10);

        String[] etat = control.libererEtal("Ordralfabétix");

        assertNotNull(etat);
        assertEquals(5, etat.length);
    }

	@Test
	void testLibererEtal_inexistant() {
		assertNull(control.libererEtal("César"));
	}
}
