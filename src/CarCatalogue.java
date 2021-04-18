import java.util.ArrayList;

public class CarCatalogue {

	private ArrayList<Car> catalogue;
	
	public CarCatalogue() {
		this.catalogue = new ArrayList<Car>();
	}
	
	public void addCarToCatalogue(Car car) {
		this.catalogue.add(car);
	}
	
	public void showAllCars() {
		for (Car c : this.catalogue) {
			String carInfo = c.showCarInfo();
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
	
	public ArrayList<Car> getCatalogue() {
		return this.catalogue;
	}
}
