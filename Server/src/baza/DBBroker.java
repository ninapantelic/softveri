/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;

import domen.OpstiDomenskiObjekat;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import repozitorijum.Repozitorijum;

/**
 *
 * @author LENOVO
 */
public class DBBroker implements DBRepozitorijum<OpstiDomenskiObjekat>{

    @Override
    public List<OpstiDomenskiObjekat> vratiSve(OpstiDomenskiObjekat param) throws Exception {
       //  try {
            StringBuilder sb = new StringBuilder();
            
            sb.append("select ")
                    .append(param.vratiNaziveKolonaSelect())
                    
                    .append(" from ")
                    .append(param.vratiImeTabele());
            String joins=param.vratiJoinzaSelect();
            if(joins.length()>0){
              
                        sb.append(joins);
            }
            String wheres = param.vratiWhereZaSelect();
            
            if(wheres.length() > 0) {
                sb.append(" where ")
                        .append(wheres);
            } 
           
            
            sb.append(";");
            
            String upit = sb.toString();
            
            Connection connection = Konekcija.getInstance().otvoriKonekciju();

            PreparedStatement statement = connection.prepareStatement(upit);
            System.out.println(upit);
            param.ubaciVrednostiZaSelectZaWhere(statement);
            
            ResultSet rs = statement.executeQuery();
            
            List<OpstiDomenskiObjekat> lista = new ArrayList<>();
            while (rs.next()) {
                lista.add((OpstiDomenskiObjekat) param.vratiRedIzRS(rs));
            }
            
            rs.close();
            
            statement.close();
            //System.out.println(lista);
            return lista;
              
//        } catch (SQLException e) {
//            return null;
//        }


    }
    @Override
    public void dodaj(OpstiDomenskiObjekat param) throws Exception {
       try{
           Connection connection = Konekcija.getInstance().otvoriKonekciju();
       
            
            String koloneZaInsert = param.vratiNaziveKolonaZaInsert();
            
            String[] kolone = koloneZaInsert.split(",");
            for(int i = 0; i < kolone.length; i++) {
                kolone[i] = "?";
            }
            
            StringBuilder sb = new StringBuilder();
            
            sb.append("INSERT INTO ")
                    .append(param.vratiImeTabele())
                    .append(" (").append(koloneZaInsert).append(")")
                    .append(" VALUES (")
                    .append(String.join(",", kolone))
                    .append(");");
      
            String upit = sb.toString();
                  System.out.println(upit);
            PreparedStatement statement = connection.prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);
            
            param.ubaciVrednostiZaInsert(statement);
            
            statement.executeUpdate();
            
            ResultSet rsID = statement.getGeneratedKeys();
            
            if (rsID.next()) {
                int id = rsID.getInt(1);
                param.setId(id);
            }
            
            statement.close();
            rsID.close();
        
        } catch (SQLException ex) {
            throw ex;
        }
    }
    @Override
    public void izmeni(OpstiDomenskiObjekat param) throws Exception {
        try {
            Connection connection = Konekcija.getInstance().otvoriKonekciju();
            
            String koloneZaIzmenu = param.vratiNaziveKolonaZaUpdate();
            
            String[] kolone = koloneZaIzmenu.split(",");
            for(int i = 0; i < kolone.length; i++) {
                kolone[i] = kolone[i] + " = ?";
            }
            
            StringBuilder sb = new StringBuilder();
            
            sb.append("update ")
                    .append(param.vratiImeTabele())
                    .append(" set ")
                    .append(String.join(",", kolone))
                    .append(" where ")
            .append(param.vratiNazivID())
                    .append(" = ?;");
            String upit = sb.toString();
            
            PreparedStatement statement = connection.prepareStatement(upit);
            
            param.ubaciVrednostiZaUpdate(statement);
            statement.setInt(kolone.length + 1, param.getId());
            
            statement.executeUpdate();
            
            statement.close();
        } catch (SQLException ex) {
            throw ex;
        }


    }

    @Override
    public void obrisi(OpstiDomenskiObjekat param) throws Exception {
           try {
            String upit = "delete from " + param.vratiImeTabele()+ " where id = ?;";
            Connection connection = Konekcija.getInstance().otvoriKonekciju();
            PreparedStatement statement = connection.prepareStatement(upit);
            statement.setInt(1, param.getId());
            statement.executeUpdate();
            statement.close();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }


    }

    @Override
    public List<OpstiDomenskiObjekat> vratiSve() {

return null;


    }

    }

  
    

