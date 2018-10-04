package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Usuario;
import datos.TipoUsuario;
import negocio.UsuarioABM;

public class ControladorVistasPersonasIndice extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException {
		procesarPeticion(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException {
		procesarPeticion(request, response);
	}
	private void procesarPeticion(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//Facade facade=new Facade();
		UsuarioABM usuarioAbm = UsuarioABM.getInstancia();
		int error=0;
		String usuario = request.getParameter("usuario");
		String contrasenia = request.getParameter("contrasenia");
		try {
			usuarioAbm.traerUsuario(usuario);
			//facade.getLoginABM().traerLogin(usuario);
		} catch (Exception e1) {
			error=1;
		}
		try {
			Usuario u = usuarioAbm.traerUsuario(usuario);
			
			if(u.getContraseña().equals(contrasenia)){
				request.setAttribute("usuario",usuarioAbm.traerUsuario(usuario));
			}else{
				error=2;
				throw new EmptyStackException();
				
			}
			
			if(u.getTipoUsuario().getNombreTipo().equals("Administrador")){
				
				request.getRequestDispatcher("/vistaadministradorindice.jsp").forward(request , response);
			}

			if(u.getTipoUsuario().getNombreTipo().equals("Cliente")){
				request.getRequestDispatcher("/vistaclienteindice.jsp").forward(request , response);
			}

			if(u.getTipoUsuario().getNombreTipo().equals("Empleado")){
				
				request.getRequestDispatcher("/vistaempleadoindice.jsp").forward(request , response);
			}

			
		}
		catch (Exception e) {
			if(error==0){
			response.sendError(500, "Hubo un problema vista personas");
			}
			
			if(error==1){
				request.getRequestDispatcher("/errorusuario.jsp").forward(request , response);
			}
			
			if(error==2){
				request.getRequestDispatcher("/errorcontrasenia.jsp").forward(request , response);
			}
			
		}
	}
}