package payment;

import java.io.Serializable;
import java.sql.Timestamp;

public class Payment implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private int paymentId;
	private Timestamp transactionDate;
	private Staff recordedBy;
	
	public Payment()
	{
		
	}
	
	public void setPaymentId(int paymentId)
	{
		this.paymentId = paymentId;
	}
	public int getPaymentId()
	{
		return paymentId;
	}
	
	public void setTransactionDate(Timestamp transactionDate)
	{
		this.transactionDate = transactionDate;
	}
	public Timestamp getTransactionDate()
	{
		return transactionDate;
	}
	
	public void setRecordedBy(Staff recordedBy)
	{
		this.recordedBy = recordedBy;
	}
	public Staff getRecordedBy()
	{
		return recordedBy;
	}
}
