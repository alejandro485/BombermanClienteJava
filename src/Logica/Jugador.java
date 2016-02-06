package Logica;

import Logica.Componente.Bomba.Bomba;
import Logica.Componente.Bomba.Comun;
import Logica.Conexion.ClienteSocket;
import Logica.Observer.Sujeto;

public class Jugador extends Sujeto {
	private int vidas;
	private int capacidadBomba;
	private Bomba tipoBomba;
	private int velocidad;
	private String nombre;
	
	private boolean indestructible;
	private boolean fullFire;
	private boolean atravesarParedes;
	private boolean atravesarBombas;

	public Jugador(String nombre) {
		super();
		this.nombre=nombre;
		velocidad=10;
		vidas = 5;
		this.capacidadBomba = 2;
		tipoBomba = new Comun();
		tipoBomba.setCapacidad(this.capacidadBomba);
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
		notificar();
	}

	public Bomba getTipoBomba() {
		return tipoBomba;
	}
	
	public void setTipoBomba(Bomba tipoBomba) {
		this.tipoBomba = tipoBomba;
	}

	public int getCapacidadBomba() {
		return capacidadBomba;
	}

	public void setCapacidadBomba(int capacidadBomba) {
		this.capacidadBomba = capacidadBomba;
		tipoBomba.setCapacidad(this.capacidadBomba);
		notificar();
	}

	public boolean isFullFire() {
		return fullFire;
	}

	public void setFullFire(boolean fullFire) {
		this.fullFire = fullFire;
		notificar();
	}

	public boolean isAtravesarParedes() {
		return atravesarParedes;
	}

	public void setAtravesarParedes(boolean atravesarParedes) {
		this.atravesarParedes = atravesarParedes;
		notificar();
	}

	public boolean isAtravesarBombas() {
		return atravesarBombas;
	}

	public void setAtravesarBombas(boolean atravesarBombas) {
		this.atravesarBombas = atravesarBombas;
		notificar();
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
		notificar();
	}

	public boolean isIndestructible() {
		return indestructible;
	}

	public void setIndestructible(boolean indestructible) {
		this.indestructible = indestructible;
		notificar();
	}

	public int getVidas() {
		return vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
		if(this.vidas<=0){
			ClienteSocket.getClienteS().enviarMensaje("logout");
			ClienteSocket.nulificar();
		}
		notificar();
	}

}
