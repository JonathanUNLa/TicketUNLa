package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.TipoBeneficio;

public class TipoBeneficioDao {
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
	
	public int agregar(TipoBeneficio objeto) {
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
	
	public void actualizar(TipoBeneficio objeto) throws HibernateException {
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
	
	public void eliminar(TipoBeneficio objeto) throws HibernateException {
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
	
	public TipoBeneficio traerTipoBeneficio(int idTipoBeneficio) throws HibernateException {
		TipoBeneficio objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (TipoBeneficio) session.get(TipoBeneficio.class, idTipoBeneficio);
		} finally {
			session.close();
		}
		
		return objeto;
	}
	
	public TipoBeneficio traerTipoBeneficio(String beneficio) throws HibernateException {
		TipoBeneficio objeto = null;
		
		try {
			iniciaOperacion();
			String hql= "from TipoBeneficio b "
					+ "where b.beneficio= "+"'"+beneficio+"'";
			objeto = (TipoBeneficio) session.createQuery(hql).uniqueResult();
		} finally {
			session.close();
		}
		
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<TipoBeneficio> traerTipoBeneficio() throws HibernateException {
		List<TipoBeneficio> tiposBeneficios = null;
		
		try {
			iniciaOperacion();
			tiposBeneficios = session.createQuery("from TipoBeneficio").list();
		} finally {
			session.close();
		}
		
		return tiposBeneficios;
	}
}
