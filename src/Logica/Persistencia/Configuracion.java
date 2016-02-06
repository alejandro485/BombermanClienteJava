package Logica.Persistencia;

import java.io.Serializable;

import Logica.Observer.Observer;
import Logica.Observer.Sujeto;
import Vista.Representacion.RepresentacionJugador;

public class Configuracion implements Serializable,Observer{

	private static final long serialVersionUID = 1L;
	private static Configuracion config=null;
	
	private String host;
	private int puerto;

	public Configuracion() {
		host="localhost";
		puerto=5566;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPuerto() {
		return puerto;
	}

	public void setPuerto(int puerto) {
		this.puerto = puerto;
	}

	@Override
	public void actualizar(Sujeto sujeto) {
		if(sujeto instanceof RepresentacionJugador){
			
		}
	}
	
	public static Configuracion getInstacia(){
		if(config==null){
			config=new Configuracion();
		}
		return config;
	}
	
	public static void setConfiguracion(Configuracion cf){
		config=cf;
	}
	
	public Memento getMemento(){
		return new Memento(this);
	}
	
	public static void cargarMemento(Memento m){
		config=m.getConfig();
	}
	
}
