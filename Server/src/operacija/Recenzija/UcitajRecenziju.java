/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.Recenzija;

import domen.Apartman;
import domen.Gost;
import domen.Recenzija;
import domen.Rezervacija;
import java.util.ArrayList;
import operacije.ApstraktnaOperacija;

/**
 *
 * @author LENOVO
 */
public class UcitajRecenziju extends ApstraktnaOperacija{
    private Recenzija recenzija;

    @Override
    protected void preduslovi(Object param) throws Exception {

         if (param == null || !(param instanceof Recenzija)) {
           throw new Exception("Neispravni podaci o recenziji!");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param) throws Exception {
         this.recenzija = null;
        
        ArrayList<Recenzija> listaR = (ArrayList<Recenzija>) this.repozitorijum.vratiSve((Recenzija) param);
        
        if(!listaR.isEmpty()) {
            this.recenzija = listaR.get(0);
        }
 for (Recenzija r : listaR) {
            Rezervacija rez = (Rezervacija) this.repozitorijum.vratiSve(r.getRezervacija()).get(0);

            Gost g = (Gost) this.repozitorijum.vratiSve(r.getRezervacija().getGost()).get(0);
            rez.setGost(g);
             Apartman a = (Apartman) this.repozitorijum.vratiSve(r.getRezervacija().getApartman()).get(0);
             rez.setApartman(a);
            r.setRezervacija(rez);
        }
    }
}
