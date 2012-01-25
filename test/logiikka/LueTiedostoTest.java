
package logiikka;

import java.util.Scanner;
import org.junit.*;
import static org.junit.Assert.*;


public class LueTiedostoTest {
    
    public LueTiedostoTest() {
    }

   
    /**
     * Test of LueTiedosto method, of class LueTiedosto.
     */
    @Test
    public void testLueTiedosto() {
        Apuluokka luokka = new Apuluokka("ei-ole-olemassa-trololo\n/fs-0/a/jarmoiso/JavaLabra/src/SanaLista.txt\n");
        System.out.println("LueTiedosto");
        logiikka.LueTiedosto l = new logiikka.LueTiedosto();
        Scanner lukija = l.lueTiedosto();


    }

    /**
     * Test of sulje method, of class LueTiedosto.
     */
    @Test
    public void testSulje() {
        Apuluokka luokka = new Apuluokka("/fs-0/a/jarmoiso/JavaLabra/src/SanaLista.txt\n");
        System.out.println("sulje");
        Scanner lukija = null;
        LueTiedosto instance = new LueTiedosto();
        boolean expResult = false;
        boolean result = instance.sulje(lukija);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
