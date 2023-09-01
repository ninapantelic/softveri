/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package forme;

import domen.Apartman;
import javax.swing.JOptionPane;
import kontroler.Komunikacija;
import modeli.ModelTabeleApartmani;

import java.util.logging.Level;
import java.util.logging.Logger;
import modeli.ModelTabeleGosti;
/**
 *
 * @author LENOVO
 */
public class IzmeniApartman extends javax.swing.JDialog {

    /**
     * Creates new form IzmeniApartman
     */
    private java.awt.Frame parent;
    ModelTabeleApartmani model;
    public IzmeniApartman(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
       this.parent = parent;
        initComponents();
        setLocationRelativeTo(null);

        pripremiTabelu();
    }
      private void pripremiTabelu() {
 try {
            this.model = new ModelTabeleApartmani(
                    Komunikacija.getInstance().ucitajListuApartmana()
            );
        
            tblApartmani.setModel(this.model);
            
          
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da ucita sve goste");
            Logger.getLogger(IzmeniGosta.class.getName()).log(Level.SEVERE, null, ex);
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
        txtPretraga = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblApartmani = new javax.swing.JTable();
        btnIzmeni = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Apartmani"));

        jLabel1.setText("Pretraga:");

        txtPretraga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPretragaActionPerformed(evt);
            }
        });

        tblApartmani.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblApartmani);

        btnIzmeni.setText("IZMENI");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPretraga)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(btnIzmeni, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPretraga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(7, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnIzmeni, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101))))
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

    private void txtPretragaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPretragaActionPerformed
        // TODO add your handling code here:
      Apartman param = new Apartman();
String pretraga = txtPretraga.getText().trim(); 
param.setNazivApartmana(txtPretraga.getText().trim()); 

try {
    int brojSoba = Integer.parseInt(pretraga);
    param.setBrojSoba(brojSoba);
} catch (NumberFormatException e) {
    
}

        try {
            this.model = new ModelTabeleApartmani(
                    Komunikacija.getInstance().pretraziApartmane(param)
            );

            tblApartmani.setModel(this.model);

            if(this.model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Sistem ne moze da nadje apartmane po zadatoj vrednosti");
            } else {

                JOptionPane.showMessageDialog(this, "Sistem je nasao apartmane po zadatoj vrednosti");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da nadje goste po zadatoj vrednosti");
            Logger.getLogger(IzmeniGosta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtPretragaActionPerformed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
        // TODO add your handling code here:
        int selected = tblApartmani.getSelectedRow();

        if(selected >= 0) {
            Apartman apartman = model.vratiSelektovanApartman(selected);

            try {
                apartman = Komunikacija.getInstance().ucitajApartman(apartman);

                JOptionPane.showMessageDialog(this, "Sistem je ucitao apartman");

                ZapamtiApartman za = new ZapamtiApartman(this.parent, true);
                za.setApartman(apartman);
                za.setVisible(true);
                pripremiTabelu();
                GlavnaForma gf = (GlavnaForma) getParent();
                gf.azurirajAp();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Sistem ne moze da ucita apartman");
                Logger.getLogger(IzmeniGosta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnIzmeniActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblApartmani;
    private javax.swing.JTextField txtPretraga;
    // End of variables declaration//GEN-END:variables

  
}
