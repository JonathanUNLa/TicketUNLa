package negocio;

import java.util.List;

import dao.AuditorioDao;
import datos.Auditorio;
import datos.Seccion;
import datos.TipoAuditorio;

public class AuditorioABM {
	
	AuditorioDao dao = new AuditorioDao();
	
	public Auditorio traerAuditorio(int idAuditorio) throws Exception {
		Auditorio auditorio = dao.traerAuditorio(idAuditorio);
		if (auditorio==null) throw new Exception("El auditorio no existe");
		return auditorio;
	}
	
	public List<Auditorio> traerAuditorio() throws Exception {
		return dao.traerAuditorio();
	}
	
	public int agregar(String nombre, List<Seccion> lstSecciones, TipoAuditorio tipoAuditorio) {
		Auditorio auditorio = new Auditorio(nombre,lstSecciones,tipoAuditorio);
		return dao.agregar(auditorio);
	}
	
	public void modificar(Auditorio auditorio) {
		dao.actualizar(auditorio);
	}
	
	public void eliminar(int idAuditorio) throws Exception {
		Auditorio auditorio = dao.traerAuditorio(idAuditorio);
		if(auditorio == null)throw new Exception("El auditorio que desea eliminar no existe");
		dao.eliminar(auditorio);
	}
}
