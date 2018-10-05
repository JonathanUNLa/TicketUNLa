package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.TipoAuditorio;

public class TipoAuditorioDao {
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
	
	public int agregar(TipoAuditorio objeto) {
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
	
	public void actualizar(TipoAuditorio objeto) throws HibernateException {
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
	
	public void eliminar(TipoAuditorio objeto) throws HibernateException {
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
	
	public TipoAuditorio traerTipoAuditorio(int idTipoAuditorio) throws HibernateException {
		TipoAuditorio objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (TipoAuditorio) session.get(TipoAuditorio.class, idTipoAuditorio);
		} finally {
			session.close();
		}
		
		return objeto;
	}
	
	public TipoAuditorio traerTipoAuditorio(String nombre) throws HibernateException {
		TipoAuditorio objeto = null;
		
		try {
			iniciaOperacion();
			String hql= "from TipoAuditorio a "
					+ "where a.nombre= "+"'"+nombre+"'";
			objeto = (TipoAuditorio) session.createQuery(hql).uniqueResult();
		} finally {
			session.close();
		}
		
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<TipoAuditorio> traerTipoAuditorio() throws HibernateException {
		List<TipoAuditorio> tiposAuditorios = null;
		
		try {
			iniciaOperacion();
			tiposAuditorios = session.createQuery("from TipoAuditorio").list();
		} finally {
			session.close();
		}
		
		return tiposAuditorios;
	}
}
