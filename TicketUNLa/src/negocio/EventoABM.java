package negocio;

import java.util.List;

import dao.EventoDao;
import datos.Auditorio;
import datos.Evento;


public class EventoABM {
	
	EventoDao dao = new EventoDao(); 
	
	public Evento traerEntrada(int idEvento)throws Exception {
		Evento evento = dao.traerEvento(idEvento);
		if(evento == null)throw new Exception("El evento no existe");
		return evento;
	}
	
	public List<Evento> traerCodigoDescuento(){
		return dao.traerEvento();
	}
	
	public int agregar(String nombre, Auditorio auditorio) {
		Evento evento = new Evento(nombre,auditorio);
		return dao.agregar(evento);
	}
	
	public void modificar(Evento evento) {
		dao.actualizar(evento);
	}
	
	public void eliminar(int idEvento)throws Exception {
		Evento evento = dao.traerEvento(idEvento);
		if(evento == null)throw new Exception("El evento no existe");
		dao.eliminar(evento);
	}
}