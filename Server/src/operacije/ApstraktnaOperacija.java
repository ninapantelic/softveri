/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

import baza.DBBroker;
import baza.DBRepozitorijum;
import repozitorijum.Repozitorijum;

/**
 *
 * @author LENOVO
 */
public abstract class ApstraktnaOperacija {
    
    protected final Repozitorijum repozitorijum;

    public ApstraktnaOperacija() {
        this.repozitorijum = new DBBroker();
    }
    
      public final void izvrsi(Object param) throws Exception {
        try {
            preduslovi(param);
            pokreniTransakciju();
            izvrsiOperaciju(param);
            potvrdiTransakciju();
        } catch (Exception ex) {
            ex.printStackTrace();
            ponistiTransakciju();
            throw ex;
        } finally {
            zatvoriKonekciju();
        }
    }

    
    protected abstract void preduslovi(Object param)throws Exception;
    
     private void pokreniTransakciju() throws Exception {
        ((DBRepozitorijum) repozitorijum).connect();
    }

    protected abstract void izvrsiOperaciju(Object param) throws Exception;

    private void potvrdiTransakciju() throws Exception {
        ((DBRepozitorijum) repozitorijum).commit();
    }

    private void ponistiTransakciju() throws Exception {
        ((DBRepozitorijum) repozitorijum).rollback();
    }

    private void zatvoriKonekciju() throws Exception {
        ((DBRepozitorijum) repozitorijum).disconnect();
    }
}
