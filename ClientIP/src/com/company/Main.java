package com.company;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        int port = 8080;
        String str1 = "2";
        String str2 = "+";
        String str3 = "2";
        System.out.println("Clien start!");
        Socket socket = new Socket("127.0.0.1", port);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
        Scanner scanner = new Scanner(System.in);
        do
        {
            //наша строка1
            System.out.print("Enter message-1 (bye - for exit): ");
            str1 = scanner.next();
            pw.println(str1);
            //наша строка2
            System.out.print("Enter message-2 (bye - for exit): ");
            str2 = scanner.next();
            pw.println(str2);
            //наша строка3
            System.out.print("Enter message-3 (bye - for exit): ");
            str3 = scanner.next();
            pw.println(str3);
            //ответ
            str1 = br.readLine();
            System.out.println(str1);
            str2 = br.readLine();
            System.out.println(str2);
            str3 = br.readLine();
            System.out.println(str3);
        }
        while (!str1.equals("bye") || !str2.equals("bye") || !str3.equals("bye"));
        br.close();
        pw.close();
        socket.close();
    }
}