package vuelo;

import java.util.ArrayList;

public class Vuelo {
	private ArrayList<Asiento> asientos;
	private String numero;
	private int cantAsientos;
	private double montoRecaudado;

	public Vuelo(String numero, int cantAsientos) {
		this.numero = numero;
		this.cantAsientos = cantAsientos;
		this.montoRecaudado = 0;
		this.asientos = new ArrayList<Asiento>();
	}

	public ResultadoReservaBoletos reservarAsiento(int dni, int telefono, Clase clase) {
		ResultadoReservaBoletos respuesta = null;
		Asiento asiento = buscarAsientoReservado(dni);
		if (!avionCompleto()) {
			if (asiento == null) {
				Persona pasajero = new Persona(dni, telefono);
				asiento = new Asiento(pasajero, clase);
				this.asientos.add(asiento);
				actualizarMontoRecaudado(asiento);
				respuesta = ResultadoReservaBoletos.RESERVA_OK;

			} else {
				respuesta = ResultadoReservaBoletos.YA_TIENE_PASAJE;

			}
		} else {
			respuesta = ResultadoReservaBoletos.AVION_COMPLETO;

		}

		return respuesta;
	}

	private Asiento buscarAsientoReservado(int dni) {
		int i = 0;
		Asiento busqueda = null;

		while (i < this.asientos.size() && busqueda == null) {
			Asiento encontrado = this.asientos.get(i);
			if (encontrado != null && encontrado.mismoAsiento(dni)) {
				busqueda = encontrado;
			} else {
				i++;
			}
		}
		return busqueda;
	}

	private void actualizarMontoRecaudado(Asiento asiento) {
		this.montoRecaudado += asiento.getPrecio();
	}
	
	private void devolverMonto(Asiento asiento) {
		this.montoRecaudado -= asiento.getPrecio();
	}

	private boolean avionCompleto() {
		return !(this.asientos.size() < this.cantAsientos);
	}

	public void listarAsientosReservados() {
		for (Asiento a : this.asientos) {
			System.out.println(a);
		}
	}

	public void anularReserva(int dni) {
		Asiento busqueda = buscarAsientoReservado(dni);

		if (busqueda != null) {
			this.asientos.remove(busqueda);
			devolverMonto(busqueda);
			System.out.println("Se ha anulado la reserva con éxito");
		} else {
			System.out.println("No existe una reserva con ese DNI");
		}
	}

	private double obtenerAcumuladoPorClase(Clase clase) {
		double acumulado = 0;

		for (Asiento a : this.asientos) {
			if (a.mismaClase(clase)) {
				acumulado += a.getPrecio();
			}
		}
		return acumulado;

	}

	public void mostrarMontoRecaudadoDeClase(Clase clase) {
		double total = obtenerAcumuladoPorClase(clase);
		if (asientos.size() == 0) {
			System.out.println("No hay asientos reservados en ninguna clase");
		}else {
			if (total > 0) {
				System.out.println("El total es: " + total);
			} else {
				System.out.println("No hay asientos reservados en la clase: " + clase);
			}
		}

	}

}
