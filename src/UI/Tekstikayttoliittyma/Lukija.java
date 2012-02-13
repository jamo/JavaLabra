package UI.Tekstikayttoliittyma;

import java.util.Scanner;

/**
 * Luokka, joka totetuuaa kaiken kommunikaation komentotulkkikäyttöliittymässä.
 *
 * @author jarmo
 */
public class Lukija {

    private Scanner kaytLukija = new Scanner(System.in);


    /**
     * Näytetään viesti ja kysytään String merkkijono.
     *
     * @param  viesti viestiNäytettävä
     *
     * @return luettu tieto
     */
    public String kysyString(String viesti) {
        System.out.println(viesti);
        return getL().nextLine();
    }

    /**
     * Näytetään viesti ja kysytään int luku.
     *
     * @param viesti Näytettävä viesti
     *
     * @return Palautetaa luettu luku
     */
    public int kysyInt(String viesti) {
        try {
            System.out.println(viesti);
            return Integer.parseInt(getL().nextLine());
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * Tulostaa käyttäjälle parametrinä annetun viestin
     *
     * @param viesti tulostettava teksti
     */
    public void kerroString(String viesti) {
        System.out.println(viesti);
    }

    /**
     * Kysyy käyttäjältä String merkkijonon, ilman viestiä.
     *
     * @return palauttaa käyttäjän syöttämän tekstirivin.
     */
    public String kysyString() {
        return getL().nextLine();
    }

    /**
     * @return palauttaa lukijan
     */
    public Scanner getL() {
        return kaytLukija;
    }
}
