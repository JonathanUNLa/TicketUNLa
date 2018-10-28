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
	
	public Funcion traerFuncionHql(int idFuncion)throws Exception {
		Funcion funcion = dao.traerFuncionHql(idFuncion);
		if(funcion == null)throw new Exception("La funcion no existe");
		return funcion;
	}
	
	public List<Funcion> traerFuncion(String evento)throws Exception {
		return dao.traerFuncion(evento);
	}
	
	public Funcion traerFuncion(int idFuncion)throws Exception {
		Funcion funcion = dao.traerFuncion(idFuncion);
		if(funcion!=null){
			return funcion;
		}else throw new Exception ("id de Funcion no existe");
	}
	
	public List<Funcion> traerFuncion(){
		return dao.traerFuncion();
	}
	
	public int agregar(double precioBase, GregorianCalendar diaHora,Evento evento,  Set<CodigoDescuento> lstCodDesc,DiaDescuento diaDescuento)throws Exception {
		boolean existe=false;
		for(Funcion f: dao.traerFuncion(evento.getNombre())) {
			if(f.getDiaHora().equals(diaHora)) {
				existe=true;
			}
		}
		if(existe) throw new Exception ("La Funcion ya existe");
		Funcion funcion = new Funcion(precioBase,diaHora,evento, diaDescuento,lstCodDesc);
		return dao.agregar(funcion);
	}
	
	public int agregar(double precioBase, GregorianCalendar diaHora,Evento evento, DiaDescuento diaDescuento)throws Exception {
		boolean existe=false;
		for(Funcion f: dao.traerFuncion(evento.getNombre())) {
			if(f.getDiaHora().equals(diaHora)) {
				existe=true;
			}
		}
		if(existe) throw new Exception ("La Funcion ya existe");
		Funcion funcion = new Funcion(precioBase,diaHora,evento, diaDescuento);
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