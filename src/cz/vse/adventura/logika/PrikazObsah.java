package cz.vse.adventura.logika;

import java.lang.StringBuilder;

/**
 *  Třída PrikazRozhlednout implementuje pro hru příkaz obsah.
 *  Tato třída je součástí jednoduché textové hry.
 *
 * @author     Jan Kornienko
 * @version    pro školní rok 2023/2024
 */
public class PrikazObsah extends Prikaz {
    private Batoh batoh;

    /**
     *  Konstruktor třídy
     */
    public PrikazObsah() {
        super("obsah");
        this.batoh = Batoh.getInstance();
    }

    /**
     * Provádí příkaz "obsah". Vypíše obsah batohu.
     *
     * @param parametry - v tomto případě se nepoužívají.
     * @return seznam věcí v batohu
     */
    @Override
    public String provedPrikaz(String... parametry) {
        StringBuilder vystup = new StringBuilder();

        if (batoh.getObsah().size() <= 0){
            return "V batohu nejsou žádné věci";
        }

        vystup.append("V batohu jsou následující věci:\n");

        for (Vec vec : batoh.getObsah()) {
            vystup.append("- " + vec.getNazev() + " - velikost: " + vec.getVelikost() + "\n");
        }

        vystup.append("Batoh je naplněn " + batoh.getObsazenost() + " z " + batoh.getKapacita());

        return vystup.toString();
    }
}
