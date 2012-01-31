/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;

/**
 *
 * @author jarmo
 */
public class KysSanaTest {

    /**
     * Tällainan tarvotaan mockia varten.
     */
    @Rule
    public MockStdio io = new MockStdio();
     
    @Test
    public void testSetEka() {
        logiikka.KysSana k = new logiikka.KysSana();
        k.setEka("eka");
        assertEquals("Sanan asettaminen ei onnistunut", "eka", k.getEka());
    }

    /**
     * Test of setToka method, of class KysSana.
     */
    @Test
    public void testSetToka() {
        logiikka.KysSana k = new logiikka.KysSana();
        k.setToka("toka");
        assertEquals("Sanan vastikkeen asettaminen ei onnistunut", "toka", k.getToka());
    }

    /**
     * Test of getEka method, of class KysSana.
     */
    @Test
    public void testGetEka() {
        logiikka.KysSana k = new logiikka.KysSana("eka", "toka");
        assertEquals("Sanan kysyminen ei onnistu", "eka", k.getEka());
    }

    
    /**
     * Test of getToka method, of class KysSana.
     */
    @Test
    public void testGetToka() {
        logiikka.KysSana k = new logiikka.KysSana("eka", "toka");
        assertEquals("Sanan vastikkeen gettri ei toimi", "toka", k.getToka());
    }

    /**
     * Test of getOikein method, of class KysSana.
     */
    @Test
    public void testGetOikein() {
        logiikka.KysSana k = new logiikka.KysSana("eka", "toka");
        k.meniOikein();
        assertEquals("ekan oikeinmeno laskettiin väärin", 1, k.getOikein());
    }

    /**
     * Test of getVaarin method, of class KysSana.
     */
    @Test
    public void testGetVaarin() {
        logiikka.KysSana k = new logiikka.KysSana("eka", "toka");
        k.meniVaarin();
        assertEquals("ekan väärinmeno laskettiin väärin", 1, k.getVaarin());
    }

    /**
     * Test of meniOikein method, of class KysSana.
     */
    @Test
    public void testMeniOikein() {
        logiikka.KysSana k = new logiikka.KysSana("eka", "toka");
        for (int i = 0; i < 10; i++) {
            k.meniOikein();
        }
        assertEquals("Menioikein metodi kasvattaa oikeala tavalla", 10, k.getOikein());
    }

    /**
     * Test of meniVaarin method, of class KysSana.
     */
    @Test
    public void testMeniVaarin() {
        logiikka.KysSana k = new logiikka.KysSana("eka", "toka");
        for (int i = 0; i < 10; i++) {
            k.meniVaarin();
        }
        assertEquals("Menivaarin metodi kasvattaa oikeala tavalla", 10, k.getVaarin());
    }

    /**
     * Test of toString method, of class KysSana.
     */
    @Test
    public void testToString() {
//        io.
        logiikka.KysSana k = new logiikka.KysSana("eka", "toka");
        String oletus = "\nSana: " + k.getEka() + " || Vastine: " + k.getToka();
        assertEquals("ToString muuttunut", oletus, k.toString() );
    }

    /**
     * Test of compareTo method, of class KysSana.
     */
    @Test
    public void testCompareTo() {
         logiikka.KysSana k = new logiikka.KysSana("eka", "toka");
         logiikka.KysSana k2 = new logiikka.KysSana("eka", "toka");
         for (int i = 0; i < 100; i++) {
            k.meniOikein();
        }
         k2.meniVaarin();
//        String oletus = "\nSana: " + k.getEka() + " || Vastine: " + k.getToka();
        assertTrue("PainoArvon lakskutapa muuttunut? (ei haitanne) tarkista metodi",  0<k.compareTo(k2));
    }
    
    @Test
    public void molemmatKonstruktoritToimivat() {
        logiikka.KysSana k = new logiikka.KysSana("eka", "toka");
        assertEquals("Sanan kysyminen ei onnistu", "eka", k.getEka());
        assertEquals("Sanan kysyminen ei onnistu", "toka", k.getToka());
    }
}
