package Vista.Fabricas;

import java.util.HashMap;

import Logica.Componente.Bomba.AtraviezaPared;
import Logica.Componente.Bomba.Bomba;
import Logica.Componente.Bomba.Comun;

public class PrototiposBomba {
	private static HashMap<String, Bomba> listaBombas;
	
	public static void abrirPrototipos(){
		listaBombas=new HashMap<String, Bomba>();
		listaBombas.put("AtraviezaParedas",new AtraviezaPared());
		listaBombas.put("Comun", new Comun());
	}
	
	public static Bomba get(String key){
		Bomba b=listaBombas.get(key);
		if(b==null){
			return null;
		}
		return (Bomba) b.clone();
	}
	
}
