package negocio;

import java.util.List;

import dao.TipoUsuarioDao;
import datos.Auditorio;
import datos.TipoBeneficio;
import datos.TipoUsuario;

public class TipoUsuarioABM {
	TipoUsuarioDao dao = new TipoUsuarioDao();
	
	public TipoUsuario traerTipoUsuario(int idTipoUsuario) throws Exception {
		TipoUsuario tipoUsuario = dao.traerTipoUsuario(idTipoUsuario);
		if (tipoUsuario==null) throw new Exception("El Tipo de Usuario no existe");
		return tipoUsuario;
	}
	
	public List<TipoUsuario> traerTipoUsuario() throws Exception {
		return dao.traerTipoUsuario();
	}
	
	public int agregar(String nombreTipo, TipoBeneficio tipoBeneficio, Auditorio auditorio) {
		TipoUsuario tipoUsuario = new TipoUsuario(nombreTipo,tipoBeneficio,auditorio);
		return dao.agregar(tipoUsuario);
	}
	
	public void modificar(TipoUsuario tipoUsuario) {
		dao.actualizar(tipoUsuario);
	}
	
	public void eliminar(int idTipoUsuario) throws Exception {
		TipoUsuario tipoUsuario = dao.traerTipoUsuario(idTipoUsuario);
		if(tipoUsuario == null)throw new Exception("El Tipo de Usuario que desea eliminar no existe");
		dao.eliminar(tipoUsuario);
	}
}