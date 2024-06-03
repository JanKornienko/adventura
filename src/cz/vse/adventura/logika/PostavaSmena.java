package cz.vse.adventura.logika;

import java.time.LocalDate;
import java.time.DayOfWeek;
import java.lang.StringBuilder;

public class PostavaSmena extends Postava{
    private int pozadovanyPocet;
    private Batoh batoh;
    private Vec darovanaVec;

    public PostavaSmena(String jmeno, Prostor prostor, Vec pozadovanaVec, Vec darovanaVec, int pozadovanyPocet) {
        super(jmeno, prostor, pozadovanaVec);
        this.darovanaVec = darovanaVec;
        this.pozadovanyPocet = pozadovanyPocet;
        this.batoh = Batoh.getInstance();
    }

    private String pozdrav() {
        StringBuilder vystup = new StringBuilder();

        // Získání aktuálního dne v týdnu
        LocalDate dnes = LocalDate.now();
        DayOfWeek denVTydnu = dnes.getDayOfWeek();

        // Převedení dne z denVTydnu na náš enum Den
        Den den = Den.valueOf(denVTydnu.name());

        switch (den) {
            case MONDAY:
                vystup.append("Přeji hezké pondělí,\n");
                break;
            case TUESDAY:
                vystup.append("Přeji hezké úterý,\n");
                break;
            case WEDNESDAY:
                vystup.append("Přeji příjemnou středu,\n");
                break;
            case THURSDAY:
                vystup.append("Přeji krásný čtvrtek,\n");
                break;
            case FRIDAY:
                vystup.append("Přeji pěkný pátek,\n");
                break;
            case SATURDAY:
                vystup.append("Přeji krásnou sobotu,\n");
                break;
            case SUNDAY:
                vystup.append("Přeji pohodovou neděli,\n");
                break;
            default:
                vystup.append("Přeji hezký den,\n");
                break;
        }

        vystup.append("já jsem " + getJmeno() + " ");

        if (pozadovanyPocet <= 0 && darovanaVec != null) {
            vystup.append(", tady máš " + darovanaVec.getNazev() + ", může se ti někdy v budoucnu hodit.");
        } else {
            vystup.append("a dám ti " + darovanaVec.getNazev() + " za " + pozadovanyPocet + " " + getPozadovanaVec().getNazev() + ".");
        }

        return vystup.toString();
    }

    private void pridaniDoBatohu() {
        if (!batoh.vlozPredmet(darovanaVec)) {
            System.out.println("Vypadá to, že máš plný baťůžek, proto ti nachám " + darovanaVec.getNazev() + " tady v " + getProstor().getNazev());
            getProstor().vlozVec(darovanaVec);
        }

        setSmenaProbehla();
    }

    public void akce() {
        if (getSmenaProbehla()) {
            System.out.println("Už ti nemám co nabídnout, pokud sis ode mě nevzala " + darovanaVec.getNazev() + ", najdeš to v prostoru " + getProstor().getNazev());
            return;
        }

        // Voláme pozdrav
        System.out.println(pozdrav());

        if (pozadovanyPocet <= 0 && darovanaVec != null) {
            pridaniDoBatohu();
            return;
        }

        // Kontrola poctu pozadovanych veci
        while (pozadovanyPocet > 0) {
            if (batoh.obsahujePredmet(getPozadovanaVec().getNazev())) {
                Vec existujiciVec = batoh.getPredmet(getPozadovanaVec().getNazev());
                batoh.odeberPredmet(existujiciVec);
                pozadovanyPocet--;
                continue;
            }

            break;
        }

        if (pozadovanyPocet <= 0) {
            pridaniDoBatohu();
            System.out.println("Děkuji za výměnu, snad si " + darovanaVec.getNazev() + " užiješ!");
            return;
        }

        System.out.println("Vypadá to, že nemáš, to co potřebuji.\n" +
                "Vrať se prosím později.");
    }
}
