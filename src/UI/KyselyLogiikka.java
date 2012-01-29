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

    private String kysyttySana, kysytynSananVastine;
    private ArrayList<KysSana> a;
    private ArrayList<KysSana> jarstettyV;
//    private Lukija lukijaOlio = new Lukija();
    private int kohta = 0, siirSuunta = 1;
    private boolean kysSuunta = true;
    private int oikein = 0, vaarin = 0;

//    private HashMap<Integer, KysSana> h;
    /**
     * toteuttaa perus logiikan, joka vaaditaan tekstipohjaisen käyttöliittymän
     * alustamiseen. Lopuksi avaa komentotulkin.
     *
     */
    public KyselyLogiikka(Scanner tiedostonLukija) {

//        LueTiedosto l = new LueTiedosto();
//        Scanner tiedLukija = l.lueTied();
        Scanner tiedLukija = tiedostonLukija;
        SanatTaulukkoon st = new SanatTaulukkoon();
        a = st.lueSanat(tiedLukija);
        jarstettyV = a;
        System.out.println(jarstettyV);
        System.out.println(a);
        kohta = a.size();
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

    public String getKysyttavaSana() {
        if (kysSuunta) {
            return a.get(kohta).getEka();
        } else {
            return a.get(kohta).getToka();
        }
    }

//   
    
    /**
     * Asetetaan kysyttävä sana ja sille vastine sanan oikeellisuuden tarkastamista varten.
     * @param ar arraylist, josta sana haetaan, sanojen järjestyksen vuoksi.
     * @param kysySuunta jos true, nii sana -> vastine, muutoin vastine -> sana
     * @param siirSuunta jos 1 kysytään seuraava, jos -1  kysytään edellinen, jos muu, kysytään kohdassa oleva sana.
     * @return palautetaan kysytty sana
     */
    public String asetaKysymys(ArrayList<KysSana> ar, boolean kysySuunta, int siirSuunta) {
        
//        System.out.println("Kyssuunta");
        if (siirSuunta == 1) {
            kohta = siirryEteenpain(kohta);
        } else if (siirSuunta == -1) {
            kohta = siirryTaaksipain(kohta);
        }
        //aloitetaan kysyminen
        if (kysySuunta) {
            System.out.println("Kyssuunta = true");
            kysyttySana = ar.get(kohta).getEka();
            kysytynSananVastine = ar.get(kohta).getToka();
            return kysyttySana;
        } else {
            System.out.println("Kysssuunta = flse");
            kysyttySana = ar.get(kohta).getToka();
            kysytynSananVastine = ar.get(kohta).getEka();
            return kysyttySana;
        }
    }

    public boolean tarkistaVastaus(String vastaus) {
        if (vastaus.equals(kysytynSananVastine)) {
            a.get(kohta).meniOikein();
            oikein++;
            return true;
        } else {
            a.get(kohta).meniVaarin();
            vaarin++;
            return false;
        }
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
    private String kysyRandomVastineeseen() {
        Random r = new Random();
        kohta = r.nextInt(a.size());
        return asetaKysymys(a, true, 0);
    }

    /**
     * arpoo satunnaisen kohdan ja kutsuu kysy metodia, ja palauttaa metodin
     * paluuarvon. Tämä kutsu metodia siirtymään taakseppäin
     *
     */
    private String kysyRandomKohteeseen() {
        Random r = new Random();
        kohta = r.nextInt(a.size());
        return asetaKysymys(a, false, 0);
    }

    /**
     * Kun halutaan random, tulee suunta valita - tämä hoitaa sen.
     *
     * @param suunta
     *
     * @return palauttaa int arvon joka on kyseinen kohta.
     *
     */
    public String random(boolean suunta) {
        if (suunta) {
            return kysyRandomVastineeseen();
        } else {
            return kysyRandomKohteeseen();
        }
    }

    /**
     * Sorttaa arraylistn, jossa kysyttävät sanat.
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
    public String alunPainotus(boolean suunta) {
        virheitaEniten(); //Sortataan listaa
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
        if (raja <= 0 && jarstettyV.size() > 1) {
            raja = jarstettyV.size() / 2;
        }
        if (raja <= 1) {
            kohta = 0;
            return asetaKysymys(jarstettyV, kysSuunta, 0);
        }

        if (rajaRadom <= (double) 2 / 3) {

            kohta = r.nextInt(raja);
            return asetaKysymys(jarstettyV, suunta, 0);
//            return kysy(r.nextInt(raja + 1), suunta, 1);
            //eli nyt tänne kyselemään väärin menneitä;
        } else {
            kohta = r.nextInt(jarstettyV.size());
            return asetaKysymys(jarstettyV, suunta, 0);
//            return kysy(r.nextInt(jarstettyV.size()), suunta, 1);
            //eli tänne kyselemään oikeinmenneitä
        }


    }

    public int getVaarin() {
        return vaarin;
    }

    public int getOikein() {
        return oikein;
    }

    public int getYhteensa() {
        return vaarin + oikein;
    }

    public ArrayList getA() {
        return a;
    }
}