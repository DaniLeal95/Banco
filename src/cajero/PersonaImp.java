package cajero;

public class PersonaImp implements Persona {

	/*
	 * Necesitamos:
	 * 	nombre -> Consultable y modificable
	 * 	edad -> Consultable
	 * 	DNI -> Consultable
	 * 	sexo -> Consultable y modificable
	 * 
	 *
	 * 	
	 */
	
	/*Atributos*/
	private String nombre;
	private int edad;
	private String dni;
	private char sexo;

	
	/*Constructores*/
	
	public PersonaImp(){
		nombre=null;
		edad=0;
		dni=null;
		sexo=' ';

	}
	public PersonaImp(String nombre,int edad,String dni,char sexo)throws ExcepcionPersona{
		
		this.nombre=nombre;
		
		if(edad<16)throw new ExcepcionPersona("No puede ser menor a 16 anios");
		else this.edad=edad;
		
		if(dni.length()!=9)throw new ExcepcionPersona("El dni debe ser de 9 cifras");
		else this.dni=dni;
		
		if(sexo!='H' && sexo!='M')throw new ExcepcionPersona("Solo Puede ser H o M");
		else this.sexo=sexo;
		
		}
	
	
	/* Consultores*/
	
	public String getNombre(){
		return this.nombre;
	}
	
	
	public int getEdad(){
		return this.edad;
	}

	public String getDni(){
	
		return this.dni;
	}

	public char getSexo(){
		return this.sexo;
	}
	
	
	//Modificadores

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEdad(int edad) throws ExcepcionPersona {
		
		if(edad<16)throw new ExcepcionPersona("No puede ser menor a 16 anios");
		else this.edad = edad;
	}

	public void setDni(String dni) throws ExcepcionPersona {
		if(dni.length()!=9)throw new ExcepcionPersona("El dni debe ser de 9 cifras");
		else this.dni=dni;
	}

	public void setSexo(char sexo) throws ExcepcionPersona {
		if(sexo!='H' && sexo!='M')throw new ExcepcionPersona("Solo Puede ser H o M");
		else this.sexo=sexo;
	}

	
	

		//HEREDACION DE OBJECT
	public String toString() {
		
		String s="(Nombre: "+this.nombre+",edad: "+this.edad+", dni: "+this.dni+", sexo: "+this.sexo+")";
		return s;
	}

}
