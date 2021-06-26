package tp3.ejercicio4;

public class Test {
	public static void main(String[] args) {
		Duenio duenio = new Duenio("Juan");
		boolean pruebas;
		
		pruebas = duenio.adoptarPerro("Pichichus");
		System.out.println(pruebas);

		pruebas = duenio.adoptarPerro("Sultan");
		System.out.println(pruebas);

		
		Collar prueba = duenio.agregarCollar("Pichichus");
		System.out.println(prueba);
		
		pruebas = duenio.prepararPaseo("Pichichus");
		System.out.println(pruebas);

		
		
		
		
	}
}
