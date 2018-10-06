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
	
	public Butaca traerButacaHql(int idButaca) throws HibernateException {
		Butaca objeto = null;
		
		try {
			iniciaOperacion();
			String hql= "from Butaca b "
						+ "inner join fetch b.seccion " 
						+ "where b.idButaca= "+idButaca;
			objeto = (Butaca) session.createQuery(hql).uniqueResult();
		} finally {
			session.close();
		}
		
		return objeto;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Butaca> traerButacaFuncion(int funcion) throws HibernateException {
		List<Butaca> objeto = null;
		//int idFuncion = funcion.getIdFuncion();
		
		try {
			iniciaOperacion();
			/*String hql= "from Butaca b "+
						"left join fetch b.seccion s "+
						"left join fetch s.auditorio a "+
						"left join fetch s.lstButacas lstb "+
						"left join fetch lstb.seccion "+
						"left join fetch a.tipoAuditorio "+
						"left join fetch a.lstSecciones lsts "+
						"left join fetch lsts.lstButacas lstbt "+
						"left join fetch lstbt.seccion "+
						"left join fetch a.lstEventos e "+
						"left join fetch e.lstFunciones lstf "+
						"left join fetch e.auditorio "+
						"left join fetch lstf.evento "+
						"left join fetch lstf.diaDescuento "+
						"left join fetch lstf.lstCodDesc lstc "+
						"left join fetch lstc.seccion "+
						"where lstf.idFuncion=" +funcion;
		*/	String hql= "from Butaca b "+
						"left join fetch b.seccion s "+
						"left join fetch s.lstButacas "+
						"left join fetch s.auditorio a "+
						"left join fetch a.tipoAuditorio "+
						"left join fetch a.lstSecciones  lst "+
						"left join fetch lst.auditorio "+
						"left join fetch lst.lstButacas  b "+
						"left join fetch b.seccion s "+
						"left join fetch a.lstEventos e "+
						"left join fetch e.auditorio "+
						"left join fetch e.lstFunciones f "+
						"left join fetch f.lstCodDesc dsc " +
						"left join fetch dsc.seccion "+
						"left join fetch dsc.funcion "+
						"left join fetch f.diaDescuento "+
						"where f.idFuncion= "+funcion;
			objeto = session.createQuery(hql).list();
		} finally {
			session.close();
		}
		
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Butaca> traerButacaAuditorio(int auditorio) throws HibernateException {
		List<Butaca> objeto = null;
		
		try {
			iniciaOperacion();
				String hql= "from Butaca b "+
						"left join fetch b.seccion s "+
						"left join fetch s.lstButacas "+
						"left join fetch s.auditorio a "+
						"left join fetch a.tipoAuditorio "+
						"left join fetch a.lstSecciones  lst "+
						"left join fetch lst.auditorio "+
						"left join fetch lst.lstButacas  b "+
						"left join fetch b.seccion s "+
						"left join fetch a.lstEventos e "+
						"left join fetch e.auditorio "+
						"left join fetch e.lstFunciones f "+
						"left join fetch f.lstCodDesc dsc " +
						"left join fetch dsc.seccion "+
						"left join fetch dsc.funcion "+
						"left join fetch f.diaDescuento "+
						"where a.idAuditorio= "+auditorio;
			objeto = session.createQuery(hql).list();
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
