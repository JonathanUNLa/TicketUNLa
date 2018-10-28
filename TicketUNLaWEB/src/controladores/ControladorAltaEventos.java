package controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Auditorio;
import datos.Evento;
import datos.Funcion;
import negocio.AuditorioABM;
import negocio.EventoABM;
import negocio.FuncionABM;
import negocio.UsuarioABM;

public class ControladorAltaEventos {
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
		
		EventoABM eventoAbm = EventoABM.getInstancia();
		int error=0;
		

		try {
			error=2;
			AuditorioABM abm= AuditorioABM.getInstancia();
			List<Auditorio> auditorios= abm.traerAuditorio();
			request.setAttribute("auditorios",auditorios);
			request.getRequestDispatcher("/AltaEvento.jsp").forward(request , response);
		}
		catch (Exception e) {
			
			if(error==2){
				response.sendError(500, "error2");
				}
			
		}
	}
}
