
package logiikka;

import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import java.util.Scanner;
import org.junit.*;
import static org.junit.Assert.*;


public class LueTiedostoTest {
    
    @Rule
    public MockStdio io = new MockStdio();
    
    public LueTiedostoTest() {
    }

//Tämä tapa ei ihan yhtä kaunis?
//    /**
//     * Test of ValitseTiedosto method, of class ValitseTiedosto.
//     */
//    @Test
//    public void testLueTiedosto() {
//        Apuluokka luokka = new Apuluokka("ei-ole-olemassa-trololo\nsrc/SanaLista.txt\n");
////        Apuluokka luokka = new Apuluokka("ei-ole-olemassa-trololo\n/fs-0/a/jarmoiso/JavaLabra/src/SanaLista.txt\n");
//        System.out.println("ValitseTiedosto");
//        logiikka.ValitseTiedosto l = new logiikka.ValitseTiedosto();
//        Scanner lukija = l.lueTiedosto();
//    }
    @Test
    public void testLueTiedostoMock() {
       
        io.setSysIn("tololololoo\nsrc/SanaLista.txt\n");
//        Apuluokka luokka = new Apuluokka("ei-ole-olemassa-trololo\n/fs-0/a/jarmoiso/JavaLabra/src/SanaLista.txt\n");
        System.out.println("LueTiedosto");
        logiikka.ValitseTiedosto l = new logiikka.ValitseTiedosto();
        Scanner lukija = l.lueTied();
        assertTrue("Kun tiedostoa ei löyvy, annetaan virheilmoitus", io.getSysOut().contains("Tiedostoa ei löydy. Yritä uudestaan!"));
    }
    
    @Test
    public void testLueTiedostoMock2() {
       
        io.setSysIn("src/SanaLista.txt\n");
        System.out.println("LueTiedosto");
        logiikka.ValitseTiedosto l = new logiikka.ValitseTiedosto();
        Scanner lukija = l.lueTied();
        String tmp = io.getSysOut();
        tmp = tmp.replace("Anna tiedoston sijainti: ", "");
        System.out.println(tmp);
        tmp = tmp.replace("LueTiedosto", "");
        assertTrue(tmp +"Kun tiedostoa ei löydy, annetaan virheilmoitus",tmp.trim().isEmpty());
    }

}
