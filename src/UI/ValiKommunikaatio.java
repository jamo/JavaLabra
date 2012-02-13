package UI;

import logiikka.KyselyLogiikka;
import logiikka.ValitseTiedosto;

/**
 * Guille kommunikaatiorajapinta kyselylogiikalle
 *
 * @author jarmo
 */
public class ValiKommunikaatio {

    private ValitseTiedosto valitseTiedosto;
    private KyselyLogiikka kyselyLogiikka;

    /**
     * Luoka nkonstruktori, tämä laukaisee tiedoston lukemisen.
     */
    public ValiKommunikaatio() {
        logiikka.ValitseTiedosto tiedValitsin = new logiikka.ValitseTiedosto();
        kyselyLogiikka = new KyselyLogiikka(tiedValitsin.lueTied());
    }

    /**
     * luodaan guiValiKommunikaatio, ja luetaan tiedoston
     *
     * @param GUI jos true, niin graafinen, jos false, niin tekstipohjainen
     *            kysymys
     */
    public ValiKommunikaatio(boolean GUI) {
        if (GUI) {
            valitseTiedosto = new ValitseTiedosto();
            kyselyLogiikka = new KyselyLogiikka(valitseTiedosto.lueTiedostoGui());
        } else {
            logiikka.ValitseTiedosto l = new logiikka.ValitseTiedosto();
            kyselyLogiikka = new KyselyLogiikka(l.lueTied());
        }
    }

    /**
     * Luodaan GuiValiKommunikaatiosta uusi ilmentymä
     *
     * @param KyselyLogiikka Kyselylogiikka, testausta varten.
     */
    public ValiKommunikaatio(KyselyLogiikka KyselyLogiikka) {
        kyselyLogiikka = KyselyLogiikka;

    }

    /**
     * Kysytän seuraava sana
     *
     * @param kysymisSuunta true = sana -> vastine; false vastine -> sana
     *
     * @return palautetaan asetaKysymyksen antama kysyttävä sana.
     */
    public String kysyNext(boolean kysymisSuunta) {
        return kyselyLogiikka.asetaKysymys(kyselyLogiikka.getA(), kysymisSuunta, 1);
    }

    /**
     * Kysytän edellinen sana
     *
     * @param kysSuunta true = sana -> vastine; false vastine -> sana
     *
     * @return palautetaan asetaKysymyksen antama kysyttävä sana.
     */
    public String kysyEdellinen(boolean kysSuunta) {
        return kyselyLogiikka.asetaKysymys(kyselyLogiikka.getA(), kysSuunta, -1);
    }

    /**
     * Tarkistetaan menikö sana oikein
     *
     * @param vastaus Tarkistettava sana
     *
     * @return palautetaan true, jos vastaus oli oikein.
     */
    public boolean tarkastaVastaus(String vastaus) {
        return kyselyLogiikka.tarkistaVastaus(vastaus);
    }

    /**
     * Kysytän random sana
     *
     * @param kysymisSuunta true = sana -> vastine; false vastine -> sana
     *
     * @return palautetaan asetaKysymyksen antama kysyttävä sana.
     */
    public String kysyRandom(boolean kysymisSuunta) {
        return kyselyLogiikka.random(kysymisSuunta);
    }

    /**
     * Kysytän sana, joka on loogisesti oppimisen kannalta kannattava sana
     * kysyä.
     *
     * @param kysymisSuunta true = sana -> vastine; false vastine -> sana
     *
     * @return palautetaan asetaKysymyksen antama kysyttävä sana.
     */
    public String kysyLooginen(boolean kysymisSuunta) {
        return kyselyLogiikka.alunPainotus(kysymisSuunta);
    }

//    /**
//     * Tarkistetaan menikö sana oikein
//     *
//     * @param vastaus Tarkistettava sana
//     *
//     * @return palautetaan true, jos vastaus oli oikein.
//     */
//    public boolean tarkSana(String vastaus) {
//        return kyselyLogiikka.tarkistaVastaus(vastaus);
//    }

    /**
     * Kertoo, moniko meni oikein
     *
     * @return oikein menneiden lkm
     */
    public int getOikein() {
        return kyselyLogiikka.getOikein();
    }

    /**
     * Kertoo, moniko meni väärin
     *
     * @return väärinmenneiden lkn
     */
    public int getVaarin() {
        return kyselyLogiikka.getVaarin();
    }

    /**
     * Kertoo, montako tarkistusyritystä on ollut yhteensä.
     *
     * @return yhteensä arvattujen lkm
     */
    public int getYhteensa() {
        return kyselyLogiikka.getYhteensa();
    }

    /**
     * palauttaa kysytyn sanan, esim vastauksen näyttämistä varten.
     *
     * @return kysytty saha
     */
    public String getKysytty() {
        return kyselyLogiikka.getKysyttavaSana();
    }

    /**
     * palauttaa vastauksen
     *
     * @return vastaus
     */
    public String getVastaus() {
        return kyselyLogiikka.getVastaus();
    }
}
