/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.GUI;

import java.io.ByteArrayInputStream;
import java.util.Scanner;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jarmo
 */
public class GuiValiKommunikaatioTest {

    @Test
    public void testKysyNext() {
        ByteArrayInputStream bais = new ByteArrayInputStream("sana\nvastine\ntro\nololooo\n".getBytes());
        Scanner l = new Scanner(bais);
        UI.KyselyLogiikka kl = new UI.KyselyLogiikka(l);
        GuiValiKommunikaatio k = new GuiValiKommunikaatio(kl);
        String kysytty = k.kysyNext(true);
        assertEquals("Seuraavan kysyminen ei onnistu", "sana", kysytty);
    }

    /**
     * Test of kysyEdellinen method, of class GuiValiKommunikaatio.
     */
    @Test
    public void testKysyEdellinen() {
        ByteArrayInputStream bais = new ByteArrayInputStream("sana\nvastine\njarmo\njarmo2\n".getBytes());
        Scanner l = new Scanner(bais);

        UI.KyselyLogiikka kl = new UI.KyselyLogiikka(l);
        GuiValiKommunikaatio k = new GuiValiKommunikaatio(kl);
        String kysytty = k.kysyEdellinen(true);
        assertEquals("Edellisen kysyminen ei onnistu", "jarmo", kysytty);
    }

    /**
     * Test of tarkastaVastaus method, of class GuiValiKommunikaatio.
     */
    @Test
    public void testTarkastaVastaus() {
        ByteArrayInputStream bais = new ByteArrayInputStream("sana\nvastine\njarmo\njarmo2\n".getBytes());
        Scanner l = new Scanner(bais);

        UI.KyselyLogiikka kl = new UI.KyselyLogiikka(l);
        GuiValiKommunikaatio k = new GuiValiKommunikaatio(kl);
        String kysytty = k.kysyEdellinen(true);
        boolean onnistui = k.tarkastaVastaus("jarmo2");
        assertEquals("Sanan vastauksen tarkastus ei onnistu", true, onnistui);
    }

    /**
     * Test of kysyRandom method, of class GuiValiKommunikaatio.
     */
    @Test
    public void testKysyRandom() {
        ByteArrayInputStream bais = new ByteArrayInputStream("sana\nvastine\njarmo\njarmo2\n".getBytes());
        Scanner l = new Scanner(bais);

        UI.KyselyLogiikka kl = new UI.KyselyLogiikka(l);
        GuiValiKommunikaatio k = new GuiValiKommunikaatio(kl);
        String kysytty = k.kysyRandom(true);
        assertTrue("kysy random ei toimi", (kysytty.equals("jarmo") || kysytty.equals("sana")));


    }

    /**
     * Test of kysyLooginen method, of class GuiValiKommunikaatio.
     */
    @Test
    public void testKysyLooginen() {
        ByteArrayInputStream bais = new ByteArrayInputStream("sana\nvastine\njarmo\njarmo2\n".getBytes());
        Scanner l = new Scanner(bais);

        UI.KyselyLogiikka kl = new UI.KyselyLogiikka(l);
        GuiValiKommunikaatio k = new GuiValiKommunikaatio(kl);
        String kysytty = k.kysyLooginen(true);
        assertTrue("kysy looginen ei toimi", (kysytty.equals("jarmo") || kysytty.equals("sana")));
    }

    /**
     * Test of tarkSana method, of class GuiValiKommunikaatio.
     */
    @Test
    public void testTarkSana() {
        ByteArrayInputStream bais = new ByteArrayInputStream("sana\nvastine\njarmo\njarmo2\n".getBytes());
        Scanner l = new Scanner(bais);

        UI.KyselyLogiikka kl = new UI.KyselyLogiikka(l);
        GuiValiKommunikaatio k = new GuiValiKommunikaatio(kl);
        String kysytty = k.kysyEdellinen(true);
        boolean onnistui = k.tarkastaVastaus("jarmo2");
        assertEquals("Sanan tarkastus ei onnistu", true, onnistui);
    }

    /**
     * Test of getOikein method, of class GuiValiKommunikaatio.
     */
    @Test
    public void testGetOikein() {
        ByteArrayInputStream bais = new ByteArrayInputStream("sana\nvastine\njarmo\njarmo2\n".getBytes());
        Scanner l = new Scanner(bais);

        UI.KyselyLogiikka kl = new UI.KyselyLogiikka(l);
        GuiValiKommunikaatio k = new GuiValiKommunikaatio(kl);
        String kysytty = k.kysyEdellinen(true);
        k.tarkastaVastaus("jarmoo2");
        k.tarkastaVastaus("jarmoook2");
        k.tarkastaVastaus("jarmoookok2");
        k.tarkastaVastaus("jarmo2");
        k.tarkastaVastaus("jarmo2");

        assertEquals("Oikein menneiden lasku ei onnistu", 2, k.getOikein());
    }

    /**
     * Test of getVaarin method, of class GuiValiKommunikaatio.
     */
    @Test
    public void testGetVaarin() {
        ByteArrayInputStream bais = new ByteArrayInputStream("sana\nvastine\njarmo\njarmo2\n".getBytes());
        Scanner l = new Scanner(bais);

        UI.KyselyLogiikka kl = new UI.KyselyLogiikka(l);
        GuiValiKommunikaatio k = new GuiValiKommunikaatio(kl);
        String kysytty = k.kysyEdellinen(true);
        k.tarkastaVastaus("jarmoo2");
        k.tarkastaVastaus("jarmoook2");
        k.tarkastaVastaus("jarmoookok2");
        k.tarkastaVastaus("jarmo2");
        k.tarkastaVastaus("jarmo2");

        assertEquals("Väärin menneiden lasku ei onnistu", 3, k.getVaarin());
    }

    /**
     * Test of getYhteensa method, of class GuiValiKommunikaatio.
     */
    @Test
    public void testGetYhteensa() {
        ByteArrayInputStream bais = new ByteArrayInputStream("sana\nvastine\njarmo\njarmo2\n".getBytes());
        Scanner l = new Scanner(bais);

        UI.KyselyLogiikka kl = new UI.KyselyLogiikka(l);
        GuiValiKommunikaatio k = new GuiValiKommunikaatio(kl);
        String kysytty = k.kysyEdellinen(true);
        k.tarkastaVastaus("jarmoo2");
        k.tarkastaVastaus("jarmoook2");
        k.tarkastaVastaus("jarmoookok2");
        k.tarkastaVastaus("jarmo2");
        k.tarkastaVastaus("jarmo2");

        assertEquals("Yhteensä tarkastetujen lasku ei onnistu", 5, k.getYhteensa());
    }

    /**
     * Test of getKysytty method, of class GuiValiKommunikaatio.
     */
    @Test
    public void testGetKysytty() {
                ByteArrayInputStream bais = new ByteArrayInputStream("sana\nvastine\njarmo\njarmo2\n".getBytes());
        Scanner l = new Scanner(bais);

        UI.KyselyLogiikka kl = new UI.KyselyLogiikka(l);
        GuiValiKommunikaatio k = new GuiValiKommunikaatio(kl);
        String kysytty = k.kysyEdellinen(true);
        String kys = k.getKysytty();
        
        assertEquals("GetKysytty ei toimi", kysytty, kys);
    }

    /**
     * Test of getVastaus method, of class GuiValiKommunikaatio.
     */
    @Test
    public void testGetVastaus() {
        ByteArrayInputStream bais = new ByteArrayInputStream("sana\nvastine\njarmo\njarmo2\n".getBytes());
        Scanner l = new Scanner(bais);

        UI.KyselyLogiikka kl = new UI.KyselyLogiikka(l);
        GuiValiKommunikaatio k = new GuiValiKommunikaatio(kl);
        String kysytty = k.kysyEdellinen(true);
        String vastaus = k.getVastaus();
        
        assertEquals("Get vastaus ei anna oikeaa vastausta", "jarmo2", vastaus);
    }
}
