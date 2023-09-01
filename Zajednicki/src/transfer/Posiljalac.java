/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transfer;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class Posiljalac {
     private Socket socket;

    public Posiljalac(Socket socket) {
        this.socket = socket;
    }
     public void posalji(Object objekat) throws Exception{
         try {
             ObjectOutputStream out=new ObjectOutputStream(socket.getOutputStream());
             out.writeObject(objekat);
             out.flush();
         } catch (IOException ex) {
             ex.printStackTrace();
            throw new Exception("Greska prilikom slanja objekta!\n"+ex.getMessage());
         }
     }
}
