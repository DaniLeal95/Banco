package cajero;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;


/*
 *Restricciones :
 **************
 * 	Ninguna
 *
 * Funcionalidades:
 * ***************
 * 	
 * 	Aniadidas:
 *	********
 *		void SetTarjeta(TarjetaImp t)
 *
 *	Heredadadas:
 *	************
 *		boolean equals(CuentaImp),
 *		int hashCode(),
 *		void toString()
 * 
 * 
 */

public class CuentaImp implements  Cuenta, Serializable {

	
	
	
	/**
	 * UID
	 */
	private static final long serialVersionUID = 1183469131124915878L;

	//ATRIBUTOS
	private long numCuenta;
	private double saldo;
	private Vector<TarjetaImp> tarjetas;
	

	
	//PropiedadesCompartidas
	public static long contadorCuentas=0;
	
	//constructores
	public CuentaImp(){
		saldo=0;
		
		if(contadorCuentas!=0){numCuenta=contadorCuentas+1; } 
		else{ 
			numCuenta=this.CogerUltimaID()+1;
			
		}
		contadorCuentas=numCuenta;
		this.escribirUltimaID(numCuenta);
		tarjetas=new Vector<TarjetaImp>(0,1);
		
	}
	
	public CuentaImp(long saldo){
		
	
			this.saldo=saldo;
			if(contadorCuentas!=0)numCuenta=contadorCuentas+1;
			else numCuenta=this.CogerUltimaID()+1;
			contadorCuentas++;
			this.escribirUltimaID(numCuenta);
			
			
			tarjetas=new Vector<TarjetaImp>(0,1);
		

	}
	
	//Consultores

	public long getNumCuenta(){
		return(this.numCuenta);
	}
	public double getSaldo(){
		return(this.saldo);
	}
	//modificadores
	
	public void setSaldo(double saldo){
		this.saldo=saldo; 
		
	}
	
	
	
	
	/*-------------------------
	 * FUNCIONALIDADES A�ADIDAS
	 * ------------------------
	 * */
	
	/*
	 * setTarjeta
	 * 	Breve Comentario:
	 * -----------------
	 * 		Este metodo recibe por parametros una TarjetaImp y lo a�ade al vector de tarjetas
	 * 
	 * 	Cabecera:
	 * ----------
	 * 		void setTarjeta(TarjetaImp t)
	 * 		
	 * Precondiciones:
	 * --------------
	 * 		Nada
	 * 
	 * Entradas:
	 * ----------
	 * 		Una tarjetaImp
	 * 
	 * Salidas:
	 * ---------
	 * 		Nada
	 * 
	 * Postcondiciones:
	 * ----------------
	 * 		Nada
	 * 
	 * */
	
	public void setTarjeta(TarjetaImp t){
		this.tarjetas.add(t);
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
	  
		public long CogerUltimaID()
		{
			long id=0;
			
			File f=null;
			FileInputStream fis=null;
	  		ObjectInputStream ois=null;
			
	  		
	  			//abro el fichero para leer
	  			f=new File("idcuenta.dat");
	  			
	  														/*Si el archivo existe leemos*/
	  			if(f.exists()){
	  				
	  				try{
	  					fis=new FileInputStream(f);
	  				
	  					ois=new ObjectInputStream (fis);
	  					long aux=ois.readLong();
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
		
	public void escribirUltimaID(long id){
		File f=null;
		FileOutputStream fos=null;
		ObjectOutputStream oos=null;
  		
  		try{
  			//abro el fichero para leer
  			f=new File("idcuenta.dat");
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

	@Override
	public String toString() {
		String tarjeta="";
		for(int i=0;i<tarjetas.size();i++){
			tarjeta=tarjeta.concat("\n\t\t"+tarjetas.elementAt(i).toString());
		}
		return "\n\tNumCuenta: " + numCuenta + ", saldo: " + saldo + "€, \n\t\ttarjetas: " + tarjeta + "";
	}








	
}
