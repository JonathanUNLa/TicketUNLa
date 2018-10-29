package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Auditorio;
import datos.Evento;
import datos.Funcion;
import datos.Reserva;
import datos.TipoBeneficio;
import datos.TipoUsuario;
import datos.Usuario;
import negocio.AuditorioABM;
import negocio.EventoABM;
import negocio.FuncionABM;
import negocio.ReservaABM;
import negocio.TipoBeneficioABM;
import negocio.TipoUsuarioABM;
import negocio.UsuarioABM;

public class ControladorEventoModificado extends HttpServlet{
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
		

		try {
			AuditorioABM aabm= AuditorioABM.getInstancia();
			EventoABM eabm= EventoABM.getInstancia();
			int idEvento = Integer.parseInt(request.getParameter("evento"));
			String nombre = request.getParameter("nombre");
			int idAuditorio = Integer.parseInt(request.getParameter("auditorio"));
			
			
			Auditorio audi = aabm.traerAuditorio(idAuditorio);
			
			Evento eve= eabm.traerEvento(idEvento);
			eve.setAuditorio(audi);
			eve.setNombre(nombre);
			eabm.modificar(eve);
			
			String respuesta= "El Evento "+nombre+" fue modificado con exito";
			
			request.setAttribute("respuesta",respuesta);
			request.getRequestDispatcher("/EventoModificado.jsp").forward(request , response);
			}
		catch (Exception e) {
			
			if(error==2){
				response.sendError(500, "error2");
				}
			
		}
	}
}
