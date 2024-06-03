package cz.vse.adventura.logika;

/**
 *  Třída PrikazKonec implementuje pro hru příkaz konec.
 *  Tato třída je součástí jednoduché textové hry.
 *
 *@autor     Jarmila Pavlickova, Luboš Pavlíček, Jan Kornienko
 *@verze     pro školní rok 2016/2017, upraveno LS 2024
 */
public class PrikazKonec extends Prikaz {
    private Hra hra;

    /**
     *  Konstruktor třídy
     *
     *  @param hra odkaz na hru, která má být ukončena
     */
    public PrikazKonec(Hra hra) {
        super("konec");
        this.hra = hra;
    }

    /**
     *  Provádí příkaz "konec". Ukončí hru.
     *
     *  @param parametry - v tomto případě se nepoužívají.
     *  @return zpráva, kterou vypíše hra hráči
     */
    @Override
    public String provedPrikaz(String... parametry) {
        hra.setKonecHry(true);
        return "Hra byla ukončena.";
    }
}
