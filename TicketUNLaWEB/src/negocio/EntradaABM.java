package negocio;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import dao.EntradaDao;
import datos.Butaca;
import datos.Entrada;
import datos.Funcion;
import datos.Reserva;

public class EntradaABM {
	private static EntradaABM instancia;
	protected EntradaDao dao;
	
	protected EntradaABM() {
		dao = new EntradaDao();
	}
	
	public static EntradaABM getInstancia() {
		if (instancia == null) 
			instancia = new EntradaABM();
		return instancia;
	}
	
	public Entrada traerEntrada(int idEntrada)throws Exception {
		Entrada entrada = dao.traerEntrada(idEntrada);
		if(entrada == null)throw new Exception("La Entrada no existe");
		return entrada;
	}
	
	public Entrada traerFuncionEntrada(int idFuncion, int idButaca)throws Exception {
		Entrada entrada = dao.traerFuncionEntrada(idFuncion, idButaca);
		if(entrada == null)throw new Exception("La Entrada no existe");
		return entrada;
	}
	
	public Entrada traerEntradaHql(int idEntrada)throws Exception {
		Entrada entrada = dao.traerEntradaHql(idEntrada);
		if(entrada == null)throw new Exception("La Entrada no existe");
		return entrada;
	}
	
	public List<Entrada> traerEntrada(){
		return dao.traerEntrada();
	}
	
	public List<Entrada> traerEntradasTipoUsuario(int idTipoUsuario, GregorianCalendar fInicio, GregorianCalendar fFin){
		List<Entrada> entradas = new ArrayList();
		for(Entrada e: dao.traerEntradasTipoUsuario(idTipoUsuario, fInicio, fFin)) {
			double precioBase=e.getButaca().getSeccion().getPrecioSeccion()+e.getFuncion().getPrecioBase();
			if(precioBase!=e.getPrecioFinal()) {
				entradas.add(e);
			}
		}
		return entradas;
	}
	
	public List<Entrada> traerEntradasEvento(int idEvento, GregorianCalendar fInicio, GregorianCalendar fFin){
		return dao.traerEntradasEvento(idEvento, fInicio, fFin);
	}
	
	public List<Entrada> traerEntradasFuncionSeccion(int idFuncion, int idSeccion, GregorianCalendar fInicio, GregorianCalendar fFin){
		List<Entrada> entradas = new ArrayList();
		for(Entrada e: dao.traerEntradasFuncionSeccion(idFuncion, fInicio, fFin)) {
			if(e.getButaca().getSeccion().getIdSeccion()==idSeccion) {
				entradas.add(e);
			}
		}
		return entradas;
	}
	
	public List<Entrada> traerEntradasEventoCliente(int idEvento, int idUsuario, GregorianCalendar fInicio, GregorianCalendar fFin){
		List<Entrada> entradas = new ArrayList();
		for(Entrada e: dao.traerEntradasEvento(idEvento, fInicio, fFin)) {
			if(e.getReserva().getUsuario().getIdUsuario()==idUsuario) {
				entradas.add(e);
			}
		}
		return entradas;
	}
	
	public List<Entrada> traerEntradaDescuento(){
		List<Entrada> entradas = new ArrayList();
		for (Entrada e: dao.traerEntrada()) {
			double precioBase=e.getButaca().getSeccion().getPrecioSeccion()+e.getFuncion().getPrecioBase();
			if(precioBase!=e.getPrecioFinal()) {
				entradas.add(e);
			}
		}
		
		return entradas;
	}
	
	public List<Butaca> traerEntradaFuncion(int funcion){
		List<Butaca>but=new ArrayList();
		for(Entrada e: dao.traerEntradaFuncion(funcion)){
			but.add(e.getButaca());
		}
		return but;
	}
	
	public List<Butaca> traerButacasDesocupadas(int funcion){
		List<Butaca>but=new ArrayList();
		for(Entrada e: dao.traerEntradaFuncion(funcion)){
			but.add(e.getButaca());
		}
		return but;
	}
	
	public List<Entrada> traerReservaUsuario(int idUsuario)throws Exception {
		List<Entrada> entradas = dao.traerReservaUsuario(idUsuario);
		if(entradas == null)throw new Exception("El usuario no tiene entradas");
		return entradas;
	}
	
	
	public int agregar(Butaca butaca, Funcion funcion, String codigo, Reserva reserva)throws Exception {
		if(dao.traerFuncionEntrada(funcion.getIdFuncion(), butaca.getIdButaca())!=null)throw new Exception("La entrada ya ha sido agregada");
		Entrada entrada = new Entrada(butaca, funcion, codigo, reserva);
		return dao.agregar(entrada);
	}
	
	public void modificar(Entrada entrada) {
		dao.actualizar(entrada);
	}
	
	public void eliminar(int idCodigo)throws Exception {
		Entrada entrada = dao.traerEntrada(idCodigo);
		if(entrada == null)throw new Exception("La entrada no existe");
		dao.eliminar(entrada);
	}
}
