package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherMarcheTest {

    private Village village;
    private ControlAfficherMarche control;
    private Gaulois vendeur;

    @BeforeEach
    void setUp() {
        village = new Village("Village", 10, 2);

        Chef chef = new Chef("Abraracourcix", 10, village);
        village.setChef(chef);

        vendeur = new Gaulois("Ordralfabétix", 10);
        village.ajouterHabitant(vendeur);

        control = new ControlAfficherMarche(village);
    }

  
    @Test
    void testControlAfficherMarche() {
        assertNotNull(control);
    }

    @Test
    void testDonnerInfosMarche() {
        village.installerVendeur(vendeur, "poisson", 10);

        String[] infos = control.donnerInfosMarche();

        assertNotNull(infos);
        assertTrue(infos.length > 0);
    }
    @Test
    void testDonnerInfosMarche_vide() {
        String[] infos = control.donnerInfosMarche();

        assertNotNull(infos);
    }
}