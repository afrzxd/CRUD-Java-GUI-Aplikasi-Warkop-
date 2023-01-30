import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.HeadlessException;
import javax.swing.ImageIcon;
/**
 *
 * @author 
 */
public class Riwayat_Order extends JFrame {
    private JTable tabel,tbl;
    private DefaultTableModel model;
    private JLabel JLabel1;
    private JPanel panel1,panelpesanan,paneltable;
    private JTextField txtnopesanan,txtnama,txttotalharga,txtbayar,txtkembalian,txtharga,txtjumlahpesanan;
    private JComboBox cbpesanan;
    private JButton btnhitung,btnbayar,btnupdate,btndelete;
    
     public Riwayat_Order(){
        ImageIcon icon = new ImageIcon("onlineshop_78377.png");
        setIconImage(icon.getImage());
        setTitle("Riwayat Order");
        setSize(920, 590);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        IsiTabel();
        setVisible(true);
        setResizable(false);
        tabelin();
    }
    private void IsiTabel(){
         panel1 = new JPanel(null);
         panel1.setBackground(new Color(245, 245, 245));
         panel1.setPreferredSize(new Dimension(920,290));
         this.add(panel1);
         JLabel head = new JLabel("WARKOP DKI");
         head.setBounds(411,8,90,35);
         head.setHorizontalAlignment(JLabel.CENTER);
         panel1.add(head);
         JLabel jlabel2 = new JLabel("No. Pesanan");
         jlabel2.setBounds(5,62,90,30);
         panel1.add(jlabel2);
         txtnopesanan = new JTextField();
         txtnopesanan.setBounds(95,61,90,30);
         panel1.add(txtnopesanan);
         
         
         panelpesanan = new JPanel(null);
         panelpesanan.setBounds(5,99,909,178);
         panelpesanan.setBackground(new Color(255,255,255));
         panel1.add(panelpesanan);
         
         JLabel jlabel3 = new JLabel("Nama Pembeli");
         jlabel3.setBounds(9,13,90,30);
         panelpesanan.add(jlabel3);
         txtnama = new JTextField();
         txtnama.setBounds(179,13,120,30);
         panelpesanan.add(txtnama);
         
         JLabel jlabel4 = new JLabel("Pesanan");
         jlabel4.setBounds(7,53,90,35);
         panelpesanan.add(jlabel4);
         String[] cbpesananItems = {"Pilih Pesanan", "Kopi", "Teh Manis", "Es Jeruk", "Air Putih", "Susu", "Wedang Jahe"};
         cbpesanan = new JComboBox(cbpesananItems);
         cbpesanan.setBounds(178,53,120,30);
         panelpesanan.add(cbpesanan);
         
         cbpesanan.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                switch (cbpesanan.getSelectedIndex()){
                case 0:
                    txtharga.setText("0");
                    break;
                case 1:
                    txtharga.setText("4000");
                    break;
                case 2:
                    txtharga.setText("5000");
                    break;
                case 3:
                    txtharga.setText("3000");
                    break;
                case 4:
                    txtharga.setText("3000");
                    break;
                case 5:
                    txtharga.setText("5000");
                    break;
                case 6:
                    txtharga.setText("9000");
                    break;
                default:
                    txtharga.setText("");
                    break;
                }
              }
            });
            
            
         JLabel jlabel5 = new JLabel("Harga");
         jlabel5.setBounds(9,95,90,35);
         panelpesanan.add(jlabel5);
         txtharga = new JTextField();
         txtharga.setBounds(179,95,120,30);
         panelpesanan.add(txtharga);
         
         JLabel jlabel6 = new JLabel("Jumlah Pesanan");
         jlabel6.setBounds(7,132,110,30); 
         panelpesanan.add(jlabel6);
         txtjumlahpesanan = new JTextField();
         txtjumlahpesanan.setBounds(179,134,120,30);
         panelpesanan.add(txtjumlahpesanan);
         
         btnhitung = new JButton("HITUNG");
         btnhitung.setBounds(402,134,90,30);
         panelpesanan.add(btnhitung);
         hitung();
         btnbayar = new JButton("BAYAR");
         btnbayar.setBounds(507,135,90,30);
         panelpesanan.add(btnbayar);
         bayar();
         
         JLabel jlabel7 = new JLabel("Total Harga");
         jlabel7.setBounds(327,13,90,35);
         panelpesanan.add(jlabel7);
         txttotalharga = new JTextField();
         txttotalharga.setBounds(476,13,120,30);
         panelpesanan.add(txttotalharga);
         
         JLabel jlabel8 = new JLabel("Bayar");
         jlabel8.setBounds(329,53,90,35);
         panelpesanan.add(jlabel8);
         txtbayar = new JTextField();
         txtbayar.setBounds(476,53,120,30);
         panelpesanan.add(txtbayar);
         
         JLabel jlabel9 = new JLabel("Kembalian");
         jlabel9.setBounds(331,93,90,30);
         panelpesanan.add(jlabel9);
         txtkembalian = new JTextField();
         txtkembalian.setBounds(477,95,120,30);
         panelpesanan.add(txtkembalian);
         
         JLabel jlabel10 = new JLabel("*Edit Tabel");
         jlabel10.setBounds(618,23,90,25);
         panelpesanan.add(jlabel10);
         
         paneltable = new JPanel(null);
         paneltable.setBounds(617,56,284,62);
         paneltable.setBackground(new Color(214,217,223));
         panelpesanan.add(paneltable);
         
         btndelete = new JButton("DELETE");
         btndelete.setBounds(147,14,120,35);
         paneltable.add(btndelete);
         delete();
         btnupdate = new JButton("UPDATE");
         btnupdate.setBounds(6,14,120,35);
         paneltable.add(btnupdate);
         update();
         //agar kolom tidak bisa di edit
         txtnopesanan.setEditable(false);
         txtharga.setEditable(false);
         txttotalharga.setEditable(false);
         txtkembalian.setEditable(false);
         
            model = new DefaultTableModel();
            tabel = new JTable(model);
            
            JPanel panel = new JPanel(null);
            panel.setBounds(3,221,912,364);
            panel1.add(panel);
            model.addColumn("No. Pesanan");
            model.addColumn("Nama");
            model.addColumn("Pesanan");
            model.addColumn("Harga");
            model.addColumn("Jumlah");
            model.addColumn("Total Harga");
            model.addColumn("Bayar");
            model.addColumn("Kembalian");
            tabel.setModel(model); //masukin nama tabel
            
            getContentPane().add(new JScrollPane(tbl));
             getContentPane().add(panel1, "North"); 
            JScrollPane scroll = new JScrollPane(tabel);
            
            getContentPane().add(scroll);
        }
    
     private void tabelin(){ 
         int row = model.getRowCount();
         for(int a = 0; a < row; a++){
             model.removeRow(0);
         }
        try {
            
            String sql = "SELECT * FROM warkop";
            Connection conn=(Connection)Koneksi.getKoneksi();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(sql);
            
            while (res.next()){
                model.addRow(new Object[]{
                    res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4),
                    res.getString(5),
                    res.getString(6),
                    res.getString(7),
                    res.getString(8)});
                
            }
            
            
         }catch(SQLException e){
            System.out.println("Error" + e.getMessage());
        }
                     tabel.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent evt) {
                    // kode untuk menangani mouse click event di sini
                            int baris = tabel.rowAtPoint(evt.getPoint());
                            String no_pesanan = tabel.getValueAt(baris, 0).toString();
                            txtnopesanan.setText(no_pesanan);
                            String nama = tabel.getValueAt(baris, 1).toString();
                            txtnama.setText(nama);
                            String pesanan = tabel.getValueAt(baris, 2).toString();
                            cbpesanan.setSelectedItem(pesanan);
                            String harga = tabel.getValueAt(baris, 3).toString();
                            txtharga.setText(harga);
                            String jumlah_pesanan = tabel.getValueAt(baris, 4).toString();
                            txtjumlahpesanan.setText(jumlah_pesanan);
                            String total = tabel.getValueAt(baris, 6).toString();
                            txttotalharga.setText("");
                            String bayar = tabel.getValueAt(baris, 6).toString();
                            txtbayar.setText(bayar);
                            String kembalian = tabel.getValueAt(baris, 7).toString();
                            txtkembalian.setText("");
                        }
                });
        }
        
        private void hitung(){   
        btnhitung.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
             if(txtnama.getText().isEmpty() || txtharga.getText().isEmpty() || cbpesanan.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null, "Semua Kolom Wajib Terisi");
        }else{
                int harga = Integer.parseInt(txtharga.getText());
                int jumlah = Integer.parseInt(txtjumlahpesanan.getText());
                int hitung = harga * jumlah;
                txttotalharga.setText(""+hitung);
        }
            }
          
        });
        }
        
        private void bayar(){
            btnbayar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(txttotalharga.getText().isEmpty() || txtbayar.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Total Harga / Bayar Tidak Boleh Kosong");
                }else{
                    int total = Integer.parseInt(txttotalharga.getText());
                    int bayar = Integer.parseInt(txtbayar.getText());

                        if (bayar < total) {
                            JOptionPane.showMessageDialog(null,"Uang yang dibayarkan kurang dari total harga");
                        } else {
                            int kembali = bayar - total;
                            txtkembalian.setText("" + kembali);
                            
                        JOptionPane.showMessageDialog(null,"BERHASIL ! SILAHKAN KLIK TOMBOL UPDATE");
                        
                        }
                    
                    }
                }
        });
        
    }    
        private void update(){
            btnupdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                  try {
                       Connection conn = (Connection)Koneksi.getKoneksi();
                       String sql = "UPDATE warkop SET nama = ?, pesanan = ?, harga = ?, jumlah_pesanan = ?, total_harga = ?, bayar = ?, kembali = ? WHERE no_pesanan ='" + txtnopesanan.getText()+"'";
                       PreparedStatement pstmt = conn.prepareStatement(sql);
                       pstmt.setString(1,txtnama.getText());
                       pstmt.setString(2,cbpesanan.getSelectedItem().toString());
                       pstmt.setString(3,txtharga.getText());
                       pstmt.setString(4,txtjumlahpesanan.getText());
                       pstmt.setString(5,txttotalharga.getText());
                       pstmt.setString(6,txtbayar.getText());
                       pstmt.setString(7,txtkembalian.getText());
                       pstmt.executeUpdate();
                       JOptionPane.showMessageDialog(null,"BERHASIL UPDATE");
                       tabelin();
                    } catch (SQLException ex) {
                       System.out.println("Error: " + ex.getMessage());
                    }

                   }
            });

    }
        private void delete(){
            btndelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            if (txtkembalian.getText().isEmpty()){
             JOptionPane.showMessageDialog(null,"Kembalian Masih Kosong");
            } else{
            int ok=JOptionPane.showConfirmDialog(null,"Apakah Anda yakin?","Konfirmasi",JOptionPane.YES_NO_OPTION);
                if(ok==0){
                    try{
                         //panggil method koneksi
                        Connection conn = (Connection)Koneksi.getKoneksi();
                        String sql="delete from warkop where no_pesanan = '" + txtnopesanan.getText()+"'";
                        PreparedStatement stmt=conn.prepareStatement(sql);
                        stmt.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Data Berhasil dihapus");
                        tabelin();
                    }catch(SQLException ew){
                        JOptionPane.showMessageDialog(null,"Data Gagal dihapus!"
                                + "\nDengan pesan error : " + ew.getMessage());
                    }
                } 
            }
                }
            });
    }    

    public static void main(String[] args) throws Exception {
        Riwayat_Order Riwayat_Order = new Riwayat_Order();
    }

}
