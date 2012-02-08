package Main;


import UI.GUI.BasicGUI;

/**
 * Main luokka, joka suoitetaan ensimmäisenä. Luo joko komentotulkki tai GUI käyttöliittymän.
 * @author jarmo
 */
public class Main  {

    public static void main(String[] args) {

//        UI.Tekstikayttoliittyma.Tekstikayttoliittyma t = new UI.Tekstikayttoliittyma.Tekstikayttoliittyma();

        new BasicGUI().setVisible(true);
        //   src/SanaLista.txt
    }
}
