import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressReader {

	public static ArrayList<Address> readAddressData(File file) throws FileNotFoundException {

		ArrayList<Address> addresses = new ArrayList<Address>();

		Scanner myReader = new Scanner(file);
		while (myReader.hasNextLine()) {
			String data = myReader.nextLine();
			System.out.print(data);
			
			String[] strings = data.split("\\|");

			String unitNum = strings[0];
			int streetNum = Integer.parseInt(strings[1]);
			String streetName = strings[2];
			String postalCode = strings[3];
			String city = strings[4];

			Address add = new Address(unitNum, streetNum, streetName, postalCode, city);
			addresses.add(add);

		}
		myReader.close();

		return addresses;
	}

}
