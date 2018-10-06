package negocio;

import java.util.List;

import dao.DiaDescuentoDao;
import datos.DiaDescuento;

public class DiaDescuentoABM {
	private static DiaDescuentoABM instancia;
	protected DiaDescuentoDao dao;
	
	protected DiaDescuentoABM() {
		dao = new DiaDescuentoDao();
	}
	
	public static DiaDescuentoABM getInstancia() {
		if (instancia == null) 
			instancia = new DiaDescuentoABM();
		return instancia;
	}
	
	
	public DiaDescuento traerDiaDescuento(int idDiaDescuento)throws Exception {
		DiaDescuento diaDescuento = dao.traerDiaDescuento(idDiaDescuento);
		if(diaDescuento == null)throw new Exception("El Dia de Descuento no existe");
		return diaDescuento;
	}
	
	public DiaDescuento traerDiaDescuento(String dia)throws Exception {
		DiaDescuento diaDescuento = dao.traerDiaDescuento(dia);
		if(diaDescuento == null)throw new Exception("El Dia de Descuento no existe");
		return diaDescuento;
	}
	
	public List<DiaDescuento> traerDiaDescuento(){
		return dao.traerDiaDescuento();
	}
	
	public int agregar(String dia, double descuento)throws Exception {
		if(dao.traerDiaDescuento(dia) != null)throw new Exception("El Dia de Descuento ya existe");
		DiaDescuento diaDescuento = new DiaDescuento(dia,descuento);
		return dao.agregar(diaDescuento);
	}
	
	public void modificar(DiaDescuento diaDescuento) {
		dao.actualizar(diaDescuento);
	}
	
	public void eliminar(int idDiaDescuento)throws Exception {
		DiaDescuento diaDescuento = dao.traerDiaDescuento(idDiaDescuento);
		if(diaDescuento == null)throw new Exception("La DiaDescuento no existe");
		dao.eliminar(diaDescuento);
	}

}
