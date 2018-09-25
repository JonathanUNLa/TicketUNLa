package negocio;

import java.util.List;

import dao.ButacaDao;
import datos.Butaca;
import datos.Seccion;

public class ButacaABM {
	private static ButacaABM instancia;
	protected ButacaDao dao;
	
	protected ButacaABM() {
		dao = new ButacaDao();
	}
	
	public static ButacaABM getInstancia() {
		if (instancia == null) 
			instancia = new ButacaABM();
		return instancia;
	}
	
	public Butaca traerButaca(int idButaca)throws Exception {
		Butaca butaca = dao.traerButaca(idButaca);
		if(butaca == null)throw new Exception("La Butaca no existe");
		return butaca;
	}
	
	public List<Butaca> traerButaca(){
		return dao.traerButaca();
	}
	
	public List<Butaca> traerButaca(Seccion seccion){
		return dao.traerButaca();
	}
	
	public int agregar(int fila, int columna,Seccion seccion) {
		Butaca butaca = new Butaca(fila,columna,seccion);
		return dao.agregar(butaca);
	}
	
	public int agregar(int fila, int columna) {
		Butaca butaca = new Butaca(fila,columna);
		return dao.agregar(butaca);
	}
	public void modificar(Butaca butaca) {
		dao.actualizar(butaca);
	}
	
	public void eliminar(int idButaca)throws Exception {
		Butaca butaca = dao.traerButaca(idButaca);
		if(butaca == null)throw new Exception("La Butaca no existe");
		dao.eliminar(butaca);
	}
}
