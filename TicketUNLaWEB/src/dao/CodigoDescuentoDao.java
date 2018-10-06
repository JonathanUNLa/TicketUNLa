package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.CodigoDescuento;

public class CodigoDescuentoDao {
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
	
	public int agregar(CodigoDescuento objeto) {
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
	
	public void actualizar(CodigoDescuento objeto) throws HibernateException {
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
	
	public void eliminar(CodigoDescuento objeto) throws HibernateException {
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
	
	public CodigoDescuento traerCodigoDescuentoHql(int idCodigoDescuento) throws HibernateException {
		CodigoDescuento objeto = null;
		
		try {
			iniciaOperacion();
			String hql= "from CodigoDescuento c "+
						"inner join fetch c.seccion "+
						"inner join fetch c.funcion "+
						"where c.idCodigoDescuento= "+idCodigoDescuento;
			objeto = (CodigoDescuento) session.createQuery(hql).uniqueResult();
		} finally {
			session.close();
		}
		
		return objeto;
	}
	
	public CodigoDescuento traerCodigoDescuento(int idCodigoDescuento) throws HibernateException {
		CodigoDescuento objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (CodigoDescuento) session.get(CodigoDescuento.class, idCodigoDescuento);
		} finally {
			session.close();
		}
		
		return objeto;
	}
	
	public CodigoDescuento traerCodigoDescuento(String codigo) throws HibernateException {
		CodigoDescuento objeto = null;
		
		try {
			iniciaOperacion();
			String hql= "from CodigoDescuento c "+
					"inner join fetch c.seccion "+
					"inner join fetch c.funcion "+
					"where c.codigo= "+"'"+codigo+"'";
			objeto = (CodigoDescuento) session.createQuery(hql).uniqueResult();
		} finally {
			session.close();
		}
		
		return objeto;
	}
	
	public CodigoDescuento traerCodigoDescuentoCodigo(String codigo) throws HibernateException {
		CodigoDescuento objeto = null;
		
		try {
			iniciaOperacion();
			String hql;
			hql = "from CodigoDescuento c where c.codigo=" + "'"+codigo+"'";
			objeto = (CodigoDescuento) session.createQuery(hql).uniqueResult();
		} finally {
			session.close();
		}
		
		return objeto;
	}

	
	@SuppressWarnings("unchecked")
	public List<CodigoDescuento> traerCodigoDescuento() throws HibernateException {
		List<CodigoDescuento> codigosDescuentos = null;
		
		try {
			iniciaOperacion();
			String hql= "from CodigoDescuento c "+
					"inner join fetch c.seccion "+
					"inner join fetch c.funcion ";
			codigosDescuentos = session.createQuery(hql).list();
		} finally {
			session.close();
		}
		
		return codigosDescuentos;
	}
}
