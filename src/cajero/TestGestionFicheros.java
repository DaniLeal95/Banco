package cajero;

public class TestGestionFicheros {

	public static void main(String[] args) {
		GestionFicherosCuenta gf=new GestionFicherosCuenta();

		CuentaImp c2 = new CuentaImp(500);
		CuentaImp c3=new CuentaImp(700);
		CuentaImp c4=new CuentaImp(900);
		
		gf.escribirMaestro(c2);
		gf.escribirMaestro(c3);
		gf.escribirMaestro(c4);
		
		gf.mostrarFichero();
	}

}
