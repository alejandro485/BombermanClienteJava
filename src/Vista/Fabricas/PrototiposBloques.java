package Vista.Fabricas;

import java.util.HashMap;

import Vista.Bloque.Bloque;
import Vista.Bloque.BloqueBomba;
import Vista.Bloque.BloqueBonus;
import Vista.Bloque.BloqueFuego;
import Vista.Bloque.BloquePared;
import Vista.Bloque.BloqueParedFirme;

public class PrototiposBloques {
	
	private static HashMap<String, Bloque> listaBloque;
	
	public static void abrirPrototipos(){
		listaBloque=new HashMap<String, Bloque>();
		listaBloque.put("BloqueBomba",new BloqueBomba());
		listaBloque.put("BloqueBonus",new BloqueBonus());
		listaBloque.put("BloqueFuego",new BloqueFuego());
		listaBloque.put("BloquePared",new BloquePared());
		listaBloque.put("BloqueParedFirme",new BloqueParedFirme());
	}
	
	public static Bloque getBloque(String key){
		Bloque b=listaBloque.get(key);
		if(b==null){
			return null;
		}
		return (Bloque) b.clone();
	}
	
}
