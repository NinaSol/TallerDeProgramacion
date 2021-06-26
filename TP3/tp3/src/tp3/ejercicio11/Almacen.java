package tp3.ejercicio11;

import java.util.ArrayList;

public class Almacen {
	private double temperatura;
	private boolean refrigerado;
	private ArrayList<Producto> productos;

	public Almacen(double temperatura, boolean refrigerado) {
		setTemperatura(temperatura);
		setRefrigerado(refrigerado);
		this.productos = new ArrayList<Producto>();
	}

	private void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}

	private void setRefrigerado(boolean refrigerado) {
		this.refrigerado = refrigerado;
	}

	public ArrayList<Producto> getProductos() {
		return this.productos;
	}

	public Producto buscarProducto(String nombre) {
		int i = 0;
		Producto producto = null;
		while (i < this.productos.size() && producto == null) {
			Producto productoEncontrado = this.productos.get(i);
			if (productoEncontrado.mismoNombre(nombre)) {
				producto = productoEncontrado;
			} else {
				i++;
			}
		}
		return producto;
	}

	public void agregarProducto(String nombre, int dias, Fecha fecha) {
		Producto producto = buscarProducto(nombre);

		if (producto == null) {
			producto = new Producto(nombre, dias, fecha);
			this.productos.add(producto);
		}
	}

	public Estado chequearProducto(String nombre) {
		Producto producto = buscarProducto(nombre);
		Estado resp = null;
		if (producto != null) {
			if (producto.estaVencido()) {
				resp = Estado.PARA_DESCARTE;
			} else {
				resp = Estado.FRESCO;
			}
		} else {
			resp = Estado.NO_ENCONTRADO;
		}
		return resp;
	}

	public void eliminarProductosVencidos(ArrayList<Producto> vencidos) {
		int i = 0;
		Producto productoEliminar = null;
		while (i < this.productos.size() && productoEliminar == null) {
			Producto productoEncontrado = this.productos.get(i);
			if (productoEncontrado.estaVencido()) {
				this.productos.remove(productoEncontrado);
				vencidos.add(productoEncontrado);
			} else {
				i++;
			}
		}

	}

}
