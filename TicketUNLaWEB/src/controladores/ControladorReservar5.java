package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Usuario;
import funciones.Funciones;
import datos.Auditorio;
import datos.Butaca;
import datos.Entrada;
import datos.Evento;
import datos.Funcion;
import datos.Reserva;
import datos.TipoUsuario;
import negocio.AuditorioABM;
import negocio.ButacaABM;
import negocio.EntradaABM;
import negocio.EventoABM;
import negocio.FuncionABM;
import negocio.ReservaABM;
import negocio.UsuarioABM;

public class ControladorReservar5 extends HttpServlet {
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
		AuditorioABM aabm = AuditorioABM.getInstancia();
		EventoABM eabm = EventoABM.getInstancia();
		FuncionABM fabm = FuncionABM.getInstancia();
		ReservaABM rabm = ReservaABM.getInstancia();
		int error=0;
		
		int idauditorio = Integer.parseInt(request.getParameter("idauditorio"));
		int idusuario = Integer.parseInt(request.getParameter("idusuario"));
		int idevento = Integer.parseInt(request.getParameter("idevento"));
		int idfuncion = Integer.parseInt(request.getParameter("idfuncion"));
		
		
		String select[] = request.getParameterValues("idbutaca"); 
		if (select != null && select.length != 0) {
		System.out.println("seleccionaste: ");
			for (int i = 0; i < select.length; i++) {
				System.out.println(select[i]); 
			}
		}
		
		//int idusuario = request.getParameter("idusuario");
		
		
		try {
			Usuario u = usuarioAbm.traerUsuarioHql(idusuario);
			Funcion f = fabm.traerFuncionHql(idfuncion);
			Reserva r = new Reserva(u, false);
				Set<Entrada> lstEntradas = new  HashSet<Entrada>();
			
			if (select != null && select.length != 0) {
				System.out.println(" ");
					for (int i = 0; i < select.length; i++) {
						Butaca b = butacaAbm.traerButacaHql(Integer.parseInt(select[i]));
						Entrada e = new Entrada(b, f, "123asd", r);

						lstEntradas.add(e);
						//System.out.println(select[i]); 
					}
			}
			r.setLstEntradas(lstEntradas);
			r.setPrecioTotal(r.calcularTotal());
			rabm.agregar(u, lstEntradas, 0, false);
			
			for(Entrada e: lstEntradas) {
				
				entradaAbm.agregar(e.getButaca(), e.getFuncion(), e.getCodigo(), rabm.traerReserva(rabm.traerReserva().size()));
			}

			request.setAttribute("idusuario",idusuario);
			request.setAttribute("idauditorio",idauditorio);
			request.setAttribute("idevento",idevento);
			request.setAttribute("idfuncion",idfuncion);
			request.setAttribute("idbutaca",select);
			request.setAttribute("precio", r.getPrecioTotal());
			request.getRequestDispatcher("/reservar5.jsp").forward(request , response);

			
		}
		catch (Exception e) {
			if(error==0){
			response.sendError(500, "hubo un problema trayendo el id de usuario");
			}
			
		}
	}
}