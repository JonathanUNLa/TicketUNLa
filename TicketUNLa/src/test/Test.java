package test;

import negocio.ButacaABM;

public class Test {

	public static void main(String[] args) {
		int columna=1;
		int fila=1;
		ButacaABM abm = new ButacaABM();
		int ultimoIdButaca = abm.agregar(fila, columna);
	}

}
