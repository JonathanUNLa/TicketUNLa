package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Usuario;

public class UsuarioDao {
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
	
	public int agregar(Usuario objeto) {
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
	
	public void actualizar(Usuario objeto) throws HibernateException {
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
	
	public void eliminar(Usuario objeto) throws HibernateException {
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
	public Usuario traerUsuario(int idUsuario) throws HibernateException {
		Usuario objeto = null;
		
		try {
			iniciaOperacion();
			objeto = (Usuario) session.get(Usuario.class, idUsuario);
		} finally {
			session.close();
		}
		
		return objeto;
	}
	
	public Usuario traerUsuarioHql(int idUsuario) throws HibernateException {
		Usuario objeto = null;
		
		try {
			iniciaOperacion();

			String 	hql =  "from Usuario a "+
					"inner join fetch a.tipoUsuario "+
					"left join fetch a.tipoBeneficio "+
					"left join fetch a.auditorio d "+
					"left join fetch d.tipoAuditorio "+
					"left join fetch d.lstSecciones s "+
					"left join fetch s.lstButacas b "+
					"left join fetch b.seccion "+
					"where a.idUsuario= "+idUsuario;
							
			objeto =  (Usuario) session.createQuery(hql).uniqueResult();
		} finally {
			session.close();
		}
		
		return objeto;
	}
	
	public Usuario traerUsuario(String nombreUsuario) throws HibernateException {
		Usuario objeto = null;
		try {
			iniciaOperacion();
			objeto = (Usuario) session.createQuery("from Usuario u "
					+ "left join fetch u.tipoBeneficio "
					+ "left join fetch u.tipoUsuario "
					+ "left join fetch u.auditorio a "
					+ "left join fetch a.lstSecciones lst "
					+ "left join fetch lst.auditorio "
					+ "left join fetch lst.lstButacas b "
					+ "left join fetch b.seccion s "
					+ "left join fetch a.lstEventos e "
					+ "left join fetch e.auditorio "
					+"left join fetch e.lstFunciones f "
					+"left join fetch f.lstCodDesc dsc " 
					+"left join fetch dsc.seccion "
					+"left join fetch dsc.funcion "
					+"left join fetch f.diaDescuento "
					+ "where u.nombreUsuario =" +
													"'"+nombreUsuario+"'").uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
/*	public Usuario traerUsuarioHql(int idUsuario) throws HibernateException {
		Usuario objeto = null;
		
		try {
			iniciaOperacion();
	String 	hql = "from Usuario a "
			+ "left join fetch a.tipoBeneficio "
			+ "inner join fetch a.tipoUsuario "
			+ "left join fetch a.auditorio "
			+"where a.idUsuario=" +idUsuario;
	objeto =  (Usuario) session.createQuery(hql).uniqueResult();
		} finally {
			session.close();
		}
		
		return objeto;
	}
	//	String hql = "from Butaca b where b.seccion=" + idSeccion
	//butacas = (Butaca) session.createQuery(hql).uniqueResult();

	*/
	@SuppressWarnings("unchecked")
	public List<Usuario> traerUsuario() throws HibernateException {
		List<Usuario> Usuarios = null;
		
		try {
			iniciaOperacion();
			String 	hql =  "from Usuario a "+
					"inner join fetch a.tipoUsuario "+
					"left join fetch a.tipoBeneficio "+
					"left join fetch a.auditorio d "+
					"left join fetch d.tipoAuditorio "+
					"left join fetch d.lstSecciones s "+
					"left join fetch s.lstButacas b "+
					"left join fetch b.seccion ";
			Usuarios = session.createQuery(hql).list();
		} finally {
			session.close();
		}
		
		return Usuarios;
	}
}
