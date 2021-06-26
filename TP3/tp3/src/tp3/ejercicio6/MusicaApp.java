package tp3.ejercicio6;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MusicaApp {
	private String nombre;
	private ArrayList<Cancion> canciones;
	private ArrayList<Usuario> usuarios;

	public MusicaApp(String nombre) {
		this.nombre = nombre;
		this.canciones = new ArrayList<Cancion>();
		this.usuarios = new ArrayList<Usuario>();

	}

	private Cancion buscarCancion(String nombre, String autor) {
		int i = 0;
		int cantElementos = this.canciones.size();
		Cancion resultado = null;
		Cancion busqueda;

		while (i < cantElementos && resultado == null) {
			busqueda = this.canciones.get(i);
			if (busqueda.getNombre().equals(nombre) && busqueda.getAutor().equals(autor)) {
				resultado = busqueda;
			} else {
				i++;
			}
		}
		return resultado;
	}

	private Usuario buscarUsuario(String email) {
		int i = 0;
		int cantElementos = this.usuarios.size();
		Usuario resultado = null;
		Usuario busqueda;

		while (i < cantElementos && resultado == null) {
			busqueda = this.usuarios.get(i);
			if (busqueda.getEmail().equals(email)) {
				resultado = busqueda;
			} else {
				i++;
			}
		}
		return resultado;
	}

	public boolean altaCancion(String nombre, String autor, String genero, int diasDePublicacion) {
		boolean resultado = false;
		Cancion busqueda = buscarCancion(nombre, autor);
		if (busqueda == null) {
			Cancion cancion = new Cancion(nombre, autor, genero, diasDePublicacion);
			this.canciones.add(cancion);
			resultado = true;
		}
		return resultado;
	}

	public boolean altaUsuario(String email, String apellido, int edad, Categoria categoria) {
		boolean resultado = false;
		Usuario busqueda = buscarUsuario(email);
		if (busqueda == null) {
			Usuario usuario = new Usuario(email, apellido, edad, categoria);
			this.usuarios.add(usuario);
			resultado = true;
		}
		return resultado;
	}


	public boolean estaRestringida(Usuario usuario, Cancion cancion) {
		return !(usuario.esPremium()) &&  (cancion.getRestringida());

	}

	public Operacion escucharCancion(String email, String nombre, String autor) {
		Operacion resultado = null;
		Usuario usuario = buscarUsuario(email);

		if (usuario != null) {
			Cancion cancion = buscarCancion(nombre, autor);
			if(cancion != null) {
				if(usuario.chequearLimite()) {
					if(!estaRestringida(usuario,cancion)) {
						resultado = Operacion.CANCION_ESCUCHADA;
						usuario.agregarHistorial(cancion);
						cancion.reproducir();
					}else {
						resultado = Operacion.CANCION_NO_DISPONIBLE;
					}
				}else {
					resultado = Operacion.LIMITE_ALCANZADO;
				}
			}else {
				resultado = Operacion.CANCION_INEXISTENTE;
			}
		}else {
			resultado = Operacion.USUARIO_INEXISTENTE;
		}


		return resultado;
	}

	public void listarUsuarios() {
		for (Usuario u : this.usuarios) {
			u.mostrarDatos();
		}
	}

	public void listarCancionesPorUsuario(String email) {
		Usuario busqueda = buscarUsuario(email);
		if (busqueda != null) {
			System.out.println("Operacion exitosa");
			busqueda.mostrarHistorial();
		} else {
			System.out.println("Usuario inexistente");
		}
	}

}
