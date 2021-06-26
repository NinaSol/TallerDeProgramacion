package inmobiliaria.ej3;

public class Test {
	public static void main(String[] args) {
		Inmobiliaria i = new Inmobiliaria();
		
		
		
		boolean pruebas;
		
		pruebas = i.agregarBarrio("Villa Crespo");
		System.out.println(pruebas);
		pruebas = i.agregarBarrio("Almagro");
		System.out.println(pruebas);
		
		pruebas = i.agregarPropiedad("Villa Crespo", "Serrano 300", 300000, Tipo.CASA);
		System.out.println(pruebas);
		
		
		pruebas = i.agregarPropiedad("Villa Crespo", "Serrano 340", 300000, Tipo.DEPTO);
		System.out.println(pruebas);
		
		pruebas = i.agregarPropiedad("Villa Crespo", "Serrano 100", 300000, Tipo.CASA);
		System.out.println(pruebas);
		
		pruebas = i.agregarPropiedad("Villa Crespo", "Serrano 200", 300000, Tipo.PH);
		System.out.println(pruebas);
		
		pruebas = i.agregarPropiedad("Almagro", "Yatay 340", 200000, Tipo.DEPTO);
		System.out.println(pruebas);
		
		pruebas = i.agregarPropiedad("Almagro", "Yatay 240", 200000, Tipo.PH);
		System.out.println(pruebas);
		
		pruebas = i.agregarPropiedad("Almagro", "Yatay 140", 200000, Tipo.CASA);
		System.out.println(pruebas);
		
		i.borrarPropiedad("Serrano 300").mostrar();
		
		i.mostrarProp();
		
		i.obtenerBarrioMaxProp();
		
		pruebas = i.cambiarPropiedadDeBarrio("Yatay 140", "Villa Crespo");
		System.out.println(pruebas);


	}
}
