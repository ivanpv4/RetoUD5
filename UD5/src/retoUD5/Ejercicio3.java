package retoUD5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {
        String fichero = "tres.dat";
        String directorioActual = System.getProperty("user.dir");
        String rutaCompletaFichero = directorioActual + File.separator + fichero;
        File miFichero = new File(rutaCompletaFichero);

        try {
            miFichero.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }

        System.out.println("Introduzca números mayores que 0 para escribirlos en el fichero. Si introduce 0 o uno negativo el programa finalizará");

        Scanner sc = new Scanner(System.in);
        escribirFichero(miFichero, sc);
        leerFichero(miFichero);

        sc.close();
    }

    public static void escribirFichero(File fichero, Scanner sc) {
        boolean bandera = true;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(fichero);
            oos = new ObjectOutputStream(fos);

            while (bandera) {
                try {
                    int i = sc.nextInt();
                    if (i > 0) {
                        oos.writeInt(i);
                    } else {
                        System.out.println("Este número es 0 o negativo. El programa finalizó");
                        bandera = false;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Por favor, ingrese un número válido.");
                    sc.next(); // Limpia el buffer del escáner
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void leerFichero(File fichero) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        boolean bandera = true;

        try {
            fis = new FileInputStream(fichero);
            ois = new ObjectInputStream(fis);

            while (bandera) {
                try {
                    int c = ois.readInt();
                    System.out.println(c);
                } catch (IOException e) {
                    bandera = false;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
