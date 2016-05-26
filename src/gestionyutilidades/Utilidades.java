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
		
		//CUENTA AUXILIAR
		CuentaImp aux=null;
		if(!fmovimiento.exists()){
			boolean encontrado=false;
			try{
				fis=new FileInputStream(fmaestro);		//Si el archivo de movimientos no existe, solo tenemos que mirar en el maestro
				ois=new ObjectInputStream(fis);
				
				fos=new FileOutputStream(fmovimiento);
				oos=new ObjectOutputStream(fos);
				
				aux=(CuentaImp)ois.readObject();
				while(aux!=null && encontrado==false){
					if(aux.getNumCuenta()==c.getNumCuenta()){
						c.setSaldo(c.getSaldo()+saldo);
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
			
			/*AQUI ME QUEDO FALTA LEER EL ARCHIVO MOVIMIENTOS , MAESTRO Y ESCRIBIR EN EL DE MOVIMIENTOS */
			
			
		}
	}
}
