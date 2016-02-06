package Logica.Persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

public class Archivo{
	
	private File archivo;
	
	private static Archivo persistencia=null;
	private ObjectInputStream streamInObjeto;
	
	public boolean generarBase(String name, Memento m)
	{
		try{
			archivo=new File(name);
			ObjectOutputStream  streamOutObjeto=new ObjectOutputStream(new FileOutputStream(archivo));
			streamOutObjeto.writeObject(m);
			streamOutObjeto.close();
			return true;
		}
		catch(FileNotFoundException e){
			JOptionPane.showMessageDialog(null, "El archivo no se encuentra o esta corrompido");
			return false;
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString());
			return false;
		}
	}
	
	public Memento cargar(String path)
	{
		archivo=new File(path);
		Memento m=null;
		try{
			streamInObjeto = new ObjectInputStream(new FileInputStream(archivo));
			m=(Memento)streamInObjeto.readObject();
		}
		catch(ClassNotFoundException e){
		}
		catch(IOException e){
		}
		return m;
	}
	
	public static Archivo getInstancia(){
		if(persistencia==null){
			persistencia=new Archivo();
		}
		return persistencia;
	}
	
}
