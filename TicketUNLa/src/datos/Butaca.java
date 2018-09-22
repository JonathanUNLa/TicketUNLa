package datos;

public class Butaca {
	private int idButaca;
	private int fila;
	private int columna;
	
	public Butaca() {}

	public Butaca(int fila, int columna) {
		this.fila = fila;
		this.columna = columna;
	}

	public int getIdButaca() {
		return idButaca;
	}

	protected void setIdButaca(int idButaca) {
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

	@Override
	public String toString() {
		return "Butaca [idButaca=" + idButaca + ", fila=" + fila + ", columna=" + columna + "]";
	}
	
}
