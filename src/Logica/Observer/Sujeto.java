package Logica.Observer;

import java.util.ArrayList;

public abstract class Sujeto {
	
	private ArrayList<Observer> observadores;
	
	public Sujeto() {
		observadores=new ArrayList<Observer>();
	}
	
	public void agregarObservador(Observer o){
		observadores.add(o);
	}
	
	public void notificar(){
		for(int i=0;i<observadores.size();i++){
			observadores.get(i).actualizar(this);
		}
	}
	
}
