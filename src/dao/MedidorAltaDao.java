package dao;

import datos.MedidorAlta;
import java.util.List;
import java.util.ArrayList;

///Clase MedidorDao:
public class MedidorAltaDao extends Dao<MedidorAlta>
{
	//Atributo:
	private static MedidorAltaDao instancia = null;
	
	//Constructor:
	protected MedidorAltaDao() {}
	
	//Obtener instancia:
	public static MedidorAltaDao getInstance() 
	{
		if(instancia == null) 
		{
			instancia = new MedidorAltaDao();
		}
		return instancia;
	}
	
	//Traer:
	//CU 5:
	public List<MedidorAlta> traerMedidoresAlta()
	{
		 List<MedidorAlta> medidoresAlta = new ArrayList<MedidorAlta>();
		 try 
		 {
			 iniciaOperacion();
			 String hql = "FROM MedidorAlta ma "
			 		    + "INNER JOIN FETCH ma.cliente";
			 medidoresAlta = session.createQuery(hql,  MedidorAlta.class).list();
		 }
		 finally 
		 {
			 session.close();
		 }
		 return medidoresAlta;
	}
	
	//CU 6:
	public MedidorAlta traerMedidorAlta(int nroSerie) 
	{
		MedidorAlta medidorAlta = null;
		try 
		{
			iniciaOperacion();
			String hql = "FROM MedidorAlta ma "
					   + "INNER JOIN FETCH ma.cliente "
					   + "WHERE ma.nroSerie = :nroSerie";
			medidorAlta = (MedidorAlta)session.createQuery(hql).setParameter("nroSerie", nroSerie).uniqueResult();
		}
		finally 
		{
			session.close();
		}
		return medidorAlta;
	}
}
