package models;

import java.util.Random;

import net.bytebuddy.utility.RandomString;

public class Account {

	private String password;
	private String address;
	private String city;
	private int fax;
	private String firstName;
	private String lastName;
	private int telephone;
	private int postCode;
	private String email;
	private int country;
	private int zone;

	public Account() {
		super();
		this.password = RandomString.make();
		this.address = RandomString.make();
		this.city = RandomString.make();
		this.fax = new Random().nextInt(100) + 1000;
		this.firstName = RandomString.make();
		this.lastName = RandomString.make();
		this.telephone = new Random().nextInt(100) + 1000;
		this.postCode = new Random().nextInt(100) + 1000;
		this.email = RandomString.make() + "@gmail.com";
		this.country = new Random().nextInt(10);
		this.zone = new Random().nextInt(10);

	}

	public String getPassword() {
		return password;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public int getFax() {
		return fax;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getTelephone() {
		return telephone;
	}

	public int getPostCode() {
		return postCode;
	}

	public String getEmail() {
		return email;
	}

	public int getCountry() {
		return country;
	}

	public int getZone() {
		return zone;
	}

}
