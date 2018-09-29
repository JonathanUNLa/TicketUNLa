package negocio;

import java.util.List;

import dao.TipoUsuarioDao;
import datos.TipoUsuario;


public class TipoUsuarioABM {
	private static TipoUsuarioABM instancia;
	protected TipoUsuarioDao dao;
	
	protected TipoUsuarioABM() {
		dao = new TipoUsuarioDao();
	}
	
	public static TipoUsuarioABM getInstancia() {
		if (instancia == null) 
			instancia = new TipoUsuarioABM();
		return instancia;
	}
	
	public TipoUsuario traerTipoUsuario(int idTipoUsuario) throws Exception {
		TipoUsuario tipoUsuario = dao.traerTipoUsuario(idTipoUsuario);
		if (tipoUsuario==null) throw new Exception("El Seccion no existe");
		return tipoUsuario;
	}
	
	public List<TipoUsuario> traerTipoUsuario() throws Exception {
		return dao.traerTipoUsuario();
	}
	
	public int agregar(String nombreTipo ) {
		TipoUsuario tipoUsuario = new TipoUsuario(nombreTipo);
		return dao.agregar(tipoUsuario);
	}
	
	public void modificar(TipoUsuario tipoUsuario ) {
		dao.actualizar(tipoUsuario);
	}
	
	public void eliminar(int idSeccion) throws Exception {
		TipoUsuario tipoUsuario = dao.traerTipoUsuario(idSeccion);
		if(tipoUsuario == null)throw new Exception("El Seccion que desea eliminar no existe");
		dao.eliminar(tipoUsuario);
	}
}