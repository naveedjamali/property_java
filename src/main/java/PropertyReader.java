import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PropertyReader {
	
	public static ArrayList<String>readPropertyData(File file) throws FileNotFoundException{
		
		ArrayList<String> properties = new ArrayList<String>();
		
		Scanner myReader = new Scanner(file);
	      while (myReader.hasNextLine()) {
	        String data = myReader.nextLine();
	        properties.add(data);
	        
	      }
	      myReader.close();
		
		return properties;
	}

}
