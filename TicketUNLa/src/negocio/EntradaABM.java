package negocio;

import java.util.List;

import dao.EntradaDao;
import datos.Butaca;
import datos.Entrada;
import datos.Funcion;
import datos.Seccion;
import datos.Usuario;

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
	
	public List<Entrada> traerEntrada(){
		return dao.traerEntrada();
	}
	
	public int agregar(Seccion seccion,Butaca butaca, Funcion funcion,Usuario usuario, double precioFinal) {
		Entrada entrada = new Entrada(seccion,butaca,usuario,funcion,precioFinal);
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
