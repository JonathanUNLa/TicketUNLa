package negocio;

import java.util.List;

import dao.EventoDao;
import datos.Auditorio;
import datos.Evento;


public class EventoABM {
	private static EventoABM instancia;
	protected EventoDao dao;
	
	protected EventoABM() {
		dao = new EventoDao();
	}
	
	public static EventoABM getInstancia() {
		if (instancia == null) 
			instancia = new EventoABM();
		return instancia;
	}
	
	public Evento traerEvento(int idEvento)throws Exception {
		Evento evento = dao.traerEvento(idEvento);
		if(evento == null)throw new Exception("El evento no existe");
		return evento;
	}
	
	public List<Evento> traerEvento(String auditorio)throws Exception {
		return dao.traerEvento(auditorio);
	}
	
	public Evento traerEventoHql(int idEvento)throws Exception {
		Evento evento = dao.traerEventoHql(idEvento);
		if(evento == null)throw new Exception("El evento no existe");
		return evento;
	}
	
	public Evento traerEventoAuditorio(String nombre, int idAuditorio)throws Exception {
		Evento evento = dao.traerEventoAuditorio(nombre, idAuditorio);
		if(evento == null)throw new Exception("El evento no existe");
		return evento;
	}
	
	public List<Evento> traerEvento(){
		return dao.traerEvento();
	}
	
	public int agregar(String nombre, Auditorio auditorio)throws Exception {
		if(dao.traerEventoAuditorio(nombre, auditorio.getIdAuditorio())!=null)throw new Exception("El evento en ese auditorio ya existe");
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