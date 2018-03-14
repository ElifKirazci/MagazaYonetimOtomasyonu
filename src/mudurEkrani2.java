
import Enums.cinsiyetEnum;
import Enums.gorevEnum;
import Enums.kategoriEnum;
import Property.cinsiyetPro;
import Property.gorevPro;
import Property.kategoriPro;
import Property.personelpro;
import Property.urunPro;
import java.awt.Image;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class mudurEkrani2 extends javax.swing.JFrame {

    DB db = new DB("personelyonetimi", "root", "");
    ArrayList<personelpro> pp = new ArrayList<>();
    ArrayList<gorevPro> gp = new ArrayList<>();
    ArrayList<cinsiyetPro> cp = new ArrayList<>();
    ArrayList<kategoriPro> kp = new ArrayList<>();
    ArrayList<urunPro> up = new ArrayList<>();
    ArrayList<String> r = new ArrayList<>();
    ArrayList<String> kList = new ArrayList<>();
    static String barkodNo;
    String filename = null;
    Validators v = new Validators();

    public mudurEkrani2() {
        initComponents();
        btnDuzenle.setEnabled(false);
        btnurunDuzenle.setEnabled(false);
        calisanDoldur();
        cinsiyetDoldur();
        kategoriDoldur(0);
        kullaniciDoldur();
        ürünCinsiyetDoldur();
        if (!personelList.pid.equals("")) {
            txtTc.setText(personelList.pro.getPtc());
            txtAdi.setText(personelList.pro.getPadi());
            txtSoyadi.setText(personelList.pro.getPsoyadi());
            txtDogumYeri.setText(personelList.pro.getPdogumyeri());
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            try {
                Date date = format.parse(personelList.pro.getPdogumtarihi());
                System.out.println(date);
                jcDogum.setDate(date);
            } catch (ParseException ex) {
                System.err.println("Tarih Getirme Hatası :" + ex);
            }
            txtEvTel.setText("" + personelList.pro.getPevtel());
            txtCepTel.setText("" + personelList.pro.getPceptel());
            txtMail.setText(personelList.pro.getPmail());
            txtAdres.setText(personelList.pro.getPadres());
            String path = personelList.pro.getPresim();
            lblPresim.setIcon(ResizeImage(path, null, lblPresim));
            try {
                Date date1 = format.parse(personelList.pro.getPbaslamatarihi());
                System.out.println(date1);
                jcBaslamaTarih.setDate(date1);

            } catch (ParseException ex) {
                System.err.println("Tarih Getirme Hatası :" + ex);
            }
            cbCalisanGorev.setSelectedItem(personelList.gpro.getCgorevi());
            btnDuzenle.setEnabled(true);
        }
        if (!urunListesi.urunID.equals("")) {
            txtBarkod.setText("" + urunListesi.upro.getUrunBarkod());
            cbCinsiyeti.setSelectedItem(urunListesi.cpro.getCinsiyet());
            cbKategori.setSelectedItem(urunListesi.kpro.getKategori());
            cbRenk.setSelectedItem(urunListesi.upro.getRenk());
            cbBeden.setSelectedItem(urunListesi.upro.getUrunBeden());
            DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            String pathurun = urunListesi.upro.getResim();
            resim.setIcon(ResizeImage(pathurun, null, resim));
            try {
                Date date1 = format1.parse(urunListesi.upro.getUrunGelisTarihi());
                jDateChooser1.setDate(date1);
            } catch (ParseException e) {
                System.err.println("Tarihi Getirme Hatası : " + e);
            }
            txtAlis.setText("" + urunListesi.upro.getAlisfiyati());
            txtSatis.setText("" + urunListesi.upro.getSatisfiyati());
            txtStokAdedi.setText("" + urunListesi.upro.getStokadedi());
            txtDetay.setText(urunListesi.upro.getDetay());
            btnurunDuzenle.setEnabled(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        YöneticiCikis = new javax.swing.JButton();
        lblDepoYonetimi = new javax.swing.JLabel();
        lblKasaYonetimi = new javax.swing.JLabel();
        lblPersonelYonetimi = new javax.swing.JLabel();
        lblAyarlar = new javax.swing.JLabel();
        jpAnaPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cbCinsiyeti = new javax.swing.JComboBox<>();
        cbKategori = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        cbBeden = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        cbRenk = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtBarkod = new javax.swing.JTextField();
        txtAlis = new javax.swing.JTextField();
        txtSatis = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txtStokAdedi = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txtDetay = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        resim = new javax.swing.JLabel();
        btnResimEkle = new javax.swing.JButton();
        btnYeniEkle = new javax.swing.JButton();
        btnurunDuzenle = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        btnUrunList = new javax.swing.JButton();
        btnİndirim = new javax.swing.JButton();
        txtİndirim = new javax.swing.JTextField();
        btnKategori = new javax.swing.JButton();
        txtKategori = new javax.swing.JTextField();
        jcKateCinsiyet = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lblToplamAdet = new javax.swing.JLabel();
        lblToplamTutar = new javax.swing.JLabel();
        lblToplamKar = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblKasa = new javax.swing.JTable();
        jdAdetBaslangic = new com.toedter.calendar.JDateChooser();
        jdAdetBaitis = new com.toedter.calendar.JDateChooser();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        btnRaporla = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtTc = new javax.swing.JTextField();
        txtAdi = new javax.swing.JTextField();
        txtSoyadi = new javax.swing.JTextField();
        txtDogumYeri = new javax.swing.JTextField();
        rKadin = new javax.swing.JRadioButton();
        rErkek = new javax.swing.JRadioButton();
        jcDogum = new com.toedter.calendar.JDateChooser();
        jPanel5 = new javax.swing.JPanel();
        btnEkle = new javax.swing.JButton();
        lblPresim = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtEvTel = new javax.swing.JTextField();
        txtCepTel = new javax.swing.JTextField();
        txtMail = new javax.swing.JTextField();
        txtAdres = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        cbCalisanGorev = new javax.swing.JComboBox<>();
        jcBaslamaTarih = new com.toedter.calendar.JDateChooser();
        btnKaydet = new javax.swing.JButton();
        btnDuzenle = new javax.swing.JButton();
        btnPersonelList = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txtKullaniciAdi = new javax.swing.JTextField();
        txtEskiSifre = new javax.swing.JTextField();
        txtYeniSifre = new javax.swing.JTextField();
        txtSifreTekrar = new javax.swing.JTextField();
        btnKullaniciKaydet = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblKullaniciTablosu = new javax.swing.JTable();
        btnKullaniciSil = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(919, 700));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(242, 242, 255));

        YöneticiCikis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/çıkış.png"))); // NOI18N
        YöneticiCikis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YöneticiCikisActionPerformed(evt);
            }
        });

        lblDepoYonetimi.setBackground(new java.awt.Color(0, 153, 255));
        lblDepoYonetimi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDepoYonetimi.setForeground(new java.awt.Color(255, 255, 255));
        lblDepoYonetimi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDepoYonetimi.setText("Depo Yönetimi");
        lblDepoYonetimi.setOpaque(true);
        lblDepoYonetimi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDepoYonetimiMouseClicked(evt);
            }
        });

        lblKasaYonetimi.setBackground(new java.awt.Color(255, 102, 102));
        lblKasaYonetimi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblKasaYonetimi.setForeground(new java.awt.Color(255, 255, 255));
        lblKasaYonetimi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblKasaYonetimi.setText("Kasa Yönetimi");
        lblKasaYonetimi.setOpaque(true);
        lblKasaYonetimi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKasaYonetimiMouseClicked(evt);
            }
        });

        lblPersonelYonetimi.setBackground(new java.awt.Color(255, 153, 51));
        lblPersonelYonetimi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPersonelYonetimi.setForeground(new java.awt.Color(255, 255, 255));
        lblPersonelYonetimi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPersonelYonetimi.setText("Personel Yönetimi");
        lblPersonelYonetimi.setOpaque(true);
        lblPersonelYonetimi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPersonelYonetimiMouseClicked(evt);
            }
        });

        lblAyarlar.setBackground(new java.awt.Color(0, 176, 115));
        lblAyarlar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblAyarlar.setForeground(new java.awt.Color(255, 255, 255));
        lblAyarlar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAyarlar.setText("Ayarlar");
        lblAyarlar.setOpaque(true);
        lblAyarlar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAyarlarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblAyarlar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPersonelYonetimi, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(lblKasaYonetimi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDepoYonetimi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(YöneticiCikis, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(lblDepoYonetimi, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblKasaYonetimi, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblPersonelYonetimi, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblAyarlar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(YöneticiCikis, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        jpAnaPanel.setPreferredSize(new java.awt.Dimension(778, 900));
        jpAnaPanel.setLayout(new java.awt.CardLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel9.setBackground(new java.awt.Color(238, 234, 253));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Ürün Ekleme");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Kategoriler");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Cinsiyeti");

        cbCinsiyeti.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbCinsiyeti.setSelectedIndex(-1);
        cbCinsiyeti.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbCinsiyetiİtemStateChanged(evt);
            }
        });

        cbKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbKategori.setSelectedIndex(-1);
        cbKategori.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbKategoriİtemStateChanged(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Beden");

        cbBeden.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seçiniz", "XS", "S", "M", "L", "XL", "XXL" }));
        cbBeden.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbBedenİtemStateChanged(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("Renk");

        cbRenk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seçiniz", "Beyaz", "Siyah", "Kırmızı", "Mavi", "Yeşil", "Sarı", "Mor", "Lacivert", "Pembe", "Kahverengi", "Gri", "Bordo", "Haki", "Bej", "Füme" }));
        cbRenk.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbRenkİtemStateChanged(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel29.setText("Alış Fiyatı");

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel30.setText("Satış Fiyatı");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel31.setText("Ürün Barkod No");

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel32.setText("Stok Adedi");

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel33.setText("Detay");

        jPanel11.setBackground(new java.awt.Color(238, 234, 253));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Resim"));

        btnResimEkle.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnResimEkle.setText("Resim Ekle");
        btnResimEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResimEkleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(resim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(0, 120, Short.MAX_VALUE)
                .addComponent(btnResimEkle)
                .addGap(100, 100, 100))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(resim, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnResimEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnYeniEkle.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnYeniEkle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/ürün ekleme.png"))); // NOI18N
        btnYeniEkle.setText("Yeni Ürün Ekle");
        btnYeniEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYeniEkleActionPerformed(evt);
            }
        });

        btnurunDuzenle.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnurunDuzenle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/ürün düzenleme.png"))); // NOI18N
        btnurunDuzenle.setText("Düzenle");
        btnurunDuzenle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnurunDuzenleActionPerformed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel34.setText("Ürünün Geliş Tarihi");

        btnUrunList.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUrunList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/ürün listesi (2).png"))); // NOI18N
        btnUrunList.setText("Ürün Listesi");
        btnUrunList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUrunListActionPerformed(evt);
            }
        });

        btnİndirim.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnİndirim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/indirim.png"))); // NOI18N
        btnİndirim.setText("İndirim Ekle");
        btnİndirim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnİndirimActionPerformed(evt);
            }
        });

        txtİndirim.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnKategori.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnKategori.setText("Kategori Ekle");
        btnKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKategoriActionPerformed(evt);
            }
        });

        jcKateCinsiyet.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtStokAdedi, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                                .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                                .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbCinsiyeti, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtBarkod, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbRenk, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbBeden, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtAlis, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtSatis, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtDetay, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(40, 40, 40)
                                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel14)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnİndirim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnYeniEkle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnUrunList, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(txtİndirim))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(btnurunDuzenle)
                                .addGap(18, 18, 18)
                                .addComponent(btnKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jcKateCinsiyet, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel14)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBarkod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbCinsiyeti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbRenk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel28))
                                .addGap(38, 38, 38))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel17)
                                .addComponent(cbBeden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAlis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtSatis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtStokAdedi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(txtDetay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnYeniEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUrunList, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnurunDuzenle, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtİndirim, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcKateCinsiyet, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnİndirim))
                .addGap(113, 113, 113))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jpAnaPanel.add(jPanel2, "card2");

        jPanel3.setBackground(new java.awt.Color(238, 234, 253));

        jPanel10.setBackground(new java.awt.Color(238, 234, 253));
        jPanel10.setToolTipText("");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel18.setText("Toplam Satış Adedi :");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel19.setText("Toplam Satış Tutarı :");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel20.setText("Toplam Kar :");

        lblToplamAdet.setBackground(new java.awt.Color(131, 131, 189));
        lblToplamAdet.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblToplamAdet.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblToplamAdet.setOpaque(true);

        lblToplamTutar.setBackground(new java.awt.Color(131, 131, 189));
        lblToplamTutar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblToplamTutar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblToplamTutar.setOpaque(true);

        lblToplamKar.setBackground(new java.awt.Color(131, 131, 189));
        lblToplamKar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblToplamKar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblToplamKar.setOpaque(true);

        tblKasa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblKasa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Barkod No", "Ürün Adı", "Renk", "Beden", "Kar", "Ürün Adedi", "Toplam Tutar"
            }
        ));
        jScrollPane2.setViewportView(tblKasa);

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel39.setText("Başlangıç Tarihi");

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel40.setText("Bitiş Tarihi");

        btnRaporla.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRaporla.setText("Raporla");
        btnRaporla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRaporlaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel20)))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jdAdetBaslangic, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel39))))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jdAdetBaitis, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                            .addComponent(lblToplamAdet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblToplamTutar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblToplamKar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel40))
                        .addGap(41, 41, 41)
                        .addComponent(btnRaporla, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 175, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(jLabel40))
                .addGap(14, 14, 14)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdAdetBaitis, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jdAdetBaslangic, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(lblToplamAdet, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblToplamTutar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblToplamKar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20)))
                    .addComponent(btnRaporla, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jpAnaPanel.add(jPanel3, "card3");

        jPanel4.setBackground(new java.awt.Color(238, 234, 253));

        jPanel7.setBackground(new java.awt.Color(238, 234, 253));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Kimlik Bilgileri", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("TC. Kimlik No");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Adı");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Soyadı");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 51));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Cinsiyeti");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 51));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Doğum Yeri");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 51));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Doğum Tarihi");

        rKadin.setBackground(new java.awt.Color(255, 255, 255));
        rKadin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rKadin.setText("Kadın");
        rKadin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rKadinMouseClicked(evt);
            }
        });

        rErkek.setBackground(new java.awt.Color(255, 255, 255));
        rErkek.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rErkek.setText("Erkek");
        rErkek.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rErkekMouseClicked(evt);
            }
        });

        jcDogum.setBackground(new java.awt.Color(255, 255, 255));
        jcDogum.setOpaque(false);

        jPanel5.setBackground(new java.awt.Color(238, 234, 253));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resim", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        btnEkle.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEkle.setText("Ekle");
        btnEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEkleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(lblPresim, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(btnEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPresim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDogumYeri)
                    .addComponent(jcDogum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtAdi)
                    .addComponent(txtSoyadi)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(rKadin)
                                .addGap(18, 18, 18)
                                .addComponent(rErkek))
                            .addComponent(txtTc, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(61, 61, 61)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel8))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(txtSoyadi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rKadin)
                            .addComponent(rErkek))))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDogumYeri, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jcDogum, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)))
                .addContainerGap(59, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(238, 234, 253));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "İletişim Bilgileri", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 51));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Adresi");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 51));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Ev Telefonu");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 51));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("Cep Telefonu");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 51));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText("E-Posta");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMail, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                    .addComponent(txtCepTel)
                    .addComponent(txtEvTel)
                    .addComponent(txtAdres))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel13))
                    .addComponent(txtEvTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel24))
                    .addComponent(txtCepTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAdres, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(238, 234, 253));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Çalışma Bilgileri", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 0, 51));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel26.setText("Çalışanın Görevi");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 0, 51));
        jLabel27.setText("İşe Başlama Tarihi");

        cbCalisanGorev.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbCalisanGorevİtemStateChanged(evt);
            }
        });

        jcBaslamaTarih.setBackground(new java.awt.Color(255, 255, 255));
        jcBaslamaTarih.setOpaque(false);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbCalisanGorev, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcBaslamaTarih, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(cbCalisanGorev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcBaslamaTarih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnKaydet.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnKaydet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/personelKaydet.png"))); // NOI18N
        btnKaydet.setText("Kaydet");
        btnKaydet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKaydetActionPerformed(evt);
            }
        });

        btnDuzenle.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDuzenle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/personelDüzenle.png"))); // NOI18N
        btnDuzenle.setText("Düzenle");
        btnDuzenle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDuzenleActionPerformed(evt);
            }
        });

        btnPersonelList.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnPersonelList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/personelListesi.png"))); // NOI18N
        btnPersonelList.setText("Personel Listesi");
        btnPersonelList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPersonelListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addComponent(btnKaydet, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(btnDuzenle, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(btnPersonelList, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKaydet, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDuzenle)
                    .addComponent(btnPersonelList))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpAnaPanel.add(jPanel4, "card4");

        jPanel6.setBackground(new java.awt.Color(238, 234, 253));

        jPanel13.setBackground(new java.awt.Color(238, 234, 253));

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel35.setText("Kullanıcı Adı");

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel36.setText("Yeni Şifre");

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel37.setText("Yeni Şifre Tekrar");

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel38.setText("Eski Şifre");

        txtKullaniciAdi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtEskiSifre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtYeniSifre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtSifreTekrar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnKullaniciKaydet.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnKullaniciKaydet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/savee.png"))); // NOI18N
        btnKullaniciKaydet.setText("Kaydet");
        btnKullaniciKaydet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKullaniciKaydetActionPerformed(evt);
            }
        });

        tblKullaniciTablosu.setModel(new javax.swing.table.DefaultTableModel(
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
        tblKullaniciTablosu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKullaniciTablosuMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblKullaniciTablosu);

        btnKullaniciSil.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnKullaniciSil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/sill.png"))); // NOI18N
        btnKullaniciSil.setText("Sil");
        btnKullaniciSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKullaniciSilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEskiSifre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                            .addComponent(txtYeniSifre, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtSifreTekrar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtKullaniciAdi)))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(btnKullaniciSil, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(btnKullaniciKaydet, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKullaniciAdi, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEskiSifre, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtYeniSifre, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSifreTekrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKullaniciKaydet, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKullaniciSil, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 235, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        jpAnaPanel.add(jPanel6, "card5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpAnaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpAnaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblPersonelYonetimiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPersonelYonetimiMouseClicked
        jpAnaPanel.removeAll();
        jpAnaPanel.repaint();
        jpAnaPanel.revalidate();
        jpAnaPanel.add(jPanel4);
        jpAnaPanel.repaint();
        jpAnaPanel.revalidate();
    }//GEN-LAST:event_lblPersonelYonetimiMouseClicked

    private void lblDepoYonetimiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDepoYonetimiMouseClicked
        jpAnaPanel.removeAll();
        jpAnaPanel.repaint();
        jpAnaPanel.revalidate();
        jpAnaPanel.add(jPanel2);
        jpAnaPanel.repaint();
        jpAnaPanel.revalidate();
    }//GEN-LAST:event_lblDepoYonetimiMouseClicked

    private void lblKasaYonetimiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKasaYonetimiMouseClicked
        jpAnaPanel.removeAll();
        jpAnaPanel.repaint();
        jpAnaPanel.revalidate();
        jpAnaPanel.add(jPanel3);
        jpAnaPanel.repaint();
        jpAnaPanel.revalidate();
    }//GEN-LAST:event_lblKasaYonetimiMouseClicked

    private void lblAyarlarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAyarlarMouseClicked
        jpAnaPanel.removeAll();
        jpAnaPanel.repaint();
        jpAnaPanel.revalidate();
        jpAnaPanel.add(jPanel6);
        jpAnaPanel.repaint();
        jpAnaPanel.revalidate();
    }//GEN-LAST:event_lblAyarlarMouseClicked
    int kcid = 0;
    private void cbCinsiyetiİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbCinsiyetiİtemStateChanged
        kcid = cp.get(cbCinsiyeti.getSelectedIndex()).getCinsiyetID();
        kategoriDoldur(kcid);
    }//GEN-LAST:event_cbCinsiyetiİtemStateChanged
    int kid = 0;
    private void cbKategoriİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbKategoriİtemStateChanged
        kid = cbKategori.getSelectedIndex();
    }//GEN-LAST:event_cbKategoriİtemStateChanged
    String bid = "";
    private void cbBedenİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbBedenİtemStateChanged
        bid = (String) cbBeden.getSelectedItem();
    }//GEN-LAST:event_cbBedenİtemStateChanged
    String rid = "";
    private void cbRenkİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbRenkİtemStateChanged
        rid = (String) cbRenk.getSelectedItem();
    }//GEN-LAST:event_cbRenkİtemStateChanged

    private void btnResimEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResimEkleActionPerformed
        urunResimEkleDoldur();
        resim.setIcon(ResizeImage(path, null, resim));
    }//GEN-LAST:event_btnResimEkleActionPerformed

    private void btnYeniEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYeniEkleActionPerformed
        yeniUrunEkleButonu();
    }//GEN-LAST:event_btnYeniEkleActionPerformed

    private void btnurunDuzenleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnurunDuzenleActionPerformed
        urunDuzenleDoldur();
    }//GEN-LAST:event_btnurunDuzenleActionPerformed

    private void btnUrunListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUrunListActionPerformed
        urunListesi ul = new urunListesi();
        ul.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnUrunListActionPerformed
    String cinsiyet = "";
    private void rKadinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rKadinMouseClicked
        cinsiyet = rKadin.getText();
    }//GEN-LAST:event_rKadinMouseClicked

    private void rErkekMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rErkekMouseClicked
        cinsiyet = rErkek.getText();
    }//GEN-LAST:event_rErkekMouseClicked
    int cid = 0;
    private void cbCalisanGorevİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbCalisanGorevİtemStateChanged
        cid = cbCalisanGorev.getSelectedIndex();
    }//GEN-LAST:event_cbCalisanGorevİtemStateChanged

    private void btnKaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKaydetActionPerformed
        personelKaydetDoldur();
    }//GEN-LAST:event_btnKaydetActionPerformed

    private void btnDuzenleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDuzenleActionPerformed
        personelDuzenleDoldur();
    }//GEN-LAST:event_btnDuzenleActionPerformed

    private void btnPersonelListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPersonelListActionPerformed
        personelList pl = new personelList();
        pl.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnPersonelListActionPerformed

    private void btnİndirimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnİndirimActionPerformed

        indirimButonuDoldur();
    }//GEN-LAST:event_btnİndirimActionPerformed

    private void btnRaporlaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRaporlaActionPerformed
        if (jdAdetBaslangic.getDate() != null && jdAdetBaitis.getDate() != null) {
            kasaDoldur();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Lütfen Önce Tarih Giriniz");
        }
    }//GEN-LAST:event_btnRaporlaActionPerformed
    int kpid = 0;
    private void btnKullaniciKaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKullaniciKaydetActionPerformed
        String kullaniciAdi = txtKullaniciAdi.getText().trim();
        String kullaniciYeniSifre = txtYeniSifre.getText().trim();
        String kullaniciYeniSifreTekrar = txtSifreTekrar.getText().trim();
        String kullaniciEskiSifre = txtEskiSifre.getText().trim();

        if (kullaniciAdi.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen Kullanıcı Adınızı Giriniz");
        } else if (kullaniciEskiSifre.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen Eski Şifrenizi Giriniz");
        } else if (kullaniciYeniSifre.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen Yeni Şifrenizi Giriniz");
        } else if (kullaniciYeniSifre.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen Yeni Şifrenizi Tekrar Giriniz");
        } else {
            String q = "{call kullaniciGetir ('" + kullaniciAdi + "','" + kullaniciEskiSifre + "')}";
            try {
                ResultSet rs = db.baglan().executeQuery(q);
                if (rs.next()) {
                    if (!kullaniciYeniSifre.equals(kullaniciYeniSifreTekrar)) {
                        JOptionPane.showMessageDialog(rootPane, "\"Yeni Şifre\" ile Yeni \"Şifre Tekrar \" Uyuşmamaktadır");
                    } else {
                        String query = "{call kullaniciGirisUpdate ('" + kullaniciAdi + "', '" + kullaniciYeniSifre + "')}";
                        db.baglan().executeUpdate(query);
                        kullaniciDoldur();
                        JOptionPane.showMessageDialog(rootPane, "Şifre Değiştime İşlemi Gerçekleşmiştir.");
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Bilgileriniz yanlış girdiniz !");
                }
            } catch (SQLException ex) {
                System.out.println("Kullanıcı Kaydetme Hatası :" + ex);
            }
        }
    }//GEN-LAST:event_btnKullaniciKaydetActionPerformed

    private void YöneticiCikisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YöneticiCikisActionPerformed
        int cevap = JOptionPane.showConfirmDialog(rootPane, "Sistemden çıkmak istediğinize emin misiniz? ", "Yönetici Çıkışı", JOptionPane.YES_NO_OPTION);
        if (cevap == 0) {
            dispose();
            new kullaniciGirisi().setVisible(true);
        }
    }//GEN-LAST:event_YöneticiCikisActionPerformed
    String satir = "";
    int row;
    private void btnKullaniciSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKullaniciSilActionPerformed
        if (satir.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen Seçim Yapınız");
        } else {
            int cevap = JOptionPane.showConfirmDialog(rootPane, "Kayıtlar geri alınamaz, silmek istediğinize emin misiniz?", "Silme İşlemi", JOptionPane.YES_NO_OPTION);
            if (cevap == 0) {
                try {
                    String silQuery = "{call kullaniciSil ( '" + satir + "' )}";
                    int silSonuc = db.baglan().executeUpdate(silQuery);
                    if (silSonuc > 0) {
                        JOptionPane.showMessageDialog(rootPane, "Silme İşlemi Başarılı");
                        kullaniciDoldur();
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Silme İşlemi Başarısız");
                    }
                } catch (Exception e) {
                    System.err.println("Kullanici Listesinden Silme Hatası : " + e);
                }
            }
        }
    }//GEN-LAST:event_btnKullaniciSilActionPerformed

    private void tblKullaniciTablosuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKullaniciTablosuMouseClicked
        row = tblKullaniciTablosu.getSelectedRow();
        if (row > -1) {
            satir = "" + tblKullaniciTablosu.getValueAt(row, 0);
            System.out.println(satir);
        }
    }//GEN-LAST:event_tblKullaniciTablosuMouseClicked

    private void btnEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEkleActionPerformed
        urunResimEkleDoldur();
        lblPresim.setIcon(ResizeImage(path, null, lblPresim));
    }//GEN-LAST:event_btnEkleActionPerformed

    private void btnKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKategoriActionPerformed
        kategoriButonuDoldur();
    }//GEN-LAST:event_btnKategoriActionPerformed

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
            java.util.logging.Logger.getLogger(mudurEkrani2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mudurEkrani2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mudurEkrani2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mudurEkrani2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mudurEkrani2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton YöneticiCikis;
    private javax.swing.JButton btnDuzenle;
    private javax.swing.JButton btnEkle;
    private javax.swing.JButton btnKategori;
    private javax.swing.JButton btnKaydet;
    private javax.swing.JButton btnKullaniciKaydet;
    private javax.swing.JButton btnKullaniciSil;
    private javax.swing.JButton btnPersonelList;
    private javax.swing.JButton btnRaporla;
    private javax.swing.JButton btnResimEkle;
    private javax.swing.JButton btnUrunList;
    private javax.swing.JButton btnYeniEkle;
    private javax.swing.JButton btnurunDuzenle;
    private javax.swing.JButton btnİndirim;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbBeden;
    private javax.swing.JComboBox<String> cbCalisanGorev;
    private javax.swing.JComboBox<String> cbCinsiyeti;
    public javax.swing.JComboBox<String> cbKategori;
    private javax.swing.JComboBox<String> cbRenk;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private com.toedter.calendar.JDateChooser jcBaslamaTarih;
    private com.toedter.calendar.JDateChooser jcDogum;
    private javax.swing.JComboBox<String> jcKateCinsiyet;
    private com.toedter.calendar.JDateChooser jdAdetBaitis;
    private com.toedter.calendar.JDateChooser jdAdetBaslangic;
    public javax.swing.JPanel jpAnaPanel;
    private javax.swing.JLabel lblAyarlar;
    private javax.swing.JLabel lblDepoYonetimi;
    private javax.swing.JLabel lblKasaYonetimi;
    private javax.swing.JLabel lblPersonelYonetimi;
    private javax.swing.JLabel lblPresim;
    private javax.swing.JLabel lblToplamAdet;
    private javax.swing.JLabel lblToplamKar;
    private javax.swing.JLabel lblToplamTutar;
    private javax.swing.JRadioButton rErkek;
    private javax.swing.JRadioButton rKadin;
    private javax.swing.JLabel resim;
    private javax.swing.JTable tblKasa;
    private javax.swing.JTable tblKullaniciTablosu;
    private javax.swing.JTextField txtAdi;
    private javax.swing.JTextField txtAdres;
    private javax.swing.JTextField txtAlis;
    private javax.swing.JTextField txtBarkod;
    private javax.swing.JTextField txtCepTel;
    private javax.swing.JTextField txtDetay;
    private javax.swing.JTextField txtDogumYeri;
    private javax.swing.JTextField txtEskiSifre;
    private javax.swing.JTextField txtEvTel;
    private javax.swing.JTextField txtKategori;
    private javax.swing.JTextField txtKullaniciAdi;
    private javax.swing.JTextField txtMail;
    private javax.swing.JTextField txtSatis;
    private javax.swing.JTextField txtSifreTekrar;
    private javax.swing.JTextField txtSoyadi;
    private javax.swing.JTextField txtStokAdedi;
    private javax.swing.JTextField txtTc;
    private javax.swing.JTextField txtYeniSifre;
    private javax.swing.JTextField txtİndirim;
    // End of variables declaration//GEN-END:variables
 public void personelKaydetDoldur() {

        String tckn = txtTc.getText().trim();
        String adi = txtAdi.getText().trim();
        String soyadi = txtSoyadi.getText().trim();
        if (rKadin.isSelected()) {
            cinsiyet = rKadin.getText();
        } else {
            cinsiyet = rErkek.getText();
        }
        String dogumyeri = txtDogumYeri.getText().trim();

        String evtel = txtEvTel.getText().trim();
        String ceptel = txtCepTel.getText().trim();
        String mail = txtMail.getText().trim();
        String adres = txtAdres.getText().trim();
        String isebaslama = new SimpleDateFormat("yyyy.MM.dd").format(jcBaslamaTarih.getDate());
        String dogumtarihi = new SimpleDateFormat("yyyy.MM.dd").format(jcDogum.getDate());
        if ((v.uzunlukTCValidator(tckn)) && (v.sayiValidator(tckn)) && (v.sayiValidator(evtel)) && (v.uzunlukTelValidator(evtel)) && (v.uzunlukTelValidator(ceptel)) && (v.harfValidator(adi)) && (v.harfValidator(soyadi)) && (v.harfValidator(dogumyeri))) {
            if (tckn.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Lütfen Personelin TC Numarasını Giriniz.");
                txtTc.requestFocus();
            } else if (adi.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Lütfen Personelin Adını Giriniz.");
                txtAdi.requestFocus();
            } else if (soyadi.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Lütfen Personelin Soyadını Giriniz");
                txtSoyadi.requestFocus();
            } else if (dogumyeri.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Lütfen Personelin Doğum Yerini Giriniz");
                txtDogumYeri.requestFocus();
            } else if (ceptel.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Lütfen Personelin Telefonunu Giriniz");
                txtCepTel.requestFocus();
            } else if (mail.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Lütfen Personelin E-Posta Adresini Giriniz");
                txtMail.requestFocus();
            } else if (adres.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Lütfen Personelin Adresini Giriniz");
                txtAdres.requestFocus();
            } else if (cbCalisanGorev.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(rootPane, "Lütfen Personelin Görevini Seçiniz");
            } else {
                try {
                    String q = "{call kimlikKaydet (?,?,?,?,?,?,?,?,?,?,?,?,?)} ";

                    PreparedStatement pr = db.preBaglan(q);
                    pr.setString(1, tckn);
                    pr.setString(2, adi);
                    pr.setString(3, soyadi);
                    pr.setString(4, cinsiyet);
                    pr.setString(5, dogumyeri);
                    pr.setString(6, dogumtarihi);
                    pr.setString(7, evtel);
                    pr.setString(8, ceptel);
                    pr.setString(9, mail);
                    pr.setString(10, adres);
                    pr.setString(11, isebaslama);
                    pr.setString(12, path);
                    pr.setInt(13, cid);
                    int yaz = pr.executeUpdate();
                    if (yaz > 0) {
                        System.out.println("Kayıt İşlemi Başarılı");
                        personelList pl = new personelList();
                        pl.tableDoldur();
                        txtTc.setText("");
                        txtAdi.setText("");
                        txtSoyadi.setText("");
                        txtDogumYeri.setText("");
                        jcDogum.setDate(null);
                        txtEvTel.setText("");
                        txtCepTel.setText("");
                        txtMail.setText("");
                        txtAdres.setText("");
                        jcBaslamaTarih.setDate(null);
                        lblPresim.setIcon(null);
                    } else {
                        System.err.println("Kayıt İşlemi Başarısız");
                    }
                } catch (SQLException e) {
                    System.err.println("Personel Kaydetme Hatası : " + e);
                }
            }
        }
    }

    public void yeniUrunEkleButonu() {
        barkodNo = txtBarkod.getText().trim();
        int cdi = cp.get(cbCinsiyeti.getSelectedIndex()).getCinsiyetID();
        int kdi = kp.get(cbKategori.getSelectedIndex()).getKategoriID();
        String alisFiyati = txtAlis.getText().trim();
        String satisFiyati = txtSatis.getText().trim();
        String stokAdedi = txtStokAdedi.getText().trim();
        String detay = txtDetay.getText().trim();
        if (jDateChooser1.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen Personelin İşe Başlama Tarihini Giriniz");
        } else {
            String urunGelisTarihi = new SimpleDateFormat("yyyy.MM.dd").format(jDateChooser1.getDate());
            if ((v.sayiValidator(barkodNo)) && (v.sayiValidator(alisFiyati)) && v.sayiValidator(satisFiyati) && (v.sayiValidator(stokAdedi))) {
                if (barkodNo.equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Lütfen Ürün Barkod No Giriniz.");
                    txtBarkod.requestFocus();
                } else if (cbCinsiyeti.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(rootPane, "Lütfen Ürünün Kategorisini Seçiniz");
                } else if (cbKategori.getSelectedIndex() == -1) {
                    JOptionPane.showMessageDialog(rootPane, "Lütfen Ürünün Kategorisini Seçiniz");
                } else if (cbBeden.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(rootPane, "Lütfen Ürünün Bedenini Seçiniz");
                } else if (cbRenk.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(rootPane, "Lütfen Ürünün Rengini Seçiniz");
                } else if (alisFiyati.equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Lütfen Ürünün Alış Fiyatını Giriniz.");
                    txtAlis.requestFocus();
                } else if (satisFiyati.equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Lütfen Ürünün Satış Fiyatını Giriniz");
                    txtSatis.requestFocus();
                } else if (stokAdedi.equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Lütfen Ürünün Stok Adedini Giriniz");
                    txtStokAdedi.requestFocus();
                } else {
                    try {
                        String q = "{call depoKaydet (?,?,?,?,?,?,?,?,?,?,?)}";
                        PreparedStatement pr = db.preBaglan(q);
                        pr.setString(1, barkodNo);
                        pr.setInt(2, cdi);
                        pr.setInt(3, kdi);
                        pr.setString(4, rid);
                        pr.setString(5, bid);
                        pr.setString(6, urunGelisTarihi);
                        pr.setString(7, alisFiyati);
                        pr.setString(8, satisFiyati);
                        pr.setString(9, stokAdedi);
                        pr.setString(10, detay);
                        pr.setString(11, path);
                        int yaz = pr.executeUpdate();
                        if (yaz > 0) {
                            System.out.println("Kayıt İşlemi Başarılı");

                            txtBarkod.setText("");
                            cbCinsiyeti.setSelectedIndex(0);
                            cbKategori.setSelectedIndex(0);
                            cbRenk.setSelectedIndex(0);
                            cbBeden.setSelectedIndex(0);
                            jDateChooser1.setDate(null);
                            txtAlis.setText("");
                            txtSatis.setText("");
                            txtStokAdedi.setText("");
                            txtDetay.setText("");
                            resim.setIcon(null);
                        } else {
                            System.out.println("Kayıt İşlemi Başarısız");
                        }
                    } catch (SQLException e) {
                        System.err.println("Yeni Urun Kaydetme Hatası : " + e);
                    }
                }
            }
        }

    }

    public void cinsiyetDoldur() {
        buttonGroup1.add(rKadin);
        buttonGroup1.add(rErkek);
        cp.clear();
        try {
            String q = "{call cinsiyetGetir ()}";
            ResultSet rs = db.baglan().executeQuery(q);
            while (rs.next()) {
                cinsiyetPro cpro = new cinsiyetPro();
                cpro.setCinsiyetID(rs.getInt("" + cinsiyetEnum.cinsiyetID));
                cpro.setCinsiyet(rs.getString("" + cinsiyetEnum.cinsiyet));
                cp.add(cpro);
            }
            cinsiyetModelDoldur();
        } catch (SQLException e) {
            System.err.println("Cinsiyet Getirme Hatası: " + e);
        }
    }

    public void cinsiyetModelDoldur() {
        DefaultComboBoxModel<String> dbmcins = new DefaultComboBoxModel<>();
        for (cinsiyetPro item : cp) {
            dbmcins.addElement(item.getCinsiyet());
        }
        cbCinsiyeti.setModel(dbmcins);
    }

    public void kategoriDoldur(int kcid) {
        kp.clear();
        try {
            String q = "{call kategoriGetir ('" + kcid + "')} ";
            ResultSet rs = db.baglan().executeQuery(q);
            while (rs.next()) {
                kategoriPro kpro = new kategoriPro();
                kpro.setKategoriID(rs.getInt("" + kategoriEnum.kategoriID));
                kpro.setKategori(rs.getString("" + kategoriEnum.kategori));
                kp.add(kpro);
            }
            kategoriModelDoldur();
        } catch (SQLException e) {
            System.err.println("Kategori Getirme Hatası: " + e);
        }
    }

    public void kategoriModelDoldur() {
        DefaultComboBoxModel<String> dbmkate = new DefaultComboBoxModel<>();
        for (kategoriPro item : kp) {
            dbmkate.addElement(item.getKategori());
        }
        cbKategori.setModel(dbmkate);
    }

    public void personelDuzenleDoldur() {
        personelList pl = new personelList();
        String tckn = txtTc.getText().trim();
        String adi = txtAdi.getText().trim();
        String soyadi = txtSoyadi.getText().trim();
        if (rKadin.isSelected()) {
            cinsiyet = rKadin.getText();
        } else {
            cinsiyet = rErkek.getText();
        }
        String dogumyeri = txtDogumYeri.getText().trim();
        String dogumtarihi = new SimpleDateFormat("yyyy.MM.dd").format(jcDogum.getDate());
        String evtel = txtEvTel.getText().trim();
        String ceptel = txtCepTel.getText().trim();
        String mail = txtMail.getText().trim();
        String adres = txtAdres.getText().trim();
        String isebaslama = new SimpleDateFormat("yyyy.MM.dd").format(jcBaslamaTarih.getDate());
        try {
            String q = "{call personelDuzenle (?,?,?,?,?,?,?,?,?,?,?,?,?,?)} ";
            PreparedStatement pr = db.preBaglan(q);
            pr.setInt(1, Integer.valueOf(pl.pid));
            pr.setString(2, tckn);
            pr.setString(3, adi);
            pr.setString(4, soyadi);
            pr.setString(5, cinsiyet);
            pr.setString(6, dogumyeri);
            pr.setString(7, dogumtarihi);
            pr.setString(8, evtel);
            pr.setString(9, ceptel);
            pr.setString(10, mail);
            pr.setString(11, adres);
            pr.setString(12, isebaslama);
            pr.setString(13, path);
            pr.setInt(14, cid);
            int yaz = pr.executeUpdate();
            if (yaz > 0) {
                System.out.println("Personel Düzenleme İşlemi Başarılı");
                pl.tableDoldur();
                txtTc.setText("");
                txtAdi.setText("");
                txtSoyadi.setText("");
                txtDogumYeri.setText("");
                jcDogum.setDate(null);
                txtEvTel.setText("");
                txtCepTel.setText("");
                txtMail.setText("");
                txtAdres.setText("");
                jcBaslamaTarih.setDate(null);
                lblPresim.setIcon(null);
            } else {
                System.err.println("Personel Düzenleme İşlemi Başarısız");
            }
        } catch (Exception e) {
            System.err.println("Personel Duzenleme Hatası : " + e);
        }
    }
    String path = "";

    public void urunResimEkleDoldur() {
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.image", "jpg", "png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = file.getSelectedFile();
            path = selectedFile.getAbsolutePath().replace("\\", "\\\\");
            System.out.println("path: " + path);
        } else {
            System.out.println("dosya seçilmedi");
        }
    }

    public ImageIcon ResizeImage(String imagePath, byte[] pic, JLabel label) {
        ImageIcon myImage = null;
        if (imagePath != null) {
            myImage = new ImageIcon(imagePath);
        } else {
            myImage = new ImageIcon(pic);
        }
        Image img = myImage.getImage();
        Image img2 = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img2);
        return image;
    }

    public void calisanDoldur() {
        gp.clear();
        try {
            String q = "{call calisanBilgileriGetir ()}";
            ResultSet rs = db.baglan().executeQuery(q);
            while (rs.next()) {
                gorevPro gv = new gorevPro();
                gv.setCid(rs.getInt("" + gorevEnum.cid));
                gv.setCgorevi(rs.getString("" + gorevEnum.cgorevi));
                gp.add(gv);
            }
            calisanModelDoldur();
        } catch (SQLException e) {
            System.err.println("Calisan Bilgisi Getirme Hatası : " + e);
        }
    }

    public void calisanModelDoldur() {
        DefaultComboBoxModel<String> dbm = new DefaultComboBoxModel<>();
        for (gorevPro item : gp) {
            dbm.addElement(item.getCgorevi());
        }
        cbCalisanGorev.setModel(dbm);
    }

    public void urunDuzenleDoldur() {

        String barkodNo = txtBarkod.getText().trim();
        int cdi = cp.get(cbCinsiyeti.getSelectedIndex()).getCinsiyetID();
        int kdi = kp.get(cbKategori.getSelectedIndex()).getKategoriID();
        String alisFiyati = txtAlis.getText().trim();
        String satisFiyati = txtSatis.getText().trim();
        String stokAdedi = txtStokAdedi.getText().trim();
        String detay = txtDetay.getText().trim();
        String urunGelisTarihi = new SimpleDateFormat("yyyy.MM.dd").format(jDateChooser1.getDate());
        urunListesi ul = new urunListesi();

        try {
            String q = "{call urunDuzenle (?,?,?,?,?,?,?,?,?,?,?,?)} ";
            PreparedStatement pr = db.preBaglan(q);
            pr.setInt(1, Integer.valueOf(ul.urunID));
            pr.setInt(2, Integer.valueOf(barkodNo));
            pr.setInt(3, cdi);
            pr.setInt(4, kdi);
            pr.setString(5, rid);
            pr.setString(6, bid);
            pr.setString(7, urunGelisTarihi);
            pr.setString(8, alisFiyati);
            pr.setString(9, satisFiyati);
            pr.setString(10, stokAdedi);
            pr.setString(11, detay);
            pr.setString(12, path);

            int yaz = pr.executeUpdate();
            if (yaz > 0) {
                System.out.println("Ürün Düzenleme İşlemi Başarılı");
                ul.tableDoldur();
                txtBarkod.setText("");
                cbCinsiyeti.setSelectedIndex(0);
                cbKategori.setSelectedIndex(0);
                cbRenk.setSelectedIndex(0);
                cbBeden.setSelectedIndex(0);
                jDateChooser1.setDate(null);
                txtAlis.setText("");
                txtSatis.setText("");
                txtStokAdedi.setText("");
                txtDetay.setText("");
                resim.setIcon(null);
            } else {
                System.out.println("Ürün Düzenleme İşlemi Başarısız");
            }
        } catch (Exception e) {
            System.err.println("Urun Duzenleme Hatası : " + e);
        }
    }

    public void indirimButonuDoldur() {
        String indirim = txtİndirim.getText().trim();
        String q = "{call indirimEkle ('" + indirim + "')}";
        try {
            int cevap = db.baglan().executeUpdate(q);
            System.out.println("cevap" + cevap);
        } catch (SQLException e) {
            System.err.println("İndirim Doldurma Hatası: " + e);
        }
        txtİndirim.setText("");
    }

    public void kasaDoldur() {

        SimpleDateFormat tarih = new SimpleDateFormat("yyyy.MM.dd");
        String baslangic = tarih.format(jdAdetBaslangic.getDate());
        String bitis = tarih.format(jdAdetBaitis.getDate());
        String toplamSatisAdedi = lblToplamAdet.getText();
        String toplamSatisTutari = lblToplamTutar.getText();
        String toplamKar = lblToplamKar.getText();

        String q = "{call satislar ('" + baslangic + "', '" + bitis + "')}";
        try {
            ResultSet rs = db.baglan().executeQuery(q);
            System.out.println(rs);
            if (rs.next()) {
                lblToplamAdet.setText((rs.getString("urunadedi")) + "  ");
                lblToplamTutar.setText((rs.getString("toplamtutar")) + " TL ");
                lblToplamKar.setText((rs.getString("kar")) + " TL ");
            }
        } catch (SQLException e) {
            System.err.println("Rapor Getirme Hatası : " + e);
        }

        try {
            String q1 = "{call raporlar ('" + baslangic + "', '" + bitis + "')}";
            ResultSet rs = db.baglan().executeQuery(q1);

            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("Barkod No");
            dtm.addColumn("Ürün Adı");
            dtm.addColumn("Renk");
            dtm.addColumn("Beden");
            dtm.addColumn("Stok Adedi");
            dtm.addColumn("Kar");
            dtm.addColumn("Ürün Adedi");
            dtm.addColumn("Toplam Tutar");

            while (rs.next()) {
                dtm.addRow(new String[]{rs.getString("urun_barkodno"), rs.getString("kategori"), rs.getString("renk"), rs.getString("beden"), rs.getString("stokadedi"), rs.getString("kar"), rs.getString("UrunAdedi"), rs.getString("ToplamTutar")});

                tblKasa.setModel(dtm);
            }
        } catch (SQLException ex) {
            System.err.println("Rapor Tablosu Doldurma Hatası:" + ex);
        }
    }

    public void personelPanelAc() {
        jpAnaPanel.removeAll();
        jpAnaPanel.repaint();
        jpAnaPanel.revalidate();
        jpAnaPanel.add(jPanel4);
        jpAnaPanel.repaint();
        jpAnaPanel.revalidate();
    }

    public void kullaniciDoldur() {
        String q = "{call kullaniciListele() }";
        DefaultTableModel dtm = new DefaultTableModel();
        try {
            ResultSet rs = db.baglan().executeQuery(q);
            dtm.addColumn("Kullanıcı ID");
            dtm.addColumn("Kullanıcı Adı");
            dtm.addColumn("Kullanici Şifre");
            while (rs.next()) {
                dtm.addRow(new String[]{rs.getString("kid"), rs.getString("kadi"), rs.getString("ksifre")});
            }
            tblKullaniciTablosu.setModel(dtm);
        } catch (SQLException ex) {
            System.out.println("Kullanıcı Tablosu Doldurma Hatası :" + ex);
        }
    }

    public void ürünCinsiyetDoldur() {
        cp.clear();
        try {
            String q = "{call cinsiyetGetir ()}";
            ResultSet rs = db.baglan().executeQuery(q);
            while (rs.next()) {
                cinsiyetPro cpro = new cinsiyetPro();
                cpro.setCinsiyetID(rs.getInt("" + cinsiyetEnum.cinsiyetID));
                cpro.setCinsiyet(rs.getString("" + cinsiyetEnum.cinsiyet));
                cp.add(cpro);
            }
            ürünCinsiyetModelDoldur();
        } catch (SQLException e) {
            System.err.println("Cinsiyet Getirme Hatası: " + e);
        }
    }

    public void ürünCinsiyetModelDoldur() {
        DefaultComboBoxModel<String> dbmcins = new DefaultComboBoxModel<>();
        for (cinsiyetPro item : cp) {
            dbmcins.addElement(item.getCinsiyet());
        }
        jcKateCinsiyet.setModel(dbmcins);
    }

    public void kategoriButonuDoldur() {

        String kategori = txtKategori.getText().trim();
        String cins = jcKateCinsiyet.getSelectedIndex() + "";
        String q = "{call KategoriEkle ('" + kategori + "','" + cins + "')}";
        try {
            int cevap = db.baglan().executeUpdate(q);
            System.out.println("cevap" + cevap);
        } catch (SQLException e) {
            System.err.println("Kategori Doldurma Hatası: " + e);
        }
        txtKategori.setText("");

    }
}
