package tp3.ejercicio4;

import java.util.ArrayList;

public class Perchero {

	private ArrayList<Collar> collares;

	public Perchero() {
		this.collares = new ArrayList<Collar>();
	}

	public Collar agregarCollar(Collar collar) {
		if (collar == null && this.collares.size() < 3) {
			this.collares.add(collar);
		}
		return collar;
	}
	
	

	public Collar buscarCollar(String nombre) {
		int i = 0;
		Collar collar = null;
		Collar c;

		while (i < this.collares.size() && collar == null) {
			c = this.collares.get(i);
			if (c != null && c.getNombre().equals(nombre)) {
				collar = c;
			} else {
				i++; 
			}
		}
		return collar;
	}
	
	public Collar dameCollar(String nombre) {
		Collar collar = buscarCollar(nombre);
		if(collar != null) {
			this.collares.remove(collar);
		}
		return collar;
	}

}
