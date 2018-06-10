package entities;

public class Holiday {

	private Strategy strategy;
	
	public Holiday(Strategy strategy)
	{
		this.strategy = strategy;
	}
	public void setHotel(String h) {
		strategy.setHotel(h);
	}
}
