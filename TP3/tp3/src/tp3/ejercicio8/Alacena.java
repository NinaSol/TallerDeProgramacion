package tp3.ejercicio8;

import java.util.ArrayList;

public class Alacena {
	private String fabricante;
	private ArrayList<Producto> productos;

	public Alacena(String fabricante) {
		this.fabricante = fabricante;
		this.productos = new ArrayList<Producto>();
	}
	
	public double verificarCantIngredientes(String nombreProducto,double cantNecesaria) {
		double cantFaltante = 0;
		Producto producto = buscarProducto(nombreProducto);
		
		if(producto != null) {
			if(producto.getCantidad() < cantNecesaria) {
				cantFaltante = cantNecesaria - producto.getCantidad();
			}
		}else {
			cantFaltante = cantNecesaria;
		}
		return cantFaltante;
	}
	
	private Producto buscarProducto(String nombre) {
		int i = 0;
		Producto producto = null;
		
		while(i < this.productos.size() && producto == null) {
			Producto productoEncontrado = this.productos.get(i);
			
			if(productoEncontrado.mismoNombre(nombre)) {
				producto = productoEncontrado;
			}else {
				i++;
			}
		}
		return producto;
	}
	
	
	public boolean agregarProducto(String nombre,double cant, String fecha) {
		boolean resultado = false;
		Producto producto = buscarProducto(nombre);
		
		if(producto == null) {
			producto = new Producto(nombre,cant,fecha);
			this.productos.add(producto);
			resultado = true;
		}
		return resultado;
	}
}
