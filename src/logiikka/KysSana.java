package logiikka;

public class KysSana implements Comparable<KysSana> {

    private String eka, toka;
    private int vaarin = 0, oikein = 0;

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
     * Tyhjä oletus konstruktori
     */
    public KysSana() {
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
        eka = sana;
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
        toka = sana;
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
        return toka;
    }

    /**
     * Palauttaa oikeinmenneiden käännösten lukumäärän
     *
     * @return Palauttaa oikein menneiden kääeenösten arvon
     */
    public int getOikein() {
        return oikein;
    }

    /**
     * Palauttaa väärinmenneiden käännösten lukumäärän
     *
     * @return palauttaa väärin menneiden käännösten arvon
     */
    public int getVaarin() {
        return vaarin;
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
    private double painoArvo() {
        double v = this.getVaarin();
        double o = this.getOikein();
//        double ka = 
        double painoArv = 5 * v + o;
//                (10*v+1*o)*Math.log((o+v)/o);
        return painoArv;
    }
//            = new HashMap<String, Integer>();

    /**
     * compareTo KysSana olioiden vertailun vuoksi
     *
     * @param verrattavaComp verrattava ilmentymä
     *
     * @return palauttaa arvon , >0 jos this omaa suuremman painooarvon, 0 jos
     *         sama ja <0 jos this omaa pienemmän painoarvon
     */
    @Override
    public int compareTo(KysSana verrattavaComp) {
        return (int) (this.painoArvo() - verrattavaComp.painoArvo());


//        throw new UnsupportedOperationException("Not supported yet.");
    }
}
//11:41:43 <@Jamo_> EKK: Paikalla?
//11:52:41 <@EKK> Jep
//11:53:49 <@Jamo_> hei hyvä, mul ois yks kysymys.
//11:54:02 <@Jamo_> eli mä teen tota javalabraa.
//11:54:33 <@EKK> jees kysy pois
//11:54:49 <@Jamo_> kyl tää kysymys kohta tulee, se on vaan pitkä.
//11:55:31 <@EKK> :)
//11:55:50 <@Jamo_> eli siis mul on olemas arraylist<kysSana> olemassa, ja voin helposti tolla käydä läpi sen listan ja kysellä kumpaan suuntaan tahansa sanoja.
//11:56:15 <@Jamo_> mutta sit haluisin saada sen jotenki sorttaamaan ton oikein ja väärin menneiden sanojen mukaan.
//11:56:22 <@Jamo_> laitan paln koodii pastebiniin.
//11:57:04 <@Jamo_> http://pastebin.com/PvFWvv8N
//11:57:06 < Hunsbotti> [Java] joo - Pastebin.com
//11:57:29 <@Jamo_> toi on se hashMap korvikkeeni, jost saan sanan ja vastikkeen sille.
//11:57:51 <@Jamo_> en tiedä, et kuinka kannattavasti toi on tehty, mut se toimii :D
//11:58:07 <@EKK> Eli siis eli siis, haluat tuon ArrayListi<kysSana> järjestykseen esimerkiksi niin että ensin väärin menneet ja sitten oikein menneet?
//11:58:32 <@Jamo_> joo, ja viel sillee, et eniten virheit olevat ois ekana.
//11:58:44 <@Jamo_> eli sorttaa sen virheiden määrän avulle.
//11:58:54 <@Jamo_> koska oikeinmenneitä ei kannata kysellä.
//11:59:01 <@EKK> Aaah, I see
//11:59:12 <@Jamo_> mut sit en haluis sorttaa tota, vaan luoda esim. kopion tosta.
//11:59:31 <@EKK> Oukkei
//11:59:35 <@Jamo_> eli sit vois edelleen kysellä niin siin järjestykses ku miten listassa oli alunperin
//11:59:54 <@EKK> Eli jokainen sana tietää montako kertaa se on mennyt oikein ja montako kertaa väärin
//11:59:58 <@Jamo_> joo
//12:00:03 <@EKK> I see
//12:00:03 <@EKK> Okei
//12:00:33 <@EKK> Sun kannattaa tehdä KysSanasta Comparable<KysSana>
//12:00:43 <@EKK> (luokkien nimet kirjoitetaan muuten yleensä isolla :)
//12:01:02 <@Jamo_> joo, pitää se joskus korjaa :D muut luokat on isol...
//12:01:12 <@EKK> Right-click -> refactor :)
//12:01:21 <@Jamo_> joo
//12:01:22 <@Jamo_> :D
//12:02:33 <@EKK> Sitten compareTo-metodiin pistät jonkun laskutoimituksen joka laskee sanan painoarvon, esim niin että jokainen oikeinmeno laskee sitä 10:llä pisteellä ja väärinmeno nostaa yhdellä
//12:02:45 <@EKK> Ja compareet niitä näiden painoarvojen mukaan
//12:02:59 <@EKK> Sitten kun toi on kunnossa, itse listaan
//12:03:34 <@Jamo_> hmm ajattelin eka et se vertais niit vaan virheiden mukaan, mut siihen vois tunkee enemmän logiikkaa.
//12:03:38 <@EKK> Luo uusi ArrayList<KysSana> , anna konstruktorin parametriksi vanha arrayList
//12:03:55 <@EKK> Mutta jos se sana menee kerrankin oikein sitä ei välttämättä haluta kysyä heti uudelleen :)
//12:04:23 <@EKK> Collections.sort(uusiArrayList);
//12:04:35 <@Jamo_> jep
//12:04:37 <@EKK> Ja sitten teet jonkun satunnaishärpäkkeen joka suosii listan alkupäätä
//12:04:46 <@EKK> Oliko tarpeeksi vaikea? :)
