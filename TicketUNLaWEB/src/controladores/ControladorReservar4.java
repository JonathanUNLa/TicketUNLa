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
import negocio.EntradaABM;
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
		EntradaABM entradaAbm= EntradaABM.getInstancia();
		ButacaABM butacaAbm= ButacaABM.getInstancia();
		int error=0;
		
		int idauditorio = Integer.parseInt(request.getParameter("idauditorio"));
		int idusuario = Integer.parseInt(request.getParameter("idusuario"));
		int idevento = Integer.parseInt(request.getParameter("idevento"));
		int idfuncion = Integer.parseInt(request.getParameter("idfuncion"));
		
		/*
		String select[] = request.getParameterValues("idfuncion"); 
		if (select != null && select.length != 0) {
		System.out.println("You have selected: ");
			for (int i = 0; i < select.length; i++) {
				System.out.println(select[i]); 
			}
		}
		*/
		//int idusuario = request.getParameter("idusuario");
		
		
		try {
			Usuario u = usuarioAbm.traerUsuario(idusuario);
			AuditorioABM aabm = AuditorioABM.getInstancia();
			EventoABM eabm = EventoABM.getInstancia();
			FuncionABM fabm = FuncionABM.getInstancia();
			@SuppressWarnings("unused")
			ButacaABM babm = ButacaABM.getInstancia();
			List<Butaca> bt =butacaAbm.traerButacaAuditorio(idauditorio);
			List<Butaca> bts =entradaAbm.traerEntradaFuncion(idfuncion);
			int x=0 ;
			while(x<bts.size()) {
				bt.remove(bts.get(x));
				x++;
			}
			
			
			Auditorio a = aabm.traerAuditorio(idauditorio);
			Evento e = eabm.traerEvento(idevento);
			Funcion f = fabm.traerFuncion(idfuncion);
			
			request.setAttribute("bl",bt);
			request.setAttribute("idusuario",idusuario);
			request.setAttribute("usuario",u);
			request.setAttribute("idauditorio",idauditorio);
			request.setAttribute("auditorio",a);
			request.setAttribute("idevento",idevento);
			request.setAttribute("evento",e);
			request.setAttribute("idfuncion",idfuncion);
			request.setAttribute("funcion",f);


			request.getRequestDispatcher("/reservar4.jsp").forward(request , response);

			
		}
		catch (Exception e) {
			if(error==0){
			response.sendError(500, "hubo un problema trayendo el id de usuario");
			}
			
		}
	}
}