import java.util.*;

public class Planet extends SolarBody {
	// Data Members //

	/**
	* Planet represents a planet in the Solar System.
	*
	* @param SolarBodyInfo is an object containg all the information about that planet.
	*/
	public Planet(SolarBodyInfo solarBodyInfo) {
		super(solarBodyInfo);
	}

	/**
	* A method used to move the Planet in the Solar System
	* @param velocity is the velocity that you want the planet to have 
	*/
	public void moveSolarBody(double velocity) {
		if (velocity > 360) velocity = 360;

		double current_angel = solarBodyInfo.getAngel();
		solarBodyInfo.setAngel(velocity + current_angel);

		displaySolarBody();
	}

	/**
	* A method used to move the Planet in the Solar System
	*/
	public void moveSolarBody() {
		double velocity = solarBodyInfo.getSpeed();
		moveSolarBody(velocity);
	}
}