/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package forme;

import domen.Apartman;
import domen.Gost;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import kontroler.Komunikacija;

/**
 *
 * @author LENOVO
 */
public class ZapamtiApartman extends javax.swing.JDialog {

    /**
     * Creates new form KreirajApartman
     */
    Apartman apartman;
    public ZapamtiApartman(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
         setLocationRelativeTo(null);
    }

    public void setApartman(Apartman apartman) {
        this.apartman = apartman;
        txtNaziv.setText(apartman.getNazivApartmana());
        txtCena.setText(String.valueOf(apartman.getCena()));
        if(apartman.isRaspolozivost() == true){
         radioRasoilozivoDA.setSelected(true);
        }else{
            radioRasoilozivoNE.setSelected(true);
        }
        txtBrojSoba.setText(String.valueOf(apartman.getBrojSoba()));
        if(apartman.isBalkon()== true){
         radioBalkonDA.setSelected(true);
        }else{
            radioBalkonNE.setSelected(true);
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        txtCena = new javax.swing.JTextField();
        radioRasoilozivoDA = new javax.swing.JRadioButton();
        radioRasoilozivoNE = new javax.swing.JRadioButton();
        radioBalkonDA = new javax.swing.JRadioButton();
        radioBalkonNE = new javax.swing.JRadioButton();
        txtBrojSoba = new javax.swing.JTextField();
        btnDodaj = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Kreiraj apartman"));

        jLabel1.setText("Naziv:");

        jLabel2.setText("Cena:");

        jLabel3.setText("Raspolozivost:");

        jLabel4.setText("Broj soba:");

        jLabel5.setText("Balkon:");

        radioRasoilozivoDA.setText("DA");

        radioRasoilozivoNE.setText("NE");

        radioBalkonDA.setText("DA");

        radioBalkonNE.setText("NE");

        btnDodaj.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDodaj.setText("DODAJ");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        jLabel6.setText("(€)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(radioBalkonDA)
                        .addGap(18, 18, 18)
                        .addComponent(radioBalkonNE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(radioRasoilozivoDA)
                        .addGap(18, 18, 18)
                        .addComponent(radioRasoilozivoNE))
                    .addComponent(txtNaziv)
                    .addComponent(txtBrojSoba, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCena, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(119, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(radioRasoilozivoDA)
                    .addComponent(radioRasoilozivoNE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtBrojSoba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(radioBalkonDA)
                        .addComponent(radioBalkonNE)))
                .addGap(10, 10, 10)
                .addComponent(btnDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        try {
            // TODO add your handling code here:
            if(this.apartman == null) {
                this.apartman = new Apartman();
            }
            
            this.apartman.setNazivApartmana(txtNaziv.getText());
            this.apartman.setCena(Integer.parseInt(txtCena.getText()));
              if(radioRasoilozivoDA.isSelected()){
                this.apartman.setRaspolozivost(true);
            }else{
                this.apartman.setRaspolozivost(false);
            }
 if(radioBalkonDA.isSelected()){
                this.apartman.setBalkon(true);
            }else{
                this.apartman.setBalkon(false);
            }

            this.apartman.setBrojSoba(Integer.parseInt(txtBrojSoba.getText()));
            
           
            String nazivAp = txtNaziv.getText();
            int cena = Integer.parseInt(txtCena.getText());
            validacijaKreirajGosta(nazivAp, cena);
           
       
            
            Komunikacija.getInstance().zapamtiApartman(apartman);
              JOptionPane.showMessageDialog(this, "Sistem je zapamtio apartman");
              GlavnaForma gf = (GlavnaForma) getParent();
            gf.azurirajAp();
              this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti apartman");
            Logger.getLogger(ZapamtiApartman.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }//GEN-LAST:event_btnDodajActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton radioBalkonDA;
    private javax.swing.JRadioButton radioBalkonNE;
    private javax.swing.JRadioButton radioRasoilozivoDA;
    private javax.swing.JRadioButton radioRasoilozivoNE;
    private javax.swing.JTextField txtBrojSoba;
    private javax.swing.JTextField txtCena;
    private javax.swing.JTextField txtNaziv;
    // End of variables declaration//GEN-END:variables

    private void validacijaKreirajGosta(String nazivAp, int cena) throws Exception {
            if(nazivAp.isEmpty() ){
           throw new Exception( "Morate uneti naziv apartmana!");
        }
        if(nazivAp.length()>10){
     throw new Exception( "Naziv apartmana ne moze da sadrzi vise od 10 karaktera!");
}
     if(cena<=0){
     throw new Exception( "Cena apartmana mora biti pozitivan broj!");
}


    }
}
