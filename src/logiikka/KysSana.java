package logiikka;

/**
 * KysSana luokka, joka sisöltää sanaparit joihin säilötään sana ja vastine.
 * Sanat tietävät siis vastineensa ja mukana kulkee tieto siitä, montko kertaa
 * käännös on onnistunut jä epäonnitunut
 *
 * @author jarmo
 */
public class KysSana implements Comparable<KysSana> {

    private String eka, toka;//päädytty, että tämä on yhä kuvaavin tapa eritellä sanat.
    private int vaarin = 0, oikein = 0;

    /**
     * Oletus konstruktori, joka on parametritön. Tarvitaan testejä varten. JA
     * koska on kuormitettu on tänkin ihan hyvä olla.
     */
    public KysSana() {
    }

    /**
     * Konstruktori, jolla parametrina sanapari. Tämä asettaa ne luokan private
     * muuttujiin.
     *
     * @param eka  itse sana
     * @param toka sanan vastine
     */
    public KysSana(String eka, String toka) {
        this.eka = eka;
        this.toka = toka;
    }

    /**
     *
     * Asettaa sanan. Palauttaa true, jos onnistuu.
     *
     * @param sana asetettava sana, mene private muuttujaan eka
     *
     * @return palauttaa true merkiksi onnistumisesta
     */
    public boolean setEka(String sana) {
        this.eka = sana;
        return true;
    }

    /**
     * Asettaa sanan vastineen. Palauttaa true, jos onnistuu (ei nyt osaa
     * palauttaa false.)
     *
     * @param sana asetettava sana, menee sanan vastineeksi
     *
     * @return palauttaa true merkiksi onnistumisesta
     */
    public boolean setToka(String sana) {
        this.toka = sana;
        return true;
    }

    /**
     * Palauttaa itse sanan arvon
     *
     * @return palauttaa sanan String merkkijonona
     */
    public String getEka() {
        return eka;
    }

    /**
     * Palauttaa sanan Vastineen arvon
     *
     * @return sanan vastineen String merkkijonona
     */
    public String getToka() {
        return this.toka;
    }

    /**
     * Palauttaa oikeinmenneiden käännösten lukumäärän
     *
     * @return Palauttaa oikein menneiden kääeenösten arvon
     */
    public int getOikein() {
        return this.oikein;
    }

    /**
     * Palauttaa väärinmenneiden käännösten lukumäärän
     *
     * @return palauttaa väärin menneiden käännösten arvon
     */
    public int getVaarin() {
        return this.vaarin;
    }

    /**
     * Kasvattaa oikeinmenneden määrää yhdellä ja palauttaa onnistuessaan true
     *
     * @return palauttaa true merkiksi onnistumisesta
     */
    public boolean meniOikein() {
        oikein++;
        return true;
    }

    /**
     * Kasvattaa väärinmenneden määrää yhdellä ja palauttaa onnistuessaan true
     *
     * @return palauttaa true merkiksi onnistumisesta
     */
    public boolean meniVaarin() {
        vaarin++;
        return true;
    }

    /**
     * Palauttaa formatoidun toString tekstin.
     *
     * @return toString merkkijonoesityksen.
     */
    @Override
    public String toString() {
        return "\nSana: " + eka + " || Vastine: " + toka;
    }

    /**
     * KysSana olioiden vertaulun vuoksi on laskettava sanalla painoarvo, joka
     *
     * @return palauttaa lasketun painoarvon jokaiselle sanalle.
     *
     */
    public double painoArvo() {
        double v = this.getVaarin();
        double o = this.getOikein();
        double painoArv = 5 * v + o;
        return painoArv;
    }

    /**
     * compareTo KysSana olioiden vertailun vuoksi
     *
     * @param verrattava verrattava ilmentymä
     *
     * @return palauttaa arvon , >0 jos this omaa suuremman painooarvon, 0 jos
     * sama ja <0 jos this omaa pienemmän painoarvon
     */
    @Override
    public int compareTo(KysSana verrattava) {
        return (int) (this.painoArvo() - verrattava.painoArvo());

    }
}