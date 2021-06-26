package ej1;

import java.util.ArrayList;
import java.util.Scanner;

public class TestAlumno {
	private static final int APRUEBA = 7;

	public static void main(String[] args) {

		ArrayList<Alumno> alumnos = generarDatosAlumnos();
		double promedio = obtenerPromedio(alumnos);
		double porcentaje = porcentajeAprobados(alumnos);
		int mejor = mejorNota(alumnos);
		ArrayList<Alumno> mejores = mejoresAlumnos(alumnos);
		ArrayList<Integer> frecuentes = notasMasFrecuentes(alumnos);
		ArrayList<Alumno> aprobados = alumnosAprobados(alumnos);

		System.out.println("El promedio es: " + promedio);
		System.out.println("El porcentaje de aprobados es: " + porcentaje + "%");
		System.out.println("La mejor nota es: " + mejor);
		System.out.println("Los mejores alumnos son: " + mejores);
		System.out.println("Las notas m�s frecuentes son: " + frecuentes);
		System.out.println("Alumnos aprobados: " + aprobados);

		/*
		 * El resultado de ejecutar este programa es: El promedio es: 5.8 El porcentaje
		 * de aprobados es: 40.0% La mejor nota es: 9 Los mejores alumnos son: [Ana(9),
		 * Elsa(9)] Las notas mas frecuentes son: [5, 9] Alumnos aprobados: [Ana(9),
		 * Julian(8), Sofia(7), Elsa(9)]
		 */
	}

	private static ArrayList<Alumno> generarDatosAlumnos() {
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		alumnos.add(new Alumno("Juan", 6));
		alumnos.add(new Alumno("Pedro", 2));
		alumnos.add(new Alumno("Ana", 9));
		alumnos.add(new Alumno("Maria", 3));
		alumnos.add(new Alumno("Mabel", 4));
		alumnos.add(new Alumno("Julian", 8));
		alumnos.add(new Alumno("Sofia", 7));
		alumnos.add(new Alumno("Jose", 5));
		alumnos.add(new Alumno("Elsa", 9));
		alumnos.add(new Alumno("Andres", 5));
		return alumnos;
	}

	private static double obtenerPromedio(ArrayList<Alumno> alumnos) {
		/*
		 * Dado un AL de alumnos devolver la nota promedio En caso que no haya ning�n
		 * alumno devolver 0.0 Considerar que el c�lculo debe realizarse como punto
		 * flotante
		 */
		double total = 0;
		int cantNotas = alumnos.size();
		if (!alumnos.isEmpty()) {
			for (Alumno a : alumnos) {
				total += a.getNota();
			}
		}
		double promedio = total / cantNotas;
		return promedio;
	}

	private static double porcentajeAprobados(ArrayList<Alumno> alumnos) {
		/*
		 * Dado un AL de alumnos devolver el porcentaje de alumnos aprobados La nota de
		 * aprobacion es 7 (ya esta definida la constante APRUEBA) En caso que no haya
		 * ningun alumno devolver 0.0 Considerar que el c�lculo debe realizarse como
		 * punto flotante
		 */
		int cantNotas = alumnos.size();
		int aprobados = 0;
		double porcentaje = 0.0;
		if (!alumnos.isEmpty()) {
			for (Alumno a : alumnos) {
				if (a.getNota() >= APRUEBA) {
					aprobados++;
				}
			}
			porcentaje = aprobados * 100 / cantNotas;
		}
		return porcentaje;
	}

	private static int mejorNota(ArrayList<Alumno> alumnos) {
		/*
		 * Dado un AL de alumnos devolver la mejor nota del curso
		 */
		int mejor = 0;
		for (Alumno a : alumnos) {
			if (a.getNota() > mejor) {
				mejor = a.getNota();
			}
		}
		return mejor;
	}

	private static ArrayList<Alumno> mejoresAlumnos(ArrayList<Alumno> alumnos) {
		/*
		 * Dado un AL de alumnos devolver otro AL con los alumnos que hayan obtenido la
		 * mejor nota (puede ser uno o varios).
		 */
		int max = 0;
		ArrayList<Alumno> mejores = new ArrayList<Alumno>();
		for (Alumno a : alumnos) {
			if (a.getNota() > max) {
				mejores.clear();
				max = a.getNota();
				mejores.add(a);
			} else if (a.getNota() == max) {
				mejores.add(a);
			}
			//otra forma
//			if(a.getNota() >= max) {
//				if(a.getNota() > max) {
//					mejores.clear();
//					max = a.getNota();
//				}
//			}
//			mejores.add(a);

		}

		return mejores;
	}

	private static ArrayList<Integer> notasMasFrecuentes(ArrayList<Alumno> alumnos) {
		/*
		 * Dado un AL de alumnos devolver otro AL con los notas mas frecuentes. En el
		 * ejemplo de referencia hay dos personas que obtuvieron 5 y dos que obtuvieron
		 * 9, asi que el resultado deberiaa ser [5, 9]
		 */
		int max = -1;
		ArrayList<Integer> frecuentes = new ArrayList<Integer>();
		ArrayList<Integer> tabla = new ArrayList<Integer>();

		for (int i = 0; i <= 10; i++) {
			tabla.add(0);
		}

		for (Alumno a : alumnos) {
			int nota = a.getNota();
			int cant = tabla.get(nota) + 1;
			tabla.set(nota, cant);
		}

		for (int i = 0; i <= 10; i++) {
			if (tabla.get(i) > max) {
				max = tabla.get(i);
				// acordarme de i (es la nota)
				frecuentes.clear();
				frecuentes.add(i);
			} else if (tabla.get(i) == max) {
				frecuentes.add(i);
			}
		}

		return frecuentes;
	}

	private static ArrayList<Alumno> alumnosAprobados(ArrayList<Alumno> alumnos) {
		/*
		 * Dado un AL de alumnos devolver otro AL con alumnos aprobados.
		 */
		ArrayList<Alumno> aprobados = new ArrayList<Alumno>();
		for (Alumno a : alumnos) {
			if (a.getNota() >= APRUEBA) {
				aprobados.add(a);
			}
		}
		return aprobados;
	}

}
