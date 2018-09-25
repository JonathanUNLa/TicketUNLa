package negocio;

import java.util.List;

import dao.SeccionDao;
import datos.Auditorio;
import datos.Butaca;
import datos.Seccion;

public class SeccionABM {
	SeccionDao dao = new SeccionDao();
	
	public Seccion traerSeccion(int idSeccion) throws Exception {
		Seccion seccion = dao.traerSeccion(idSeccion);
		if (seccion==null) throw new Exception("El Seccion no existe");
		return seccion;
	}
	
	public List<Seccion> traerSeccion() throws Exception {
		return dao.traerSeccion();
	}
	
	public int agregar(String nombreSeccion, double precioSeccion, List<Butaca> lstButacas,Auditorio auditorio) {
		Seccion seccion = new Seccion(nombreSeccion, precioSeccion, lstButacas,auditorio);
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
