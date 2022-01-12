package demo.hogwarts;

import java.util.List;

/**
 * This class demonstrated the implementation of Facade design pattern
 * @author emalianakasmuri
 *
 */
public class HouseFacade {
	
	public HouseDataManager dataMgr;
	
	/**
	 * Constructor
	 */
	public HouseFacade () {
		
		dataMgr = new HouseDataManager();
	}
	
	/**
	 * This method gets a Hogwarts house
	 * @param house
	 * @return a Hogwarts house
	 */
	public House getHouse (House house) {
		
		return dataMgr.getHouse(house);
	}
	
	/**
	 * This method get a list of Hogwarts houses
	 * @return
	 */
	public List<House> getHouses() {
		
		return dataMgr.getHouses();
	}

}
