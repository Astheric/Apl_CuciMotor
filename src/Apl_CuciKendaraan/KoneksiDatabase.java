/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Apl_CuciKendaraan;

/**
 *
 * @author Asus
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class KoneksiDatabase {
    private static Connection mysqlconfig; // Menggunakan nama yang lebih deskriptif

    public static Connection configDB() throws SQLException {
        try {
            // Konfigurasi koneksi
            String url = "jdbc:mysql://localhost:3306/cuci_motor"; // Ganti 'db_kantor' dengan nama database Anda
            String user = "root"; // User default MySQL di XAMPP
            String pass = "";     // Password default MySQL di XAMPP (kosong)
            
            // Mendaftarkan driver dan membuat koneksi
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            mysqlconfig = DriverManager.getConnection(url, user, pass);
            
        } catch (SQLException e) {
            // Menampilkan pesan error jika koneksi gagal
            JOptionPane.showMessageDialog(null, "Koneksi ke database gagal: " + e.getMessage());
            // Melempar kembali exception agar bisa ditangani di level yang lebih tinggi jika perlu
            throw e; 
        }
        return mysqlconfig;
    }
}
