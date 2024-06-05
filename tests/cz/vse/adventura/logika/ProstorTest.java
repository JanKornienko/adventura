package cz.vse.adventura.logika;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

/*******************************************************************************
 * Testovací třída ProstorTest slouží ke komplexnímu otestování
 * třídy Prostor
 *
 * @author    Jarmila Pavlíčková, Jan Kornienko
 * @version   pro skolní rok 2016/2017, upraveno 2024
 */
public class ProstorTest
{
    private Prostor hrad;
    private Vec mec;
    private Vec jablko;
    private Postava drak;

    /**
     * Inicializace prostředků pro každý test.
     */
    @BeforeEach
    public void setUp() {
        hrad = new Prostor("hrad", "popis hradu");
        mec = new Vec("Mec", 1, true);
        jablko = new Vec("Jablko", 1, true);
        drak = new PostavaDrak("Drak", hrad, mec, jablko);
    }

    /**
     * Původní 2016/2017
     * Testuje, zda jsou správně nastaveny průchody mezi prostory hry. Prostory
     * nemusí odpovídat vlastní hře, 
     */
    @Test
    public  void testLzeProjit() {		
        Prostor prostor1 = new Prostor("hala", "vstupní hala budovy VŠE na Jižním městě");
        Prostor prostor2 = new Prostor("bufet", "bufet, kam si můžete zajít na svačinku");
        prostor1.setVychod(prostor2);
        prostor2.setVychod(prostor1);
        assertEquals(prostor2, prostor1.vratSousedniProstor("bufet"));
        assertEquals(null, prostor2.vratSousedniProstor("pokoj"));
    }

    /**
     * Test přidávání a odebírání věcí v prostoru.
     */
    @Test
    public void testVeciVProstoru() {
        hrad.vlozVec(mec);
        assertTrue(hrad.obsahujeVec("Mec"));
        assertEquals(mec, hrad.getVec("Mec"));

        hrad.odeberVec(mec);
        assertFalse(hrad.obsahujeVec("Mec"));
        assertNull(hrad.getVec("Mec"));
    }

    /**
     * Test přidávání a odebírání postav v prostoru.
     */
    @Test
    public void testPostavyVProstoru() {
        hrad.vlozPostavu(drak);
        assertTrue(hrad.obsahujePostavu("Drak"));
        assertEquals(drak, hrad.getPostava("Drak"));

        hrad.odeberPostavu(drak);
        assertFalse(hrad.obsahujePostavu("Drak"));
        assertNull(hrad.getPostava("Drak"));
    }

    /**
     * Test zamčení a odemčení prostoru.
     */
    @Test
    public void testZamceniProstoru() {
        hrad.setZamceno(true);
        assertTrue(hrad.getZamceno());

        hrad.setZamceno(false);
        assertFalse(hrad.getZamceno());
    }
}
