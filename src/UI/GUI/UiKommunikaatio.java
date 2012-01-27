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

//    private javax.swing.JButton KysEdellinen;
//    private javax.swing.JButton KysSeuraava;
    private javax.swing.JTextArea Kysymys;
//    private javax.swing.JButton Logiikka;
//    private javax.swing.JButton Random;
//    private javax.swing.JRadioButton Sanaan;
//    private javax.swing.ButtonGroup SuunnanValitsin;
//    private javax.swing.JButton TarkVastaus;
    private javax.swing.JTextField Vastaus;
//    private javax.swing.JRadioButton Vastineeseen;
//    private javax.swing.JScrollPane jScrollPane1;

    public UiKommunikaatio(JTextArea kysymys, JTextField vastaus){
        this.Kysymys = kysymys;
        this.Vastaus = vastaus;
    }
    
    @Override
    public int kysyInt(String viesti) {
        Kysymys.setText(viesti);
        
        return 0;
    }

    @Override
    public String kysyString(String viesti) {
        Kysymys.setText(viesti);
        return "";
    }

    @Override
    public void kerroString(String viesti) {
        Kysymys.setText(viesti);
    }

    @Override
    public String kysyString() {
        Kysymys.setText("");
        return "";
    }
}
