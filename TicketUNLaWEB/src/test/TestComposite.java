package test;

import java.util.ArrayList;
import java.util.List;

import composite.Busqueda;
import composite.BusquedaEntradaFuncion;
import composite.BusquedaFuncion;
import composite.FiltroBusqueda;
import datos.Butaca;
import funciones.Funciones;
import negocio.FuncionABM;



public class TestComposite {

	public static void main(String[] args) throws Exception {

		FuncionABM funcionAbm = FuncionABM.getInstancia();
		List<Butaca>lista=new ArrayList<Butaca>();
		
		Busqueda b = new Busqueda();
		b.agregar(new BusquedaFuncion(funcionAbm.traerFuncion(1)));
		b.agregar(new BusquedaEntradaFuncion(funcionAbm.traerFuncion(1)));

		
		lista=b.realizarBusqueda(lista);
		
		System.out.println(lista.size());
	}

}