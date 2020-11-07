
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] arg) {
        double numero, entrada;
        int c, total = (int) (10 * Math.random());
        Socket s = null;
        try {
            System.out.println("Conectando...");
            s = new Socket("localhost", 6789);
            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            System.out.println("Conectado. Enviando " + total + " números...");
            for (c = 0; c < total; c++) {
//                numero = 100.0 * Math.random();
                System.out.println("Digite um valor: ");                
                out.writeDouble(Double.parseDouble((new Scanner(System.in).nextLine())));
                System.out.println("Enviando... ");
            }
            out.flush();
            out.writeDouble(-1.0);
            System.out.println("Total enviado = " + in.readDouble());
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            try {
                if (s != null) {
                    s.close();
                }
            } catch (Exception e2) {
            }
        }
        System.out.println("Conexão encerrada");
        try {
            System.in.read();
        } catch (Exception e3) {
        }
    }
}
