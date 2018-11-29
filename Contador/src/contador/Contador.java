
package contador;

import javafx.stage.FileChooser;
import javax.swing.*;
import java.awt.*;
import java.io.*;
public class Contador {


    public static void main(String[] args) throws Exception  {
       

        System.out.println ("Número de palabras");
        JFileChooser buscador = new JFileChooser();
        buscador.showOpenDialog((buscador));
        String path = buscador.getSelectedFile().getAbsolutePath();
        FileInputStream fr = new FileInputStream (path);
        DataInputStream entrada = new DataInputStream(fr);
        BufferedReader br = new BufferedReader (new InputStreamReader(entrada));
        String line = br.readLine ();
        int count = 0;
        while (line != null) {
            String []parts = line.split(" ");
            for( String w : parts)
            {
                count++;
            }
            line = br.readLine();
        }
        System.out.println(count);
    }
}