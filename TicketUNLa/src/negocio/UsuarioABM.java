package negocio;

import java.util.List;

import dao.UsuarioDao;
import datos.Usuario;
import datos.TipoBeneficio;
import datos.TipoUsuario;

public class UsuarioABM {
	UsuarioDao dao = new UsuarioDao();
	
	public Usuario traerUsuario(int idUsuario) throws Exception {
		Usuario usuario = dao.traerUsuario(idUsuario);
		if (usuario==null) throw new Exception("El Usuario no existe");
		return usuario;
	}
	
	public List<Usuario> traerUsuario() throws Exception {
		return dao.traerUsuario();
	}
	
	public int agregar(long dni, String nombre, String apellido, String telefono, String nombreUsuario,
			String contrasenia, TipoUsuario tipoUsuario, TipoBeneficio tipoBeneficio) {
		Usuario usuario = new Usuario(dni,nombre,apellido,telefono,nombreUsuario,contrasenia,tipoUsuario,tipoBeneficio);
		return dao.agregar(usuario);
	}
	
	public void modificar(Usuario usuario) {
		dao.actualizar(usuario);
	}
	
	public void eliminar(int idUsuario) throws Exception {
		Usuario usuario = dao.traerUsuario(idUsuario);
		if(usuario == null)throw new Exception("El Usuario que desea eliminar no existe");
		dao.eliminar(usuario);
	}
}
