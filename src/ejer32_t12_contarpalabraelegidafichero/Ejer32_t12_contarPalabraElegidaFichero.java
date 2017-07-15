package ejer32_t12_contarpalabraelegidafichero;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Ismael Martín Ramírez
 * [imartinr01@informatica.iesvalledeljerteplasencia.es]
 */
public class Ejer32_t12_contarPalabraElegidaFichero {

    public static String pedirTexto(String texto) {
        Scanner entrada = new Scanner(System.in);
        System.out.print(texto);
        return entrada.nextLine();
    }

    public static void flujoLectura(File fichero, String palabra) {

        String linea;
        String[] palabras;
        int contador = 0;

        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(fichero);
            br = new BufferedReader(fr);
            linea = br.readLine();

            while (linea != null) {
                palabras = linea.split(" ");
                for (int i = 0; i < palabras.length; i++) {
                    
                    if(palabras[i].equalsIgnoreCase(palabra)){
                     contador++;
                    }
                   
                }

                linea = br.readLine();

            }
            System.out.println("El fichero contiene un total de " + contador + " palabras iguales que \""+palabra+"\" .");
            
        } catch (FileNotFoundException ex) {
            System.out.println("Error al leer el fichero en su fase inicial");
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error al leer el fichero en su fase final");
            System.out.println(ex.getMessage());
        } finally {

            if (br != null) {
                try {
                    br.close();
                } catch (IOException ex) {
                    System.out.println("Error al cerrar el fichero en su fase final");
                    System.out.println(ex.getMessage());
                }
            }
            if (fr != null) {

                try {
                    fr.close();
                } catch (IOException ex) {
                    System.out.println("Error al cerrar el fichero en su fase inicial");
                    System.out.println(ex.getMessage());
                }
            }
        }

    }

    public static void main(String[] args) {
        String palabra;
        File fichero;
        System.out.println("Lector de Palabras");
        System.out.println("--------------------");

        fichero = new File(pedirTexto("Nombre del fichero: (quijote.txt)"));

        palabra = pedirTexto("Palabra a buscar: ");

        flujoLectura(fichero, palabra);

        System.out.println("¡Saludos!");
    }

}
