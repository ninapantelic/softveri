/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroler;


import domen.Apartman;
import domen.Gost;
import domen.Menadzer;
import domen.Recenzija;
import domen.Rezervacija;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import operacije.Operacije;
import transfer.KlijentskiZahtev;
import transfer.Posiljalac;
import transfer.Primalac;
import transfer.ServerskiOdgovor;

/**
 *
 * @author LENOVO
 */
public class Komunikacija {
    private static Komunikacija instance;
    private Socket soket;
    private Posiljalac posiljalac;
    private Primalac primalac;

    public static Komunikacija getInstance() throws IOException {
       if(instance == null){
           instance = new Komunikacija();
       }
        return instance;
    }

    public Komunikacija() throws IOException {
        
            soket = new Socket("localhost", 9000);
            posiljalac = new Posiljalac(soket);
            primalac = new Primalac(soket);
      
  
    }

   

    public Gost loginGost(String korisnickoIme, String lozinka) throws Exception {
     Gost gost=new Gost();
        gost.setKorisnickoIme(korisnickoIme);
        gost.setLozinka(lozinka);
        KlijentskiZahtev kz=new KlijentskiZahtev( gost,Operacije.LOGIN_GOST);
        posiljalac.posalji(kz);
        ServerskiOdgovor so=(ServerskiOdgovor)primalac.primi();
        if(so.getException()==null){
            return (Gost)so.getOdgovor();
        }else{
            throw so.getException();
        }
    }

    public Menadzer loginMenadzer(String korisnickoIme, String lozinka) throws Exception {
            Menadzer menadzer=new Menadzer();
        menadzer.setKorisnickoIme(korisnickoIme);
        menadzer.setLozinka(lozinka);
        KlijentskiZahtev kz=new KlijentskiZahtev( menadzer,Operacije.LOGIN_MENADZER);
        posiljalac.posalji(kz);
        ServerskiOdgovor so=(ServerskiOdgovor)primalac.primi();
        if(so.getException()==null){
            return (Menadzer)so.getOdgovor();
        }else{
            throw so.getException();
        }
    }

    public void zapamtiGosta(Gost zapamceniGost) throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev(zapamceniGost, Operacije.ZAPAMTI_GOSTA);
        posiljalac.posalji(kz);
          ServerskiOdgovor so=(ServerskiOdgovor)primalac.primi();
           if(so.getException()==null){
         Gost novGost = (Gost) so.getOdgovor();
         zapamceniGost.setGostID(novGost.getGostID());
        }else{
            throw so.getException();
        }
           
     
           
    }

    public void zapamtiApartman(Apartman zapamceniApartman) throws Exception {
  KlijentskiZahtev kz = new KlijentskiZahtev(zapamceniApartman, Operacije.ZAPAMTI_APARTMAN);
        posiljalac.posalji(kz);
          ServerskiOdgovor so=(ServerskiOdgovor)primalac.primi();
           if(so.getException()==null){
         Apartman novApartman = (Apartman) so.getOdgovor();
         zapamceniApartman.setApartmanID(novApartman.getApartmanID());
        }else{
            throw so.getException();
        }
    }

     public ArrayList<Gost> ucitajListuGostiju() throws Exception
    {
        KlijentskiZahtev kz = new KlijentskiZahtev(null,Operacije.UCITAJ_LISTU_GOSTIJU);
        posiljalac.posalji(kz);
       ServerskiOdgovor so=(ServerskiOdgovor)primalac.primi();
        if(so.getException()==null){
            return (ArrayList<Gost>) so.getOdgovor();
        }else{
            throw so.getException();
        }
    }

    public ArrayList<Gost> pretraziGoste(Gost param) throws Exception {
KlijentskiZahtev kz = new KlijentskiZahtev(param,Operacije.PRETRAZI_GOSTE);
        posiljalac.posalji(kz);
       ServerskiOdgovor so=(ServerskiOdgovor)primalac.primi();
        if(so.getException()==null){
            return (ArrayList<Gost>) so.getOdgovor();
        }else{
            throw so.getException();
        }
    }

    public Gost ucitajGosta(Gost gost) throws Exception {
KlijentskiZahtev kz = new KlijentskiZahtev(gost,Operacije.UCITAJ_GOSTA);
        posiljalac.posalji(kz);
         ServerskiOdgovor so=(ServerskiOdgovor)primalac.primi();
        
        if(so.getException()!=null){
            throw so.getException();
        }

        return (Gost) so.getOdgovor();
    }

    public ArrayList<Apartman> pretraziApartmane(Apartman param) throws Exception {
KlijentskiZahtev kz = new KlijentskiZahtev(param,Operacije.PRETRAZI_APARTMANE);
        posiljalac.posalji(kz);
       ServerskiOdgovor so=(ServerskiOdgovor)primalac.primi();
        if(so.getException()==null){
            return (ArrayList<Apartman>) so.getOdgovor();
        }else{
            throw so.getException();
        }
    }

    public Apartman ucitajApartman(Apartman apartman) throws Exception {
KlijentskiZahtev kz = new KlijentskiZahtev(apartman,Operacije.UCITAJ_APARTMAN);
        posiljalac.posalji(kz);
         ServerskiOdgovor so=(ServerskiOdgovor)primalac.primi();
        
        if(so.getException()!=null){
            throw so.getException();
        }

        return (Apartman) so.getOdgovor();
    }

    public ArrayList<Apartman> ucitajListuApartmana() throws Exception {
 KlijentskiZahtev kz = new KlijentskiZahtev(null,Operacije.UCITAJ_LISTU_APARTMANA);
        posiljalac.posalji(kz);
       ServerskiOdgovor so=(ServerskiOdgovor)primalac.primi();
        if(so.getException()==null){
            return (ArrayList<Apartman>) so.getOdgovor();
        }else{
            throw so.getException();
        }
    }

    public ArrayList<Rezervacija> ucitajListuRezervacija() throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev(null,Operacije.UCITAJ_LISTU_REZERVACIJA);
        posiljalac.posalji(kz);
       ServerskiOdgovor so=(ServerskiOdgovor)primalac.primi();
        if(so.getException()==null){
            return (ArrayList<Rezervacija>) so.getOdgovor();
        }else{
            throw so.getException();
        }
    }

    public void zapamtiRezervaciju(Rezervacija rezervacija) throws Exception {
KlijentskiZahtev kz = new KlijentskiZahtev(rezervacija, Operacije.ZAPAMTI_REZERVACIJU);
        posiljalac.posalji(kz);
          ServerskiOdgovor so=(ServerskiOdgovor)primalac.primi();
           if(so.getException()==null){
         Rezervacija novaRez = (Rezervacija) so.getOdgovor();
         rezervacija.setRezervacijaID(novaRez.getRezervacijaID());
        }else{
            throw so.getException();
        }
    }
    
     public void zapamtiRecenziju(Recenzija recenzija) throws Exception {
KlijentskiZahtev kz = new KlijentskiZahtev(recenzija, Operacije.ZAPAMTI_RECENZIJU);
        posiljalac.posalji(kz);
          ServerskiOdgovor so=(ServerskiOdgovor)primalac.primi();
           if(so.getException()==null){
         Recenzija novaRecenzija = (Recenzija) so.getOdgovor();
         recenzija.setRecenzijaID(novaRecenzija.getRecenzijaID());
        }else{
            throw so.getException();
        }
    }

   

    public ArrayList<Rezervacija> pretraziRezervacije(Rezervacija param) throws Exception {
KlijentskiZahtev kz = new KlijentskiZahtev(param,Operacije.PRETRAZI_REZERVACIJE);
        posiljalac.posalji(kz);
       ServerskiOdgovor so=(ServerskiOdgovor)primalac.primi();
        if(so.getException()==null){
            return (ArrayList<Rezervacija>) so.getOdgovor();
        }else{
            throw so.getException();
        }
    }

    public Rezervacija ucitajRezervaciju(Rezervacija rezervacija) throws Exception {
KlijentskiZahtev kz = new KlijentskiZahtev(rezervacija,Operacije.UCITAJ_REZERVACIJU);
        posiljalac.posalji(kz);
         ServerskiOdgovor so=(ServerskiOdgovor)primalac.primi();
        
        if(so.getException()!=null){
            throw so.getException();
        }

        return (Rezervacija) so.getOdgovor();
    }

    public ArrayList<Recenzija> ucitajListuRecenzija() throws Exception {
KlijentskiZahtev kz = new KlijentskiZahtev(null,Operacije.UCITAJ_LISTU_RECENZIJA);
        posiljalac.posalji(kz);
       ServerskiOdgovor so=(ServerskiOdgovor)primalac.primi();
        if(so.getException()==null){
            return (ArrayList<Recenzija>) so.getOdgovor();
        }else{
            throw so.getException();
        }
    }

    public ArrayList<Recenzija> retraziRecenzije(Recenzija param) throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev(param,Operacije.PRETRAZI_RECENZIJE);
        posiljalac.posalji(kz);
       ServerskiOdgovor so=(ServerskiOdgovor)primalac.primi();
        if(so.getException()==null){
            return (ArrayList<Recenzija>) so.getOdgovor();
        }else{
            throw so.getException();
        }
    }

   


    
}
