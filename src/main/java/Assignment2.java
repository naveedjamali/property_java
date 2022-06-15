import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
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
            System.out.println("Welcome to our Property Search");
            System.out.println("Choose one of the following options:");
            System.out.println("\t1.\tGeneral Queries");
            System.out.println("\t2.\tResidence Queries");
            System.out.println("\t3.\tCommercial Queries");
            System.out.println("\t4.\tRetail Queries");
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
            System.out.println("\t1.\tBy Property");
            System.out.println("\t2.\tBy Price");
            System.out.println("\t3.\tBy Street");
            System.out.println("\t4.\tBy Type");
            System.out.println("\t5.\tBack");
            System.out.println();

            userInput = scanner.nextLine();

            if (userInput.equals("1")) {
                doSearchByPropertyId();

            } else if (userInput.equals("2")) {

                doSearchByPrice();

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

    private void doSearchByType()
    {
        System.out.println("Enter Property Type:");


        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        try {
            ArrayList<Property>  addresses = agency.getPropertiesOfType(input);

            for (Property prop : addresses) {
                System.out.println(prop);
            }

        } catch (Exception e) {

            System.out.println("You entered invalid type" );
        }
    }

    private void doSearchByStreet() {

        System.out.println("Enter Street name: ");

        Scanner scanner = new Scanner(System.in);
        String streetName = scanner.nextLine();
        try {
           ArrayList<Address>  addresses = agency.getPropertiesOn(streetName);

            for (Address add : addresses) {
                System.out.println(add);
            }

        } catch (Exception e) {

            System.out.println("No Property found with PropertyID: " );
        }
    }

    private void doSearchByPrice() {

        Scanner scanner = new Scanner(System.in);


        try {
            System.out.print("Enter Min Price");

            double minPrice = Double.parseDouble(scanner.nextLine());

            System.out.print("Enter Max Price");

            double maxPrice = Double.parseDouble(scanner.nextLine());


            Property[] properties = agency.getPropertiesBetween(maxPrice, maxPrice);
            for (Property property : properties) {
                System.out.println(property);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

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
            System.out.println("\t1.\tBy Bedroom");
            System.out.println("\t2.\tBy Pool");
            System.out.println("\t3.\tBy Strata");
            System.out.println("\t4.\tBack");

            userInput = scanner.nextLine();

            if (userInput.equals("1")) {
                searchByBedroom();
            } else if (userInput.equals("2")) {
                searchByPools();
            } else if (userInput.equals("3")) {
                searchByStrata();
            } else if (userInput.equals("4")) {
                userInput = "";
                break;
            } else {
                System.out.println("Invalid input");

            }

            userInput = "";

        } while (!userInput.equals("4"));

    }

    private void searchByStrata() {
        for (Residence propertyWithStratum : agency.getPropertyWithStrata()) {
            System.out.println(propertyWithStratum);
        }
    }

    private void searchByPools() {

            for (Residence propertiesWithPool : agency.getPropertiesWithPools()) {
                System.out.println(propertiesWithPool);
            }

    }

    private void searchByBedroom() {
        Scanner scanner = new Scanner(System.in);


        try {
            System.out.print("Enter Min Bedrooms");

            int minBeds = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Max Bedrooms");

            int maxBeds = Integer.parseInt(scanner.nextLine());


            HashMap<String, Residence> properties = agency.getPropertiesWithBedrooms(minBeds, maxBeds);
           properties.values().forEach(residence -> {
               System.out.println(residence);
           });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void commercialQueries() {

        Scanner scanner = new Scanner(System.in);
        String userInput = "";

        do {
            System.out.println("\t1.\tBy Loading Dock");
            System.out.println("\t2.\tBy Highway Access");
            System.out.println("\t3.\tBack");

            userInput = scanner.nextLine();

            if (userInput.equals("1")) {
                searchByLoadingDock();

            } else if (userInput.equals("2")) {
                searchByHighwayAccess();
            } else if (userInput.equals("3")) {

                userInput = "";
                break;

            } else {

                System.out.println("Invalid input");

            }

            userInput = "";

        } while (!userInput.equals("4"));

    }

    private void searchByHighwayAccess() {
        for (Commercial propertyWithHighwayAccess : agency.getPropertyWithHighwayAccess()) {
            System.out.println(propertyWithHighwayAccess);
        }
    }

    private void searchByLoadingDock() {
        for (Commercial commercial : agency.gerPropertyWithLoadingDock()) {
            System.out.println(commercial);
        }
    }

    public void retailQueries() {

        Scanner scanner = new Scanner(System.in);
        String userInput = "";

        do {
            System.out.println("\t1.\tBy Square Footage");
            System.out.println("\t2.\tBy Customer Parking");
            System.out.println("\t3.\tBack");

            userInput = scanner.nextLine();

            if (userInput.equals("1")) {

                searchBySquareFootage();

            } else if (userInput.equals("2")) {
                searchByCustomerParking();

            } else if (userInput.equals("3")) {

                userInput = "";
                break;

            } else {

                System.out.println("Invalid input");

            }

            userInput = "";

        } while (!userInput.equals("4"));

    }

    private void searchByCustomerParking() {
        for (Retail retail : agency.getPropertyWithCustomerParking()) {
            System.out.println(retail);
        }
    }

    private void searchBySquareFootage() {

        Scanner scanner = new Scanner(System.in);
        try{
            int input = Integer.parseInt(scanner.nextLine());
            agency.getPropertyWithSquareFootage(input);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void init() throws FileNotFoundException {


        File addressFile = new File("/home/naveed/Desktop/CourseHero-20220615T044311Z-001/CourseHero/property_java/src/main/java/address_data.txt");
        File propertiesFile = new File("/home/naveed/Desktop/CourseHero-20220615T044311Z-001/CourseHero/property_java/src/main/java/property_data.txt");
        ArrayList<Address> addresses = AddressReader.readAddressData(addressFile);
        ArrayList<String> properties = PropertyReader.readPropertyData(propertiesFile);

        agency = new Agency("Hello Agency");

        for (int i = 0; i < properties.size(); i++) {
            String[] propData = properties.get(i).split("\\|");

            if (propData[1].trim().equals("commercial")) {

                Commercial com = new Commercial(Double.parseDouble(propData[0]), addresses.get(i), propData[1],
                        propData[2], Boolean.parseBoolean(propData[3]), Boolean.parseBoolean(propData[4]));
                agency.addProperty(com);

            } else if (propData[1].trim().equals("retail")) {

                Retail ret = new Retail(Double.parseDouble(propData[0]), addresses.get(i), "retail", propData[2],
                        Integer.parseInt(propData[3]), Boolean.parseBoolean(propData[4]));
                agency.addProperty(ret);

            } else if (propData[3].trim().equals("residence")) {

                Residence residence = new Residence(Double.parseDouble(propData[0]), addresses.get(i),
                        Integer.parseInt(propData[1]), Boolean.parseBoolean(propData[2]), "residence", propData[4],
                        Boolean.parseBoolean(propData[5]));
                agency.addProperty(residence);

            } else {
                System.out.println("Invalid property type.");
            }

        }

    }

}
