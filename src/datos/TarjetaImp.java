package datos;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import cajero.TarjetaExcepcion;

public class TarjetaImp implements Tarjeta,Serializable {
	
	private static final long serialVersionUID = -2452366085707864944L;
	/* 
	 * Clase Implementada de Tarjeta 
	 * 	Propiedades
	 * 		string tipo -> consultable y modificable
	 * */
	//basicas
	private char tipo;
	private long numtarjeta;
	//compartidas
	public static long contadortarjeta=0;
	
	//constructores
	public TarjetaImp(){
		if(contadortarjeta!=0){
			numtarjeta=contadortarjeta++;	
		}
		else{ 
			numtarjeta=this.CogerUltimaID()+1;
		}
		contadortarjeta=numtarjeta;
		this.escribirUltimaID(numtarjeta);
		tipo=' ';
	}
	
	public TarjetaImp(char tipo) throws TarjetaExcepcion{
		if(Character.toUpperCase(tipo)!='C' && Character.toUpperCase(tipo)!='D'){
			throw new TarjetaExcepcion("Solo puede ser de Credito o de Debito");
		}
		else{
			if(contadortarjeta!=0){
				numtarjeta=contadortarjeta+1;
				}
			else{ 
				numtarjeta=this.CogerUltimaID()+1;
				
			}
			contadortarjeta=numtarjeta;
			this.escribirUltimaID(numtarjeta);
			this.tipo=tipo;
		}
	}
	//ESTE CONSTRUCTOR NO TIENE MUCHO SENTIDO EN MI UNIVERSO DEL DISCURSO.
	public TarjetaImp(TarjetaImp tp){
		this.tipo=tp.getTipo();
		this.numtarjeta=tp.numtarjeta;
	}
	
	/*Consultores*/
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
	public long getNumtarjeta() {
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

		public long CogerUltimaID()
		{
			//variables 
			long id=0;
			
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
	  					long aux=ois.readLong();
	  					while(aux!=-1){
	  						id=aux;
	  						aux=ois.readLong();
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
	public void escribirUltimaID(long id){
		File f=null;
		FileOutputStream fos=null;
		ObjectOutputStream oos=null;
  		
  		try{
  			//abro el fichero para leer
  			f=new File("idtarjeta.dat");
  			
  			fos=new	FileOutputStream(f);
  			
  			oos=new ObjectOutputStream(fos);
  			
  			oos.writeLong(id);
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
		String tip="Debito";
		if(tipo=='C')tip="Credito";	//esto simplemente es estetico, 
					//para que en vez que en el toString muestre un char nos muestre una cadena
		
		return "Numtarjeta: " + (numtarjeta) +", tipo: " + tip ;
	}

	



}
