package gestionyutilidades;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import cajero.MiObjectOutputStream;
import datos.ClienteImp;
import datos.CuentaImp;

public class Utilidades {

	/*
	 * Sacar dinero
	 * 
	 * 
	 * */
	public void movimientocon1cuenta(CuentaImp c, int saldo){
		File fmaestro=new File("ClientesMaestro.dat");
		File fmovimiento=new File("ClientesMovimiento.dat");
		//PARA LEER
		FileInputStream fismae=null;
		FileInputStream fismov=null;
		ObjectInputStream oismov=null;
		ObjectInputStream oismae=null;
		//PARA ESCRIBIR
		FileOutputStream fos=null;
		MiObjectOutputStream moos=null; //Declaro los dos porque en el primer caso if si no hay archivo de movimiento lo tengo que crear con cabecera.
		ObjectOutputStream oos=null;
		
		boolean encontrado=false;//este indicador lo utilizo por si encuentra la cuenta en cuestion deje de buscar, solo sirve
								 //para el fichero maestro.
		
		//CUENTA AUXILIAR
		CuentaImp aux=null;
		
		if(!fmovimiento.exists()){
			
			try{
				fismae=new FileInputStream(fmaestro);		//Si el archivo de movimientos no existe, solo tenemos que mirar en el maestro
				oismae=new ObjectInputStream(fismae);
				
				fos=new FileOutputStream(fmovimiento);
				oos=new ObjectOutputStream(fos);
				
				aux=(CuentaImp)oismae.readObject();
				
				while(aux!=null && encontrado==false){
					if(aux.getNumCuenta()==c.getNumCuenta()){
						c.setSaldo(aux.getSaldo()+saldo);
						oos.writeObject(c);
						encontrado=true;
					}
					aux=(CuentaImp)oismae.readObject();
				}
			}catch(EOFException eofe){
				System.out.println();
			}catch(IOException ioe){
				System.out.println(ioe);
			} catch (ClassNotFoundException e) {
				System.out.println(e);
			}finally{
				try{
					oismae.close();
					fismae.close();
					oos.close();
					fos.close();
				}catch(IOException ioe){
					System.out.println(ioe);
				}
			}
			
		}//Fin if
		else{
			//ahora primero miramos en el de movimientos
			try{
				fismov=new FileInputStream(fmovimiento);
				oismov=new ObjectInputStream(fismov);
				
				fos=new FileOutputStream(fmovimiento,true);
				moos= new MiObjectOutputStream(fos);
				
				aux=(CuentaImp)oismov.readObject();
				CuentaImp aux2=null;
				while(aux!=null){
					if(c.getNumCuenta()==aux.getNumCuenta()){
						//c.setSaldo(c.getSaldo()+saldo);
						if(aux!=null){
							aux2=aux;		//Hago esta condicion, porque en el fichero puede haber mas de un movimiento de la 
							encontrado=true;				//misma cuenta
						}
						aux=(CuentaImp)oismov.readObject();
					
					}
				}
				if(aux2!=null){
					c.setSaldo(aux2.getSaldo()+saldo);
				}
				if (!encontrado) {

					fismae = new FileInputStream(fmaestro); // Si el archivo de
															// movimientos no
															// existe, solo
															// tenemos que mirar
															// en el maestro
					oismae = new ObjectInputStream(fismae);

				

					aux = (CuentaImp) oismae.readObject();
					while (aux != null && encontrado == false) {
						if (aux.getNumCuenta() == c.getNumCuenta()) {
							c.setSaldo(aux.getSaldo() + saldo);
							moos.writeObject(c);
							encontrado = true;
						}
						aux = (CuentaImp) oismae.readObject();
					}

				}
				
			}catch(EOFException eofe){
				System.out.println();
			}catch(ClassNotFoundException cnfe){
				System.out.println(cnfe);
			}catch(IOException ioe){
				System.out.println(ioe);
			}finally{
				try{
					if(oismae!=null){
						oismae.close();
						fismae.close();
					}
					if(oismov!=null){
						oismov.close();
						fismov.close();
					}
					if(moos!=null){
						moos.close();
						fos.close();
					}
				}catch(IOException ioe){
					System.out.println(ioe);
				}
			}
			
			
		}
	}
}
