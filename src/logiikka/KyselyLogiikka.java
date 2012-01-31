package logiikka;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 * Luokka, johon on koottu kyselyn tarvittava logiikka. Ei köytetä suoraan, vaan
 * välikappaleen avulla.
 *
 * @author jarmo
 */
public class KyselyLogiikka {

    private String kysyttySana, kysytynSananVastine;
    private ArrayList<KysSana> kyselyLista;
    private ArrayList<KysSana> virheidenMukJarjLista;
    private int kohta = 0, siirSuunta = 1;
    private boolean kysSuunta = true;
    private int oikein = 0, vaarin = 0;

    /**
     * Luo tiedoston lukijan, ja lukee sanat taulukkoon.
     *
     * @param tiedostonLukija se,mistä sanat taulukkoon luetaan, voi olla joko
     * System.in, tai file oliosta luotu scanner.
     */
    public KyselyLogiikka(Scanner tiedostonLukija) {
        Scanner tiedLukija = tiedostonLukija;
        SanatTaulukkoon st = new SanatTaulukkoon();
        kyselyLista = st.lueSanat(tiedLukija);
        virheidenMukJarjLista = kyselyLista;
        System.out.println(virheidenMukJarjLista);
        System.out.println(kyselyLista);
        kohta = kyselyLista.size();
    }

    /**
     * Jos suunta on 1, niin siirrytään taulukossa seuraavaan, jos 0, niin
     * pysytään paikallaaj ja jos -1, niin siittytään yksi taakseppäin.
     *
     * @param suunta 1, 0 tai -1
     */
    public void setSiirSuunta(int suunta) {
        this.siirSuunta = suunta;
    }

    /**
     * Palauttaa kysyttävän sanan
     *
     * @return Kysytty sana
     */
    public String getKysyttavaSana() {
        if (kysSuunta) {
            return kyselyLista.get(kohta).getEka();
        } else {
            return kyselyLista.get(kohta).getToka();
        }
    }

    /**
     * Palauttaa kysytyn sanan vastauksen
     *
     * @return palauttaa vastauksen
     */
    public String getVastaus() {
        if (!kysSuunta) {
            return kyselyLista.get(kohta).getEka();
        } else {
            return kyselyLista.get(kohta).getToka();
        }
    }

//   
    /**
     * Asetetaan kysyttävä sana ja sille vastine sanan oikeellisuuden
     * tarkastamista varten.
     *
     * @param kysyttavatSanat arraylist, josta sana haetaan, sanojen
     * järjestyksen vuoksi.
     * @param kysySuunta      jos true, nii sana -> vastine, muutoin vastine ->
     * sana
     * @param siirSuunta      jos 1 kysytään seuraava, jos -1 kysytään
     * edellinen, jos
     * muu, kysytään kohdassa oleva sana.
     *
     * @return palautetaan kysytty sana
     */
    public String asetaKysymys(ArrayList<KysSana> kysyttavatSanat, boolean kysySuunta, int siirSuunta) {

//        System.out.println("Kyssuunta");
        if (siirSuunta == 1) {
            kohta = siirryEteenpain(kohta);
        } else if (siirSuunta == -1) {
            kohta = siirryTaaksipain(kohta);
        }
        //aloitetaan kysyminen
        if (kysySuunta) {
//            System.out.println("Kyssuunta = true");
            kysyttySana = kysyttavatSanat.get(kohta).getEka();
            kysytynSananVastine = kysyttavatSanat.get(kohta).getToka();
            return kysyttySana;
        } else {
//            System.out.println("Kysssuunta = false");
            kysyttySana = kysyttavatSanat.get(kohta).getToka();
            kysytynSananVastine = kysyttavatSanat.get(kohta).getEka();
            return kysyttySana;
        }
    }

    /**
     * Tarkistaa vastauksen kysytylle sanalle.
     *
     * @param vastaus tarkastettava sana "vastaus kanditaatti"
     *
     * @return true, jos on oikein, muuten false
     */
    public boolean tarkistaVastaus(String vastaus) {
        if (vastaus.equals(kysytynSananVastine)) {
            kyselyLista.get(kohta).meniOikein();
            oikein++;
            return true;
        } else {
            kyselyLista.get(kohta).meniVaarin();
            vaarin++;
            return false;
        }
    }

    /**
     * Eteenpäin siirryttäessä huolehtii siitä, ettei ylitetä taulukon rajoja.
     *
     * @param kohtaNyt kohta jossa ollaan parhaillaan
     *
     * @return uusi kohta.
     */
    private int siirryEteenpain(int kohtaNyt) {
        if (kohtaNyt >= kyselyLista.size() - 1) {
            return 0;
        } else {
            return kohtaNyt + 1;
        }
    }

    /**
     * Taakseppäin siirryttäessä huolehtii siitä, ettei ylitetä taulukon rajoja.
     *
     * @param kohtaNyt kohta, jossa ollaan parhaillaan
     *
     * @return uuden kohdan
     */
    private int siirryTaaksipain(int kohtaNyt) {
        if (kohtaNyt <= 0) {
            return kyselyLista.size() - 1;
        } else {
            return kohtaNyt - 1;
        }
    }

    /**
     * Kertoo, mahtuuko eteenpäin siirtymään
     *
     * @param kohta sijainti, jossa ollaan nyt
     *
     * @return true, jos mahtuu etenpäin, false, jos taulukon lopussa
     */
    private boolean mahtuukoEteenpain(int kohta) {
        if (kohta + 1 < kyselyLista.size()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Kertoo, mahtuuko taakseppäin siirtymään
     *
     * @param kohta kohta, jossa juuri nyt ollaan
     *
     * @return truen jos mahtuu siirtymään, false, jos tulukon alussa.
     */
    private boolean mahtuukoTaaksepain(int kohta) {
        if (kohta - 1 >= 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Arpoo satunnaisen kohdan ja kutsuu metodia AsetaKysymys, ja antaa sille
     * kohdaksi satunnaisen kohdan taulukosta.
     * Kysymis suunta, sana -> vastine
     *
     * @return Kysytyn sanan, joka on saatu AsetaSeuraava metodilla
     */
    private String kysyRandomVastineeseen() {
        Random r = new Random();
        kohta = r.nextInt(kyselyLista.size());
        return asetaKysymys(kyselyLista, true, 0);
    }

    /**
     * Arpoo satunnaoisen sijainnin taulukosta, ja kutsuu metodia AsetaKysymys
     * sillä.
     * Kysymissuunta vastine -> sana
     *
     * @return AsetaSana -metodin palauttama kysymis sana.
     */
    private String kysyRandomKohteeseen() {
        Random r = new Random();
        kohta = r.nextInt(kyselyLista.size());
        return asetaKysymys(kyselyLista, false, 0);
    }

    /**
     * Kun halutaan random, tulee suunta valita - tämä hoitaa sen.
     *
     * @param suunta true, jos kysytään sana -> vastine flase, jos vastine ->
     * sana
     *
     * @return palauttaa Aseta metodin antaman kysymys merkkijonon.
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
     */
    private void jarjestaVirheidenMukaan() {
//        virheidenMukJarjLista = getA()
        System.out.println(virheidenMukJarjLista);;
        Collections.sort(virheidenMukJarjLista);
    }

    /**
     * Painottaa alussa olevia sanoja, eli siis sanoja, joissa on eniten
     * virheitä.
     *
     * @param suunta true, niin sana -> vastine, false, niin vastine -> sana
     *
     * @return alunperin AsetaSana metodista saadun kysymys sanan
     *
     */
    public String alunPainotus(boolean suunta) {
        jarjestaVirheidenMukaan(); //Sortataan listaa
        Random r = new Random();
        
        double rajaRadom = Math.random();
        int koko = kyselyLista.size();
        int raja = 0;
        double randomi = r.nextDouble() * koko + 1;
        for (int i = 0; i < virheidenMukJarjLista.size(); i++) {
            if (virheidenMukJarjLista.get(i).painoArvo() < 0) {
                raja = i;
                i = virheidenMukJarjLista.size();
            }
        }
        if (raja <= 0 && virheidenMukJarjLista.size() > 1) {
            raja = virheidenMukJarjLista.size() / 2;
        }
        if (raja <= 1) {
            kohta = 0;
            return asetaKysymys(virheidenMukJarjLista, kysSuunta, 0);
        }

        if (rajaRadom <= (double) 2 / 3) {

            kohta = r.nextInt(raja);
            return asetaKysymys(virheidenMukJarjLista, suunta, 0);
//            return kysy(r.nextInt(raja + 1), suunta, 1);
            //eli nyt tänne kyselemään väärin menneitä;
        } else {
            kohta = r.nextInt(virheidenMukJarjLista.size());
            return asetaKysymys(virheidenMukJarjLista, suunta, 0);
//            return kysy(r.nextInt(jarstettyV.size()), suunta, 1);
            //eli tänne kyselemään oikeinmenneitä
        }


    }

    /**
     * Kertoo, montako arvausta on mennyt väärin
     *
     * @return väärin menneiden lkm
     */
    public int getVaarin() {
        return vaarin;
    }

    /**
     * Kertoo, montako arvausta on mennyt oikein
     *
     * @return oikein menneiden lkm
     */
    public int getOikein() {
        return oikein;
    }

    /**
     * Kertoo, montako arvausta on tehty
     *
     * @return tehtyjen arvausten määrän tarkastus
     */
    public int getYhteensa() {
        return vaarin + oikein;
    }

    /**
     * Palauttaa kyselyssä käytetyn arrayListin, pääosin testausta varten.
     *
     * @return arraylistin
     */
    public ArrayList getA() {
        return kyselyLista;
    }
}