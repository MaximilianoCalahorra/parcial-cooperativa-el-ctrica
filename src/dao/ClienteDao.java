package dao;

import datos.Cliente;

///Clase ClienteDao:
public class ClienteDao extends Dao<Cliente>
{
	//Atributo:
	private static ClienteDao instancia = null;
	
	//Constructor:
	protected ClienteDao() {}
	
	//Obtener instancia:
	public static ClienteDao getInstance() 
	{
		if(instancia == null) 
		{
			instancia = new ClienteDao();
		}
		return instancia;
	}
}
