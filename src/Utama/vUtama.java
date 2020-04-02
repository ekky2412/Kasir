package Utama;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.text.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;

public class vUtama extends JFrame{
    JTabbedPane tab = new JTabbedPane();
    JPanel pKasir = new JPanel();
    JPanel pBarang = new JPanel();
    JPanel pLaporan = new JPanel();

//    Bagian Kasir
    JLabel lno = new JLabel("No Transaksi : ",SwingConstants.RIGHT);
    JLabel fno = new JLabel();
    JLabel ltanggal = new JLabel("Tanggal : ",SwingConstants.RIGHT);
    JLabel ftanggal = new JLabel();
    JLabel lkasir = new JLabel("Kasir : ",SwingConstants.RIGHT);
    JLabel fkasir = new JLabel();
    JLabel lmember = new JLabel("Member : ",SwingConstants.RIGHT);
    JLabel lkode = new JLabel("Kode Item : ",SwingConstants.RIGHT);
    JLabel ljum = new JLabel("Jumlah : ",SwingConstants.RIGHT);

    String[] isi = {"UMUM","MEMBER"};
    JComboBox fmember = new JComboBox(isi);
    JTextField fkode = new JTextField(15);
    JTextField fjum = new JTextField(7);
    JTextField ftotal = new JTextField("12.000",30);

    JButton bTambah = new JButton("Tambah");
    JButton bHapus = new JButton("Hapus");
    JButton bBayar = new JButton("Bayar");

    JPanel data = new JPanel();
    JPanel dbarang = new JPanel();
    String[] column = {"","No","Kode Item","Nama Barang","Harga","Jumlah","Total"};
    int a = 12000;
    int b = 20;
    Object[][] tdata = {{"","1","123","pensil",a,b,new Integer(a*b)}};
    JTable table = new JTable(tdata,column);
    DefaultTableCellRenderer righttable = new DefaultTableCellRenderer();
    JScrollPane jScrollPane = new JScrollPane(table);
//    End Bagian Kasir

    public vUtama(){
        setTitle("Sistem Kasir");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
//        setUndecorated(true);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);

        tab.addTab("Kasir",pKasir);
        tab.addTab("Barang",pBarang);
        tab.addTab("Laporan",pLaporan);

//        Bagian Kasir
        pKasir.setLayout(null);
        dbarang.setLayout(new FlowLayout(FlowLayout.LEADING,30,3));
        dbarang.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        data.setLayout(null);
        data.setSize(300,300);
        ftotal.setSize(200,200);
        ftotal.setFont(new Font("SansSerif",Font.PLAIN,90));
        ftotal.setHorizontalAlignment(SwingConstants.RIGHT);
        ftotal.setEditable(false);

//        Setting Tabel
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setRowHeight(20);
        table.setFont(new Font("SansSerif",Font.PLAIN,14));
        table.getColumnModel().getColumn(0).setPreferredWidth(25);
        table.getColumnModel().getColumn(1).setPreferredWidth(30);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
        table.getColumnModel().getColumn(3).setPreferredWidth(542);
        table.getColumnModel().getColumn(4).setPreferredWidth(300);
        table.getColumnModel().getColumn(5).setPreferredWidth(100);
        table.getColumnModel().getColumn(6).setPreferredWidth(300);
        righttable.setHorizontalAlignment(JLabel.RIGHT);
        table.getColumnModel().getColumn(4).setCellRenderer(righttable);
        table.getColumnModel().getColumn(5).setCellRenderer(righttable);
        table.getColumnModel().getColumn(6).setCellRenderer(righttable);

//        Tambah ke panel data
        data.add(lno);
        data.add(fno);
        data.add(ltanggal);
        Timer date = new Timer();
        date.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                ftanggal.setText(new SimpleDateFormat("E, dd MMMM yyyy HH:mm:ss").format(new java.util.Date()));
            }
        },0,1000);
        data.add(ftanggal);
        data.add(lkasir);
        data.add(fkasir);
        data.add(lmember);
        data.add(fmember);
        pKasir.add(data);

//        Tambah ke panel kode barang
        dbarang.add(lkode);
        dbarang.add(fkode);
        dbarang.add(ljum);
        dbarang.add(fjum);
        dbarang.add(bTambah);
        dbarang.add(bHapus);
        dbarang.add(bBayar);
        pKasir.add(dbarang);

//        tampilan total dan tabel di panel kasir
        pKasir.add(ftotal);
        pKasir.add(jScrollPane);

//        set bound panel data
        lno.setBounds(10,10,100,20);
        fno.setBounds(120,10,160,20);
        ltanggal.setBounds(10,40,100,20);
        ftanggal.setBounds(120,40,160,20);
        lkasir.setBounds(10,70,100,20);
        fkasir.setBounds(120,70,160,20);
        lmember.setBounds(10,100,100,20);
        fmember.setBounds(120,100,160,20);
        ftotal.setBounds(320,20,1165,110);

//        set panel data, kode barang dan tabel
        data.setBounds(10,10,300,130);
        dbarang.setBounds(10,140,800,30);
        jScrollPane.setBounds(10,180,1500,600);

        add(tab);
        tab.setBounds(5,0,1530,835);
    }

    public static void main(String[] args) {
        new vUtama();
    }
}
