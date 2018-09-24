package negocio;

import java.util.GregorianCalendar;
import java.util.List;

import dao.FuncionDao;
import datos.CodigoDescuento;
import datos.DiaDescuento;
import datos.Evento;
import datos.Funcion;
import datos.Seccion;

public class FuncionABM {
	FuncionDao dao = new FuncionDao();
	
	public Funcion traerFuncion(int idFuncion) throws Exception {
		Funcion funcion = dao.traerFuncion(idFuncion);
		if (funcion==null) throw new Exception("La Funcion no existe");
		return funcion;
	}
	
	public List<Funcion> traerFuncion() throws Exception {
		return dao.traerFuncion();
	}
	
	public int agregar(double precioBase, GregorianCalendar diaHora, Evento evento,
			double descuento,DiaDescuento diaDescuento, List<CodigoDescuento> lstCodDesc) {
		Funcion funcion = new Funcion(precioBase,diaHora,evento,descuento,diaDescuento,lstCodDesc);
		return dao.agregar(funcion);
	}
	
	public void modificar(Funcion funcion) {
		dao.actualizar(funcion);
	}
	
	public void eliminar(int idFuncion) throws Exception {
		Funcion funcion = dao.traerFuncion(idFuncion);
		if(funcion == null)throw new Exception("La Funcion que desea eliminar no existe");
		dao.eliminar(funcion);
	}

}
