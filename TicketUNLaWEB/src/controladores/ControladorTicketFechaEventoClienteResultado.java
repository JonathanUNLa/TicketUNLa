package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Auditorio;
import datos.Butaca;
import datos.Entrada;
import datos.Funcion;
import datos.Reserva;
import datos.Seccion;
import datos.Usuario;
import funciones.Funciones;
import negocio.AuditorioABM;
import negocio.ButacaABM;
import negocio.EntradaABM;
import negocio.FuncionABM;
import negocio.ReservaABM;
import negocio.SeccionABM;
import negocio.UsuarioABM;

public class ControladorTicketFechaEventoClienteResultado extends HttpServlet{
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
			EntradaABM eabm=EntradaABM.getInstancia();
			UsuarioABM uabm=UsuarioABM.getInstancia();
			int idusuario = Integer.parseInt(request.getParameter("idusuario"));
			int idevento = Integer.parseInt(request.getParameter("idevento"));
			String  fecha1=(String) request.getParameter("fecha1");
			String  fecha2=(String) request.getParameter("fecha2");
			GregorianCalendar f1= Funciones.traerFechaInput(fecha1);
			GregorianCalendar f2= Funciones.traerFechaInput(fecha2);
			System.out.println(fecha1);
			System.out.println(fecha2);
			System.out.println(Funciones.traerFechaCorta(f1));
			System.out.println(Funciones.traerFechaCorta(f2));
			List<Entrada> lista= eabm.traerEntradasEventoCliente(idevento, idusuario, f1, f2);
			Usuario u= uabm.traerUsuarioHql(idusuario);
			request.setAttribute("lista",lista);
			request.setAttribute("u",u);
			request.getRequestDispatcher("/TicketFechaEventoClienteResultado.jsp").forward(request , response);
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
