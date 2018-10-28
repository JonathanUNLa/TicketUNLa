package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Auditorio;
import datos.Butaca;
import datos.Entrada;
import datos.Evento;
import datos.Funcion;
import datos.Reserva;
import datos.Seccion;
import datos.TipoAuditorio;
import datos.TipoBeneficio;
import datos.TipoUsuario;
import datos.Usuario;
import funciones.Funciones;
import negocio.AuditorioABM;
import negocio.ButacaABM;
import negocio.EntradaABM;
import negocio.EventoABM;
import negocio.FuncionABM;
import negocio.ReservaABM;
import negocio.SeccionABM;
import negocio.TipoAuditorioABM;
import negocio.TipoBeneficioABM;
import negocio.TipoUsuarioABM;
import negocio.UsuarioABM;

public class ControladorCrearEvento extends HttpServlet{
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

			AuditorioABM aabm= AuditorioABM.getInstancia();
			EventoABM eabm= EventoABM.getInstancia();
			String nombre = request.getParameter("nombre");
			int idAuditorio = Integer.parseInt(request.getParameter("auditorio"));
			

			Auditorio audi = aabm.traerAuditorio(idAuditorio);
			
			if(eabm.validarEvento(nombre, audi)==true) {
				error=3;
			}
			
			eabm.agregar(nombre, audi);
			
			String respuesta= "El Evento "+nombre+" fue creado con exito";
			
			request.setAttribute("respuesta",respuesta);
			request.getRequestDispatcher("/CrearAuditorio.jsp").forward(request , response);
		}
		catch (Exception e) {
			if(error==0){
			response.sendError(500, "hubo un problemas en alguna parte de crear auditorio");
			}
			
			if(error==2){
				response.sendError(500, "tu vieja");
			}
			
			if(error==3){
				response.sendError(500, "No se puede repetir eventos");
			}
		}
	}
}
