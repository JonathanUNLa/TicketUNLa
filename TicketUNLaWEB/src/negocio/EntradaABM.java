package negocio;

import java.util.ArrayList;
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
	
	public Entrada traerEntradaHql(int idEntrada)throws Exception {
		Entrada entrada = dao.traerEntradaHql(idEntrada);
		if(entrada == null)throw new Exception("La Entrada no existe");
		return entrada;
	}
	
	public List<Entrada> traerEntrada(){
		return dao.traerEntrada();
	}
	
	public List<Butaca> traerEntradaFuncion(int funcion){
		List<Butaca>but=new ArrayList();
		for(Entrada e: dao.traerEntradaFuncion(funcion)){
			but.add(e.getButaca());
		}
		return but;
	}
	
	public int agregar(Butaca butaca, Funcion funcion, String codigo, Reserva reserva) {
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
