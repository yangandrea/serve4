package com.example;

/*package com.example;

import java.io.*;
import java.net.*;
import java.util.*;

public class server {
    ServerSocket s = null;
    Socket c = null;
    String r = null;
    String m = null;
    BufferedReader inDalClient;
    DataOutputStream outVersoClient;
    int numero;
public Socket attendi(){
    try {
        System.out.println("server esecuzione" );
        s=new ServerSocket(6789);
        c=s.accept();
        s.close();
        inDalClient=new BufferedReader(new InputStreamReader(c.getInputStream()));
        outVersoClient= new DataOutputStream(c.getOutputStream());
    } catch (Exception e) {
        System.out.println(e.getMessage());
        System.out.println("errore");
        System.exit(1);
    }
    return c;
}
public void communica(){
try {/*nel 
    System.out.println("invio della stringa");
    outVersoClient.writeBytes(m+ '\n');
    System.out.println("fine");
    c.close();
    System.out.println("il numero generato");
    numero= (int) (Math.random()* (100 - 0) + 0 );nel 
    System.out.println("il numero è "+ numero);
}
catch (Exception e) {
}
}
}*/
import java.io.*;
import java.net.*;
import java.util.Random;

public class server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server in attesa di connessione...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connesso");

            Random random = new Random();
            int numeroSegreto = random.nextInt(2);

            int tentativiMassimi = 10;
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println(tentativiMassimi);

            // Inizia il gioco
            for (int tentativo = 1; tentativo <= tentativiMassimi; tentativo++) {
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                int numeroUtente = Integer.parseInt(in.readLine());

                if (numeroUtente == numeroSegreto) {
                    System.out.println("Il client ha indovinato il numero: " + numeroSegreto);
                    
                    break;
                } else {
                    String risposta;
                    if (numeroUtente < numeroSegreto) {
                        risposta = "Troppo basso";
                    } else {
                        risposta = "Troppo alto";
                    }
                    System.out.println("Tentativo #" + tentativo + ": " + risposta);
                    out.println(risposta);
                }
            }

            // Chiudi le connessioni
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
