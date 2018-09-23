package datos;

public class DiaDescuento {
	private int iDiadDescuento;
	private String dia;
	private double descuento;

	
	public DiaDescuento() {
	}
	public DiaDescuento(int iDiadDescuento, String dia, double descuento) {
		super();
		this.iDiadDescuento = iDiadDescuento;
		this.dia = dia;
		this.descuento = descuento;

	}
	public int getiDiadDescuento() {
		return iDiadDescuento;
	}
	public void setiDiadDescuento(int iDiadDescuento) {
		this.iDiadDescuento = iDiadDescuento;
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
		return "DiaDescuento [iDiadDescuento=" + iDiadDescuento + ", dia=" + dia + ", descuento=" + descuento + "]";
	}
	
	
	
	
	
	
}
