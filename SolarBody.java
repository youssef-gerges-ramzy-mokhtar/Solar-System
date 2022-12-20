import java.util.*;

public abstract class SolarBody {
	// Data Members //
	protected SolarBodyInfo solarBodyInfo;

	/**
	* SolarBody is an abstract class representing any solar body that can exist in the Solar System.
	*
	* @param SolarBodyInfo is an object containg all the information about that Solar Body.
	*/
	public SolarBody(SolarBodyInfo solarBodyInfo) {
		this.solarBodyInfo = solarBodyInfo;
	}

	/**
	* A method used to display the Solar Body in the Solar System
	*/
	protected void displaySolarBody() {
		double distance = solarBodyInfo.getDistance();
		double angel = solarBodyInfo.getAngel();
		double diameter = solarBodyInfo.getDiameter();
		String color = solarBodyInfo.getColor();

		solarBodyInfo.getSolarSystem().drawSolarObject(distance, angel, diameter, color);
	}

	/**
	* A method used to move the solar body in the Solar System
	* @param velocity is the velocity that you want the solar body to have 
	*/
	abstract public void moveSolarBody(double velocity);

	/**
	* A method used to move the solar body in the Solar System
	*/
	abstract public void moveSolarBody();

	/**
	* Returns a SolarBodyInfo object which contains information about this solar body 
	*/
	public SolarBodyInfo getSolarBodyInfo() {
		return solarBodyInfo;
	}

	/**
	* A method used to change the current size of the Solar Body based on the rate
	* @param rate is the rate at which you want to change the size
	*/
	public void changeSize(double rate) {
		double distance = solarBodyInfo.getDistance();
		double diameter = solarBodyInfo.getDiameter();
		solarBodyInfo.setDistance(distance * rate);
		solarBodyInfo.setDiameter(diameter * rate);
	}

	/**
	* A method used to change the current speed of the Solar Body based on the rate
	* @param rate is the rate at which you want to change the speed 
	*/
	public void changeSpeed(double rate) {
		double speed = solarBodyInfo.getSpeed();
		solarBodyInfo.setSpeed(speed * rate);
	}
}