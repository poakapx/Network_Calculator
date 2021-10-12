package com.company;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        System.out.println("Клиент запущен!");
        int port = 8080; String host = "127.0.0.1";
        // Первая строка, вторая строка, третья строка
        String str1; String str2; String str3;
        // Открыть сокет
        Socket socket = new Socket(host, port);
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter printwriter = new PrintWriter(socket.getOutputStream(), true);
        Scanner scanner = new Scanner(System.in);
        // Ввод данных
        do
        {
            // Первая строка
            System.out.print("Введи число (bye - выход): ");
            str1 = scanner.next(); printwriter.println(str1);
            // Вторая строка
            System.out.print("Введи +, -, *, /, % или ^ (bye - выход): ");
            str2 = scanner.next(); printwriter.println(str2);
            // Третья строка
            System.out.print("Введи число (bye - выход): ");
            str3 = scanner.next(); printwriter.println(str3);
            // Ответ с сервака
            str1 = bufferedreader.readLine(); System.out.println(str1);
            str2 = bufferedreader.readLine(); System.out.println(str2);
            str3 = bufferedreader.readLine(); System.out.println(str3);
        }
        while (!str1.equals("bye") || !str2.equals("bye") || !str3.equals("bye"));
        // Закрыть сокет
        bufferedreader.close(); printwriter.close(); socket.close();
    }
}