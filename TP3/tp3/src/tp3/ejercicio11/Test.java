package tp3.ejercicio11;

public class Test {

	public static void main(String[] args) {
		Almacen heladera = new Almacen(10,true);
		Almacen alacena = new Almacen(20,false);

		Chef chef = new Chef("Chefsito",heladera,alacena);
		
		heladera.agregarProducto("leche", 3, new Fecha(11,6,2021));
		heladera.agregarProducto("queso", 3, new Fecha(9,6,2021));
		alacena.agregarProducto("harina", 3, new Fecha(11,6,2021));
		alacena.agregarProducto("azucar", 3, new Fecha(9,6,2021));
		
		System.out.println(chef.extraerProductosVencidos());
		System.out.println(chef.chequearProducto("leche", true));
		System.out.println(chef.chequearProducto("harina", false));
		System.out.println(chef.chequearProducto("queso", true));

		heladera.agregarProducto("queso", 3, new Fecha(9,6,2021));
		System.out.println(chef.chequearProducto("queso", true));



		
	}

}
