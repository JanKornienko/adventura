package cz.vse.adventura.logika;

public class PrikazSeber implements IPrikaz {
    private static final String NAZEV = "seber";
    private Prostor aktualniProstor;
    private Batoh batoh;

    public PrikazSeber(Prostor prostor, Batoh batoh) {
       this.aktualniProstor = prostor;
       this.batoh = batoh;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo (věc), tak ....
            return "Co sebrat? Musíš zadat jméno věci, kterou chceš uložit do batohu";
        }

        // Vytvoření proměnné pro uložení zprávy o průběhu operace
        StringBuilder zprava = new StringBuilder();

        // Projdi všechny parametry (věci), které hráč zadal
        for (String nazevVeci : parametry) {
            // Zkontroluj, zda je věc s tímto názvem v aktuálním prostoru
            Vec nalezenaVec = aktualniProstor.odeberVec(nazevVeci);
            if (nalezenaVec != null) {
                // Pokud věc byla nalezena v prostoru, zkontroluj kapacitu batohu
                if (batoh.jePlny()) {
                    // Pokud je batoh plný, vrať zprávu o tom, že nelze přidat další věc
                    // a vrátíme věc zpět do prostoru
                    aktualniProstor.pridejVec(nalezenaVec);
                    zprava.append("Batoh je plný, nelze přidat další věc: ").append(nazevVeci).append("\n");
                } else {
                    // Pokud je v batohu místo, přidej věc do batohu
                    batoh.pridejVec(nalezenaVec);
                    zprava.append("Věc ").append(nalezenaVec.getNazev()).append(" byla uložena do batohu.\n");
                }
            } else {
                // Pokud věc není v aktuálním prostoru, přidej informaci o tom do zprávy
                zprava.append("Věc s názvem ").append(nazevVeci).append(" v prostoru není.\n");
            }
        }

        // Vrátíme výslednou zprávu o průběhu operace
        return zprava.toString();
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
