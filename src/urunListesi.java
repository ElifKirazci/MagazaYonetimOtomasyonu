
import Property.cinsiyetPro;
import Property.kategoriPro;
import Property.urunPro;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class urunListesi extends javax.swing.JFrame {

    DB db = new DB("personelyonetimi", "root", "");
    ArrayList<String> uls = new ArrayList<>();

    public urunListesi() {
        initComponents();
        tableDoldur();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtArama = new javax.swing.JTextField();
        btnAra = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUrunList = new javax.swing.JTable();
        btnSil = new javax.swing.JButton();
        btnSec = new javax.swing.JButton();
        btnYenile = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(238, 234, 253));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ürün Listesi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        txtArama.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnAra.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/seç.png"))); // NOI18N
        btnAra.setText("Ara");
        btnAra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAraActionPerformed(evt);
            }
        });

        tblUrunList.setModel(new javax.swing.table.DefaultTableModel(
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
        tblUrunList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUrunListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUrunList);

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

        btnYenile.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnYenile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/yenile.png"))); // NOI18N
        btnYenile.setText("Yenile");
        btnYenile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYenileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnSil, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(221, 221, 221)
                                .addComponent(btnYenile)
                                .addGap(65, 65, 65)
                                .addComponent(btnSec, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtArama, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(btnAra, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtArama, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAra))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSil)
                        .addComponent(btnSec))
                    .addComponent(btnYenile)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAraActionPerformed
        if (txtArama.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen aramak istediğiniz ürünü yazınız");
        } else {
            AramaButonu();
        }

    }//GEN-LAST:event_btnAraActionPerformed
    String satir = "";
    int roww;
    static String urunID = "";
    static urunPro upro = null;
    static kategoriPro kpro = null;
    static cinsiyetPro cpro = null;
    private void btnSecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSecActionPerformed
        SecmeButonu();
    }//GEN-LAST:event_btnSecActionPerformed

    private void tblUrunListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUrunListMouseClicked
        urunListMouseClicked();
    }//GEN-LAST:event_tblUrunListMouseClicked

    private void btnSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSilActionPerformed
        SilmeButonu();
    }//GEN-LAST:event_btnSilActionPerformed

    private void btnYenileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYenileActionPerformed
        tableDoldur();
    }//GEN-LAST:event_btnYenileActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        new mudurEkrani2().setVisible(true);
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
            java.util.logging.Logger.getLogger(urunListesi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(urunListesi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(urunListesi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(urunListesi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new urunListesi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAra;
    private javax.swing.JButton btnSec;
    private javax.swing.JButton btnSil;
    private javax.swing.JButton btnYenile;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblUrunList;
    private javax.swing.JTextField txtArama;
    // End of variables declaration//GEN-END:variables
public void tableDoldur() {
        uls.clear();
        try {
            int cinsiyetID = 0;
            int kategoriID = 0;
            String personelQuery = "{call urunTablosuBirlestirme ('" + cinsiyetID + "','" + kategoriID + "')} ";
            ResultSet rs = db.baglan().executeQuery(personelQuery);
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("Barkod No");
            dtm.addColumn("Cinsiyet");
            dtm.addColumn("Kategori");
            dtm.addColumn("Renk");
            dtm.addColumn("Beden");
            dtm.addColumn("Ürünün Geliş Tarihi");
            dtm.addColumn("Alış Fiyatı");
            dtm.addColumn("Satış Fiyatı");
            dtm.addColumn("Stok Adedi");
            dtm.addColumn("Detay");
            dtm.addColumn("Resim");

            while (rs.next()) {
                uls.add(rs.getString("urunID"));
                dtm.addRow(new String[]{rs.getString("urun_barkodno"), rs.getString("cinsiyet"), rs.getString("kategori"), rs.getString("renk"), rs.getString("beden"), rs.getString("urunGelisTarihi"), rs.getString("alisfiyati"), rs.getString("satisfiyati"), rs.getString("stokadedi"), rs.getString("detay"), rs.getString("resim")});
            }
            tblUrunList.setModel(dtm);
        } catch (SQLException e) {
            System.err.println("Urun Data Getirme Hatası : " + e);
        }
    }

    public void AramaButonu() {
        uls.clear();
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Barkod No");
        dtm.addColumn("Cinsiyet");
        dtm.addColumn("Kategori");
        dtm.addColumn("Renk");
        dtm.addColumn("Beden");
        dtm.addColumn("Ürünün Geliş Tarihi");
        dtm.addColumn("Alış Fiyatı");
        dtm.addColumn("Satış Fiyatı");
        dtm.addColumn("Stok Adedi");
        dtm.addColumn("Detay");
        dtm.addColumn("Resim");
        String data = fullConvert(txtArama.getText().trim());

        try {
            String personelQuery = "{call urunArama ('" + data + "')} ";
            ResultSet rs = db.baglan().executeQuery(personelQuery);
            while (rs.next()) {
                uls.add(rs.getString("urunID"));
                dtm.addRow(new String[]{rs.getString("urun_barkodno"), rs.getString("cinsiyet"), rs.getString("kategori"), rs.getString("renk"), rs.getString("beden"), rs.getString("urunGelisTarihi"), rs.getString("alisfiyati"), rs.getString("satisfiyati"), rs.getString("stokadedi"), rs.getString("detay"), rs.getString("resim")});
            }
            tblUrunList.setModel(dtm);
        } catch (SQLException e) {
            System.err.println("Arama Hatası : " + e);
        }
    }

    public void SecmeButonu() {
        if (satir.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen Seçim Yapınız");
        } else {
            new mudurEkrani2().setVisible(true);
            dispose();
        }
    }

    public void urunListMouseClicked() {
        roww = tblUrunList.getSelectedRow();
        System.out.println("uls get:" + roww);
        urunID = uls.get(roww);
        if (roww > -1) {
            satir = "" + tblUrunList.getValueAt(roww, 0);
            urunPro urp = new urunPro();
            kategoriPro kap = new kategoriPro();
            cinsiyetPro cip = new cinsiyetPro();
            urp.setUrunBarkod(Integer.valueOf((String) tblUrunList.getValueAt(roww, 0)));
            cip.setCinsiyet("" + tblUrunList.getValueAt(roww, 1));
            kap.setKategori("" + tblUrunList.getValueAt(roww, 2));
            urp.setRenk("" + tblUrunList.getValueAt(roww, 3));
            urp.setUrunBeden("" + tblUrunList.getValueAt(roww, 4));
            urp.setUrunGelisTarihi("" + tblUrunList.getValueAt(roww, 5));
            urp.setAlisfiyati(Float.valueOf((String) tblUrunList.getValueAt(roww, 6)));
            urp.setSatisfiyati(Float.valueOf((String) tblUrunList.getValueAt(roww, 7)));
            urp.setStokadedi(Integer.valueOf((String) tblUrunList.getValueAt(roww, 8)));
            urp.setDetay("" + tblUrunList.getValueAt(roww, 9));
            urp.setResim("" + tblUrunList.getValueAt(roww, 10));
            upro = urp;
            kpro = kap;
            cpro = cip;
        }
    }

    public void SilmeButonu() {
        if (satir.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen Seçim Yapınız");
        } else {
            int cevap = JOptionPane.showConfirmDialog(rootPane, "Kayıtlar geri alınamaz, silmek istediğinize emin misiniz?", "Silme İşlemi", JOptionPane.YES_NO_OPTION);
            if (cevap == 0) {
                try {
                    String silQuery = "{call urunSil ( '" + urunID + "' )}";
                    int silSonuc = db.baglan().executeUpdate(silQuery);
                    if (silSonuc > 0) {
                        tableDoldur();
                        JOptionPane.showMessageDialog(rootPane, "Silme İşlemi Başarılı");
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Silme İşlemi Başarısız");
                    }
                } catch (Exception e) {
                    System.err.println("Urun Silme Hatası : " + e);
                }
            }
        }
    }

    public String fullConvert(String data) {
        String gonder = "";
        String[] dizi = data.split(" ");
        for (String item : dizi) {
            if (!item.trim().equals("")) {
                gonder += item + "*";
            }
        }
        return gonder;
    }
}
