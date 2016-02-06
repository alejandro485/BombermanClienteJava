package Logica.Conexion;

import java.util.StringTokenizer;

import Logica.Mundo;
import Logica.Componente.Bomba.Bomba;
import Logica.Componente.Bonus.Bonus;
import Vista.Fabricas.PrototiposBomba;
import Vista.Fabricas.PrototiposBonus;
import Vista.Representacion.RepresentacionAjena;

public class Interprete {
	
	public void interpretar(String ms){
		Mundo m=Mundo.getInstancia();
		StringTokenizer st=new StringTokenizer(ms,"||");
		String segundo="";
		String tercero="";
		String cuarto="";
		String quinto="";
		String primer=st.nextToken();
		switch(primer){
		case "jugador":
			segundo=st.nextToken();
			tercero=st.nextToken();
			cuarto=st.nextToken();
			quinto=st.nextToken();
			RepresentacionAjena rj;
			rj=new RepresentacionAjena();
			rj.setImagen(tercero);
			rj.setNombre(segundo);
			rj.setCuadrante(Integer.parseInt(cuarto), Integer.parseInt(quinto));
			m.getJugadores().put(segundo, rj);
			break;
		case "bomba":
			segundo=st.nextToken();
			tercero=st.nextToken();
			cuarto=st.nextToken();
			quinto=st.nextToken();
			Bomba bomba=PrototiposBomba.get(segundo);
			bomba.setCapacidad(Integer.parseInt(tercero));
			bomba.setPocX(Integer.parseInt(cuarto));
			bomba.setPocY(Integer.parseInt(quinto));
			m.agregarBomba(bomba.getPocX(), bomba.getPocY(), bomba);
			break;
		case "bonus":
			segundo=st.nextToken();
			tercero=st.nextToken();
			cuarto=st.nextToken();
			Bonus bonus=PrototiposBonus.get(segundo);
			m.agregarBonus(Integer.parseInt(tercero), Integer.parseInt(cuarto), bonus);
			break;
		case "remove":
			segundo=st.nextToken();
			tercero=st.nextToken();
			m.asignarValor(Integer.parseInt(segundo), Integer.parseInt(tercero),0);
			break;
		case "logout":
			segundo=st.nextToken();
			Mundo.getInstancia().getJugadores().remove(segundo);
			break;
		}
	}
}
