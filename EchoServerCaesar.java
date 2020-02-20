
import java.io.*;
import java.net.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

public class EchoServerCaesar {

    public static void main(String[] args) {
        try {
            ServerSocket s = new ServerSocket(8190);
            Socket incoming = s.accept();
            try {
                InputStream inStream = incoming.getInputStream();
                OutputStream outStream = incoming.getOutputStream();

                Scanner in = new Scanner(inStream);
                PrintWriter out = new PrintWriter(outStream, true /* autoFlush */);
                menu(out);

                // echo client input 
                boolean done = false;

                while (!done && in.hasNextLine()) {
                    String line = in.next();
						//out.println("Echo: " + line); 

                    if (line.equals("0")) {
                        done = true;
                    } else if (line.equals("1")) {
                        Calendar data = Calendar.getInstance();
                        int hora = data.get(Calendar.HOUR_OF_DAY);
                        int min = data.get(Calendar.MINUTE);
                        int seg = data.get(Calendar.SECOND);

                        out.println("Hora: " + hora + ":" + min + ":" + seg);

                    } else if (line.equals("2")) {
                        String soName = System.getProperty("os.name");
                        out.println("O nome do SO e: " + cipherOfCaesar(soName));

                    } else if (line.equals("3")) {
                        String idiomaDoSo = System.getProperty("user.language");
                        out.println("O idioma do SO e: " + cipherOfCaesar(idiomaDoSo));

                    } else {
                        out.println("Opcao invalida!");

                    }
                    menu(out);
                }
            } finally {
                incoming.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void menu(PrintWriter out) {
        out.println("Escolha uma opcao e tecle enter: \n"
                + "  1- Obter hora do servidor."
                + "  2- Obter nome do SO do servidor."
                + "  3- Obter o idioma do SO do servidor."
                + "  0- Sair.");
    }

    public static String cipherOfCaesar(String mens) {
        int chave = 3;
        char ascii;
        char x, y;
        String retorno = "";

        for (int i = 0; i < mens.length(); i++) {
            //Tratamento Letras minusculas  
            if (mens.charAt(i) >= 97 && mens.charAt(i) <= 122) {//letrans minusculas de acordo com a tabela ASCII
                if ((int) (mens.charAt(i) + chave) > 122) {
                    x = (char) (mens.charAt(i) + chave);
                    y = (char) (x - 122);
                    ascii = (char) (96 + y);
                    retorno += ascii + " ";
                } else {
                    ascii = (char) (mens.charAt(i) + chave);
                    retorno += ascii + " ";
                }
            }

            //Tratamento Letras mausculas
            if (mens.charAt(i) >= 65 && mens.charAt(i) <= 90) {
                if (mens.charAt(i) + chave > 90) {
                    x = (char) (mens.charAt(i) + chave);
                    y = (char) (x - 90);
                    ascii = (char) (64 + y);
                    retorno += ascii + " ";
                } else {
                    ascii = (char) (mens.charAt(i) + chave);
                    retorno += ascii + " ";
                }
            }
        }

        return retorno;
    }

}
