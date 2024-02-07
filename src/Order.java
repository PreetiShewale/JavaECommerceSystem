import TypeOfUser.Customer;

public class Order {
	private String orderID;

	private Customer User;

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public Customer getUser() {
		return User;
	}

	public void setUser(Customer user) {
		User = user;
	}

}
