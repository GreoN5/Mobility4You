
public class GasCar extends Vehicle {
	
	public float engineDisplacement;

	public GasCar(String brand, String model, short enginePower, double carPrice, float engineDisplacement) {
		super(brand, model, enginePower, carPrice);
		this.engineDisplacement = engineDisplacement;
	}

	@Override
	public String showCarInfo() {
		return this.getClass().getSimpleName() + ", " + this.brand + ", " 
				+ this.model + ", " + this.engineDisplacement + "L, " 
				+ this.powerOfEngine + "KW, " + this.price + " euro";
	}

}
