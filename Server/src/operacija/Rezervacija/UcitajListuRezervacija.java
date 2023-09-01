/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.Rezervacija;

import operacija.Gost.*;
import domen.Apartman;
import domen.Gost;
import domen.Rezervacija;
import java.util.ArrayList;
import operacije.ApstraktnaOperacija;

/**
 *
 * @author LENOVO
 */
public class UcitajListuRezervacija extends ApstraktnaOperacija{
     private ArrayList<Rezervacija> lista;

    @Override
    protected void preduslovi(Object param) throws Exception {
   if (param == null || !(param instanceof Rezervacija)) {
             throw new Exception("Neispravni podaci o rezervacijama!");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param) throws Exception {
this.lista = (ArrayList<Rezervacija>) this.repozitorijum.vratiSve((Rezervacija)param);
for (Rezervacija r : lista) {

            r.setGost((Gost) this.repozitorijum.vratiSve(r.getGost()).get(0));
            r.setApartman((Apartman) this.repozitorijum.vratiSve(r.getApartman()).get(0));
        }

    }

    public ArrayList<Rezervacija> getLista() {
        return lista;
    }
  
}
