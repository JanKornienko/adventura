package cz.vse.adventura.logika;

public class PrikazObsah implements IPrikaz{
    private static final String NAZEV = "obsah";
    private Prostor aktualniProstor;
    private Batoh batoh;

    public PrikazObsah(Prostor prostor, Batoh batoh) {
        this.aktualniProstor = prostor;
        this.batoh = batoh;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo (místo pro vypsání), tak ....
            return "Co tě zajímá? Vyber batoh nebo " + aktualniProstor.getNazev();
        }

        String objekt = parametry[0];
        String nazevProstoru = aktualniProstor.getNazev();

        switch (objekt) {
            case "batoh":
                return batoh.getVeci().toString();
            case "prostor":
                return aktualniProstor.getVeci();
            default:
                return "Neznámý objekt pro vypsání. Vyber batoh nebo " + aktualniProstor.getNazev();
        }
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
