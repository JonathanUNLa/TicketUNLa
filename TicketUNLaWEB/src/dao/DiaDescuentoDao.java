package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.DiaDescuento;

public class DiaDescuentoDao {
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
	
	public int agregar(DiaDescuento objeto) {
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
	
	public void actualizar(DiaDescuento objeto) throws HibernateException {
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
	
	public void eliminar(DiaDescuento objeto) throws HibernateException {
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
	
	public DiaDescuento traerDiaDescuento(int idDiaDescuento) throws HibernateException {
		DiaDescuento objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (DiaDescuento) session.get(DiaDescuento.class, idDiaDescuento);
		} finally {
			session.close();
		}
		
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<DiaDescuento> traerDiaDescuento() throws HibernateException {
		List<DiaDescuento> diaDescuentos = null;
		
		try {
			iniciaOperacion();
			diaDescuentos = session.createQuery("from DiaDescuento").list();
		} finally {
			session.close();
		}
		
		return diaDescuentos;
	}
}
