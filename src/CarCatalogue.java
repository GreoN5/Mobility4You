import java.util.ArrayList;

public class CarCatalogue {

	private ArrayList<Vehicle> catalogue;
	
	public CarCatalogue() {
		this.catalogue = new ArrayList<Vehicle>();
	}
	
	public void addCarToCatalogue(Vehicle car) {
		this.catalogue.add(car);
	}
	
	public void showAllCars() {
		for (Vehicle v : this.catalogue) {
			String carInfo = v.showCarInfo();
			System.out.println(carInfo);
		}
		
		System.out.println();
	}
	
	public void showCarsSortedByType() {
		this.catalogue.sort((t1, t2) -> t1.getClass().getSimpleName().compareTo(t2.getClass().getSimpleName()));
		
		this.showAllCars();
	}
	
	public void showCarsSortedByBrand() {
		this.catalogue.sort((t1, t2) -> t1.brand.compareTo(t2.brand));
		
		this.showAllCars();
	}
	
	public ArrayList<Vehicle> getCatalogue() {
		return this.catalogue;
	}
}
