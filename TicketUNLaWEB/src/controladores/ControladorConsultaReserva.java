package controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Entrada;
import datos.Reserva;
import datos.Usuario;
import negocio.EntradaABM;
import negocio.ReservaABM;
import negocio.UsuarioABM;

public class ControladorConsultaReserva extends HttpServlet{
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
			
			EntradaABM eabm = EntradaABM.getInstancia();
			//error=2;
			List<Entrada> entradas= eabm.traerReservaUsuario(idusuario);
			error=2;
			Usuario u = usuarioAbm.traerUsuario(idusuario);
			request.setAttribute("idusuario",idusuario);
			request.setAttribute("usuario",u);
			request.setAttribute("entradas",entradas);
			request.getRequestDispatcher("/reservasUsuario.jsp").forward(request , response);
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
