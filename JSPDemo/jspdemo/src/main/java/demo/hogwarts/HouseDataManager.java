package demo.hogwarts;

import java.util.ArrayList;
import java.util.List;

/**
 * This class manages data of Hogwarts house
 * 
 * @author emalianakasmuri
 *
 */
public class HouseDataManager {
	
	private List<House> houses;
	
	/**
	 * Constructor
	 */
	public HouseDataManager() {
		
		houses = this.loadHouses();
	}
	
	/**
	 * This method gets a Hogwarts house
	 * @param house
	 * @return a Hogwarts house
	 */
	protected House getHouse (House house) {
		
		// Iterate the list find the house
		for (House currentHouse:houses) {
			
			if (house.getHouseId() == currentHouse.getHouseId()) {
				// If ids matched, return currentHouse
				
				return currentHouse;
			}
				
		}
		
		// Set id to 0 because no matched id
		house.setHouseId(0);
		
		return house;
		
	}
	
	/**
	 * This method get a list of Hogwarts houses
	 * @return
	 */
	protected List<House> getHouses() {
		
		return houses;
	}
	
	/**
	 * This method loads data into list
	 * @return
	 */
	private List<House> loadHouses() {
		
		// Declaration of sample data
		String houseNames[] = {"Gryffidor", "Slyterin", "Hufflepuff", "Ravenclaw"};
		String firstNames[] = {"Godric", "Salazar", "Helga", "Rowena"};
		String colors[] = {"scarlet-gold", "green-silver", "yellow-black", "blue-bronze"};
		String mascots[] = {"lion", "serpent", "badger", "eagle"};
		
		// Load data into list
		houses = new ArrayList<House>();
		for (int index=0; index < houseNames.length; index++) {
			
			// Wrap data into object
			House house = new House();
			house.setHouseId(index+1);
			house.setName(houseNames[index]);
			house.setFounder(firstNames[index] + " " + houseNames[index]);
			house.setColor(colors[index]);
			house.setMascot(mascots[index]);
			
			// Add into list
			houses.add(house);
		}
		
		return houses;
		
	}
	
	

}
