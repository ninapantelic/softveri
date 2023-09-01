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
public class UcitajApartman extends ApstraktnaOperacija{
    private Apartman apartman;

   
    
    @Override
    protected void preduslovi(Object param) throws Exception {

         if (param == null || !(param instanceof Apartman)) {
           throw new Exception("Neispravni podaci o apartmanima!");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param) throws Exception {
         this.apartman = null;
        
        ArrayList<Apartman> listaAp = (ArrayList<Apartman>) this.repozitorijum.vratiSve((Apartman) param);
        
        if(!listaAp.isEmpty()) {
            this.apartman = listaAp.get(0);
        }

    }

    public Apartman getApartman() {
        return apartman;
    }
    
    
}
