
public abstract class Vehicle {
	
	protected String brand;
	protected String model;
	protected short powerOfEngine;
	protected double price;
	
	public Vehicle(String brand, String model, short enginePower, double carPrice) {
		this.brand = brand;
		this.model = model;
		this.powerOfEngine = enginePower;
		this.price = carPrice;
	}
	
	public abstract String showCarInfo();
}
