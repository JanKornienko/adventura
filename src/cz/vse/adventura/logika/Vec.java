package cz.vse.adventura.logika;

public class Vec {
    private String nazev;
    private String popis;

    /**
     * Konstruktor pro vytvoření předmětu se zadaným názvem a popisem.
     *
     * @param nazev název předmětu
     * @param popis popis předmětu
     */
    public Vec(String nazev, String popis) {
        this.nazev = nazev;
        this.popis = popis;
    }

    /**
     * Metoda pro získání názvu předmětu.
     *
     * @return název předmětu
     */
    public String getNazev() {
        return nazev;
    }

    /**
     * Metoda pro získání popisu předmětu.
     *
     * @return popis předmětu
     */
    public String getPopis() {
        return popis;
    }
}
