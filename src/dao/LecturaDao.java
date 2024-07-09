package dao;

import datos.Lectura;
import datos.MedidorAlta;
import java.util.List;
import java.util.ArrayList;

///Clase LecturaDao:
public class LecturaDao extends Dao<Lectura>
{
	//Atributo:
	private static LecturaDao instancia = null;
	
	//Constructor:
	protected LecturaDao() {}
	
	//Obtener instancia:
	public static LecturaDao getInstance() 
	{
		if(instancia == null) 
		{
			instancia = new LecturaDao();
		}
		return instancia;
	}
	
	//Traer:
	//CU 7:
	public List<Lectura> traerLecturas()
	{
		List<Lectura> lecturas = new ArrayList<Lectura>();
		try 
		{
			iniciaOperacion();
			String hql = "FROM Lectura l "
					   + "INNER JOIN FETCH l.medidorAlta ma INNER JOIN FETCH l.inspector INNER JOIN FETCH l.consumo INNER JOIN FETCH ma.cliente";
			lecturas = session.createQuery(hql, Lectura.class).list();
		}
		finally 
		{
			session.close();
		}
		return lecturas;
	}
	
	//CU 8:
	public List<Lectura> traerLecturas(MedidorAlta ma)
	{
		List<Lectura> lecturas = new ArrayList<Lectura>();
		try 
		{
			iniciaOperacion();
			String hql = "FROM Lectura l "
					   + "INNER JOIN FETCH l.medidorAlta ma INNER JOIN FETCH l.inspector INNER JOIN FETCH l.consumo INNER JOIN FETCH ma.cliente "
					   + "WHERE ma.idMedidorAlta = :idMedidorAlta";
			lecturas = session.createQuery(hql, Lectura.class).setParameter("idMedidorAlta", ma.getIdMedidorAlta()).list();
		}
		finally 
		{
			session.close();
		}
		return lecturas;
	}
	
	//CU 9:
	public Lectura traerLectura(MedidorAlta ma, int mes, int anio) 
	{
		Lectura lectura = null;
		try 
		{
			iniciaOperacion();
			String mesAdecuado = Integer.toString(mes);
			if(mes < 10) 
			{
				mesAdecuado = "0" + mes;
			}
			String hql = "FROM Lectura l "
			           + "INNER JOIN FETCH l.medidorAlta ma INNER JOIN FETCH l.inspector INNER JOIN FETCH l.consumo INNER JOIN FETCH ma.cliente "
			           + "WHERE ma.idMedidorAlta = :idMedidorAlta AND l.fecha LIKE CONCAT(:anio, '-', :mesAdecuado, '-%')";
			lectura = (Lectura) session.createQuery(hql)
					.setParameter("idMedidorAlta", ma.getIdMedidorAlta()).setParameter("mesAdecuado", mesAdecuado).setParameter("anio", anio)
			        .uniqueResult();
		}
		finally 
		{
			session.close();
		}
		return lectura;
	}
}
