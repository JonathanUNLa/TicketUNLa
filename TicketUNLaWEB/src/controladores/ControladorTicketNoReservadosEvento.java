package controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Butaca;
import datos.Funcion;
import negocio.ButacaABM;
import negocio.EntradaABM;
import negocio.EventoABM;
import negocio.FuncionABM;

@WebServlet("/ControladorTicketNoReservadosEvento")
public class ControladorTicketNoReservadosEvento extends HttpServlet {
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
			int idEvento = Integer.parseInt(request.getParameter("evento"));	
			EntradaABM eabm=EntradaABM.getInstancia();
			FuncionABM fabm= FuncionABM.getInstancia();
			ButacaABM babm= ButacaABM.getInstancia();
			EventoABM evabm= EventoABM.getInstancia();
			fabm.traerFuncion(evabm.traerEvento(idEvento).getNombre());
			List<Funcion> funciones = fabm.traerFuncion(evabm.traerEvento(idEvento).getNombre());
			List<Butaca> bt =babm.traerButacaAuditorio(1);
			/*List<Butaca> bts =eabm.traerEntradaFuncion(f.getIdFuncion());
			int x=0 ;
			while(x<bts.size()) {
				bt.remove(bts.get(x));
				x++;
			}*/		
			request.setAttribute("bt",bt);
			request.getRequestDispatcher("/TicketNoReservadosEvento.jsp").forward(request , response);
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
