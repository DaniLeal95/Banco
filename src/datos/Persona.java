package datos;

import java.util.GregorianCalendar;

/*
 * Clase Persona
 * 
 * Propiedades:
 * edad: entero, consultable, modificable
 * nombre: cadena, consultable
 * apellido1: cadena, consultable
 * apellido2: cadena, consultable
 * FNacimiento: GregorianCalendar, consultable
 * dni: cadena, consultable
 * telefono: cadena, consultable, modificable
 * direccion: cadena, consultable, modificable
 * genero: caracter, consultable

 * 
 * Interfaz:
 * 
 * getEdad()
 * getNombre()
 * getApellido1()
 * getApellido2()
 * getDni()
 * getTelefono()
 * getDireccion()
 * getGenero()
 * getPersona()
 * getFNacimiento()

 * 
 * setEdad(int edad)
 * setTelefono(String telefono)
 * setDireccion(String direccion)
 */

public interface Persona
{

	 int getEdad();
	 String getNombre();
	 String getApellido1();
	 String getApellido2();
	 String getDni();
	 String getTelefono();
	 String getDireccion();
	 char getGenero();
	 String getPersona();
	 GregorianCalendar getFNacimiento();
	
	 void setEdad(int edad) throws PersonaNoValida;
	 void setTelefono(String telefono) throws PersonaNoValida;
	 void setDireccion(String direccion);
}
