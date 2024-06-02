package cz.vse.adventura.logika;

public class PrikazPoloz implements IPrikaz{
    private static final String NAZEV = "polož";
    private Prostor aktualniProstor;
    private Batoh batoh;

    public PrikazPoloz(Prostor prostor, Batoh batoh) {
        this.aktualniProstor = prostor;
        this.batoh = batoh;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo (věc), tak ....
            return "Co položit? Musíš zadat jméno věci, kterou chceš odebrat z batohu";
        }

        Vec vec = batoh.odeberVec(parametry[0]);
        if (vec != null) {
            aktualniProstor.pridejVec(vec);
            return "Věc " + parametry[0] + " byla položena v prostoru.";
        } else {
            // Pokud věc není v batohu
            return "Věc " + parametry[0] + " není v batohu.";
        }
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
