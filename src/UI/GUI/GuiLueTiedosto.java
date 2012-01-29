/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.GUI;

import java.awt.FileDialog;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author jarmo
 */
public class GuiLueTiedosto extends JFrame {

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

    public Scanner loadFile() {

//        return fd.getFile();
        JFrame jF = new JFrame("hiphei");
        while (true) {
            try {

                String title = "Valitse tiedosto ";
                String defDir = "~/";
                FileDialog fd = new FileDialog(jF, title, FileDialog.LOAD);

                fd.setDirectory(defDir);
                fd.setLocation(50, 50);
                fd.show();

                String polku = fd.getFile();
                String path = fd.getDirectory();
                System.out.println(polku);
                System.out.println(path);
//                System.out.print("Anna tiedoston sijainti: ");
                tied = new File(path + polku);
                filunLukija = new Scanner(tied);
                return filunLukija;
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(rootPane, "Ei onnistu, tiedostoa ei voitu avata");
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(rootPane, "Ei onnistu, valitse jokun tiedosto!");

            }
        }
//        return null;
    }

    public Scanner lueTiedosto3() {
        while (true) {
            try {
                JFileChooser jf = new JFileChooser("~/");

//                String polku = JOptionPane.showInputDialog("Anna tiedoston sijainti: ");

                jf.setVisible(true);
                jf.setMultiSelectionEnabled(false);
                jf.showOpenDialog(jf);
                String polku = jf.getName();
                File valittu = jf.getSelectedFile();
//                System.out.println(polku);
//                System.out.print("Anna tiedoston sijainti: ");
//                tied = new File(polku);
                System.out.println(valittu);
                filunLukija = new Scanner(valittu);
                return filunLukija;
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, "Ei onnistu");
            }
        }

    }
}
