package test;

import java.util.GregorianCalendar;

import negocio.AuditorioABM;
import negocio.ButacaABM;
import negocio.CodigoDescuentoABM;
import negocio.DiaDescuentoABM;
import negocio.EntradaABM;
import negocio.EventoABM;
import negocio.FuncionABM;
import negocio.ReservaABM;
import negocio.SeccionABM;
import negocio.TipoAuditorioABM;
import negocio.TipoBeneficioABM;
import negocio.TipoUsuarioABM;
import negocio.UsuarioABM;

public class TestMain {

	public static void main(String[] args) {
		TipoAuditorioABM tipoAuditorioAbm = TipoAuditorioABM.getInstancia();
		AuditorioABM auditorioAbm = AuditorioABM.getInstancia();
		SeccionABM seccionAbm = SeccionABM.getInstancia();
		ButacaABM butacaAbm = ButacaABM.getInstancia();
		EventoABM eventoAbm = EventoABM.getInstancia();
		FuncionABM funcionAbm = FuncionABM.getInstancia();
		CodigoDescuentoABM codigoDescuentoAbm = CodigoDescuentoABM.getInstancia();
		DiaDescuentoABM diaDescuentoAbm = DiaDescuentoABM.getInstancia();
		TipoUsuarioABM tipoUsuarioAbm = TipoUsuarioABM.getInstancia();
		TipoBeneficioABM tipoBeneficioAbm = TipoBeneficioABM.getInstancia();
		UsuarioABM usuarioAbm = UsuarioABM.getInstancia();
		EntradaABM entradaAbm = EntradaABM.getInstancia();
		ReservaABM reservaAbm= ReservaABM.getInstancia();
		try {
			
			// agregar 
			
	
			/*tipoAuditorioAbm.agregar("estadio");
			tipoAuditorioAbm.agregar("teatro");
			tipoAuditorioAbm.agregar("cine");
			auditorioAbm.agregar("El Monumental", tipoAuditorioAbm.traerTipoAuditorio(1));
			auditorioAbm.agregar("Teatro Colon", tipoAuditorioAbm.traerTipoAuditorio(2));
			auditorioAbm.agregar("Hoyts", tipoAuditorioAbm.traerTipoAuditorio(3));
			//secciones estadio	(12 butacas, 4 x seccion)
			seccionAbm.agregar("Palco ", 300, auditorioAbm.traerAuditorio(1));
			seccionAbm.agregar("Platea ", 200, auditorioAbm.traerAuditorio(1));
			seccionAbm.agregar("Popular ", 100, auditorioAbm.traerAuditorio(1));
			//Butacas seccion 1 estadio 1 
			butacaAbm.agregar(1, 1, seccionAbm.traerSeccion(1));
			butacaAbm.agregar(1, 2, seccionAbm.traerSeccion(1));
			butacaAbm.agregar(2, 1, seccionAbm.traerSeccion(1));
			butacaAbm.agregar(2, 2, seccionAbm.traerSeccion(1));
			//Butacas seccion 2 estadio 1
			butacaAbm.agregar(1, 1, seccionAbm.traerSeccion(2));
			butacaAbm.agregar(1, 2, seccionAbm.traerSeccion(2));
			butacaAbm.agregar(2, 1, seccionAbm.traerSeccion(2));
			butacaAbm.agregar(2, 2, seccionAbm.traerSeccion(2));
			//Butacas seccion 3 estadio 1
			butacaAbm.agregar(1, 1, seccionAbm.traerSeccion(3));
			butacaAbm.agregar(1, 2, seccionAbm.traerSeccion(3));
			butacaAbm.agregar(2, 1, seccionAbm.traerSeccion(3));
			butacaAbm.agregar(2, 2, seccionAbm.traerSeccion(3));
			//secciones teatro (8 butacas, 4 x seccion)
			seccionAbm.agregar("Preferente", 100, auditorioAbm.traerAuditorio(2));
			seccionAbm.agregar("Balcon", 300, auditorioAbm.traerAuditorio(2));
			//Butacas seccion 1 estadio 2
			butacaAbm.agregar(1, 1, seccionAbm.traerSeccion(4));
			butacaAbm.agregar(1, 2, seccionAbm.traerSeccion(4));
			butacaAbm.agregar(2, 1, seccionAbm.traerSeccion(4));
			butacaAbm.agregar(2, 2, seccionAbm.traerSeccion(4));
						//Butacas seccion 2 estadio 2
			butacaAbm.agregar(1, 1, seccionAbm.traerSeccion(5));
			butacaAbm.agregar(1, 2, seccionAbm.traerSeccion(5));
			butacaAbm.agregar(2, 1, seccionAbm.traerSeccion(5));
			butacaAbm.agregar(2, 2, seccionAbm.traerSeccion(5));
			//secciones cine (6 butacas)
			seccionAbm.agregar("Sala 1", 100, auditorioAbm.traerAuditorio(3));
			//Butacas seccion 1 cine 1
			butacaAbm.agregar(1, 1, seccionAbm.traerSeccion(6));
			butacaAbm.agregar(1, 2, seccionAbm.traerSeccion(6));
			butacaAbm.agregar(2, 1, seccionAbm.traerSeccion(6));
			butacaAbm.agregar(2, 2, seccionAbm.traerSeccion(6));
			butacaAbm.agregar(3, 1, seccionAbm.traerSeccion(6));
			butacaAbm.agregar(3, 2, seccionAbm.traerSeccion(6));
			//eventos
			eventoAbm.agregar("Fito Páez", auditorioAbm.traerAuditorio(1));
			eventoAbm.agregar("Como si pasara un tren", auditorioAbm.traerAuditorio(2));
			eventoAbm.agregar("Los increibles 2 ", auditorioAbm.traerAuditorio(3));
			//dias de descuento
			diaDescuentoAbm.agregar("Lunes", 15.0);
			diaDescuentoAbm.agregar("Viernes", 20.0);
			//funciones agregadas
			funcionAbm.agregar(500.0, new GregorianCalendar(), eventoAbm.traerEvento(1),null);
			funcionAbm.agregar(550.0, new GregorianCalendar(), eventoAbm.traerEvento(2), diaDescuentoAbm.traerDiaDescuento(1));
			funcionAbm.agregar(600.0, new GregorianCalendar(), eventoAbm.traerEvento(3), diaDescuentoAbm.traerDiaDescuento(2));
			funcionAbm.agregar(650.0, new GregorianCalendar(), eventoAbm.traerEvento(1), diaDescuentoAbm.traerDiaDescuento(2));
			//codigo de descuento 
			codigoDescuentoAbm.agregar("SDE5697", 100.0, seccionAbm.traerSeccion(1), funcionAbm.traerFuncion(1));
			codigoDescuentoAbm.agregar("QWERTY", 50.0, seccionAbm.traerSeccion(6), funcionAbm.traerFuncion(3));
			//tipos de usuario
			tipoUsuarioAbm.agregar("Cliente");	
			tipoUsuarioAbm.agregar("Empleado");
			tipoUsuarioAbm.agregar("Administrador");
			//tipos de beneficio
			tipoBeneficioAbm.agregar("Estudiante", 5);
			tipoBeneficioAbm.agregar("Jubilado", 10);
			
			//agregar usuarios
			//cliente
			usuarioAbm.agregar(1111111, "Romina", "Mansilla", "999999", "rmansilla", "oo1", tipoUsuarioAbm.traerTipoUsuario(1), tipoBeneficioAbm.traerTipoBeneficio(1), null);
			usuarioAbm.agregar(2222222, "Alejandra", "Vranic", "888888", "avranic", "oo2", tipoUsuarioAbm.traerTipoUsuario(2), tipoBeneficioAbm.traerTipoBeneficio(2), null);
			usuarioAbm.agregar(3333333, "Damian", "Santirachi", "777777", "dsantirachi", "12345", tipoUsuarioAbm.traerTipoUsuario(1), null, null);
			//empleado
			usuarioAbm.agregar(4444444, "Jonathan", "Yañez", "666666", "jyañez", "zxc", tipoUsuarioAbm.traerTipoUsuario(2), null, auditorioAbm.traerAuditorio(1));
			usuarioAbm.agregar(4444444, "Jose", "Lucero", "5555555", "jlucero", "asd", tipoUsuarioAbm.traerTipoUsuario(2), null, auditorioAbm.traerAuditorio(2));
			usuarioAbm.agregar(4444444, "Martin", "Olmos", "444444", "molmos", "qwe", tipoUsuarioAbm.traerTipoUsuario(2), null, auditorioAbm.traerAuditorio(3));
			//administrador
			usuarioAbm.agregar(5555555, "Nehuen", "Verges", "333333", "nverges", "987654", tipoUsuarioAbm.traerTipoUsuario(3), null,null);
			//generar reservas
			reservaAbm.agregar(usuarioAbm.traerUsuarioHql(1), false);
			reservaAbm.agregar(usuarioAbm.traerUsuarioHql(2), false);
			reservaAbm.agregar(usuarioAbm.traerUsuarioHql(3), false);
			//agregar entradas usuario 1
			entradaAbm.agregar(butacaAbm.traerButacaHql(1),  funcionAbm.traerFuncion(1),"SDE5697",reservaAbm.traerReserva(1));
			entradaAbm.agregar(butacaAbm.traerButacaHql(5),  funcionAbm.traerFuncion(1),"s",reservaAbm.traerReserva(1));
			entradaAbm.agregar(butacaAbm.traerButacaHql(10),  funcionAbm.traerFuncion(1),"QWERTY",reservaAbm.traerReserva(1));
			//agregar entradas usuario 2
			entradaAbm.agregar(butacaAbm.traerButacaHql(13),  funcionAbm.traerFuncion(2),"asd",reservaAbm.traerReserva(2));
			entradaAbm.agregar(butacaAbm.traerButacaHql(17),  funcionAbm.traerFuncion(2),"s",reservaAbm.traerReserva(2));
			entradaAbm.agregar(butacaAbm.traerButacaHql(20),  funcionAbm.traerFuncion(2),"s",reservaAbm.traerReserva(2));
			//agregar etradas usuario 3
			entradaAbm.agregar(butacaAbm.traerButacaHql(21),  funcionAbm.traerFuncion(2),"QWERTY",reservaAbm.traerReserva(3));
			entradaAbm.agregar(butacaAbm.traerButacaHql(24),  funcionAbm.traerFuncion(2),"s",reservaAbm.traerReserva(3));
			entradaAbm.agregar(butacaAbm.traerButacaHql(26),  funcionAbm.traerFuncion(2),"s",reservaAbm.traerReserva(3));*/
			
			
			//traer e imprimir
		
			
			
		//	System.out.println(butacaAbm.traerButacaHql(1));+++++++++++
		//	System.out.println(seccionAbm.traerSeccionHql(1));+++++++++
		//	System.out.println(eventoAbm.traerEventoHql(1)); -----------
		//	System.out.println(funcionAbm.traerFuncionHql(1));++++++++++ le saque el getDia del toString
		//	auditorioAbm.agregar("asdasd", tipoAuditorioAbm.traerTipoAuditorio(1));
		//	System.out.println(auditorioAbm.traerAuditorioHql(1));------------- no trae el primero los demas si
		//	System.out.println(codigoDescuentoAbm.traerCodigoDescuentoHql(1));
		//	System.out.println(entradaAbm.traerEntradaHql(1));+++++++++++++
		//	System.out.println(funcionAbm.traerFuncionHql(2).damianSeLaCome()); +++++++ le saque el getDia del toString
		//	System.out.println(eventoAbm.traerEvento("El monumental"));+++++++++
		//	System.out.println(usuarioAbm.traerUsuario("jlucero")); ---------- esta mal el hql
		//	System.out.println(funcionAbm.traerFuncion("Fito Paez"));++++++++ creo que anda
		//	System.out.println(butacaAbm.traerButacaAuditorio(4).size()); +++++ parece que anda
		//	System.out.println(entradaAbm.traerEntradaFuncion(2).size());
		//	System.out.println(butacaAbm.traerButacaFuncion(4).size()); //-------- desde el 4 en adelante no andan
		//	System.out.println(reservaAbm.traerReservaHql(1)); ++++++++
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

