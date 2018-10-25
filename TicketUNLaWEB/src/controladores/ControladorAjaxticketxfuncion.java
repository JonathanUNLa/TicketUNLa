package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import datos.Reserva;
import datos.Usuario;
import negocio.ReservaABM;
import negocio.UsuarioABM;

public class ControladorAjaxticketxfuncion extends HttpServlet{
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
			
			ReservaABM rabm = ReservaABM.getInstancia();
			//error=2;
			List<String> lista = new ArrayList<String>() ;
			
			lista.add("prueba1");
			lista.add("prueba2");
			lista.add("prueba3");

			
			Usuario u = usuarioAbm.traerUsuario(idusuario);
			
			request.setAttribute("idusuario",idusuario);
			request.setAttribute("usuario",u);
			request.setAttribute("lista",lista);
			request.getRequestDispatcher("/ajaxticketxfuncion.jsp").forward(request , response);
		}
		catch (Exception e) {
			if(error==0){
			response.sendError(500, "hubo un problemas trayendo el id de usuario");
			}
			
			if(error==2){
				response.sendError(500, "error2");
				}
			
		}
	}
}
