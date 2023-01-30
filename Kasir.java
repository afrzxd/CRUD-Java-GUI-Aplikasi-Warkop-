import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Kasir extends JPanel {
    private JButton btnmenu;
    private JButton btnriwayat;
    private JLabel JLabel1;
    private JFrame frame;

    public Kasir() {
        //adjust size and set layout
        setPreferredSize (new Dimension (343, 386));
        setLayout (null);
        
        //KOMPONEN PADA GUI 
        btnmenu = new JButton ("Menu Order");
        btnmenu.setBounds (80, 90, 210, 90);
        add (btnmenu);
        
        btnriwayat = new JButton ("Riwayat Order");
        btnriwayat.setBounds (80, 210, 210, 90);
        add (btnriwayat);
        
        JLabel1 = new JLabel ("MENU KASIR");
        JLabel1.setBounds (145, 40, 100, 25);
        add (JLabel1);
        
        btnmenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu_Order.main(null);

            }
        });
        btnriwayat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try
                {
                    Riwayat_Order.main(null);
                
                }
                catch (Exception ex)
                {
                   
                }
            }
        });
    }

public static void main (String[] args) {
        ImageIcon icon = new ImageIcon("onlineshop_78377.png");
        JFrame frame = new JFrame ("Kasir");
        frame.setIconImage(icon.getImage());
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new Kasir());
        frame.pack();
        frame.setVisible (true);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
    }
}