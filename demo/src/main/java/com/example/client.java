package com.example;

/*import java.io.*;
import java.net.*;
import java.util.*;
public class client {
    String a="localhost";
    int porta=6789;
    DataInputStream in;
    DataOutputStream out;
    Socket m;
    BufferedReader tastiera;
    String utente;
    int numero;
    String ricevuta;
    DataOutputStream outVersoServer;
    BufferedReader inDalServer;
public Socket connetti(){
    System.out.println("i due client sono in esecuzione");
    try{
        tastiera = new BufferedReader(new InputStreamReader(System.in));
        m=new Socket("localhost", 6789);
        outVersoServer= new DataOutputStream(m.getOutputStream());
        inDalServer = new BufferedReader(new InputStreamReader(m.getInputStream()));
    }
    catch(UnknownHostException e ){
        System.err.println("host non coniuscito");
    }  catch(Exception e)
    {
        System.out.println(e.getMessage());
        System.out.println("errore durante la connessione");
        System.exit(1);
    }
    return m;
}
public void communica(){
    try{
        System.out.println("inserisci un numero");
        numero=tastiera.read();
        System.out.println("invio e attendo");
        outVersoServer.writeByte(numero+"/n");
        ricevuta=inDalServer.read();
        System.out.println("risposta" +ricevuta);
        System.out.println("termina la connessione");
        m.close();
    }
    catch(Exception e)
    {
        System.out.println(e.getMessage());
        System.out.println("errore");
        System.exit(1);
    }
}
}*/
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8080);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);
            int tentativiMassimi = Integer.parseInt(in.readLine());
            System.out.println("Hai " + tentativiMassimi + " tentativi per indovinare il numero segreto.");

            int tentativo = 1;
            do {
                System.out.print("Tentativo #" + tentativo + ": Inserisci un numero: ");
                int numeroUtente = scanner.nextInt();

                out.println(numeroUtente);
                System.out.println(numeroUtente);

                String response = in.readLine();
                System.out.println(response);

                if (response.equals("Il numero è corretto. Congratulazioni!") || response.equals("Hai esaurito i tentativi. Il numero segreto era:")) {
                    break;
                }

                tentativo++;
            } while (tentativo <= tentativiMassimi);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
