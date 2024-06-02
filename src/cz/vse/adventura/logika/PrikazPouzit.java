package cz.vse.adventura.logika;

public class PrikazPouzit implements IPrikaz{
    private static final String NAZEV = "použít";
    private Batoh batoh;

    public PrikazPouzit(Batoh batoh) {
        this.batoh = batoh;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo (věc), tak ....
            return "Co použít? Musíš zadat jméno věci, kterou chceš použít";
        }

        String nazevVeci = parametry[0];
        Vec vec = batoh.obsahujeVec(nazevVeci);

        if (vec != null) {
            return "Popis věci " + nazevVeci + ": " + vec.getPopis();
        } else {
            return "Věc " + nazevVeci + " není v batohu.";
        }
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
