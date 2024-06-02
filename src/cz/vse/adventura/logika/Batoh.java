package cz.vse.adventura.logika;

import java.util.ArrayList;
import java.util.List;

/**
 * Třída Batoh představuje batoh, do kterého hráč může ukládat předměty.
 * Batoh má pevnou kapacitu a uchovává v něm seznam předmětů.
 *
 * Implementace singletonu, požadováno v domácím úkolu.
 *
 * @author     Jan Kornienko
 * @version    pro školní rok 2023/2024
 */
public class Batoh {
    private static final int KAPACITA = 5; // Maximální kapacita batohu
    private List<Vec> obsah; // Seznam předmětů v batohu
    private int obsazenost; // Obsazená kapacita batohu
    private static Batoh instance; // Instance batohu

    /**
     * Privátní konstruktor pro vytvoření instance batohu.
     * Vytvoří prázdný batoh.
     */
    private Batoh() {
        this.obsah = new ArrayList<>();
        this.obsazenost = 0;
    }

    /**
     * Metoda pro získání instance batohu.
     * Pokud instance neexistuje, vytvoří ji a vrátí ji.
     * @return instance batohu
     */
    public static synchronized Batoh getInstance() {
        if (instance == null) {
            instance = new Batoh();
        }
        return instance;
    }

    /**
     * Metoda pro vložení předmětu do batohu.
     * Pokud je batoh plný, předmět se nevloží.
     * @param vec předmět k vložení
     * @return true, pokud se předmět vložil, jinak false
     */
    public boolean vlozPredmet(Vec vec) {
        if (obsazenost + vec.getVelikost() <= KAPACITA && vec.getPrenositelnost()) {
            obsazenost += vec.getVelikost();
            obsah.add(vec);
            System.out.println("Předmět " + vec.getNazev() + " byl vložen do batohu.");
            return true;
        } else if (!vec.getPrenositelnost()) {
            System.out.println("Předmět " + vec.getNazev() + " je nepřenositelný.");
            return false;
        } else {
            System.out.println("Batoh je plný, předmět " + vec.getNazev() + " nešlo vložit.");
            return false;
        }
    }

    /**
     * Metoda pro ověření, zda batoh obsahuje zadaný předmět.
     * @param nazevPredmetu název předmětu k ověření
     * @return true, pokud batoh obsahuje předmět, jinak false
     */
    public boolean obsahujePredmet(String nazevPredmetu) {
        for (Vec vec : obsah) {
            if (vec.getNazev().equals(nazevPredmetu)) {
                return true;
            }
        }
        return false;
    }


    /**
     * Metoda pro odebrání předmětu z batohu.
     * @param vec předmět k odebrání
     */
    public void odeberPredmet(Vec vec) {
        if (this.obsahujePredmet(vec.getNazev())) {
            obsah.remove(vec);
            obsazenost -= vec.getVelikost();
            System.out.println("Předmět " + vec.getNazev() + " byl odebrán z batohu.");
        } else {
            System.out.println("Předmět " + vec.getNazev() + " není v batohu.");
        }
    }

    /**
     * Metoda pro získání seznamu předmětů v batohu.
     * @return seznam předmětů v batohu
     */
    public List<Vec> getObsah() {
        return obsah;
    }

    /**
     * Metoda pro získání počtu předmětů v batohu.
     * @return počet předmětů v batohu
     */
    public int getObsazenost() {
        return obsazenost;
    }

    /**
     * Metoda pro získání kapacity batohu.
     * @return kapacita batohu
     */
    public int getKapacita() {
        return KAPACITA;
    }
}
