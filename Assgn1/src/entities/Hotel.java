package entities;

public class Hotel {

	private int id;
	private String name;
	private String destination;
	
	public Hotel(String name, String destination) {
		this.name = name;
		this.destination = destination;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", destination=" + destination + "]";
	}
	
	
}
