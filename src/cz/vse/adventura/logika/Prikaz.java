package cz.vse.adventura.logika;

/**
 *  Abstraktní třída Prikaz představuje základní strukturu pro všechny příkazy ve hře.
 *  Tato třída je součástí jednoduché textové hry.
 *  Příklad dědičnosti podle požadavků domácího úkolu
 *
 * @author     Jan Kornienko
 * @version    pro LS 2023/2024
 */
public abstract class Prikaz implements IPrikaz {
    private final String nazev;

    /**
     *  Konstruktor třídy
     *
     *  @param nazev název příkazu
     */
    public Prikaz(String nazev) {
        this.nazev = nazev;
    }

    /**
     *  Metoda vrací název příkazu (slovo, které používá hráč pro jeho vyvolání).
     *
     *  @return název příkazu
     */
    @Override
    public String getNazev() {
        return nazev;
    }

    /**
     *  Abstraktní metoda pro provedení příkazu.
     *
     *  @param parametry parametry příkazu
     *  @return zpráva, kterou vypíše hra hráči
     */
    @Override
    public abstract String provedPrikaz(String... parametry);
}
