package UI.GUI;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;

/**
 * Oma rakennelma guiksi
 *
 * @author jarmo
 */
public class GuiItse extends JFrame {

    private JTextField kentta;
    private JButton kysyNext;
//    private JButton kysyPrev;
//    private JButton kysyRandom;
//    private JButton kysyLogiikka;
    private JTextArea kysymys;
    private JLabel otsikko;
    private JTextField vastaus;

    public static void main(String[] args){
     GuiItse ikkuna = new GuiItse();
    ikkuna.setTitle("ElemFlow");
    ikkuna.pack();
    ikkuna.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ikkuna.setVisible(true);   
        
    }
    
    public  GuiItse() { // konstruktori!

        // luodaan käyttöliittymäelementit, oliot:

        kentta = new JTextField("Kentta");
        kysyNext = new JButton("Nappula");
        kysymys = new JTextArea(3, 7);
        otsikko = new JLabel("Otsikko");
        vastaus = new JTextField("vastaus");
        kentta.setEditable(false);

//        viestikentta = new JTextField("Viestikentta");
//        viestikentta.setEditable(false);  // muuttamattomaksi!

        // valitaan asemointi:

        setLayout(new GridLayout(3, 3));

        // lisätään kentät näkymään:

        add(kentta);
        add(kysyNext);
        add(otsikko);
        add(vastaus);
//        add(viestikentta);
    }
    
    private void actionListenerit(){

        
        
        
        
    }
    


}



