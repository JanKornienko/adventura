package cz.vse.adventura.logika;

/**
 * Třída reprezentující příkaz pro interakci s postavami v herním světě.
 * Je potomkem třídy Prikaz.
 *
 * @author Jan Kornienko
 * @version pro LS 2023/2024
 */
public class PrikazInterakce extends Prikaz {
    private HerniPlan plan;

    /**
     * Konstruktor pro vytvoření instance příkazu pro interakci.
     *
     * @param plan herní plán, se kterým je příkaz prováděn
     */
    public PrikazInterakce(HerniPlan plan) {
        super("interakce");
        this.plan = plan;
    }

    /**
     * Metoda pro provedení příkazu interakce.
     *
     * @param parametry parametry příkazu
     * @return zpráva, která se vypíše hráči po provedení příkazu
     */
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo (postava), tak ....
            return "S kým chceš interagovat? Musíš zadat jméno postavy";
        }

        String pozadovanaPostava = parametry[0];

        // zkousime najit postavu v mistnosti
        Postava postava = plan.getAktualniProstor().getPostava(pozadovanaPostava);

        if (postava == null) {
            return "Tahle postava zde není";
        }

        postava.akce();

        return "";
    }
}
