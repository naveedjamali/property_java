
public class Commercial extends Property {
	
	private boolean loadingDock;
	private boolean highwayAccess;

	public Commercial(double priceUsd, Address address, String type, String propertyId, boolean loadingDock, boolean highwayDock) {
		super(priceUsd, address, type, propertyId);
		
		this.loadingDock = loadingDock;
		this.highwayAccess =highwayDock;
	}
	
	
	public boolean getLoadingDock() {return this.loadingDock;}
	public boolean getHighwayAccess() {return this.highwayAccess;}
	


    @Override
	public String toString() {
		return "Residence [priceUsd=" + priceUsd + ", address=" + address +  ", type=" + type + ", propertyId=" + propertyId + ", loadignDock=" +loadingDock+ ", highwayAccess="+highwayAccess+ "]";
	}
	
	
}
