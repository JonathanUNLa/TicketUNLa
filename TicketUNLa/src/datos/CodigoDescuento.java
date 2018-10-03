package datos;

public class CodigoDescuento {
	private int idCodigo;
	private String codigo;
	private double descuento;
	private Seccion seccion;
	private Funcion funcion;
	
	public CodigoDescuento() {}
	
	public CodigoDescuento(String codigo, double descuento, Seccion seccion, Funcion funcion) {
		this.codigo = codigo;
		this.descuento = descuento;
		this.seccion = seccion;
		this.funcion = funcion;
	}

	public int getIdCodigo() {
		return idCodigo;
	}

	protected void setIdCodigo(int idCodigo) {
		this.idCodigo = idCodigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public Seccion getSeccion() {
		return seccion;
	}

	public void setSeccion(Seccion seccion) {
		this.seccion = seccion;
	}

	public Funcion getFuncion() {
		return funcion;
	}

	public void setFuncion(Funcion funcion) {
		this.funcion = funcion;
	}

	@Override
	public String toString() {
		return "CodigoDescuento [idCodigo=" + idCodigo + ", codigo=" + codigo + ", descuento="
				+ descuento + ", seccion=" + seccion.getNombreSeccion() + ", funcion=" + funcion.getIdFuncion() + "]";
	}
	
}
