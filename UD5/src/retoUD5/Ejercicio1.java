package retoUD5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {

		String fichero1, fichero2;
		String directorio = "dirEjer1";

		System.out.println("Introduzca los nombres de dos ficheros. Ambos deben tener una longitud igual o superior a 3");

		Scanner sc = new Scanner(System.in);
		fichero1 = sc.nextLine() + ".txt";
		fichero2 = sc.nextLine() + ".txt";

		while(fichero1.length() < 3 || fichero2.length() < 3) {
			while(fichero1.length() < 3) {
				System.out.println("El nombre del fichero 1 no es válido. Introdúzcalo de nuevo");
				fichero1 = sc.nextLine() + ".txt";
			}
			while(fichero2.length() < 3) {
				System.out.println("El nombre del fichero 2 no es válido. Introdúzcalo de nuevo");
				fichero2 = sc.nextLine() + ".txt";
			}
		}
		System.out.println("El nombre del fichero 1: " + fichero1 + " es válido");
		System.out.println("El nombre del fichero 2: " + fichero2 + " es válido");
		
		String directorioActual = System.getProperty("user.dir");
		System.out.println("\nLa ruta del directorio actual es: " + directorioActual);
		
		String rutaCompletaFich1 = directorioActual + File.separator + fichero1;
		File miFichero1 = new File(rutaCompletaFich1);
		
		if(!comprobarExiste(miFichero1)) {
			try {
				miFichero1.createNewFile();
				System.out.println("\nEl fichero " + fichero1 + " se ha creado");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("\nEl fichero 1 ya existe");
		}
		
		String rutaCompletaFich2 = directorioActual + File.separator + fichero2;
		File miFichero2 = new File(rutaCompletaFich2);
		
		if(!comprobarExiste(miFichero2)) {
			try {
				miFichero2.createNewFile();
				System.out.println("El fichero " + fichero2 + " se ha creado");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("El fichero 2 ya existe");
		}
		
		if(comprobarExiste(miFichero1)) {
			escribirEnFichero(miFichero1);
		}
		
		if(comprobarExiste(miFichero1)) {
			System.out.println("\nLectura de fichero 1:");
			leerDeFichero(miFichero1);
		}
		
		if(comprobarExiste(miFichero1)) {
			System.out.println("Nombre del archivo: " + miFichero1.getName());
			System.out.println("Ruta absoluta: " + miFichero1.getAbsolutePath());
			System.out.println("Ruta del directorio padre: " + miFichero1.getParent());
			try{
				System.out.println("Tamaño del archivo: " + miFichero1.length());
				System.out.println("¿Es un archivo?: " + miFichero1.isFile());
				System.out.println("¿Tiene permisos de lectura?: " + miFichero1.canRead());
				System.out.println("¿Tiene permisos de escritura?: " + miFichero1.canWrite());
				System.out.println("¿Tiene permisos de ejecución?: " + miFichero1.canExecute());
				System.out.println("¿Está oculto?: " + miFichero1.isHidden());
			} catch (SecurityException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("El archivo no existe y por tanto no se pueden mostrar las propiedades del fichero");
		}
		
		duplicarFicheros(miFichero1, miFichero2);
		System.out.println("\nSe ha copiado el contenido del fichero " + fichero1 + " en el fichero " + fichero2);
		
		borrarFichero(miFichero1);
		System.out.println("\nSe ha borrado el fichero " + fichero1);
		
		System.out.println("\nLectura del fichero 2:");
		leerDeFichero(miFichero2);
		
		String rutaCompletaDirectorio = directorioActual + File.separator + directorio;
		File miDirectorio = new File(rutaCompletaDirectorio);
		
		if(!comprobarExiste(miDirectorio)) {
			try {
				miDirectorio.mkdir();
				System.out.println("\nEl directorio " + directorio + " se ha creado");
			} catch (SecurityException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("\nEl directorio ya existe");
		}

		sc.close();

	}
	
	public static boolean comprobarExiste(File fichero) {
		if(fichero.exists()){
			return true;
		} else {
			return false;
		}
		
	}
	
	public static boolean escribirEnFichero(File fichero) {
		try{
			FileWriter escritor = new FileWriter(fichero);
			for(int i = 0; i < 11; i++) {
				escritor.write(i + "\n");
			}
			escritor.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public static boolean leerDeFichero(File fichero) {
		try {
			FileReader lector = new FileReader(fichero);
			BufferedReader br = new BufferedReader(lector);
			String linea;
			while((linea = br.readLine()) != null){
				System.out.println(linea);
			};
			lector.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public static boolean duplicarFicheros(File origen, File destino) {
		try {
			FileInputStream desde = new FileInputStream(origen);
			FileOutputStream hacia = new FileOutputStream(destino);
			int c;
			while((c = desde.read()) != -1) {
				hacia.write(c);
			}
			desde.close();
			hacia.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return true;
	}
	
	public static boolean borrarFichero(File fichero) {
		try {
			fichero.delete();
		} catch(SecurityException e) {
			e.printStackTrace();
		}
		return true;
	}

}
