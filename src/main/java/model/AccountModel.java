package model;

public class AccountModel {
	private int accId;
	private String accName;
	private String role;
	private int phone;
	private String emal;
	private String passWord;
	private String address;
	private int cartId;
	
	//constructor method
	public AccountModel(int accId, String accName, String role, int phone, String emal, String passWord, String address,
			int cartId) {
		super();
		this.accId = accId;
		this.accName = accName;
		this.role = role;
		this.phone = phone;
		this.emal = emal;
		this.passWord = passWord;
		this.address = address;
		this.cartId = cartId;
	}
	public AccountModel() {
		super();
	}
	
	//getter and setter method
	public int getAccId() {
		return accId;
	}
	public void setAccId(int accId) {
		this.accId = accId;
	}
	public String getAccName() {
		return accName;
	}
	public void setAccName(String accName) {
		this.accName = accName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getEmal() {
		return emal;
	}
	public void setEmal(String emal) {
		this.emal = emal;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	
	

}
