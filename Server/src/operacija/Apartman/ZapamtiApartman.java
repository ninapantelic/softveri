/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.Apartman;

import domen.Apartman;
import operacije.ApstraktnaOperacija;

/**
 *
 * @author LENOVO
 */
public class ZapamtiApartman extends ApstraktnaOperacija{

    @Override
    protected void preduslovi(Object param) throws Exception {
  if (param == null || !(param instanceof Apartman)) {
     throw new Exception("Neispravni podaci o apartmanu!");
        }
        
        Apartman a = (Apartman) param;
        
        boolean validno = a.getCena()>=0 && 
                (a.getNazivApartmana()!=null && a.getNazivApartmana().length()<=10);
        
        if(!validno) {
            throw new Exception("Niste dobro uneli podatke!");
        }

    }

    @Override
    protected void izvrsiOperaciju(Object param) throws Exception {
        this.repozitorijum.dodaj((Apartman)param);
    }
    
}
