package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Funcion;

public class FuncionDao {
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
	
	public int agregar(Funcion objeto) {
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
	
	public void actualizar(Funcion objeto) throws HibernateException {
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
	
	public void eliminar(Funcion objeto) throws HibernateException {
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
	
	public Funcion traerFuncion(int idFuncion) throws HibernateException {
		Funcion objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (Funcion) session.get(Funcion.class, idFuncion);
		} finally {
			session.close();
		}
		
		return objeto;
	}
	public Funcion traerFuncionHql(int idFuncion) throws HibernateException {
		Funcion objeto = null;
		
		try {
			iniciaOperacion();
			String hql= "from Funcion f "+
						"inner join fetch f.evento "+
						"inner join fetch f.lstCodDesc dsc " +
						"inner join fetch dsc.seccion "+
						"inner join fetch dsc.funcion "+
						"iner join fetch f.diaDescuento "+
						"where f.idFuncion= "+idFuncion;
			objeto = (Funcion) session.createQuery(hql).uniqueResult();
			Hibernate.initialize(objeto.getLstCodDesc());
		} finally {
			session.close();
		}
		
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Funcion> traerFuncion() throws HibernateException {
		List<Funcion> funciones = null;
		
		try {
			iniciaOperacion();
			funciones = session.createQuery("from Funcion").list();
		} finally {
			session.close();
		}
		
		return funciones;
	}
}
