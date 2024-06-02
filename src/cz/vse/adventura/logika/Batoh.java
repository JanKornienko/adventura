package cz.vse.adventura.logika;

import java.util.List;
import java.util.ArrayList;

public class Batoh {
    private static final int KAPACITA = 5; // Maximální kapacita batohu
    private List<Vec> veci; // Seznam věcí v batohu

    /**
     * Konstruktor pro vytvoření batohu s prázdným seznamem věcí.
     */
    public Batoh() {
        this.veci = new ArrayList<>();
    }

    /**
     * Metoda pro přidání věci do batohu, pokud je v něm ještě místo.
     *
     * @param vec věc, která se má přidat do batohu
     * @return true, pokud se věc podařilo přidat do batohu, jinak false
     */
    public boolean pridejVec(Vec vec) {
        if (veci.size() < KAPACITA) {
            veci.add(vec);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metoda pro odebrání věci z batohu.
     *
     * @param nazev název věci, která se má odebrat z batohu
     * @return odebraná věc, nebo null pokud věc v batohu není
     */
    public Vec odeberVec(String nazev) {
        for (Vec vec : veci) {
            if (vec.getNazev().equalsIgnoreCase(nazev)) {
                veci.remove(vec);
                return vec;
            }
        }
        return null;
    }

    /**
     * Metoda pro zjištění, zda je v batohu věc se zadaným názvem.
     *
     * @param nazev název věci, kterou hledáme v batohu
     * @return true, pokud je věc v batohu, jinak false
     */
    public Vec obsahujeVec(String nazev) {
        for (Vec vec : veci) {
            if (vec.getNazev().equalsIgnoreCase(nazev)) {
                return vec;
            }
        }
        return null;
    }

    /**
     * Metoda pro zjištění, zda je batoh plný.
     *
     * @return true, pokud je batoh plný, jinak false
     */
    public boolean jePlny() {
        return veci.size() >= KAPACITA;
    }

    /**
     * Metoda pro získání seznamu věcí v batohu.
     *
     * @return seznam věcí v batohu
     */
    public List<Vec> getVeci() {
        return veci;
    }
}
