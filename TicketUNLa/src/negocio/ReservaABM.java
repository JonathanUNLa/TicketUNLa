package negocio;

import java.util.List;
import java.util.Set;

import dao.ReservaDao;
import datos.Entrada;
import datos.Reserva;
import datos.Usuario;


public class ReservaABM {
	private static ReservaABM instancia;
	protected ReservaDao dao;
	
	protected ReservaABM() {
		dao = new ReservaDao();
	}
	
	public static ReservaABM getInstancia() {
		if (instancia == null) 
			instancia = new ReservaABM();
		return instancia;
	}
	
	public Reserva traerReserva(int idReserva)throws Exception {
		Reserva reserva = dao.traerReserva(idReserva);
		if(reserva == null)throw new Exception("La Reserva no existe");
		return reserva;
	}
	public Reserva traerReservaHql(int idReserva)throws Exception {
		Reserva reserva = dao.traerReserva(idReserva);
		if(reserva == null)throw new Exception("La Reserva no existe");
		return reserva;
	}
	
	public List<Reserva> traerReserva(){
		return dao.traerReserva();
	}
	
	public int agregar(Usuario usuario,boolean entregado) {
		Reserva reserva = new Reserva(usuario,  entregado);
		return dao.agregar(reserva);
	}
	
	public int agregar(Usuario usuario, Set<Entrada> lstEntradas,double precioTotal,boolean entregado) {
		Reserva reserva = new Reserva(usuario, lstEntradas,precioTotal, entregado);
		return dao.agregar(reserva);
	}
	public void modificar(Reserva reserva) {
		dao.actualizar(reserva);
	}
	
	public void eliminar(int idReserva)throws Exception {
		Reserva reserva = dao.traerReserva(idReserva);
		if(reserva == null)throw new Exception("La Butaca no existe");
		dao.eliminar(reserva);
	}
}
