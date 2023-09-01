/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import baza.DBBroker;
import baza.DBRepozitorijum;
import baza.Konekcija;
import forme.ServerskaForma;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import niti.ObradaKlijentskogZahteva;

/**
 *
 * @author LENOVO
 */
public class PokreniServer extends Thread{
 ServerSocket serverSocket;
    ServerskaForma sf;

    public PokreniServer() {
      
    }

  
    
    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }
 
   
 @Override
    public void run() {
        try {
             serverSocket = new ServerSocket(9000);
            while (true) {

                System.out.println("Cekanje na konekciju...");
                Socket socket = serverSocket.accept();
                System.out.println("Povezan!");
                obradaKlijentskihZahteva(socket);
            }
        } catch (Exception ex) {
            //ex.printStackTrace();
            System.out.println("Zatvoren je soket, pokrenite server ponovo!");
        }

    }

    private void obradaKlijentskihZahteva(Socket socket) {
        ObradaKlijentskogZahteva nit = new ObradaKlijentskogZahteva(socket);
        nit.start();
    }
    
      
}
