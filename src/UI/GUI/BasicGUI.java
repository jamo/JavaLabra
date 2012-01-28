package UI.GUI;

import javax.swing.JOptionPane;

/**
 *
 * @author jarmo
 */
public class BasicGUI extends javax.swing.JFrame {
    
    private boolean kysSuunta = true;
    GuiValiKommunikaatio k = new GuiValiKommunikaatio();

    /**
     * Creates new form BasicGUI
     */
    public BasicGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
//    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SuunnanValitsin = new javax.swing.ButtonGroup();
        Vastineeseen = new javax.swing.JRadioButton();
        Sanaan = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Kysymys = new javax.swing.JTextArea();
        Vastaus = new javax.swing.JTextField();
        KysSeuraava = new javax.swing.JButton();
        KysEdellinen = new javax.swing.JButton();
        Random = new javax.swing.JButton();
        Logiikka = new javax.swing.JButton();
        TarkVastaus = new javax.swing.JButton();
        Onnistuneet = new javax.swing.JLabel();
        Vaarin = new javax.swing.JLabel();
        Yhteensa = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        SuunnanValitsin.add(Vastineeseen);
        Vastineeseen.setSelected(true);
        Vastineeseen.setText("Sana -> Vastine");
        Vastineeseen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VastineeseenActionPerformed(evt);
            }
        });

        SuunnanValitsin.add(Sanaan);
        Sanaan.setText("Vastine -> Sana");
        Sanaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SanaanActionPerformed(evt);
            }
        });

        Kysymys.setColumns(20);
        Kysymys.setEditable(false);
        Kysymys.setLineWrap(true);
        Kysymys.setRows(5);
        jScrollPane1.setViewportView(Kysymys);

        Vastaus.setToolTipText("Kirjoita vastaus tähän kenttään");

        KysSeuraava.setText("Kysy Seuraava");
        KysSeuraava.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KysSeuraavaActionPerformed(evt);
            }
        });

        KysEdellinen.setText("Kysy Edellinen");
        KysEdellinen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KysEdellinenActionPerformed(evt);
            }
        });

        Random.setText("Kysys Satunnainen");
        Random.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RandomActionPerformed(evt);
            }
        });

        Logiikka.setText("Kysys Painotetusti");
        Logiikka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogiikkaActionPerformed(evt);
            }
        });

        TarkVastaus.setText("Tarkista");
        TarkVastaus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TarkVastausActionPerformed(evt);
            }
        });

        Onnistuneet.setText("Oikein: 0");

        Vaarin.setText("Vaarin: 0");

        Yhteensa.setText("Yhteensä: 0");

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 36)); // NOI18N
        jLabel1.setText("Arvaa sanan vastine");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(KysSeuraava, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(KysEdellinen, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Random)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Logiikka, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Vastaus, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TarkVastaus)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Onnistuneet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Vaarin, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Yhteensa, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 54, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Vastineeseen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Sanaan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addComponent(Vastineeseen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Sanaan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Onnistuneet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Vaarin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Yhteensa))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Vastaus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TarkVastaus))))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(KysSeuraava)
                    .addComponent(KysEdellinen)
                    .addComponent(Random)
                    .addComponent(Logiikka))
                .addGap(118, 118, 118))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VastineeseenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VastineeseenActionPerformed
        kysSuunta = true;
//        Vastineeseen.setSelected(true);
    }//GEN-LAST:event_VastineeseenActionPerformed

    private void SanaanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SanaanActionPerformed
        kysSuunta = false;
//        Sanaan.setSelected(true);
    }//GEN-LAST:event_SanaanActionPerformed

    private void KysSeuraavaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KysSeuraavaActionPerformed
        //Eli tähän se, mitä seuraavan sanan kysymiseen vaaditaan
//       kysyttavaSana
        String kysyttavaSana = k.kysyNext(kysSuunta);
        Kysymys.setText("Anna sanan: " + kysyttavaSana + " vastine:");
        Vastaus.setText("");
    }//GEN-LAST:event_KysSeuraavaActionPerformed

    private void KysEdellinenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KysEdellinenActionPerformed
        String kysyttavaSana = k.kysyEdellinen(kysSuunta);
        Kysymys.setText("Anna sanan: " + kysyttavaSana + " vastine:");
        Vastaus.setText("");
    }//GEN-LAST:event_KysEdellinenActionPerformed

    private void RandomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RandomActionPerformed
        // TODO add your handling code here:
        String kysyttava = k.kysyRandom(kysSuunta);
        Kysymys.setText("Anna sanan: " + kysyttava + " vastine:");
        Vastaus.setText("");

        //tämä kutsuu sitä kuuluisaa Randomia
    }//GEN-LAST:event_RandomActionPerformed

    private void LogiikkaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogiikkaActionPerformed
        // TODO add your handling code here:
        String kysyttava = k.kysyLooginen(kysSuunta);
        Kysymys.setText("Anna sanan: " + kysyttava + " vastine:");
        Vastaus.setText("");
        //tänne loogisen kyselyn vaatimat kyselyt
    }//GEN-LAST:event_LogiikkaActionPerformed

    private void TarkVastausActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TarkVastausActionPerformed
        // TODO add your handling code here:

        String vastaus = Vastaus.getText();
        boolean onnistui = k.tarkSana(vastaus);
        Onnistuneet.setText("Oikein: " + k.getOikein() );
        Vaarin.setText("Vaarin: " +k.getVaarin());
        Yhteensa.setText("Yhteensä: "+ k.getYhteensa());
//        if (onnistui) {
//            JOptionPane.showInputDialog("Onnistuit!");
//
//        } else {
//            JOptionPane.showInputDialog("Väärin!");
//        }
    }//GEN-LAST:event_TarkVastausActionPerformed

//    public static void main(String[] args){
//        
//        main m = new main( new String[]); 
//    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BasicGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BasicGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BasicGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BasicGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
//        uk = new UiKommunikaatio(, null)
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new BasicGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton KysEdellinen;
    private javax.swing.JButton KysSeuraava;
    private javax.swing.JTextArea Kysymys;
    private javax.swing.JButton Logiikka;
    private javax.swing.JLabel Onnistuneet;
    private javax.swing.JButton Random;
    private javax.swing.JRadioButton Sanaan;
    private javax.swing.ButtonGroup SuunnanValitsin;
    private javax.swing.JButton TarkVastaus;
    private javax.swing.JLabel Vaarin;
    private javax.swing.JTextField Vastaus;
    private javax.swing.JRadioButton Vastineeseen;
    private javax.swing.JLabel Yhteensa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
