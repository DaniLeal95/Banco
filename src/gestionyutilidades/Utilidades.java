package gestionyutilidades;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Utilidades {

	
	  /*
	   * Estudio de la interfaz de escribirUltimaID
	   * 
	   * Comentario: 
	   * 	El metodo sobreescribir� la Id escrita en el fichero
	   * Cabecera: 
	   * 	void escribirUltimaID(long id)
	   * Precondiciones:Nada
	   * 	
	   * Entradas:Nada
	   * Salidas:sobreescribira el fichero
	   * Postcondiciones:
	   * 	nada
	   * */	
	
	public void escribirUltimaId(long id,String nombreFichero){
		File f=null;
		FileOutputStream fos= null;
		ObjectOutputStream oos=null;
		try{
			f=new File(nombreFichero);
			fos=new FileOutputStream(f);
			oos=new ObjectOutputStream(fos);
			
			oos.writeLong(id);
		}catch(IOException ioe){
			System.out.println(ioe);
		}finally{
			try{
				oos.close();
			}catch(IOException ioe){
				System.out.println(ioe);
			}
		}
		
	}
	
	/*
	   * Estudio de la interfaz de CogerUltimaID
	   * 
	   * Comentario: 
	   * 	El metodo recogera la Id escrita en ese fichero(long) y la devolvera asociada al nombre
	   * Cabecera: 
	   * 	long CogerUltimaID()
	   * Precondiciones:Nada
	   * 	
	   * Entradas:Nada
	   * Salidas:un long (ID)
	   * Postcondiciones:
	   * 	El long retornara asociado al nombre -> Funcion
	   * */
	public long cogerUltimaId(String nombreFichero){
		long id=0;
		File f=new File(nombreFichero);

		
		if(f.exists()){						//Si el archivo existe pues leemos de el la id
			FileInputStream fis=null;
			ObjectInputStream ois=null;
			try{
				fis=new FileInputStream(f);
				ois=new ObjectInputStream(fis);	
				
				long aux=ois.readLong();
				while(aux!=-1){
					id=aux;
					aux=ois.readLong();
				}
			}catch(EOFException eofe){
				
			}catch(IOException ioe){
				System.out.println(ioe);
			}
			finally{
				try{
					ois.close();
				}catch(IOException ioe){
					System.out.println(ioe);
				}
			}
		}// fin if

		
		return id;
	}
	
	/*
	 * validarPin
	 * 	
	 * Breve comentario:
	 * 		El metodo validara el pin de la tarjeta
	 * 			si el pin es correcto retornara true y false si no es correcto
	 * cabecera:
	 * 		boolean validarPin()
	 * Precondiciones:
	 * 		nada
	 * Entradas:
	 * 		nada
	 * Salida:
	 * 		boolean (validacion)
	 * Postcondiciones:
	 * 		el boolean retornara asociado al nombre -> Funcion
	 * 	
	 * */
	public boolean validarPin(String pin) {
		// Comprobacion del pin
		boolean valido = true;
		if (pin.length() == 4) {

			for (int i = 0; i < pin.length() && valido; i++) {
				
				if (!Character.isDigit(pin.charAt(i))) {
					valido = false;
				}
				
			}
		}
		else{
			valido=false;
		}
		return valido;
	}
	

}
