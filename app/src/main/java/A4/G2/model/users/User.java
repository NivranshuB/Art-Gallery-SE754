package A4.G2.model.users;

import java.util.UUID;

import A4.G2.model.Payment;

public class User {
    private String id;
    private String userName;
    private String password;
    private String email;
    private String phone;
    private String address;
    private Payment payment;


public User(String userName, String password, String email, String phone, String address) {
    this.userName = userName;
    this.password = password;
    this.email = email;
    this.phone = phone;
    this.address = address;
    this.id = this.id = UUID.randomUUID().toString();
}

	public void modifyPayment(Payment payment) {
	    this.payment = payment;
	}

}
