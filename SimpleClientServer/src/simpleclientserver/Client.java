/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleclientserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brandon
 */
public class Client {
    
    public static void main(String[] args) throws Exception{
        System.out.println("Client started");
        Socket soc = new Socket("localhost", 9806);
       
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in)); //reading data from keyboard
        
        BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream())); //reading data from socket input stream


        //send data to server 
        PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
        

        int option = 0;
        int num1 = 0;
        int num2 = 0;
        
        do {            
            System.out.println("Choose an operation:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");
            System.out.println("Enter an option:");
            option = Integer.parseInt(userInput.readLine());
            
            if (option != 5)
            {
            System.out.println("Enter first number");
            num1 = Integer.parseInt(userInput.readLine());
            
            System.out.println("Enter second number");
            num2 = Integer.parseInt(userInput.readLine());
            
            out.println(option+ ":"+num1 + ":"+num2);
            }
            
            else{
                out.println(option+":0:0");
                break;
            }
            
            String answer = in.readLine();
            System.out.println("Server says: "+ answer);
            System.out.println("");
            
            
        } while (true);
        
        System.out.println("Client terminated");
        
        
        
    }
    
    
    
    
    
    
    
   
    
    
}
