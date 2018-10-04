package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Auditorio;


public class AuditorioDao {
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
	
	public int agregar(Auditorio objeto) {
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
	
	public void actualizar(Auditorio objeto) throws HibernateException {
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
	
	public void eliminar(Auditorio objeto) throws HibernateException {
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
	
	public Auditorio traerAuditorio(int idAuditorio) throws HibernateException {
		Auditorio objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (Auditorio) session.get(Auditorio.class, idAuditorio);
		} finally {
			session.close();
		}
		
		return objeto;
	}
	
	public Auditorio traerAuditorioHql(int idAuditorio) throws HibernateException {
		Auditorio objeto = null;
		
		try {
			iniciaOperacion();
			String hql= "from Auditorio a "+
						"left join fetch a.tipoAuditorio "+
						"left join fetch a.lstSecciones  lst "+
						"left join fetch lst.lstButacas  "+
						"where a.idAuditorio= "+ idAuditorio;
			objeto = (Auditorio) session.createQuery(hql).uniqueResult();
			
		} finally {
			session.close();
		}
		
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Auditorio> traerAuditorio() throws HibernateException {
		List<Auditorio> auditorios = null;
		
		try {
			iniciaOperacion();
			auditorios = session.createQuery("from Auditorio").list();
		} finally {
			session.close();
		}
		
		return auditorios;
	}
}
