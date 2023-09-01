/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.Gost;


import domen.Gost;
import java.util.ArrayList;
import operacije.ApstraktnaOperacija;

/**
 *
 * @author LENOVO
 */
public class UcitajGosta extends ApstraktnaOperacija {
    private Gost gost;

   
    
    @Override
    protected void preduslovi(Object param) throws Exception {

         if (param == null || !(param instanceof Gost)) {
             throw new Exception("Неисправни подаци о госту!");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param) throws Exception {
         this.gost = null;
        
        ArrayList<Gost> listaG = (ArrayList<Gost>) this.repozitorijum.vratiSve((Gost) param);
        
        if(!listaG.isEmpty()) {
            this.gost = listaG.get(0);
        }

    }

    public Gost getGost() {
        return gost;
    }
    
}
