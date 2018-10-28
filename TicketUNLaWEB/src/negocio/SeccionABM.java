package negocio;

import java.util.List;
import java.util.Set;

import dao.SeccionDao;
import datos.Auditorio;
import datos.Butaca;
import datos.Seccion;

public class SeccionABM {
	private static SeccionABM instancia;
	protected SeccionDao dao;
	
	protected SeccionABM() {
		dao = new SeccionDao();
	}
	
	public static SeccionABM getInstancia() {
		if (instancia == null) 
			instancia = new SeccionABM();
		return instancia;
	}
	
	public boolean validarSeccion(String nombre,Auditorio auditorio) {
		boolean validar=false;
		if(dao.traerSeccionNombre(nombre, auditorio.getIdAuditorio())!=null)validar=true;
		return validar;
	}
	
	public Seccion traerSeccionHql(int idSeccion) throws Exception {
		Seccion seccion = dao.traerSeccionHql(idSeccion);
		if (seccion==null) throw new Exception("El Seccion no existe");
		return seccion;
	}
	
	public Seccion traerSeccionNombre(String nombre) throws Exception {
		Seccion seccion = dao.traerSeccionNombre(nombre);
		if (seccion==null) throw new Exception("El Seccion no existe");
		return seccion;
	}
	
	public Seccion traerSeccion(int idSeccion)throws Exception{
		Seccion seccion = dao.traerSeccion(idSeccion);
		if(seccion!=null){
			return seccion;
		}else throw new Exception ("id de Factura no existe");
	}
	
	public List<Seccion> traerSeccionAuditorio(int idAuditorio) throws Exception {
		return dao.traerSeccionAuditorio(idAuditorio);
	}
	public List<Seccion> traerSeccion()  throws Exception {
		return dao.traerSeccion();
	}
	
	public int agregar(String nombreSeccion, double precioSeccion, Set<Butaca> lstButacas,Auditorio auditorio) {
		Seccion seccion = new Seccion(nombreSeccion, precioSeccion, lstButacas,auditorio);
		return dao.agregar(seccion);
	}
	public int agregar(String nombreSeccion, double precioSeccion,Auditorio auditorio)throws Exception {
		//if(dao.traerSeccionNombre(nombreSeccion)!=null)throw new Exception ("la Seccion ya existe");
		Seccion seccion = new Seccion(nombreSeccion, precioSeccion,auditorio);
		return dao.agregar(seccion);
	}
	
	public void modificar(Seccion Seccion) {
		dao.actualizar(Seccion);
	}
	
	public void eliminar(int idSeccion) throws Exception {
		Seccion seccion = dao.traerSeccion(idSeccion);
		if(seccion == null)throw new Exception("El Seccion que desea eliminar no existe");
		dao.eliminar(seccion);
	}
}
