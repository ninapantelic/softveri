/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class Menadzer implements OpstiDomenskiObjekat  {
    
    private int menadzerID;
    private String korisnickoIme;
    private String lozinka;
    private String ime;
    private String prezime;
    private String mejl;

    public Menadzer() {
    }

    public Menadzer(int menadzerID, String korisnickoIme, String lozinka, String ime, String prezime, String mejl) {
        this.menadzerID = menadzerID;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.mejl = mejl;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.menadzerID;
        hash = 47 * hash + Objects.hashCode(this.korisnickoIme);
        hash = 47 * hash + Objects.hashCode(this.lozinka);
        hash = 47 * hash + Objects.hashCode(this.ime);
        hash = 47 * hash + Objects.hashCode(this.prezime);
        hash = 47 * hash + Objects.hashCode(this.mejl);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Menadzer other = (Menadzer) obj;
        if (this.menadzerID != other.menadzerID) {
            return false;
        }
        if (!Objects.equals(this.korisnickoIme, other.korisnickoIme)) {
            return false;
        }
        if (!Objects.equals(this.lozinka, other.lozinka)) {
            return false;
        }
        if (!Objects.equals(this.ime, other.ime)) {
            return false;
        }
        if (!Objects.equals(this.prezime, other.prezime)) {
            return false;
        }
        return Objects.equals(this.mejl, other.mejl);
    }

    public String getMejl() {
        return mejl;
    }

    public void setMejl(String mejl) {
        this.mejl = mejl;
    }

    public int getMenadzerID() {
        return menadzerID;
    }

    public void setMenadzerID(int menadzerID) {
        this.menadzerID = menadzerID;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    @Override
    public String vratiImeTabele() {
return "menadzer";
    }

  


    @Override
    public void setId(int id) {
this.menadzerID=id;
    }

    
    @Override
    public OpstiDomenskiObjekat vratiRedIzRS(ResultSet rs) {
 Menadzer m = new Menadzer();
        try {
            
            
            m.setId(rs.getInt("menadzerID"));
           m.setKorisnickoIme(rs.getString("korisnickoIme"));
           m.setLozinka(rs.getString("lozinka"));
           m.setIme(rs.getString("ime"));
           m.setPrezime(rs.getString("prezime"));
           m.setMejl(rs.getString("mejl"));
            
        } catch (SQLException ex) {
            Logger.getLogger(Menadzer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return m;

    }

    @Override
    public void ubaciVrednostiZaInsert(PreparedStatement statement) {
        try {
           
            statement.setString(1, korisnickoIme);
            statement.setString(2, lozinka);
            statement.setString(3, ime);
            statement.setString(4, prezime);
            statement.setString(5, mejl);
          
        } catch (SQLException ex) {
            Logger.getLogger(Menadzer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void ubaciVrednostiZaUpdate(PreparedStatement statement) {
   try {
        
            statement.setString(1, korisnickoIme);
            statement.setString(2, lozinka);
            statement.setString(3, ime);
            statement.setString(4, prezime);
            statement.setString(5, mejl);
          
        } catch (SQLException ex) {
            Logger.getLogger(Menadzer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getId() {
return menadzerID;
    }

    @Override
    public String vratiWhereZaSelect() {
if(this.getMenadzerID() != 0){
    return "menadzerID = ?";
}
 return "";      
        
    }

    @Override
    public void ubaciVrednostiZaSelectZaWhere(PreparedStatement statement) {
      
           try {
                if(this.getMenadzerID() != 0){
               statement.setInt(1,this.getId());
                }
           } catch (SQLException ex) {
               Logger.getLogger(Menadzer.class.getName()).log(Level.SEVERE, null, ex);
           }
           
           
}
    

    @Override
    public String vratiNaziveKolonaSelect() {
return "menadzerID,korisnickoIme,lozinka,ime,prezime,mejl";
    }

    @Override
    public String vratiNaziveKolonaZaInsert() {
return "korisnickoIme,lozinka,ime,prezime,mejl";
    }

   

    @Override
    public String vratiNaziveKolonaZaUpdate() {
return "korisnickoIme,lozinka,ime,prezime,mejl";
    }

    @Override
    public String vratiNazivID() {
return "menadzerID";
    }

    @Override
    public String vratiJoinzaSelect() {
return "";
    }

  
     
    
}
