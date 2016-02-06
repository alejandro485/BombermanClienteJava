package Logica.Conexion;

import java.io.DataInputStream;
import java.io.PrintStream;
import java.net.Socket;

import Logica.Persistencia.Configuracion;

public class ClienteSocket extends Thread{
	
	private Interprete interprete;
	private Socket socket;
	private DataInputStream dis;
	private PrintStream ps;
	
	private static ClienteSocket clienteS=null;
	
	public static ClienteSocket getClienteS(){
		if(clienteS==null){
			clienteS=new ClienteSocket();
			clienteS.start();
		}
		return clienteS;
	}
	
	public ClienteSocket() {
		try {
			socket=new Socket(Configuracion.getInstacia().getHost(),Configuracion.getInstacia().getPuerto());
			System.out.println("Conectado");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		interprete=new Interprete();
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		try {
			dis=new DataInputStream(socket.getInputStream());
			ps=new PrintStream(socket.getOutputStream());
			while(true){
				String input=null;
				input=dis.readLine().trim();
				if(input!=null){
					interprete.interpretar(input);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void enviarMensaje(String st){
		ps.println(st);
	}
	
	public static void nulificar(){
		clienteS=null;
	}
	
}
