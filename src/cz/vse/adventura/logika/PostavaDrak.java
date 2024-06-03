package cz.vse.adventura.logika;

/**
 * Třída reprezentující postavu draka v herním světě.
 * Je potomkem třídy Postava.
 *
 * @author Jan Kornienko
 * @version pro LS 2023/2024
 */
public class PostavaDrak extends Postava {
    private Vec draciHlava;

    /**
     * Konstruktor pro vytvoření instance postavy draka.
     *
     * @param jmeno název postavy draka
     * @param prostor aktuální prostor, kde se postava nachází
     * @param pozadovanaVec požadovaná věc k interakci s postavou
     * @param draciHlava věc představující hlavu draka
     */
    public PostavaDrak(String jmeno, Prostor prostor, Vec pozadovanaVec, Vec draciHlava) {
        super(jmeno, prostor, pozadovanaVec);
        this.draciHlava = draciHlava;
    }

    /**
     * Metoda provádějící akci interakce s postavou draka.
     * Pokud hráč má požadovanou věc, draka porazí a získá jeho hlavu.
     * Jinak hráče varuje a vyzve k útěku.
     */
    public void akce() {
        if (getBatoh().obsahujePredmet(getPozadovanaVec().getNazev())) {
            System.out.println("Gratulace.\n" +
                    "Porazila si draka, jako trofej si můžeš odnést jeho hlavu");
            getProstor().vlozVec(draciHlava);
            getProstor().odeberPostavu(this);
            return;
        }

        System.out.println("Ty si troufáš na draka bez meče?\n" +
                "Radši utíkej, dřív než se ti něco stane.");
    }
}
