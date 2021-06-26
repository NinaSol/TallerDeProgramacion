package tp3.ejercicio14;

import java.util.ArrayList;

public class Golfista {
	private static int ultimoNro = 0;
	private int numero;
	private String nombre;
	private String apellido;
	private ArrayList<RegistroHoyo> registroHoyos;

	public Golfista(String nombre, String apellido) {
		this.numero = ultimoNro();
		this.nombre = nombre;
		this.apellido = apellido;
		this.registroHoyos = new ArrayList<RegistroHoyo>();
	}

	private int ultimoNro() {
		return ++ultimoNro;
	}

	public int obetenerPuntaje() {
		int total = 0;

		for (RegistroHoyo r : this.registroHoyos) {
			total += r.obtenerPuntaje();
		}

		return total;
	}

	public boolean mismoNombre(String nombre, String apellido) {
		return this.nombre.equals(nombre) && this.apellido.equals(apellido);
	}

	public boolean mismoNumero(int numero) {
		return this.numero == numero;
	}

	public void agregarRegistro(int golpesUsado, Hoyo hoyo) {
		if (hoyo != null) {
			if (!hoyo.yaPaso(this)) {
				RegistroHoyo registro = new RegistroHoyo(hoyo, golpesUsado);
				this.registroHoyos.add(registro);
				hoyo.agregarJugador(this);
			}
		}
	}

	public int getNumero() {
		return this.numero;
	}

	public String getNombre() {
		return this.nombre;
	}
}
