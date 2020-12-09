package com.company;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main
{
    public static void main(String[] args)
    {
        int port = 8080;
        try
        {
            ServerSocket serverSocket = new ServerSocket(port);
            while (true)
            {
                System.out.println("Waiting for client on port " + port);
                Socket fromClientSocket = serverSocket.accept();
                try(Socket localSocket = fromClientSocket; PrintWriter pw = new PrintWriter(localSocket.getOutputStream(),true); BufferedReader br = new BufferedReader(new InputStreamReader(localSocket.getInputStream())))
                {
                    String str1;
                    String str2;
                    String str3;
                    while ((str1 = br.readLine()) != null && (str2 = br.readLine()) != null && (str3 = br.readLine()) != null)
                    {
                        if (str1.equals("bye") && str2.equals("bye") && str3.equals("bye"))
                        {
                            pw.println("good bye");
                            break;
                        }
                        else
                            {
                                System.out.println("The message-1 is " + str1 + "!");
                                System.out.println("The message-2 is " + str2 + "!");
                                System.out.println("The message-3 is " + str3 + "!");
                                pw.println("Message on server!");
                                switch (str2)
                                {
                                    case "+":
                                        {
                                            System.out.print("Answer: ");
                                            System.out.println(Integer.parseInt(str1) + Integer.parseInt(str3));
                                            break;
                                        }
                                        case "-":
                                            {
                                                System.out.print("Answer: ");
                                                System.out.println(Integer.parseInt(str1) - Integer.parseInt(str3));
                                                break;
                                            }
                                            case "*":
                                                {
                                                    System.out.print("Answer: ");
                                                    System.out.println(Integer.parseInt(str1) * Integer.parseInt(str3));
                                                    break;
                                                }
                                                case "%":
                                                {
                                                    System.out.print("Answer: ");
                                                    System.out.println(Integer.parseInt(str1) % Integer.parseInt(str3));
                                                    break;
                                                }
                                                case "^":
                                                {
                                                    System.out.print("Answer: ");
                                                    System.out.println(Integer.parseInt(str1) ^ Integer.parseInt(str3));
                                                    break;
                                                }
                                    }
                                }

                        }
                }
                catch(IOException ex)
                {
                    ex.printStackTrace(System.out);
                }
            }
        }
        catch (IOException ex)
        {
            ex.printStackTrace(System.out);
        }
    }
}