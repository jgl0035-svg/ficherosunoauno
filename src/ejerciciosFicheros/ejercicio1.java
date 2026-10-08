package ejerciciosFicheros;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ejercicio1 {

    public static void main(String[] args) {
        File carpeta = new File ("datos/ud1/practica");
        System.out.println("Creación con mkdir devuelve: " + carpeta.mkdir());
        System.out.println("Creación con mkdirs devuelve: " + carpeta.mkdirs());

        System.out.println();

        System.out.println("En la primera salida sale false, porque se está usando mkdir para crear el último directorio y los directorios padres, cuando mkdir solo puede crear uno");

        System.out.println();

        File carta = new File(carpeta, "carta.txt");
        try{
            boolean creado = carta.createNewFile();
            System.out.println("Primera llamada con createNewFile: " + creado);
            System.out.println("Segunda llamada con createNewFile: " + carta.createNewFile());

        } catch(IOException e){
            System.out.println("ERROR de entrada/salida: " + e.getMessage());
        }

        try(FileWriter fw = new FileWriter(carta)) {
            fw.write("Primera línea\n");
            fw.write("Segunda línea");

        } catch(IOException e){
            System.out.println("ERROR de entrada/salida: " + e.getMessage());
        }

        try {
            File renombrado = new File(carpeta, "carta_ok.txt");
            boolean renombrar = carta.renameTo(renombrado);
            File borrar = new File("borrar.txt");
            borrar.createNewFile();
            boolean paraBorrar = borrar.delete();
            System.out.println();

            System.out.println("Fichero renombrado: " + renombrar);
            System.out.println("Fichero borrado: " + paraBorrar);
            System.out.println();

        } catch(IOException e){
            System.out.println("ERROR de entrada/salida: " + e.getMessage());
        }

        System.out.println("getName(): " + carta.getName());
        System.out.println("getAbsolutePath(): " + carta.getAbsolutePath());
        System.out.println("length(): " + carta.length());
        System.out.println("lastModified(): " + carta.lastModified());
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println("formateado: " + formato.format(new Date(carta.lastModified())));




    }
}
