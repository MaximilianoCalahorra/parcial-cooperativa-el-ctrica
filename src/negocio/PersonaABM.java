package negocio;

import dao.PersonaDao;
import datos.Persona;
import java.util.List;

///Clase PersonaABM:
public class PersonaABM 
{
	//Atributo:
	private static PersonaABM instancia = null;
		
	//Constructor:
	protected PersonaABM() {}
		
	//Obtener instancia:
	public static PersonaABM getInstance() 
	{
		if(instancia == null) 
		{
			instancia = new PersonaABM();
		}
		return instancia;
	}
	
	//Traer:
	//CU 1:
	public List<Persona> traerPersonas()
	{
		return PersonaDao.getInstance().traerPersonas();
	}
	
	//CU 2:
	public Persona traerPersona(int idPersona)
	{
		return PersonaDao.getInstance().traer(idPersona);
	}
}
