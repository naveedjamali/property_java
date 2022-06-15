import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Assignment2 {
	static Agency agency;

	public static void main(String[] args) {

		Assignment2 assignment2 = new Assignment2();
		try {

			assignment2.init();
			assignment2.doSearches();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doSearches() {

		Scanner scanner = new Scanner(System.in);
		String userInput = "";

		do {
			System.out.print("Welcome to our Property Search");
			System.out.print("Choose one of the following options:");
			System.out.print("\t1.\tGeneral Queries");
			System.out.print("\t2.\tResidence Queries");
			System.out.print("\t3.\tCommercial Queries");
			System.out.print("\t4.\tRetail Queries");
			System.out.print("\t5.\tExit");

			userInput = scanner.nextLine();

			if (userInput.equals("1")) {

				generalQueries();

			} else if (userInput.equals("2")) {

				residenceQueries();

			} else if (userInput.equals("3")) {

				commercialQueries();

			} else if (userInput.equals("4")) {

				retailQueries();

			} else if (userInput.equals("5")) {

				scanner.close();
				System.exit(0);

			} else {

				System.out.println("Invalid input");

			}

			userInput = "";

		} while (!userInput.equals("5"));

	}

	public void generalQueries() {

		Scanner scanner = new Scanner(System.in);
		String userInput = "";

		do {
			System.out.print("\t1.\tBy Property");
			System.out.print("\t2.\tBy Price");
			System.out.print("\t3.\tBy Street");
			System.out.print("\t4.\tBy Type");
			System.out.print("\t5.\tBack");

			userInput = scanner.nextLine();

			if (userInput.equals("1")) {
				doSearchByPropertyId();

			} else if (userInput.equals("2")) {

				doSeachByPrice();

			} else if (userInput.equals("3")) {
				doSearchByStreet();

			} else if (userInput.equals("4")) {

				doSearchByType();

			} else if (userInput.equals("5")) {

				userInput = "";
				break;

			} else {

				System.out.println("Invalid input");

			}

			userInput = "";

		} while (!userInput.equals("5"));

	}

	private void doSearchByType() {
		// TODO Auto-generated method stub

	}

	private void doSearchByStreet() {
		// TODO Auto-generated method stub

	}

	private void doSeachByPrice() {
		// TODO Auto-generated method stub

	}

	public void doSearchByPropertyId() {
		System.out.print("Enter Property ID");

		Scanner scanner = new Scanner(System.in);
		String propId = scanner.nextLine();
		try {
			System.out.print(agency.getProperty(propId));
		} catch (Exception e) {

			System.out.print("No Property found with PropertyID: " + propId);
		}
	}

	public void residenceQueries() {

		Scanner scanner = new Scanner(System.in);
		String userInput = "";

		do {
			System.out.print("\t1.\tBy Bedroom");
			System.out.print("\t2.\tBy Pool");
			System.out.print("\t3.\tBy Strata");
			System.out.print("\t4.\tBack");

			userInput = scanner.nextLine();

			if (userInput.equals("1")) {

				generalQueries();

			} else if (userInput.equals("2")) {

			} else if (userInput.equals("3")) {

			} else if (userInput.equals("4")) {

				userInput = "";
				break;

			} else {

				System.out.println("Invalid input");

			}

			userInput = "";

		} while (!userInput.equals("4"));

	}

	public void commercialQueries() {

		Scanner scanner = new Scanner(System.in);
		String userInput = "";

		do {
			System.out.print("\t1.\tBy Loading Dock");
			System.out.print("\t2.\tBy Highway Access");
			System.out.print("\t3.\tBack");

			userInput = scanner.nextLine();

			if (userInput.equals("1")) {

				generalQueries();

			} else if (userInput.equals("2")) {

			} else if (userInput.equals("3")) {

				userInput = "";
				break;

			} else {

				System.out.println("Invalid input");

			}

			userInput = "";

		} while (!userInput.equals("4"));

	}

	public void retailQueries() {

		Scanner scanner = new Scanner(System.in);
		String userInput = "";

		do {
			System.out.print("\t1.\tBy Square Footage");
			System.out.print("\t2.\tBy Customer Parking");
			System.out.print("\t3.\tBack");

			userInput = scanner.nextLine();

			if (userInput.equals("1")) {

				generalQueries();

			} else if (userInput.equals("2")) {

			} else if (userInput.equals("3")) {

				userInput = "";
				break;

			} else {

				System.out.println("Invalid input");

			}

			userInput = "";

		} while (!userInput.equals("4"));

	}

	public void init() throws FileNotFoundException {

		
		File addressFile = new File(this.getClass().getResource("").getPath()+"/address_data.txt");
		File propertiesFile = new File(this.getClass().getResource("").getPath()+"/property_data.txt");
		ArrayList<Address> addresses = AddressReader.readAddressData(addressFile);
		ArrayList<String> properties = PropertyReader.readPropertyData(propertiesFile);

		agency = new Agency("Hello Agency");

		for (int i = 0; i < properties.size(); i++) {
			String[] propData = properties.get(i).split("|");
			if (propData[1] == "commercial") {

				Commercial com = new Commercial(Double.parseDouble(propData[0]), addresses.get(i), propData[1],
						propData[2], Boolean.parseBoolean(propData[3]), Boolean.parseBoolean(propData[4]));
				agency.addProperty(com);

			} else if (propData[1] == "retail") {

				Retail ret = new Retail(Double.parseDouble(propData[0]), addresses.get(i), "retail", propData[2],
						Integer.parseInt(propData[3]), Boolean.parseBoolean(propData[4]));
				agency.addProperty(ret);

			} else {

				Residence residence = new Residence(Double.parseDouble(propData[0]), addresses.get(i),
						Integer.parseInt(propData[1]), Boolean.parseBoolean(propData[2]), propData[3], propData[4],
						Boolean.parseBoolean(propData[5]));
				agency.addProperty(residence);

			}

		}

	}

}
