/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.GUI;

import java.io.File;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author jarmo
 */
public class GuiLueTiedosto extends JFrame{
    private File tied;
    private Scanner filunLukija;
     public Scanner lueTied() {
        Scanner l = new Scanner(System.in);
        while (true) {
            try {
                String polku = JOptionPane.showInputDialog("Anna tiedoston sijainti: ");
//                System.out.print("Anna tiedoston sijainti: ");
                tied = new File(polku);
                filunLukija = new Scanner(tied);
                return filunLukija;
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, "Ei onnistu");
            }
        }
//        return null;

    }
}
