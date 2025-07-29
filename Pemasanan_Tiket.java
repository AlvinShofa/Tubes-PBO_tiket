package tubes_tiket;

/**
 *
 * @author kezia
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Date;



public class Pemasanan_Tiket extends javax.swing.JFrame {


    int harga=0;
    float diskon = 5/100, pajak, total=0, total_pembayaran, disk_val;
    public java.sql.Statement st;
    public ResultSet rs;
    String sql, wahana, tiket, tanggal, insert, nama, email;
    
    public Pemasanan_Tiket(String Nama, String Email) {
        initComponents();
        
        nama = Nama;
        email = Email;
    }

    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbx_wahana = new javax.swing.JComboBox();
        cbx_tiket = new javax.swing.JComboBox();
        btn_x = new javax.swing.JButton();
        btn_pesan = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        cek_tiket = new javax.swing.JButton();
        jCalendar1 = new com.toedter.calendar.JCalendar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(2000, 1200));
        setSize(new java.awt.Dimension(2000, 1200));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 55)); // NOI18N
        jLabel1.setText("PEMESANAN TIKET");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 40)); // NOI18N
        jLabel2.setText("Jenis Wahana  :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 40)); // NOI18N
        jLabel3.setText("Jenis Tiket      :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 40)); // NOI18N
        jLabel4.setText("Tanggal Pesan :");

        cbx_wahana.setFont(new java.awt.Font("Tahoma", 0, 40)); // NOI18N
        cbx_wahana.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Pilihan-", "Roller Coaster", "Bianglala", "Kora-kora", "Komidi Putar", "Rumah Hantu", "Mini Trampolin", "Circus", "Semua Wahana" }));
        cbx_wahana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_wahanaActionPerformed(evt);
            }
        });

        cbx_tiket.setFont(new java.awt.Font("Tahoma", 0, 40)); // NOI18N
        cbx_tiket.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Pilihan-", "Reguler", "Fast Track" }));
        cbx_tiket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_tiketActionPerformed(evt);
            }
        });

        btn_x.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btn_x.setText("X");
        btn_x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xActionPerformed(evt);
            }
        });

        btn_pesan.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btn_pesan.setText("Pesan");
        btn_pesan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pesanActionPerformed(evt);
            }
        });

        btn_clear.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btn_clear.setText("Clear");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        cek_tiket.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        cek_tiket.setText("Cek Tiket");
        cek_tiket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cek_tiketActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_x, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(734, 734, 734)
                        .addComponent(jLabel1)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_clear)
                .addGap(20, 20, 20)
                .addComponent(btn_pesan)
                .addGap(20, 20, 20)
                .addComponent(cek_tiket)
                .addGap(155, 155, 155))
            .addGroup(layout.createSequentialGroup()
                .addGap(680, 680, 680)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbx_wahana, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbx_tiket, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(583, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_x)
                .addGap(59, 59, 59)
                .addComponent(jLabel1)
                .addGap(104, 104, 104)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbx_wahana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbx_tiket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(93, 93, 93)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_pesan)
                            .addComponent(cek_tiket)
                            .addComponent(btn_clear))
                        .addGap(72, 72, 72))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(315, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbx_wahanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_wahanaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_wahanaActionPerformed

    private void cbx_tiketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_tiketActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_tiketActionPerformed

    private void btn_xActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xActionPerformed
        // TODO add your handling code here:
        new TUBES_LOGIN().setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_xActionPerformed

    private void btn_pesanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pesanActionPerformed
        // TODO add your handling code here:
        
        wahana = cbx_wahana.getSelectedItem().toString();
        tiket = cbx_tiket.getSelectedItem().toString();
        Date selectedDate = jCalendar1.getDate();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        tanggal = dateFormat.format(selectedDate);
        
        
        try {
        
            Connection c =koneksi.getkoneksi();
            st = c.createStatement();
            
            sql = "select harga from wahana where nama_wahana = '"+wahana+"';";
            rs = st.executeQuery(sql);
            
            if (rs.next()){
                
                harga = rs.getInt("harga");
               
                if (tiket.equals("Fast Track")){
                
                int Harga = harga + 25000;
                
                    if (wahana.equals("Semua Wahana")){
                        disk_val = Harga - (diskon * Harga);
                    
                        total = (Harga + (Harga - (diskon * Harga)));
                        pajak = total * 10/100;
                        total_pembayaran = pajak + total;
                    
                    }else {
                        disk_val = 0;
                    
                        total = Harga;
                        pajak = total * 10/100;
                        total_pembayaran = pajak + total;
                    }
                
                }else {
                
                    if (wahana.equals("Semua Wahana")){
                        disk_val = harga - (diskon * harga);
                    
                        total = (harga + (harga - (diskon * harga)));
                        pajak = total * 10/100;
                        total_pembayaran = pajak + total;
                    }else {
                        disk_val = 0;
                    
                        total = harga;
                        pajak = total * 10/100;
                        total_pembayaran = pajak + total;
                    }
                }
            
            new INVOICE_TUBES_2(nama, email, wahana, harga, disk_val, total_pembayaran, tanggal, tiket, pajak).setVisible(true);
            dispose(); 
            
            }else{
                JOptionPane.showMessageDialog(this, "Tidak Ada Dalam Database");
            }    

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }//GEN-LAST:event_btn_pesanActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        // TODO add your handling code here:
        cbx_wahana.setSelectedItem("-Pilihan-");
        cbx_tiket.setSelectedItem("-Pilihan-");
         jCalendar1.setDate(null);
    }//GEN-LAST:event_btn_clearActionPerformed

    private void cek_tiketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cek_tiketActionPerformed
        // TODO add your handling code here:
        new Datatiket(email).setVisible(true);
    }//GEN-LAST:event_cek_tiketActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PEMESANAN_TIKET.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PEMESANAN_TIKET.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PEMESANAN_TIKET.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PEMESANAN_TIKET.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_pesan;
    private javax.swing.JButton btn_x;
    private javax.swing.JComboBox cbx_tiket;
    private javax.swing.JComboBox cbx_wahana;
    private javax.swing.JButton cek_tiket;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
