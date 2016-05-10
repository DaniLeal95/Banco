package cajero;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GestionFicherosCuenta {
	/*
	 * Metodo mostrarFichero
	 * 	Breve Comentario:
	 * 		Este metodo pinta en pantalla todos las Cuentas que tenemos registrados en el fichero.
	 * 	Cabecera:
	 * 		void mostrarFichero()
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
	public void mostrarFichero(){
		File f=null;
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		try{
			f=new File("CuentaMaestro.dat");
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
	
	
	/*
	 * Breve comentario:
	 * ****************
	 * 	 Este metodo  recibira por parametros la cuenta que desee escribir,
	 * 		y escribirá en el fichero esa cuenta si es posible.
	 * Cabecera:
	 * ********
	 * 	void escribirMaestro(Cuenta c)
	 * 
	 * Precondiciones:
	 * **************
	 * 	Nada	
	 * 
	 * Entradas:
	 * *********
	 * La cuenta a insertar
	 * 
	 * Salida:
	 * *******
	 * Nada
	 * 
	 * Postcondicones:
	 * **************
	 * Nada
	 *  *
	 * */
	public void escribirMaestro(Cuenta c){
		File f=null;
		FileOutputStream fos=null;
		MiObjectOutputStream mioos=null;
		try{
			f=new File("CuentaMaestro.dat");
			fos=new FileOutputStream(f,true);
			mioos=new MiObjectOutputStream(fos);
			
			mioos.writeObject(c);
			
			
		}catch(IOException ioe){
			System.out.println(ioe);
		}finally{
			try{
				mioos.close();
				
			}catch(IOException ioe){
				System.out.println(ioe);
			}
		}
		
		
	}
	
	
	
	
}
