package payment;

public class Payment {
	private String creditCard;
	private String ccv;
	private String bank;
	
	public void setCreditCard(String creditCard)
	{
		this.creditCard = creditCard;
	}
	public String getCreditCard()
	{
		return creditCard;
	}
	public void setCcv(String ccv)
	{
		this.ccv = ccv;
	}
	public String getCcv()
	{
		return ccv;
	}
	public void setBank(String bank)
	{
		this.bank = bank;
	}
	public String getBank()
	{
		return bank;
	}
	
	
}
