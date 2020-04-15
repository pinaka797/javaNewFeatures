import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalExamples {

	public static void main(String args[]) {
		Address ajitaddress = new Address("52/A, Bajaj Maruti", "Hyderabad", "India", 500001);
		Employee john = new Employee("Ajit", Optional.of(ajitaddress), 990238076);
		Employee pinaka = new Employee("Pinaka", Optional.empty(), 999111232);
		Employee subham = new Employee("Subham", Optional.empty(), 533299911);

		List<Employee> people = new ArrayList<>();
		people.add(john);
		people.add(pinaka);
		people.add(subham);

		people.stream().forEach((p) -> {
			System.out.printf("%s from %s %n", p.name(), p.address().orElse(Address.EMPTY_ADDRESS));
		});

	}

}

class Employee {
	private String name;
	private Optional<Address> address;
	private int phone;

	public Employee(String name, Optional<Address> address, int phone) {
		if (name == null) {
			throw new IllegalArgumentException("Null value for name is not permitted");
		}

		this.name = name;
		this.address = address;
		this.phone = phone;

	}

	public String name() {
		return name;
	}

	public Optional<Address> address() {
		return address;
	}

	public int phone() {
		return phone;
	}

	@Override
	public String toString() {
		return "Person{" + "name=" + name + ", address=" + address + ", phone=" + phone + '}';
	}
}

class Address {

	public static final Address EMPTY_ADDRESS = new Address("", "", "", 0);
	private final String street;
	private final String city;
	private final String country;
	private final int zipcode;

	public Address(String line1, String city, String country, int zipcode) {
		this.street = line1;
		this.city = city;
		this.country = country;
		this.zipcode = zipcode;
	}

	public String line1() {
		return street;
	}

	public String city() {
		return city;
	}

	public String country() {
		return country;
	}

	public int zipcode() {
		return zipcode;
	}

	@Override
	public String toString() {
		return "Address{" + "line1=" + street + ", city=" + city + ", country=" + country + ", zipcode=" + zipcode + '}';
	}

}
