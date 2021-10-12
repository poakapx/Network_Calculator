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
                try(Socket socket = fromClientSocket; PrintWriter printwriter = new PrintWriter(socket.getOutputStream(),true); BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(socket.getInputStream())))
                {
                    // Ввод данных
                    while ((str1 = bufferedreader.readLine()) != null && (str2 = bufferedreader.readLine()) != null && (str3 = bufferedreader.readLine()) != null)
                    {
                        if (str1.equals("bye") || str2.equals("bye") || str3.equals("bye")) { printwriter.println("Прощай!"); break; }
                        else
                        {
                            // Первая строка, вторая строка, третья строка
                            printwriter.println("Сообщения (" + str1 + ", " + str2 + ", " + str3 + ") на сервак доставлены!");
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