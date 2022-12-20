public class Commet extends SolarBody {
	// Data Members //
	private double distance_change_rate;

	/**
	* Commet represents a commet in the Solar System.
	* It provides a motion that is not perfectly circular
	* 
	* @param solarBodyInfo is an object containg all the information about that Commet.
	* @param distanceChangeRate is the rate of change in distance for the elliptical motion
	*/
	public Commet(SolarBodyInfo solarBodyInfo, double distance_change_rate) {
		super(solarBodyInfo);
		this.distance_change_rate = distance_change_rate;
	}

	/**
	* A method used to move the Commet in the Solar System
	* @param velocity is the velocity that you want the Commet to have 
	*/
	public void moveSolarBody(double velocity) {
		if (velocity > 360) velocity = 360;

		double current_angel = solarBodyInfo.getAngel();
		solarBodyInfo.setAngel(velocity + current_angel);

		double current_distance = solarBodyInfo.getDistance();
		if (current_angel >= 0 && current_angel < 90) current_distance += distance_change_rate;
		if (current_angel >= 90 && current_angel < 180) current_distance -= distance_change_rate;
		if (current_angel >= 180 && current_angel < 270) current_distance += distance_change_rate;
		if (current_angel >= 270 && current_angel < 360) current_distance -= distance_change_rate;
		solarBodyInfo.setDistance(current_distance);

		displaySolarBody();
	}

	/**
	* A method used to move the Commet in the Solar System
	*/
	public void moveSolarBody() {
		double velocity = solarBodyInfo.getSpeed();
		moveSolarBody(velocity);
	}
}