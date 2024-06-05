package cz.vse.adventura.logika;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Třída PostavaTest testuje funkčnost tříd Postava, PostavaDrak, PostavaStraz a PostavaSmena.
 * Testuje základní operace jako interakce s postavami, přidávání a odebírání předmětů.
 *
 * @author  Jan Kornienko
 * @version pro LS 2023/2024
 */
public class PostavaTest {

    private Batoh batoh;
    private Prostor prostor;
    private Vec mec;
    private Vec draciHlava;
    private Vec klic;
    private Vec jablko;

    /**
     * Inicializace prostředků pro každý test.
     */
    @BeforeEach
    public void setUp() {
        batoh = Batoh.getInstance();
        batoh.vycistitBatoh();

        prostor = new Prostor("hrad","hrad, kde na Karkulku čeká vysněný princ Krasoň");
        mec = new Vec("mec", 1, true);
        draciHlava = new Vec("draci_hlava", 1, true);
        klic = new Vec("klic", 1, true);
        jablko = new Vec("jablko", 1, true);
    }

    /**
     * Test pro PostavaDrak.
     */
    @Test
    public void testPostavaDrak() {
        PostavaDrak drak = new PostavaDrak("drak", prostor, mec, draciHlava);

        // Test bez požadované věci
        drak.akce();
        assertFalse(prostor.obsahujeVec("draci_hlava"));

        // Přidání požadované věci do batohu a test
        batoh.vlozPredmet(mec);
        drak.akce();
        assertTrue(prostor.obsahujeVec("draci_hlava"));
    }

    /**
     * Test pro PostavaStraz.
     */
    @Test
    public void testPostavaStraz() {
        PostavaStraz straz = new PostavaStraz("straz", prostor, draciHlava);
        prostor.setZamceno(true);

        // Test bez požadované věci
        straz.akce();
        assertTrue(prostor.getZamceno());

        // Přidání požadované věci do batohu a test
        batoh.vlozPredmet(draciHlava);
        straz.akce();
        assertFalse(prostor.getZamceno());
    }

    /**
     * Test pro PostavaSmena.
     */
    @Test
    public void testPostavaSmena() {
        PostavaSmena smena = new PostavaSmena("smena", prostor, jablko, klic, 2);

        // Test bez požadovaných věcí
        smena.akce();
        assertFalse(batoh.obsahujePredmet("klic"));

        // Přidání požadovaných věcí do batohu a test
        batoh.vlozPredmet(jablko);
        batoh.vlozPredmet(jablko);
        smena.akce();
        assertTrue(batoh.obsahujePredmet("klic"));
    }
}
