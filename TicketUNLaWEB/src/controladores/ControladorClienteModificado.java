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
import datos.TipoBeneficio;
import datos.TipoUsuario;
import datos.Usuario;
import funciones.Funciones;
import negocio.AuditorioABM;
import negocio.ButacaABM;
import negocio.EntradaABM;
import negocio.FuncionABM;
import negocio.ReservaABM;
import negocio.SeccionABM;
import negocio.TipoBeneficioABM;
import negocio.TipoUsuarioABM;
import negocio.UsuarioABM;

public class ControladorClienteModificado extends HttpServlet{
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
			TipoBeneficioABM tabm= TipoBeneficioABM.getInstancia();
			TipoUsuarioABM tuabm= TipoUsuarioABM.getInstancia();
			AuditorioABM aabm=AuditorioABM.getInstancia();
			UsuarioABM uabm=UsuarioABM.getInstancia();
			
			int id = Integer.parseInt(request.getParameter("idUsuario"));
			int dni = Integer.parseInt(request.getParameter("dni"));
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String telefono = request.getParameter("telefono");
			String nombreUsuario = request.getParameter("nombreUsuario");
			String contraseña = request.getParameter("password");
			int idTipoUsuario = Integer.parseInt(request.getParameter("tipoUsuario"));
			int idTipoBeneficio = Integer.parseInt(request.getParameter("tipoBeneficio"));
		
			
			
			TipoBeneficio tipob=null;
			Auditorio audi=null;
			
			System.out.println(nombre+" "+apellido+" "+telefono+" "+nombreUsuario+" "+contraseña+"  "+idTipoUsuario+" "+idTipoBeneficio );
			if(idTipoBeneficio!=3) {
				 tipob= tabm.traerTipoBeneficio(idTipoBeneficio);
			}
		
			
			TipoUsuario tipou = tuabm.traerTipoUsuario(idTipoUsuario);
			
			
			Usuario user= uabm.traerUsuario(id);
			user.setDni(dni);
			user.setNombre(nombre);
			user.setApellido(apellido);
			user.setNombreUsuario(nombreUsuario);
			user.setContraseña(contraseña);
			user.setTipoUsuario(tipou);
			user.setTipoBeneficio(tipob);
			uabm.modificar(user);
			//uabm.agregar(dni, nombre, apellido, telefono, nombreUsuario, contraseña, tipou, tipob, audi);
			
			String respuesta= "El usuario "+nombre+" fue modificado con exito";
			
			request.setAttribute("respuesta",respuesta);
			request.getRequestDispatcher("/ClienteModificado.jsp").forward(request , response);
		}
		catch (Exception e) {
			if(error==0){
			response.sendError(500, "hubo un problemas en alguna parte de modificar cliente");
			}
			
			if(error==2){
				response.sendError(500, "tu vieja");
			}
			
		}
	}
}
