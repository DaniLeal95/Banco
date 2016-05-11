package cajero;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Vector;

import com.sun.org.apache.bcel.internal.generic.NEW;

/*
 * Restricciones:
 * 		-Prestigio:
 * 		-----------
 * 			
 * 			Solo puede ser:  -> EXCELENTE (Son los clientes que tienen la media de sus cuentas con un saldo superior a 30.000 € )
 * 							 -> BUENO (Son los clientes que tienen la media de sus cuentas con un saldo entre 10.000€ y 29.999€)
 * 							 -> NORMAL (Son los clientes que tienen la media de sus cuentas con un saldo entre 3.000€ y 9.999€)
 * 							 -> REGULAR (Son los clientes que tienen la media de sus cuentas con un saldo entre 0€ y 2.999€)
 * 							 -> MALO (Son los clientes que tienen la media de sus cuenta con un saldo inferior a 0€)
 * 							o
 * 							 -> null Es cuando No tiene aun una cuenta asignada 
 * 
 * 
 * 
 * */

public class ClienteImp extends PersonaImp implements Cliente{
	/*-----------------------*/
	/*Atributos b�sicos*/
	private long idCliente;
	private Vector<CuentaImp> Cuentas;
	
	
	/*Atributos calculados*/
	private String prestigio;

	
	/*Atributos Compartidos*/
	public static long contadorclientes=0;
	/*----------------------*/
	
	/*Constructores*/
	public ClienteImp(){
		super();
		/*Estas 4 lineas son para obtener el idCliente*/
		if(contadorclientes!=0){idCliente=contadorclientes;}
		else{idCliente=this.cogerUltimaId()+1;}
		contadorclientes=idCliente;
		this.escribirUltimaId(idCliente);
		/*-------------------------------------------*/
		this.Cuentas=null;
		this.prestigio=null;
	}
	
	public ClienteImp(String nombre,int edad,String dni,char sexo) throws ExcepcionPersona{
		super(nombre,edad,dni,sexo);
		/*Estas 4 lineas son para obtener el idCliente*/
		if(contadorclientes!=0){idCliente=contadorclientes;}
		else{idCliente=this.cogerUltimaId()+1;}
		contadorclientes++;
		this.escribirUltimaId(idCliente);
		/*-------------------------------------------*/
		this.Cuentas=null;
		this.prestigio=null;
	}
	
	/*----------------*/
	
	/***************
	 **Consultores**
	 ***************/
	
	/*Metodos a�adidos*/
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
		}
	}
	/*----------------*/
}

