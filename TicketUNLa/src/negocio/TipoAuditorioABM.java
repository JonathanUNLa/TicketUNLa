package negocio;

import java.util.List;

import dao.TipoAuditorioDao;
import datos.TipoAuditorio;

public class TipoAuditorioABM {
	TipoAuditorioDao dao = new TipoAuditorioDao();
	
	public TipoAuditorio traerTipoAuditorio(int idTipoAuditorio) throws Exception {
		TipoAuditorio tipoAuditorio = dao.traerTipoAuditorio(idTipoAuditorio);
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
