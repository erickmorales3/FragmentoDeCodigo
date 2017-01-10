
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LecturaArchivo {

    public static void main(String args[]) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File("archivo.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (Exception ex2) {
                ex2.printStackTrace();
            }
        }
    }
}
