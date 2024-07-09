package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.lang.reflect.ParameterizedType;

///Clase Dao:
public abstract class Dao<T> 
{
	//Atributos:
	private Class<T> clasePersistente;
	protected static Session session;
    protected Transaction tx;
    
    //Constructor:
    @SuppressWarnings("unchecked")
	protected Dao()
    {  
        this.clasePersistente = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass())
        									.getActualTypeArguments()[0];
    } 
    
    //Obtener clase:
    public Class<T> getClasePersistente()
    {  
        return clasePersistente;  
    } 
    
    //Iniciar operación:
    protected void iniciaOperacion() throws HibernateException 
    {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    //Manejar excepción:
    protected void manejaExcepcion(HibernateException he) throws HibernateException 
    {
        tx.rollback();
        throw new HibernateException("ERROR en la capa de acceso a datos", he);
    }

    //Traer:
    public T traer(int idObjeto) throws HibernateException
    {
		T objeto = null;
		try 
        {
			iniciaOperacion();
			objeto = (T)session.get(clasePersistente, idObjeto);
		} 
        finally 
        {
			session.close();
		}
		return objeto;
	}
 	
    //Agregar:
 	public int agregar(T objeto) 
    {
 		int id = 0;
 		try 
        {
 			iniciaOperacion();
 			id = (int)session.save(objeto);
 			tx.commit();
 		} 
 		catch (HibernateException he) 
        {
 			manejaExcepcion(he);
 		} 
 		finally 
        {
 			session.close();
 		}
 		return id;
 	}
 	
    //Modificar:
 	public void modificar(T objeto) 
    {
        try
        {
            iniciaOperacion();
            session.update(objeto);
            tx.commit();
        }
        catch(HibernateException he)
        {
            manejaExcepcion(he);
        }
        finally
        {
            session.close();
        }
    }

    //Eliminar:
    public void eliminar(T objeto)
    {
        try
        {
            iniciaOperacion();
            session.delete(objeto);
            tx.commit();
        }
        catch(HibernateException he)
        {
            manejaExcepcion(he);
        }
        finally
        {
            session.close();
        }
    }
}