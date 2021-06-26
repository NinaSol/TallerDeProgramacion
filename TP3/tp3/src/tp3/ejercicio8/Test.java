package tp3.ejercicio8;

public class Test {
	public static void main(String[] args) {
		Heladera heladera = new Heladera("Samsung");
		Alacena alacena = new Alacena("Easy");
		Recetario recetario = new Recetario();
		
		
		heladera.agregarProducto("Dulce de leche",250, "3/8/2021");
		heladera.agregarProducto("Crema",250,  "30/8/2021");
		heladera.agregarProducto("Chocolatada",50, "5/12/2021");
		alacena.agregarProducto("Chocolinas",500, "13/9/2021");
		
		Receta torta = new Receta("2333","Chocotorta");
		torta.agregarIngrediente("Chocolinas",500, Tipo.NO_REFRIGERADO);
		torta.agregarIngrediente("Dulce de leche",250, Tipo.REFRIGERADO);
		torta.agregarIngrediente("Crema",250, Tipo.REFRIGERADO);
		torta.agregarIngrediente("Chocolatada",50, Tipo.REFRIGERADO);

		recetario.agregarReceta(torta);
		
		System.out.println(recetario.prepararListadoAComprar("Chocotorta", 1, heladera, alacena));
		System.out.println(recetario.recetasPosibleAPreparar(heladera, alacena, 1));
		
		
		

	}
}
