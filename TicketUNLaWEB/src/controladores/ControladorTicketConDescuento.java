package controladores;

import java.io.IOException;
import java.util.ArrayList;
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
import negocio.ButacaABM;
import negocio.EntradaABM;
import negocio.FuncionABM;
import negocio.ReservaABM;
import negocio.UsuarioABM;

public class ControladorTicketConDescuento extends HttpServlet{
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
		List<Entrada> entradas= eabm.traerEntradaDescuento();
		
			request.setAttribute("lista",entradas);
			request.getRequestDispatcher("/TicketConDescuento.jsp").forward(request , response);
		}
		catch (Exception e) {
			if(error==0){
			response.sendError(500, "hubo un problemas al cargar");
			}
			
			if(error==2){
				response.sendError(500, "error2");
				}
			
		}
	}
}
