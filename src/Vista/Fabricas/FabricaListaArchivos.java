package Vista.Fabricas;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class FabricaListaArchivos {
	private static HashMap<String, ArrayList<String>> listaArchivos;
	
	public static void abrirFabrica() {
		listaArchivos=new HashMap<String, ArrayList<String>>();
	}
	
	public static ArrayList<String> get(String key){
		ArrayList<String> i=listaArchivos.get(key);
		if(i==null){
			File f=new File(key);
			File[] ff=f.listFiles();
			i=new ArrayList<String>();
			if(ff!=null){
				for(int j=0;j<ff.length;j++){
					i.add(ff[j].getName());
				}
				listaArchivos.put(key, i);
			}
		}
		return i;
	}
	
}
