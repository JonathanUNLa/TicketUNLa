package negocio;

import java.util.List;

import dao.TipoBeneficioDao;
import datos.TipoBeneficio;

public class TipoBeneficioABM {
	private static TipoBeneficioABM instancia;
	protected TipoBeneficioDao dao;
	
	protected TipoBeneficioABM() {
		dao = new TipoBeneficioDao();
	}
	
	public static TipoBeneficioABM getInstancia() {
		if (instancia == null) 
			instancia = new TipoBeneficioABM();
		return instancia;
	}
	
	public TipoBeneficio traerTipoBeneficio(int idTipoBeneficio) throws Exception {
		TipoBeneficio tipoBeneficio = dao.traerTipoBeneficio(idTipoBeneficio);
		if (tipoBeneficio==null) throw new Exception("El Tipo de Beneficio no existe");
		return tipoBeneficio;
	}
	
	public TipoBeneficio traerTipoBeneficio(String beneficio) throws Exception {
		TipoBeneficio tipoBeneficio = dao.traerTipoBeneficio(beneficio);
		if (tipoBeneficio==null) throw new Exception("El Tipo de Beneficio no existe");
		return tipoBeneficio;
	}
	
	public List<TipoBeneficio> traerTipoBeneficio() throws Exception {
		return dao.traerTipoBeneficio();
	}
	
	public int agregar(String beneficio, double descuento) {
		TipoBeneficio tipoBeneficio = new TipoBeneficio(beneficio,descuento);
		return dao.agregar(tipoBeneficio);
	}
	
	public void modificar(TipoBeneficio tipoBeneficio) {
		dao.actualizar(tipoBeneficio);
	}
	
	public void eliminar(int idTipoBeneficio) throws Exception {
		TipoBeneficio tipoBeneficio = dao.traerTipoBeneficio(idTipoBeneficio);
		if(tipoBeneficio == null)throw new Exception("El Tipo de Beneficio que desea eliminar no existe");
		dao.eliminar(tipoBeneficio);
	}

}