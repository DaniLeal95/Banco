package cajero;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TestCuentaImp {

	public static void main(String[] args) {
		File f = null;

		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		
		GestionFicherosCuenta gf=new GestionFicherosCuenta();

		try {
			
			CuentaImp cuenta1 = new CuentaImp(500);
			// Abrir fichero para escribir
			f = new File("CuentaMaestro.dat");
			fos = new FileOutputStream(f.getAbsoluteFile());
			oos = new ObjectOutputStream(fos);
			
		
		} catch (IOException ioe) {
			System.out.println(ioe);
		}

		finally {
			if (oos != null) {
				try {
					// Cerrar fichero
					oos.close();
				} catch (IOException e) {

					System.out.println(e);
				}
			}

		}

			
			
		
		
		
		

	}

}
