package gestionyutilidades;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import cajero.MiObjectOutputStream;
import datos.ClienteImp;
import datos.CuentaImp;

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
	
	/*contarRegistros
	 * 
	 * Breve comentario:
	 * 		El metodo lee todo el fichero y retorna el numero de registros que hayan en el fichero cuyo nombre 
	 *  		se le  pasa por parametros
	 * 	Cabecera:
	 * 		int contarRegistros(String nombreFichero)
	 * 	Precondiciones:
	 * 		El fichero debera existir, en el caso de que no este creado saltara una excepcion(FILENOTFOUNDEXCEPTION)
	 * 	Entradas:
	 * 		el nombre del fichero(String)
	 * 	Salida:
	 * 		un entero numregistros
	 * 	Postcondiciones:
	 * 		el numregistros retornara asociado al nombre -> Funcion.
	 * 
	 * */
	
	public int contarRegistros(String nombreFichero){
		int registro=0;
		File f=null;
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		try{
			f=new File(nombreFichero);
			fis=new FileInputStream(f);
			ois=new ObjectInputStream(fis);
			
			Object c=(ClienteImp)ois.readObject();
		
			while(c!=null){
				registro++;
				c=(ClienteImp)ois.readObject();
			}
		}catch(FileNotFoundException fnfe){
			System.out.println("El fichero "+nombreFichero+" no existe");
		}catch(IOException ioe){
			System.out.println(ioe);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}finally{
			if(f!=null){
				try{
					ois.close();
					fis.close();
				}catch(IOException ioe){
					System.out.println(ioe);
				}
			}
		}
	
		return registro;
	}


/*
 * actualiza Clientes
 * 	Breve comentario: 
 * 		Este metodo mezcla dos archivos desordenados ( ClientesMaestro.dat y ClientesMovimientos.dat )
 * 			y los incluye en un archivo auxiliar mezclados
 * 	Cabecera:
 * 		void actulizaClientes()
 * 	Precondiciones:
 * 		nada
 * 	Entradas:
 * 		nada
 * 	Salidas:
 * 		El metodo escribirá en un archivo auxiliar
 * 	Postcondiciones:
 * 		El metodo escribira en un archivo auxiliar los datos de los dos archivos (maestro y movimientos) y los volcará 
 * 		sobre el auxiliar.
 * 
 * */

	public void actualizaClientes(){
		
		
		File fmaestro=new File("ClientesMaestro.dat");
		File fmovimiento=new File("ClientesMovimiento.dat");
		File fmaestronuevo=new File("ClientesMaestroNuevo.dat");
		// Para leer maestro
		FileInputStream fism=null;
		ObjectInputStream oism=null;
		FileInputStream fismo=null;
		ObjectInputStream oismo=null;
		
		// Para escribir
		FileOutputStream fos=null;
		ObjectOutputStream oos=null;
		
		int numregistros;

		
		if(fmaestro.exists() && fmovimiento.exists()){
			numregistros=this.contarRegistros("ClientesMaestro.dat");
			
			for(int i=0;i<numregistros;i++){
				try{
					//Abrimos para leer el archivo maestro
					fism=new FileInputStream(fmaestro);
					oism=new ObjectInputStream(fism);
					//Abrimos para leer el archivo movimiento
					fismo=new FileInputStream(fmovimiento);
					oismo=new ObjectInputStream(fismo);
					 
					ClienteImp cmaestro=(ClienteImp)oism.readObject();
					
					CuentaImp cmovimiento=(CuentaImp) oismo.readObject();
					while(cmovimiento!=null){
						
						for(int z=0;z<cmaestro.getCuentas().size();z++){
							//Si 
							if(cmaestro.getCuentas().elementAt(z).getNumCuenta()==cmovimiento.getNumCuenta()){
								
								
								cmaestro.getCuentas().elementAt(z).setSaldo(cmovimiento.getSaldo());
							}
							
							cmovimiento=(CuentaImp) oismo.readObject();
						}
					}
					fos=new FileOutputStream(fmaestronuevo);
					oos=new ObjectOutputStream(fos);
					
					//Escribimos el nuevo clienteMaestro
					oos.writeObject(cmaestro);
					
					
					
				}catch(IOException ioe){
					System.out.println(ioe);
				} catch (ClassNotFoundException e) {
					System.out.println(e);
				}finally{
					try{
						fism.close();
						fismo.close();
						oism.close();
						oismo.close();
					}catch(IOException ioe){
						System.out.println(ioe);
					}
				}
			}
			
		}
		
		
	}
}