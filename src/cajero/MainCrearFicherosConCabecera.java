package cajero;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.GregorianCalendar;

import datos.ClienteImp;
import datos.CuentaImp;
import datos.TarjetaImp;

public class MainCrearFicherosConCabecera {

	public static void main(String[] args) {
		File f = null;
		File fmov = null;
		FileOutputStream fos = null;
		FileOutputStream fosmov=null;
		ObjectOutputStream oos = null;
		ObjectOutputStream oosmov=null;
		

		try {
			
			// Abrir fichero para escribir
			f = new File("ClientesMaestro.dat");
			fos = new FileOutputStream(f);
			oos = new ObjectOutputStream(fos);
			fmov=new File("ClientesMovimiento.dat");
			fosmov= new FileOutputStream(fmov);
			oosmov= new ObjectOutputStream(fosmov);
			/*
			 * Meto Un ciente 
			 * */
			TarjetaImp t1=new TarjetaImp('D');
			TarjetaImp t3=new TarjetaImp('C');
			CuentaImp c2=new CuentaImp(900);
			
			c2.setTarjeta(t1);
			c2.setTarjeta(t3);
			
			GregorianCalendar fnacimiento=new GregorianCalendar(1995, 12, 10);
			
			
			
			ClienteImp cl1 = new ClienteImp("Daniel", "Leal","Reyes",fnacimiento,"53284930W",'H',"Este tio es el amo");
			
			
			
			cl1.addCuenta(c2);
			System.out.println(cl1.toString());
			/*
			 * Y ahora una cuenta en movimiento
			 * */
			
			CuentaImp c1=new CuentaImp(c2,700);
			
			
			oos.writeObject(cl1);
			oosmov.writeObject(c1);
			
		} catch (IOException ioe) {
			System.out.println(ioe);
		} catch (ExcepcionPersona e) {
			e.printStackTrace();
		}

		finally {
				try {
					// Cerrar fichero
					oos.close();
					fos.close();
					
					oosmov.close();
					fosmov.close();
				} catch (IOException e) {

					System.out.println(e);
				}
			}

		}

}


