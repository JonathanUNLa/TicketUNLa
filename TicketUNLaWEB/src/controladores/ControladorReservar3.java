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
import funciones.Funciones;
import datos.Auditorio;
import datos.Evento;
import datos.Funcion;
import datos.TipoUsuario;
import negocio.AuditorioABM;
import negocio.EventoABM;
import negocio.FuncionABM;
import negocio.UsuarioABM;

public class ControladorReservar3 extends HttpServlet {
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
		
		int idauditorio = Integer.parseInt(request.getParameter("idauditorio"));
		int idusuario = Integer.parseInt(request.getParameter("idusuario"));
		int idevento = Integer.parseInt(request.getParameter("idevento"));

		//int idusuario = request.getParameter("idusuario");
		
		try {
			usuarioAbm.traerUsuario(idusuario);
		} catch (Exception e1) {
			error=0;
		}
		try {
			Usuario u = usuarioAbm.traerUsuario(idusuario);
			AuditorioABM aabm = AuditorioABM.getInstancia();
			EventoABM eabm = EventoABM.getInstancia();
			FuncionABM fabm = FuncionABM.getInstancia();
			
			List<Funcion> fl = fabm.traerFuncion(eabm.traerEvento(idevento).getNombre());
			
			Auditorio a = aabm.traerAuditorio(idauditorio);
			Evento e = eabm.traerEvento(idevento);
			request.setAttribute("fl",fl);
			request.setAttribute("idusuario",idusuario);
			request.setAttribute("usuario",u);
			request.setAttribute("idauditorio",idauditorio);
			request.setAttribute("auditorio",a);
			request.setAttribute("idevento",idevento);
			request.setAttribute("evento",e);
			
			request.getRequestDispatcher("/reservar3.jsp").forward(request , response);

			
		}
		catch (Exception e) {
			if(error==0){
			response.sendError(500, "hubo un problema trayendo el id de usuario");
			}
			
		}
	}
}