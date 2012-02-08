package logiikka;

import java.io.File;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * Luokka, jossa valitaan tiedosto, josta luetaan sanat listaan.
 * @author jarmo
 */
public class ValitseTiedosto {

    private static Scanner filunLukija;
    private static File tied;

    /**
     * ValitseTiedosto luokan default konstruktori, joka kysyy tiedoston
     * sijainnin
     * ja luo siitä file-olion, jonka syöttää Scannerille parametrinä. Jos
     * tapahtuu virhe, niin koko prosesi aloitetaan alusta. Poistuminen ei
     * onnistu, ennenkuin on tiedosto saatu luettua. Palauttaa Scanner olion.
     *
     * @return scannerin
     */
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
    }

    /**
     * Luetaan tiedosto hienosti graafisesti
     *
     * @return Filestä luodun scannerin
     */
    public Scanner lueTiedostoGui() {
        while (true) {
            try {
                JFileChooser jf = new JFileChooser("~/");
                jf.setVisible(true);
                jf.setMultiSelectionEnabled(false);
                jf.showOpenDialog(jf);
                String polku = jf.getName();
                File valittu = jf.getSelectedFile();
                if (valittu == null) {
                    System.exit(0); //cancelin painaminen loptettaa.
                }
                filunLukija = new Scanner(valittu);
                return filunLukija;
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Ei onnistu, tiedoston valinnassa tapahtui virhe");
            }
        }

    }
}
