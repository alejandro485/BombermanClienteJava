package Vista.Fabricas;

import java.awt.Image;
import java.util.HashMap;

import javax.swing.ImageIcon;

import Logica.Mundo;

public class FabricaImagenes {
	
	private static HashMap<String, Image> listaImagen;
	
	public static void abrirFabrica() {
		listaImagen=new HashMap<String, Image>();
	}
	
	public static Image get(String key){
		Image i=listaImagen.get(key);
		if(i==null){
			ImageIcon im=new ImageIcon(key);
			im=new ImageIcon(im.getImage().getScaledInstance(Mundo.largo, Mundo.largo, Image.SCALE_SMOOTH));
			listaImagen.put(key, im.getImage());
			i=im.getImage();
		}
		return i;
	}
	
	public static Image get(String key, int x, int y){
		Image i=listaImagen.get(key);
		if(i==null){
			ImageIcon im=new ImageIcon(key);
			im=new ImageIcon(im.getImage().getScaledInstance(x, y, Image.SCALE_SMOOTH));
			listaImagen.put(key, im.getImage());
			i=im.getImage();
		}
		return i;
	}
}
