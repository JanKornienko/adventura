package cz.vse.adventura.logika;

/**
 * Abstraktní třída Postava představuje základní strukturu pro všechny postavy ve hře.
 * Tato třída je součástí jednoduché textové hry.
 * Příklad dědičnosti podle požadavků domácího úkolu
 *
 *  @author Jan Kornienko
 *  @version pro LS 2023/2024
 */
public abstract class Postava {
    private final String jmeno;
    private final Vec pozadovanaVec;
    private final Prostor prostor;
    private boolean smenaProbehla;
    private Batoh batoh;

    /**
     * Konstruktor pro vytvoření postavy
     *
     * @param jmeno jméno postavy
     */
    public Postava(String jmeno, Prostor prostor, Vec pozadovanaVec) {
        this.batoh = Batoh.getInstance();
        this.jmeno = jmeno;
        this.prostor = prostor;
        this.pozadovanaVec = pozadovanaVec;
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
     * Metoda vrací prostor, ve kterém se postava nachází
     *
     * @return prostor, ve kterém postava je
     */
    public Prostor getProstor() {
        return prostor;
    }

    /**
     * Metoda vrací zda směna proběhla
     *
     * @return boolean proběhlé směny
     */
    public boolean getSmenaProbehla() {
        return smenaProbehla;
    }

    /**
     * Metoda nastavuje proběhlou směnu
     */
    public void setSmenaProbehla() {
        smenaProbehla = true;
    }

    /**
     * Metoda která získá objekt batohu
     *
     * @return batoh
     */
    public Batoh getBatoh() {
        return batoh;
    }

    /**
     * Kontroluje, zda batoh obsahuje požadovanou věc, a pokud ano, odebere ji z batohu.
     *
     * @return true, pokud požadovaná věc existuje v batohu a byla odebrána, jinak false
     */
    public boolean existujiciVec() {
        if (batoh.obsahujePredmet(pozadovanaVec.getNazev())) {
            Vec existujiciVec = batoh.getPredmet(pozadovanaVec.getNazev());
            batoh.odeberPredmet(existujiciVec);
            return true;
        }

        return false;
    }

    /**
     * Metoda, ve které se provádí akce postavy
     */
    public abstract void akce();
}