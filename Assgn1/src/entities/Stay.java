package entities;

public class Stay implements Strategy{

	int id;
	String destination;
	int no_persons;
	int payment;
	String deadline;
	String c;
	private String hotel;
	public Stay(String destination, int no_persons, int payment, String deadline, String c)
	{
		this.destination = destination;
		this.no_persons = no_persons;
		this.payment = payment;
		this.deadline = deadline;
		this.c = c;
	}
	public Stay() {
		// TODO Auto-generated constructor stub
	}
	
	public String getHotel() {
		return hotel;
	}
	public void setHotel(String hotel) {
		this.hotel = hotel;
	}
	
	public void setHotel1(String hotel) {
		this.hotel = hotel;
	}
	public String getClient()
	{
		return c;
	}
	
	public void setClient(String c)
	{
		this.c = c;
	}
	public int getID() {
		return id;
	}
	
	public void setID(int ID) {
		this.id=ID;
	}
	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}


	public int getNo_persons() {
		return no_persons;
	}

	public void setNo_persons(int no_persons) {
		this.no_persons = no_persons;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
}
