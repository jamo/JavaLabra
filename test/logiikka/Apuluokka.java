/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

import java.io.ByteArrayInputStream;

/**
 *
 * @author jarmoiso
 */
public class Apuluokka {
    private ByteArrayInputStream bais;
    
    public Apuluokka(String merkkijono) {
        bais = new ByteArrayInputStream(merkkijono.getBytes());
        System.setIn(bais);
    }    
}
