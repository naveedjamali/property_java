
public class Retail extends Property {
	
	private int squareFootage;
	private boolean customerParking;
	

	public Retail(double priceUsd, Address address, String type, String propertyId,int squareFootage, boolean customerParking) {
		super(priceUsd, address, type, propertyId);
		// TODO Auto-generated constructor stub
		
		if(squareFootage<0) {
			 throw new IllegalArgumentException("Invalid squareFootage: " + squareFootage); 
		}
		
		this.customerParking = customerParking;
		this.squareFootage = squareFootage;
	}
	
	
	
	public boolean getCustomerParking() {
		return this.customerParking;
	}

	public int getSquareFootage() {
		return this.squareFootage;
	}

    @Override
	public String toString() {
		return "Residence [priceUsd=" + priceUsd + ", address=" + address +  ", type=" + type + ", propertyId=" + propertyId + ", squareFootage=" +squareFootage+ ", customerParking="+customerParking+ "]";
	}
	

}
