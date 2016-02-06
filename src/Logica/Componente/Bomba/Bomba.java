package Logica.Componente.Bomba;

import Logica.Componente.Componente;

public abstract class Bomba implements Componente {
	
	protected int capacidad;
	protected boolean terminado;
	protected boolean fullFire;
	protected int pocX;
	protected int pocY;
	
	public Bomba() {
		capacidad=1;
		terminado=false;
		fullFire=false;
	}

	@Override
	public boolean isTerminado() {
		return terminado;
	}
	
	public int getPocX() {
		return pocX;
	}

	public void setPocX(int pocX) {
		this.pocX = pocX;
	}

	public int getPocY() {
		return pocY;
	}

	public void setPocY(int pocY) {
		this.pocY = pocY;
	}

	public boolean isFullFire() {
		return fullFire;
	}

	public void setFullFire(boolean fullFire) {
		this.fullFire = fullFire;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	
	public void activar(){
		new Thread(this).start();
	}
	
	public void run(){
		terminado=true;
		ejecutar();
	}
	
	public Object clone(){
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
}
