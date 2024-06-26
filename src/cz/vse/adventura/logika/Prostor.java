package cz.vse.adventura.logika;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Trida Prostor - popisuje jednotlivé prostory (místnosti) hry
 *
 * Tato třída je součástí jednoduché textové hry.
 *
 * "Prostor" reprezentuje jedno místo (místnost, prostor, ..) ve scénáři hry.
 * Prostor může mít sousední prostory připojené přes východy. Pro každý východ
 * si prostor ukládá odkaz na sousedící prostor.
 *
 * @author Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova, Jan Kornienko
 * @version pro školní rok 2016/2017, upraveno 2024
 */
public class Prostor {

    private String nazev;
    private String popis;
    private Set<Prostor> vychody;   // obsahuje sousední místnosti
    private List<Vec> veci; // seznam věcí v prostoru
    private List<Postava> postavy; // seznam postav v prostoru
    private boolean zamceno;

    /**
     * Vytvoření prostoru se zadaným popisem, např. "kuchyň", "hala", "trávník
     * před domem"
     *
     * @param nazev nazev prostoru, jednoznačný identifikátor, jedno slovo nebo
     * víceslovný název bez mezer.
     * @param popis Popis prostoru.
     */
    public Prostor(String nazev, String popis) {
        this.nazev = nazev;
        this.popis = popis;
        zamceno = false;
        vychody = new HashSet<>();
        veci = new ArrayList<>();
        postavy = new ArrayList<>();
    }

    /**
     * Definuje východ z prostoru (sousední/vedlejsi prostor). Vzhledem k tomu,
     * že je použit Set pro uložení východů, může být sousední prostor uveden
     * pouze jednou (tj. nelze mít dvoje dveře do stejné sousední místnosti).
     * Druhé zadání stejného prostoru tiše přepíše předchozí zadání (neobjeví se
     * žádné chybové hlášení). Lze zadat též cestu ze do sebe sama.
     *
     * @param vedlejsi prostor, který sousedi s aktualnim prostorem.
     *
     */
    public void setVychod(Prostor vedlejsi) {
        vychody.add(vedlejsi);
    }

    /**
     * Metoda equals pro porovnání dvou prostorů. Překrývá se metoda equals ze
     * třídy Object. Dva prostory jsou shodné, pokud mají stejný název. Tato
     * metoda je důležitá z hlediska správného fungování seznamu východů (Set).
     *
     * Bližší popis metody equals je u třídy Object.
     *
     * @param o object, který se má porovnávat s aktuálním
     * @return hodnotu true, pokud má zadaný prostor stejný název, jinak false
     */
    @Override
    public boolean equals(Object o) {
        // porovnáváme zda se nejedná o dva odkazy na stejnou instanci
        if (this == o) {
            return true;
        }
        // porovnáváme jakého typu je parametr
        if (!(o instanceof Prostor)) {
            return false;    // pokud parametr není typu Prostor, vrátíme false
        }
        // přetypujeme parametr na typ Prostor
        Prostor druhy = (Prostor) o;

        //metoda equals třídy java.util.Objects porovná hodnoty obou názvů.
        //Vrátí true pro stejné názvy a i v případě, že jsou oba názvy null,
        //jinak vrátí false.

        return (java.util.Objects.equals(this.nazev, druhy.nazev));
    }

    /**
     * metoda hashCode vraci ciselny identifikator instance, ktery se pouziva
     * pro optimalizaci ukladani v dynamickych datovych strukturach. Pri
     * prekryti metody equals je potreba prekryt i metodu hashCode. Podrobny
     * popis pravidel pro vytvareni metody hashCode je u metody hashCode ve
     * tride Object
     */
    @Override
    public int hashCode() {
        int vysledek = 3;
        int hashNazvu = java.util.Objects.hashCode(this.nazev);
        vysledek = 37 * vysledek + hashNazvu;
        return vysledek;
    }


    /**
     * Vrací název prostoru (byl zadán při vytváření prostoru jako parametr
     * konstruktoru)
     *
     * @return název prostoru
     */
    public String getNazev() {
        return nazev;
    }

    /**
     * Vrací "dlouhý" popis prostoru, který může vypadat následovně: Jsi v
     * mistnosti/prostoru vstupni hala budovy VSE na Jiznim meste. vychody:
     * chodba bufet ucebna
     *
     * @return Dlouhý popis prostoru
     */
    public String dlouhyPopis() {
        return "Jsi v mistnosti/prostoru " + popis + ".\n"
                + popisVychodu();
    }

    /**
     * Vrací textový řetězec, který popisuje sousední východy, například:
     * "vychody: hala ".
     *
     * @return Popis východů - názvů sousedních prostorů
     */
    private String popisVychodu() {
        String vracenyText = "východy:";
        for (Prostor sousedni : vychody) {
            vracenyText += " " + sousedni.getNazev();
        }
        return vracenyText;
    }

    /**
     * Vrací prostor, který sousedí s aktuálním prostorem a jehož název je zadán
     * jako parametr. Pokud prostor s udaným jménem nesousedí s aktuálním
     * prostorem, vrací se hodnota null.
     *
     * @param nazevSouseda Jméno sousedního prostoru (východu)
     * @return Prostor, který se nachází za příslušným východem, nebo hodnota
     * null, pokud prostor zadaného jména není sousedem.
     */
    public Prostor vratSousedniProstor(String nazevSouseda) {
        List<Prostor>hledaneProstory =
                vychody.stream()
                        .filter(sousedni -> sousedni.getNazev().equals(nazevSouseda))
                        .collect(Collectors.toList());
        if(hledaneProstory.isEmpty()){
            return null;
        }
        else {
            return hledaneProstory.get(0);
        }
    }

    /**
     * Vrací kolekci obsahující prostory, se kterými tento prostor sousedí.
     * Takto získaný seznam sousedních prostor nelze upravovat (přidávat,
     * odebírat východy) protože z hlediska správného návrhu je to plně
     * záležitostí třídy Prostor.
     *
     * @return Nemodifikovatelná kolekce prostorů (východů), se kterými tento
     * prostor sousedí.
     */
    public Collection<Prostor> getVychody() {
        return Collections.unmodifiableCollection(vychody);
    }

    /**
     * Metoda pro zjištění, zda je věc v prostoru.
     * @param nazev název věci
     * @return true, pokud je věc v prostoru, jinak false
     */
    public boolean obsahujeVec(String nazev) {
        for (Vec vec : veci) {
            if (vec.getNazev().equalsIgnoreCase(nazev)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metoda pro přidání věci do prostoru.
     * @param vec věc k přidání
     */
    public void vlozVec(Vec vec) {
        veci.add(vec);
    }

    /**
     * Metoda pro odebrání věci z prostoru.
     * @param vec věc k odebrání
     */
    public void odeberVec(Vec vec) {
        if (this.obsahujeVec(vec.getNazev()) && vec.getPrenositelnost()) {
            veci.remove(vec);
            System.out.println("Věc " + vec.getNazev() + " byl/a odebrán z prostoru " + this.getNazev() + ".");
        } else if (!vec.getPrenositelnost()) {
            System.out.println("Předmět " + vec.getNazev() + " je nepřenositelný.");
        } else {
            System.out.println("Předmět " + vec.getNazev() + " není v tomto prostoru.");
        }
    }

    /**
     * Metoda pro získání věci z prostoru podle názvu.
     * @param nazev název věci
     * @return věc nalezená v prostoru, nebo null, pokud věc není v prostoru
     */
    public Vec getVec(String nazev) {
        for (Vec vec : veci) {
            if (vec.getNazev().equalsIgnoreCase(nazev)) {
                return vec;
            }
        }
        return null;
    }

    /**
     * Metoda pro získání všech věcí v prostoru.
     * @return seznam všech věcí v prostoru
     */
    public List<Vec> getVeci() {
        return veci;
    }

    /**
     * Kontroluje, zda postava se zadaným jménem existuje v seznamu.
     *
     * @param jmeno jméno postavy, kterou hledáte
     * @return true, pokud postava se zadaným jménem existuje, jinak false
     */
    public boolean obsahujePostavu(String jmeno) {
        for (Postava postava : postavy) {
            if (postava.getJmeno().equalsIgnoreCase(jmeno)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Přidá postavu do seznamu.
     *
     * @param postava postava, která má být přidána
     */
    public void vlozPostavu(Postava postava) {
        postavy.add(postava);
    }

    /**
     * Metoda pro odebrání postav z prostoru.
     * @param postava postava k odebrání
     */
    public void odeberPostavu(Postava postava) {
        if (this.obsahujePostavu(postava.getJmeno())) {
            postavy.remove(postava);
        } else {
            System.out.println("Postava " + postava.getJmeno() + " není v tomto prostoru.");
        }
    }

    /**
     * Získá postavu se zadaným jménem ze seznamu.
     *
     * @param jmeno jméno postavy, kterou chcete získat
     * @return postava se zadaným jménem nebo null, pokud nebyla nalezena
     */
    public Postava getPostava(String jmeno) {
        for (Postava postava : postavy) {
            if (postava.getJmeno().equalsIgnoreCase(jmeno)) {
                return postava;
            }
        }
        return null;
    }

    /**
     * Vrátí seznam všech postav.
     *
     * @return seznam všech postav
     */
    public List<Postava> getPostavy() {
        return postavy;
    }

    /**
     * Nastaví stav zámku.
     *
     * @param zamceno nový stav zámku, kde {@code true} znamená zamčeno a {@code false} znamená odemčeno
     */
    public void setZamceno(boolean zamceno) {
        this.zamceno = zamceno;
    }

    /**
     * Vrátí aktuální stav zámku.
     *
     * @return {@code true} pokud je zamčeno, {@code false} pokud je odemčeno
     */
    public boolean getZamceno() {
        return zamceno;
    }
}