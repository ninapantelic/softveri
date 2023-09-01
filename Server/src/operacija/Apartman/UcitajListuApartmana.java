/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.Apartman;

import domen.Apartman;
import java.util.ArrayList;
import operacije.ApstraktnaOperacija;

/**
 *
 * @author LENOVO
 */
public class UcitajListuApartmana extends ApstraktnaOperacija{
    
     private ArrayList<Apartman> listaApartmana;



    @Override
    protected void preduslovi(Object param) throws Exception {
   if (param == null || !(param instanceof Apartman)) {
        throw new Exception("Neispravni podaci o apartmanima!");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param) throws Exception {
this.listaApartmana = (ArrayList<Apartman>) this.repozitorijum.vratiSve(param);
    }
        public ArrayList<Apartman> getListaApartmana() {
        return listaApartmana;
    }
    

}
