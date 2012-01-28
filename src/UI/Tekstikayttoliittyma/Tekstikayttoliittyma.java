package UI.Tekstikayttoliittyma;

import java.util.Scanner;

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
     * Komentotulkki perus käytöliittymä,
     *
     *
     */
    private void komentotulkki() {
//        UI.GUI.GuiValiKommunikaatio uk = new UI.GUI.GuiValiKommunikaatio();
        Lukija l = new Lukija();
        UI.Tekstikayttoliittyma.KomenotulkkiValiKommunikaatio uk = new UI.Tekstikayttoliittyma.KomenotulkkiValiKommunikaatio();
        int kohta = 0;
        Scanner luk = new Scanner(System.in);
        boolean kysSuunta = true;
        while (true) {
            System.out.println("Anna komento: komentoja ovat (q)lopeta,  (n)seuraava, (p)dellinen (r)andom, (l)ooginen, (a)seta suunta");
            String komento = luk.nextLine();
            
            if (komento.equals("lopeta") || komento.equals("quit") || komento.equals("q")) {
                break;
            } else if (komento.equals("seuraava") || komento.equals("next") || komento.equals("n")) {
                uk.tarkastaVastaus(l.kysyString("Anna sanan \"" + uk.kysyNext(kysSuunta) + "\" vastine"));
                
            } else if (komento.equals("edellinen") || komento.equals("previous") || komento.equals("p")) {
                uk.tarkastaVastaus(l.kysyString("Anna sanan \"" + uk.kysyEdellinen(kysSuunta) + "\" vastine"));
            } else if (komento.equals("random") || komento.equals("r")) {
                uk.tarkastaVastaus(l.kysyString("Anna sanan \"" + uk.kysyRandom(kysSuunta) + "\" vastine"));
            } else if (komento.equals("logiikka") || komento.equals("l")) {
                uk.tarkastaVastaus(l.kysyString("Anna sanan \"" + uk.kysyLooginen(kysSuunta) + "\" vastine"));
            } else if (komento.equals("a") || komento.equals("aseta suunta")) {
                kysSuunta = asetaSuunta(l);
            } else {
                System.out.println("Komentoa ei tunnistettu!");
            }
        }
    }
    
    private boolean asetaSuunta(Lukija l) {
        while (true) {
            int suunta = l.kysyInt("1) sana -> vastine\n"
                    + "2) vastine -> sana");
            if (suunta == 1) {
                return true;
            } else if (suunta == 2) {
                return false;
            }
            l.kerroString("Komentoa ei tunnistettu, yritä uudelleen!");
        }
    }
}
