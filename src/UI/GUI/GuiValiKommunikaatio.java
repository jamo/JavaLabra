/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.GUI;

import UI.KyselyLogiikka;

/**
 *
 * @author jarmo
 */
public class GuiValiKommunikaatio {

    private GuiLueTiedosto gl = new GuiLueTiedosto();
//    private KyselyLogiikka k = new KyselyLogiikka(gl.lueTied());
    private KyselyLogiikka k = new KyselyLogiikka(gl.lueTiedosto3());

    public String kysyNext(boolean kysSuunta) {
        return k.asetaKysymys(k.getA(), kysSuunta, 1);
    }

    public String kysyEdellinen(boolean kysSuunta) {
        return k.asetaKysymys(k.getA(), kysSuunta, -1);
    }

    public boolean tarkastaVastaus(String sana) {
        return k.tarkistaVastaus(sana);
    }

    public String kysyRandom(boolean kysSuunta) {
        return k.random(kysSuunta);
    }

    public String kysyLooginen(boolean kysSuunta) {
        return k.alunPainotus(kysSuunta);
    }

    public boolean tarkSana(String sana) {
        return k.tarkistaVastaus(sana);
    }

    public int getOikein() {
        return k.getOikein();
    }

    public int getVaarin() {
        return k.getVaarin();
    }

    public int getYhteensa() {
        return k.getYhteensa();
    }
}
