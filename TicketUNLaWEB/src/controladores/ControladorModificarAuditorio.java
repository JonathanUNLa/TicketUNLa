package controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Auditorio;
import datos.Seccion;
import negocio.AuditorioABM;
import negocio.SeccionABM;

@WebServlet("/ControladorModificarAuditorio")
public class ControladorModificarAuditorio extends HttpServlet {
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
			error=2;
			AuditorioABM abm= AuditorioABM.getInstancia();
			List<Auditorio> auditorio= abm.traerAuditorio();
			request.setAttribute("auditorio",auditorio);
			SeccionABM sabm= SeccionABM.getInstancia();
			List<Seccion> seccion= sabm.traerSeccion();
			request.setAttribute("seccion",seccion);
			request.getRequestDispatcher("/ModificarAuditorio.jsp").forward(request , response);
		}
		catch (Exception e) {
			
			if(error==2){
				response.sendError(500, "error2");
				}
			
		}
	}

}
