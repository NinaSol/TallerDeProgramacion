package ejercicio.vuelo;

import java.util.ArrayList;

public class Vuelo {
	//atributos
	private String numeroDeVuelo;
	private int cantTotalAsientos;
	private ArrayList<Asiento> reservados; //Definimos la lista de asientos reservados
	private double montoTotal;
	
	//Constructor
	public Vuelo(String numeroDeVuelo, int cantTotalAsientos) {
		setNumeroDeVuelo(numeroDeVuelo);
		setCantTotalAsientos(cantTotalAsientos);
		reservados = new ArrayList<>(); //Se instancia la lista cuando se crea el vuelo
		this.montoTotal = 0; //Se inicializa el monto en 0
	}
	
	
	//Metodo muy importante y complejo que usa otros metodos 
	public ResultadoReserva reservarAsiento(int dni, int tel, Clase clase) {
		ResultadoReserva resultado = ResultadoReserva.ERROR_AVION_COMPLETO;  //Se utiliza un Enum para indicar el resultado
		if (buscarAsiento(dni) == null) { //utiliza otro metodo que se encuentra mas abajo para buscar el asiento
			Pasajero pasajero = new Pasajero(dni, tel); //si el pasajero no existe se instancia un nuevo pasajero
			reservados.add(new Asiento(pasajero, clase)); //se agrega al pasajero al array justo con la clase
			resultado = ResultadoReserva.RESERVA_CONFIRMADA; //Se indica que la reserva fue confirmada
		} else {
			resultado = ResultadoReserva.ERROR_YA_TIENE_PASAJE; //En caso de que exista el pasajero muestra este msj
		}
		return resultado;
	}
	
	//metodo para buscar asiento
	private Asiento buscarAsiento(int dni) {
		Asiento asientoABuscar = null;
		int i = 0;
		//Utilizamos un while para buscar y que corte la busqueda cuando encuentre un DNI que existe 
		while (asientoABuscar == null && i < reservados.size()) {
			if (reservados.get(i).mismoPasajero(dni)) { //recorre la lista de asientos y utiliza el metodo de Asiento para comparar DNI, esa funcion devuelve True o False
				asientoABuscar = reservados.get(i); //devuelve la posicion del asiento 
			} else {
				i++;
			}
		}
		return asientoABuscar;
	}
	
	//Mostrar todos los asientos reservados
	public void listarAsientosReservados() {
		if (reservados.size() > 0) { //filtro para validar si el array no tiene datos
			System.out.println("Cantidad de asientos reservados hasta el momento: " + reservados.size());
			for (Asiento reservado : reservados) { //for each para recorrer todo el array y mostrar los datos
				System.out.println(reservado); //esto utiliza el ToString de Asiento para mostrar los datos
			}
		} else {
			System.out.println("No hay asientos reservados");
		}
	}
	//Metodo para anular reserva
	public void anularReserva(int dni) {
		Asiento reserva = buscarAsiento(dni); //utiliza el metodo de buscarAsiento 
		if (reserva != null) { //si encuentra el Asiento reservado 
			reservados.remove(reserva); //lo borra de la lista 
			System.out.println("Se ha anulado la reserva con éxito"); 
		}
		System.out.println("No existe una reserva con ese dni"); // en caso de que no lo encuentre lo informamos por pantalla
	}
	
	//Calcular el monto acumulado por tipo de Clase (primera, business,turista)
	private Double obtenerAcumuladoPorClase(Clase clase) {
		double montoTotal = 0;
		for(Asiento reservado: reservados) { //For each para recorrer la lista
			if(reservado.getClase().equals(clase)) { //Llama al getter de Asiento para pedir el valor de la clase y compararlo con la clase solicitada
				montoTotal += reservado.getPrecio(); //en caso de que devuelva True suma el valor del asiento al montoTotal
			}
		}
		return montoTotal;
	}
	
	//Muestra el monto recaudado que calculamos anteriormente
	public void mostrarMontoRecaudadoDeClase(Clase clase) {
		Double totalAcumulado = obtenerAcumuladoPorClase(clase); //llamamos al metodo ya creado para calcular el total
		if(totalAcumulado != 0) { 
			System.out.println("El monto acumulado hasta el momento en la clase "+clase+" es: $"+ totalAcumulado);
		}
		else {
			System.out.println("No hay asientos reservados para la clase: "+ clase);
		}
		if(this.reservados.isEmpty()) { //isEmpty indica si el array esta vacio o no
			System.out.println("No hay asientos reservados en ninguna clase"); //en caso de no tener datos muestra el msj
		}
	}
	
	
	//Getters y Setters (capaz hay alguno de mas)
	public String getNumeroDeVuelo() {
		return numeroDeVuelo;
	}

	public void setNumeroDeVuelo(String numeroDeVuelo) {
		this.numeroDeVuelo = numeroDeVuelo;
	}

	public int getCantTotalAsientos() {
		return cantTotalAsientos;
	}

	public void setCantTotalAsientos(int cantTotalAsientos) {
		this.cantTotalAsientos = cantTotalAsientos;
	}

	public ArrayList<Asiento> getReservados() {
		return reservados;
	}

	public void setReservados(ArrayList<Asiento> reservados) {
		this.reservados = reservados;
	}

	public double getMontoTotal() {
		return montoTotal;
	}

}
