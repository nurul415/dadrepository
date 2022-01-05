package payment;

import java.sql.Timestamp;

public class PaymentManager 
{
	public Payment createPayment(Payment payment)
	{
		
		
		int paymentID = payment.getPaymentId();
		payment.setPaymentId(paymentID);
		
		
		Timestamp transDate = payment.getTransactionDate();
		payment.setTransactionDate(transDate);
		
		Staff staff = payment.getRecordedBy();
		payment.setRecordedBy(staff);
		
		return payment;
		
	}
	
	public Staff createStaff(Staff staff)
	{
		String userID = staff.getUserId();
		staff.setUserId(userID);
		
		String userName = staff.getName();
		staff.setName(userName);
		
		return staff;
	}

}
