package cz.vse.adventura.logika;

/**
 *  Třída PrikazRozhlednout implementuje pro hru příkaz seber.
 *  Tato třída je součástí jednoduché textové hry.
 *
 * @author     Jan Kornienko
 * @version    pro školní rok 2023/2024
 */
public class PrikazSeber extends Prikaz {
    private HerniPlan plan;
    private Batoh batoh;

    /**
     *  Konstruktor třídy
     *
     *  @param plan plán ke zjištění aktuálního prostoru
     */
   public PrikazSeber(HerniPlan plan) {
       super("seber");
       this.plan = plan;
       this.batoh = Batoh.getInstance();
   }

    /**
     *  Provádí příkaz "seber". Zkouší sebrat předmět z prostoru a uložit ho
     *  do batohu.
     *
     *  @param parametry - jako parametr obsahuje jméno předmětu k sebrání,
     *  @return zpráva, kterou vypíše hra hráči
     */
   @Override
   public String provedPrikaz(String... parametry) {
       final Prostor aktualniProstor = plan.getAktualniProstor();

       if (parametry.length == 0) {
           // pokud chybí druhé slovo (sousední prostor), tak ....
           return "Co sebrat? Napiš věc, kterou chceš uložit do batohu.";
       }

       String predmet = parametry[0];

       // zkoušíme sebrat věc a uložit ji do batohu
       if (!aktualniProstor.obsahujeVec(predmet)) { // Věc v prostoru není
           return "Věc " + predmet + " se v prostoru " + aktualniProstor.getNazev() + " nenachází.";
       }

       Vec existujiciVec = aktualniProstor.getVec(predmet);

       if (batoh.vlozPredmet(existujiciVec)) { // Plný batoh
           aktualniProstor.odeberVec(existujiciVec);
       }

       return "";
   }
}
