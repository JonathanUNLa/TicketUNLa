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
import datos.Butaca;
import datos.Evento;
import datos.Funcion;
import datos.TipoUsuario;
import negocio.AuditorioABM;
import negocio.ButacaABM;
import negocio.EventoABM;
import negocio.FuncionABM;
import negocio.UsuarioABM;

public class ControladorReservar4 extends HttpServlet {
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
		int idfuncion = Integer.parseInt(request.getParameter("idfuncion"));

		//int idusuario = request.getParameter("idusuario");
		
		
		try {
			//Usuario u = usuarioAbm.traerUsuario(idusuario);
			//AuditorioABM aabm = AuditorioABM.getInstancia();
			//EventoABM eabm = EventoABM.getInstancia();
			//FuncionABM fabm = FuncionABM.getInstancia();
			ButacaABM babm = ButacaABM.getInstancia();
			
			List<Butaca> bl = babm.traerButacaFuncion(idfuncion);
			
			request.setAttribute("bl",bl);
			request.setAttribute("idusuario",idusuario);
			request.setAttribute("idauditorio",idauditorio);
			request.setAttribute("idevento",idevento);
			request.setAttribute("idfuncion",idfuncion);

			request.getRequestDispatcher("/reservar4.jsp").forward(request , response);

			
		}
		catch (Exception e) {
			if(error==0){
			response.sendError(500, "hubo un problema trayendo el id de usuario");
			}
			
		}
	}
}