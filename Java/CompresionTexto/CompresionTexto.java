import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class CompresionTexto {

    public static byte[] comprimir(String texto) throws IOException {
        if (texto == null || texto.length() == 0) {
            return null;
        }

        ByteArrayOutputStream bos = new ByteArrayOutputStream(texto.length());
        GZIPOutputStream gzip = new GZIPOutputStream(bos);
        gzip.write(texto.getBytes());
        gzip.close();

        byte[] compresion = bos.toByteArray();
        bos.close();

        return compresion;
    }

    public static String descomprimir(byte[] compresion) throws IOException {
        if (compresion == null) {
            return null;
        }

        ByteArrayInputStream bis = new ByteArrayInputStream(compresion);
        GZIPInputStream gzip = new GZIPInputStream(bis);
        BufferedReader br = new BufferedReader(new InputStreamReader(gzip, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        
        br.close();
        gzip.close();
        bis.close();
        
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        String texto = "El Bugatti Veyron EB 16.4 es un automóvil superdeportivo "
                + "diseñado y desarrollado por el Grupo Volkswagen y producido en "
                + "Molsheim, Francia por Bugatti Automobiles S.A.S. desde 2001. "
                + "La versión básica del coche (Veyron 16.4) se fabricó hasta 2011, "
                + "y más tarde las versiones Grand Sport y Super Sport se iniciaron "
                + "en 2009 y 2010.";

        System.out.println("Cadena original: " + texto);
        System.out.println("Tamaño original: " + texto.length());

        byte[] compresion = comprimir(texto);
        String compresionStr = new String(compresion, "UTF-8");

        System.out.println("=== Compresión ===");
        System.out.println("Cadena compresa: " + compresionStr);
        System.out.println("Tamaño de compresión: " + compresionStr.length());

        String descompresion = descomprimir(compresion);

        System.out.println("=== Descompresión ===");
        System.out.println("Cadena descompresa: " + descompresion);
        System.out.println("Tamaño de descompresión: " + descompresion.length());
    }
}
