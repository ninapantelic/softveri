/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.Rezervacija;

import domen.Apartman;
import domen.Menadzer;
import domen.Rezervacija;
import operacije.ApstraktnaOperacija;

/**
 *
 * @author LENOVO
 */
public class IzmeniRezervaciju extends ApstraktnaOperacija{
    @Override
    protected void preduslovi(Object param) throws Exception {
  if (param == null || !(param instanceof Rezervacija)) {
            throw new Exception("Neispravni podaci o rezervaciji!");
        }
        
        Rezervacija rezervacija = (Rezervacija) param;
        
        boolean validno = (rezervacija.getDatumOd()!= null) &&
                (rezervacija.getDatumDo()!= null) &&
                (rezervacija.getStatus()!= null) &&
                (rezervacija.getMenadzer()!= null && rezervacija.getMenadzer() instanceof Menadzer) &&
                (rezervacija.getApartman()!= null && rezervacija.getApartman() instanceof Apartman);

        
        if(!validno) {
            throw new Exception("Niste dobro uneli podatke!");
        }

    }

    @Override
    protected void izvrsiOperaciju(Object param) throws Exception {
        this.repozitorijum.izmeni((Rezervacija)param);
    }
}
