package cajero;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class GestionFicheros {
	/*
	 * Metodo mostrarFichero
	 * 	Breve Comentario:
	 * 		Este metodo pinta en pantalla todos los clientes que tenemos registrados en el fichero.
	 * 	Cabecera:
	 * 		void mostrarFichero(String fichero)
	 * 	Precondiciones:
	 * 		Nada
	 * 	Entradas:
	 * 		El nombre del fichero
	 * 	Salidas:
	 * 		Nada solo pinta en pantalla
	 * 	Postcondiciones
	 * 		Nada  
	 * 
	 * */
	public void mostrarFichero(String fichero){
		File f=null;
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		try{
			f=new File(fichero);
			fis=new FileInputStream(f);
			ois=new ObjectInputStream(fis);
			
			Object cuenta=(CuentaImp)ois.readObject();
			while(cuenta!=null){
			System.out.println(cuenta.toString());
			cuenta=(CuentaImp)ois.readObject();
			}
		}catch(FileNotFoundException fnfe){
			System.out.println("Fichero no encontrado");
		}catch(EOFException eof){
			System.out.println("");
		}	catch (IOException ioe) {
			System.out.println(ioe);
		} catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe);
		}
	}
}
