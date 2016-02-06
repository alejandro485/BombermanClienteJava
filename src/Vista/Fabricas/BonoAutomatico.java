package Vista.Fabricas;

import javax.swing.Timer;

import Controladores.ControladorRecurrencia;

public class BonoAutomatico {
	private static Timer recurencia;
	
	public static void crearRecurrencia(ControladorRecurrencia CR){
		recurencia=new Timer(10000, CR);
	}
	
	public static void comenzar(){
		recurencia.start();
	}
	
}
