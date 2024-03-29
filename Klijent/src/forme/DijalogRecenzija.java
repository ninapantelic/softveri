/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package forme;

import domen.Gost;
import domen.Recenzija;
import domen.Rezervacija;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import kontroler.Komunikacija;
import modeli.ModelTabeleRezervacije;

/**
 *
 * @author LENOVO
 */
public class DijalogRecenzija extends javax.swing.JDialog {

    /**
     * Creates new form DijalogRecenzija
     */
    Gost ulogovaniGost;
    ModelTabeleRezervacije modelRez;
    Rezervacija rezervacija;

    public DijalogRecenzija(java.awt.Frame parent, boolean modal, Gost ulogovaniGost) {
        super(parent, modal);
        initComponents();
        this.ulogovaniGost = ulogovaniGost;
        lblGost.setText(ulogovaniGost.toString());
        setLocationRelativeTo(null);

        cbOcena.addItem(1);
        cbOcena.addItem(2);
        cbOcena.addItem(3);
        cbOcena.addItem(4);
        cbOcena.addItem(5);
        popuniTabeluRezervacija();

    }

    private void popuniTabeluRezervacija() {
        try {
            ArrayList<Rezervacija> lista = Komunikacija.getInstance().ucitajListuRezervacija();
            ArrayList<Rezervacija> listaDatogGosta = new ArrayList<>();

            for (Rezervacija rez : lista) {
                if (rez.getGost().getGostID() == ulogovaniGost.getGostID()) {
                    listaDatogGosta.add(rez);
                    if (rez.getListaRecenzija() != null) {
                        System.out.println(rez.getListaRecenzija().toString());
                    } else {
                        System.out.println("prazno");
                    }
                }
            }

            this.modelRez = new ModelTabeleRezervacije(
                    listaDatogGosta
            );

            tblRezerv.setModel(this.modelRez);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da ucita sve rezervacije");
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

        lblGost = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtKomentar = new javax.swing.JTextArea();
        btnDodajRecenziju = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbOcena = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblRezerv = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblGost.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblGost.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGost.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setText("Ostavite vasu recenziju....");

        txtKomentar.setColumns(20);
        txtKomentar.setRows(5);
        jScrollPane1.setViewportView(txtKomentar);

        btnDodajRecenziju.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDodajRecenziju.setText("<html>DODAJ<br>RECENZIJU</html>");
        btnDodajRecenziju.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDodajRecenziju.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajRecenzijuActionPerformed(evt);
            }
        });

        jLabel1.setText("Ocena:");

        tblRezerv.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblRezerv);

        jLabel4.setText("Izbor rezervacije:");

        jButton1.setText("IZABERI");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(29, 29, 29)
                                .addComponent(lblGost, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(41, 41, 41)
                                        .addComponent(jLabel1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cbOcena, 0, 96, Short.MAX_VALUE)
                                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(267, 267, 267)
                        .addComponent(btnDodajRecenziju, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblGost, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(cbOcena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnDodajRecenziju, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JComboBox<Integer> getCbOcena() {
        return cbOcena;
    }


    private void btnDodajRecenzijuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajRecenzijuActionPerformed
        // TODO add your handling code here:
        String komentar = txtKomentar.getText();
        int ocena = (int) cbOcena.getSelectedItem();
        Recenzija r = new Recenzija();

        r.setRezervacija(rezervacija);
        r.setKomentar(komentar);
        r.setOcena(ocena);

        ArrayList<Recenzija> recenzijeZaTogGosta = new ArrayList<>();
        try {
            Komunikacija.getInstance().zapamtiRecenziju(r);

            JOptionPane.showMessageDialog(this, "Sistem je zapamtio recenziju");

            ArrayList<Recenzija> listaRecenzija = Komunikacija.getInstance().ucitajListuRecenzija();

            for (Recenzija rec : listaRecenzija) {

                if (rec.getRezervacija().getGost().getGostID() == ulogovaniGost.getGostID()) {

                    recenzijeZaTogGosta.add(rec);
                }
            }

            rezervacija.setListaRecenzija(recenzijeZaTogGosta);
            System.out.println("ta ista rezervacija,sada je njena recenzija: " + rezervacija.getListaRecenzija());
            FormaRecenzija fr = (FormaRecenzija) getParent();
            fr.popuniTabeluRecenzija();
            fr.popuniTabeluRecenzijaZaUlogovanog();

        } catch (IOException ex) {
            Logger.getLogger(DijalogRecenzija.class.getName()).log(Level.SEVERE, null, ex);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sistem nije zapamtio recenziju");
            Logger.getLogger(DijalogRecenzija.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnDodajRecenzijuActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int selected = tblRezerv.getSelectedRow();

        if (selected >= 0) {
            this.rezervacija = modelRez.vratiSelektovanuRezervaciju(selected);

            try {
                this.rezervacija = Komunikacija.getInstance().ucitajRezervaciju(this.rezervacija);
                System.out.println(rezervacija);
                JOptionPane.showMessageDialog(this, "Sistem je ucitao rezervaciju");
                System.out.println("ucitana rezervacija, njena recenzija je: " + rezervacija.getListaRecenzija());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Sistem ne moze da ucita rezervaciju");
                Logger.getLogger(IzmeniGosta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajRecenziju;
    private javax.swing.JComboBox<Integer> cbOcena;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblGost;
    private javax.swing.JTable tblRezerv;
    private javax.swing.JTextArea txtKomentar;
    // End of variables declaration//GEN-END:variables

}
