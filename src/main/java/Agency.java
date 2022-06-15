import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Agency
{
    private String name;
    private HashMap<String, Property> properties;

    public static final int MIN_NAME_LEN = 1;
    public static final int MAX_NAME_LEN = 30;


    public Agency(String name)
    {
        if(name == null)
        {
            throw new NullPointerException("Invalid name: null");
        }

        if(name.length() < MIN_NAME_LEN || name.length() > MAX_NAME_LEN)
        {
            throw new IllegalArgumentException("Invalid name: " + name);
        }
        this.name = name;

        properties = new HashMap<>();
    }

    public void addProperty(Property property)
    {
        if(property == null)
        {
            throw new NullPointerException("Invalid property: null");
        }

        properties.put(property.getPropertyId(), property);
    }

    public Property getProperty(String propertyId)
    {
        if(properties.containsKey(propertyId))
        {
            return(properties.get(propertyId));
        }
        else
        {
            return null;
        }
    }

    public void removeProperty(String propertyId)
    {
        if(properties.containsKey(propertyId))
        {
            properties.remove(propertyId);
        }
    }

    public double getTotalPropertyValues()
    {
        double totalUsd = 0.0;
        Set<String> propertyIds = properties.keySet();

        for(String propertyId: propertyIds)
        {
            totalUsd +=  properties.get(propertyId).getPriceUsd();
        }

        return totalUsd;
    }

    public ArrayList<Residence> getPropertiesWithPools()
    {
        ArrayList<Residence> matches = new ArrayList<>();

        Set<String> propertyIds = properties.keySet();

        for(String propertyId: propertyIds)
        {
        	Residence property =  (Residence) properties.get(propertyId);

            if(property.isSwimmingPool())
            {
                matches.add(property);
            }
        }

        if(matches.size() == 0)
        {
            return null;
        }

        return matches;
    }


    public Property[] getPropertiesBetween(double minUsd, double maxUsd)
    {
        int numberOfMatches = 0;
        int i = 0;

        Set<String> propertyIds = properties.keySet();

        for(String propertyId: propertyIds)
        {
            Property property =  properties.get(propertyId);

            if(property.getPriceUsd() >= minUsd && property.getPriceUsd() <= maxUsd)
            {
                numberOfMatches++;
            }
        }

        if(numberOfMatches == 0)
        {
            return null;
        }

        Property[] matches = new Property[numberOfMatches];

        for(String propertyId: propertyIds)
        {
            Property property =  properties.get(propertyId);

            if(property.getPriceUsd() >= minUsd && property.getPriceUsd() <= maxUsd)
            {
                matches[i] = property;
                i++;

            }
        }
        return matches;
    }

    public ArrayList<Address> getPropertiesOn(String streetName)
    {
        ArrayList<Address> matches = new ArrayList<>();

        Set<String> propertyIds = properties.keySet();

        for(String propertyId: propertyIds)
        {
            Property property =  properties.get(propertyId);

            if(property.getAddress().getStreetName().equalsIgnoreCase(streetName))
            {
                matches.add(property.getAddress());
            }
        }

        if(matches.size() == 0)
        {
            return new ArrayList<Address>();
        }

        return matches;
    }

    public HashMap<String, Residence> getPropertiesWithBedrooms(int minBedrooms, int maxBedrooms)
    {
        HashMap<String, Residence> matches = new HashMap<>();

        Set<String> propertyIds = properties.keySet();

        for(String propertyId: propertyIds)
        {
            Residence property =  (Residence) properties.get(propertyId);

            if(property.getNumberOfBedrooms() >= minBedrooms && property.getNumberOfBedrooms() <= maxBedrooms)
            {
                matches.put(property.getPropertyId(), property);
            }
        }

        if(matches.size() == 0)
        {
            return null;
        }

        return matches.size()>0?matches:null;
    }


    public ArrayList<Property> getPropertiesOfType(final String propertyType) {
		ArrayList<Property> results = new ArrayList<>();

		for (String key : properties.keySet()) {

			Property prop = properties.get(key);

			if (prop.getType().equalsIgnoreCase(propertyType)) {

				results.add(prop);
			}

		}

		return results;
	}


    private String toTitleCase(String input) {
        StringBuilder titleCase = new StringBuilder(input.length());
        boolean nextTitleCase = true;

        for (char c : input.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                nextTitleCase = true;
            } else if (nextTitleCase) {
                c = Character.toTitleCase(c);
                nextTitleCase = false;
            }

            titleCase.append(c);
        }

        return titleCase.toString();
    }
    
    public int getNumberOfProperties() {
    	
    	return properties.size();
    }

    ArrayList<Commercial> gerPropertyWithLoadingDock(){
    	ArrayList<Commercial> results = new ArrayList<>();

		for (String key : properties.keySet()) {

			Property prop = properties.get(key);

			if (prop.getType().equalsIgnoreCase("commercial")) {

				results.add((Commercial) prop);
			}

		}

		return results;
    }
    
    
    ArrayList<Commercial> getPropertyWithLoadingDock(){
    	ArrayList<Commercial> results = new ArrayList<>();

		for (String key : properties.keySet()) {

			Property prop = properties.get(key);

			if (prop.getType().equalsIgnoreCase("commercial")) {

				Commercial com = (Commercial) prop;
				if(com.getLoadingDock()) {
					results.add(com);
				}
			
			}

		}

		return results;
    }
    
    ArrayList<Commercial> getPropertyWithHighwayAccess(){
    	ArrayList<Commercial> results = new ArrayList<>();

		for (String key : properties.keySet()) {

			Property prop = properties.get(key);

			if (prop.getType().equalsIgnoreCase("commercial")) {

				Commercial com = (Commercial) prop;
				if(com.getHighwayAccess()) {
					results.add(com);
				}
			
			}

		}

		return results;
    }
    
    ArrayList<Retail> getPropertyWithSquareFootage(int squareFootage){
    	ArrayList<Retail> results = new ArrayList<>();

		for (String key : properties.keySet()) {

			Property prop = properties.get(key);

			if (prop.getType().equalsIgnoreCase("retail")) {

				Retail retail = (Retail) prop;
				if(retail.getSquareFootage()==squareFootage) {
					results.add(retail);
				}
			
			}

		}

		return results;
    }
    
      
    ArrayList<Retail> getPropertyWithCustomerParking(){
    	ArrayList<Retail> results = new ArrayList<>();

		for (String key : properties.keySet()) {

			Property prop = properties.get(key);

			if (prop.getType().equalsIgnoreCase("retail")) {

				Retail retail = (Retail) prop;
				if(retail.getCustomerParking()) {
					results.add(retail);
				}
			
			}

		}

		return results;
    }
    
    
    ArrayList<Residence> getPropertyWithStrata(int squareFootage){
    	ArrayList<Residence> results = new ArrayList<>();

		for (String key : properties.keySet()) {

			Property prop = properties.get(key);

			if (prop.getType().equalsIgnoreCase("residence")) {

				Residence res = (Residence) prop;
				if(res.getStrata()) {
					results.add(res);
				}
			
			}

		}

		return results;
    }
    
    
    
    
    
        
    
    
}
