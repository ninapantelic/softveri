/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import domen.Apartman;
import domen.Gost;
import domen.Menadzer;
import domen.Recenzija;
import domen.Rezervacija;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import logika.Kontroler;
import operacije.Operacije;
import transfer.KlijentskiZahtev;
import transfer.Posiljalac;
import transfer.Primalac;
import transfer.ServerskiOdgovor;

/**
 *
 * @author LENOVO
 */
public class ObradaKlijentskogZahteva extends Thread {

    Socket s;
    Posiljalac posiljalac;
    Primalac primalac;

    public ObradaKlijentskogZahteva(Socket s) {
        this.s = s;
        this.posiljalac = new Posiljalac(s);
        this.primalac = new Primalac(s);
    }

    @Override
    public void run() {
        while (true) {

            try {
                KlijentskiZahtev kz = (KlijentskiZahtev) primalac.primi();
                ServerskiOdgovor so = new ServerskiOdgovor();
                try {
                    switch (kz.getOperacija()) {
                        case Operacije.LOGIN_MENADZER:
                            Menadzer m = (Menadzer) kz.getParametar();
                            so.setOdgovor(Kontroler.getInstance().loginMenadzer(m.getKorisnickoIme(), m.getLozinka()));
                            break;

                        case Operacije.ZAPAMTI_GOSTA:
                            Gost zapamceniGost = (Gost) kz.getParametar();
                            if (zapamceniGost.getGostID() != 0) {
                                Kontroler.getInstance().izmeniGosta(zapamceniGost);
                            } else {
                                Kontroler.getInstance().zapamtiGosta(zapamceniGost);
                            }
                            so.setOdgovor(zapamceniGost);
                            break;
                        case Operacije.ZAPAMTI_APARTMAN:
                            Apartman zapamceniApartman = (Apartman) kz.getParametar();
                            if (zapamceniApartman.getApartmanID() != 0) {
                                Kontroler.getInstance().izmeniApartman(zapamceniApartman);
                            } else {
                                Kontroler.getInstance().zapamtiApartman(zapamceniApartman);
                            }
                            so.setOdgovor(zapamceniApartman);
                            break;

                        case Operacije.UCITAJ_LISTU_GOSTIJU:
                            so.setOdgovor(Kontroler.getInstance().ucitajListuGostiju());
                            break;
                        case Operacije.PRETRAZI_GOSTE:
                            Gost param = (Gost) kz.getParametar();
                            so.setOdgovor(Kontroler.getInstance().pretraziGoste(param));
                            break;
                        case Operacije.UCITAJ_GOSTA:
                            Gost gostZaUcitavanje = (Gost) kz.getParametar();
                            so.setOdgovor(Kontroler.getInstance().ucitajGosta(gostZaUcitavanje));
                            break;

                        case Operacije.PRETRAZI_APARTMANE:
                            Apartman paramA = (Apartman) kz.getParametar();
                            so.setOdgovor(Kontroler.getInstance().pretraziApartmane(paramA));
                            break;
                        case Operacije.UCITAJ_APARTMAN:
                            Apartman apartmanZaUcitavanje = (Apartman) kz.getParametar();
                            so.setOdgovor(Kontroler.getInstance().ucitajApartman(apartmanZaUcitavanje));
                            break;
                        case Operacije.UCITAJ_LISTU_APARTMANA:
                            so.setOdgovor(Kontroler.getInstance().ucitajListuApartmana());
                            break;

                        case Operacije.UCITAJ_LISTU_REZERVACIJA:
                            so.setOdgovor(Kontroler.getInstance().ucitajListuRezervacija());
                            break;
                        case Operacije.ZAPAMTI_REZERVACIJU:

                            Rezervacija rezervacija = (Rezervacija) kz.getParametar();
                            if (rezervacija.getRezervacijaID() != 0) {
                                Kontroler.getInstance().izmeniRezervaciju(rezervacija);
                            } else {
                                Kontroler.getInstance().zapamtiRezervaciju(rezervacija);
                            }
                            so.setOdgovor(rezervacija);

                            break;
                        case Operacije.LOGIN_GOST:
                            Gost gostLogin = (Gost) kz.getParametar();
                            so.setOdgovor(Kontroler.getInstance().loginGost(gostLogin.getKorisnickoIme(), gostLogin.getLozinka()));
                            break;
                        case Operacije.ZAPAMTI_RECENZIJU:
                            Recenzija recenzija = (Recenzija) kz.getParametar();

                            Kontroler.getInstance().zapamtiRecenziju(recenzija);

                            so.setOdgovor(recenzija);
                            break;

                        case Operacije.PRETRAZI_REZERVACIJE:
                            Rezervacija rezervacijaPretraga = (Rezervacija) kz.getParametar();
                            so.setOdgovor(Kontroler.getInstance().pretraziRezervacije(rezervacijaPretraga));
                            break;
                        case Operacije.UCITAJ_REZERVACIJU:
                            Rezervacija rezervacijaZaUcitavanje = (Rezervacija) kz.getParametar();
                            so.setOdgovor(Kontroler.getInstance().ucitajRezervaciju(rezervacijaZaUcitavanje));
                            break;
                        case Operacije.UCITAJ_LISTU_RECENZIJA:
                         
                             so.setOdgovor(Kontroler.getInstance().ucitajListuRecenzija());
                            break;
                            case Operacije.PRETRAZI_RECENZIJE:
                            Recenzija paramRec = (Recenzija) kz.getParametar();
                            so.setOdgovor(Kontroler.getInstance().pretraziRecenzije(paramRec));
                            break;
                        default:
                            throw new AssertionError();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    so.setException(e);
                }
                posiljalac.posalji(so);

            } catch (Exception ex) {
                Logger.getLogger(ObradaKlijentskogZahteva.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
