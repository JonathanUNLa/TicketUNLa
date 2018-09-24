package datos;

public class Butaca {
	private int idButaca;
	private int fila;
	private int columna;
	private Seccion seccion;
	
	public Butaca() {}

	public Butaca(int fila, int columna, Seccion seccion) {

		this.fila = fila;
		this.columna = columna;
		this.seccion = seccion;
	}

	public int getIdButaca() {
		return idButaca;
	}

	public void setIdButaca(int idButaca) {
		this.idButaca = idButaca;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}

	public Seccion getSeccion() {
		return seccion;
	}

	public void setSeccion(Seccion seccion) {
		this.seccion = seccion;
	}

	@Override
	public String toString() {
		return "Butaca [idButaca=" + idButaca + ", fila=" + fila + ", columna=" + columna + "]";
	}

	
	
}
