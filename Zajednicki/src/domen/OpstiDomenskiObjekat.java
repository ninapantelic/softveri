/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.*;
/**
 *
 * @author LENOVO
 */
public interface OpstiDomenskiObjekat extends Serializable {

    public String vratiNazivID();

    String vratiImeTabele();


    void setId(int id);
    
    OpstiDomenskiObjekat vratiRedIzRS(ResultSet rs);

    public void ubaciVrednostiZaInsert(PreparedStatement statement);

    public void ubaciVrednostiZaUpdate(PreparedStatement statement);

    public int getId();

    public String vratiWhereZaSelect();

    public void ubaciVrednostiZaSelectZaWhere(PreparedStatement statement);

    public String vratiNaziveKolonaSelect();

    public String vratiNaziveKolonaZaInsert();

    public String vratiNaziveKolonaZaUpdate();

    public String vratiJoinzaSelect();



   
}
