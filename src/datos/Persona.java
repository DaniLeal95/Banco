package datos;

import java.io.Serializable;
import java.util.GregorianCalendar;

/*
 * Clase Persona
 * 
 * Propiedades:
 * codigo: entero, consultable
 * edad: entero, consultable, modificable (Restricci�n: mayor o igual que 0
 * nombre: cadena, consultable
 * apellido1: cadena, consultable
 * apellido2: cadena, consultable
 * FNacimiento: Fecha, consultable
 * dni: cadena, consultable (Restricci�n: 9 caracteres)
 * telefono: cadena, consultable, modificable (Restricci�n: 9 caracteres)
 * direccion: cadena, consultable, modificable
 * genero: caracter, consultable (Restricci�n: M o H)

 * 
 * M�todos heredados:
 * equals()
 * toString()
 * hashCode()
 * comparable()
 * clone()
 */

public abstract class Persona implements Serializable {
	
	//Atributos compartidos
	private static final long serialVersionUID = 4007293735854407963L;
	//Atributos basicos
	private String nombre;
	private String apellido;
	private int edad;
	private String dni;
	private char genero;
	private String telefono;
	private String direccion;
	private GregorianCalendar FNacimiento;

	


	
	//metodos consultores

	
	public int getEdad()
	{
		return edad;
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public String getApellido()
	{
		return apellido;
	}
	
	
	
	public GregorianCalendar getFNacimiento()
	{
		return this.FNacimiento;
	}
	
	public char getGenero()
	{
		return genero;
	}
	
	public String getDni()
	{
		return dni;
	}
	
	public String getTelefono()
	{
		return telefono;
	}

	public String getDireccion()
	{
		return direccion;
	}
	

	/*getPersona
	 * Breve comentario: 
	 * 		el método devuelve un String con los valores de todos los atributos del cliente.
	 * Cabecera:
	 * 		String cuentatoCadena()
	 * precondiciones:
	 * 		 nada
	 * entrada:
	 * 		 nada
	 * salida:
	 * 		 un String
	 * postcondiciones:
	 * 		 el String retornara asociado  al nombre -> Funcion
	 */
	public String getPersona()
	{
		return (this.getNombre()+","+this.getApellido()+","+this.getEdad()+","+this.getGenero()+","+this.getDni()+","+this.getDireccion()+","+this.getTelefono());
	}
	
	//metodos modificadores
	
	public void setEdad (int edad) throws PersonaNoValida
	{
		if (edad<0)
		{
			throw new PersonaNoValida("La edad no puede ser menor que 0");
		}
		else
		{
			this.edad= edad;
		}
	}
	
		 
	 public void setTelefono(String telefono) throws PersonaNoValida
	 {
		if (telefono.length()!=9)
		{
			throw new PersonaNoValida("el telefono debe tener 9 caracteres");
		}
		else
		{
			this.telefono= telefono;
		}
	 }
	 
	 public void setDireccion(String direccion)
	 {
		 this.direccion= direccion;
	 }
	 
	
		 
	 
	 public void setAlumno (String nombre, String apellido, GregorianCalendar FNacimiento, int edad, String dni, char genero, String telefono, String direccion) throws PersonaNoValida
	 {
		 this.nombre= nombre;
		 this.apellido= apellido;
		 this.FNacimiento= FNacimiento;
		 if (edad<0)
			{
				throw new PersonaNoValida("La edad no puede ser menor que 0");
			}
			else
			{
		 this.edad= edad;
			}
		 if(dni.length()!=9)
			{
				throw new PersonaNoValida("el DNI debe tener 9 caracteres");
			}
			else
			{	
		 this.dni= dni;
			}	
		 if(genero!='M' && genero!='H')
			{
				throw new PersonaNoValida ("el genero debe ser M o H");
			}
		 	else
		 	{
		 this.genero= genero;
		 	}
		 if (telefono.length()!=9)
			{
				throw new PersonaNoValida("el telefono debe tener 9 caracteres");
			}
			else
			{
		 this.telefono= telefono;
			}
		 this.direccion= direccion;
	
	 }
	 
	 
	 //Metodos heredados

	 //Metodo toString
	 @Override
	 public String toString()
	 {
		 String s= ("\nNombre: "+this.getNombre()+"\nPrimer apellido: "+this.getApellido()+"\nFecha de nacimiento: "+this.getFNacimiento()+"\nEdad: "+this.getEdad()+"\nGenero: "+this.getGenero()+"\nDni: "+this.getDni()+"\nTelefono: "+this.getTelefono()+"\nDireccion: "+this.getDireccion());
		 return s;
	 }
	 
	 //Metodo hashCode
	 @Override
	 public int hashCode()
	 {
		 return (int)(this.edad+110120203+Integer.parseInt(this.dni));
	 }
	 



	

}//fin clase alumno

