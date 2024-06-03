package cz.vse.adventura.logika;

public class PostavaDrak extends Postava {
    private Vec draciHlava;

    public PostavaDrak(String jmeno, Prostor prostor, Vec pozadovanaVec, Vec draciHlava) {
        super(jmeno, prostor, pozadovanaVec);
        this.draciHlava = draciHlava;
    }

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
