
public class ElectricCar extends Vehicle {
	
	public int batteryCapacity;

	public ElectricCar(String brand, String model, short enginePower, double carPrice, int batteryCapacity) {
		super(brand, model, enginePower, carPrice);
		this.batteryCapacity = batteryCapacity;
	}

	@Override
	public String showCarInfo() {
		return this.getClass().getSimpleName() + ", " + this.brand + ", " 
				+ this.model + ", " + this.powerOfEngine + "KW, " + this.batteryCapacity + "Ah, " + this.price + " euro";
	}

}
