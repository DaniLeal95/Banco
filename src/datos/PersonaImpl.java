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

public class PersonaImpl implements Persona, Serializable, Cloneable,Comparable<PersonaImpl> {
	
	//Atributos


	private String nombre;
	private String apellido1;
	private String apellido2;
	private int edad;
	private String dni;
	private char genero;
	private String telefono;
	private String direccion;
	private String curso;
	private GregorianCalendar FNacimiento;

	
	
	//constructor por defecto
	public PersonaImpl()
	{	

		nombre= null;
		apellido1= null;
		apellido2= null;
		edad=0;
		dni= null;
		genero=' ';
		telefono= null;
		direccion= null;
		FNacimiento= null;

	}
	
	//constructor con algunos atributos
	public PersonaImpl(String nombre,String apellido1,String apellido2,GregorianCalendar Fnacimiento,String dni,char genero){
		this.nombre=nombre;
		this.apellido1=apellido1;
		this.apellido2=apellido2;
		this.FNacimiento=Fnacimiento;
		this.dni=dni;
		this.genero=genero;
	}
	
	
	//constructor copia
	public PersonaImpl(PersonaImpl a)
	{

		this.nombre= a.nombre;
		this.apellido1= a.apellido1;
		this.apellido2= a.apellido2;
		this.FNacimiento= a.FNacimiento;
		this.edad= a.edad;
		this.dni= a.dni;
		this.genero= a.genero;
		this.telefono= a.telefono;
		this.direccion= a.direccion;

	}
	
	//constructor por parametros
	public PersonaImpl(String nombre, String apellido1, String apellido2, GregorianCalendar FNacimiento, int edad, String dni, char genero, String telefono, String direccion, double sueldo) throws PersonaNoValida
	{
		genero= Character.toUpperCase(genero);
		if (edad<0)
		{
			throw new PersonaNoValida("edad no puede ser menor que 0");
		}
		else 
			if(dni.length()!=9)
			{
				throw new PersonaNoValida("el DNI debe tener 9 caracteres");
			}
			else
				if(genero!='M' && genero!='H')
				{
					throw new PersonaNoValida ("el genero debe ser M o H");
				}
				else
					if (telefono.length()!=9)
					{
						throw new PersonaNoValida("el telefono debe tener 9 caracteres");
					}
					else
						if(sueldo<0)
						{
							throw new PersonaNoValida("el sueldo no puede ser menor a 0");
						}	
					{
						
						this.nombre=nombre;
						this.apellido1= apellido1;
						this.apellido2= apellido2;
						this.FNacimiento= FNacimiento;
						this.edad= edad;
						this.genero= genero;
						this.dni= dni;
						this.direccion= direccion;
						this.telefono= telefono;
					}
	}
	
	//metodos consultores

	
	public int getEdad()
	{
		return edad;
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public String getApellido1()
	{
		return apellido1;
	}
	
	public String getApellido2()
	{
		return apellido2;
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
	

		
	public String getPersona()
	{

		String s;
		return s= (this.getNombre()+","+this.getApellido1()+","+this.getApellido2()+","+this.getEdad()+","+this.getGenero()+","+this.getDni()+","+this.getDireccion()+","+this.getTelefono());
				
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
	 
	
		 
	 
	 public void setAlumno (String nombre, String apellido1, String apellido2, GregorianCalendar FNacimiento, int edad, String dni, char genero, String telefono, String direccion) throws PersonaNoValida
	 {
		 this.nombre= nombre;
		 this.apellido1= apellido1;
		 this.apellido2= apellido2;
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
	 
	 //Metodo equals (seran iguales si tienen el mismo numero de codigo)
	 @Override
	 public boolean equals(Object o)
	 {
		 boolean igual= false;
		 if(o!= null && o instanceof PersonaImpl)
		 {
			 PersonaImpl a= (PersonaImpl) o;
			 if(this.dni == a.dni)
				 igual= true;
		 }
		 return igual;
	 }
	 
	 //Metodo toString
	 @Override
	 public String toString()
	 {
		 String s= ("\nNombre: "+this.getNombre()+"\nPrimer apellido: "+this.getApellido1()+"\nSegundo apellido: "+this.getApellido2()+"\nFecha de nacimiento: "+this.getFNacimiento()+"\nEdad: "+this.getEdad()+"\nGenero: "+this.getGenero()+"\nDni: "+this.getDni()+"\nTelefono: "+this.getTelefono()+"\nDireccion: "+this.getDireccion());
		 return s;
	 }
	 
	 //Metodo hashCode
	 @Override
	 public int hashCode()
	 {
		// return (int)(this.getDni()+110120203);
		 return 0;
	 }
	 
	 //Metodo Clone
	 public PersonaImpl clone()
	 {
		 PersonaImpl copia= null;
		 try
		 {
			 copia= (PersonaImpl) super.clone();
		 }
		 catch(CloneNotSupportedException e)
		 {
			 System.out.println(e);
		 }
		 return copia;
	 }
	 @Override
	 //Metodo compareTo (compara por la fecha de nacimiento de alumno: 0 si son iguales, -1 si es mayor nuestro propio objeto, 1 si es menor el objeto que nos pasan por parametros)
	 public int compareTo(PersonaImpl a)
	 {
		 int comparar= 0;
		 if(this.FNacimiento.before(a.FNacimiento))
		 {
			 comparar=-1;
		 }
		 else
		 if (this.FNacimiento.after(a.FNacimiento))
		 {
			 comparar= 1;
		 }
		 
		 return comparar;
	 }
	

}//fin clase alumno

