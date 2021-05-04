
public class HybridCar extends Vehicle {
	
	public float engineDisplacement;
	public int batteryCapacity;

	public HybridCar(String brand, String model, short enginePower, double carPrice, float engineDisplacement, int batteryCapacity) {
		super(brand, model, enginePower, carPrice);
		this.engineDisplacement = engineDisplacement;
		this.batteryCapacity = batteryCapacity;
	}

	@Override
	public String showCarInfo() {
		return this.getClass().getSimpleName() + ", " + this.brand + ", " 
				+ this.model + ", " + this.engineDisplacement + "L, " 
				+ this.powerOfEngine + "KW, " + this.batteryCapacity + "Ah, " + this.price + " euro";
	}

}
