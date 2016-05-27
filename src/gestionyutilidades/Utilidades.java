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
		FileInputStream fis=null;
		ObjectInputStream ois=null;
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
				fis=new FileInputStream(fmaestro);		//Si el archivo de movimientos no existe, solo tenemos que mirar en el maestro
				ois=new ObjectInputStream(fis);
				
				fos=new FileOutputStream(fmovimiento);
				oos=new ObjectOutputStream(fos);
				
				aux=(CuentaImp)ois.readObject();
				while(aux!=null && encontrado==false){
					if(aux.getNumCuenta()==c.getNumCuenta()){
						c.setSaldo(aux.getSaldo()+saldo);
						oos.writeObject(c);
						encontrado=true;
					}
					aux=(CuentaImp)ois.readObject();
				}
			}catch(EOFException eofe){
				System.out.println();
			}catch(IOException ioe){
				System.out.println(ioe);
			} catch (ClassNotFoundException e) {
				System.out.println(e);
			}finally{
				try{
					ois.close();
					fis.close();
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
				fis=new FileInputStream(fmovimiento);
				ois=new ObjectInputStream(fis);
				
				fos=new FileOutputStream(fmovimiento);
				moos= new MiObjectOutputStream(fos);
				
				aux=(CuentaImp)ois.readObject();
				CuentaImp aux2=null;
				while(aux!=null){
					if(c.getNumCuenta()==aux.getNumCuenta()){
						c.setSaldo(c.getSaldo()+saldo);
						aux=(CuentaImp)ois.readObject();
						if(aux!=null){
							aux2=aux;		//Hago esta condicion, porque en el fichero puede haber mas de un movimiento de la 
							encontrado=true;				//misma cuenta
						}
					}
				}
				if(aux2!=null){
					c.setSaldo(aux2.getSaldo()+saldo);
				}
				if (!encontrado) {

					fis = new FileInputStream(fmaestro); // Si el archivo de
															// movimientos no
															// existe, solo
															// tenemos que mirar
															// en el maestro
					ois = new ObjectInputStream(fis);

				

					aux = (CuentaImp) ois.readObject();
					while (aux != null && encontrado == false) {
						if (aux.getNumCuenta() == c.getNumCuenta()) {
							c.setSaldo(aux.getSaldo() + saldo);
							oos.writeObject(c);
							encontrado = true;
						}
						aux = (CuentaImp) ois.readObject();
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
					ois.close();
					fis.close();
					moos.close();
					fos.close();
				}catch(IOException ioe){
					System.out.println(ioe);
				}
			}
			
			
		}
	}
}
