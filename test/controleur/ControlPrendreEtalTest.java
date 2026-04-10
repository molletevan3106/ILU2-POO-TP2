package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {

    private Village village;
    private ControlPrendreEtal control;
    private ControlVerifierIdentite verifier;
    private Gaulois vendeur;

    @BeforeEach
    void setUp() {
        village = new Village("Village", 10, 2);

        Chef chef = new Chef("Abraracourcix", 10, village);
        village.setChef(chef);

        vendeur = new Gaulois("Ordralfabétix", 10);
        village.ajouterHabitant(vendeur);

        verifier = new ControlVerifierIdentite(village);

        control = new ControlPrendreEtal(verifier, village);
    }

    @Test
    void testControlPrendreEtal() {
        assertNotNull(control);
    }

    @Test
    void testResteEtals_true() {
        assertTrue(control.resteEtals());
    }

    @Test
    void testPrendreEtal_ok() {
        int etal = control.prendreEtal("Ordralfabétix", "poisson", 10);
        assertTrue(etal >= 0);
    }

    @Test
    void testPrendreEtal_inconnu() {
        int etal = control.prendreEtal("César", "poisson", 10);
        assertEquals(-1, etal);
    }

    @Test
    void testVerifierIdentite_true() {
        assertTrue(control.verifierIdentite("Ordralfabétix"));
    }

    @Test
    void testVerifierIdentite_false() {
        assertFalse(control.verifierIdentite("César"));
    }
}
