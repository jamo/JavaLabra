package UI.Tekstikayttoliittyma;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import logiikka.KysSana;
import logiikka.LueTiedosto;
import logiikka.SanatTaulukkoon;

public class Tekstikayttoliittyma {

    private ArrayList<KysSana> a;
    private ArrayList<KysSana> jarstettyV;
    private Lukija lukijaOlio = new Lukija();
//    private HashMap<Integer, KysSana> h;

    /**
     * toteuttaa perus logiikan, joka vaaditaan tekstipohjaisen käyttöliittymän
     * alustamiseen. Lopuksi avaa komentotulkin.
     **/
    public Tekstikayttoliittyma() {
//        h = new HashMap<a.get()
        LueTiedosto l = new LueTiedosto();
        Scanner tiedLukija = l.LueTiedosto();
        SanatTaulukkoon st = new SanatTaulukkoon();
        a = st.lueSanat(tiedLukija);
        jarstettyV = a;
        System.out.println(a);
        komentotulkki();
    }

    /**
     *
     * komentotulkki jotain
     **/
    private void komentotulkki() {

        int kohta = 0;
        Scanner luk = new Scanner(System.in);
        while (true) {
            System.out.println("Anna komento: komentoja ovat (q)lopeta,  (n)seuraava, (p)edellinen (r)random");
            String komento = luk.nextLine();

            if (komento.equals("lopeta") || komento.equals("quit") || komento.equals("q")) {
                //lopetetaan
                break;
            } else if (komento.equals("seuraava") || komento.equals("next") || komento.equals("n")) {
                //suoritetaan komento
//                kysySeuraava(kohta);
                kohta = kysy(kohta,true, 1);
            } else if (komento.equals("edellinen") || komento.equals("previous") || komento.equals("p")) {
                //suoritetaan komento
                kohta = kysy(kohta,true, -1);
            } else if (komento.equals("random") || komento.equals("r")) {
                //suoritetaan komento
                random();
            } else if (komento.equals("logiikka")) {
            } else {
                System.out.println("Komentoa ei tunnistettu!");
            }
        }
    }

    /**
     * jos suunta on true on suunta sana -> vastine. Jos false, niin on suunta
     * Vastine -> sana
     * 1 == eteenpäin -1 == taaksepäin ja 0 == pysy paikallaan
     **/
    private int kysy(int kohta, boolean kysySuunta ,int siirSuunta) {
        String vastaus;


        if (siirSuunta == 1) {
            kohta = siirryEteenpain(kohta);
        }

        if (siirSuunta == -1) {
            kohta = siirryEteenpain(kohta);
        }


        if (kysySuunta) {
            vastaus = lukijaOlio.kysyString("Anna sanan: " + a.get(kohta).getEka() + " vastine");
            if (vastaus.equals(a.get(kohta).getToka())) {
                a.get(kohta).meniOikein();
                System.out.println("Oikein :D");
            } else {
                a.get(kohta).meniVaarin();
                System.out.println("Väärin :(");
            }
        } else {
            vastaus = lukijaOlio.kysyString("Anna sanan: " + a.get(kohta).getToka() + " vastine");
            if (vastaus.equals(a.get(kohta).getEka())) {
                a.get(kohta).meniOikein();
                System.out.println("Oikein :D");
            } else {
                a.get(kohta).meniVaarin();
                System.out.println("Väärin :(");
            }
        }


        return kohta;
    }

    /**
     * Eteenpäin siirryttäessä huolehtii siitä, ettei ylitetä taulukon rajoja.
     **/
    private int siirryEteenpain(int kohtaNyt) {
        if (kohtaNyt >= a.size() - 1) {
            return 0;
        } else {
            return kohtaNyt + 1;
        }
    }

    /**
     * Taakseppäin siirryttäessä huolehtii siitä, ettei ylitetä taulukon rajoja.
     **/
    private int siirryTaaksipain(int kohta) {
        if (kohta <= 0) {
            return a.size() - 1;
        } else {
            return kohta - 1;
        }
    }

    /**
     * Kertoo, mahtuuko eteenpäin siirtymään
     **/
    private boolean mahtuukoEteenpain(int kohta) {
        if (kohta + 1 < a.size()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Kertoo, mahtuuko taakseppäin siirtymään
     **/
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
     **/
    private int kysyRandomVastineeseen() {
        Random r = new Random();
        return kysy(r.nextInt(a.size()), true, 0);
    }

    /**
     * arpoo satunnaisen kohdan ja kutsuu kysy metodia, ja palauttaa metodin
     * paluuarvon. Tämä kutsu metodia siirtymään taakseppäin
     **/
    private int kysyRandomKohteeseen() {
        Random r = new Random();
        return kysy(r.nextInt(a.size()), false, 0);
    }

    /**
     * Kun halutaan random, tulee suunta valita - tämä hoitaa sen.
     * 
     * @return palauttaa int arvon joka on kyseinen kohta. 
     **/
    private int random() {
        int suunta = lukijaOlio.kysyInt("Valitse suunta: \n1: sana -> vastine\n2:vastine -> sana");
        if (suunta == 2) {
            return kysyRandomKohteeseen();
        } else {
            return kysyRandomVastineeseen();
        }
    }

    /**
     * Not yet included
     * @return 
     **/
    private int logiikka() {


        return -1;
    }
 /**
  * 
  * @return 
  **/
    private  int virheitaEniten() {
        Collections.sort(jarstettyV);
        Random r = new Random();
        return kysy(r.nextInt(jarstettyV.size()), true, 0);
        
        
//        return 0;
    }
    
    /**
     * 
     * @return 
     **/
    private int alunPainotus(){
        Random r = new Random();
        int koko = a.size();
        double randomi = r.nextDouble()*koko+1;
        if (randomi > koko /2){
            //otetaan loppu listasta
        } else{
            //otetaan alku listasta, tänne siis haluttiin
        }
        
        
        return 0;
    }
    
}
