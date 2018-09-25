package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Butaca;
import datos.Seccion;

public class ButacaDao {
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
	
	public int agregar(Butaca objeto) {
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
	
	public void actualizar(Butaca objeto) throws HibernateException {
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
	
	public void eliminar(Butaca objeto) throws HibernateException {
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
	
	public Butaca traerButaca(int idButaca) throws HibernateException {
		Butaca objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (Butaca) session.get(Butaca.class, idButaca);
		} finally {
			session.close();
		}
		
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Butaca> traerButaca() throws HibernateException {
		List<Butaca> butacas = null;
		
		try {
			iniciaOperacion();
			butacas = session.createQuery("from Butaca").list();
		} finally {
			session.close();
		}
		
		return butacas;
	}
	
	@SuppressWarnings("unchecked")
	public List<Butaca> traerButaca(Seccion seccion) throws HibernateException {
		List<Butaca> butacas = null;
		int idSeccion = seccion.getIdSeccion();
		String hql = "from Butaca b where b.seccion=" + idSeccion;
		
		try {
			iniciaOperacion();
			butacas = session.createQuery(hql).list();
		} finally {
			session.close();
		}
		
		return butacas;
	}
}
