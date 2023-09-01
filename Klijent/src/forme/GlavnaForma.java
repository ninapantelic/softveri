/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forme;

import domen.Apartman;
import domen.Gost;
import domen.Menadzer;
import domen.Rezervacija;
import domen.Status;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import kontroler.Komunikacija;
import modeli.ModelTabeleApartmani;
import modeli.ModelTabeleGosti;
import modeli.ModelTabeleRezervacije;

/**
 *
 * @author LENOVO
 */
public class GlavnaForma extends javax.swing.JFrame {

    /**
     * Creates new form GlavnaForma
     */
    Menadzer m;
    ModelTabeleGosti modelGosti;
    Gost selektovaniGost;
    
    ModelTabeleApartmani modelApartmani;
    Apartman selektovaniApartman;
    
    ModelTabeleRezervacije modelRez;
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
    public GlavnaForma(Menadzer m) {
        initComponents();
        setLocationRelativeTo(null);
       // setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        this.m = m;
        lblMenazder.setText(m.getIme()+" " + m.getPrezime());
        
        popuniTabeluGostiju();
        popuniTabeluApartmana();
       popuniTabeluRezervacija();
        popuniCbStatus();
    }
    
    
    private void popuniTabeluGostiju() {
try {
            this.modelGosti = new ModelTabeleGosti(
                    Komunikacija.getInstance().ucitajListuGostiju()
            );
        
            tblGosti.setModel(this.modelGosti);
            
          
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da ucita sve goste");
            Logger.getLogger(IzmeniGosta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
      private void popuniTabeluApartmana() {
try {
            this.modelApartmani = new ModelTabeleApartmani(
                    Komunikacija.getInstance().ucitajListuApartmana()
            );
        
            tblApartmani.setModel(this.modelApartmani);
            
          
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da ucita sve apartmane");
            Logger.getLogger(IzmeniGosta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void popuniTabeluRezervacija() {
try {
            this.modelRez = new ModelTabeleRezervacije(
                    Komunikacija.getInstance().ucitajListuRezervacija()
            );
        
            tblRezervacije.setModel(this.modelRez);
            
          
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

        lblMenazder = new javax.swing.JLabel();
        btnKreirajRez = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblRezervacije = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtPretragaRez = new javax.swing.JTextField();
        btnIzabranGost = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtDatumDo1 = new javax.swing.JTextField();
        btnIzmeniRez = new javax.swing.JButton();
        btnIzabranApartman = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lblIzabraniAp = new javax.swing.JLabel();
        cbStatus1 = new javax.swing.JComboBox<>();
        txtIzabranGost = new javax.swing.JLabel();
        txtDatumOd1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblGosti = new javax.swing.JTable();
        txtSearchGost = new javax.swing.JTextField();
        txtSearchApartman = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblApartmani = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jmbGlavna = new javax.swing.JMenuBar();
        jmGost = new javax.swing.JMenu();
        miKreirajGosta = new javax.swing.JMenuItem();
        miIzmeniGosta = new javax.swing.JMenuItem();
        jmApartman = new javax.swing.JMenu();
        miKreirajApartman = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblMenazder.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMenazder.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnKreirajRez.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnKreirajRez.setText("<html>KREIRAJ<br>REZERVACIJU</html>");
        btnKreirajRez.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnKreirajRez.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKreirajRezActionPerformed(evt);
            }
        });

        jLabel3.setText("Pretrazi rezervaciju:");

        tblRezervacije.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tblRezervacije);

        jLabel1.setText("Pretrazi gosta:");

        jLabel7.setText("Status:");

        txtPretragaRez.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPretragaRezActionPerformed(evt);
            }
        });

        btnIzabranGost.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnIzabranGost.setForeground(new java.awt.Color(255, 0, 51));
        btnIzabranGost.setText("<html>  IZABERI GOSTA<br>ZA REZERVACIJU</html>");
        btnIzabranGost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzabranGostActionPerformed(evt);
            }
        });

        jLabel2.setText("Pretrazi apartman:");

        btnIzmeniRez.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnIzmeniRez.setText("IZMENI");
        btnIzmeniRez.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniRezActionPerformed(evt);
            }
        });

        btnIzabranApartman.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnIzabranApartman.setForeground(new java.awt.Color(255, 0, 0));
        btnIzabranApartman.setText("<html>  IZABERI APARTMAN<br>ZA REZERVACIJU</html>");
        btnIzabranApartman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzabranApartmanActionPerformed(evt);
            }
        });

        jLabel6.setText("Datum od:");

        lblIzabraniAp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblIzabraniAp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIzabraniAp.setToolTipText("");

        cbStatus1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtIzabranGost.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtIzabranGost.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        tblGosti.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblGosti);

        txtSearchGost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchGostActionPerformed(evt);
            }
        });

        txtSearchApartman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchApartmanActionPerformed(evt);
            }
        });

        jLabel8.setText("Datum do:");

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

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("MENADZER:");

        jmGost.setBorder(null);
        jmGost.setText("Gost");
        jmGost.setToolTipText("");

        miKreirajGosta.setText("Kreiraj gosta");
        miKreirajGosta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miKreirajGostaActionPerformed(evt);
            }
        });
        jmGost.add(miKreirajGosta);

        miIzmeniGosta.setText("Izmeni gosta");
        miIzmeniGosta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miIzmeniGostaActionPerformed(evt);
            }
        });
        jmGost.add(miIzmeniGosta);

        jmbGlavna.add(jmGost);

        jmApartman.setText("Apartman");

        miKreirajApartman.setText("Kreiraj apartman");
        miKreirajApartman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miKreirajApartmanActionPerformed(evt);
            }
        });
        jmApartman.add(miKreirajApartman);

        jMenuItem1.setText("Izmeni apartman");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jmApartman.add(jMenuItem1);

        jmbGlavna.add(jmApartman);

        setJMenuBar(jmbGlavna);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearchGost, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(327, 327, 327)
                        .addComponent(jLabel2)
                        .addGap(40, 40, 40)
                        .addComponent(txtSearchApartman, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(506, 506, 506)
                        .addComponent(btnIzabranApartman, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblIzabraniAp, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(146, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(lblMenazder, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(48, 48, 48))))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtDatumOd1)
                        .addComponent(txtDatumDo1)
                        .addComponent(cbStatus1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnIzabranGost, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIzabranGost, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPretragaRez, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(btnKreirajRez, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114)
                .addComponent(jScrollPane3)
                .addGap(179, 179, 179)
                .addComponent(btnIzmeniRez, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblMenazder, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtSearchGost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearchApartman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(txtIzabranGost, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnIzabranApartman, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnIzabranGost, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(lblIzabraniAp, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtPretragaRez, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addComponent(btnIzmeniRez, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(cbStatus1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel6)
                                            .addComponent(txtDatumOd1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(30, 30, 30)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel8)
                                            .addComponent(txtDatumDo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(38, 38, 38)))
                                .addGap(45, 45, 45)
                                .addComponent(btnKreirajRez, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miKreirajGostaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miKreirajGostaActionPerformed
        // TODO add your handling code here:
        new ZapamtiGosta(this, true).setVisible(true);
    }//GEN-LAST:event_miKreirajGostaActionPerformed

    private void miKreirajApartmanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miKreirajApartmanActionPerformed
        // TODO add your handling code here:
        new ZapamtiApartman(this, true).setVisible(true);
    }//GEN-LAST:event_miKreirajApartmanActionPerformed

    private void miIzmeniGostaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miIzmeniGostaActionPerformed

        // TODO add your handling code here:
        new IzmeniGosta(this, true).setVisible(true);
    }//GEN-LAST:event_miIzmeniGostaActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        new IzmeniApartman(this, true).setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnKreirajRezActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKreirajRezActionPerformed
        try {
            // TODO add your handling code here:
            Date datumOd = sdf.parse(txtDatumOd1.getText());
            Date datumDo = sdf.parse(txtDatumDo1.getText());
            Status status = (Status) cbStatus1.getSelectedItem();
            long diffInMillis = datumDo.getTime() - datumOd.getTime();
            int brojDana =(int)TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);

            int ukupnaCena = brojDana*selektovaniApartman.getCena();
            Rezervacija rezervacija = new Rezervacija();
            rezervacija.setApartman(selektovaniApartman);
            rezervacija.setGost(selektovaniGost);
            rezervacija.setMenadzer(m);
            rezervacija.setDatumOd(datumOd);
            rezervacija.setDatumDo(datumDo);
            rezervacija.setStatus(status);
            rezervacija.setUkupnaCena(ukupnaCena);
            
            
            Komunikacija.getInstance().zapamtiRezervaciju(rezervacija);
            JOptionPane.showMessageDialog(this, "Sistem je zapamtio rezervaciju");

            azurirajRezervacije();

        } catch (ParseException ex) {
            Logger.getLogger(GlavnaForma.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti rezervaciju");
            Logger.getLogger(GlavnaForma.class.getName()).log(Level.SEVERE, null, ex);

        }
    }//GEN-LAST:event_btnKreirajRezActionPerformed

    private void btnIzabranGostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzabranGostActionPerformed
        // TODO add your handling code here:
        int selected = tblGosti.getSelectedRow();
        if(selected>=0){
            Gost selektovaniGost = modelGosti.vratiSelektovanogGosta(selected);
            this.selektovaniGost=selektovaniGost;
            txtIzabranGost.setText(selektovaniGost.getIme()+" " + selektovaniGost.getPrezime());
        }
    }//GEN-LAST:event_btnIzabranGostActionPerformed

    private void btnIzabranApartmanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzabranApartmanActionPerformed
        // TODO add your handling code here:
        int selected = tblApartmani.getSelectedRow();
        if(selected>=0){
            Apartman selektovaniApartman = modelApartmani.vratiSelektovanApartman(selected);
            this.selektovaniApartman=selektovaniApartman;
            lblIzabraniAp.setText(selektovaniApartman.getNazivApartmana());
        }
    }//GEN-LAST:event_btnIzabranApartmanActionPerformed

    private void txtSearchGostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchGostActionPerformed
        // TODO add your handling code here:
        Gost param = new Gost();
        param.setIme(txtSearchGost.getText());
        param.setPrezime(txtSearchGost.getText());
        param.setKorisnickoIme(txtSearchGost.getText());
        param.setLozinka(txtSearchGost.getText());

        try {
            this.modelGosti = new ModelTabeleGosti(
                Komunikacija.getInstance().pretraziGoste(param)
            );

            tblGosti.setModel(this.modelGosti);

            if(this.modelGosti.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Sistem ne moze da nadje goste po zadatoj vrednosti");
            } else {

                JOptionPane.showMessageDialog(this, "Sistem je nasao goste po zadatoj vrednosti");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da nadje goste po zadatoj vrednosti");
            Logger.getLogger(IzmeniGosta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtSearchGostActionPerformed

    private void txtSearchApartmanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchApartmanActionPerformed
        // TODO add your handling code here:
        Apartman param = new Apartman();
        String pretraga = txtSearchApartman.getText().trim();
        param.setNazivApartmana(txtSearchApartman.getText().trim());

        try {
            int brojSoba = Integer.parseInt(pretraga);
            param.setBrojSoba(brojSoba);
        } catch (NumberFormatException e) {

        }

        try {
            this.modelApartmani = new ModelTabeleApartmani(
                Komunikacija.getInstance().pretraziApartmane(param)
            );

            tblApartmani.setModel(this.modelApartmani);

            if(this.modelApartmani.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Sistem ne moze da nadje apartmane po zadatoj vrednosti");
            } else {

                JOptionPane.showMessageDialog(this, "Sistem je nasao apartmane po zadatoj vrednosti");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da nadje goste po zadatoj vrednosti");
            Logger.getLogger(IzmeniGosta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtSearchApartmanActionPerformed

    private void txtPretragaRezActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPretragaRezActionPerformed
        // TODO add your handling code here:
         Rezervacija param = new Rezervacija();
        Gost g = new Gost();
        g.setIme(txtPretragaRez.getText());
        g.setPrezime(txtPretragaRez.getText());
        param.setGost(g);

        
        try {
            this.modelRez = new ModelTabeleRezervacije(
                    Komunikacija.getInstance().pretraziRezervacije(param)
            );
        
         tblRezervacije.setModel(this.modelRez);
            
          
            
            if(this.modelRez.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Sistem ne moze da nadje rezervacije po zadatoj vrednosti");
            } else {
                
                JOptionPane.showMessageDialog(this, "Sistem je nasao rezervacije po zadatoj vrednosti");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da nadje rezervacije po zadatoj vrednosti");
            Logger.getLogger(IzmeniGosta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtPretragaRezActionPerformed

    private void btnIzmeniRezActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniRezActionPerformed
    
            // TODO add your handling code here:
             int selected = tblRezervacije.getSelectedRow();
        
        if(selected >= 0) {
            Rezervacija rezervacija = modelRez.vratiSelektovanuRezervaciju(selected);
            
            try {
                rezervacija = Komunikacija.getInstance().ucitajRezervaciju(rezervacija);
                
               // System.out.println(  rezervacija.getListaRecenzija());
          
       DijalogPretraziRecenzije d = new DijalogPretraziRecenzije(this, true,rezervacija);
       d.setVisible(true);
       
         azurirajRezervacije();
        } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Sistem ne moze da ucita rezervaciju");
                Logger.getLogger(IzmeniGosta.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_btnIzmeniRezActionPerformed
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzabranApartman;
    private javax.swing.JButton btnIzabranGost;
    private javax.swing.JButton btnIzmeniRez;
    private javax.swing.JButton btnKreirajRez;
    private javax.swing.JComboBox<Object> cbStatus1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JMenu jmApartman;
    private javax.swing.JMenu jmGost;
    private javax.swing.JMenuBar jmbGlavna;
    private javax.swing.JLabel lblIzabraniAp;
    private javax.swing.JLabel lblMenazder;
    private javax.swing.JMenuItem miIzmeniGosta;
    private javax.swing.JMenuItem miKreirajApartman;
    private javax.swing.JMenuItem miKreirajGosta;
    private javax.swing.JTable tblApartmani;
    private javax.swing.JTable tblGosti;
    private javax.swing.JTable tblRezervacije;
    private javax.swing.JTextField txtDatumDo1;
    private javax.swing.JTextField txtDatumOd1;
    private javax.swing.JLabel txtIzabranGost;
    private javax.swing.JTextField txtPretragaRez;
    private javax.swing.JTextField txtSearchApartman;
    private javax.swing.JTextField txtSearchGost;
    // End of variables declaration//GEN-END:variables

    public void azuriraj() {
        try {
            this.modelGosti = new ModelTabeleGosti(
                    Komunikacija.getInstance().ucitajListuGostiju()
            );
        
            tblGosti.setModel(this.modelGosti);
            
          
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da ucita sve goste");
            Logger.getLogger(IzmeniGosta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  public  void azurirajAp() {
  try {
            this.modelApartmani = new ModelTabeleApartmani(
                    Komunikacija.getInstance().ucitajListuApartmana()
            );
        
            tblApartmani.setModel(this.modelApartmani);
            
          
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da ucita sve apartmane");
            Logger.getLogger(IzmeniGosta.class.getName()).log(Level.SEVERE, null, ex);
        }
  }

    public JComboBox<Object> getCbStatus1() {
        return cbStatus1;
    }

 

    private void popuniCbStatus() {
        getCbStatus1().removeAllItems();
        for(Status s: Status.values()){
            getCbStatus1().addItem(s);
        }
    }

    private void azurirajRezervacije() {
 try {
            this.modelRez = new ModelTabeleRezervacije(
                    Komunikacija.getInstance().ucitajListuRezervacija()
            );
        
            tblRezervacije.setModel(this.modelRez);
            
          
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da ucita sve rezervacije");
            Logger.getLogger(IzmeniGosta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

  
}
