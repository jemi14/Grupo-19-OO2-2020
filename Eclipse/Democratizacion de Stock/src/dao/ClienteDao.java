package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Cliente;

public class ClienteDao {
	private static Session session;
	private Transaction tx;
	
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("Error en la capa de acceso a datos", he);
	}
	
	//agrega cliente a clase "cliente"
	
	public int agregar(Cliente objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	}
	
	//actualizar cliente de la clase "cliente"
	
	public void actualizar(Cliente objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}
	
	//eliminar cliente de la clase "Cliente"
	
	public void eliminar(Cliente objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}
	
	//traer cliente de la clase "cliente"
	
	public Cliente traerCliente(int idCliente) throws HibernateException {
		Cliente objeto = null;
		try {
			iniciaOperacion();
			objeto = (Cliente) session.get(Cliente.class, idCliente);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	
	public List<Cliente> traerCliente() throws HibernateException {
		List<Cliente> lista=null;
		try {
			iniciaOperacion();
			lista=session.createQuery("from Cliente c order by c.nroCliente asc").list();
		} finally {
			session.close();
		}
		return lista;
	}
	
	

}