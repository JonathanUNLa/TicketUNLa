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
import datos.Auditorio;
import datos.TipoUsuario;
import negocio.AuditorioABM;
import negocio.UsuarioABM;

public class ControladorReservar1 extends HttpServlet {
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
		
		UsuarioABM usuarioAbm = UsuarioABM.getInstancia();
		int error=0;
		
		int idusuario = Integer.parseInt(request.getParameter("idusuario"));
		
		//int idusuario = request.getParameter("idusuario");
		
		try {
			usuarioAbm.traerUsuario(idusuario);
		} catch (Exception e1) {
			error=0;
		}
		try {
			Usuario u = usuarioAbm.traerUsuario(idusuario);
			AuditorioABM aabm = AuditorioABM.getInstancia();
			List<Auditorio> la = aabm.traerAuditorio();
			
			request.setAttribute("la",la);
			request.setAttribute("idusuario",idusuario);
			request.setAttribute("usuario",u);
			request.getRequestDispatcher("/reservar1.jsp").forward(request , response);

			
		}
		catch (Exception e) {
			if(error==0){
			response.sendError(500, "hubo un problema trayendo el id de usuario");
			}
			
		}
	}
}