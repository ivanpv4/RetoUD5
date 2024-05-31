package retoUD5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {

		String directorio = "dirEjer2";
		String fichero1 = "uno.txt";
		String fichero2 = "dos.txt";

		String directorioActual = System.getProperty("user.dir");
		System.out.println("La ruta del directorio actual es: " + directorioActual);

		String rutaCompletaDirectorio1 = directorioActual + File.separator + directorio;
		File miDirectorio = new File(rutaCompletaDirectorio1);

		if (!comprobarExiste(miDirectorio)) {
			try {
				miDirectorio.mkdir();
				System.out.println("Se ha creado el directorio " + directorio);
			} catch (SecurityException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("El directorio " + directorio + " ya existe");
		}

		String rutaCompletaFich1 = rutaCompletaDirectorio1 + File.separator + fichero1;
		String rutaCompletaFich2 = rutaCompletaDirectorio1 + File.separator + fichero2;

		File miFichero1 = new File(rutaCompletaFich1);
		File miFichero2 = new File(rutaCompletaFich2);

		if (!comprobarExiste(miFichero1)) {
			try {
				miFichero1.createNewFile();
				System.out.println("Se ha creado el fichero " + fichero1);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("El fichero " + fichero1 + " ya existe");
		}

		if (!comprobarExiste(miFichero2)) {
			try {
				miFichero2.createNewFile();
				System.out.println("Se ha creado el fichero " + fichero2);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("El fichero " + fichero2 + " ya existe");
		}

		escribirFichero(miFichero2);
		System.out.println("\nSe ha escrito en el fichero " + fichero2);
		
		System.out.println("\nLectura de fichero " + fichero2);
		leerFichero(miFichero2);

	}

	public static boolean comprobarExiste(File fichero) {
		if (fichero.exists()) {
			return true;
		} else {
			return false;
		}

	}

	public static void escribirFichero(File fichero) {
		try {
			FileWriter escritor = new FileWriter(fichero);
			BufferedWriter bw = new BufferedWriter(escritor);
			Scanner sc = new Scanner(System.in);
			String nombre, salida;
			boolean bandera1 = true;
			boolean bandera2 = true;

			System.out.println("\nIntroduzca un nombre");
			do {
				nombre = sc.nextLine();
				bw.write(nombre + "\n");
				System.out.println("\nPulse 'Enter' para introducir otro nombre o la tecla 'guión'(-) para finalizar");
				do {
					salida = sc.nextLine();
					if (salida.isEmpty()) {
						bandera2 = true;
					} else if (salida.equalsIgnoreCase("-")) {
						bandera2 = true;
						bandera1 = false;
					} else {
						System.out.println("Instrucción no válida. Pulse 'Enter' o 'guión'(-)");
						bandera2 = false;
					}
				} while (!bandera2);
			} while (bandera1);
			bw.close();
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void leerFichero(File fichero) {
		try {
			FileReader lector = new FileReader(fichero);
			BufferedReader br = new BufferedReader(lector);
			String linea;
			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
			;
			lector.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
