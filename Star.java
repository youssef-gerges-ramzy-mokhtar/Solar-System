import java.util.*;

public class Star extends SolarBody {

	/**
	* Sun represents a Star in the Solar System.
	*
	* @param SolarBodyInfo is an object containg all the information about that Sun.
	*/
	public Star(SolarBodyInfo solarBodyInfo) {
		super(solarBodyInfo);
	}

	/**
	* A method used to move the Sun in the Solar System
	* @param velocity is the velocity that you want the Sun to have 
	*/
	public void moveSolarBody(double velocity) {
		if (velocity > 360) velocity = 360;

		double current_angel = solarBodyInfo.getAngel();
		solarBodyInfo.setAngel(velocity + current_angel);

		displaySolarBody();
	}

	/**
	* A method used to move the Sun in the Solar System
	*/
	public void moveSolarBody() {
		double velocity = solarBodyInfo.getSpeed();
		moveSolarBody(velocity);
	}
	
}