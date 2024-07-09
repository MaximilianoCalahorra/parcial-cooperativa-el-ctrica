package dao;

import datos.Persona;
import java.util.List;
import java.util.ArrayList;

///Clase PersonaDao:
public class PersonaDao extends Dao<Persona>
{
	//Atributo:
	private static PersonaDao instancia = null;
	
	//Constructor:
	protected PersonaDao() {}
	
	//Obtener instancia:
	public static PersonaDao getInstance() 
	{
		if(instancia == null) 
		{
			instancia = new PersonaDao();
		}
		return instancia;
	}
	
	//Traer:
	//CU 1:
	public List<Persona> traerPersonas()
	{
		List<Persona> personas = new ArrayList<Persona>();
		try 
		{
			iniciaOperacion();
			personas = session.createQuery("FROM Persona", Persona.class).list();
		}
		finally 
		{
			session.close();
		}
		return personas;
	}
}
