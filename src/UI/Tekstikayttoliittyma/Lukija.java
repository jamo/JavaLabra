package UI.Tekstikayttoliittyma;

import java.util.Scanner;

public class Lukija {

    Scanner l = new Scanner(System.in);

    public Lukija() {
    }

    /**
     * Näytetään viesti ja kysytään String merkkijono.
     *
     * @param viesti
     *
     * @return
     */
    public String kysyString(String viesti) {
        System.out.println(viesti);
        return l.nextLine();
    }

    /**
     * Näytetään viesti ja kysytään int luku.
     *
     * @param viesti
     *
     * @return
     */
    public int kysyInt(String viesti) {
        try {
            System.out.println(viesti);
            return Integer.parseInt(l.nextLine());
        } catch (Exception e) {
            return -1;
        }
    }
}
