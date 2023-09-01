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
public class Gost implements OpstiDomenskiObjekat{
    private int gostID;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String lozinka;
    private String brojTelefona;

    public Gost() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.gostID;
        hash = 19 * hash + Objects.hashCode(this.ime);
        hash = 19 * hash + Objects.hashCode(this.prezime);
        hash = 19 * hash + Objects.hashCode(this.korisnickoIme);
        hash = 19 * hash + Objects.hashCode(this.lozinka);
        hash = 19 * hash + Objects.hashCode(this.brojTelefona);
        return hash;
    }

    @Override
    public String toString() {
return ime + " " + prezime;
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
        final Gost other = (Gost) obj;
        if (this.gostID != other.gostID) {
            return false;
        }
        if (!Objects.equals(this.ime, other.ime)) {
            return false;
        }
        if (!Objects.equals(this.prezime, other.prezime)) {
            return false;
        }
        if (!Objects.equals(this.korisnickoIme, other.korisnickoIme)) {
            return false;
        }
        if (!Objects.equals(this.lozinka, other.lozinka)) {
            return false;
        }
        return Objects.equals(this.brojTelefona, other.brojTelefona);
    }

    public Gost(int gostID, String ime, String prezime, String korisnickoIme, String lozinka, String brojTelefona) {
        this.gostID = gostID;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.brojTelefona = brojTelefona;
    }

    public Gost(String ime, String prezime, String korisnickoIme, String lozinka, String brojTelefona) {
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.brojTelefona = brojTelefona;
    }

  

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public int getGostID() {
        return gostID;
    }

    public void setGostID(int gostID) {
        this.gostID = gostID;
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

    @Override
    public String vratiImeTabele() {
return "gost";
    }

    @Override
    public void setId(int id) {
this.gostID=id;
    }

    @Override
    public OpstiDomenskiObjekat vratiRedIzRS(ResultSet rs) {

        Gost g = new Gost();
        try {
            
            g.setGostID(rs.getInt("gostID"));
            g.setIme(rs.getString("ime"));
            g.setPrezime(rs.getString("prezime"));
            g.setKorisnickoIme(rs.getString("korisnickoIme"));
            g.setLozinka(rs.getString("lozinka"));
            g.setBrojTelefona(rs.getString("brojTelefona"));
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Menadzer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return g;
    }

    @Override
    public void ubaciVrednostiZaInsert(PreparedStatement statement) {
 try {
           
           
            statement.setString(1, ime);
            statement.setString(2, prezime);
             statement.setString(3, korisnickoIme);
            statement.setString(4, lozinka);
            statement.setString(5, brojTelefona);
          
        } catch (SQLException ex) {
            Logger.getLogger(Menadzer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ubaciVrednostiZaUpdate(PreparedStatement statement) {
try {
           
           
            statement.setString(1, ime);
            statement.setString(2, prezime);
             statement.setString(3, korisnickoIme);
            statement.setString(4, lozinka);
            statement.setString(5, brojTelefona);
          
        } catch (SQLException ex) {
            Logger.getLogger(Menadzer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public int getId() {
        return gostID;
    }

    @Override
    public String vratiWhereZaSelect() {
 if(this.getGostID()!= 0) {
            return "gostID = ?";
        }
        
        ArrayList<String> wheres = new ArrayList<>();
        
        if(ime != null) {
            wheres.add("ime like ?");
        }

        if(prezime != null) {
            wheres.add("prezime like ?");
        }

        if(korisnickoIme != null) {
            wheres.add("korisnickoIme like ?");
        }

        if(lozinka != null) {
            wheres.add("lozinka like ?");
        }
        
        return String.join(" or ", wheres);
 
    }

    @Override
    public void ubaciVrednostiZaSelectZaWhere(PreparedStatement statement) {
   try {
            if(this.getGostID()!= 0) {
                statement.setInt(1, getGostID());
            } else {
                int i = 1;
                
                if(ime != null) {
                    statement.setString(i, "%" + ime + "%");
                    i++;
                }

                if(prezime != null) {
                    statement.setString(i, "%" + prezime + "%");
                    i++;
                }

                if(korisnickoIme != null) {
                    statement.setString(i, "%" + korisnickoIme + "%");
                    i++;
                }

                if(lozinka != null) {
                    statement.setString(i, "%" + lozinka + "%");
                    i++;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Gost.class.getName()).log(Level.SEVERE, null, ex);
        }

           
    }

    @Override
    public String vratiNaziveKolonaSelect() {
return "gostID,ime,prezime,korisnickoIme,lozinka,brojTelefona";
    }

    @Override
    public String vratiNaziveKolonaZaInsert() {
return "ime,prezime,korisnickoIme,lozinka,brojTelefona";
    }

    @Override
    public String vratiNaziveKolonaZaUpdate() {
return "ime,prezime,korisnickoIme,lozinka,brojTelefona";
    }

    @Override
    public String vratiNazivID() {
return "gostID";
    }

    @Override
    public String vratiJoinzaSelect() {
return "";
    }
    
    
}
