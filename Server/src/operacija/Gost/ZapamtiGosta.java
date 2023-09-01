/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.Gost;

import domen.Apartman;
import domen.Gost;
import operacije.ApstraktnaOperacija;

/**
 *
 * @author LENOVO
 */
public class ZapamtiGosta extends ApstraktnaOperacija{
    @Override
    protected void preduslovi(Object param) throws Exception {
  if (param == null || !(param instanceof Gost)) {
             throw new Exception("Neispravni podaci o gostu!");
        }
        
        Gost g = (Gost) param;
        
        boolean validno = (g.getIme()!= null && g.getIme().length() >= 2) &&
                (g.getPrezime()!= null && g.getPrezime().length() >= 2) &&
                (g.getKorisnickoIme() != null && g.getKorisnickoIme().length() >= 4  && g.getKorisnickoIme().length()<=20) &&
                (g.getLozinka()!= null && g.getLozinka().length() >= 4&& g.getLozinka().length()<=20) &&
                (g.getBrojTelefona()!= null && g.getBrojTelefona().length() >= 2 && g.getBrojTelefona().length()<=15);

        
        if(!validno) {
            throw new Exception("Niste dobro uneli podatke!");
        }

    }

    @Override
    protected void izvrsiOperaciju(Object param) throws Exception {
        this.repozitorijum.dodaj((Gost)param);
    }
}
