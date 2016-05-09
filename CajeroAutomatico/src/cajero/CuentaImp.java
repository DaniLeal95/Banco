package cajero;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
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
import java.io.Serializable;

public class CuentaImp implements  Cuenta, Serializable {

	
	
	
	/**
	 * UID
	 */
	private static final long serialVersionUID = 1183469131124915878L;

	//ATRIBUTOS
	private int numCuenta;
	private long saldo;

	
	//PropiedadesCompartidas
	public static int contador=0;
	
	//constructores
	public CuentaImp(){
		saldo=0;
		
		if(contador!=0){numCuenta=contador++;}
		else{ 
			numCuenta=this.CogerUltimaID()+1;
			
		}
		this.escribirUltimaID(numCuenta);
		
		
	}
	
	public CuentaImp(long saldo) throws ExcepcionPersona{
		
	
			this.saldo=saldo;
			if(contador!=0)numCuenta=contador++;
			else numCuenta=this.CogerUltimaID()+1;
			
			this.escribirUltimaID(numCuenta);
			
		

	}
	
	//Consultores

	public int getNumCuenta(){
		return(this.numCuenta);
	}
	public long getSaldo(){
		return(this.saldo);
	}
	//modificadores
	
	public void setSaldo(long saldo){
		this.saldo=saldo; 
		
	}
	public int getContador(){
		return this.contador;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (numCuenta ^ (numCuenta >>> 32));
		return result;
	}

	/*
	 *Estudio de la Interfaz de equals
	 *Comentario:Va a comprobar si dos objetos de tipo Cuenta son iguales o no
	 *Cabecera: boolean equals(Object o)
	 *Precondiciones:
	 *Entradas: un objeto de tipo Object 
	 *Salidas: un boolean
	 *Poscondiciones:devolvera true si son iguales y false si no lo son 
	 * */
	@Override
	public boolean equals(Object o) {
		boolean eq=false;
		
		if(o!=null && o instanceof CuentaImp)
			{
				CuentaImp c=(CuentaImp)o;
				if(this.numCuenta==c.numCuenta && this.saldo==c.saldo)
					{
						eq=true;
				}//fin if
		}//fin if
		return(eq);
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
	  
		public int CogerUltimaID()
		{
			//variables 
			int id=1;
			
			File f=null;
			FileInputStream fis=null;
	  		ObjectInputStream ois=null;
			
	  		try{
	  			//abro el fichero para leer
	  			f=new File("idcuenta.dat");
	  			fis=new FileInputStream(f);
	  			ois=new ObjectInputStream (fis);
	  			int aux=ois.readInt();
	  			while(aux!=-1){
	  				id=aux;
	  				aux=ois.readInt();
	  			}
	  			
				
				
	  		//  }catch(FileNotFoundException fnfe){
	  			
			  }catch(EOFException eofe){
				  System.out.println("Fin de fichero " +eofe);
			  }catch(IOException io){
				  System.out.println("Ha ocurrido un error " +io);
			  }finally{
				  try{
					  ois.close();
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
		
	public void escribirUltimaID(int id){
		File f=null;
		FileOutputStream fos=null;
		ObjectOutputStream oos=null;
  		
  		try{
  			//abro el fichero para leer
  			f=new File("idcuenta.dat");
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

	@Override
	public String toString() {
		return "CuentaImp [NumCuenta= " + numCuenta + " Saldo= "+saldo+"]";
	}






	
}
