package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Auditorio;
import datos.Funcion;
import datos.Reserva;
import datos.Seccion;
import datos.TipoBeneficio;
import datos.TipoUsuario;
import datos.Usuario;
import negocio.AuditorioABM;
import negocio.FuncionABM;
import negocio.ReservaABM;
import negocio.SeccionABM;
import negocio.TipoBeneficioABM;
import negocio.TipoUsuarioABM;
import negocio.UsuarioABM;

public class ControladorAltaAuditorio extends HttpServlet{
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
		

		try {
			error=2;
			SeccionABM abm= SeccionABM.getInstancia();
			List<Seccion> seccion= abm.traerSeccion();
			request.setAttribute("seccion",seccion);
			request.getRequestDispatcher("/AltaAuditorio.jsp").forward(request , response);
		}
		catch (Exception e) {
			
			if(error==2){
				response.sendError(500, "error2");
				}
			
		}
	}
}
