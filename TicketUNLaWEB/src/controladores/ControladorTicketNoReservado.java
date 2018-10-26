package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Butaca;
import datos.Funcion;
import datos.Reserva;
import datos.Usuario;
import negocio.ButacaABM;
import negocio.EntradaABM;
import negocio.FuncionABM;
import negocio.ReservaABM;
import negocio.UsuarioABM;

public class ControladorTicketNoReservado extends HttpServlet{
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
			int idfuncion = Integer.parseInt(request.getParameter("funcion"));	
			EntradaABM eabm=EntradaABM.getInstancia();
			FuncionABM fabm= FuncionABM.getInstancia();
			ButacaABM babm= ButacaABM.getInstancia();
			int idauditorio= fabm.traerFuncionHql(idfuncion).getEvento().getAuditorio().getIdAuditorio();
			List<Butaca> bt =babm.traerButacaAuditorio(1);
			List<Butaca> bts =eabm.traerEntradaFuncion(idfuncion);
			int x=0 ;
			while(x<bts.size()) {
				bt.remove(bts.get(x));
				x++;
			}		
			request.setAttribute("bt",bt);
			request.getRequestDispatcher("/TicketNoReservado.jsp").forward(request , response);
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
