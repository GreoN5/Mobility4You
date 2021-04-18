import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	private static CarCatalogue catalogue = new CarCatalogue();
	
	public static void main(String[] args) {
		
		while(true) {
			GUI();
			
			switch (choice()) {
				case 1: { 
					System.out.print("Type catalogue name: ");
					Scanner catalogueName = new Scanner(System.in);
					String file = catalogueName.next();
					System.out.println();
					
					populateCatalogue(file);
					catalogue.showAllCars();
				} 
				break;
			
				case 2: {
					addElectricCar();
				}
				break;
				
				case 3: {
					addGasCar();
				}
				break;
				
				case 4: {
					addHybridCar();
				}
				break;
				
				case 5: {
					catalogue.showCarsSortedByType();
				}
				break;
				
				case 6: {
					catalogue.showCarsSortedByBrand();
				}
				break;
				
				case 7: {
					writeToFile();
				}
				break;
				
				case 8: {
					return;
				}
				
				default: {
					break;
				}
			}
		}
	}
	
	private static void GUI() {
		System.out.println("Please make your choice:");
		System.out.println("\t 1 - Show the entire Mobility4You catalogue");
		System.out.println("\t 2 - Add a new electric car");
		System.out.println("\t 3 - Add a new gas-powered car");
		System.out.println("\t 4 - Add a new hybrid car");
		System.out.println("\t 5 - Show the entire Mobility4You catalogue sorted by car-type");
		System.out.println("\t 6 - Show the entire Mobility4You catalogue sorted by brand (alphabetically)");
		System.out.println("\t 7 - Write to file");
		System.out.println("\t 8 - Stop the program \n");
		
		System.out.print("Your choice: ");
	}
	
	private static byte choice() {
		Scanner choice = new Scanner(System.in);
		byte choiceNumber = choice.nextByte();
		System.out.println();
		
		return choiceNumber;
	}
	
	private static void addElectricCar() {
		System.out.print("Type brand name: ");
		Scanner electricBrand = new Scanner(System.in);
		String brand = electricBrand.next();
		
		System.out.print("Type model name: ");
		Scanner electricModel = new Scanner(System.in);
		String model = electricModel.next();
		
		System.out.print("Type engine power: ");
		Scanner electricEnginePower = new Scanner(System.in);
		short enginePower = electricEnginePower.nextShort();
		
		System.out.print("Type car price: ");
		Scanner carPrice = new Scanner(System.in);
		double price = carPrice.nextDouble();
		
		System.out.print("Type battery capacity: ");
		Scanner carBatteryCapacity = new Scanner(System.in);
		int batteryCapacity = carBatteryCapacity.nextInt();
		System.out.println();
		
		catalogue.addCarToCatalogue(new ElectricCar(brand, model, enginePower, price, batteryCapacity));
		System.out.println("New electric car successfully added! \n");
	}
	
	private static void addGasCar() {
		System.out.print("Type brand name: ");
		Scanner gasBrand = new Scanner(System.in);
		String brand = gasBrand.next();
		
		System.out.print("Type model name: ");
		Scanner gasModel = new Scanner(System.in);
		String model = gasModel.next();
		
		System.out.print("Type engine power: ");
		Scanner gasEnginePower = new Scanner(System.in);
		short enginePower = gasEnginePower.nextShort();
		
		System.out.print("Type car price: ");
		Scanner carPrice = new Scanner(System.in);
		double price = carPrice.nextDouble();
		
		System.out.print("Type engine displacement: ");
		Scanner gasEngineDisplacement = new Scanner(System.in);
		float engineDisplacement = gasEngineDisplacement.nextFloat();
		System.out.println();
		
		catalogue.addCarToCatalogue(new GasCar(brand, model, enginePower, price, engineDisplacement));
		System.out.println("New gas car successfully added! \n");
	}
	
	private static void addHybridCar() {
		System.out.print("Type brand name: ");
		Scanner hybridBrand = new Scanner(System.in);
		String brand = hybridBrand.next();
		
		System.out.print("Type model name: ");
		Scanner hybridModel = new Scanner(System.in);
		String model = hybridModel.next();
		
		System.out.print("Type engine power: ");
		Scanner hybridEnginePower = new Scanner(System.in);
		short enginePower = hybridEnginePower.nextShort();
		
		System.out.print("Type car price: ");
		Scanner carPrice = new Scanner(System.in);
		double price = carPrice.nextDouble();
		
		System.out.print("Type engine displacement: ");
		Scanner hybridEngineDisplacement = new Scanner(System.in);
		float engineDisplacement = hybridEngineDisplacement.nextFloat();
		
		System.out.print("Type battery capacity: ");
		Scanner hybridBatteryCapacity = new Scanner(System.in);
		int batteryCapacity = hybridBatteryCapacity.nextInt();
		System.out.println();
		
		catalogue.addCarToCatalogue(new HybridCar(brand, model, enginePower, price, engineDisplacement, batteryCapacity));
		System.out.println("New hybrid car successfully added! \n");
	}
	
	private static void populateCatalogue(String catalogueName) {
		String fullCatalogue = catalogueName + ".txt";
		
		try {
			File carCatalogue = new File(fullCatalogue);
			
			if (!carCatalogue.exists()) {
				System.out.println("Catalogue name does not exists!");
			} else {
				Scanner obj = new Scanner(fullCatalogue);
				
				while (obj.hasNext()) {
					String line = obj.next();
					String[] fields = line.split(", ");
					
					if (fields[0] == "GasCar") {
						catalogue.addCarToCatalogue(new GasCar(fields[1], fields[2], Short.parseShort(fields[3]), Double.parseDouble(fields[4]), Float.parseFloat(fields[5])));
					} else if (fields[0] == "ElectricCar") {
						catalogue.addCarToCatalogue(new ElectricCar(fields[1], fields[2], Short.parseShort(fields[3]), Double.parseDouble(fields[4]), Integer.parseInt(fields[5])));
					} else if (fields[0] == "HybridCar") {
						catalogue.addCarToCatalogue(new HybridCar(fields[1], fields[2], Short.parseShort(fields[3]), Double.parseDouble(fields[4]), Float.parseFloat(fields[5]), Integer.parseInt(fields[6])));
					}
				}
			}
			
		} catch(Exception ex) {
			System.out.println("An error ocurred!");
		}	
	}
	
	private static void writeToFile() {
		System.out.print("Type file name: ");
		Scanner fileName = new Scanner(System.in);
		String file = fileName.next();
		System.out.println();
		
		populateCatalogue(file);
		
		String fullFile = file + ".txt";
		
		try {
			File carCatalogue = new File(fullFile);
			
			if (!carCatalogue.exists()) {
				carCatalogue.createNewFile();
				FileWriter writer = new FileWriter(fullFile);
				
				for (Car car : catalogue.getCatalogue()) {
					String carInfo = car.showCarInfo();
					writer.write(carInfo + "\n");
				}
				
				writer.close();
			} else {
				carCatalogue.delete();
				FileWriter writer = new FileWriter(fullFile);
				
				for (Car car : catalogue.getCatalogue()) {
					String carInfo = car.showCarInfo();
					writer.write(carInfo + "\n");
				}
				
				writer.close();
			}
			
		} catch(IOException ex) {
			System.out.println("An error ocurred!");
		}	
	}
}
