package entities;

public class Cruise implements Strategy{
	int id;
	String destination;
	int no_persons;
	int payment;
	String deadline;
	String c;
	private String hotel;
	public Cruise(String destination, int no_persons, int payment, String deadline, String c)
	{
		this.destination = destination;
		this.no_persons = no_persons;
		this.payment = payment;
		this.deadline = deadline;
		this.c = c;
	}
	
	public Cruise() {
		// TODO Auto-generated constructor stub
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

	@Override
	public void setHotel(String H) {
		// TODO Auto-generated method stub
		this.hotel = "-";
	}
	public String getHotel()
	{
		return this.hotel;
	}
	public void setHotel1(String hotel) {
		this.hotel = hotel;
	}
}
