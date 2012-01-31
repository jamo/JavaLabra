package UI.Tekstikayttoliittyma;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import UI.ValiKommunikaatio;
import java.io.ByteArrayInputStream;
import java.util.Scanner;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jarmo
 */
public class KomenotulkkiValiKommunikaatioTest {
    
    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */




    @Test
    public void testKysyNext() {
        ByteArrayInputStream bais = new ByteArrayInputStream("sana\nvastine\ntro\nololooo\n".getBytes());
        Scanner l = new Scanner(bais);
        logiikka.KyselyLogiikka kl = new logiikka.KyselyLogiikka(l);
//        KomenotulkkiValiKommunikaatio k = new KomenotulkkiValiKommunikaatio(kl);
        ValiKommunikaatio k = new ValiKommunikaatio(kl);
        String kysytty = k.kysyNext(true);
        assertEquals("Seuraavan kysyminen ei onnistu", "sana", kysytty);
    }

    /**
     * Test of kysyEdellinen method, of class ValiKommunikaatio.
     */
    @Test
    public void testKysyEdellinen() {
        ByteArrayInputStream bais = new ByteArrayInputStream("sana\nvastine\njarmo\njarmo2\n".getBytes());
        Scanner l = new Scanner(bais);

        logiikka.KyselyLogiikka kl = new logiikka.KyselyLogiikka(l);
        ValiKommunikaatio k = new ValiKommunikaatio(kl);
        String kysytty = k.kysyEdellinen(true);
        assertEquals("Edellisen kysyminen ei onnistu", "jarmo", kysytty);
    }

    /**
     * Test of tarkastaVastaus method, of class ValiKommunikaatio.
     */
    @Test
    public void testTarkastaVastaus() {
        ByteArrayInputStream bais = new ByteArrayInputStream("sana\nvastine\njarmo\njarmo2\n".getBytes());
        Scanner l = new Scanner(bais);

        logiikka.KyselyLogiikka kl = new logiikka.KyselyLogiikka(l);
        ValiKommunikaatio k = new ValiKommunikaatio(kl);
        String kysytty = k.kysyEdellinen(true);
        boolean onnistui = k.tarkastaVastaus("jarmo2");
        assertEquals("Sanan vastauksen tarkastus ei onnistu", true, onnistui);
    }

    /**
     * Test of kysyRandom method, of class ValiKommunikaatio.
     */
    @Test
    public void testKysyRandom() {
        ByteArrayInputStream bais = new ByteArrayInputStream("sana\nvastine\njarmo\njarmo2\n".getBytes());
        Scanner l = new Scanner(bais);

        logiikka.KyselyLogiikka kl = new logiikka.KyselyLogiikka(l);
        ValiKommunikaatio k = new ValiKommunikaatio(kl);
        String kysytty = k.kysyRandom(true);
        assertTrue("kysy random ei toimi", (kysytty.equals("jarmo") || kysytty.equals("sana")));


    }

    /**
     * Test of kysyLooginen method, of class ValiKommunikaatio.
     */
    @Test
    public void testKysyLooginen() {
        ByteArrayInputStream bais = new ByteArrayInputStream("sana\nvastine\njarmo\njarmo2\n".getBytes());
        Scanner l = new Scanner(bais);

        logiikka.KyselyLogiikka kl = new logiikka.KyselyLogiikka(l);
        ValiKommunikaatio k = new ValiKommunikaatio(kl);
        String kysytty = k.kysyLooginen(true);
        assertTrue("kysy looginen ei toimi", (kysytty.equals("jarmo") || kysytty.equals("sana")));
    }

    /**
     * Test of tarkSana method, of class ValiKommunikaatio.
     */
    @Test
    public void testTarkSana() {
        ByteArrayInputStream bais = new ByteArrayInputStream("sana\nvastine\njarmo\njarmo2\n".getBytes());
        Scanner l = new Scanner(bais);

        logiikka.KyselyLogiikka kl = new logiikka.KyselyLogiikka(l);
        ValiKommunikaatio k = new ValiKommunikaatio(kl);
        String kysytty = k.kysyEdellinen(true);
        boolean onnistui = k.tarkastaVastaus("jarmo2");
        assertEquals("Sanan tarkastus ei onnistu", true, onnistui);
    }

    /**
     * Test of getOikein method, of class ValiKommunikaatio.
     */
    @Test
    public void testGetOikein() {
        ByteArrayInputStream bais = new ByteArrayInputStream("sana\nvastine\njarmo\njarmo2\n".getBytes());
        Scanner l = new Scanner(bais);

        logiikka.KyselyLogiikka kl = new logiikka.KyselyLogiikka(l);
        ValiKommunikaatio k = new ValiKommunikaatio(kl);
        String kysytty = k.kysyEdellinen(true);
        k.tarkastaVastaus("jarmoo2");
        k.tarkastaVastaus("jarmoook2");
        k.tarkastaVastaus("jarmoookok2");
        k.tarkastaVastaus("jarmo2");
        k.tarkastaVastaus("jarmo2");

        assertEquals("Oikein menneiden lasku ei onnistu", 2, k.getOikein());
    }

    /**
     * Test of getVaarin method, of class ValiKommunikaatio.
     */
    @Test
    public void testGetVaarin() {
        ByteArrayInputStream bais = new ByteArrayInputStream("sana\nvastine\njarmo\njarmo2\n".getBytes());
        Scanner l = new Scanner(bais);

        logiikka.KyselyLogiikka kl = new logiikka.KyselyLogiikka(l);
        ValiKommunikaatio k = new ValiKommunikaatio(kl);
        String kysytty = k.kysyEdellinen(true);
        k.tarkastaVastaus("jarmoo2");
        k.tarkastaVastaus("jarmoook2");
        k.tarkastaVastaus("jarmoookok2");
        k.tarkastaVastaus("jarmo2");
        k.tarkastaVastaus("jarmo2");

        assertEquals("Väärin menneiden lasku ei onnistu", 3, k.getVaarin());
    }

    /**
     * Test of getYhteensa method, of class ValiKommunikaatio.
     */
    @Test
    public void testGetYhteensa() {
        ByteArrayInputStream bais = new ByteArrayInputStream("sana\nvastine\njarmo\njarmo2\n".getBytes());
        Scanner l = new Scanner(bais);

        logiikka.KyselyLogiikka kl = new logiikka.KyselyLogiikka(l);
        ValiKommunikaatio k = new ValiKommunikaatio(kl);
        String kysytty = k.kysyEdellinen(true);
        k.tarkastaVastaus("jarmoo2");
        k.tarkastaVastaus("jarmoook2");
        k.tarkastaVastaus("jarmoookok2");
        k.tarkastaVastaus("jarmo2");
        k.tarkastaVastaus("jarmo2");

        assertEquals("Yhteensä tarkastetujen lasku ei onnistu", 5, k.getYhteensa());
    }

}
