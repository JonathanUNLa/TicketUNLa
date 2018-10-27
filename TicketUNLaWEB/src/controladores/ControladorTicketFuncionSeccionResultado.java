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

public class ControladorTicketFuncionSeccionResultado extends HttpServlet{
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
			int idfuncion = Integer.parseInt(request.getParameter("idfuncion"));
			int idseccion = Integer.parseInt(request.getParameter("seccion"));
			String  fecha1=(String) request.getParameter("fecha1");
			String  fecha2=(String) request.getParameter("fecha2");
			GregorianCalendar f1= Funciones.traerFechaInput(fecha1);
			GregorianCalendar f2= Funciones.traerFechaInput(fecha2);
			System.out.println(fecha1);
			System.out.println(fecha2);
			System.out.println(Funciones.traerFechaCorta(f1));
			System.out.println(Funciones.traerFechaCorta(f2));
			List<Entrada> lista= eabm.traerEntradasFuncionSeccion(idfuncion, idseccion ,f1,f2);
			request.setAttribute("lista",lista);
			request.getRequestDispatcher("/TicketFuncionSeccionResultado.jsp").forward(request , response);
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
