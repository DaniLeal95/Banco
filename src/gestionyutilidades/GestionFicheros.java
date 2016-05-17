package gestionyutilidades;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Vector;

import cajero.MiObjectOutputStream;
import datos.ClienteImp;

public class GestionFicheros {
	/*
	 * Metodo mostrarFichero
	 * 	Breve Comentario:
	 * 		Este metodo retornara todos los clientes que tenemos registrados en el fichero, en un vector de ClienteImp
	 * 	Cabecera:
	 * 		Vector<ClienteImp> mostrarFichero()
	 * 	Precondiciones:
	 * 		Nada
	 * 	Entradas:
	 * 		El nombre del fichero
	 * 	Salidas:
	 * 		Un vector de clientes
	 * 	Postcondiciones
	 * 		El metodo retornara un Vector de clienteImp con todos los clientes que tenga el fichero, 
	 * 		asociado al nombre , funciion   
	 * 
	 * */
	public Vector<ClienteImp> mostrarFichero(){
		File f=null;
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		Vector<ClienteImp> clientes=new Vector<>(0,1);
		try{
			f=new File("ClientesMaestro.dat");
			fis=new FileInputStream(f);
			ois=new ObjectInputStream(fis);
			
			Object cliente=(ClienteImp)ois.readObject();
			while(cliente!=null){
			clientes.addElement((ClienteImp) cliente);	
				
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
		
		return clientes;
	}
	
	
	
	/*Escribir Fichero
	 * 	Breve comentario:
	 * 		El metodo escribirá en el fichero cuyo nombre y objeto clienteImp recibirá por parametros 
	 * 	Cabecera:
	 * 		void escribirCliente(ClienteImp cliente)
	 * 	Precondiciones:
	 * 		El fichero debe estar creado
	 * 	Entradas:
	 * 		Una cadena nombre del fichero y un objeto ClienteImp
	 * 	Salidas:
	 * 		Nada 
	 * 	Postcondiciones:
	 * 		Escribirá el objeto en el fichero.
	 * */
	public void escribirCliente(ClienteImp cliente){
		
		File f=null;
		FileOutputStream fos=null;
		MiObjectOutputStream oos=null;
		try{
			f=new File("ClientesMaestro.dat");
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
