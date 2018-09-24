package negocio;

import java.util.List;

import dao.CodigoDescuentoDao;
import datos.CodigoDescuento;
import datos.Funcion;
import datos.Seccion;


public class CodigoDescuentoABM {
	CodigoDescuentoDao dao = new CodigoDescuentoDao(); 
	
	public CodigoDescuento traerCodigoDescuento(int idCodigo)throws Exception {
		CodigoDescuento butaca = dao.traerCodigoDescuento(idCodigo);
		if(butaca == null)throw new Exception("El Codigo no existe");
		return butaca;
	}
	
	public List<CodigoDescuento> traerCodigoDescuento(){
		return dao.traerCodigoDescuento();
	}
	
	public int agregar(String codigo,double descuento,Seccion seccion, Funcion funcion) {
		CodigoDescuento codigoDesc = new CodigoDescuento(codigo,descuento,seccion,funcion);
		return dao.agregar(codigoDesc);
	}
	
	public void modificar(CodigoDescuento codigoDesc) {
		dao.actualizar(codigoDesc);
	}
	
	public void eliminar(int idCodigo)throws Exception {
		CodigoDescuento codigoDesc = dao.traerCodigoDescuento(idCodigo);
		if(codigoDesc == null)throw new Exception("El codigo no existe");
		dao.eliminar(codigoDesc);
	}
}
