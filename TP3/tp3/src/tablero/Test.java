package tablero;

public class Test {

	public static void main(String[] args) {
		Tablero tablero = new Tablero(35);
		Telon telon = new Telon();
		
		tablero.agregarTelon(telon);
		

		tablero.agregarLampara(Sector.MEDIO,Color.AMARILLA);
		tablero.agregarLampara(Sector.MEDIO,Color.AZUL);
		tablero.agregarLampara(Sector.MEDIO,Color.BLANCA);
		tablero.agregarLampara(Sector.MEDIO,Color.ROJA);
		tablero.agregarLampara(Sector.ATRAS,Color.AMARILLA);
		tablero.agregarLampara(Sector.ATRAS,Color.AZUL);
		tablero.agregarLampara(Sector.ATRAS,Color.BLANCA);
		tablero.agregarLampara(Sector.ATRAS,Color.ROJA);
		tablero.agregarLampara(Sector.ADELANTE,Color.AMARILLA);
		tablero.agregarLampara(Sector.ADELANTE,Color.AZUL);
		tablero.agregarLampara(Sector.ADELANTE,Color.BLANCA);
		tablero.agregarLampara(Sector.ADELANTE,Color.ROJA);
		
		
		tablero.prenderLuz(3);
		tablero.prenderLuz(3);
		tablero.prenderLuz(0);

		
		
		tablero.subirTelon();
		
		tablero.prenderLuces(Sector.ADELANTE);
		
		tablero.mostrarEstadoGeneralLuces();
		
		tablero.apagarLuz(3);
		tablero.apagarLuz(3);
		tablero.apagarLuz(0);
		

		
		tablero.cambiarLucesDeColor(Color.BLANCA, Color.AZUL);
		
		tablero.subirTelon();
		
		tablero.apagarYCerrarTodo();
		
		tablero.mostrarHistoricoLuces();
		
		


	}

}
