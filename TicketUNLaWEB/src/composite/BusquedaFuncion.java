package composite;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import datos.Butaca;
import datos.Funcion;
import negocio.ButacaABM;

public class BusquedaFuncion extends FiltroBusqueda {
	private Funcion funcion;

	public BusquedaFuncion(Funcion funcion) {
		super();
		this.funcion = funcion;
	}
	
	public List<Butaca> realizarBusqueda (List<Butaca> butacas){
		List<Butaca> aux = new ArrayList<Butaca>();
		ButacaABM babm = ButacaABM.getInstancia();
		
		int idf = funcion.getIdFuncion();
		
		try {
			aux = babm.traerButacaFuncion(idf);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return aux;
		
	}
	
}
