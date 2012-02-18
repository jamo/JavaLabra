package logiikka;


import java.util.ArrayList;
import java.util.Scanner;


/**
 * Luokka, joka siirtää luetut sanat arayList taulukkoon KysSana olioina.
 * @author jarmo
 */
public class SanatTaulukkoon {

    private ArrayList<KysSana> lista;

    /**
     * Lukee sanat ArrayList<kysSana> talukkoon ja palauttaa taulukon.
     * @param lukija Scanner ilmentymä, josta sanat luodaan.
     * @return  palauttaa listan sanoista
     */
    public ArrayList lueSanat(Scanner lukija) {
        String sana, vastine;
        lista = new ArrayList<KysSana>();
        while (lukija.hasNext()) {
            try {
                //ekaa virhettä ei pitäisi voida tapahtua!
                sana = lukija.nextLine();
            } catch (Exception e) {
                sana = "sanalla ei ollut arvoa!";
//                System.out.println("'Sana' luokassa Sanat ei saanut arvoa!");
            }
            try {
                vastine = lukija.nextLine();
            } catch (Exception e) {
                vastine = "sanalla ei ollut arvoa!";
//                System.out.println("'Vastine' luokassa Sanat ei saanut arvoa!");
            }
            lista.add(new KysSana(sana, vastine));
        }
//        System.out.println("Sanat luettu!");

        lukija.close();
        return lista;
    }
}
