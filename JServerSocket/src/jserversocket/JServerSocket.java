/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jserversocket;

import java.io.IOException;
import java.net.ServerSocket;


/**
 *
 * @author Administrador
 */
public class JServerSocket 
{
    short Port;
//------------------------------------------------------------------------------
    JServerSocket(short Port)
    {
        this.Port=Port;
        
    }
//------------------------------------------------------------------------------    
    public void run() throws IOException
    {
        System.out.println("Iniciando Server");
        
        ServerSocket server = new ServerSocket(Port);
        
        for(;;)
        {
            System.out.println("Aguardando Conexoes");
            new Client(server.accept()).start();
            System.out.println("Novo cliente");
            
        }
        
    }
//------------------------------------------------------------------------------    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        try
        {
           new JServerSocket((short)1050).run();
           
        }
        catch(Exception Ex)
        {
           Ex.printStackTrace();
           System.out.println("Falha inesperada encerrando server...");
        }
        
    }
    
}
