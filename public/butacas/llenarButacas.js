var butacas = new Array();
const filas = 8;
const columnas =6;

function llenarMapaButacas() {
	for (let i = 0; i < filas; i++){
		let fila = $("<tr>");
		$("table").append(fila);
		butacas[i] = new Array();
		
		for (let j = 0; j < columnas; j++) {
			let columna = $("<td>");
			columna.addClass("noSeleccionada");
			
			columna.attr("id", i*j);//idRancio

			fila.append(columna);
			butacas[i][j] = "noSeleccionada";
		}
	}
	$("td").click(toggleDesk);
}

function toggleDesk() {
    $(this).toggleClass("seleccionada");
}

$(document).ready(llenarMapaButacas);
