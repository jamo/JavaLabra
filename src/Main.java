
import UI.Tekstikayttoliittyma.Tekstikayttoliittyma;

public class Main {

    public static void main(String[] args) {
//        lueTiedosto l = new lueTiedosto();
//        System.out.println("Luetaan tiedosto: ");
//        lukija = l.lueTiedosto();
//        SanatTaulukkoon st = new SanatTaulukkoon();
//        Tekstikayttoliittyma teksti = new Tekstikayttoliittyma();

//        System.out.println(a);
//        komentotulkki();
        int merkkeja = 10 * 2 - 1;
        int n = merkkeja;
        int[][] ruutu;
        ruutu = new int[merkkeja][merkkeja];

        String sana = "ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖ";
        for (int rivi = 0; rivi < merkkeja; rivi++) {
            for (int sarake = 0; sarake < merkkeja; sarake++) {

                int keskusta = n / 2;
                int s = sarake;
                if (s > keskusta) {
                    s = n - 1 - s;
                }
                int r = rivi;
                if (r > keskusta) {
                    r = n - 1 - rivi;
                }
                int lukuu = Math.min(r, s);
                ruutu[rivi][sarake] = lukuu;
            }
        }
        for (int i = 0; i < merkkeja; i++) {
            for (int j = 0; j < merkkeja; j++) {
                System.out.print(sana.charAt(ruutu[i][j]));
            }
            System.out.println("");
        }


        //   src/SanaLista.txt
    }
}
