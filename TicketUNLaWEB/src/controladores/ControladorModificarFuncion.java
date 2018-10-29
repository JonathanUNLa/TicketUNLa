package controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Auditorio;
import datos.DiaDescuento;
import datos.Evento;
import datos.Funcion;
import negocio.AuditorioABM;
import negocio.DiaDescuentoABM;
import negocio.EventoABM;
import negocio.FuncionABM;


@WebServlet("/ControladorAltaFunciones")
public class ControladorModificarFuncion extends HttpServlet {
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
		
		FuncionABM funcionAbm = FuncionABM.getInstancia();
		int error=0;
		

		try {
			error=2;
			FuncionABM fabm=FuncionABM.getInstancia();
			EventoABM eabm= EventoABM.getInstancia();
			List<Evento> eventos= eabm.traerEvento();
			
			DiaDescuentoABM dabm= DiaDescuentoABM.getInstancia();
			List<DiaDescuento> diasDescuentos= dabm.traerDiaDescuento();
			List<Funcion> funcion =fabm.traerFuncion();
			request.setAttribute("funcion",funcion);
			request.setAttribute("eventos",eventos);
			request.setAttribute("diasDescuentos",diasDescuentos);
			request.getRequestDispatcher("/ModificarFuncion.jsp").forward(request , response);
		}
		catch (Exception e) {
			
			if(error==2){
				response.sendError(500, "error2");
				}
			
		}
	}

}
