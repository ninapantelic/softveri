/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.Recenzija;

import domen.Apartman;
import domen.Gost;
import domen.Recenzija;
import domen.Rezervacija;
import operacije.ApstraktnaOperacija;

/**
 *
 * @author LENOVO
 */
public class ZapamtiRrecenziju extends ApstraktnaOperacija{
     @Override
    protected void preduslovi(Object param) throws Exception {
  if (param == null || !(param instanceof Recenzija)) {
            throw new Exception("Neispravni podaci o recenziji!");
        }
        
        Recenzija recenzija = (Recenzija) param;
        
      boolean validno = (recenzija.getKomentar()!= null ) &&
                (recenzija.getOcena()>=0 && recenzija.getOcena()<=5) &&
                    
                (recenzija.getRezervacija()!= null && recenzija.getRezervacija()instanceof Rezervacija) ;


        
        if(!validno) {
             throw new Exception("Niste dobro uneli podatke!");
        }

    }

    @Override
    protected void izvrsiOperaciju(Object param) throws Exception {
        this.repozitorijum.dodaj((Recenzija)param);
    }
}
