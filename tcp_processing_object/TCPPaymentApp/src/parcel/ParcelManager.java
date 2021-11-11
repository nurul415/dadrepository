package parcel;

public class ParcelManager 
{
	public Parcel createParcel (Parcel parcel) 
	{
			
		double weight = parcel.getWeight();
		parcel.setWeight(weight);
		
		//Get parcel pricing
		double pricing = this.getPricing(parcel.getWeight());
		parcel.setPrice(pricing);
		
		return parcel;
		
	}
	
	private double getPricing (double weight) 
	{
		double price = 0;
		
		if(weight >= 0.00 && weight <= 0.50)
		{
			price = 8.00;
		}
		else if (weight >= 0.51 && weight <= 1.00)
		{
			price = 9.00;
		}
		else if (weight >= 1.01 && weight <= 1.50)
		{
			price = 10.05;
		}
		else if (weight >= 1.51 && weight <= 2.00)
		{
			price = 10.60;
		}
		
		return price;
		
	}
}
