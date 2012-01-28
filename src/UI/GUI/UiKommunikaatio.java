/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.GUI;

import UI.UserActionsInterface;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author jarmo
 */
public class UiKommunikaatio implements UserActionsInterface {

    private javax.swing.JTextArea Kysymys;
    private javax.swing.JTextField Vastaus;

//    public UiKommunikaatio(JTextArea kysymys, JTextField vastaus) {
//        this.Kysymys = kysymys;
//        this.Vastaus = vastaus;
//    }
   public UiKommunikaatio(){
       
       
   }

    @Override
    public int kysyInt(String viesti) {
        this.setKysymys(viesti);

        return 0;
    }

    @Override
    public String kysyString(String viesti) {
        this.setKysymys(viesti);
        return "";
    }

    @Override
    public void kerroString(String viesti) {
        this.setKysymys(viesti);

    }

    @Override
    public String kysyString() {
        Kysymys.setText("");
        return "";
    }

    public void setKysymys(String viesti) {
    }

    public void palautaVastaus(String vastaus) {
    }
}
