package cajero;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;


/*
 * Restricciones:
 * 		Nada
 * Metodos añadidos:
 * 		public long cogerUltimaId()
 * 		public void escribirUltimaId(long id)
 * 		
 * 			 
 * 
 * 
 * 
 * */

public class ClienteImp extends PersonaImp implements Cliente,Comparable<ClienteImp>,Cloneable{
	/*-----------------------*/
	/*Atributos bï¿½sicos*/
	private long idCliente;
	private Vector<CuentaImp> cuentas;
	
	
	private String observaciones;

	
	/*Atributos Compartidos*/
	public static long contadorclientes=0;
	/*----------------------*/
	
	/*Constructores*/
	public ClienteImp(){
		super();
		/*Estas 4 lineas son para obtener el idCliente*/
		if(contadorclientes!=0){idCliente=contadorclientes+1;}
		else{idCliente=this.cogerUltimaId()+1;}
		contadorclientes=idCliente;
		this.escribirUltimaId(idCliente);
		/*-------------------------------------------*/
		this.cuentas=new Vector<CuentaImp>(0,1);
		this.observaciones=null;
	}
	
	public ClienteImp(String nombre,int edad,String dni,char sexo) throws ExcepcionPersona{
		super(nombre,edad,dni,sexo);
		/*Estas 4 lineas son para obtener el idCliente*/
		if(contadorclientes!=0){idCliente=contadorclientes+1;}
		else{idCliente=this.cogerUltimaId()+1;}
		contadorclientes=idCliente;
		this.escribirUltimaId(idCliente);
		/*-------------------------------------------*/
		this.cuentas=new Vector<CuentaImp>(0,1);
		this.observaciones=null;
	}
	
	public ClienteImp(String nombre,int edad,String dni,char sexo,String observaciones) throws ExcepcionPersona{
		super(nombre,edad,dni,sexo);
		/*Estas 4 lineas son para obtener el idCliente*/
		if(contadorclientes!=0){
			idCliente=contadorclientes+1;
			}
		else{
			idCliente=this.cogerUltimaId()+1;
			}
		contadorclientes=idCliente;
		this.escribirUltimaId(idCliente);
		/*-------------------------------------------*/
		this.cuentas=new Vector<CuentaImp>(0,1);
		this.observaciones=observaciones;
	}
	
	/*----------------*/
	
	/***************
	 **Consultores**
	 ***************/
	
	public long getIdCliente(){
		return this.idCliente;
	}
	
	public String getObservaciones(){
		return this.observaciones;
	}
	
	public Vector<CuentaImp> getCuentas(){
		return this.cuentas;
	}
	
	/*---------------
	 * Modificadores-
	 * --------------
	 * */
	
	public void addCuenta(CuentaImp c){
		this.cuentas.add(c);
	}
	
	public void setObservaciones(String observaciones){
		this.observaciones=observaciones;
	}
	
	
	
	/*Metodos aï¿½adidos*/

	
	
	public long cogerUltimaId(){
		long id=0;
		File f=new File("idclientes.dat");

		
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
		else{
			
		}
		
		return id;
	}
	
	/*escribir ultima id*/
	
	public void escribirUltimaId(long id){
		File f=null;
		FileOutputStream fos= null;
		ObjectOutputStream oos=null;
		try{
			f=new File("idclientes.dat");
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
	/*----------------*/

	@Override
	public String toString() {
		String cuenta="";
		for(int i=0;i<cuentas.size();i++){
			cuenta=cuenta.concat(cuentas.elementAt(i).toString())+"\n";
		}
		return "Nombre cliente: "+getNombre()+", IdCliente: " + idCliente + "\ncuentas:" + cuenta + "\n observaciones: " + observaciones + "\n\n--------------------------------";
	}

	
	/*
	 * CompareTo
	 * Breve comentario:
	 * 	 Este metodo recibe y se compara con un objeto ClienteImp,
	 * 		se comparara por el id del Cliente.
	 * 			Si el idCliente propio es mayor al que recibe entonces retornara 1
	 * 			Si el idCliente propio es menor al que recibe entonces retornara -1
	 * 			en otro caso retornara 0.
	 * Cabecera:
	 * 		int compareTo(ClienteImp c)
	 * Precondiciones;
	 * 		nada
	 * Entradas:
	 * 		Un objeto ClienteImp
	 * Salidas:
	 * 		un entero
	 * Postcondiciones;
	 * 		el entero retornara asociado al nombre -> Funcion.
	 * 															
	 * 		
	 * */
	@Override
	public int compareTo(ClienteImp c) {
		int comparado=0;
		if(this.idCliente>c.getIdCliente()){
			comparado=1;
		}
		else if (this.idCliente<c.getIdCliente()){
			comparado=-1;
		}
		return comparado;
	}
	
	/*
	 * 
	 * */
	@Override
	public ClienteImp clone(){
		ClienteImp copia=null;
		//copia=(ClienteImp) super().clone();
		try
		{
			copia = (ClienteImp) super.clone();
		}
		catch (CloneNotSupportedException error)
		{
			System.out.println("Objeto no clonado");
		}
		return copia;
	}
	
	
}

