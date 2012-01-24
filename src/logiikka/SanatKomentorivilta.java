/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jarmo
 */
public class SanatKomentorivilta {
    
    /*
     * Luetaan komentoriviltä sanapari
     * @RETURN arraylist jossa sanaparit KysSana olioina
     */
    public ArrayList lueKomentorivila(){
        Scanner l = new Scanner(System.in);
        String sana, vastine;
        ArrayList<KysSana> a = new ArrayList<KysSana>();
        while (l.hasNext()){
            System.out.print("Anna sana: ");
            sana = l.nextLine();
            System.out.print("Anna sanan "+ sana+ " vastine: ");
            vastine = l.nextLine();
            a.add(new KysSana(sana, vastine));
            sana = "";
            vastine = "";
        }
        return a;   
    }

    
    
}
