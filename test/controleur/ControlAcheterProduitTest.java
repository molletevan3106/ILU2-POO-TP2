package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

class ControlAcheterProduitTest {

    private Village village;
    private ControlAcheterProduit control;
    private ControlVerifierIdentite verifier;
    private ControlTrouverEtalVendeur trouver;
    private Gaulois vendeur;

    @BeforeEach
    void setUp() {
        village = new Village("Village", 10, 2);

        Chef chef = new Chef("Abraracourcix", 10, village);
        village.setChef(chef);

        vendeur = new Gaulois("Ordralfabétix", 10);
        village.ajouterHabitant(vendeur);

        verifier = new ControlVerifierIdentite(village);
        trouver = new ControlTrouverEtalVendeur(village);

        control = new ControlAcheterProduit(verifier, trouver, village);
    }

    @Test
    void testControlAcheterProduit() {
        assertNotNull(control);
    }

    @Test
    void testIsHabitant_true() {
        assertTrue(control.isHabitant("Ordralfabétix"));
    }

    @Test
    void testIsHabitant_false() {
        assertFalse(control.isHabitant("César"));
    }

    @Test
    void testAppartientProduit() {
        village.installerVendeur(vendeur, "poisson", 10);

        Gaulois[] res = control.appartientProduit("poisson");

        assertNotNull(res);
        assertEquals(1, res.length);
    }

    @Test
    void testAppartientProduit_aucun() {
        Gaulois[] res = control.appartientProduit("pain");

        assertNull(res);
    }

    @Test
    void testAcheterProduit_ok() {
        village.installerVendeur(vendeur, "poisson", 10);

        Etal etal = village.rechercherEtal(vendeur);

        int qte = control.acheterProduit(5, vendeur);

        assertTrue(qte >= 0);
        assertNotNull(etal);
    }

    @Test
    void testAcheterProduit_pasDEtal() {
        int qte = control.acheterProduit(5, vendeur);

        assertEquals(0, qte);
    }
}
