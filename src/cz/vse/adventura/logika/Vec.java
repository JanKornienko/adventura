package cz.vse.adventura.logika;

/**
 * Třída Vec představuje předmět v textové hře.
 * Každý předmět má název, popis a velikost.
 *
 * @author     Jan Kornienko
 * @version    pro školní rok 2023/2024
 */
public class Vec {
    private String nazev; // Název předmětu
    private boolean prenositelnost; // Přenositelnost věci
    private int velikost; // Velikost předmětu

    /**
     * Konstruktor pro vytvoření instance předmětu.
     * @param nazev název předmětu
     * @param velikost velikost předmětu
     */
    public Vec(String nazev, int velikost, boolean prenostilnost) {
        this.nazev = nazev;
        this.velikost = velikost;
        this.prenositelnost = prenostilnost;
    }

    /**
     * Metoda pro získání názvu předmětu.
     * @return název předmětu
     */
    public String getNazev() {
        return nazev;
    }

    /**
     * Metoda pro získání velikosti předmětu.
     * @return velikost předmětu
     */
    public int getVelikost() {
        return velikost;
    }

    /**
     * Metoda pro zjištění přenostitelnosti předmětu
     * @return přenostitelnost předmětu
     */
    public boolean getPrenositelnost() {
        return prenositelnost;
    }

    /**
     * Přepsaná metoda toString pro získání textové reprezentace předmětu.
     * @return textová reprezentace předmětu
     */
    @Override
    public String toString() {
        return "nazev: " + nazev +
                ", velikost: " + velikost;
    }
}