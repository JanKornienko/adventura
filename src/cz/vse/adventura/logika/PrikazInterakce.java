package cz.vse.adventura.logika;

public class PrikazInterakce extends Prikaz {
    private HerniPlan plan;

    public PrikazInterakce(HerniPlan plan) {
        super("interakce");
        this.plan = plan;
    }

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
