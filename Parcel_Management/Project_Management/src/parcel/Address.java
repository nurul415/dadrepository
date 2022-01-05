package parcel;

public class Address 
{
	private String add;
	private String city;
	private String postcode;
	private String state;
	
	public Address(String add, String city, String postcode, String state)
	{
		this.add = add;
		this.city = city;
		this.postcode = postcode;
		this.state = state;
	}
	
	public String getAdd()
	{
		return add;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public String getPostcode()
	{
		return postcode;
	}
	
	public String getState()
	{
		return state;
	}
}
