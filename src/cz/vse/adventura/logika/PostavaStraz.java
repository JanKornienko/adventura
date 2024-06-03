package cz.vse.adventura.logika;

/**
 * Třída reprezentující strážce v herním světě.
 * Je potomkem třídy Postava.
 *
 * @author Jan Kornienko
 * @version pro LS 2023/2024
 */
public class PostavaStraz extends Postava {
    /**
     * Konstruktor pro vytvoření instance strážce.
     *
     * @param jmeno název strážce
     * @param prostor aktuální prostor, kde se strážec nachází
     * @param pozadovanaVec požadovaná věc k interakci s postavou
     */
    public PostavaStraz(String jmeno, Prostor prostor, Vec pozadovanaVec) {
        super(jmeno, prostor, pozadovanaVec);
    }

    /**
     * Metoda pro provedení akce interakce s postavou strážce.
     */
    public void akce() {
        if (getSmenaProbehla()) {
            System.out.println("Klaníme se ti Karkulko, od tebe bychom zabití draka nečekali.");
            return;
        }

        if (existujiciVec()) {
            setSmenaProbehla();
            getProstor().setZamceno(false);
            System.out.println("Zázrak, ty si ho pokořila.\n" +
                    "Od teď máš na hrad volný přístup.\n" +
                    "Vítej!!!");
            return;
        }

        System.out.println("Kliď se odsud, na hradě nemáš co pohledávat,\n" +
                "ledaže by si zabila draka, ale to je nemožné!!!\n" +
                "Dokud tě tady neuvidíme s dračí hlavou, nikdo ti neuvěří.");
    }
}
