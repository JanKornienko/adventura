package cz.vse.adventura.logika;

import java.lang.StringBuilder;

/**
 *  Třída PrikazRozhlednout implementuje pro hru příkaz rozhlédnout.
 *  Tato třída je součástí jednoduché textové hry.
 *
 * @author     Jan Kornienko
 * @version    pro školní rok 2023/2024
 */
public class PrikazRozhlednout extends Prikaz {
    private HerniPlan plan;

    /**
     *  Konstruktor třídy
     *
     *  @param plan plán ke zjištění aktuálního prostoru
     */
    public PrikazRozhlednout(HerniPlan plan) {
        super("rozhlednout");
        this.plan = plan;
    }

    /**
     * Provádí příkaz "rozhlednout". Rozhlédne se po prostoru a vypíše předměty, které se v něm nachází.
     *
     *  @param parametry - v tomto případě se nepoužívají.
     * @return seznam věcí v prostoru
     */
    @Override
    public String provedPrikaz(String... parametry) {
        final Prostor aktualniProstor = plan.getAktualniProstor();
        StringBuilder vystup = new StringBuilder();

        vystup.append("V prostoru se nacházejí tyto věci:\n");

        if (aktualniProstor.getVeci().size() <= 0){
            return "V prostoru " + aktualniProstor.getNazev() + " se nic nenachází";
        }

        for (Vec vec : aktualniProstor.getVeci()) {
            vystup.append("- " + vec.getNazev() + "\n");
        }

        return vystup.toString();
    }
}
