package demo.hogwarts;

/**
 * This class represent a house in Hogwarts
 * 
 * @author emalianakasmuri
 *
 */
public class House {
	
	private int houseId;
	private String name;
	private String founder;
	private String color;
	private String mascot;
	
	public int getHouseId() {
		return houseId;
	}
	public void setHouseId(int houseId) {
		this.houseId = houseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFounder() {
		return founder;
	}
	public void setFounder(String founder) {
		this.founder = founder;
	}
	public String getColor()
	{
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getMascot()
	{
		return mascot;
	}
	public void setMascot(String mascot) {
		this.mascot = mascot;
	}
	
}
