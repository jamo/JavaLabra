package logiikka;


import java.util.ArrayList;
import java.util.Scanner;

public class SanatTaulukkoon {

    private ArrayList<KysSana> lista;

    /*
     * Lukee sanat ArrayList<kysSana> talukkoon ja palauttaa taulukon.
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
                System.out.println("'Sana' luokassa Sanat ei saanut arvoa!");
            }
            try {
                vastine = lukija.nextLine();
            } catch (Exception e) {
                vastine = "sanalla ei ollut arvoa!";
                System.out.println("'Vastine' luokassa Sanat ei saanut arvoa!");
            }
//            System.out.println("Sana: "+ sana);
//            System.out.println("Vastine: "+ vastine);
            lista.add(new KysSana(sana, vastine));
        }
        System.out.println("Sanat luettu!");

        lukija.close();
        return lista;
    }
}
