/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jserversocket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Administrador
 */
public class Client extends Thread
{
    Socket socket;
    BufferedInputStream input;
    BufferedOutputStream output;
    
//------------------------------------------------------------------------------    
    Client(Socket socket)
    {
        this.socket=socket;
        
    }
//------------------------------------------------------------------------------    
    @Override
    public void run()
    {
        
        try
        {
            System.out.println("Novo cliente iniciado!");

            input = new BufferedInputStream(socket.getInputStream());
            output = new BufferedOutputStream(socket.getOutputStream());

            for(;;)
            {
                System.out.println("Lendo!");
                int lido = input.read();
                
                if(lido==-1)
                {
                  System.out.println("Desconexao encerrando client...");       
                  return;
                }
                
                //---All cliente code here
                                
            }
        }
        catch(IOException Ex)
        {
           Ex.printStackTrace();
           System.out.println("Falha de I/O...");
        }
        catch(Exception Ex)
        {
           Ex.printStackTrace();
           System.out.println("Falha inesperada encerrando client...");
        }
        finally
        {
            try 
            {
                input.close();
                output.close();
                socket.close();
            } 
            catch (IOException Ex) 
            {
                Ex.printStackTrace();
                System.out.println("Falha de I/O");
            }
        }
        
        
    }
}    
