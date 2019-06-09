/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleclientserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brandon
 */
public class Server {

    public static void main(String[] args) throws Exception{
            System.out.println("Server Started");
        
        
            ServerSocket ss = new ServerSocket(9806);
            System.out.println("Waiting for client ...");
            Socket soc = ss.accept(); //create socket object
            System.out.println("Connection established");
            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()) {});
            
            
            PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
            //true means - auto flush functionality
            //when sending data to printwrited, will not keep data to buffer
           
            while (true) 
            {            //begin while loop
                String str[] = in.readLine().split(":");
                
                int option = Integer.parseInt(str[0]);
                int num1 = Integer.parseInt(str[1]);
                int num2 = Integer.parseInt(str[2]);
                
                String result = "";
                
                int flag = 0;
                
                switch (option)
                {
                    case 1: result = "Addition is: "+(num1 + num2);break;
                    case 2: result = "Subtraction is: "+(num1 - num2);break;
                    case 3: result = "Multiplication is: "+(num1 * num2);break;
                    case 4: result = "Division is: "+(num1 / num2);break;
                    case 5: flag = 1;break;
                    default:break;
                }
                if (flag == 1)
                {
                    break;
                }
                
                
                
                out.println(result);
                
                //end of while loop
        }
            System.out.println("Server terminated");
       
       
        }

    }

