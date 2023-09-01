/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import domen.Gost;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author LENOVO
 */
public class ModelTabeleGosti extends AbstractTableModel {
private ArrayList<Gost>lista;
    private String[] kolone = {"Ime","Prezime","Korisnicko ime","Broj telefona"};

    public ModelTabeleGosti(ArrayList<Gost> gosti) {
        this.lista =gosti;
    }

    public ArrayList<Gost> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Gost> lista) {
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
Gost g = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                
               return g.getIme();
            case 1:
                return g.getPrezime();
            case 2:
                return g.getKorisnickoIme();
          
            case 3:
                return g.getBrojTelefona();
            
            default:
              return "n/a";
        }
    }

    public Gost vratiSelektovanogGosta(int selected) {
return lista.get(selected);
    }
    
}
