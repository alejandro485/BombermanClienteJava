package Logica.Persistencia;

import java.io.Serializable;

public class Memento implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Configuracion config;
	public Memento(Configuracion config) {
		this.config=config;
	}
	public Configuracion getConfig(){
		return config;
	}
}
