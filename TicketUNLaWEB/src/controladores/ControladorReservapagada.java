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

public class ControladorReservapagada extends HttpServlet{
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
		
		int idreserva = Integer.parseInt(request.getParameter("idreserva"));
		
		//int idusuario = request.getParameter("idusuario");

		try {
			ReservaABM rabm= ReservaABM.getInstancia();
			Reserva r = rabm.traerReserva(idreserva);
			
			r.setEntregado(true);
			
			rabm.modificar(r);
			
			request.setAttribute("r",r);
			
			request.getRequestDispatcher("/reservapagada.jsp").forward(request , response);
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
