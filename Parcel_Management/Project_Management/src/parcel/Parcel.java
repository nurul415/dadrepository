package parcel;

import java.io.Serializable;

public class Parcel 
{
	private static final long serialVersionUID = 1L;
	
	private double weight;
	private String senderName;
	private String mykad;
	private String senderPhone;
	private Address senderAdd;
	private String receiverName;
	private String receiverPhone;
	private Address receiverAdd;
	
	public Parcel()
	{
		
	}
	
	public double getRandom()
	{
		Double min = 0.0;  // Set To Your Desired Min Value
        Double max = 9.0; // Set To Your Desired Max Value
        double x = (Math.random() * ((max - min) + 1)) + min;   // This Will Create A Random Number Inbetween Your Min And Max.
        double xrounded = Math.round(x * 100.0) / 100.0;   // Creates Answer To The Nearest 100 th, You Can Modify This To Change How It Rounds.
        
        return xrounded;
	}
	
	public void setWeight(double weight)
	{
		this.weight = weight;	
	}
	public double getWeight()
	{
		return weight;
	}
	
	public void setSenderName(String senderName)
	{
		this.senderName = senderName;
	}
	public String getSenderName()
	{
		return senderName;
	}
	
	public void setSenderMykad(String mykad)
	{
		this.mykad = mykad;
	}
	public String getSenderMykad()
	{
		return mykad;
	}
	
	public void setSenderPhone(String senderPhone)
	{
		this.senderPhone = senderPhone;
	}
	public String getSenderPhone()
	{
		return senderPhone;
	}
	
	public void setSenderAdd(Address senderAdd)
	{
		this.senderAdd = senderAdd;
	}
	public Address getSenderAdd()
	{
		return senderAdd;
	}
	
	public void setReceiverName(String receiverName)
	{
		this.receiverName = receiverName;
	}
	public String getReceiverName()
	{
		return receiverName;
	}
	
	public void setReceiverPhone(String receiverPhone)
	{
		this.receiverPhone = receiverPhone;
	}
	public String getReceiverPhone()
	{
		return receiverPhone;
	}
	
	public void setReceiverAdd(Address receiverAdd)
	{
		this.receiverAdd = receiverAdd;
	}
	public Address getReceiverAdd()
	{
		return receiverAdd;
	}
}
