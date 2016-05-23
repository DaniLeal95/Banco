package gestionyutilidades;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import cajero.MiObjectOutputStream;
import datos.ClienteImp;
import datos.CuentaImp;

public class GestionFicheros {
	/*
	 * Metodo mostrarFicheromaestro
	 * 	Breve Comentario:
	 * 		Este metodo mostrara por pantalla todos los clientes que tenemos registrados en el fichero
	 * 		
	 * 	Cabecera:
	 * 		void mostrarFicheromaestro()
	 * 	Precondiciones:
	 * 		el fichero debera estar creado, de no estarlo saltara una excepcion de fichero no encontrado
	 * 	Entradas:
	 * 		El nombre del fichero
	 * 	Salidas:
	 * 		Nada
	 * 	Postcondiciones:
	 * 		Nada
	 * */
	public void mostrarFicheromaestro(){
		File f=null;
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		try{
			f=new File("ClientesMaestro.dat");
			fis=new FileInputStream(f);
			ois=new ObjectInputStream(fis);
			
			Object cliente=(ClienteImp)ois.readObject();
			while(cliente!=null){
			System.out.println(cliente.toString());
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
		
	}
	
	/*
	 * Obtener cuenta.
	 * 
	 * 	Breve comentario:
	 * 		Este metodo retornara una cuenta , dadas una id de cliente 
	 * 		y una id de cuenta
	 * 	Cabecera:
	 * 		CuentaImp obtenerCuenta(long idCliente,long idCuenta)
	 * 	Precondiciones:
	 * 		Nada, si no encuentra ninguna cuenta con esas id retornara null.
	 * 			
	 * 	Entradas:
	 * 		dos long con las ids de cliente y cuenta
	 * 	Salidas:
	 * 		Un objeto CuentaImp
	 * 	Postcondiciones:
	 * 		El objeto CuentaImp retornara asociado al nombre, funcion
	 * 
	 * 
	 * */
	public CuentaImp obtenerCuenta(long idCliente,long idCuenta){
		CuentaImp cuenta=null;
		
		File f=null;
		File fmov=null;
		FileInputStream fis=null;
		FileInputStream fismov=null;
		ObjectInputStream ois=null;
		ObjectInputStream oismov=null;
		boolean encontrado=false;
		ClienteImp aux=null;
		CuentaImp auxc=null;
		try{
			f= new File("ClientesMaestro.dat");
			fmov=new File("ClientesMovimiento.dat");
			fis=new FileInputStream(f);
			fismov=new FileInputStream(fmov);
			ois=new ObjectInputStream(fis);
			oismov=new ObjectInputStream(fismov);
				
			
			/*Si el fichero de movimiento no existe, no necesitamos mirar en el.
			 * Solo tendremos que buscar en el maestro,
			 * */
			if(!fmov.exists()){
			aux=(ClienteImp)ois.readObject();
				while(aux!=null && encontrado==false){
					if(aux.getIdCliente()==idCliente){
						
						for(int i=0;i<aux.getCuentas().size();i++){
							
							if(aux.getCuentas().elementAt(i).getNumCuenta()==idCuenta){
								cuenta=aux.getCuentas().elementAt(i);
								encontrado=true;
							}
						}
					}
					aux=(ClienteImp)ois.readObject();
				}
			}
			/*Si el fichero de movimientos si existe tenemos que mirar en los dos
			 * ficheros ,primero en el de movimiento y luego si en el de movimiento
			 *  no lo encuentra mirara en el maestro.
			 *  Si no el objeto quedara null;
			 * */
			else{
				auxc=(CuentaImp)oismov.readObject();
				/*Recorro el fichero entero porque puede haber mas de un movimiento
				 * entonces me interesa mirar todos los clientes ingresados 
				 * */
				while(auxc!=null){
					if(auxc.getNumCuenta()==idCuenta){
								cuenta=auxc;
								encontrado=true;
					}	
					aux=(ClienteImp)oismov.readObject();
				}
				/*Si no se a encontrado el cliente en el de movimientos
				 * 	miraremos en el maestro
				 * */
				
				if(!encontrado){
					aux=(ClienteImp)ois.readObject();
					while(aux!=null && !encontrado){
						if(aux.getIdCliente()==idCliente){
							
							for(int i=0;i<aux.getCuentas().size();i++){
								
								if(aux.getCuentas().elementAt(i).getNumCuenta()==idCuenta){
									cuenta=aux.getCuentas().elementAt(i);
									encontrado=true;
								}
							}
							
						}	
						aux=(ClienteImp)ois.readObject();
					}
				}
			}
			
		}catch(IOException ioe){
			System.out.println(ioe);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		return cuenta;
	}
	
	
	/*Escribir Fichero ClienteMaestro
	 * 	Breve comentario:
	 * 		El metodo escribirá en el fichero ClienteMaestro un objeto clienteImp que recibirá por parametros 
	 * 	Cabecera:
	 * 		void escribirCliente(ClienteImp cliente)
	 * 	Precondiciones:
	 * 		Nada
	 * 	Entradas:
	 * 		un objeto ClienteImp
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
	
	/*Escribir Fichero ClienteMaestro
	 * 	Breve comentario:
	 * 		El metodo escribirá en el fichero ("ClientesMovimiento.dat") un objeto Cuenta que recibirá por parametros 
	 * 	Cabecera:
	 * 		void escribirCliente(ClienteImp cliente)
	 * 	Precondiciones:
	 * 		Nada
	 * 	Entradas:
	 * 		un objeto CuentaImp
	 * 	Salidas:
	 * 		Nada 
	 * 	Postcondiciones:
	 * 		Escribirá el objeto en el fichero.
	 * */
	public void escribirMovimiento(CuentaImp c){
		
		File f=null;
		FileOutputStream fos=null;
		MiObjectOutputStream moos=null;
		
		try{
			f=new File("ClientesMovimiento.dat");
			fos=new FileOutputStream(f,true);
			moos=new MiObjectOutputStream(fos);
			
			moos.writeObject(c);
		}catch(IOException ioe){
			System.out.println(ioe);
		}finally{
			try{
				fos.close();
				moos.close();
			}catch(IOException ioe){
				System.out.println(ioe);
			}
		}
		
	}
	/*
	 * Mostrar fichero movimientos
	 * 	Breve Comentario:
	 * 		Este metodo mostrara por pantalla todos los movimientos que tenemos registrados en el fichero de movimientos
	 * 		
	 * 	Cabecera:
	 * 		 void mostrarFicheromovimiento()
	 * 	Precondiciones:
	 * 		el fichero debera estar creado, de no estarlo saltara una excepcion de fichero no encontrado
	 * 	Entradas:
	 * 		Nada
	 * 	Salidas:
	 * 		Nada
	 * 	Postcondiciones:
	 * 		Nada
	 * */
	public void mostrarFicheromovimiento(){
		File f=null;
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		try{
			f=new File("ClientesMovimiento.dat");
			fis=new FileInputStream(f);
			ois=new ObjectInputStream(fis);
			
			CuentaImp cliente=(CuentaImp)ois.readObject();
			while(cliente!=null){
			System.out.println(cliente.toString());
			cliente=(CuentaImp)ois.readObject();
			
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

	public void actualizaClientes() {
		
		File fmaestro = new File("ClientesMaestro.dat");
		File fmovimiento = new File("ClientesMovimiento.dat");
		File fmaestronuevo = new File("ClientesMaestroNuevo.dat");
		// Para leer maestro
		FileInputStream fism = null;
		ObjectInputStream oism = null;
		// Para leer movimientos
		FileInputStream fismo = null;
		ObjectInputStream oismo = null;

		// Para escribir
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		int numregistros;

		if (fmaestro.exists() && fmovimiento.exists()) {
			numregistros = this.contarRegistros("ClientesMaestro.dat");
			try {

				// Abrimos para leer el archivo maestro
				fism = new FileInputStream(fmaestro);
				oism = new ObjectInputStream(fism);
				// Abrimos para leer el archivo movimiento
				fismo = new FileInputStream(fmovimiento);
				oismo = new ObjectInputStream(fismo);
				// Abrimos para escribir en el nuevo archivo maestro
				fos = new FileOutputStream(fmaestronuevo);
				oos = new ObjectOutputStream(fos);

				// leemos el primero cliente del fichero maestro
				ClienteImp cmaestro = (ClienteImp) oism.readObject();

				for (int i = 0; i < numregistros; i++) {
					// Leemos el primer movimiento
					CuentaImp cmovimiento = (CuentaImp) oismo.readObject();
					while (cmovimiento != null) {

						for (int z = 0; z < cmaestro.getCuentas().size(); z++) {
							// Si el numero de cuenta es el mismo
							if (cmaestro.getCuentas().elementAt(z).getNumCuenta() == cmovimiento.getNumCuenta()) {

								// le damos al saldo Del Maestro el saldo que
								// hay en el de movimiento.
								cmaestro.getCuentas().elementAt(z).setSaldo(cmovimiento.getSaldo());
							}
						}
						// Volvemos a leer el siguiente movimiento
						cmovimiento = (CuentaImp) oismo.readObject();
					}

					// Escribimos el nuevo clienteMaestro
					oos.writeObject(cmaestro);
					cmaestro = (ClienteImp) oism.readObject();
				} // fin Para
					
				
				//Ahora eliminamos el antiguo archivo de Maestro
				fmaestro.delete();
				//y renombramos el archivo maestro nuevo con el nombre del antiguo
				fmaestronuevo.renameTo(fmaestro);
			} catch (IOException ioe) {
				System.out.println(ioe);
			} catch (ClassNotFoundException e) {
				System.out.println(e);
			} finally {
				try {
					fism.close();
					fismo.close();
					oism.close();
					oismo.close();
					fos.close();
					oos.close();
				} catch (IOException ioe) {
					System.out.println(ioe);
				}
			}

		}

	}
}