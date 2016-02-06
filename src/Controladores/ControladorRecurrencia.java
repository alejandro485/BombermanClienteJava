package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import Logica.Mundo;
import Logica.Componente.Bonus.Bonus;
import Vista.Fabricas.PrototiposBonus;

public class ControladorRecurrencia implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg) {
		Random r=new Random();
		int x;
		int y;
		do{
			x=r.nextInt(15);
			y=r.nextInt(15);
		}
		while(Mundo.getInstancia().getMatriz()[x][y]!=0);
		Bonus b=null;
		int i=new Random().nextInt(6);
		switch(i){
		case 0:
			b=PrototiposBonus.get("AtraviesaBomba");
			break;
		case 1:
			b=PrototiposBonus.get("AtraviesaPared");
			break;
		case 2:
			b=PrototiposBonus.get("FullFire");
			break;
		case 3:
			b=PrototiposBonus.get("Indestructible");
			break;
		case 4:
			b=PrototiposBonus.get("RangoMas");
			break;
		case 5:
			b=PrototiposBonus.get("VidaMas");
			break;
		}
		Mundo.getInstancia().agregarBonus(x, y, b);
	}

}
