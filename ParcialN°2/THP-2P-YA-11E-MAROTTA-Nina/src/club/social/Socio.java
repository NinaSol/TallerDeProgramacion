package club.social;

import java.util.ArrayList;

public class Socio {
	private static final int EDAD_MIN = 1;
	private static final int EDAD_MAX = 120;

	private String nombre;
	private int edad;
	private ArrayList<Socio> amigos;

	public Socio(String nombre, int edad) {
		setNombre(nombre);
		setEdad(edad);
		this.amigos = new ArrayList<Socio>();
	}

	private void setNombre(String nombre) {
		if (nombreValido(nombre)) {
			this.nombre = nombre;
		}
	}

	private boolean nombreValido(String nombre) {
		return !nombre.isEmpty() && nombre != null;
	}

	private boolean edadValida(int edad) {
		return edad >= EDAD_MIN && edad <= EDAD_MAX;
	}

//no tiene sentido validarlo aca, por que ya se crea el objeto, si validarlo en club, eso esta correcto -1
	private void setEdad(int edad) {
		if (edadValida(edad)) {
			this.edad = edad;
		}
	}

	public String getNombre() {
		return this.nombre;
	}

	public boolean mismoNombre(String nombre) {
		return this.nombre.equalsIgnoreCase(nombre);
	}

	private int getEdad() {
		return this.edad;
	}

//	private Socio buscarAmistad(String nombre) { 
//		//tendria que haber validado que el objeto sea igual no un equals -1
//		int i = 0;
//		Socio amistadADevolver = null;
//
//		while (i < this.amigos.size() && amistadADevolver == null) {
//			Socio amistadEncontrada = this.amigos.get(i);
//
//			if (amistadEncontrada.mismoNombre(nombre)) {
//				amistadADevolver = amistadEncontrada;
//			} else {
//				i++;
//			}
//		}
//		return amistadADevolver;
//	}
	//mejorado
	public boolean esAmigo(Socio socio) {
		int i = 0;
		boolean resultado = false;

		while (i < this.amigos.size() && !resultado) {
			Socio amistadEncontrada = this.amigos.get(i);

			if (amistadEncontrada == socio && socio != null) {
				resultado = true;
			} else {
				i++;
			}
		}
		return resultado;
	}
	//mejorado
	public void establecerAmistad(Socio amistad) {
		if (!esAmigo(amistad)) {
			this.amigos.add(amistad);
		}
	}

//	public Resultado establecerAmistad(Socio amistad) {
//		Resultado resultado = null;
//		Socio persona = buscarAmistad(amistad.getNombre());
//		if (persona == null) {
//			this.amigos.add(amistad);
//			resultado = Resultado.OK;
//		} else {
//			resultado = Resultado.YA_SON_AMIGOS;
//		}
//		return resultado;
//	}

//	public Resultado deshacerAmistad(Socio amistad) {
//		Resultado resultado = null;
//		Socio persona = buscarAmistad(amistad.getNombre());
//
//		if (persona != null) {
//			this.amigos.remove(amistad);
//			resultado = Resultado.OK;
//		}
//
//		return resultado;
//	}

	public boolean deshacerAmistad(Socio amistad) {
		boolean resultado = false;

		if (esAmigo(amistad)) {
			resultado = this.amigos.remove(amistad);
		}

		return resultado;
	}

	private boolean edadSimilar(Socio socio) {
		return this.edad == socio.getEdad() || this.edad + 1 == socio.getEdad() || this.edad - 1 == socio.getEdad();
	}

	private ArrayList<Socio> obtenerAmigosEdadSimilar() {
		ArrayList<Socio> amigosEdadSimilar = new ArrayList<Socio>();
		for (Socio s : this.amigos) {
			if (edadSimilar(s)) {
				amigosEdadSimilar.add(s);
			}
		}
		return amigosEdadSimilar;
	}

	public int cantAmigosEdadSimilar() {
		return obtenerAmigosEdadSimilar().size();
	}

//	public void mostrarAmigos() {
//		for (Socio s : this.amigos) {
//			System.out.println(s);
//		}
//
//	}
	//mejorado
	public ArrayList<RegistroAmigo> obtenerRegistroAmigos() {
		ArrayList<RegistroAmigo> registros = new ArrayList<RegistroAmigo>();
		for (Socio s : this.amigos) {
			RegistroAmigo registro = new RegistroAmigo(s.getNombre(), s.getEdad());
			registros.add(registro);
		}
		return registros;
	}

	@Override
	public String toString() {
		return "Socio [nombre=" + nombre + ", edad=" + edad + "]";
	}

}
