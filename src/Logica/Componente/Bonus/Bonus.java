package Logica.Componente.Bonus;

import Logica.Jugador;
import Logica.Componente.Componente;

public abstract class Bonus implements Componente{

	protected Jugador receptor;
	protected boolean terminado;
	
	public Bonus() {
		terminado=false;
	}

	public boolean isTerminado() {
		return terminado;
	}

	public void activar(){
		new Thread(this).start();
	}

	public Jugador getReceptor() {
		return receptor;
	}

	public void setReceptor(Jugador receptor) {
		this.receptor = receptor;
	}
	
	@Override
	public void run() {
		ejecutar();
		terminado=true;
	}
	
    public Object clone(){
        Object obj=null;
        try{
            obj=super.clone();
        }catch(CloneNotSupportedException ex){
            System.out.println(" no se puede duplicar");
        }
        return obj;
    }
	
}
