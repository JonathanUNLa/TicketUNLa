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
		if (tipoUsuario==null) throw new Exception("El tipo usuario no existe");
		return tipoUsuario;
	}
	
	public TipoUsuario traerTipoUsuario(String nombreTipo) throws Exception {
		TipoUsuario tipoUsuario = dao.traerTipoUsuario(nombreTipo);
		if (tipoUsuario==null) throw new Exception("El tipo usuario no existe");
		return tipoUsuario;
	}
	
	public List<TipoUsuario> traerTipoUsuario() throws Exception {
		return dao.traerTipoUsuario();
	}
	
	public int agregar(String nombreTipo )throws Exception {
		if(dao.traerTipoUsuario(nombreTipo)!=null)throw new Exception("El tipo usuario ya existe");
		TipoUsuario tipoUsuario = new TipoUsuario(nombreTipo);
		return dao.agregar(tipoUsuario);
	}
	
	public void modificar(TipoUsuario tipoUsuario ) {
		dao.actualizar(tipoUsuario);
	}
	
	public void eliminar(int idTipoUsuario) throws Exception {
		TipoUsuario tipoUsuario = dao.traerTipoUsuario(idTipoUsuario);
		if(tipoUsuario == null)throw new Exception("El Tipo usuario que desea eliminar no existe");
		dao.eliminar(tipoUsuario);
	}
}