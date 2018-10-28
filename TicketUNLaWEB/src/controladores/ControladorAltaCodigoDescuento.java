package controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.DiaDescuento;
import datos.Evento;
import datos.Funcion;
import datos.Seccion;
import negocio.CodigoDescuentoABM;
import negocio.DiaDescuentoABM;
import negocio.EventoABM;
import negocio.FuncionABM;
import negocio.SeccionABM;

/**
 * Servlet implementation class ControladorAltaCodigoDescuento
 */
@WebServlet("/ControladorAltaCodigoDescuento")
public class ControladorAltaCodigoDescuento extends HttpServlet {
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
		
		CodigoDescuentoABM codigoDescuentoAbm = CodigoDescuentoABM.getInstancia();
		int error=0;
		

		try {
			error=2;
			SeccionABM sabm= SeccionABM.getInstancia();
			List<Seccion> secciones= sabm.traerSeccion();
			request.setAttribute("secciones",secciones);
			FuncionABM fabm= FuncionABM.getInstancia();
			List<Funcion> funciones= fabm.traerFuncion();
			request.setAttribute("funiones",funciones);
			request.getRequestDispatcher("/AltaCodigoDescuento.jsp").forward(request , response);
		}
		catch (Exception e) {
			
			if(error==2){
				response.sendError(500, "error2");
				}
			
		}
	}

}
