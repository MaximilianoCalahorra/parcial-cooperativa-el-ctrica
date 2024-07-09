package dao;

import datos.Inspector;

///Clase InspectorDao:
public class InspectorDao extends Dao<Inspector>
{
	//Atributo:
	private static InspectorDao instancia = null;
	
	//Constructor:
	protected InspectorDao() {}
	
	//Obtener instancia:
	public static InspectorDao getInstance() 
	{
		if(instancia == null) 
		{
			instancia = new InspectorDao();
		}
		return instancia;
	}
}
