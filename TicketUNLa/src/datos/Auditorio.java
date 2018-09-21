package datos;

import java.util.*;

public class Auditorio {
	private int idAuditorio;
	private String nombre;
	private List<Seccion> lstSecciones= new ArrayList<Seccion>();
	private TipoAuditorio tipoAudiotorio;
	private Butaca[][] butacas;
	
	public Auditorio(){}

	public Auditorio(String nombre, List<Seccion> lstSecciones, TipoAuditorio tipoAudiotorio,
			Butaca[][] butaca) {
		this.nombre = nombre;
		this.lstSecciones = lstSecciones;
		this.tipoAudiotorio = tipoAudiotorio;
		//this.butacas = new Butaca[];
	}

	public int getIdAuditorio() {
		return idAuditorio;
	}

	protected void setIdAuditorio(int idAuditorio) {
		this.idAuditorio = idAuditorio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Seccion> getLstSecciones() {
		return lstSecciones;
	}

	public void setLstSecciones(List<Seccion> lstSecciones) {
		this.lstSecciones = lstSecciones;
	}

	public TipoAuditorio getTipoAudiotorio() {
		return tipoAudiotorio;
	}

	public void setTipoAudiotorio(TipoAuditorio tipoAudiotorio) {
		this.tipoAudiotorio = tipoAudiotorio;
	}

	public Butaca[][] getButacas() {
		return butacas;
	}

	/*public void setButacas() {
		int i, j, k;
		for(k=0;k<this.lstSecciones.size();k++) {
			for (i=0;i<this.lstSecciones.get(k).getCantFilas();i++) {
				for (j=0;j<this.lstSecciones.get(k).getCantColumnas();j++) {
					this.butacas[i][j] = new Butaca(i+1,j+1);
				}
			}
		}
	}*/
	
}
