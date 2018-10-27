package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Evento;
import datos.Funcion;
import datos.Reserva;
import datos.TipoBeneficio;
import datos.Usuario;
import negocio.EventoABM;
import negocio.FuncionABM;
import negocio.ReservaABM;
import negocio.TipoBeneficioABM;
import negocio.UsuarioABM;

public class ControladorAjaxticketxfuncion extends HttpServlet{
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
		
		int idusuario = Integer.parseInt(request.getParameter("idusuario"));
		
		//int idusuario = request.getParameter("idusuario");
		
		try {
			usuarioAbm.traerUsuario(idusuario);
		} catch (Exception e1) {
			error=0;
		}
		try {
			FuncionABM fabm= FuncionABM.getInstancia();
			EventoABM eabm= EventoABM.getInstancia();
			TipoBeneficioABM tabm= TipoBeneficioABM.getInstancia();
			List<Funcion> funciones= fabm.traerFuncion();
			List<Evento> eventos= eabm.traerEvento();
			List<TipoBeneficio> tipoBeneficio= tabm.traerTipoBeneficio();
			Usuario u = usuarioAbm.traerUsuario(idusuario);
			
			request.setAttribute("idusuario",idusuario);
			request.setAttribute("usuario",u);
			request.setAttribute("lista",funciones);
			request.setAttribute("evento",eventos);
			request.setAttribute("tipoBeneficio",tipoBeneficio);
			request.getRequestDispatcher("/ajaxticketxfuncion.jsp").forward(request , response);
		}
		catch (Exception e) {
			if(error==0){
			response.sendError(500, "hubo un problemas trayendo el id de usuario");
			}
			
			if(error==2){
				response.sendError(500, "error2");
				}
			
		}
	}
}
