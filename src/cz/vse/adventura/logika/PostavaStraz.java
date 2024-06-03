package cz.vse.adventura.logika;

public class PostavaStraz extends Postava {
    public PostavaStraz(String jmeno, Prostor prostor, Vec pozadovanaVec) {
        super(jmeno, prostor, pozadovanaVec);
    }

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
