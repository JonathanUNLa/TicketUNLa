package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Seccion;

public class SeccionDao {
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
	
	public int agregar(Seccion objeto) {
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
	
	public void actualizar(Seccion objeto) throws HibernateException {
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
	
	public void eliminar(Seccion objeto) throws HibernateException {
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
	
	public Seccion traerSeccion(int idSeccion) throws HibernateException {
		Seccion objeto = null;
		
		try {
			iniciaOperacion();
			String hql= "from Seccion s "+
						"left join fetch s.lstButacas "+
						"left join fetch s.auditorio "+
						"where s.idSeccion= "+ idSeccion;
			objeto = (Seccion) session.createQuery(hql).uniqueResult();
			Hibernate.initialize(objeto.getLstButacas());
		} finally {
			session.close();
		}
		
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Seccion> traerSeccion() throws HibernateException {
		List<Seccion> secciones = null;
		
		try {
			iniciaOperacion();
			secciones = session.createQuery("from Seccion").list();
		} finally {
			session.close();
		}
		
		return secciones;
	}
}
