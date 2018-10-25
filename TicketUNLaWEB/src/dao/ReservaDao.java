package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Reserva;

public class ReservaDao {
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
	
	public int agregar(Reserva objeto) {
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
	
	
	public void actualizar(Reserva objeto) throws HibernateException {
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
	
	public void eliminar(Reserva objeto) throws HibernateException {
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
	
	public Reserva traerReserva(int idReserva) throws HibernateException {
		Reserva objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (Reserva) session.get(Reserva.class, idReserva);
		} finally {
			session.close();
		}
		
		return objeto;
	}
	public Reserva traerReservaHql(int idReserva) throws HibernateException {
		Reserva objeto = null;
		
		try {
			iniciaOperacion();
			String hql="from Reserva r "+
					"left join fetch r.usuario u "+
					"left  join fetch r.lstEntradas e "+
					"left join fetch e.butaca s "+
					"left join fetch e.funcion f "+
					"left join fetch s.seccion "+
					"left join fetch u.tipoBeneficio "+
					"left join fetch u.tipoUsuario "+
					"left join fetch f.diaDescuento "+
					"left join fetch f.evento "+
					"left join fetch f.lstCodDesc lst "+
					"left join fetch lst.seccion "+
					"where r.idReserva= "+ idReserva;
			
			


			objeto = (Reserva) session.createQuery(hql).uniqueResult();
		} finally {
			session.close();
		}
		
		return objeto;
	}

		@SuppressWarnings("unchecked")
		public List<Reserva> traerReservaUsuario(int idUsuario) throws HibernateException {
			List<Reserva> objeto = null;
			
			try {
				iniciaOperacion();
				String hql="from Reserva r "+
						"left join fetch r.usuario u "+
						"left  join fetch r.lstEntradas e "+
						"left join fetch e.butaca s "+
						"left join fetch e.funcion f "+
						"left join fetch s.seccion "+
						"left join fetch u.tipoBeneficio "+
						"left join fetch u.tipoUsuario "+
						"left join fetch f.diaDescuento "+
						"left join fetch f.evento "+
						"left join fetch f.lstCodDesc lst "+
						"left join fetch lst.seccion "+
						"where u.idUsuario= "+ idUsuario;
				objeto = session.createQuery(hql).list();
			} finally {
				session.close();
			}
			
			return objeto;
		}
		
	@SuppressWarnings("unchecked")
	public List<Reserva> traerReserva() throws HibernateException {
		List<Reserva> reserva = null;
		
		try {
			iniciaOperacion();
			String hql="from Reserva r "+
					"left join fetch r.usuario u "+
					"left  join fetch r.lstEntradas e "+
					"left join fetch e.butaca s "+
					"left join fetch e.funcion f "+
					"left join fetch s.seccion "+
					"left join fetch u.tipoBeneficio "+
					"left join fetch u.tipoUsuario "+
					"left join fetch f.diaDescuento "+
					"left join fetch f.evento "+
					"left join fetch f.lstCodDesc lst "+
					"left join fetch lst.seccion ";
			reserva = session.createQuery(hql).list();
		} finally {
			session.close();
		}
		
		return reserva;
	}
}
