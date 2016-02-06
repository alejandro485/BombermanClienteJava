package Logica.Componente.Bomba;

import java.awt.Point;
import java.util.ArrayList;

import Logica.Mundo;

public class AtraviezaPared extends Bomba{

	@Override
	public void ejecutar() {
		ArrayList<Point> listaPuntos=new ArrayList<Point>();
		int ayuda;
		listaPuntos.add(new Point(this.pocX,this.pocY));
		if(fullFire){
			ayuda=15;
		}
		else{
			ayuda=capacidad;
		}
		for(int i=1;i<=ayuda;i++){
			if(pocX+i<15){
				if(Mundo.getInstancia().getMatriz()[pocX+i][pocY]==0 || Mundo.getInstancia().getMatriz()[pocX+i][pocY]==4){
					listaPuntos.add(new Point(pocX+i,pocY));
				}
			}
			if(pocX-i>=0){
				if(Mundo.getInstancia().getMatriz()[pocX-i][pocY]==0 || Mundo.getInstancia().getMatriz()[pocX-i][pocY]==4){
					listaPuntos.add(new Point(pocX-i,pocY));
				}
			}
			if(pocY+i<15){
				if(Mundo.getInstancia().getMatriz()[pocX][pocY+i]==0 || Mundo.getInstancia().getMatriz()[pocX][pocY+i]==4){
					listaPuntos.add(new Point(pocX,pocY+i));
				}
			}
			if(pocY-i>=0){
				if(Mundo.getInstancia().getMatriz()[pocX][pocY-i]==0 || Mundo.getInstancia().getMatriz()[pocX][pocY-i]==4){
					listaPuntos.add(new Point(pocX,pocY-i));
				}
			}
		}
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(int i=0;i<listaPuntos.size();i++){
			Mundo.getInstancia().asignarValor(listaPuntos.get(i).x, listaPuntos.get(i).y, 3);
		}
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(int i=0;i<listaPuntos.size();i++){
			Mundo.getInstancia().asignarValor(listaPuntos.get(i).x, listaPuntos.get(i).y, 0);
		}
	}

	public Object clone(){
		return new AtraviezaPared();
	}
	
}
