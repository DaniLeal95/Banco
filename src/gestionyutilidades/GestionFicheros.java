package gestionyutilidades;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import cajero.MiObjectOutputStream;
import datos.ClienteImp;

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
			
			Object cliente=(ClienteImp)ois.readObject();
			while(cliente!=null){
			System.out.println(cliente.toString());
			cliente=(ClienteImp)ois.readObject();
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
	
	
	
	/*Escribir Fichero
	 * 	Breve comentario:
	 * 		El metodo escribirá en el fichero cuyo nombre y objeto clienteImp recibirá por parametros 
	 * 	Cabecera:
	 * 		void escribirCliente(String nombrefichero,ClienteImp cliente)
	 * 	Precondiciones:
	 * 		El fichero debe estar creado
	 * 	Entradas:
	 * 		Una cadena nombre del fichero y un objeto ClienteImp
	 * 	Salidas:
	 * 		Nada 
	 * 	Postcondiciones:
	 * 		Escribirá el objeto en el fichero.
	 * */
	public void escribirCliente(String nombrefichero, ClienteImp cliente){
		
		File f=null;
		FileOutputStream fos=null;
		MiObjectOutputStream oos=null;
		try{
			f=new File(nombrefichero);
			fos=new FileOutputStream(f,true);
			oos=new MiObjectOutputStream(fos);
			
			oos.writeObject(cliente);
			
		}catch(IOException ioe){
			System.out.println(ioe);
		}finally{
			if(fos!=null && oos!=null){
				try{
					fos.close();
					oos.close();
				}catch(IOException ioe){
					System.out.println(ioe);
				}
			}
		}
	}
	
}

/*
 * Actualizacion
 * 	
 * 
 * */
