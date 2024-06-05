package cz.vse.adventura.logika;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Třída BatohTest testuje funkčnost třídy Batoh.
 * Testuje základní operace jako vložení, odebrání a ověření předmětů v batohu.
 *
 *  @author  Jan Kornienko
 *  @version pro LS 2023/2024
 */
public class BatohTest {

    private Batoh batoh;

    /**
     * Metoda, která se spustí před každým testem.
     * Inicializuje instanci batohu.
     */
    @BeforeEach
    public void setUp() {
        batoh = Batoh.getInstance();
        batoh.vycistitBatoh();
    }

    /**
     * Test metody vlozPredmet, která vkládá předměty do batohu.
     * Testuje vložení přenositelných a nepřenositelných předmětů,
     * a také přidání předmětů do plného batohu.
     */
    @Test
    public void testVlozPredmet() {
        Vec vec1 = new Vec("Kniha", 1, true);
        Vec vec2 = new Vec("Notebook", 3, true);
        Vec vec3 = new Vec("Skříň", 4, false);

        assertTrue(batoh.vlozPredmet(vec1));
        assertTrue(batoh.vlozPredmet(vec2));
        assertFalse(batoh.vlozPredmet(vec3));
        assertEquals(4, batoh.getObsazenost());

        Vec vec4 = new Vec("Laptop", 2, true);
        assertFalse(batoh.vlozPredmet(vec4));
    }

    /**
     * Test metody obsahujePredmet, která ověřuje přítomnost předmětu v batohu.
     */
    @Test
    public void testObsahujePredmet() {
        Vec vec = new Vec("Kniha", 1, true);
        batoh.vlozPredmet(vec);

        assertTrue(batoh.obsahujePredmet("Kniha"));
        assertFalse(batoh.obsahujePredmet("Notebook"));
    }

    /**
     * Test metody odeberPredmet, která odebírá předměty z batohu.
     */
    @Test
    public void testOdeberPredmet() {
        Vec vec = new Vec("Kniha", 1, true);
        batoh.vlozPredmet(vec);

        assertTrue(batoh.obsahujePredmet("Kniha"));
        assertTrue(batoh.odeberPredmet(vec));
        assertFalse(batoh.obsahujePredmet("Kniha"));
        assertEquals(0, batoh.getObsazenost());
    }

    /**
     * Test metody getPredmet, která získává předmět podle názvu.
     */
    @Test
    public void testGetPredmet() {
        Vec vec = new Vec("Kniha", 1, true);
        batoh.vlozPredmet(vec);

        assertEquals(vec, batoh.getPredmet("Kniha"));
        assertNull(batoh.getPredmet("Notebook"));
    }

    /**
     * Test metody getKapacita, která vrací kapacitu batohu.
     */
    @Test
    public void testGetKapacita() {
        assertEquals(5, batoh.getKapacita());
    }

    /**
     * Test metody getObsah, která vrací seznam předmětů v batohu.
     */
    @Test
    public void testGetObsah() {
        Vec vec1 = new Vec("Kniha", 1, true);
        Vec vec2 = new Vec("Notebook", 3, true);
        batoh.vlozPredmet(vec1);
        batoh.vlozPredmet(vec2);

        assertTrue(batoh.getObsah().contains(vec1));
        assertTrue(batoh.getObsah().contains(vec2));
    }

    /**
     * Test metody getObsazenost, která vrací aktuální obsazenost batohu.
     */
    @Test
    public void testGetObsazenost() {
        Vec vec1 = new Vec("Kniha", 1, true);
        Vec vec2 = new Vec("Notebook", 3, true);

        assertEquals(0, batoh.getObsazenost());

        batoh.vlozPredmet(vec1);
        assertEquals(1, batoh.getObsazenost());

        batoh.vlozPredmet(vec2);
        assertEquals(4, batoh.getObsazenost());

        batoh.odeberPredmet(vec1);
        assertEquals(3, batoh.getObsazenost());
    }
}
