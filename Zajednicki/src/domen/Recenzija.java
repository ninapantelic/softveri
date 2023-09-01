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
public class Recenzija implements OpstiDomenskiObjekat {

    private int recenzijaID;

    private Rezervacija rezervacija;
    private int ocena;
    private String komentar;

    public Recenzija() {
    }

    public Recenzija(int recenzijaID, Rezervacija rezervacija, int ocena, String komentar) {
        this.recenzijaID = recenzijaID;
        this.rezervacija = rezervacija;
        this.ocena = ocena;
        this.komentar = komentar;
    }

    public int getRecenzijaID() {
        return recenzijaID;
    }

    public void setRecenzijaID(int recenzijaID) {
        this.recenzijaID = recenzijaID;
    }

    public Rezervacija getRezervacija() {
        return rezervacija;
    }

    public void setRezervacija(Rezervacija rezervacija) {
        this.rezervacija = rezervacija;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }

    @Override
    public String vratiNazivID() {
        return "recenzijaID";
    }

    @Override
    public String vratiImeTabele() {
        return "recenzija";
    }

    @Override
    public void setId(int id) {
        this.recenzijaID = id;
    }
 @Override
    public String vratiNaziveKolonaSelect() {
        return "recenzija.recenzijaID,"
                + "ocena,komentar,rezervacija.gostID,rezervacija.apartmanID,recenzija.rezervacijaID";
    }

    @Override
    public OpstiDomenskiObjekat vratiRedIzRS(ResultSet rs) {
        Recenzija r = new Recenzija();
        try {
            r.setRecenzijaID(rs.getInt("recenzija.recenzijaID"));
 r.setOcena(rs.getInt("recenzija.ocena"));
            r.setKomentar(rs.getString("recenzija.komentar"));
            
            Gost g = new Gost();
            g.setGostID(rs.getInt("rezervacija.gostID"));
          
            Apartman a = new Apartman();
            a.setApartmanID(rs.getInt("rezervacija.apartmanID"));
            
  Rezervacija rez = new Rezervacija();
            rez.setRezervacijaID(rs.getInt("recenzija.rezervacijaID"));
          rez.setApartman(a);
          rez.setGost(g);
            ArrayList<Recenzija> lista = new ArrayList<>();
            lista.add(r);
            rez.setListaRecenzija(lista);
            r.setRezervacija(rez);
        } catch (SQLException ex) {
            Logger.getLogger(Menadzer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    @Override
    public void ubaciVrednostiZaInsert(PreparedStatement statement) {

        try {

            statement.setInt(1, rezervacija.getRezervacijaID());
            statement.setInt(2, ocena);
            statement.setString(3, komentar);
        } catch (SQLException ex) {
            Logger.getLogger(Recenzija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ubaciVrednostiZaUpdate(PreparedStatement statement) {
        try {
            statement.setInt(1, ocena);
            statement.setString(2, komentar);
        } catch (SQLException ex) {
            Logger.getLogger(Recenzija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getId() {
        return recenzijaID;
    }

    @Override
    public String vratiWhereZaSelect() {
        if (this.getRecenzijaID() != 0) {
            return "recenzija.recenzijaID = ?";
        }

        ArrayList<String> wheres = new ArrayList<>();

        if (komentar != null) {
            wheres.add("recenzija.komentar like ?");

        }

        return String.join(" or ", wheres);
    }

    @Override
    public void ubaciVrednostiZaSelectZaWhere(PreparedStatement statement) {

        try {
            if (this.recenzijaID!= 0) {
                statement.setInt(1, getRecenzijaID());
            } else {

                if (komentar != null) {
                    statement.setString(1, "%" + komentar + "%");

                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(Gost.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

   
    @Override
    public String vratiNaziveKolonaZaInsert() {
        return "recenzija.rezervacijaID,ocena,komentar";
    }

    @Override
    public String vratiNaziveKolonaZaUpdate() {
        return "ocena,komentar";
    }

    @Override
    public String vratiJoinzaSelect() {
        return " JOIN rezervacija ON (rezervacija.rezervacijaID=recenzija.rezervacijaID) JOIN gost ON (rezervacija.gostID=gost.gostID) "
                + "JOIN apartman ON (rezervacija.apartmanID=apartman.apartmanID) ";
    }

}
