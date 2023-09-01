/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.Gost;

import domen.Apartman;
import domen.Gost;
import java.util.ArrayList;
import operacije.ApstraktnaOperacija;

/**
 *
 * @author LENOVO
 */
public class UcitajListuGostiju extends ApstraktnaOperacija{
     private ArrayList<Gost> listaGostiju;

    @Override
    protected void preduslovi(Object param) throws Exception {
   if (param == null || !(param instanceof Gost)) {
             throw new Exception("Neispravni podaci o gostima!");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param) throws Exception {
this.listaGostiju = (ArrayList<Gost>) this.repozitorijum.vratiSve((Gost)param);
    }
  public ArrayList<Gost> getListaGostiju() {
        return listaGostiju;
    }
}
