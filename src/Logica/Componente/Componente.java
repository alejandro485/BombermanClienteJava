package Logica.Componente;

public interface Componente extends Cloneable,Runnable{
	
	public Object clone();
	public void ejecutar();
	public boolean isTerminado();
}
