package Logica.Componente.Bonus;



public class RangoMas extends Bonus {

	@Override
	public void ejecutar() {
		this.receptor.setCapacidadBomba(receptor.getCapacidadBomba()+1);
	}

}
