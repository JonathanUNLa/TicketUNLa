package negocio;

import java.util.List;

import dao.UsuarioDao;
import datos.Auditorio;
import datos.TipoBeneficio;
import datos.TipoUsuario;
import datos.Usuario;


public class UsuarioABM {
	private static UsuarioABM instancia;
	protected UsuarioDao dao;
	
	protected UsuarioABM() {
		dao = new UsuarioDao();
	}
	
	public static UsuarioABM getInstancia() {
		if (instancia == null) 
			instancia = new UsuarioABM();
		return instancia;
	}
	
	public Usuario traerUsuario(int idUsuario)throws Exception {
		Usuario usuario = dao.traerUsuario(idUsuario);
		if(usuario == null)throw new Exception("El usuario no existe");
		return usuario;
	}
	public Usuario traerUsuarioHql(int idUsuario)throws Exception {
		Usuario usuario = dao.traerUsuarioHql(idUsuario);
		if(usuario == null)throw new Exception("El usuario no existe");
		return usuario;
	}
	public Usuario traerUsuarioDni(int dni)throws Exception {
		Usuario usuario = dao.traerUsuarioDni(dni);
		if(usuario == null)throw new Exception("El usuario no existe");
		return usuario;
	}
	public Usuario traerUsuario(String nombreUsuario)throws Exception {
		Usuario usuario = dao.traerUsuario(nombreUsuario);
		if(usuario == null)throw new Exception("El usuario no existe");
		return usuario;
	}
	public List<Usuario> traerUsuario(){
		return dao.traerUsuario();
	}
	
	public int agregar(int dni, String nombre, String apellido, String telefono, String nombreUsuario, String contraseña,TipoUsuario tipoUsuario,TipoBeneficio tipoBeneficio,Auditorio auditorio)throws Exception {
		if(dao.traerUsuarioDni(dni)!=null)throw new Exception("El usuario ya existe");
		Usuario usuario = new Usuario(dni, nombre, apellido, telefono, nombreUsuario, contraseña, tipoUsuario, tipoBeneficio, auditorio);
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