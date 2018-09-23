package datos;

import java.util.*;

public class Funcion {
	private int idFuncion;
	private double precioBase;
	private GregorianCalendar diaHora;
	private Evento evento;
	private int cantEspacioRestante;
	private double descuento;
	private List<CodigoDescuento> lstCodDesc = new ArrayList<CodigoDescuento>();
	private DiaDescuento diaDescuento;
	public Funcion() {}
	
	public Funcion(double precioBase, GregorianCalendar diaHora, Evento evento, int cantEspacioRestante,
					double descuento,DiaDescuento diaDescuento, List<CodigoDescuento> lstCodDesc) {
		
		this.precioBase = precioBase;
		this.diaHora = diaHora;
		this.evento = evento;
		this.cantEspacioRestante = cantEspacioRestante;
		this.diaDescuento= diaDescuento;
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

	
	
	public DiaDescuento getDiaDescuento() {
		return diaDescuento;
	}

	public void setDiaDescuento(DiaDescuento diaDescuento) {
		this.diaDescuento = diaDescuento;
	}

	@Override
	public String toString() {
		return "Funcion [idFuncion=" + idFuncion + ", precioBase=" + precioBase + ", diaHora=" + diaHora + ", evento="
				+ evento + ", cantEspacioRestante=" + cantEspacioRestante 
				+ ", descuento=" + descuento + ", lstCodDesc=" + lstCodDesc + "]";
	}
	
}
