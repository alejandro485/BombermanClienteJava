package Vista.Fabricas;

import java.util.HashMap;

import Logica.Componente.Bonus.Bonus;
import Logica.Componente.Bonus.AtraviesaBomba;
import Logica.Componente.Bonus.AtraviesaPared;
import Logica.Componente.Bonus.FullFire;
import Logica.Componente.Bonus.Indestructible;
import Logica.Componente.Bonus.RangoMas;
import Logica.Componente.Bonus.VidaMas;

public class PrototiposBonus {
	private static HashMap<String, Bonus> listaBombas;
	
	public static void abrirPrototipos(){
		listaBombas=new HashMap<String, Bonus>();
		listaBombas.put("RangoMas",new RangoMas());
		listaBombas.put("VidaMas", new VidaMas());
		listaBombas.put("AtraviesaBomba", new AtraviesaBomba());
		listaBombas.put("AtraviesaPared", new AtraviesaPared());
		listaBombas.put("FullFire", new FullFire());
		listaBombas.put("Indestructible", new Indestructible());
		
	}
	
	public static Bonus get(String key){
		Bonus b=listaBombas.get(key);
		if(b==null){
			return null;
		}
		return (Bonus) b.clone();
	}
	
}
