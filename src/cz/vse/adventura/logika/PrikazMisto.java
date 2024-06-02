package cz.vse.adventura.logika;

/**
 *  Třída PrikazMisto implementuje pro hru příkaz misto.
 *  Tato třída je součástí jednoduché textové hry.
 *
 * @author     Jan Kornienko
 * @version    pro školní rok 2023/2024
 */
public class PrikazMisto extends Prikaz {
    private HerniPlan plan;

    /**
     *  Konstruktor třídy
     *
     *  @param plan herní plán
     */
    public PrikazMisto(HerniPlan plan) {
        super("misto");
        this.plan = plan;
    }

    /**
     *  Provádí příkaz "misto". Poradí hráči kde se zrovna nachází a kam jít.
     *
     *  @param parametry - nepoužívají se
     *  @return zpráva, kterou vypíše hra hráči
     */

    @Override
    public String provedPrikaz(String... parametry) {
        final Prostor aktualniProstor = plan.getAktualniProstor();

        return aktualniProstor.dlouhyPopis();

    }
}
