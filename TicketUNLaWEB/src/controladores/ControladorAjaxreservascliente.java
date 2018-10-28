package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Evento;
import datos.Funcion;
import datos.Reserva;
import datos.TipoBeneficio;
import datos.Usuario;
import negocio.EventoABM;
import negocio.FuncionABM;
import negocio.ReservaABM;
import negocio.TipoBeneficioABM;
import negocio.UsuarioABM;

public class ControladorAjaxreservascliente extends HttpServlet{
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
		
		int dni = Integer.parseInt(request.getParameter("dni"));
		
		//int idusuario = request.getParameter("idusuario");
		
		try {
			usuarioAbm.traerUsuarioDni(dni);
		} catch (Exception e1) {
			error=0;
		}
		try {
			ReservaABM rabm= ReservaABM.getInstancia();
			Usuario u = usuarioAbm.traerUsuarioDni(dni);
			
			List<Reserva> lr= rabm.traerReservaUsuario(u.getIdUsuario());
			
			request.setAttribute("usuario",u);
			request.setAttribute("lr",lr);
			request.getRequestDispatcher("/ajaxreservascliente.jsp").forward(request , response);
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
