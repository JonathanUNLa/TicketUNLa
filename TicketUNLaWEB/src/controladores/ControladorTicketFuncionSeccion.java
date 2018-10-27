package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Auditorio;
import datos.Butaca;
import datos.Funcion;
import datos.Reserva;
import datos.Seccion;
import datos.Usuario;
import negocio.AuditorioABM;
import negocio.ButacaABM;
import negocio.EntradaABM;
import negocio.FuncionABM;
import negocio.ReservaABM;
import negocio.SeccionABM;
import negocio.UsuarioABM;

public class ControladorTicketFuncionSeccion extends HttpServlet{
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
		int error=0;
	
		try {
			int idfuncion = Integer.parseInt(request.getParameter("funcion"));	
			AuditorioABM aabm=AuditorioABM.getInstancia();
			FuncionABM fabm=FuncionABM.getInstancia();
			SeccionABM sabm=SeccionABM.getInstancia();
			int idAuditorio = fabm.traerFuncionHql(idfuncion).getEvento().getAuditorio().getIdAuditorio();
			Auditorio auditorio = aabm.traerAuditorioHql(idAuditorio);
			List<Seccion> secciones=sabm.traerSeccionAuditorio(idAuditorio);
			request.setAttribute("idfuncion",idfuncion);
			request.setAttribute("auditorio",auditorio);
			request.setAttribute("secciones",secciones);
			request.getRequestDispatcher("/TicketFuncionSeccion.jsp").forward(request , response);
		}
		catch (Exception e) {
			if(error==0){
			response.sendError(500, "hubo un problemas trayendo el id la Funcion");
			}
			
			if(error==2){
				response.sendError(500, "error2");
				}
			
		}
	}
}
