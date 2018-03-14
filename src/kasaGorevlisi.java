
import Property.personelpro;
import Property.urunPro;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class kasaGorevlisi extends javax.swing.JFrame {

    DB db = new DB("personelyonetimi", "root", "");
    urunListesi ul = new urunListesi();
    ArrayList<String> kgls = null;
    ArrayList<String> barkodLs = null;
    ArrayList<urunPro> up = new ArrayList<>();
    ArrayList<personelpro> pp = new ArrayList<>();
    ArrayList<String> iu = new ArrayList<>();

    public kasaGorevlisi() {
        initComponents();
        keyboard = new PopUpKeyboard(txtBarkod);
        indirimDoldur();
        kasiyerGetirme();
        lblKasiyer.setText(new kullaniciGirisi().kullaniciAdi);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMiktar = new javax.swing.JTextField();
        txtBarkod = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnİptal = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKasiyerList = new javax.swing.JTable();
        btnCikis = new javax.swing.JButton();
        btnListedenCikar = new javax.swing.JButton();
        btnUrunGetir = new javax.swing.JButton();
        Kasiyer = new javax.swing.JLabel();
        lblKasiyer = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btniade = new javax.swing.JButton();
        btnNakit = new javax.swing.JButton();
        btnKrediKarti = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnİndirimUygula = new javax.swing.JButton();
        btnFatura = new javax.swing.JButton();
        lblToplamTutar = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtOdenenTutar = new javax.swing.JTextField();
        txtParaUstu = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jcİndirim = new javax.swing.JComboBox<>();
        btnIade = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(238, 234, 253));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Miktarı");

        txtMiktar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtBarkod.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtBarkod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBarkodMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Barkod No");

        btnİptal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnİptal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/satişİptal.png"))); // NOI18N
        btnİptal.setText("Satışı İptal Et");
        btnİptal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnİptalActionPerformed(evt);
            }
        });

        tblKasiyerList.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblKasiyerList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Barkod No", "Ürün Adı", "Beden", "Renk", "Satış Fiyatı", "Adet", "Toplam Tutar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblKasiyerList.setGridColor(new java.awt.Color(102, 102, 102));
        tblKasiyerList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKasiyerListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKasiyerList);

        btnCikis.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCikis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/kasiyerÇıkış.png"))); // NOI18N
        btnCikis.setText("Çıkış");
        btnCikis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCikisActionPerformed(evt);
            }
        });

        btnListedenCikar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnListedenCikar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/silme.png"))); // NOI18N
        btnListedenCikar.setText("Seçili Ürünü Listeden Çıkar");
        btnListedenCikar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListedenCikarActionPerformed(evt);
            }
        });

        btnUrunGetir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUrunGetir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/ürünGetirme.png"))); // NOI18N
        btnUrunGetir.setText("Ürünü Getir");
        btnUrunGetir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUrunGetirActionPerformed(evt);
            }
        });

        Kasiyer.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Kasiyer.setForeground(new java.awt.Color(51, 102, 255));
        Kasiyer.setText("Kasiyer  :");

        lblKasiyer.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblKasiyer.setForeground(new java.awt.Color(51, 102, 255));
        lblKasiyer.setText("jLabel8");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMiktar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtBarkod, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnUrunGetir, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnListedenCikar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(Kasiyer, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblKasiyer, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnİptal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCikis, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCikis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Kasiyer)
                            .addComponent(lblKasiyer)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUrunGetir, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(txtBarkod)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnListedenCikar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnİptal, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtMiktar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        jPanel2.setBackground(new java.awt.Color(238, 234, 253));

        btniade.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btniade.setText("Ürün Getir(İade)");
        btniade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btniadeActionPerformed(evt);
            }
        });

        btnNakit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNakit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Cash-2-icon.png"))); // NOI18N
        btnNakit.setText("Nakit ");
        btnNakit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNakitActionPerformed(evt);
            }
        });

        btnKrediKarti.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnKrediKarti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/if_visa_213724.png"))); // NOI18N
        btnKrediKarti.setText("Kredi Kartı");
        btnKrediKarti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKrediKartiActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("SATIŞI ONAYLAMA");

        btnİndirimUygula.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnİndirimUygula.setText("İndirim Uygula");
        btnİndirimUygula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnİndirimUygulaActionPerformed(evt);
            }
        });

        btnFatura.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnFatura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/fatura.png"))); // NOI18N
        btnFatura.setText("Fatura");
        btnFatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFaturaActionPerformed(evt);
            }
        });

        lblToplamTutar.setBackground(new java.awt.Color(2, 180, 180));
        lblToplamTutar.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblToplamTutar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblToplamTutar.setOpaque(true);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Ödenen Tutar");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Para Üstü");

        txtOdenenTutar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtOdenenTutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOdenenTutarActionPerformed(evt);
            }
        });

        txtParaUstu.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setText("ÖDENECEK TUTAR");

        jcİndirim.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcİndirim.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seçiniz" }));
        jcİndirim.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcİndirimİtemStateChanged(evt);
            }
        });

        btnIade.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnIade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/ürünİade.png"))); // NOI18N
        btnIade.setText("İade");
        btnIade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIadeActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("%");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnKrediKarti, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                            .addComponent(btnNakit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnIade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(54, 54, 54)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jcİndirim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnİndirimUygula, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btniade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnFatura, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtOdenenTutar)
                                .addComponent(txtParaUstu, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(lblToplamTutar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblToplamTutar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtOdenenTutar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtParaUstu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnİndirimUygula, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnNakit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(btnKrediKarti, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jcİndirim)
                                .addGap(18, 18, 18)
                                .addComponent(btnFatura, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnIade, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btniade, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void txtBarkodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBarkodMouseClicked
        txtBarkodMouseClicked();
    }//GEN-LAST:event_txtBarkodMouseClicked
    int uID = 0;
    int durum = 0;
    private void btnUrunGetirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUrunGetirActionPerformed
        if (!txtBarkod.getText().equals("") && !txtMiktar.getText().equals("")) {
            UrunGetirButonu();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Lütfen Önce Ürün Tanımlayınız!");
            txtMiktar.requestFocus();
        }
    }//GEN-LAST:event_btnUrunGetirActionPerformed

    private void btnNakitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNakitActionPerformed
        if (!txtBarkod.getText().equals("") && !txtMiktar.getText().equals("")) {
            NakitButonu();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Lütfen Önce Ürün Tanımlayınız!");
            txtMiktar.requestFocus();
        }
    }//GEN-LAST:event_btnNakitActionPerformed

    private void txtOdenenTutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOdenenTutarActionPerformed
        if (!txtBarkod.getText().equals("") && !txtMiktar.getText().equals("")) {
            OdenenTutar();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Lütfen Önce Ürün Tanımlayınız!");
            txtMiktar.requestFocus();
        }
    }//GEN-LAST:event_txtOdenenTutarActionPerformed

    private void btnFaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFaturaActionPerformed
        if (!txtBarkod.getText().equals("") && !txtMiktar.getText().equals("")) {
            FaturaButonu();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Lütfen Önce Ürün Tanımlayınız!");
            txtMiktar.requestFocus();
        }
    }//GEN-LAST:event_btnFaturaActionPerformed
    String secili = "";
    int sec = 0;
    static String sID = "";
    float toplamTutar = 0;
    private void tblKasiyerListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKasiyerListMouseClicked
        KasiyerListMouseClicked();
    }//GEN-LAST:event_tblKasiyerListMouseClicked

    private void btnİptalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnİptalActionPerformed
        if (!txtBarkod.getText().equals("") && !txtMiktar.getText().equals("")) {
            İptalButonu();
        } else {
            JOptionPane.showMessageDialog(rootPane, "İşlem Yapmadan İptal Yapılamaz!");
            txtMiktar.requestFocus();
        }
    }//GEN-LAST:event_btnİptalActionPerformed

    private void btnListedenCikarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListedenCikarActionPerformed
        if (!txtBarkod.getText().equals("") && !txtMiktar.getText().equals("")) {
            ListedenCikarButonu();
        } else {
            JOptionPane.showMessageDialog(rootPane, "\"Lütfen Önce Ürün Tanımlayınız");
            txtMiktar.requestFocus();
        }
    }//GEN-LAST:event_btnListedenCikarActionPerformed

    private void btnKrediKartiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKrediKartiActionPerformed
        if (!txtBarkod.getText().equals("") && !txtMiktar.getText().equals("")) {
            KrediKartiButonu();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Lütfen Önce Ürün Tanımlayınız");
            txtMiktar.requestFocus();
        }
    }//GEN-LAST:event_btnKrediKartiActionPerformed

    private void btniadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btniadeActionPerformed
        if (!txtBarkod.getText().equals("") && !txtMiktar.getText().equals("")) {
            iadeTabloDoldur();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Lütfen Önce Ürün Tanımlayınız");
            txtMiktar.requestFocus();
        }
    }//GEN-LAST:event_btniadeActionPerformed
    float ind = 0;
    private void btnİndirimUygulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnİndirimUygulaActionPerformed
        if (jcİndirim.getSelectedIndex() > -1) {
            if (!lblToplamTutar.getText().equals("")) {
                ind = Float.valueOf(lblToplamTutar.getText());
                ind -= (ind * indirim) / 100;
                lblToplamTutar.setText("" + ind);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Ürün Seçme İşlemi Olmadan İndirim Yapamazsınız.");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Lütfen İndirim Seçiniz.");
        }
    }//GEN-LAST:event_btnİndirimUygulaActionPerformed
    int indirim = 0;
    private void jcİndirimİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcİndirimİtemStateChanged
        indirim = Integer.valueOf("" + jcİndirim.getSelectedItem());
    }//GEN-LAST:event_jcİndirimİtemStateChanged

    private void btnIadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIadeActionPerformed
        barkodLs = null;
        try {
            if (bID != null) {
                String q = "{call iadeUpdate('" + bID + "')}";
                int update = db.baglan().executeUpdate(q);
                JOptionPane.showMessageDialog(rootPane, "İade İşlemi Gerçekleşmiştir.");
                iadeTabloDoldur();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Lütfen İade Edilecek Ürünü Seçiniz");
            }
            bID = null;
        } catch (SQLException e) {
            System.err.println("İade Update Yapma Hatası :" + e);
        }
        txtOdenenTutar.setText("");
        txtParaUstu.setText("");
        txtMiktar.setText("");
        txtBarkod.setText("");
    }//GEN-LAST:event_btnIadeActionPerformed

    private void btnCikisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCikisActionPerformed
        int cevap = JOptionPane.showConfirmDialog(rootPane, "Sistemden çıkmak istediğinize emin misiniz? ", "Kasiyer Çıkış", JOptionPane.YES_NO_OPTION);
        if (cevap == 0) {
            dispose();
            new kullaniciGirisi().setVisible(true);
        }
    }//GEN-LAST:event_btnCikisActionPerformed

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
            java.util.logging.Logger.getLogger(kasaGorevlisi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(kasaGorevlisi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(kasaGorevlisi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(kasaGorevlisi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new kasaGorevlisi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Kasiyer;
    private javax.swing.JButton btnCikis;
    private javax.swing.JButton btnFatura;
    private javax.swing.JButton btnIade;
    private javax.swing.JButton btnKrediKarti;
    private javax.swing.JButton btnListedenCikar;
    private javax.swing.JButton btnNakit;
    private javax.swing.JButton btnUrunGetir;
    private javax.swing.JButton btniade;
    private javax.swing.JButton btnİndirimUygula;
    private javax.swing.JButton btnİptal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcİndirim;
    private javax.swing.JLabel lblKasiyer;
    private javax.swing.JLabel lblToplamTutar;
    private javax.swing.JTable tblKasiyerList;
    private javax.swing.JTextField txtBarkod;
    private javax.swing.JTextField txtMiktar;
    private javax.swing.JTextField txtOdenenTutar;
    private javax.swing.JTextField txtParaUstu;
    // End of variables declaration//GEN-END:variables
    private PopUpKeyboard keyboard;

    public void txtBarkodMouseClicked() {
        try {
            Point p = txtBarkod.getLocationOnScreen();
            p.y += 30;
            keyboard.setLocation(p);
            keyboard.setVisible(true);
        } catch (Exception e) {
            System.err.println("Barkod Tıklanma Hatası : " + e);
        }
    }
    String bID = null;

    public void KasiyerListMouseClicked() {
        if (kgls != null) {
            sec = tblKasiyerList.getSelectedRow();
            sID = kgls.get(sec);
            System.out.println(sID);
            if (sec > -1) {
                secili = "" + tblKasiyerList.getValueAt(sec, 0);
                System.out.println(secili);
            }
        } else if (barkodLs != null) {
            sec = tblKasiyerList.getSelectedRow();
            bID = barkodLs.get(sec);
            toplamTutar = Float.valueOf("" + tblKasiyerList.getValueAt(sec, 7));
            lblToplamTutar.setText("-" + String.valueOf(toplamTutar));
            if (sec > -1) {
                System.out.println(bID);
            }
        }
    }

    public void NakitButonu() {
        txtOdenenTutar.requestFocus();
    }

    public void OdenenTutar() {
        float odenenTutar = Float.valueOf(txtOdenenTutar.getText().trim());
        float toplamTutar = Float.valueOf(lblToplamTutar.getText().trim());
        float paraUstu = odenenTutar - toplamTutar;
        txtParaUstu.setText("" + paraUstu);
    }

    public void FaturaButonu() {

        try {
            stoktanDus();
            String i = "{call fiyatUpdate('" + indirim + "')}";
            db.baglan().executeUpdate(i);
            String q = "{call KasiyerUpdate('" + durum + "')}";
            int update = db.baglan().executeUpdate(q);
            tableDoldur();
        } catch (SQLException e) {
            System.err.println("Nakit Update Yapma Hatası :" + e);
        }
        lblToplamTutar.setText("");
        txtOdenenTutar.setText("");
        txtParaUstu.setText("");
        txtMiktar.setText("");
        txtBarkod.setText("");
        kgls = null;
    }

    public void stoktanDus() {
        int satirSayisi = tblKasiyerList.getRowCount();
        for (int i = 0; i < satirSayisi; i++) {
            String barkodNo = "" + tblKasiyerList.getValueAt(i, 0);
            int urunAdeti = Integer.valueOf("" + tblKasiyerList.getValueAt(i, 5));
            try {
                String q = "{call stokDurumu('" + urunAdeti + "','" + barkodNo + "')}";
                int cevap = db.baglan().executeUpdate(q);
                if (cevap > 0) {
                    System.out.println("Ürün Adedi Stoktan Düşürüldü.");
                }
            } catch (SQLException e) {
                System.err.println("Stoktan Dusme Hatası" + e);
            }
        }
    }

    public void UrunGetirButonu() {
        barkodLs = null;
        kgls = new ArrayList<>();
        int barkod = 0;
        int satisfiyati = 0;
        String kategori = "";
        String beden = "";
        String renk = "";
        try {
            String q = "{call barkodSorgu('" + txtBarkod.getText() + "')}";
            ResultSet rs = db.baglan().executeQuery(q);
            if (rs.next()) {
                uID = rs.getInt(1);
                barkod = rs.getInt(2);
                kategori = rs.getString(3);
                beden = rs.getString(4);
                renk = rs.getString(5);
                satisfiyati = rs.getInt(9);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Lütfen Doğru Barkod Numarası Giriniz");
            }
        } catch (SQLException e) {
            System.err.println("Barkod Getirme Hatası: " + e);
        }
        int urunAdet = 0;
        urunAdet = Integer.valueOf(txtMiktar.getText().trim());
        int toplam = satisfiyati * urunAdet;

        try {
            String q = "{call kasiyerKaydet (?,?,?,?,?)} ";
            PreparedStatement pr = db.preBaglan(q);
            pr.setInt(1, urunAdet);
            pr.setInt(2, toplam);
            pr.setInt(3, uID);
            pr.setInt(4, 1);
            pr.setFloat(5, 100);
            pr.execute();
        } catch (SQLException e) {
            System.err.println("Toplam Tutar Getirme Hatası :" + e);
        }
        tableDoldur();
    }

    public void tableDoldur() {

        if (lblToplamTutar.getText().trim().equals("")) {
            toplamTutar = 0;
        } else {
            toplamTutar = Float.valueOf(lblToplamTutar.getText());
        }

        kgls.clear();
        try {
            String kasiyerQuery = "{call satisKaydet ('" + uID + "')} ";
            ResultSet rs = db.baglan().executeQuery(kasiyerQuery);
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("Barkod No");
            dtm.addColumn("Ürünün Adı");
            dtm.addColumn("Beden");
            dtm.addColumn("Renk");
            dtm.addColumn("Satış Fiyatı");
            dtm.addColumn("Adet");
            dtm.addColumn("Toplam Tutar");
            while (rs.next()) {
                kgls.add(rs.getString("SatisID"));
                if (rs.getInt("stokadedi") > Integer.valueOf(txtMiktar.getText())) {
                    dtm.addRow(new String[]{rs.getString("urun_barkodno"), rs.getString("kategori"), rs.getString("beden"), rs.getString("renk"), rs.getString("satisfiyati"), rs.getString("UrunAdedi"), rs.getString("ToplamTutar")});
                    toplamTutar += Float.valueOf(rs.getString("ToplamTutar"));
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Bu Üründen " + rs.getInt("stokadedi") + " adet bulunmaktadır.");
                }
            }
            tblKasiyerList.setModel(dtm);
            lblToplamTutar.setText(String.valueOf(toplamTutar));
        } catch (Exception e) {
            System.err.println("Kasiyer Listesi Doldurma Hatası: " + e);
        }
    }

    public void İptalButonu() {

        int cevap = JOptionPane.showConfirmDialog(rootPane, "Satışı İptal Etmek İstediğinize Emin misiniz?", "Satış İptal İşlemi", JOptionPane.YES_NO_OPTION);
        if (cevap == 0) {
            try {
                String silQuery = "{call satisiptal ( '" + durum + "' )}";
                int silSonuc = db.baglan().executeUpdate(silQuery);
                if (silSonuc > 0) {
                    tableDoldur();
                    JOptionPane.showMessageDialog(rootPane, "Silme İşlemi Başarılı");
                    txtBarkod.setText("");
                    txtMiktar.setText("");
                    lblToplamTutar.setText("");
                    txtOdenenTutar.setText("");
                    txtParaUstu.setText("");
                    jcİndirim.setSelectedIndex(0);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Silme İşlemi Başarısız");
                }
            } catch (Exception e) {
                System.err.println("İptal Etme Hatası : " + e);
            }
        }
    }

    public void ListedenCikarButonu() {
        if (secili.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen Seçim Yapınız");
        } else {
            int cevap = JOptionPane.showConfirmDialog(rootPane, "Kayıtlar geri alınamaz, listeden çıkarmak istediğinize emin misiniz?", "Listeden Silme İşlemi", JOptionPane.YES_NO_OPTION);
            if (cevap == 0) {
                try {
                    String silQuery = "{call kasiyerListSil ( '" + sID + "' )}";
                    int silSonuc = db.baglan().executeUpdate(silQuery);
                    if (silSonuc > 0) {
                        tableDoldur();
                        JOptionPane.showMessageDialog(rootPane, "Silme işlemi başarılı");
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Silme hatası !");
                    }
                } catch (Exception e) {
                    System.err.println("Seçili Urunu Listeden hatası : " + e);
                }
            }
        }
    }

    public void KrediKartiButonu() {
        JOptionPane.showMessageDialog(rootPane, "Satışınız Başarıyla Gerçekleşmiştir.");
    }

    class PopUpKeyboard extends JDialog implements ActionListener {

        private JTextField txt;

        public PopUpKeyboard(JTextField txt) {
            this.txt = txt;
            setLayout(new GridLayout(3, 3));
            for (int i = 1; i <= 9; i++) {
                createButton(Integer.toString(i));
            }
            pack();
        }

        private void createButton(String label) {
            JButton btn = new JButton(label);
            btn.addActionListener(this);
            btn.setFocusPainted(false);
            btn.setPreferredSize(new Dimension(100, 100));
            btn.setBackground(Color.white);
            Font font = btn.getFont();
            float size = font.getSize() + 15.0f;
            btn.setFont(font.deriveFont(size));
            add(btn);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String actionCommand = e.getActionCommand();
            txt.setText(txt.getText() + actionCommand);
        }
    }

    public void indirimDoldur() {
        iu.clear();
        try {
            String q = "{call indirimGetir() }";
            ResultSet rs = db.baglan().executeQuery(q);
            while (rs.next()) {
                String indirim = rs.getString(1);
                iu.add(indirim);
            }
            indirimModelDoldur();
        } catch (SQLException e) {
            System.err.println("İndirim getirme hatasi : " + e);
        }
    }

    public void indirimModelDoldur() {
        DefaultComboBoxModel<String> dkm = new DefaultComboBoxModel<>();
        for (String item : iu) {
            dkm.addElement(item);
        }
        jcİndirim.setModel(dkm);
    }

    public void iadeTabloDoldur() {
        kgls = null;
        barkodLs = new ArrayList<>();
        barkodLs.clear();
        try {
            String kasiyerQuery = "{call satisIade ('" + txtBarkod.getText() + "','" + txtMiktar.getText() + "')} ";
            ResultSet rs = db.baglan().executeQuery(kasiyerQuery);
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("Fiş Numarası");
            dtm.addColumn("Barkod No");
            dtm.addColumn("Ürünün Adı");
            dtm.addColumn("Beden");
            dtm.addColumn("Renk");
            dtm.addColumn("Satış Fiyatı");
            dtm.addColumn("Adet");
            dtm.addColumn("Toplam Tutar");
            while (rs.next()) {
                barkodLs.add(rs.getString("SatisID"));
                if (rs.getInt("stokadedi") > Integer.valueOf(txtMiktar.getText())) {
                    dtm.addRow(new String[]{rs.getString("SatisID"), rs.getString("urun_barkodno"), rs.getString("kategori"), rs.getString("beden"), rs.getString("renk"), rs.getString("satisfiyati"), rs.getString("UrunAdedi"), rs.getString("ToplamTutar")});
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Bu Üründen " + rs.getInt("stokadedi") + " adet bulunmaktadır.");
                }
            }
            tblKasiyerList.setModel(dtm);
        } catch (Exception e) {
            System.err.println("İade Doldurma Hatası: " + e);
        }
    }

    public void kasiyerGetirme() {
        String adi = "";
        String soyadi = "";

        String kasiyer = lblKasiyer.getText().trim();
        try {
            String q = "{call kasiyerLogin ()}";
            ResultSet rs = db.baglan().executeQuery(q);
            while (rs.next()) {
                adi = rs.getString("padi");
                soyadi = rs.getString("psoyadi");
            }
            lblKasiyer.setText(adi + " " + soyadi);

        } catch (Exception e) {
            System.err.println("Kasiyer Bilgisi Getirme Hatası: " + e);
        }
    }

}
