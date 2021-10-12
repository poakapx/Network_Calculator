package com.company;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Сервак запущен!");
        int port = 8080;
        // Первая строка, вторая строка, третья строка
        String str1; String str2; String str3;
        // Открыть сокет
        try
        {
            ServerSocket serversocket = new ServerSocket(port);
            while (true)
            {
                System.out.println("Подключение к порту: " + port + "...");
                Socket fromClientSocket = serversocket.accept();
                try(Socket localSocket = fromClientSocket; PrintWriter printwriter = new PrintWriter(localSocket.getOutputStream(),true); BufferedReader br = new BufferedReader(new InputStreamReader(localSocket.getInputStream())))
                {
                    // Ввод данных
                    while ((str1 = br.readLine()) != null && (str2 = br.readLine()) != null && (str3 = br.readLine()) != null)
                    {
                        if (str1.equals("bye") || str2.equals("bye") || str3.equals("bye"))
                        { printwriter.println("Прощай!"); break; }
                        else
                        {
                            // Первая строка, вторая строка, третья строка
                            System.out.println("1-е сообщение: " + str1);
                            System.out.println("2-е сообщение: " + str2);
                            System.out.println("3-е сообщение: " + str3);
                            printwriter.println("Сообщения от клиента на сервак доставлены!");
                            switch (str2)
                            {
                                case "+": { System.out.print("Ответ: "); System.out.println(Integer.parseInt(str1) + Integer.parseInt(str3)); break; }
                                case "-": { System.out.print("Ответ: "); System.out.println(Integer.parseInt(str1) - Integer.parseInt(str3)); break; }
                                case "*": { System.out.print("Ответ: "); System.out.println(Integer.parseInt(str1) * Integer.parseInt(str3)); break; }
                                case "/": { System.out.print("Ответ: "); System.out.println(Integer.parseInt(str1) / Integer.parseInt(str3)); break; }
                                case "%": { System.out.print("Ответ: "); System.out.println(Integer.parseInt(str1) % Integer.parseInt(str3)); break; }
                                case "^": { System.out.print("Ответ: "); System.out.println(Integer.parseInt(str1) ^ Integer.parseInt(str3)); break; }
                            }
                        }
                    }
                }
                catch(IOException ex) { ex.printStackTrace(System.out); }
            }
        }
        catch (IOException ex) { ex.printStackTrace(System.out); }
    }
}