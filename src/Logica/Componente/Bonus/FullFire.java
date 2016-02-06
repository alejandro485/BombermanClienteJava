package Logica.Componente.Bonus;



public class FullFire extends Bonus {

	@Override
	public void ejecutar() {
		this.receptor.setFullFire(true);
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.receptor.setFullFire(false);
	}

}
