/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import logiikka.KyselyLogiikka;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import logiikka.KysSana;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author jarmo
 */
public class KyselyLogiikkaTest {

    /**
     * Test of setSiirSuunta method, of class KyselyLogiikka.
     */
    @Test
    public void testSetSiirSuunta() {
        Scanner l;
        ByteArrayInputStream bais = new ByteArrayInputStream("sana\nvastine\n".getBytes());
        l = new Scanner(bais);
        KyselyLogiikka k = new KyselyLogiikka(l);
        try {
            k.setSiirSuunta(-1);
        } catch (Exception e) {
            assertTrue("Sirtymissuunnan muutos aiheuttaa virheen", true);
        }
    }

    /**
     * Test of getKysyttavaSana method, of class KyselyLogiikka.
     */
    @Test
    public void testGetKysyttavaSana() {
        Scanner l;
        ByteArrayInputStream bais = new ByteArrayInputStream("sana\nvastine\n".getBytes());
        l = new Scanner(bais);
        KyselyLogiikka k = new KyselyLogiikka(l);
        ArrayList<KysSana> a = new ArrayList<KysSana>();
        a.add(new KysSana("sana", "vastine"));

        String joo = k.asetaKysymys(a, true, 1);
        assertEquals("SgetKysyttäva sana ei toimi odotetusti", "sana", joo);
    }

    /**
     * Test of getVastaus method, of class KyselyLogiikka.
     */
    @Test
    public void testGetVastaus() {
        Scanner l;
        ByteArrayInputStream bais = new ByteArrayInputStream("sana\nvastine\n".getBytes());
        l = new Scanner(bais);
        KyselyLogiikka k = new KyselyLogiikka(l);
        ArrayList<KysSana> a = new ArrayList<KysSana>();
        a.add(new KysSana("sana", "vastine"));

        k.asetaKysymys(a, true, 1);
        String vastaus = k.getVastaus();
        assertEquals("getVastaus ei toimi odoitetusti", "vastine", vastaus);
    }

    @Test
    public void testGetVastausSiirtosuunnalla() {
        Scanner l;
        ByteArrayInputStream bais = new ByteArrayInputStream("sana\nvastine\n".getBytes());
        l = new Scanner(bais);
        KyselyLogiikka k = new KyselyLogiikka(l);
        ArrayList<KysSana> a = new ArrayList<KysSana>();
        a.add(new KysSana("sana", "vastine"));

        k.asetaKysymys(a, true, -1);
        String vastaus = k.getVastaus();
        assertEquals("Siirtosuunnan muuttamisen ei pitöäisi muuttaa tilannetta", "vastine", vastaus);
    }

    /**
     * Test of asetaKysymys method, of class KyselyLogiikka.
     */
    @Test
    public void testAsetaKysymys() {
        Scanner l;
        ByteArrayInputStream bais = new ByteArrayInputStream("sana\nvastine\n".getBytes());
        l = new Scanner(bais);
        KyselyLogiikka k = new KyselyLogiikka(l);
        ArrayList<KysSana> a = new ArrayList<KysSana>();
        a.add(new KysSana("sana", "vastine"));

        String sana = k.asetaKysymys(a, true, 1);
        String vastaus = k.getVastaus();
        assertEquals("kysymykse nasettaminen ei toimi", "sana", sana);
    }

    /**
     * Test of tarkistaVastaus method, of class KyselyLogiikka.
     */
    @Test
    public void testTarkistaVastaus() {
        Scanner l;
        ByteArrayInputStream bais = new ByteArrayInputStream("sana\nvastine\n".getBytes());
        l = new Scanner(bais);
        KyselyLogiikka k = new KyselyLogiikka(l);
        ArrayList<KysSana> a = new ArrayList<KysSana>();
        a.add(new KysSana("sana", "vastine"));

        k.asetaKysymys(a, true, 1);


        assertEquals("Sanan tarkastus ei toimi", true, k.tarkistaVastaus("vastine"));
    }

    /**
     * Test of random method, of class KyselyLogiikka.
     */
    @Test
    public void testRandom() {
        Scanner l;
        ByteArrayInputStream bais = new ByteArrayInputStream("sana\nvastine\n".getBytes());
        l = new Scanner(bais);
        KyselyLogiikka k = new KyselyLogiikka(l);
        ArrayList<KysSana> a = new ArrayList<KysSana>();
        a.add(new KysSana("sana", "vastine"));

        String kysymys = k.random(true);


        assertEquals("Randm ei kysy sanaa", "sana", kysymys);
    }

    /**
     * Test of alunPainotus method, of class KyselyLogiikka.
     */
    @Test
    public void testAlunPainotus() {
        Scanner l;
        ByteArrayInputStream bais = new ByteArrayInputStream("sana\nvastine\n".getBytes());
        l = new Scanner(bais);
        KyselyLogiikka k = new KyselyLogiikka(l);
        ArrayList<KysSana> a = new ArrayList<KysSana>();
        a.add(new KysSana("sana", "vastine"));

        String kysymys = k.alunPainotus(true);


        assertEquals("AlunPainoitus ei toimi", "sana", kysymys);
    }

    /**
     * Test of getVaarin method, of class KyselyLogiikka.
     */
    @Test
    public void testGetVaarin() {
        Scanner l;
        ByteArrayInputStream bais = new ByteArrayInputStream("sana\nvastine\n".getBytes());
        l = new Scanner(bais);
        KyselyLogiikka k = new KyselyLogiikka(l);
        ArrayList<KysSana> a = new ArrayList<KysSana>();
        a.add(new KysSana("sana", "vastine"));

        k.asetaKysymys(a, true, 1);
        k.tarkistaVastaus("vaarav vastaus");
        k.tarkistaVastaus("trololololoo");
        int virheita = k.getVaarin();

        assertEquals("Väärin menneiden tarkistusten lasku ei toimi", 2, virheita);
    }

    /**
     * Test of getOikein method, of class KyselyLogiikka.
     */
    @Test
    public void testGetOikein() {
        Scanner l;
        ByteArrayInputStream bais = new ByteArrayInputStream("sana\nvastine\n".getBytes());
        l = new Scanner(bais);
        KyselyLogiikka k = new KyselyLogiikka(l);
        ArrayList<KysSana> a = new ArrayList<KysSana>();
        a.add(new KysSana("sana", "vastine"));

        k.asetaKysymys(a, true, 1);
        k.tarkistaVastaus("vastine");
        k.tarkistaVastaus("trololololoo");
        int virheita = k.getOikein();
//        System.out.println(virheita);

        assertEquals("Oikein menneiden sanojen tarkastukset ei laske virheitä oikein", 1, virheita);
    }

    /**
     * Test of getYhteensa method, of class KyselyLogiikka.
     */
    @Test
    public void testGetYhteensa() {
        Scanner l;
        ByteArrayInputStream bais = new ByteArrayInputStream("sana\nvastine\n".getBytes());
        l = new Scanner(bais);
        KyselyLogiikka k = new KyselyLogiikka(l);
        ArrayList<KysSana> a = new ArrayList<KysSana>();
        a.add(new KysSana("sana", "vastine"));

        k.asetaKysymys(a, true, 1);
        k.tarkistaVastaus("vaarav vastaus");
        k.tarkistaVastaus("trololololoo");
        int virheita = k.getYhteensa();

        assertEquals("Sanan tarkastus ei toimi", 2, virheita);
    }

    /**
     * Test of getA method, of class KyselyLogiikka.
     */
    @Test
    public void testGetA() {
        Scanner l;
        ByteArrayInputStream bais = new ByteArrayInputStream("sana\nvastine\n".getBytes());
        l = new Scanner(bais);
        KyselyLogiikka k = new KyselyLogiikka(l);
        ArrayList<KysSana> a = new ArrayList<KysSana>();
        a.add(new KysSana("sana", "vastine"));

        k.asetaKysymys(a, true, 1);
        ArrayList<KysSana>  ar = k.getA();
        ar.toString().equals(a.toString());
        assertEquals("Sanan tarkastus ei toimi", true, ar.toString().equals(a.toString()));
    }
}
