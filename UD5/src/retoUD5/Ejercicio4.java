package retoUD5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Ejercicio4 {

	public static void main(String[] args) {
		
		String fichero = "persona.dat";
		String ruta = System.getProperty("user.dir");
		String rutaFichero = ruta + File.separator + fichero;
		File miFichero = new File(rutaFichero);
		
		try {
			miFichero.createNewFile();
		} catch (IOException | SecurityException e) {
			e.printStackTrace();
		}
		
		escribirFichero(miFichero);
		
		leerFichero(miFichero);

	}
	
	public static void escribirFichero(File fichero) {
		Persona marco = new Persona("Marco", 29, "C/ Marchenilla, 26", 611111111);
		Persona lorena = new Persona("Lorena", 22, "C/ Tonás, 11", 622222222);
		Persona esther = new Persona("Esther", 43, "C/ Cervantes, 18", 633333333);
		
		try {
			FileOutputStream fos = new FileOutputStream(fichero);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(marco);
			oos.writeObject(lorena);
			oos.writeObject(esther);
			oos.close();
		} catch(IOException e) {
			System.out.println("No se pudo escribir en el fichero");
		}
	}
	
	public static void leerFichero(File fichero) {
		try {
			FileInputStream fis = new FileInputStream(fichero);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			// (Persona) es un casting, ya que el método .readObject() nos devuelve un objeto Object, así nos devuelve un objeto Persona
			// con la instrucción Object persona = ois.readObject(); obtenemos el mismo resultado
			
			Persona persona = (Persona) ois.readObject();
			System.out.println(persona.toString() + "\n");
			persona = (Persona) ois.readObject();
			System.out.println(persona.toString() + "\n");
			persona = (Persona) ois.readObject();
			System.out.println(persona.toString() + "\n");
			ois.close();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("No se pudo leer el fichero");
		}
	}

}
