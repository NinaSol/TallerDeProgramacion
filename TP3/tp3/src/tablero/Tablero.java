package tablero;

import java.util.ArrayList;

public class Tablero {
	private static final int MIN_LUCES = 3;
	private static final int MAX_LUCES = 32;
	private Telon telon;
	private int cantMaxLuces;
	private int cantLucesPrendidas;
	private ArrayList<Lampara> luces;
	private ArrayList<HistoricoLuz> historicoLuces;

	public Tablero(int cantMaxLuces) {
		setCantMaxLuces(cantMaxLuces);
		this.cantLucesPrendidas = 0;
		this.luces = new ArrayList<Lampara>();
		this.historicoLuces = new ArrayList<HistoricoLuz>();
	}

	private void setCantMaxLuces(int cant) {
		if (cant < 3) {
			this.cantMaxLuces = MIN_LUCES;
		} else if (cant > 32) {
			this.cantMaxLuces = MAX_LUCES;
		} else {
			this.cantMaxLuces = cant;
		}
	}

	private int cantLucesPrendidas() {
		int total = 0;
		for (Lampara l : this.luces) {
			if (l.estaPrendida()) {
				total++;
			}
		}
		this.cantLucesPrendidas = total;
		return this.cantLucesPrendidas;
	}

	public double porcentajeLucesPrendidas() {
		double porcentaje = (cantLucesPrendidas() * 100) / this.cantMaxLuces;
		return porcentaje;

	}

	private boolean topeLuces() {
		return this.luces.size() == this.cantMaxLuces;
	}

	public void agregarLampara(Sector sector, Color colorInicial) {
		if (sectorValido(sector) && colorValido(colorInicial) && !topeLuces()) {
			Lampara lampara = new Lampara(sector, colorInicial);
			this.luces.add(lampara);
			HistoricoLuz historico = new HistoricoLuz(lampara, Accion.CREADO);
			this.historicoLuces.add(historico);
		}
	}

	public void borrarLampara(int id) {
		Lampara lampara = buscarLampara(id);
		if (lampara != null) {
			this.luces.remove(id);
		}
	}

	public void agregarTelon(Telon telon) {
		if (telon != null) {
			this.telon = telon;
		}
	}

	private Lampara buscarLampara(int id) {
		int i = 0;
		Lampara lampara = null;

		while (i < this.luces.size() && lampara == null) {
			Lampara lamparaEncontrada = this.luces.get(i);

			if (lamparaEncontrada.mismoId(id)) {
				lampara = lamparaEncontrada;
			} else {
				i++;
			}
		}
		return lampara;
	}

	private boolean sectorValido(Sector sector) {
		return sector != null;
	}

	private boolean colorValido(Color color) {
		return color != null;
	}

	private boolean cantAptaParaSubir() {
		return this.luces.size() >= 3;
	}

	public void subirTelon() {
		if (cantAptaParaSubir()) {
			if (telon.subir()) {
				System.out.println("Arriba telon!");
			} else {
				System.out.println("El telon ya se ha subido!");
			}
		}

	}

	public void bajarTelon() {
		if (telon.bajar()) {
			System.out.println("Se bajo el telon");
		} else {
			System.out.println("El telon ya estaba bajado");
		}
	}

	public void prenderLuces(Sector sector) {
		for (Lampara l : this.luces) {
			if (l.mismoSector(sector) && !l.estaPrendida()) {
				l.encender();
				HistoricoLuz historico = new HistoricoLuz(l, Accion.PRENDIDO);
				this.historicoLuces.add(historico);
			}
		}
		System.out.println("Se prendieron " + cantLucesPrendidas() + " luces en el sector " + sector);
	}

	public void apagarLuz(int id) {
		Lampara lampara = buscarLampara(id);
		boolean apagada = false;

		if (lampara != null) {
			apagada = lampara.apagar();
		}
		if (apagada) {
			System.out.println("Se apago la luz con id " + id);
			HistoricoLuz historico = new HistoricoLuz(lampara, Accion.APAGADO);
			this.historicoLuces.add(historico);
		} else {
			System.out.println("No se pudo apagar la luz con id " + id);
		}
	}

	public void prenderLuz(int id) {
		Lampara lampara = buscarLampara(id);
		boolean encendida = false;

		if (lampara != null) {
			encendida = lampara.encender();
		}
		if (encendida == true) {
			System.out.println("Se prendio la luz con id " + id);
			HistoricoLuz historico = new HistoricoLuz(lampara, Accion.PRENDIDO);
			this.historicoLuces.add(historico);
		} else {
			System.out.println("No se pudo prender la luz con id " + id);
		}
	}

	public void apagarLuces() {
		for (Lampara l : this.luces) {
			if (l.estaPrendida()) {
				l.apagar();
				HistoricoLuz historico = new HistoricoLuz(l, Accion.APAGADO);
				this.historicoLuces.add(historico);
			}
		}
	}

	public void mostrarEstadoGeneralLuces() {
		System.out.println("Porcentaje encendido: " + cantLucesPrendidas() + " (" + porcentajeLucesPrendidas() + "%)");
	}

	public void cambiarLucesDeColor(Color colorActual, Color colorACambiar) {
		int i = 0;
		for (Lampara l : this.luces) {
			if (l.mismoColor(colorActual)) {
				l.cambiarColor(colorACambiar);
				i++;
				HistoricoLuz historico = new HistoricoLuz(l, Accion.COLOR_CAMBIADO);
				this.historicoLuces.add(historico);
			}
		}
		System.out.println("Se cambiaron " + i + " luces de " + colorActual + " a " + colorACambiar);
	}

	public void apagarYCerrarTodo() {
		int prendidas = cantLucesPrendidas();
		apagarLuces();
		bajarTelon();
		System.out.println("Habia " + prendidas + " luces prendidas");
	}

	public void mostrarHistoricoLuces() {
		for (HistoricoLuz h : this.historicoLuces) {
			System.out.println(h);
		}
	}
}
