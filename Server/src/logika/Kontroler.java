/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logika;

import baza.DBBroker;
import domen.Apartman;
import domen.Gost;
import domen.Menadzer;
import domen.OpstiDomenskiObjekat;
import domen.Recenzija;
import domen.Rezervacija;
import java.util.ArrayList;
import java.util.List;
import operacija.Apartman.ZapamtiApartman;
import operacija.Gost.UcitajListuGostiju;
import operacija.Gost.ZapamtiGosta;
import repozitorijum.Repozitorijum;
import operacija.Gost.*;
import operacija.Apartman.*;

import operacija.Recenzija.*;
import operacija.Rezervacija.*;
/**
 *
 * @author LENOVO
 */
public class Kontroler {
     private static Kontroler instance;
private final Repozitorijum repozitorijum;

   
    public Kontroler() {
        this.repozitorijum = new DBBroker();
    }

    public static Kontroler getInstance() {
      if(instance==null){
          instance= new Kontroler();
      }
        return instance;
    }

    public Object loginMenadzer(String korisnickoIme, String lozinka) throws Exception {
   List<Menadzer> listaM = repozitorijum.vratiSve(new Menadzer());
        for (Menadzer m : listaM) {
            if (m.getKorisnickoIme().equals(korisnickoIme) && m.getLozinka().equals(lozinka)) {
                return m;
            }
        }
        //return null;
        throw new Exception("Ne postoji menadzer sa ovim korisnickim imenom i lozinkom!");

}

    public void zapamtiGosta(Gost zapamceniGost) throws Exception {
        (new ZapamtiGosta()).izvrsi(zapamceniGost);
       
    }

    public void zapamtiApartman(Apartman zapamceniApartman) throws Exception {
         (new ZapamtiApartman()).izvrsi(zapamceniApartman);
    }

    public ArrayList<Gost> ucitajListuGostiju() throws Exception {
         {
       UcitajListuGostiju  ucitaj = new UcitajListuGostiju();
        ucitaj.izvrsi(new Gost());
        return ucitaj.getListaGostiju();
    }
    }

    public ArrayList<Gost> pretraziGoste(Gost param) throws Exception {
        PretraziGoste pg = new PretraziGoste();
        pg.izvrsi(param);
        return pg.getLista();
    }

    public void izmeniGosta(Gost g) throws Exception {
       (new IzmeniGosta()).izvrsi(g);
    }

    public Object ucitajGosta(Gost gostZaUcitavanje) throws Exception {
        UcitajGosta ucitaj = new UcitajGosta();
        ucitaj.izvrsi(gostZaUcitavanje);
        return ucitaj.getGost();
    }

    public void izmeniApartman(Apartman zapamceniApartman) throws Exception {
        (new IzmeniApartman()).izvrsi(zapamceniApartman);
    }
    

    public ArrayList<Apartman> pretraziApartmane(Apartman param) throws Exception {
        PretraziApartmane pa = new PretraziApartmane();
        pa.izvrsi(param);
        return pa.getLista();
    }

    public Object ucitajApartman(Apartman apartmanZaUcitavanje) throws Exception {
        UcitajApartman ua= new UcitajApartman();
        ua.izvrsi(apartmanZaUcitavanje);
        return ua.getApartman();
    }

    public ArrayList<Apartman> ucitajListuApartmana() throws Exception {
           UcitajListuApartmana  ucitajListuAp = new UcitajListuApartmana();
        ucitajListuAp.izvrsi(new Apartman());
        return ucitajListuAp.getListaApartmana();
    }

    public Object ucitajListuRezervacija() throws Exception {
        UcitajListuRezervacija ucitajListuRez = new UcitajListuRezervacija();
        ucitajListuRez.izvrsi(new Rezervacija());
        return ucitajListuRez.getLista();
    }

    public void zapamtiRezervaciju(Rezervacija rezervacija) throws Exception {
(new ZapamtiRezervaciju()).izvrsi(rezervacija);
    }

    public Object loginGost(String korisnickoIme, String lozinka) throws Exception {
ArrayList<Gost> listaGostiju = (ArrayList<Gost>) repozitorijum.vratiSve(new Gost());
        for (Gost g : listaGostiju) {
            if (g.getKorisnickoIme().equals(korisnickoIme) && g.getLozinka().equals(lozinka)) {
                return g;
            }
        }
       
        throw new Exception("U sistemu ne postoji gost sa ovim korisnickim imenom i lozinkom!");
    }
    
    
    
    
    public void zapamtiRecenziju(Recenzija recenzija) throws Exception {
(new ZapamtiRrecenziju()).izvrsi(recenzija);
    }

  

    public Object pretraziRezervacije(Rezervacija rezervacijaPretraga) throws Exception {
PretraziRezervacije pretragaRez = new PretraziRezervacije();
pretragaRez.izvrsi(rezervacijaPretraga);
return pretragaRez.getLista();
    }

    public Object ucitajRezervaciju(Rezervacija rezervacijaZaUcitavanje) throws Exception {
UcitajRezervaciju urez = new UcitajRezervaciju();
urez.izvrsi(rezervacijaZaUcitavanje);
return urez.getRezervacija();
    }

    public void izmeniRezervaciju(Rezervacija rezervacija) throws Exception {
        (new IzmeniRezervaciju()).izvrsi(rezervacija);

    }

    public Object ucitajListuRecenzija() throws Exception {
UcitajListuRecenzija ucitajListuRec= new UcitajListuRecenzija();
        ucitajListuRec.izvrsi(new Recenzija());
        return ucitajListuRec.getLista();
    }

    public Object pretraziRecenzije(Recenzija paramRec) throws Exception {
PretraziRecenzije pretragaRec = new PretraziRecenzije();
pretragaRec.izvrsi(paramRec);
return pretragaRec.getLista();
    }
    
    
    
}