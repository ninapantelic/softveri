/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import domen.Apartman;
import domen.Gost;
import domen.Rezervacija;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author LENOVO
 */
public class ModelTabeleRezervacije extends AbstractTableModel {
private ArrayList<Rezervacija>lista;
    private String[] kolone = {"Gost","Apartman","Datum od","Datum do","Status","Ukupna cena"};
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    public ModelTabeleRezervacije(ArrayList<Rezervacija> rezervacije) {
        this.lista =rezervacije;
    }

    public ArrayList<Rezervacija> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Rezervacija> lista) {
        this.lista = lista;
    }
    
    @Override
    public int getRowCount() {
return lista.size();
    }

    @Override
    public int getColumnCount() {
return kolone.length;
    }

    @Override
    public String getColumnName(int column) {
return kolone[column];
    }

   
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
Rezervacija r = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                
               return r.getGost().toString();
            case 1:
                return r.getApartman().toString();
            case 2:
                return sdf.format(r.getDatumOd());
            case 3:
                return sdf.format(r.getDatumDo());
            case 4:
                return r.getStatus();
            case 5:
                return r.getUkupnaCena()+ "€";
            
            default:
              return "n/a";
        }
    }

    public Rezervacija vratiSelektovanuRezervaciju(int selected) {
return lista.get(selected);
    }
    
}
