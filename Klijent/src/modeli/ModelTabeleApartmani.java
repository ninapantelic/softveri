/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import domen.Apartman;
import domen.Gost;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author LENOVO
 */
public class ModelTabeleApartmani extends AbstractTableModel {
private ArrayList<Apartman>lista;
    private String[] kolone = {"Naziv apartmana","Cena","Raspolozivost","Broj soba","Balkon"};

    public ModelTabeleApartmani(ArrayList<Apartman> apartmani) {
        this.lista =apartmani;
    }

    public ArrayList<Apartman> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Apartman> lista) {
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
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex==2 || columnIndex==4)return Boolean.class;
        return super.getColumnClass(columnIndex); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
Apartman a = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                
               return a.getNazivApartmana();
            case 1:
                return a.getCena() + "€";
            case 2:
                return a.isRaspolozivost();
            case 3:
                return a.getBrojSoba();
            case 4:
                return a.isBalkon();
            
            default:
              return "n/a";
        }
    }

    public Apartman vratiSelektovanApartman(int selected) {
return lista.get(selected);
    }
    
}
