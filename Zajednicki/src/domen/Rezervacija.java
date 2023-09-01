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
import java.util.Date;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author LENOVO
 */
public class Rezervacija implements OpstiDomenskiObjekat  {
        private int rezervacijaID;
        private Date datumOd;
        private Date datumDo;
        private Status status;
        private int ukupnaCena;
        private Menadzer menadzer;
        private Apartman apartman;
        private Gost gost;
        private ArrayList<Recenzija>listaRecenzija;


    public Rezervacija() {
    }

    public Rezervacija(int rezervacijaID, Date datumOd, Date datumDo, Status status, int ukupnaCena, Menadzer menadzer, Apartman apartman, Gost gost) {
        this.rezervacijaID = rezervacijaID;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
        this.status = status;
        this.ukupnaCena = ukupnaCena;
        this.menadzer = menadzer;
        this.apartman = apartman;
        this.gost = gost;
       
    }

 

    public Rezervacija(Date datumOd, Date datumDo, Status status, int ukupnaCena, Menadzer menadzer, Apartman apartman, Gost gost) {
        this.datumOd = datumOd;
        this.datumDo = datumDo;
        this.status = status;
        this.ukupnaCena = ukupnaCena;
        this.menadzer = menadzer;
        this.apartman = apartman;
        this.gost = gost;
      
    }

    public ArrayList<Recenzija> getListaRecenzija() {
        return listaRecenzija;
    }

    public void setListaRecenzija(ArrayList<Recenzija> listaRecenzija) {
        this.listaRecenzija = listaRecenzija;
    }

   public void dodajRecenziju(Recenzija r){
   if(listaRecenzija == null) {
            listaRecenzija = new ArrayList<>();
        }
        listaRecenzija.add(r);
            
}

    public int getUkupnaCena() {
        return ukupnaCena;
    }

    public void setUkupnaCena(int ukupnaCena) {
        this.ukupnaCena = ukupnaCena;
    }

   

    public Gost getGost() {
        return gost;
    }

    public void setGost(Gost gost) {
        this.gost = gost;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.rezervacijaID;
        hash = 37 * hash + Objects.hashCode(this.datumOd);
        hash = 37 * hash + Objects.hashCode(this.datumDo);
        hash = 37 * hash + Objects.hashCode(this.status);
        hash = 37 * hash + this.ukupnaCena;
        hash = 37 * hash + Objects.hashCode(this.menadzer);
        hash = 37 * hash + Objects.hashCode(this.apartman);
        hash = 37 * hash + Objects.hashCode(this.gost);
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
        final Rezervacija other = (Rezervacija) obj;
        if (this.rezervacijaID != other.rezervacijaID) {
            return false;
        }
        if (this.ukupnaCena != other.ukupnaCena) {
            return false;
        }
        if (!Objects.equals(this.datumOd, other.datumOd)) {
            return false;
        }
        if (!Objects.equals(this.datumDo, other.datumDo)) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        if (!Objects.equals(this.menadzer, other.menadzer)) {
            return false;
        }
        if (!Objects.equals(this.apartman, other.apartman)) {
            return false;
        }
        return Objects.equals(this.gost, other.gost);
    }

   

    

    public Apartman getApartman() {
        return apartman;
    }

    public void setApartman(Apartman apartman) {
        this.apartman = apartman;
    }

    public int getRezervacijaID() {
        return rezervacijaID;
    }

    public void setRezervacijaID(int rezervacijaID) {
        this.rezervacijaID = rezervacijaID;
    }

    public Date getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
    }

    public Date getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(Date datumDo) {
        this.datumDo = datumDo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Menadzer getMenadzer() {
        return menadzer;
    }

    public void setMenadzer(Menadzer menadzer) {
        this.menadzer = menadzer;
    }

    
    @Override
    public String vratiNazivID() {
        return "rezervacijaID";
    }

    @Override
    public String vratiImeTabele() {
        return "rezervacija";
    }

    @Override
    public void setId(int id) {
        this.rezervacijaID = id;
    }

    @Override
    public OpstiDomenskiObjekat vratiRedIzRS(ResultSet rs) {
        Rezervacija r = new Rezervacija();
        try {
            Menadzer m = new Menadzer();
            m.setMenadzerID(rs.getInt("menadzerID"));

            Gost g = new Gost();
            g.setGostID(rs.getInt("rezervacija.gostID"));

            Apartman a = new Apartman();
            a.setApartmanID(rs.getInt("rezervacija.apartmanID"));

            r.setRezervacijaID(rs.getInt("rezervacijaID"));
            r.setDatumOd(new Date(rs.getDate("datumOd").getTime()));
            r.setDatumDo(new Date(rs.getDate("datumDo").getTime()));

            r.setStatus(Status.valueOf(rs.getString("status")));
            r.setUkupnaCena(rs.getInt("ukupnaCena"));
            r.setApartman(a);
            r.setMenadzer(m);
            r.setGost(g);
        } catch (SQLException ex) {
            Logger.getLogger(Menadzer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;

    }

    @Override
    public void ubaciVrednostiZaInsert(PreparedStatement statement) {
        try {

            statement.setDate(1, new java.sql.Date(datumOd.getTime()));
            statement.setDate(2, new java.sql.Date(datumDo.getTime()));
            statement.setString(3, status.toString());

            statement.setInt(4, ukupnaCena);
            statement.setInt(5, menadzer.getMenadzerID());
            statement.setInt(6, apartman.getApartmanID());
            statement.setInt(7, gost.getGostID());

        } catch (SQLException ex) {
            Logger.getLogger(Menadzer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ubaciVrednostiZaUpdate(PreparedStatement statement) {
        try {
            // mozda da ne stavim sve vec samo sta moze da update
            //a to bi bilo status

            statement.setDate(1, new java.sql.Date(datumOd.getTime()));
            statement.setDate(2, new java.sql.Date(datumDo.getTime()));
            statement.setInt(3, ukupnaCena);
           if(!status.equals(status.POTVRDJENA)){
            statement.setString(4, status.toString());
           }
           

        } catch (SQLException ex) {
            Logger.getLogger(Menadzer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getId() {
        return rezervacijaID;
    }

    @Override
    public String vratiWhereZaSelect() {
        if (this.getRezervacijaID() != 0) {
            return "rezervacijaID = ?";
        }

        ArrayList<String> wheres = new ArrayList<>();

        if (gost != null) {
            wheres.add("gost.ime like ?");
            wheres.add("gost.prezime like ?");

        }

        return String.join(" or ", wheres);
    }

    @Override
    public String vratiJoinzaSelect() {
        return " JOIN gost ON (gost.gostID=rezervacija.gostID) JOIN apartman ON (apartman.apartmanID=rezervacija.apartmanID) ";
    }

    @Override
    public void ubaciVrednostiZaSelectZaWhere(PreparedStatement statement) {
        try {
            if (this.getRezervacijaID() != 0) {
                statement.setInt(1, getRezervacijaID());
            } else {

                if (gost != null) {
                    statement.setString(1, "%" + gost.getIme() + "%");

                    statement.setString(2, "%" + gost.getPrezime() + "%");

                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(Gost.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String vratiNaziveKolonaSelect() {
        return "rezervacijaID,datumOd,datumDo,status,ukupnaCena,menadzerID,rezervacija.apartmanID,rezervacija.gostID";
    }

    @Override
    public String vratiNaziveKolonaZaInsert() {
        return "datumOd,datumDo,status,ukupnaCena,menadzerID,apartmanID,gostID";
    }

    @Override
    public String vratiNaziveKolonaZaUpdate() {
          if(!status.equals(status.POTVRDJENA)){
              return "datumOd,datumDo,ukupnaCena,status";
           }
        return "datumOd,datumDo,ukupnaCena";
    }
        
   
}
