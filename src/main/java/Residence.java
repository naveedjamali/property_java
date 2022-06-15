
public class Residence extends Property {
	

    private int numberOfBedrooms;
    private boolean swimmingPool;
    private boolean strata;
    
    

    public static final int MIN_BEDROOMS = 1;
    public static final int MAX_BEDROOMS = 20;


	public Residence(double priceUsd, Address address, int numberOfBedrooms, boolean swimmingPool, String type, String propertyId, boolean strata) {
		super(priceUsd, address, type, propertyId);

        if(numberOfBedrooms < MIN_BEDROOMS || numberOfBedrooms > MAX_BEDROOMS)
        {
            throw new IllegalArgumentException("Invalid number of bedrooms: " + numberOfBedrooms);
        }
        
        
        this.numberOfBedrooms = numberOfBedrooms;
        this.swimmingPool = swimmingPool; 
        this.strata = strata;
	
	}
	
	
	
    public int getNumberOfBedrooms()
    {
        return numberOfBedrooms;
    }

    public boolean isSwimmingPool()
    {
        return swimmingPool;
    }
    
    public boolean getStrata() {
    	return this.strata;
    }
    
    
    @Override
	public String toString() {
		return "Residence [priceUsd=" + priceUsd + ", address=" + address + ", numberOfBedrooms=" + numberOfBedrooms
				+ ", swimmingPool=" + swimmingPool + ", type=" + type + ", propertyId=" + propertyId + ", strata=" +strata+ "]";
	}

}
