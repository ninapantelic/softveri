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
public class Apartman implements OpstiDomenskiObjekat  {
    private int apartmanID;
    private String nazivApartmana;
    private int cena;
    private boolean raspolozivost;
    private int brojSoba;
    private boolean balkon;

    public Apartman() {
    }

    public Apartman(int apartmanID, String nazivApartmana, int cena, boolean raspolozivost, int brojSoba, boolean balkon) {
        this.apartmanID = apartmanID;
        this.nazivApartmana = nazivApartmana;
        this.cena = cena;
        this.raspolozivost = raspolozivost;
        this.brojSoba = brojSoba;
        this.balkon = balkon;
    }

    public String getNazivApartmana() {
        return nazivApartmana;
    }

    public void setNazivApartmana(String nazivApartmana) {
        this.nazivApartmana = nazivApartmana;
    }

    @Override
    public String toString() {
return nazivApartmana;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.apartmanID;
        hash = 89 * hash + Objects.hashCode(this.nazivApartmana);
        hash = 89 * hash + this.cena;
        hash = 89 * hash + (this.raspolozivost ? 1 : 0);
        hash = 89 * hash + this.brojSoba;
        hash = 89 * hash + (this.balkon ? 1 : 0);
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
        final Apartman other = (Apartman) obj;
        if (this.apartmanID != other.apartmanID) {
            return false;
        }
        if (this.cena != other.cena) {
            return false;
        }
        if (this.raspolozivost != other.raspolozivost) {
            return false;
        }
        if (this.brojSoba != other.brojSoba) {
            return false;
        }
        if (this.balkon != other.balkon) {
            return false;
        }
        return Objects.equals(this.nazivApartmana, other.nazivApartmana);
    }

   

    

    public boolean isBalkon() {
        return balkon;
    }

    public void setBalkon(boolean balkon) {
        this.balkon = balkon;
    }

    public int getApartmanID() {
        return apartmanID;
    }

    public void setApartmanID(int apartmanID) {
        this.apartmanID = apartmanID;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public boolean isRaspolozivost() {
        return raspolozivost;
    }

    public void setRaspolozivost(boolean raspolozivost) {
        this.raspolozivost = raspolozivost;
    }

    public int getBrojSoba() {
        return brojSoba;
    }

    public void setBrojSoba(int brojSoba) {
        this.brojSoba = brojSoba;
    }

    
    
    @Override
    public String vratiImeTabele() {
return "apartman";
    }

    @Override
    public void setId(int id) {
this.apartmanID=id;
    }

    @Override
    public OpstiDomenskiObjekat vratiRedIzRS(ResultSet rs) {
     Apartman a = new Apartman();
        try {
            
            a.setApartmanID(rs.getInt("apartmanID"));
            a.setNazivApartmana(rs.getString("nazivApartmana"));
            a.setCena(rs.getInt("cena"));
           
            a.setRaspolozivost(rs.getBoolean("raspolozivost"));
            a.setBrojSoba(rs.getInt("brojSoba"));
            a.setBalkon(rs.getBoolean("balkon"));
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Menadzer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }
    

    @Override
    public void ubaciVrednostiZaInsert(PreparedStatement statement) {
try {
           
           
            statement.setString(1, nazivApartmana);
            statement.setInt(2, cena);
             statement.setBoolean(3, raspolozivost);
            statement.setInt(4, brojSoba);
            statement.setBoolean(5, balkon);
          
        } catch (SQLException ex) {
            Logger.getLogger(Menadzer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ubaciVrednostiZaUpdate(PreparedStatement statement) {
try {
           
           
            statement.setString(1, nazivApartmana);
            statement.setInt(2, cena);
             statement.setBoolean(3, raspolozivost);
            statement.setInt(4, brojSoba);
            statement.setBoolean(5, balkon);
          
        } catch (SQLException ex) {
            Logger.getLogger(Menadzer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getId() {
return apartmanID;
    }

    @Override
    public String vratiWhereZaSelect() {
if(this.getApartmanID()!= 0) {
            return "apartmanID = ?";
        }
        
      
       ArrayList<String> wheres = new ArrayList<>();
        
        if(nazivApartmana != null) {
            wheres.add("nazivApartmana like ?");
        }
         if(brojSoba != 0) {
            wheres.add("brojSoba like ?");
         
            
        }
         
         return String.join(" or ", wheres);
    
    }

    @Override
    public void ubaciVrednostiZaSelectZaWhere(PreparedStatement statement) {
try {
            if(this.getApartmanID()!= 0) {
                statement.setInt(1, getApartmanID());
            } else {
             
                int i = 1;
                
                if(nazivApartmana != null) {
                    statement.setString(i, "%" + nazivApartmana + "%");
                    i++;
                }

               if(brojSoba != 0) {
 
    statement.setString(i, "%" + brojSoba + "%");
    i++;
}


                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Gost.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String vratiNaziveKolonaSelect() {
return "apartmanID,nazivApartmana,cena,raspolozivost,brojSoba,balkon";
    }

    @Override
    public String vratiNaziveKolonaZaInsert() {
return "nazivApartmana,cena,raspolozivost,brojSoba,balkon";
    }

    @Override
    public String vratiNaziveKolonaZaUpdate() {
return "nazivApartmana,cena,raspolozivost,brojSoba,balkon";
    }

    @Override
    public String vratiNazivID() {
return "apartmanID";
    }

    @Override
    public String vratiJoinzaSelect() {
return "";
    }
    
    
}
