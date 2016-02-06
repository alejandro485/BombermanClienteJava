package Logica.Componente.Bonus;



public class AtraviesaPared extends Bonus {

	@Override
	public void ejecutar() {
		this.receptor.setAtravesarParedes(true);
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.receptor.setAtravesarParedes(false);
	}

}
