package cz.vse.adventura.logika;


import javax.swing.*;

/**
 *  Class HerniPlan - třída představující mapu a stav adventury.
 *
 *  Tato třída inicializuje prvky ze kterých se hra skládá:
 *  vytváří všechny prostory,
 *  propojuje je vzájemně pomocí východů
 *  a pamatuje si aktuální prostor, ve kterém se hráč právě nachází.
 *
 *@author     Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova, Jan Kornienko
 *@version    pro školní rok 2016/2017, upraveno 2024
 */
public class HerniPlan {

    private Prostor aktualniProstor;

    /**
     *  Konstruktor který vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví halu.
     */
    public HerniPlan() {
        zalozProstoryHry();

    }
    /**
     *  Vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví domeček.
     */
    private void zalozProstoryHry() {
        // vytvářejí se jednotlivé prostory
        Prostor domecek = new Prostor("domecek","domeček, ve kterém bydlí Karkulka");
        Prostor chaloupka = new Prostor("chaloupka","chaloupka, ve které bydlí babička Karkulky");
        Prostor les = new Prostor("les","les, který je plný dřeva a borůvek");
        Prostor hlubokyLes = new Prostor("hluboky_les","hluboký les, ve kterém má babička chaloupku");
        Prostor draciDoupe = new Prostor("draci_doupe","dračí doupě, ve které číhá nebezpečný drak");
        Prostor cesta = new Prostor("cesta","cesta, na které tě může čekat nečekané překvapení");
        Prostor vesnice = new Prostor("vesnice","vesnice, ve které se nachází spoustu zajímavých míst");
        Prostor kovarna = new Prostor("kovarna","kovárna, kde pracuje kovář");
        Prostor hospoda = new Prostor("hospoda","hospoda, kde se čepuje pivo a je tady hospodský");
        Prostor hradni_brana = new Prostor("hradni_brana","hradní brána, kde strážný hlídá vstup do hradu");
        Prostor hrad = new Prostor("hrad","hrad, kde na Karkulku čeká vysněný princ Krasoň");


        // přiřazují se průchody mezi prostory (sousedící prostory)
        domecek.setVychod(les);
        les.setVychod(domecek);
        les.setVychod(hlubokyLes);
        les.setVychod(cesta);
        hlubokyLes.setVychod(les);
        hlubokyLes.setVychod(draciDoupe);
        hlubokyLes.setVychod(chaloupka);
        draciDoupe.setVychod(hlubokyLes);
        chaloupka.setVychod(hlubokyLes);
        cesta.setVychod(les);
        cesta.setVychod(vesnice);
        vesnice.setVychod(cesta);
        vesnice.setVychod(kovarna);
        vesnice.setVychod(hospoda);
        vesnice.setVychod(hradni_brana);
        kovarna.setVychod(vesnice);
        hospoda.setVychod(vesnice);
        hradni_brana.setVychod(vesnice);
        hradni_brana.setVychod(hrad);
        hrad.setVychod(hradni_brana);

        hrad.setZamceno(true); // zamkne hrad

        aktualniProstor = domecek;  // hra začíná v domečku

        // vytvoření věcí na plánku
        Vec klacek = new Vec("klacek", 3, true);
        Vec boruvky = new Vec("boruvky", 2, true);
        Vec strom = new Vec ("strom" , 0, false);
        Vec parez = new Vec("parez", 0, false);
        Vec odpadleParozi = new Vec("odpadle_parozi", 4, true);
        Vec balvan = new Vec("balvan", 5, true);
        Vec kybl = new Vec("kybl", 4, true);
        Vec lucerna = new Vec("lucerna", 2, true);
        Vec zlatak = new Vec("zlatak", 1, true);
        Vec draciHlava = new Vec("draci_hlava", 5, true);
        Vec kovadlina = new Vec("kovadlina", 0, false);
        Vec mec = new Vec("mec", 3, true);
        Vec pivo = new Vec("pivo", 2, true);

        // zasazení věcí do prostoru
        les.vlozVec(klacek);
        les.vlozVec(boruvky);
        les.vlozVec(strom);
        hlubokyLes.vlozVec(parez);
        hlubokyLes.vlozVec(strom);
        hlubokyLes.vlozVec(odpadleParozi);
        chaloupka.vlozVec(lucerna);
        draciDoupe.vlozVec(balvan);
        vesnice.vlozVec(kybl);
        kovarna.vlozVec(kovadlina);
        hospoda.vlozVec(pivo);

        // vytvoreni postav na planku
        Postava babicka = new PostavaSmena("babicka", chaloupka, null, zlatak, 0);
        Postava obchodnik = new PostavaSmena("obchodnik", cesta, boruvky, zlatak, 1);
        Postava hospodsky = new PostavaSmena("hospodsky", hospoda, odpadleParozi, zlatak, 1);
        Postava kovar = new PostavaSmena("kovar", kovarna, zlatak, mec, 3);
        Postava straz = new PostavaStraz("straz", hrad, draciHlava);
        Postava drak = new PostavaDrak("drak", draciDoupe, mec, draciHlava);

        // zasazeni postav do prostoru
        chaloupka.vlozPostavu(babicka);
        cesta.vlozPostavu(obchodnik);
        hospoda.vlozPostavu(hospodsky);
        kovarna.vlozPostavu(kovar);
        hradni_brana.vlozPostavu(straz);
        draciDoupe.vlozPostavu(drak);
    }

    /**
     *  Metoda vrací odkaz na aktuální prostor, ve ktetém se hráč právě nachází.
     *
     *@return     aktuální prostor
     */

    public Prostor getAktualniProstor() {
        return aktualniProstor;
    }

    /**
     *  Metoda nastaví aktuální prostor, používá se nejčastěji při přechodu mezi prostory
     *
     *@param  prostor nový aktuální prostor
     */
    public void setAktualniProstor(Prostor prostor) {
        aktualniProstor = prostor;
    }

}
