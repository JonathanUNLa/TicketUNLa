package composite;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import datos.Butaca;

public class Busqueda extends FiltroBusqueda{
	private Set<FiltroBusqueda> FiltroBusquedas = new LinkedHashSet<FiltroBusqueda>();

	public Busqueda() {
		super();
		this.setFiltroBusquedas(new LinkedHashSet<FiltroBusqueda>());
	}
	
	public Set<FiltroBusqueda> getFiltroBusquedas() {
		return FiltroBusquedas;
	}

	public void setFiltroBusquedas(Set<FiltroBusqueda> filtroBusquedas) {
		FiltroBusquedas = filtroBusquedas;
	}
	
	public List<Butaca> realizarBusqueda(List<Butaca> butacas){
		List<Butaca> aux = butacas;
		
		for (FiltroBusqueda f: this.getFiltroBusquedas()){
			aux=f.realizarBusqueda(aux);
		}
		return aux;
	}
	
	public void agregar(FiltroBusqueda f){
			this.getFiltroBusquedas().remove(f);
			}
	
}

