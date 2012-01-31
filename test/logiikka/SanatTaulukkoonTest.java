package logiikka;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class SanatTaulukkoonTest {


    
    @Test
    public void sanatTaulukkoontest(){
        String merkkijono = "sana1\nvastike1\n";
         ByteArrayInputStream bais = new ByteArrayInputStream(merkkijono.getBytes());
        
        Scanner syotto = new Scanner(bais);
        logiikka.SanatTaulukkoon l = new logiikka.SanatTaulukkoon();
        ArrayList<KysSana> a = l.lueSanat(syotto);
        assertTrue("Arraylistissä on liikaa tiedostoja", 1 == a.size());
    }
    
    @Test
    public void sanatTaulukkoontest2(){
        String merkkijono = "sana1\nvastike1\n";
         ByteArrayInputStream bais = new ByteArrayInputStream(merkkijono.getBytes());
        
        Scanner syotto = new Scanner(bais);
        logiikka.SanatTaulukkoon l = new logiikka.SanatTaulukkoon();
        ArrayList<KysSana> a = l.lueSanat(syotto);
        a.remove(a.get(0));
        assertTrue("Arraylistissä on vain yksi ilmentymä KysSanasta", 0 == a.size());
    }
}
