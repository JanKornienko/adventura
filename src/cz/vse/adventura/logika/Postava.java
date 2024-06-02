package cz.vse.adventura.logika;

/**
 * Abstraktní třída Postava představuje základní strukturu pro všechny postavy ve hře.
 * Tato třída je součástí jednoduché textové hry.
 * Příklad dědičnosti podle požadavků domácího úkolu
 *
 * @author     Jan Kornienko
 * @version    pro školní rok 2023/2024
 */
public abstract class Postava {
    private final String jmeno;
    private final Vec pozadovanaVec;
    private final Vec darovanaVec;
    private final Prostor prostor;
    private boolean smenaProbehla;

    /**
     * Konstruktor pro vytvoření postavy
     *
     * @param jmeno jméno postavy
     */
    public Postava(String jmeno, Prostor prostor, Vec pozadovanaVec, Vec darovanaVec) {
        this.jmeno = jmeno;
        this.prostor = prostor;
        this.pozadovanaVec = pozadovanaVec;
        this.darovanaVec = darovanaVec;
        this.smenaProbehla = false;
    }

    /**
     * Metoda vrací jméno postavy
     *
     * @return jméno postavy
     */
    public String getJmeno() {
        return jmeno;
    }

    /**
     * Metoda vrací věc, kterou postava chce
     *
     * @return věc, kterou postava chce
     */
    public Vec getPozadovanaVec() {
        return pozadovanaVec;
    }

    /**
     * Metoda vrací věc, kterou výměnou daruje
     *
     * @return věc, kterou výměnou daruje
     */
    public Vec getDarovanaVec() {
        return darovanaVec;
    }

    /**
     * Metoda vrací prostor, ve kterém se postava nachází
     *
     * @return prostor, ve kterém postava je
     */
    public Prostor getProstor() {
        return prostor;
    }

    public boolean getSmenaProbehla() {
        return smenaProbehla;
    }

    public void setSmenaProbehla() {
        smenaProbehla = true;
    }
}