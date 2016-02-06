package Logica.Componente.Bonus;



public class VidaMas extends Bonus{

	@Override
	public void ejecutar() {
		this.receptor.setVidas(receptor.getVidas()+1);
	}

}
