package cz.vse.adventura.logika;

/**
 *  Třída PrikazMisto implementuje pro hru příkaz misto.
 *  Tato třída je součástí jednoduché textové hry.
 *
 * @author     Jan Kornienko
 * @version    pro školní rok 2023/2024
 */
public class PrikazPolozit extends Prikaz{
    private HerniPlan plan;
    private Batoh batoh;

    /**
     *  Konstruktor třídy
     *
     *  @param plan plán ke zjištění aktuálního prostoru
     */
    public PrikazPolozit (HerniPlan plan) {
        super("polozit");
        this.plan = plan;
        this.batoh = Batoh.getInstance();
    }

    /**
     *  Provádí příkaz "polozit". Zkouší položit předmět z batohu do prostoru.
     *
     *  @param parametry - jako parametr obsahuje jméno předmětu k položení.
     *  @return zpráva, kterou vypíše hra hráči
     */

    public String provedPrikaz(String... parametry) {
        final Prostor aktualniProstor = plan.getAktualniProstor();

        if (parametry.length == 0) {
            // pokud chybí druhé slovo (sousední prostor), tak ....
            return "Co položit? Napiš věc, kterou chceš odebrat z batohu.";
        }

        String predmet = parametry[0];

        // zkoušíme odebrat věc z batohu
        if (!batoh.obsahujePredmet(predmet)) {
            return "Věc " + predmet + " se v batohu nenachází.";
        }

        Vec existujiciVec = batoh.getPredmet(predmet);

        if (batoh.odeberPredmet(existujiciVec)) {
            aktualniProstor.vlozVec(existujiciVec);
        }

        return "";
    }
}
