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
import negocio.AuditorioABM;
import negocio.EventoABM;
import negocio.FuncionABM;
import negocio.ReservaABM;
import negocio.TipoBeneficioABM;
import negocio.UsuarioABM;

public class ControladorAuditorioseliminadios extends HttpServlet{
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
		
		AuditorioABM auditorioAbm = AuditorioABM.getInstancia();
		int error=0;

		try {
			
			String select[] = request.getParameterValues("idauditorio"); 
			if (select != null && select.length != 0) {
			System.out.println("seleccionados: ");
				for (int i = 0; i < select.length; i++) {
					auditorioAbm.eliminar(Integer.parseInt(select[i]));
				}
			}
			
			for (int i = 0; i < select.length; i++) {
				System.out.println(select[i]); 
			}
			
			
			request.getRequestDispatcher("/auditorioseliminados.jsp").forward(request , response);
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
