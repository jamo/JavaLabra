package UI;

import UI.Tekstikayttoliittyma.Lukija;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import logiikka.KysSana;
import logiikka.LueTiedosto;
import logiikka.SanatTaulukkoon;

/**
 *
 * @author jarmo
 */
public class KyselyLogiikka {
    private UserActionsInterface ui;
    public String kysyttySana, kysytynSananVastine;
    private ArrayList<KysSana> a;
    private ArrayList<KysSana> jarstettyV;
    private Lukija lukijaOlio = new Lukija();
    private int kohta = 0, siirSuunta = 1;
    private boolean kysSuunta = true;

//    private HashMap<Integer, KysSana> h;
    /**
     * toteuttaa perus logiikan, joka vaaditaan tekstipohjaisen käyttöliittymän
     * alustamiseen. Lopuksi avaa komentotulkin.
     *
     * @param uui Interface, jolla viestit välittää.
     */
    public KyselyLogiikka(UserActionsInterface uui) {
        this.ui = uui;
        LueTiedosto l = new LueTiedosto();
        Scanner tiedLukija = l.lueTiedosto();
        SanatTaulukkoon st = new SanatTaulukkoon();
        a = st.lueSanat(tiedLukija);
        jarstettyV = a;
        System.out.println(a);
//        Lukija lukija = new Lukija();
//        komentotulkki(lukija);
    }

    public void setKohta(int luku) {
        this.kohta = luku;
    }

    public int getKohta() {
        return this.kohta;
    }

    public void setSiirSuunta(int suunta) {
        this.siirSuunta = suunta;
    }

    /**
     * Komentotulkki perus käytöliittymä,
     *
     *
     */
//    private void komentotulkki(UI.UserActionsInterface ui) {
//
//        int kohta = 0;
//
//        while (true) {
//            String komento = ui.kysyString("Anna komento: komentoja ovat (q)lopeta,  (n)seuraava, (p)edellinen (r)random");
////             = ui.kysyString();
//
//            if (komento.equals("lopeta") || komento.equals("quit") || komento.equals("q")) {
//                //lopetetaan
//                break;
//            } else if (komento.equals("seuraava") || komento.equals("next") || komento.equals("n")) {
//                //suoritetaan komento
////                kysySeuraava(kohta);
//                kohta = kysy(kohta, true, 1, ui);
//            } else if (komento.equals("edellinen") || komento.equals("previous") || komento.equals("p")) {
//                //suoritetaan komento
//                kohta = kysy(kohta, true, -1, ui);
//            } else if (komento.equals("random") || komento.equals("r")) {
//                //suoritetaan komento
//                random(ui);
//            } else if (komento.equals("logiikka") || komento.equals("l")) {
//                random(ui);
//            } else {
//                System.out.println("Komentoa ei tunnistettu!");
//            }
//        }
//    }
//    public void kysySeuraa(){
//        kysy(kohta, kysSuunta, siirSuunta, null );
//    }
//     public void kysyEdell(){
//        kysy(kohta, kysSuunta, siirSuunta, null );
//    }
    public void kysySana() {
        this.kohta = kysy(kohta, kysSuunta, siirSuunta, null);
    }

    public String getKysyttavaSana() {
        if (kysSuunta) {
            return a.get(kohta).getEka();
        } else {
            return a.get(kohta).getToka();
        }
    }

    /**
     * jos suunta on true on suunta sana -> vastine. Jos false, niin on suunta
     * Vastine -> sana 1 == eteenpäin -1 == taaksepäin ja 0 == pysy paikallaan
     *
     */
    private int kysy(int kohta, boolean kysySuunta, int siirSuunta, UI.UserActionsInterface ui) {
        String vastaus;


        if (siirSuunta == 1) {
            kohta = siirryEteenpain(kohta);
        } else if (siirSuunta == -1) {
            kohta = siirryEteenpain(kohta);
        }
        if (kysySuunta) {
            vastaus = ui.kysyString("Anna sanan: " + a.get(kohta).getEka() + " vastine");
            if (vastaus.equals(a.get(kohta).getToka())) {
                a.get(kohta).meniOikein();
                ui.kerroString("Oikein :D");
            } else {
                a.get(kohta).meniVaarin();
                ui.kerroString("Väärin :(");
            }
        } else {
            vastaus = ui.kysyString("Anna sanan: " + a.get(kohta).getToka() + " vastine");
            if (vastaus.equals(a.get(kohta).getEka())) {
                a.get(kohta).meniOikein();
                ui.kysyString("Oikein :D");
            } else {
                a.get(kohta).meniVaarin();
                ui.kerroString("Väärin :(");
            }
        }


        return kohta;
    }

    /**
     * asetetaan kysyttävä sana, ja kysytty sana haluttuihin muuttujiin, ja
     *
     * @param kysySuunta jos true, niin sana -> vastine, jos false vastine ->
     * sana
     * @param siirSuunta jos 1, kysytään seuraavasana.jos -1, niin silloin
     * kysytään kohdassaoleva sana
     *
     * @return
     */
    public int asetaKysymys(boolean kysySuunta, int siirSuunta) {
        String vastaus;

        if (siirSuunta == 1) {
            kohta = siirryEteenpain(kohta);
        } else if (siirSuunta == -1) {
            kohta = siirryEteenpain(kohta);
        }
        //aloitetaan kysyminen
        if (kysySuunta) {
            kysyttySana = a.get(kohta).getEka();
            kysytynSananVastine = a.get(kohta).getToka();
        } else {
            kysyttySana = a.get(kohta).getToka();
            kysytynSananVastine = a.get(kohta).getEka();
        }
        return kohta;
//        return 0;
    }

    public String tarkistaVastaus(String vastaus) {
        if (vastaus.equals(kysytynSananVastine)) {
            a.get(kohta).meniOikein();
            this.ilmoitaOnnistumisesta();
        } else {
            a.get(kohta).meniVaarin();
            this.ilmoitaVaainmenosta();
        }
        if (kysSuunta) {
        }

        return null;
    }

    public void ilmoitaOnnistumisesta(){
        
        
    }
     public void ilmoitaVaainmenosta(){
        
        
    }
    
    /**
     * Eteenpäin siirryttäessä huolehtii siitä, ettei ylitetä taulukon rajoja.
     *
     */
    private int siirryEteenpain(int kohtaNyt) {
        if (kohtaNyt >= a.size() - 1) {
            return 0;
        } else {
            return kohtaNyt + 1;
        }
    }

    /**
     * Taakseppäin siirryttäessä huolehtii siitä, ettei ylitetä taulukon rajoja.
     *
     */
    private int siirryTaaksipain(int kohta) {
        if (kohta <= 0) {
            return a.size() - 1;
        } else {
            return kohta - 1;
        }
    }

    /**
     * Kertoo, mahtuuko eteenpäin siirtymään
     *
     */
    private boolean mahtuukoEteenpain(int kohta) {
        if (kohta + 1 < a.size()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Kertoo, mahtuuko taakseppäin siirtymään
     *
     */
    private boolean mahtuukoTaaksepain(int kohta) {
        if (kohta - 1 >= 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * arpoo satunnaisen kohdan ja kutsuu kysy metodia, ja palauttaa metodin
     * paluuarvon. Tämä kutsuu methodia siirtymään eteenpäin.
     *
     */
    private int kysyRandomVastineeseen(UI.UserActionsInterface ui) {
        Random r = new Random();
        return kysy(r.nextInt(a.size()), true, 0, ui);
    }

    /**
     * arpoo satunnaisen kohdan ja kutsuu kysy metodia, ja palauttaa metodin
     * paluuarvon. Tämä kutsu metodia siirtymään taakseppäin
     *
     */
    private int kysyRandomKohteeseen(UI.UserActionsInterface ui) {
        Random r = new Random();
        return kysy(r.nextInt(a.size()), false, 0, ui);
    }

    /**
     * Kun halutaan random, tulee suunta valita - tämä hoitaa sen.
     *
     * @return palauttaa int arvon joka on kyseinen kohta.
     *
     */
    private int random(UI.UserActionsInterface ui) {
        int suunta = lukijaOlio.kysyInt("Valitse suunta: \n1: sana -> vastine\n2:vastine -> sana");
        if (suunta == 2) {
            return kysyRandomKohteeseen(ui);
        } else {
            return kysyRandomVastineeseen(ui);
        }
    }

    /**
     * Not yet included
     *
     * @return
     *
     */
    private int logiikka(UI.UserActionsInterface ui) {
        virheitaEniten(); //sorttaa jarjestettyV taulukon, jotta sitä voidaan kysellä.
        String suunta = ui.kysyString("Anna suunta: \n1 = sana => vastine\n2 vastine => sana");
        if (suunta.equals("2")) {
            return alunPainotus(false, ui);
        } else {
            return alunPainotus(true, ui);
        }


//        return -1;
    }

    /**
     *
     * @return
     *
     */
    private void virheitaEniten() {
        Collections.sort(jarstettyV);
    }

    /**
     * Jos suunta == true, silloin kyselään sana => vastine
     * Jos suunta == flase, silloin kysellaan vastine => sana
     *
     * @return
     *
     */
    private int alunPainotus(boolean suunta, UI.UserActionsInterface ui) {
        Random r = new Random();
        double rajaRadom = Math.random();
        int koko = a.size();
        int raja = 0;
        double randomi = r.nextDouble() * koko + 1;
        for (int i = 0; i < jarstettyV.size(); i++) {
            if (jarstettyV.get(i).painoArvo() < 0) {
                raja = i;
                i = jarstettyV.size();
            }
        }
        if (rajaRadom <= (double) 2 / 3) {
            r.nextInt(raja);
            return kysy(r.nextInt(raja + 1), suunta, 1, ui);
            //eli nyt tänne kyselemään väärin menneitä;
        } else {
            return kysy(r.nextInt(jarstettyV.size()), suunta, 1, ui);
            //eli tänne kyselemään oikeinmenneitä
        }

    }
}