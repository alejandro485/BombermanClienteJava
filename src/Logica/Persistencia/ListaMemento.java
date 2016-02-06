package Logica.Persistencia;

import java.util.ArrayList;

import Vista.Fabricas.FabricaListaArchivos;

public class ListaMemento {
	private ArrayList<Memento> listaMemento;
	
	public ListaMemento() {
		listaMemento=new ArrayList<>();
		cargarArchivos();
	}
	
	public void agregarMemento(Memento m){
		Archivo.getInstancia().generarBase("src/Logica/Persistencia/CF/config"+getLargoLista()+".obj", m);
		listaMemento.add(m);
	}
	
	public Memento getMemento(int i){
		return listaMemento.get(i);
	}

	public int getLargoLista() {
		return listaMemento.size();
	}
	
	private void cargarArchivos(){
		String path="src/Logica/Persistencia/CF";
		ArrayList<String> lista=FabricaListaArchivos.get(path);
		for(int i=0;i<lista.size();i++){
			listaMemento.add(Archivo.getInstancia().cargar(path+"/"+lista.get(i)));
		}
	}
	
}
