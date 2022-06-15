public class Property
{
     double priceUsd;
     Address address;
     String type; /* residence, commercial, or retail */
     String propertyId;

    public static final int MIN_PROPERTY_ID_LEN = 1;
    public static final int MAX_PROPERTY_ID_LEN = 6;

    public Property(double priceUsd, Address address, String type, String propertyId)
    {
        if(priceUsd < 0.0)
        {
            throw new IllegalArgumentException(String.format("Invalid price: " + priceUsd, "%.2f"));
        }
        if(address == null)
        {
            throw new NullPointerException("Invalid address: null");
        }


        if(type == null)
        {
            throw new NullPointerException("Invalid property type: null");
        }
        else
        {
            if(!type.equalsIgnoreCase("residence") &&
                    !type.equalsIgnoreCase("commercial") &&
                    !type.equalsIgnoreCase("retail"))
            {
                throw new IllegalArgumentException("Invalid property type: " + type);
            }
        }

        if(propertyId == null)
        {
            throw new NullPointerException("Invalid property id: null");
        }

        if(propertyId.length() < MIN_PROPERTY_ID_LEN || propertyId.length() > MAX_PROPERTY_ID_LEN)
        {
            throw new IllegalArgumentException("Invalid property id: " + propertyId);
        }

        this.priceUsd = priceUsd;
        this.address = address;
      
        this.type = type;
        this.propertyId = propertyId;
    }


    public double getPriceUsd()
    {
        return priceUsd;
    }

    public Address getAddress()
    {
        return address;
    }


    public String getType()
    {
        return type;
    }

    public String getPropertyId()
    {
        return propertyId;
    }

    public void setPriceUsd(double priceUsd)
    {
        if(priceUsd < 0.0)
        {
            throw new IllegalArgumentException(String.format("Invalid price: " + priceUsd, "%.2f"));
        }
        this.priceUsd = priceUsd;
    }


	@Override
	public String toString() {
		return "Property [priceUsd=" + priceUsd + ", address=" + address + ", type=" + type + ", propertyId=" + propertyId + "]";
	}
    
    
}

