package UI.Tekstikayttoliittyma;

/**
 * Komentotulkkikäyttöliittymä. Lähes kaikki komentotulkissa tapahtuva
 * keskusteku totetaan tässä luokssa. Luokka käyttää Lukija luokkaa käyttäjän
 * kanssa kommunikaatioon, muuta tämä sisältää pääosn kommunikaatioon vaaditusta
 * logiikasta.
 *
 * @author jarmo
 */
public class Tekstikayttoliittyma {

    /**
     * toteuttaa perus logiikan, joka vaaditaan tekstipohjaisen käyttöliittymän
     * alustamiseen. Lopuksi avaa komentotulkin.
     *
     */
    public Tekstikayttoliittyma() {
        komentotulkki();

    }

    /**
     * Komentotulkki perus käytöliittymä.
     */
    private void komentotulkki() {
        Lukija l = new Lukija();
        UI.ValiKommunikaatio uk = new UI.ValiKommunikaatio(false);
        int kohta = 0;
        boolean kysSuunta = true;
        while (true) {
            l.kerroString("Anna komento: komentoja ovat (q)lopeta,  (n)seuraava, (p)dellinen (r)andom, (l)ooginen, (a)seta suunta, (t)ilanne");
            String komento = l.kysyString();

            if (komento.equals("lopeta") || komento.equals("quit") || komento.equals("q")) {
                break;
            } else if (komento.equals("seuraava") || komento.equals("next") || komento.equals("n")) {
                boolean onnistui = uk.tarkastaVastaus(l.kysyString("Anna sanan \"" + uk.kysyNext(kysSuunta) + "\" vastine"));
                if (onnistui) {
                    l.kerroString("Oikein!");
                } else {
                    l.kerroString("Väärin");
                }
            } else if (komento.equals("edellinen") || komento.equals("previous") || komento.equals("p")) {
                uk.tarkastaVastaus(l.kysyString("Anna sanan \"" + uk.kysyEdellinen(kysSuunta) + "\" vastine"));
            } else if (komento.equals("random") || komento.equals("r")) {
                uk.tarkastaVastaus(l.kysyString("Anna sanan \"" + uk.kysyRandom(kysSuunta) + "\" vastine"));
            } else if (komento.equals("logiikka") || komento.equals("l")) {
                uk.tarkastaVastaus(l.kysyString("Anna sanan \"" + uk.kysyLooginen(kysSuunta) + "\" vastine"));
            } else if (komento.equals("a") || komento.equals("aseta suunta")) {
                kysSuunta = asetaSuunta(l);
            } else if (komento.equals("t") || komento.equals("tilanne")) {
                l.kerroString("Oikein: " + uk.getOikein() + "\nVäärin: " + uk.getVaarin() + "\nYhteensä: " + uk.getYhteensa());
            } else {
                System.out.println("Komentoa ei tunnistettu!");
            }
        }
    }

    /**
     * AsetaSuunta metodi, joka määrää kysymissuunnan, jos true, niin kysytään
     * sana -> vastine, jos false, niin vastine -> sana.
     *
     * @param lukija Lukija olio, jolla kysytään ja kerrotaan viestejä.
     *
     * @return ralautetaan true tai false, riippuen käyttäjän suuntavalinnasta.
     */
    private boolean asetaSuunta(Lukija lukija) {
        while (true) {
            int suunta = lukija.kysyInt("1) sana -> vastine\n"
                    + "2) vastine -> sana");
            if (suunta == 1) {
                return true;
            } else if (suunta == 2) {
                return false;
            }
            lukija.kerroString("Komentoa ei tunnistettu, yritä uudelleen!");
        }
    }
}
