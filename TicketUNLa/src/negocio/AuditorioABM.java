package negocio;

import java.util.List;
import java.util.Set;

import dao.AuditorioDao;
import datos.Auditorio;
import datos.Evento;
import datos.Seccion;
import datos.TipoAuditorio;

public class AuditorioABM {
	private static AuditorioABM instancia;
	protected AuditorioDao dao;
	
	protected AuditorioABM() {
		dao = new AuditorioDao();
	}
	
	public static AuditorioABM getInstancia() {
		if (instancia == null) 
			instancia = new AuditorioABM();
		return instancia;
	}
	
	public Auditorio traerAuditorio(int idAuditorio) throws Exception {
		Auditorio auditorio = dao.traerAuditorio(idAuditorio);
		if (auditorio==null) throw new Exception("El auditorio no existe");
		return auditorio;
	}
	
	public Auditorio traerAuditorioHql(int idAuditorio) throws Exception {
		Auditorio auditorio = dao.traerAuditorioHql(idAuditorio);
		if (auditorio==null) throw new Exception("El auditorio no existe");
		return auditorio;
	}
	public List<Auditorio> traerAuditorio() throws Exception {
		return dao.traerAuditorio();
	}
	
	public int agregar(String nombre, TipoAuditorio tipoAuditorio) {
		Auditorio auditorio = new Auditorio(nombre,tipoAuditorio);
		return dao.agregar(auditorio);
	}
	
	public int agregar(String nombre, Set<Seccion> lstSecciones, TipoAuditorio tipoAuditorio,Set<Evento> lstEventos) {
		Auditorio auditorio = new Auditorio(nombre,lstSecciones,tipoAuditorio, lstEventos);
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
