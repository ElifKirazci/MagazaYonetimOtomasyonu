
import Property.gorevPro;
import Property.personelpro;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class personelList extends javax.swing.JFrame {

    DB db = new DB("personelyonetimi", "root", "");
    ArrayList<String> plsid = new ArrayList<>();

    public personelList() {
        initComponents();
        tableDoldur();
    }

    public void tableDoldur() {
        plsid.clear();
        try {
            int cid = 0;
            String personelQuery = "{call gorevKaydet ('" + cid + "')} ";
            ResultSet rs = db.baglan().executeQuery(personelQuery);
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("TC_No");
            dtm.addColumn("Adı");
            dtm.addColumn("Soyadı");
            dtm.addColumn("Cinsiyeti");
            dtm.addColumn("Doğum Yeri");
            dtm.addColumn("Doğum Tarihi");
            dtm.addColumn("Ev Telefonu");
            dtm.addColumn("Cep Telefonu");
            dtm.addColumn("Email");
            dtm.addColumn("Adres");
            dtm.addColumn("İşe Başlama Tarihi");
            dtm.addColumn("Resim");
            dtm.addColumn("Çalışanın Görevi");

            while (rs.next()) {
                plsid.add(rs.getString("pid"));
                dtm.addRow(new String[]{rs.getString("ptc"), rs.getString("padi"), rs.getString("psoyadi"), rs.getString("pcinsiyeti"), rs.getString("pdogumyeri"), rs.getString("pdogumtarihi"), rs.getString("pevtel"), rs.getString("pceptel"), rs.getString("pmail"), rs.getString("padres"), rs.getString("pbaslamatarihi"), rs.getString("presim"), rs.getString("cgorevi")});
            }
            tblPersonelList.setModel(dtm);
        } catch (SQLException e) {
            System.err.println("Personel Datası Getirme Hatası : " + e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPersonelList = new javax.swing.JTable();
        btnSil = new javax.swing.JButton();
        btnSec = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(238, 234, 253));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Personel Listesi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        tblPersonelList.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPersonelList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPersonelListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPersonelList);

        btnSil.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/silme.png"))); // NOI18N
        btnSil.setText("Sil");
        btnSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSilActionPerformed(evt);
            }
        });

        btnSec.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/seç.png"))); // NOI18N
        btnSec.setText("Seç");
        btnSec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSecActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnSil, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSec, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSec, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSecActionPerformed
        if (satir.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen Seçim Yapınız");
        } else {
            mudurEkrani2 me = new mudurEkrani2();
            me.setVisible(true);
            me.personelPanelAc();
            dispose();
        }
    }//GEN-LAST:event_btnSecActionPerformed
    String satir = "";
    int roww;
    static String pid = "";
    static personelpro pro = null;
    static gorevPro gpro = null;
    private void tblPersonelListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPersonelListMouseClicked
        roww = tblPersonelList.getSelectedRow();
        pid = plsid.get(roww);
        if (roww > -1) {
            satir = "" + tblPersonelList.getValueAt(roww, 0);
            personelpro pr = new personelpro();
            gorevPro gp = new gorevPro();
            pr.setPtc("" + tblPersonelList.getValueAt(roww, 0));
            pr.setPadi("" + tblPersonelList.getValueAt(roww, 1));
            pr.setPsoyadi("" + tblPersonelList.getValueAt(roww, 2));
            pr.setPcinsiyeti("" + tblPersonelList.getValueAt(roww, 3));
            pr.setPdogumyeri("" + tblPersonelList.getValueAt(roww, 4));
            pr.setPdogumtarihi("" + tblPersonelList.getValueAt(roww, 5));
            pr.setPevtel("" + tblPersonelList.getValueAt(roww, 6));
            pr.setPceptel("" + tblPersonelList.getValueAt(roww, 7));
            pr.setPmail("" + tblPersonelList.getValueAt(roww, 8));
            pr.setPadres("" + tblPersonelList.getValueAt(roww, 9));
            pr.setPbaslamatarihi("" + tblPersonelList.getValueAt(roww, 10));
//            pr.setPresim(""+tblPersonelList.getValueAt(roww, 11));
            pr.setPresim("" + tblPersonelList.getValueAt(roww, 11));
            gp.setCgorevi("" + tblPersonelList.getValueAt(roww, 12));
//            lblpersonel.setIcon(ResizeImage(pertabList.get(jTable6.getSelectedRow()).getResim(), null));

            pro = pr;
            gpro = gp;
        }
    }//GEN-LAST:event_tblPersonelListMouseClicked

    private void btnSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSilActionPerformed
        if (satir.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen Seçim Yapınız");
        } else {
            int cevap = JOptionPane.showConfirmDialog(rootPane, "Kayıtlar geri alınamaz, silmek istediğinize emin misiniz?", "Silme İşlemi", JOptionPane.YES_NO_OPTION);
            if (cevap == 0) {
                try {
                    String silQuery = "{call personelSil ( '" + pid + "' )}";
                    int silSonuc = db.baglan().executeUpdate(silQuery);
                    if (silSonuc > 0) {
                        tableDoldur();
                        JOptionPane.showMessageDialog(rootPane, "Silme İşlemi Başarılı");
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Silme İşlemi Başarısız");
                    }
                } catch (Exception e) {
                    System.err.println("Personel Listesinden Silme Hatası : " + e);
                }
            }
        }
    }//GEN-LAST:event_btnSilActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        mudurEkrani2 me = new mudurEkrani2();
        me.setVisible(true);
        me.personelPanelAc();
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(personelList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(personelList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(personelList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(personelList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new personelList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSec;
    private javax.swing.JButton btnSil;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPersonelList;
    // End of variables declaration//GEN-END:variables
}
