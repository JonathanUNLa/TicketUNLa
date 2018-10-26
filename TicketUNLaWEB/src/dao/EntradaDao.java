package dao;

import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Entrada;
import datos.Reserva;
import funciones.Funciones;

public class EntradaDao {
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
	
	public int agregar(Entrada objeto) {
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
	
	public void actualizar(Entrada objeto) throws HibernateException {
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
	
	public void eliminar(Entrada objeto) throws HibernateException {
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
	
	public Entrada traerEntrada(int idEntrada) throws HibernateException {
		Entrada objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (Entrada) session.get(Entrada.class, idEntrada);
		} finally {
			session.close();
		}
		
		return objeto;
	}
	
	public Entrada traerEntradaHql(int idEntrada) throws HibernateException {
		Entrada objeto = null;
		
		try {
			iniciaOperacion();

			
			String 	hql =  "from Entrada e "+
					"inner  join fetch e.butaca s "+
					"inner  join fetch e.funcion v "+
					"left join fetch s.seccion "+
					"left join fetch v.diaDescuento "+
					"left join fetch v.lstCodDesc lst "+
					"left join fetch v.evento "+
					"left join fetch lst.seccion "+
					"where e.idEntrada= "+idEntrada;
							
			objeto =  (Entrada) session.createQuery(hql).uniqueResult();
		} finally {
			session.close();
		}
		
		return objeto;
	}
	
	public Entrada traerFuncionEntrada(int idFuncion, int idButaca) throws HibernateException {
		Entrada objeto = null;
		
		try {
			iniciaOperacion();

			
			String 	hql =  "from Entrada e "+
					"inner  join fetch e.butaca s "+
					"inner  join fetch e.funcion v "+
					"left join fetch s.seccion "+
					"left join fetch v.diaDescuento "+
					"left join fetch v.lstCodDesc lst "+
					"left join fetch v.evento "+
					"left join fetch lst.seccion "+
					"where v.idFuncion= "+idFuncion+
					"and s.idButaca= "+idButaca;
							
			objeto =  (Entrada) session.createQuery(hql).uniqueResult();
		} finally {
			session.close();
		}
		
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Entrada> traerEntradaFuncion(int funcion) throws HibernateException {
		List<Entrada> entradas = null;
		
		try {
			iniciaOperacion();
			String 	hql =  "from Entrada e "+
							"inner  join fetch e.butaca s "+
							"inner  join fetch e.funcion v "+
							"left join fetch s.seccion "+
							"left join fetch v.diaDescuento "+
							"left join fetch v.lstCodDesc lst "+
							"left join fetch v.evento "+
							"left join fetch lst.seccion "+
							"where v.idFuncion= "+funcion;
			entradas = session.createQuery(hql).list();
		} finally {
			session.close();
		}
		
		return entradas;
	}
	
	@SuppressWarnings("unchecked")
	public List<Entrada> traerReservaUsuario(int idUsuario) throws HibernateException {
		List<Entrada> entradas = null;
		
		try {
			iniciaOperacion();
			String hql1="from Entrada e "+
						"inner join fetch e.reserva r "+
						"inner join fetch r.usuario u "+
						"inner join fetch e.funcion f "+
						"inner join fetch e.butaca b "+
						"inner join fetch b.seccion "+
						"inner join fetch f.evento "+
						"left join fetch f.diaDescuento "+
						"left join fetch f.lstCodDesc lst "+
						"left join fetch lst.seccion "+
						"left join fetch u.tipoUsuario t "+
						"where u.idUsuario= "+idUsuario+
						"order by r.idReserva asc";
			entradas = session.createQuery(hql1).list();
		} finally {
			session.close();
		}
		
		return entradas;
	}
	
	@SuppressWarnings("unchecked")
	public List<Entrada> traerEntradasTipoUsuario(int idTipoUsuario, GregorianCalendar fInicio, GregorianCalendar fFin) throws HibernateException {
		List<Entrada> entradas = null;
		
		try {
			iniciaOperacion();
			String hql1="from Entrada e "+
						"inner join fetch e.reserva r "+
						"inner join fetch r.usuario u "+
						"inner join fetch e.funcion f "+
						"inner join fetch e.butaca b "+
						"inner join fetch b.seccion "+
						"inner join fetch f.evento "+
						"left join fetch f.diaDescuento "+
						"left join fetch f.lstCodDesc lst "+
						"left join fetch lst.seccion "+
						"left join fetch u.tipoUsuario t "+
						"where f.diaHora between :fechaI and :fechaF "+
						"and t.idTipoUsuario= "+idTipoUsuario+
						"order by r.idReserva asc";
			entradas = session.createQuery(hql1).setParameter("fechaI", fInicio).setParameter("fechaF", fFin).list();
		} finally {
			session.close();
		}
		
		return entradas;
	}
	
	@SuppressWarnings("unchecked")
	public List<Entrada> traerEntradasEvento(int idEvento, GregorianCalendar fInicio, GregorianCalendar fFin) throws HibernateException {
		List<Entrada> entradas = null;
		
		try {
			iniciaOperacion();
			String hql1="from Entrada e "+
						"inner join fetch e.reserva r "+
						"inner join fetch r.usuario u "+
						"inner join fetch e.funcion f "+
						"inner join fetch e.butaca b "+
						"inner join fetch b.seccion "+
						"inner join fetch f.evento "+
						"left join fetch f.diaDescuento "+
						"left join fetch f.lstCodDesc lst "+
						"left join fetch lst.seccion "+
						"left join fetch u.tipoUsuario t "+
						"where f.diaHora between :fechaI and :fechaF "+
						"and f.evento.idEvento= "+idEvento+
						"order by r.idReserva asc";
			entradas = session.createQuery(hql1).setParameter("fechaI", fInicio).setParameter("fechaF", fFin).list();
		} finally {
			session.close();
		}
		
		return entradas;
	}
	
	@SuppressWarnings("unchecked")
	public List<Entrada> traerEntradasFuncionSeccion(int idFuncion, GregorianCalendar fInicio, GregorianCalendar fFin) throws HibernateException {
		List<Entrada> entradas = null;
		
		try {
			iniciaOperacion();
			String hql1="from Entrada e "+
						"inner join fetch e.reserva r "+
						"inner join fetch r.usuario u "+
						"inner join fetch e.funcion f "+
						"inner join fetch e.butaca b "+
						"inner join fetch b.seccion "+
						"inner join fetch f.evento "+
						"left join fetch f.diaDescuento "+
						"left join fetch f.lstCodDesc lst "+
						"left join fetch lst.seccion "+
						"left join fetch u.tipoUsuario t "+
						"where f.diaHora between :fechaI and :fechaF "+
						"and f.idFuncion= "+idFuncion+
						"order by r.idReserva asc";
			entradas = session.createQuery(hql1).setParameter("fechaI", fInicio).setParameter("fechaF", fFin).list();
		} finally {
			session.close();
		}
		
		return entradas;
	}
	
	@SuppressWarnings("unchecked")
	public List<Entrada> traerEntrada() throws HibernateException {
		List<Entrada> entradas = null;
		
		try {
			iniciaOperacion();
			String 	hql =  "from Entrada e "+
					"inner  join fetch e.butaca s "+
					"inner  join fetch e.funcion v "+
					"left join fetch s.seccion "+
					"left join fetch v.diaDescuento "+
					"left join fetch v.lstCodDesc lst "+
					"left join fetch v.evento "+
					"left join fetch lst.seccion ";
			entradas = session.createQuery(hql).list();
		} finally {
			session.close();
		}
		
		return entradas;
	}
}
