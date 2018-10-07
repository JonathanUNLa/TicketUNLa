package composite;

import java.util.ArrayList;
import java.util.List;

import datos.Butaca;
import datos.Funcion;
import negocio.ButacaABM;
import negocio.EntradaABM;

public class BusquedaEntradaFuncion extends FiltroBusqueda {
	private Funcion funcion;

	public BusquedaEntradaFuncion(Funcion funcion) {
		super();
		this.funcion = funcion;
	}

	public List<Butaca> realizarBusqueda(List<Butaca> habitaciones) {
		List<Butaca> aux = new ArrayList<Butaca>();
		
		EntradaABM aabm = EntradaABM.getInstancia();
		
		int idf = funcion.getIdFuncion();

		try {
			aux = aabm.traerEntradaFuncion(idf);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return aux;

	}
}
