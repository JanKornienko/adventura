package cz.vse.adventura.logika;

public class PrikazMluv implements IPrikaz{
    private static final String NAZEV = "mluv";
    private Prostor aktualniProstor;

    /**
     * Konstruktor pro vytvoření instance příkazu pro mluvení s postavami.
     *
     * @param aktualniProstor aktuální prostor, ve kterém se hráč nachází
     */
    public PrikazMluv(Prostor aktualniProstor) {
        this.aktualniProstor = aktualniProstor;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            // Pokud chybí druhé slovo (jméno postavy), tak ....
            return "S kým chceš mluvit? Musíš zadat jméno postavy, se kterou chceš mluvit.";
        }

        String jmenoPostavy = parametry[0];
        /*
        TODO - Postava bude implementovana pozdeji

        Postava postava = aktualniProstor.najdiPostavu(jmenoPostavy);

        if (postava != null) {
            return postava.getMluva();
        } else {
            return "Postava " + jmenoPostavy + " není v aktuálním prostoru.";
        }
         */
        return "postava mluvi";
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
