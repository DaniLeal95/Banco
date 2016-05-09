package cajero;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TarjetaImp implements Tarjeta {
	/* 
	 * Clase Implementada de Tarjeta 
	 * 	Propiedades
	 * 		string tipo -> consultable y modificable
	 * */
	//basicas
	private char tipo;
	private int numtarjeta;
	//compartidas
	public static int contadortarjeta=0;
	
	//constructores
	public TarjetaImp(){
		if(contadortarjeta!=0){
			numtarjeta=contadortarjeta++;
			
			
		}
		else{ 
			numtarjeta=this.CogerUltimaID()+1;
			this.escribirUltimaID(numtarjeta);
			
		}
		
		tipo=' ';
	}
	
	public TarjetaImp(char tipo) throws TarjetaExcepcion{
		if(Character.toUpperCase(tipo)!='C' && Character.toUpperCase(tipo)!='D'){
			throw new TarjetaExcepcion("Solo puede ser de Credito o de Debito");
		}
		else{
			if(contadortarjeta!=0){numtarjeta=contadortarjeta++;}
			else{ 
				numtarjeta=this.CogerUltimaID()+1;
				
			}
			this.escribirUltimaID(numtarjeta);
			this.tipo=tipo;
		}
	}
	//ESTE CONSTRUCTOR NO TIENE MUCHO SENTIDO EN MI UNIVERSO DEL DISCURSO.
	public TarjetaImp(TarjetaImp tp){
		this.tipo=tp.getTipo();
		this.numtarjeta=tp.numtarjeta;
	}
	
	
	@Override
	public char getTipo() {
		return tipo;
	}

	
	@Override
	public void setTipo(char tipo) throws TarjetaExcepcion {
		
		if(Character.toUpperCase(tipo)=='C' || Character.toUpperCase(tipo)=='D'){
			this.tipo = tipo;
		}
		else {
			throw new TarjetaExcepcion("Solo puede ser de Credito o de Debito");
		}
	}


	@Override
	public int getNumtarjeta() {
		return numtarjeta;
	}

	//Metodos a�adidos
	
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

		@Override

		public int CogerUltimaID()
		{
			//variables 
			int id=0;
			
			File f=null;
			FileInputStream fis=null;
	  		ObjectInputStream ois=null;
			
	  		
	  			//abro el fichero para leer
	  			f=new File("idtarjeta.dat");
	  			
	  														/*Si el archivo existe leemos*/
	  			if(f.exists()){
	  				
	  				try{
	  					fis=new FileInputStream(f);
	  				
	  					ois=new ObjectInputStream (fis);
	  					int aux=ois.readInt();
	  					while(aux!=-1){
	  						id=aux;
	  						aux=ois.readInt();
	  					}
	  				
	  				}catch(FileNotFoundException fnfe){
	  		  			System.out.println(fnfe);
	  		  		}
	  		  		catch(EOFException eofe){
	  		  		
	  		  		}catch(IOException io){
	  					  System.out.println("Ha ocurrido un error " +io);
	  				
	  		  		}finally{
	  					  try{								//cerramos el archivo
	  						  ois.close();
	  					  }catch(IOException ioe){
	  						  System.out.println(ioe);
	  					  }
	  				  }
	  				
	  			}//fin if
	  			
	  			
	  			else{										/*Si no pues lo crearemos*/
	  				escribirUltimaID(id);
	  				
	  			}
	  			
	  		
				
	  		//fin finally
	  		
	  		
	  			
			return(id);
	}
		  /*
		   * Estudio de la interfaz de escribirUltimaID
		   * 
		   * Comentario: 
		   * 	El metodo sobreescribir� la Id escrita en el fichero
		   * Cabecera: 
		   * 	long CogerUltimaID()
		   * Precondiciones:Nada
		   * 	
		   * Entradas:Nada
		   * Salidas:un long (ID)
		   * Postcondiciones:
		   * 	El long retornara asociado al nombre -> Funcion
		   * */	

	@Override
	public void escribirUltimaID(int id){
		File f=null;
		FileOutputStream fos=null;
		ObjectOutputStream oos=null;
  		
  		try{
  			//abro el fichero para leer
  			f=new File("idtarjeta.dat");
  			
  			fos=new	FileOutputStream(f);
  			
  			oos=new ObjectOutputStream(fos);
  			
  			oos.writeInt(id);
	}catch(FileNotFoundException fnfe){
		System.out.println(fnfe);
	} catch (IOException ioe) {
		System.out.println(ioe);
	}finally{
		try {
			oos.close();
		} catch (IOException ioe) {
			System.out.println(ioe);
		}
	}
 } 
	/*
	   * Estudio de la interfaz de escribirUltimaID
	   * 
	   * Comentario: 
	   * 	El metodo sobreescribir� la Id escrita en el fichero, pero sin cabecera
	   * Cabecera: 
	   * 	long CogerUltimaID()
	   * Precondiciones:Nada
	   * 	
	   * Entradas:Nada
	   * Salidas:un long (ID)
	   * Postcondiciones:
	   * 	El long retornara asociado al nombre -> Funcion
	   * */	
	
	public void escribirUltimaIDsinCabecera(int id){
		File f=null;
		FileOutputStream fos=null;
		MiObjectOutputStream oos=null;
  		
  		try{
  			//abro el fichero para leer
  			f=new File("idtarjeta.dat");
  			
  			fos=new	FileOutputStream(f);
  			
  			oos=new MiObjectOutputStream(fos);
  			
  			oos.writeInt(id);
	}catch(FileNotFoundException fnfe){
		System.out.println(fnfe);
	} catch (IOException ioe) {
		System.out.println(ioe);
	}finally{
		try {
			oos.close();
		} catch (IOException ioe) {
			System.out.println(ioe);
		}
	}
 }
	
	
	
	//Metodos sobrescritos
	@Override
	public int hashCode() {
			int result = 1;
	
		return result;
	}
	
	/*
	 * Metodo equals
	 * 	Breve comentario:
	 * 		Este metodo comprobara que dos objetos son iguales,, si es asi retornara true , y false cuando no.
	 * 	Cabecera:
	 * 		boolean equals(Object o)
	 * 	Precondiciones
	 * 		Nada
	 * 	Entrada
	 * 		Un objeto
	 * 	Salidas
	 * 		Un boolean
	 * 	Postcondiciones
	 * 		El boolean retornara asociado al nombre -> Funcion
	 * 
	 * 
	 * */
	@Override
	public boolean equals(Object o){
		boolean igual=false;
		
		if(o!=null && o instanceof TarjetaImp) {
			TarjetaImp t = (TarjetaImp) o;
			if(this.numtarjeta==t.numtarjeta && this.tipo==t.tipo){
				igual=true;
			}
			
		}
		
		return igual;
		
	}

	@Override
	public String toString() {
		String tip;
		if(tipo=='C')tip="Credito";	//esto simplemente es estetico, 
		else tip="Debito";			//para que en vez que en el toString muestre un char nos muestre una cadena 
		return "TarjetaImp [tipo=" + tip + ", numtarjeta=" + (numtarjeta) + "]";
	}

	



}
