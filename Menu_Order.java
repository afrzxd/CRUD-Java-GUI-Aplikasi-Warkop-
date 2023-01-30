import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.HeadlessException;
import javax.swing.ImageIcon;
public class Menu_Order extends JPanel {
    private JLabel JLabel1, JLabel2,JLabel3,JLabel4,JLabel5,JLabel6,JLabel7,JLabel8,JLabel9,JLabel10,JLabel11,JLabel12,JLabel13;
    private JTextField txtnopesanan, txtnama, txtkembalian, txtharga, txtjumlahpesanan, txttotalharga, txtbayar;
    private JButton btnhitung, btnbayar;
    private JComboBox cbpesanan;
    public Menu_Order() {
        //mengatur ukuran
        setPreferredSize (new Dimension (387, 570));
        setLayout (null);
        
        //KOMPONEN PADA GUI 
        JLabel1 = new JLabel ("Warkop DKI");
        JLabel1.setBounds (165, 15, 100, 25);
        add (JLabel1);
        
        JLabel2 = new JLabel ("No. Pesanan");
        JLabel2.setBounds (195, 65, 100, 25);
        add (JLabel2);
        txtnopesanan = new JTextField (5);
        txtnopesanan.setBounds (270, 65, 100, 25);
        add (txtnopesanan);
        
        JLabel3 = new JLabel ("Nama Costumer");
        JLabel3.setBounds (25, 110, 100, 25);
        add (JLabel3);
        txtnama = new JTextField ();
        txtnama.setBounds (180, 115, 200, 25);
        add (txtnama);
        
        
        JLabel4 = new JLabel ("Pesanan");
        JLabel4.setBounds (25, 155, 100, 25);
        add (JLabel4);
        String[] cbpesananItems = {"Pilih Pesanan", "Kopi", "Teh Manis", "Es Jeruk", "Air Putih", "Susu", "Wedang Jahe"};
        cbpesanan = new JComboBox (cbpesananItems);
        cbpesanan.setBounds (180, 155, 200, 25);
        add (cbpesanan);
        
        JLabel5 = new JLabel ("Harga");
        JLabel5.setBounds (25, 195, 100, 25);
        add (JLabel5);
        txtharga = new JTextField ();
        txtharga.setBounds (180, 195, 200, 25);
        add (txtharga);
        
        JLabel6 = new JLabel ("Jumlah Pesanan");
        JLabel6.setBounds (25, 230, 100, 25);
        add (JLabel6);
        txtjumlahpesanan = new JTextField ();
        txtjumlahpesanan.setBounds (180, 230, 200, 25);
        add (txtjumlahpesanan);
        
        btnhitung = new JButton ("HITUNG");
        btnhitung.setBounds (280, 275, 100, 25);
        add (btnhitung);
        
        JLabel7 = new JLabel ("--------------------------------------------------------------------------------------------");
        JLabel7.setBounds (10, 295, 390, 45);
        add (JLabel7);
        
        JLabel8 = new JLabel ("Total Harga");
        JLabel8.setBounds (15, 335, 100, 25);
        add (JLabel8);
        txttotalharga = new JTextField ();
        txttotalharga.setBounds (185, 330, 195, 30);
        add (txttotalharga);
        
        JLabel9 = new JLabel ("Bayar");
        JLabel9.setBounds (15, 365, 100, 25);
        add (JLabel9);
        txtbayar = new JTextField ();
        txtbayar.setBounds (185, 370, 195, 30);
        add (txtbayar);
        
        btnbayar = new JButton ("BAYAR");
        btnbayar.setBounds (280, 420, 100, 25);
        add (btnbayar);
        
        JLabel10 = new JLabel ("--------------------------------------------------------------------------------------------");
        JLabel10.setBounds (15, 435, 370, 35);
        add (JLabel10);
        
        JLabel11 = new JLabel ("KEMBALIAN");
        JLabel11.setBounds (20, 480, 100, 25);
        add (JLabel11);
        txtkembalian = new JTextField ();
        txtkembalian.setBounds (95, 465, 285, 50);
        add (txtkembalian);
        
        JLabel12 = new JLabel ("-------------------------------------------------------------------------------------------- ");
        JLabel12.setBounds (5, 85, 375, 25);
        add (JLabel12);
        //Properti yang digunakan pada komponen
        //setEditable berfungsi agar kolom bisa di ketik atau tidak ,, disini di false /tidak bisa di edit
        txtharga.setEditable (false);
        txttotalharga.setEditable(false);
        
        //untuk combobox Pilih Pesanan", "Kopi", "Teh Manis", "Es Jeruk", "Air Putih", "Susu", "Wedang Jahe"
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
                            try{
                        String sql = "INSERT INTO warkop VALUES('"+txtnopesanan.getText()+"','"+txtnama.getText()+"','"+cbpesanan.getSelectedItem()+"','"+txtharga.getText()+"','"+txtjumlahpesanan.getText()+"','"+txttotalharga.getText()+"','"+txtbayar.getText()+"','"+txtkembalian.getText()+"')";
                        java.sql.Connection conn = (Connection)Koneksi.getKoneksi();
                        java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                        pstm.execute();
                        JOptionPane.showMessageDialog(null,"Proses Simpan Data Berhasil");
                        
                            } catch (HeadlessException | SQLException evt) {
                        JOptionPane.showMessageDialog(null,evt.getMessage());
                        }
                        }
                    
                    }
                }
        });
        
    }    
        //add components
        //set component bounds (only needed by Absolute Positioning)
    public static void main (String[] args) {
        ImageIcon icon = new ImageIcon("onlineshop_78377.png");
        JFrame frame1 = new JFrame ("Menu Order");
        frame1.setIconImage(icon.getImage());
        frame1.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame1.getContentPane().add (new Menu_Order());
        frame1.pack();
        frame1.setVisible (true);
        frame1.setResizable(true);
        frame1.setLocationRelativeTo(null);
        }
}