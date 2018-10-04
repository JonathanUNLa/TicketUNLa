package test;

import datos.Usuario;
import negocio.UsuarioABM;

public class Test2 {

	public static void main(String[] args) {
		UsuarioABM usuarioAbm = UsuarioABM.getInstancia();
		Usuario u;
		String contrasenia = "asd";
		try {
			u = usuarioAbm.traerUsuario("Jon");
			if(u.getContraseña().equals(contrasenia)){
				System.out.println("contraseña correcta");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
