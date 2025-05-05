package workshop.person.entity;

public class PersonEntity {
	private String name;
	private char gender;
	private String address;
	private String phone;
	
	public PersonEntity() {
		
	}

	public PersonEntity(String name, String address, String phone) {
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
}
