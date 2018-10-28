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
import datos.DiaDescuento;
import datos.Entrada;
import datos.Evento;
import datos.Funcion;
import datos.Reserva;
import datos.Seccion;
import datos.TipoBeneficio;
import datos.TipoUsuario;
import datos.Usuario;
import funciones.Funciones;
import negocio.AuditorioABM;
import negocio.ButacaABM;
import negocio.DiaDescuentoABM;
import negocio.EntradaABM;
import negocio.EventoABM;
import negocio.FuncionABM;
import negocio.ReservaABM;
import negocio.SeccionABM;
import negocio.TipoBeneficioABM;
import negocio.TipoUsuarioABM;
import negocio.UsuarioABM;

public class ControladorCrearFuncion extends HttpServlet{
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
			
			EventoABM eabm= EventoABM.getInstancia();
			DiaDescuentoABM tuabm= DiaDescuentoABM.getInstancia();
			FuncionABM aabm=FuncionABM.getInstancia();
				
			int precioBase = Integer.parseInt(request.getParameter("precioBase"));
			String fecha = request.getParameter("diaHora");
			int idEvento = Integer.parseInt(request.getParameter("idEvento"));
			int idDiaDescuento = Integer.parseInt(request.getParameter("idDiaDescuento"));
			
			Evento evento=eabm.traerEvento(idEvento);
			DiaDescuento diaDescuento=tuabm.traerDiaDescuento(idDiaDescuento);
			GregorianCalendar fechaHora= Funciones.traerFechaHoraInput(fecha);
		
			aabm.agregar(precioBase, fechaHora, evento, diaDescuento); 
			
			
			String respuesta= "La funcion fue creado con exito";
			
			request.setAttribute("respuesta",respuesta);
			request.getRequestDispatcher("/CrearFuncion.jsp").forward(request , response);
		}
		catch (Exception e) {
			if(error==0){
			response.sendError(500, "hubo un problemas en alguna parte de crear cliente");
			}
			
			if(error==2){
				response.sendError(500, "tu vieja");
			}
			
		}
	}
}
