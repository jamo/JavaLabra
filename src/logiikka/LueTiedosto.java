package logiikka;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author jarmo
 */
public class LueTiedosto {

    private static Scanner filunLukija;
    private static File tied;

    /**
     * LueTiedosto luokan default konstruktori, joka kysyy tiedoston sijainnin
     * ja luo siitä file-olion, jonka syöttää Scannerille parametrinä. Jos
     * tapahtuu virhe, niin koko prosesi aloitetaan alusta. Poistuminen ei
     * onnistu, ennenkuin on tiedosto saatu luettua. Palauttaa Scanner olion.
     */
//    public Scanner lueTiedosto() {
//        Scanner l = new Scanner(System.in);
////        System.out.print("Anna tiedoston sijainti: ");
//        while (true) {
//            try {
//                System.out.print("Anna tiedoston sijainti: ");
//                tied = new File(l.nextLine());
//                filunLukija = new Scanner(tied);
//                return filunLukija;
//            } catch (Exception ex) {
//                System.out.println("Tiedostoa ei löydy. Yritä uudestaan! ");
//            }
//        }
////        return null;
//
//    }

    public Scanner lueTied() {
        Scanner l = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Anna tiedoston sijainti: ");
                tied = new File(l.nextLine());
                filunLukija = new Scanner(tied);
                return filunLukija;
            } catch (Exception ex) {
                System.out.println("Tiedostoa ei löydy. Yritä uudestaan! ");
            }
        }
//        return null;

    }

    /*
     * Sulkee annetun scanner olion, jolla parametrina file.
     */
    public boolean sulje(Scanner lukija) {
        lukija.close();
        return true;
    }
}
