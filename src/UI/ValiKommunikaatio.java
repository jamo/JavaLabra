package UI;

import logiikka.KyselyLogiikka;
import logiikka.ValitseTiedosto;

/**
 * Guille kommunikaatiorajapinta kyselylogiikalle
 *
 * @author jarmo
 */
public class ValiKommunikaatio {

    private ValitseTiedosto gl;
    private KyselyLogiikka k;

//private KyselyLogiikka k;
//
    // konstruktori tekstikäytöliittymää varten
    public ValiKommunikaatio() {
        logiikka.ValitseTiedosto l = new logiikka.ValitseTiedosto();
        k = new KyselyLogiikka(l.lueTied());
    }

    /**
     * luodaan guiValiKommunikaatio, ja luetaan tiedoston
     * @param GUI jos true, niin graafinen, jos false, niin tekstipohjainen kysymys
     */
    public ValiKommunikaatio(boolean GUI) {
        if (GUI) {
            gl = new ValitseTiedosto();
            k = new KyselyLogiikka(gl.lueTiedostoGui());
        } else {
            logiikka.ValitseTiedosto l = new logiikka.ValitseTiedosto();
            k = new KyselyLogiikka(l.lueTied());
        }
    }

    /**
     * Luodaan GuiValiKommunikaatiosta uusi ilmentymä
     *
     * @param KyselyLogiikka Kyselylogiikka, testausta varten.
     */
    public ValiKommunikaatio(KyselyLogiikka KyselyLogiikka) {
        k = KyselyLogiikka;

    }

    /**
     * Kysytän seuraava sana
     *
     * @param kysSuunta true = sana -> vastine; false vastine -> sana
     *
     * @return palautetaan asetaKysymyksen antama kysyttävä sana.
     */
    public String kysyNext(boolean kysSuunta) {
        return k.asetaKysymys(k.getA(), kysSuunta, 1);
    }

    /**
     * Kysytän edellinen sana
     *
     * @param kysSuunta true = sana -> vastine; false vastine -> sana
     *
     * @return palautetaan asetaKysymyksen antama kysyttävä sana.
     */
    public String kysyEdellinen(boolean kysSuunta) {
        return k.asetaKysymys(k.getA(), kysSuunta, -1);
    }

    /**
     * Tarkistetaan menikö sana oikein
     *
     * @param sana Tarkistettava sana
     *
     * @return palautetaan true, jos vastaus oli oikein.
     */
    public boolean tarkastaVastaus(String sana) {
        return k.tarkistaVastaus(sana);
    }

    /**
     * Kysytän random sana
     *
     * @param kysSuunta true = sana -> vastine; false vastine -> sana
     *
     * @return palautetaan asetaKysymyksen antama kysyttävä sana.
     */
    public String kysyRandom(boolean kysSuunta) {
        return k.random(kysSuunta);
    }

    /**
     * Kysytän sana, joka on loogisesti oppimisen kannalta kannattava sana
     * kysyä.
     *
     * @param kysSuunta true = sana -> vastine; false vastine -> sana
     *
     * @return palautetaan asetaKysymyksen antama kysyttävä sana.
     */
    public String kysyLooginen(boolean kysSuunta) {
        return k.alunPainotus(kysSuunta);
    }
//TODO tässä 2 saman tekevää metodia!!!

    /**
     * Tarkistetaan menikö sana oikein
     *
     * @param sana Tarkistettava sana
     *
     * @return palautetaan true, jos vastaus oli oikein.
     */
    public boolean tarkSana(String sana) {
        return k.tarkistaVastaus(sana);
    }

    /**
     * Kertoo, moniko meni oikein
     *
     * @return oikein menneiden lkm
     */
    public int getOikein() {
        return k.getOikein();
    }

    /**
     * Kertoo, moniko meni väärin
     *
     * @return väärinmenneiden lkn
     */
    public int getVaarin() {
        return k.getVaarin();
    }

    /**
     * Kertoo, montako tarkistusyritystä on
     *
     * @return yhteensä arvattujen lkm
     */
    public int getYhteensa() {
        return k.getYhteensa();
    }

    /**
     * palauttaa kysytyn sanan
     *
     * @return kysytty saha
     */
    public String getKysytty() {
        return k.getKysyttavaSana();
    }

    /**
     * palauttaa vastauksen
     *
     * @return vastaus
     */
    public String getVastaus() {
        return k.getVastaus();
    }
}
