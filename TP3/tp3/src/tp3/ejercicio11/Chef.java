package tp3.ejercicio11;

import java.util.ArrayList;

public class Chef {
	private String nombre;
	private Almacen refrigedaro;
	private Almacen noRefrigedaro;

	public Chef(String nombre, Almacen refrigedaro, Almacen noRefrigedaro) {
		setNombre(nombre);
		setRefrigedaro(refrigedaro);
		setNoRefrigedaro(noRefrigedaro);
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private void setRefrigedaro(Almacen refrigedaro) {
		this.refrigedaro = refrigedaro;
	}

	private void setNoRefrigedaro(Almacen noRefrigedaro) {
		this.noRefrigedaro = noRefrigedaro;
	}

	public ArrayList<Producto> extraerProductosVencidos() {
		ArrayList<Producto> productosVencidos = new ArrayList<Producto>();
		
		this.refrigedaro.eliminarProductosVencidos(productosVencidos);
		this.noRefrigedaro.eliminarProductosVencidos(productosVencidos);

		return productosVencidos;
	}
	
	public Estado chequearProducto(String nombreProducto, boolean refrigerado) {
		Estado resp = null;
		if(refrigerado) {
			resp = this.refrigedaro.chequearProducto(nombreProducto);
		}else {
			resp = this.noRefrigedaro.chequearProducto(nombreProducto);
		}
		
		
		return resp;
	}


	

}
