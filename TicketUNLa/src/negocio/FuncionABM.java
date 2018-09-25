package negocio;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

import dao.FuncionDao;
import datos.CodigoDescuento;
import datos.DiaDescuento;
import datos.Evento;
import datos.Funcion;

public class FuncionABM {
	private static FuncionABM instancia;
	protected FuncionDao dao;
	
	protected FuncionABM() {
		dao = new FuncionDao();
	}
	
	public static FuncionABM getInstancia() {
		if (instancia == null) 
			instancia = new FuncionABM();
		return instancia;
	}
	
	public Funcion traerEntrada(int idFuncion)throws Exception {
		Funcion funcion = dao.traerFuncion(idFuncion);
		if(funcion == null)throw new Exception("La funcion no existe");
		return funcion;
	}
	
	public List<Funcion> traerCodigoDescuento(){
		return dao.traerFuncion();
	}
	
	public int agregar(double precioBase, GregorianCalendar diaHora,Evento evento,double descuento, Set<CodigoDescuento> lstCodDesc,DiaDescuento diaDescuento) {
		Funcion funcion = new Funcion(precioBase,diaHora,evento,descuento,diaDescuento,lstCodDesc);
		return dao.agregar(funcion);
	}
	
	public void modificar(Funcion funcion) {
		dao.actualizar(funcion);
	}
	
	public void eliminar(int idFuncion)throws Exception {
		Funcion funcion = dao.traerFuncion(idFuncion);
		if(funcion == null)throw new Exception("La funcion no existe");
		dao.eliminar(funcion);
	}
}