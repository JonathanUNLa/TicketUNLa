package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Butaca;
import datos.Entrada;
import datos.Funcion;
import datos.Reserva;
import datos.Usuario;
import funciones.Funciones;
import negocio.ButacaABM;
import negocio.EntradaABM;
import negocio.FuncionABM;
import negocio.ReservaABM;
import negocio.UsuarioABM;

public class ControladorTicketFechaEvento extends HttpServlet{
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
			String  fecha1=request.getParameter("fecha1");
			String  fecha2=request.getParameter("fecha2");
			GregorianCalendar f1= Funciones.traerFechaInput(fecha1);
			GregorianCalendar f2= Funciones.traerFechaInput(fecha2);
			int idevento = Integer.parseInt(request.getParameter("codigo"));	
			
			EntradaABM eabm=EntradaABM.getInstancia();
			List<Entrada> entradas= eabm.traerEntradasEvento(idevento, f1, f2);
		
			request.setAttribute("entradas",entradas);
			request.getRequestDispatcher("/TicketFechaEvento.jsp").forward(request , response);
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
