/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;


/**
 *
 * @author LENOVO

 */
public class Konekcija {
     private Connection konekcija;
    private static Konekcija instance;

    private Konekcija() {
    }

    public static Konekcija getInstance() {
        if (instance == null) {
            instance = new Konekcija();
        }
        return instance;
    }

    public Connection otvoriKonekciju() throws Exception {
        if (konekcija == null || konekcija.isClosed()) {
            Properties properties = new Properties();
            properties.load(new FileInputStream("konfiguracija/konfiguracija.properties"));
            String url = properties.getProperty("url");
            String korisnickoIme = properties.getProperty("korisnickoIme");
            String lozinka = properties.getProperty("lozinka");
            konekcija = DriverManager.getConnection(url, korisnickoIme, lozinka);
            konekcija.setAutoCommit(false);
        }
        return konekcija;
    }
    
    

}
