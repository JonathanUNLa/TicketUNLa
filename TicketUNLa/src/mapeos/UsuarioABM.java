package negocio;

import java.util.List;

import dao.UsuarioDao;
import datos.TipoBeneficio;
import datos.TipoUsuario;
import datos.Usuario;


public class UsuarioABM {
	
	UsuarioDao dao = new UsuarioDao(); 
	
	public Usuario traerEntrada(int idUsuario)throws Exception {
		Usuario usuario = dao.traerUsuario(idUsuario);
		if(usuario == null)throw new Exception("El usuario no existe");
		return usuario;
	}
	
	public List<Usuario> traerCodigoDescuento(){
		return dao.traerUsuario();
	}
	
	public int agregar(long dni, String nombre, String apellido, String telefono, String nombreUsuario, String contraseña,TipoUsuario tipoUsuario,TipoBeneficio tipoBeneficio) {
		Usuario usuario = new Usuario(dni,nombre,apellido,telefono,nombreUsuario,contraseña,tipoUsuario,tipoBeneficio);
		return dao.agregar(usuario);
	}
	
	public void modificar(Usuario usuario) {
		dao.actualizar(usuario);
	}
	
	public void eliminar(int idUsuario)throws Exception {
		Usuario usuario = dao.traerUsuario(idUsuario);
		if(usuario == null)throw new Exception("La funcion no existe");
		dao.eliminar(usuario);
	}
}