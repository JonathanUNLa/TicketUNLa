package datos;

public class DiaDescuento {
	private int idDiaDescuento;
	private String dia;
	private double descuento;
	
	public DiaDescuento() {}
	
	public DiaDescuento( String dia, double descuento) {
		this.dia = dia;
		this.descuento = descuento;
	}
	
	public int getIdDiaDescuento() {
		return idDiaDescuento;
	}
	protected void setIdDiaDescuento(int idDiaDescuento) {
		this.idDiaDescuento = idDiaDescuento;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public double getDescuento() {
		return descuento;
	}
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	@Override
	public String toString() {
		return "DiaDescuento [idDiaDescuento=" + idDiaDescuento + ", dia=" + dia + ", descuento=" + descuento + "]";
	}
}
