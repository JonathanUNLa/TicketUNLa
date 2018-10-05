package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Evento;

public class EventoDao {
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
	
	public int agregar(Evento objeto) {
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
	
	public void actualizar(Evento objeto) throws HibernateException {
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
	
	public void eliminar(Evento objeto) throws HibernateException {
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
	
	public Evento traerEvento(int idEvento) throws HibernateException {
		Evento objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (Evento) session.get(Evento.class, idEvento);
		} finally {
			session.close();
		}
		
		return objeto;
	}
	
	public Evento traerEventoHql(int idEvento) throws HibernateException {
		Evento objeto = null;
		
		try {
			iniciaOperacion();
			String hql= "from Evento e "+
						"left join fetch e.auditorio a "+
						"left join fetch a.tipoAuditorio "+
						"left join fetch e.lstFunciones f "+
						"left join fetch f.lstCodDesc dsc " +
						"left join fetch dsc.seccion "+
						"left join fetch dsc.funcion "+
						"left join fetch f.diaDescuento "+
						"left join fetch a.lstSecciones s "+
						"left join fetch s.auditorio "+
						"left join fetch s.lstButacas b"+
						"left join fetch b.seccion "+
						"where e.idEvento= "+idEvento;
			objeto = (Evento) session.createQuery(hql).uniqueResult();
		} finally {
			session.close();
		}
		
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Evento> traerEvento(String auditorio) throws HibernateException {
		List<Evento> eventos = null;
		
		try {
			iniciaOperacion();
			String hql= "from Evento e "+
						"left join fetch e.auditorio a "+
						"left join fetch e.lstFunciones f "+
						"left join fetch f.evento "+
						"left join fetch f.lstCodDesc dsc " +
						"left join fetch dsc.seccion "+
						"left join fetch dsc.funcion "+
						"left join fetch f.diaDescuento "+
						"left join fetch a.lstSecciones s "+
						"left join fetch s.lstButacas "+
						"where a.nombre= "+"'"+auditorio+"'";
			eventos = session.createQuery(hql).list();
		} finally {
			session.close();
		}
		
		return eventos;
	}
	
	@SuppressWarnings("unchecked")
	public List<Evento> traerEvento() throws HibernateException {
		List<Evento> eventos = null;
		
		try {
			iniciaOperacion();
			String hql= "from Evento e "+
					"inner join fetch e.auditorio a "+
				"inner join fetch a.tipoAuditorio "+
					"left join fetch a.lstSecciones s "+
					"left join fetch s.lstButacas ";
			eventos = session.createQuery(hql).list();
		} finally {
			session.close();
		}
		
		return eventos;
	}
}
