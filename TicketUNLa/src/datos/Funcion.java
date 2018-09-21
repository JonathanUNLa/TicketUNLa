package datos;

import java.util.*;

public class Funcion {
	private int idFuncion;
	private double precioBase;
	private GregorianCalendar diaHora;
	private Evento evento;
	private int cantEspacioRestante;
	private List<String> lstDiaDescuento = new ArrayList<String>();
	private double descuento;
	private List<CodigoDescuento> lstCodDesc = new ArrayList<CodigoDescuento>();
	
	public Funcion() {}
	
	public Funcion(double precioBase, GregorianCalendar diaHora, Evento evento, int cantEspacioRestante,
			List<String> lstDiaDescuento, double descuento, List<CodigoDescuento> lstCodDesc) {
		
		this.precioBase = precioBase;
		this.diaHora = diaHora;
		this.evento = evento;
		this.cantEspacioRestante = cantEspacioRestante;
		this.lstDiaDescuento = lstDiaDescuento;
		this.descuento = descuento;
		this.lstCodDesc = lstCodDesc;	
	}

	public int getIdFuncion() {
		return idFuncion;
	}

	protected void setIdFuncion(int idFuncion) {
		this.idFuncion = idFuncion;
	}

	public double getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}

	public GregorianCalendar getDiaHora() {
		return diaHora;
	}

	public void setDiaHora(GregorianCalendar diaHora) {
		this.diaHora = diaHora;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public int getCantEspacioRestante() {
		return cantEspacioRestante;
	}

	public void setCantEspacioRestante(int cantEspacioRestante) {
		this.cantEspacioRestante = cantEspacioRestante;
	}

	public List<String> getLstDiaDescuento() {
		return lstDiaDescuento;
	}

	public void setLstDiaDescuento(List<String> lstDiaDescuento) {
		this.lstDiaDescuento = lstDiaDescuento;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public List<CodigoDescuento> getLstCodDesc() {
		return lstCodDesc;
	}

	public void setLstCodDesc(List<CodigoDescuento> lstCodDesc) {
		this.lstCodDesc = lstCodDesc;
	}

	@Override
	public String toString() {
		return "Funcion [idFuncion=" + idFuncion + ", precioBase=" + precioBase + ", diaHora=" + diaHora + ", evento="
				+ evento + ", cantEspacioRestante=" + cantEspacioRestante + ", lstDiaDescuento=" + lstDiaDescuento
				+ ", descuento=" + descuento + ", lstCodDesc=" + lstCodDesc + "]";
	}
	
}
