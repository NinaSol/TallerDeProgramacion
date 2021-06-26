package tp3.ejercicio5;

import java.util.ArrayList;

import tp3.ejercicio6.Usuario;

public class ORTFlix {
	private ArrayList<Pelicula> peliculas;
	private ArrayList<Cliente> clientes;
	private ArrayList<Cliente> listaNegra;

	public ORTFlix() {
		this.peliculas = new ArrayList<Pelicula>();
		this.clientes = new ArrayList<Cliente>();
		this.listaNegra = new ArrayList<Cliente>();

	}

	public boolean agregarPelicula(String nombre, Subscripcion tipo) {
		boolean resultado = false;
		if (buscarPelicula(nombre) == null) {
			Pelicula pelicula = new Pelicula(nombre, tipo);
			this.peliculas.add(pelicula);
			resultado = true;
		}
		return resultado;
	}

	private Pelicula buscarPelicula(String nombre) {
		int i = 0;
		Pelicula peliculaResultante = null;

		while (i < this.peliculas.size() && peliculaResultante == null) {
			Pelicula pelicula = this.peliculas.get(i);
			if (pelicula.getNombre().equals(nombre)) {
				peliculaResultante = pelicula;
			} else {
				i++;
			}
		}
		return peliculaResultante;
	}

	private Cliente buscarCliente(int dni, ArrayList<Cliente> listaClientes) {
		int i = 0;
		Cliente clienteResultante = null;

		while (i < listaClientes.size() && clienteResultante == null) {
			Cliente cliente = listaClientes.get(i);
			if (cliente.getDni() == dni) {
				clienteResultante = cliente;
			} else {
				i++;
			}
		}
		return clienteResultante;
	}

	public RespuestaAlta darDeAlta(int dni, String nombre, Subscripcion tipo, double saldo) {
		Cliente cliente = buscarCliente(dni, this.clientes);
		RespuestaAlta resp;
		Cliente deudor = buscarCliente(dni, this.listaNegra);

		if (cliente == null) {
			if (deudor == null) {
				resp = RespuestaAlta.ALTA_OK;
				cliente = new Cliente(dni, nombre, tipo, saldo);
				this.clientes.add(cliente);
			} else {
				resp = RespuestaAlta.CLIENTE_DEUDOR;
			}
		} else {
			resp = RespuestaAlta.CLIENTE_EXISTENTE;
		}

		return resp;
	}

	
	
	public boolean darDeBaja(int dni) { 
		boolean resultado = false;
		Cliente cliente = buscarCliente(dni, this.clientes);
		if (cliente != null) {
			this.clientes.remove(cliente);
			if (cliente.getDeudor()) {
				this.listaNegra.add(cliente);
			}
			resultado = true;
		}
		return resultado;
	}

	private boolean contenidoDisponible(Cliente cliente, Pelicula pelicula) {
		return ((cliente.getSubscripcion() == Subscripcion.PREMIUM) || (pelicula.getTipo() == Subscripcion.STANDARD));
	}

	public Respuesta verPelicula(int dni, String nombre) {
		Respuesta respuesta = null;
		Cliente cliente = buscarCliente(dni, this.clientes);

		if (cliente != null) {
			Pelicula pelicula = buscarPelicula(nombre);
			if (pelicula != null) {
				if (!cliente.getDeudor()) {
					if (contenidoDisponible(cliente, pelicula)) {
						respuesta = Respuesta.OK;
						cliente.agregarHistorial(pelicula);
					} else {
						respuesta = Respuesta.CONTENIDO_NO_DISPONIBLE;
					}
				} else {
					respuesta = Respuesta.CLIENTE_DEUDOR;
				}
			} else {
				respuesta = Respuesta.CONTENIDO_INEXISTENTE;
			}
		} else {
			respuesta = Respuesta.CLIENTE_INEXISTENTE;
		}

		return respuesta;
	}

	public void depurarListNegra(double importe) {
		int i = 0;
		while (i < this.listaNegra.size()) {
			Cliente clienteDeudor = this.listaNegra.get(i);
			if (clienteDeudor.saldarDeuda(importe)) {
				this.listaNegra.remove(clienteDeudor);
			} else {
				i++;
			}
		}
	}

	public ArrayList<Listado> peliculasVistasPorClientes(Subscripcion subscripcion) {
		ArrayList<Listado> listado = new ArrayList<Listado>();
		for (Cliente c : this.clientes) {
			if (subscripcion == c.getSubscripcion()) {
				Listado l = new Listado(c.getNombre(), c.cantPelisVistas());
				listado.add(l);
			}
		}
		return listado;
	}

}
