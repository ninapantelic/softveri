/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import domen.Apartman;
import domen.Recenzija;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author LENOVO
 */
public class ModelTabeleRecenzije extends AbstractTableModel{
    private ArrayList<Recenzija>lista;
    private String[] kolone = {"Komentar","Ocena","Gost","Apartman"};

    public ModelTabeleRecenzije(ArrayList<Recenzija> recenzije) {
        this.lista =recenzije;
    }

    public ArrayList<Recenzija> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Recenzija> lista) {
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
Recenzija r = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                
               return r.getKomentar();
            case 1:
                return r.getOcena();
            case 2:
                return r.getRezervacija().getGost().toString();
            case 3:
                return r.getRezervacija().getApartman().toString();
         
            
            default:
              return "n/a";
        }
    }

    public Recenzija vratiSelektovanuRecenziju(int selected) {
return lista.get(selected);
    }
}
