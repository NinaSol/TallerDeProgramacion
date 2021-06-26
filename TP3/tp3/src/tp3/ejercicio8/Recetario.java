package tp3.ejercicio8;

import java.util.ArrayList;

public class Recetario {

	private ArrayList<Receta> recetas;

	public Recetario() {
		this.recetas = new ArrayList<Receta>();
	}

	public ArrayList<Faltante> prepararListadoAComprar(String nombreReceta, int porciones, Heladera heladera,
			Alacena alacena) {
		ArrayList<Faltante> faltantes;
		Receta receta = buscarReceta(nombreReceta);

		if (receta != null) {
			faltantes = verificarIngredientes(receta.getIngredientes(), porciones, heladera, alacena);
		} else {
			faltantes = new ArrayList<Faltante>();
		}
		return faltantes;
	}

	private ArrayList<Faltante> verificarIngredientes(ArrayList<Ingrediente> ingredientes, int porciones,
			Heladera heladera, Alacena alacena) {
		ArrayList<Faltante> faltantes = new ArrayList<Faltante>();
		double cantNecesaria;
		double cantFaltante;
		for (Ingrediente i : ingredientes) {
			cantNecesaria = porciones * i.getCantNecesaria();
			if (i.esRefrigerado()) {
				cantFaltante = heladera.verificarCantIngredientes(i.getNombre(), cantNecesaria);
			} else {
				cantFaltante = alacena.verificarCantIngredientes(i.getNombre(), cantNecesaria);
			}

			if (cantFaltante > 0) {
				Faltante faltante = new Faltante(i.getNombre(),cantFaltante);
				faltantes.add(faltante);
			}

		}

		return faltantes;
	}

	private Receta buscarReceta(String nombre) {
		int i = 0;
		Receta receta = null;

		while (i < this.recetas.size() && receta == null) {
			Receta recetaEncontrada = this.recetas.get(i);

			if (recetaEncontrada.mismoNombre(nombre)) {
				receta = recetaEncontrada;
			} else {
				i++;
			}
		}
		return receta;
	}
	
	public boolean agregarReceta(Receta receta) {
		boolean resultado = false;
		Receta recetaABuscar = buscarReceta(receta.getNombre());
		
		if(recetaABuscar == null) {
			this.recetas.add(receta);
			resultado = true;
		}
		return resultado;
	}
	
	
	
		
	public ArrayList<String> recetasPosibleAPreparar(Heladera heladera,Alacena alacena, int porciones){
		ArrayList<String> posiblesRecetas =  new ArrayList<String>();
		
		for(Receta r: this.recetas) {
			ArrayList<Faltante> itemsFaltantes = verificarIngredientes(r.getIngredientes(),porciones,heladera,alacena);
			if(itemsFaltantes.size() == 0) {
				posiblesRecetas.add(r.getNombre());
			}
		}
		
		return posiblesRecetas;
	}

}
