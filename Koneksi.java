import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;
public class Koneksi {
    private static Connection conn;
    public static Connection getKoneksi(){
        Connection con = null;
        try{
            Class.forName("org.sqlite.JDBC");
            // db parameters
            String url = "jdbc:sqlite:warkop.db";
            // create a connection to the database
            con = DriverManager.getConnection(url);
            JOptionPane.showMessageDialog(null,"Koneksi Berhasil");          
            //System.out.println("Koneksi Berhasil");
            // buat tabel warkop
            String sql = "CREATE TABLE IF NOT EXISTS warkop (\n"
                    + "no_pesanan varchar(10) PRIMARY KEY,\n"
                    + "nama varchar (50),\n"
                    + "pesanan varchar (20),\n"
                    + "harga varchar(100),\n"
                    + "jumlah_pesanan varchar(100),\n"
                    + "total_harga varchar(100),\n"
                    + "bayar varchar(100),\n"
                    + "kembali varchar(100)\n"
                    + ");";

            Statement stmt = con.createStatement();
            stmt.execute(sql);
            stmt.executeUpdate("select * from warkop");
        }catch(Exception e){
            System.out.println(e);
        }
        return con;
    }
}