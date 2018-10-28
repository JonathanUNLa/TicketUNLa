package negocio;

import java.util.List;

import dao.TipoAuditorioDao;
import datos.TipoAuditorio;

public class TipoAuditorioABM {
	private static TipoAuditorioABM instancia;
	protected TipoAuditorioDao dao;
	
	protected TipoAuditorioABM() {
		dao = new TipoAuditorioDao();
	}
	
	public static TipoAuditorioABM getInstancia() {
		if (instancia == null) 
			instancia = new TipoAuditorioABM();
		return instancia;
	}
	
	public boolean validarTipoAuditorio(String nombre) {
		boolean validar=false;
		if(dao.traerTipoAuditorio(nombre)!=null)validar=true;
		return validar;
	}
	
	public TipoAuditorio traerTipoAuditorio(int idTipoAuditorio) throws Exception {
		TipoAuditorio tipoAuditorio = dao.traerTipoAuditorio(idTipoAuditorio);
		if (tipoAuditorio==null) throw new Exception("El TipoAuditorio no existe");
		return tipoAuditorio;
	}
	
	public TipoAuditorio traerTipoAuditorio(String nombre) throws Exception {
		TipoAuditorio tipoAuditorio = dao.traerTipoAuditorio(nombre);
		if (tipoAuditorio==null) throw new Exception("El TipoAuditorio no existe");
		return tipoAuditorio;
	}
	
	public List<TipoAuditorio> traerTipoAuditorio() throws Exception {
		return dao.traerTipoAuditorio();
	}
	
	public int agregar(String nombre) {
		TipoAuditorio tipoAuditorio = new TipoAuditorio(nombre);
		return dao.agregar(tipoAuditorio);
	}
	
	public void modificar(TipoAuditorio TipoAuditorio) {
		dao.actualizar(TipoAuditorio);
	}
	
	public void eliminar(int idTipoAuditorio) throws Exception {
		TipoAuditorio tipoAuditorio = dao.traerTipoAuditorio(idTipoAuditorio);
		if(tipoAuditorio == null)throw new Exception("El TipoAuditorio que desea eliminar no existe");
		dao.eliminar(tipoAuditorio);
	}

}
