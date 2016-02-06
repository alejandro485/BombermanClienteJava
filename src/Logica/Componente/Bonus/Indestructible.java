package Logica.Componente.Bonus;



public class Indestructible extends Bonus {

	@Override
	public void ejecutar() {
		this.receptor.setIndestructible(true);
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.receptor.setIndestructible(false);
	}

}
