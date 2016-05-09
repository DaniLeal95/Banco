package cajero;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
		if(contadortarjeta!=0){numtarjeta=contadortarjeta++;}
		else{ 
			numtarjeta=this.CogerUltimaID()+1;
			
		}
		this.escribirUltimaID(numtarjeta);
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
			int id=1;
			File f=null;
			FileReader fr=null;
			BufferedReader br=null;
			
	  		
	  		try{
	  			//abro el fichero para leer
	  			f=new File("idtarjeta.txt");
	  			fr=new FileReader(f);
	  			br=new BufferedReader(fr);
	  			String aux=br.readLine();
	  			while(aux!=null){
	  				id=Integer.parseInt(aux);
	  				aux=br.readLine();
	  			}
				
				  
			  }catch(EOFException eofe){
				  System.out.println("Fin de fichero " +eofe);
			  }catch(IOException io){
				  System.out.println("Ha ocurrido un error " +io);
			  }finally{
				  try{
					  fr.close();
				  }catch(IOException ioe){
					  System.out.println(ioe);
				  }
			  }//fin finally
	  		
	  			
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
		FileWriter fw=null;

		
		try{
			//abro el fichero para leer
			fw=new FileWriter("idtarjeta.txt");
			
			fw.write( id);
	}catch(FileNotFoundException fnfe){
		System.out.println(fnfe);
	} catch (IOException ioe) {
		System.out.println(ioe);
	}finally{
		try {
			fw.close();
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
