package Logica.Componente.Bonus;



public class AtraviesaBomba extends Bonus {

	@Override
	public void ejecutar() {
		this.receptor.setAtravesarBombas(true);
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.receptor.setAtravesarBombas(false);
	}

}
