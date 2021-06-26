package club.social;

import java.util.ArrayList;

public class Club {
	private static final int EDAD_MIN = 1;
	private static final int EDAD_MAX = 120;
	private ArrayList<Socio> socios;
	private String nombre;

	public Club(String nombre) {
		setNombre(nombre);
		this.socios = new ArrayList<Socio>();
	}

	private void setNombre(String nombre) {
		if (nombreValido(nombre)) {
			this.nombre = nombre;
		}
	}

	private boolean edadValida(int edad) {
		return edad >= EDAD_MIN && edad <= EDAD_MAX;
	}

	private boolean nombreValido(String nombre) {
		return !nombre.isEmpty() && nombre != null;
	}

	private Socio buscarSocio(String nombre) {
		int i = 0;
		Socio socioADevolver = null;

		while (i < this.socios.size() && socioADevolver == null) {
			Socio socioEncontrado = this.socios.get(i);

			if (socioEncontrado.mismoNombre(nombre)) {
				socioADevolver = socioEncontrado;
			} else {
				i++;
			}
		}
		return socioADevolver;
	}

	public Resultado agregarSocio(String nombre, int edad) {
		Resultado resultado = null;
		if (edadValida(edad) && nombreValido(nombre)) {
			Socio socio = buscarSocio(nombre);
			if (socio == null) {
				socio = new Socio(nombre, edad);
				this.socios.add(socio);
				resultado = Resultado.OK;
			} else {
				resultado = Resultado.YA_EXISTE;
			}
		}
		return resultado;
	}

	// mas eficiente buscar un socio, fijarse que exista, buscar el otro y fijarse
	// que exista. -0
//	public Resultado establecerAmistad(String nombre1, String nombre2) {
//		Resultado resultado = null;
//		if (nombreValido(nombre1) && nombreValido(nombre2)) {
//			if (!nombre1.equals(nombre2)) {
//				Socio amistad1 = buscarSocio(nombre1);
//				Socio amistad2 = buscarSocio(nombre2);
//				if (amistad1 != null && amistad2 != null) {
//					// no deberia haber resivido un enum del metodo sino un boolean y validar aca -1
//					resultado = amistad1.establecerAmistad(amistad2);
//					resultado = amistad2.establecerAmistad(amistad1);
//
//				} else {
//					resultado = Resultado.NO_EXISTE;
//				}
//			} else {
//				resultado = Resultado.MISMA_PERSONA;
//			}
//		}
//		return resultado;
//	}
	//mejorado
	public Resultado establecerAmistad(String nombre1, String nombre2) {
		Resultado resultado = null;
		if (nombreValido(nombre1) && nombreValido(nombre2)) {
			if (!nombre1.equals(nombre2)) {
				Socio amistad1 = buscarSocio(nombre1);
				Socio amistad2 = buscarSocio(nombre2);
				if (amistad1 != null && amistad2 != null) {
					if (!amistad1.esAmigo(amistad2) && !amistad2.esAmigo(amistad1)) {
						amistad1.establecerAmistad(amistad2);
						amistad2.establecerAmistad(amistad1);
						resultado = Resultado.OK;
					} else {
						resultado = Resultado.YA_SON_AMIGOS;
					}

				} else {
					resultado = Resultado.NO_EXISTE;
				}
			} else {
				resultado = Resultado.MISMA_PERSONA;
			}
		} else {
			resultado = Resultado.NOMBRE_INVALIDO;
		}
		return resultado;
	}

//	public Resultado deshacerAmistad(String nombre1, String nombre2) {
//		Resultado resultado = null;
//
//		if (nombreValido(nombre1) && nombreValido(nombre2)) {
//			if (!nombre1.equals(nombre2)) {
//				Socio amistad1 = buscarSocio(nombre1);
//				Socio amistad2 = buscarSocio(nombre2);
//				if (amistad1 != null && amistad2 != null) {
//					resultado = amistad1.deshacerAmistad(amistad2);
//					resultado = amistad2.deshacerAmistad(amistad1);
//
//				} else {
//					resultado = Resultado.NO_EXISTE;
//				}
//
//			} else {
//				resultado = Resultado.MISMA_PERSONA;
//			}
//		}
//		return resultado;
//
//	}
	//mejorado
	public Resultado deshacerAmistad(String nombre1, String nombre2) {
		Resultado resultado = null;

		if (nombreValido(nombre1) && nombreValido(nombre2)) {
			if (!nombre1.equals(nombre2)) {
				Socio amistad1 = buscarSocio(nombre1);
				Socio amistad2 = buscarSocio(nombre2);
				if (amistad1 != null && amistad2 != null) {
					if (amistad1.deshacerAmistad(amistad2)) {
						amistad2.deshacerAmistad(amistad1);
						resultado = Resultado.OK;
					} else {
						resultado = Resultado.NO_SON_AMIGOS;
					}

				} else {
					resultado = Resultado.NO_EXISTE;
				}

			} else {
				resultado = Resultado.MISMA_PERSONA;
			}
		} else {
			resultado = Resultado.NOMBRE_INVALIDO;
		}
		return resultado;

	}

	public void listarSociosEdadSimilar() {
		System.out.println("Socios con amigos de edad similar (+-1 año)");
		if (!this.socios.isEmpty()) {
			for (Socio s : this.socios) {
				System.out.println(s.getNombre() + " - " + s.cantAmigosEdadSimilar());

			}
		}else {
			System.out.println("No hay socios");
		}
	}

//	public void mostrarAmigosDeSocio(String nombre) {
//		if (nombreValido(nombre)) {
//			Socio socio = buscarSocio(nombre);
//			System.out.println("Amigos de " + nombre);
//			if (socio != null) {
//				socio.mostrarAmigos();
//			} else {
//				System.out.println("No hay nadie que se llame " + nombre);
//			}
//		}
//
//	}
	//mejorado
	public ArrayList<RegistroAmigo> mostrarAmigosDeSocio(String nombre){
		ArrayList<RegistroAmigo> amigosDe = new ArrayList<RegistroAmigo>();
		if (nombreValido(nombre)) {
			Socio socio = buscarSocio(nombre);
			System.out.println("Amigos de " + nombre);
			if (socio != null) {
				amigosDe = socio.obtenerRegistroAmigos();
			} else {
				System.out.println("No hay nadie que se llame " + nombre);
			}
		}
		return amigosDe;
	}

}
