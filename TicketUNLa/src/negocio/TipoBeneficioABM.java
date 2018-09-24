package negocio;

import java.util.List;

import dao.TipoBeneficioDao;
import datos.TipoBeneficio;

public class TipoBeneficioABM {
	TipoBeneficioDao dao = new TipoBeneficioDao();
	
	public TipoBeneficio traerTipoBeneficio(int idTipoBeneficio) throws Exception {
		TipoBeneficio tipoBeneficio = dao.traerTipoBeneficio(idTipoBeneficio);
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