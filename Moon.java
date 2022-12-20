public class Moon extends SolarBody {
	// Data Members //
	private double centerOfRotationDistance;
	private double centerOfRotationAngle;
	private double speed_about;

	/**
	* Moon represents a moon in the Solar System.
	*
	* @param SolarBodyInfo is an object containg all the information about the moon.
	* @param centerOfRotationDistance the distance part of the polar co-ordinate about which this object orbits.
	* @param centreOfRotationAngle the angular part of the polar co-ordinate about which this object orbits.
	* @param speedAbout the speed about which this object orbits.
	*/
	public Moon(SolarBodyInfo solarBodyInfo, double centerOfRotationDistance, double centerOfRotationAngle, double speed_about) {
		super(solarBodyInfo);
		this.centerOfRotationDistance = centerOfRotationDistance;
		this.centerOfRotationAngle = centerOfRotationAngle;
		this.speed_about = speed_about;
	}

	/**
	* Moon represents a moon in the Solar System.
	*
	* @param SolarBodyInfo is an object containg all the information about the moon.
	* @param centerOfRotationDistance the distance part of the polar co-ordinate about which this object orbits.
	* @param speedAbout the speed about which this object orbits.
	*/
	public Moon(SolarBodyInfo solarBodyInfo, double centerOfRotationDistance, double speed_about) {
		this(solarBodyInfo, centerOfRotationDistance, 0, speed_about);
	}

	/**
	* Moon represents a moon in the Solar System.
	*
	* @param SolarBodyInfo is an object containg all the information about the moon.
	*/
	public Moon(SolarBodyInfo solarBodyInfo) {
		this(solarBodyInfo, 0, 0, 0);
	}


	private void displaySolarBodyAbout() {
		double distance = solarBodyInfo.getDistance();
		double angel = solarBodyInfo.getAngel();
		double diameter = solarBodyInfo.getDiameter();
		String color = solarBodyInfo.getColor();

		solarBodyInfo.getSolarSystem().drawSolarObjectAbout(distance, angel, diameter, color, centerOfRotationDistance, centerOfRotationAngle);
	}

	/**
	* A method used to move the moon in the Solar System
	* @param velocity is the velocity that you want the moon to have when orbiting another Solar Body 
	*/
	public void moveSolarBody(double velocity) {
		// Planet Motion //
		double planet_velocity = solarBodyInfo.getSpeed();
		if (planet_velocity > 360) planet_velocity = 360;

		double current_angel = solarBodyInfo.getAngel();
		solarBodyInfo.setAngel(planet_velocity + current_angel);

		// Moon Motion //
		if (velocity > 360) velocity = 360;

		centerOfRotationAngle += velocity;
		centerOfRotationAngle %= 360;

		displaySolarBodyAbout();
	}

	/**
	* A method used to move the moon in the Solar System
	*/
	public void moveSolarBody() {
		moveSolarBody(speed_about);
	}

	/**
	* A method used to change the current size of the Moon based on the rate
	* @param rate is the rate at which you want to change the size of the Moon
	*/
	public void changeSize(double rate) {
		super.changeSize(rate);
		centerOfRotationDistance *= rate;
	}

	/**
	* A method used to change the current speed of the Moon based on the rate
	* @param rate is the rate at which you want to change the speed of the Moon
	*/
	public void changeSpeed(double rate) {
		super.changeSpeed(rate);
		speed_about *= rate;
	}


	// Setters //
	/**
	* sets the center of roation distance
	* @param centerOfRoationDistance
	*/
	public void setCenterOfRotationDistance(double centerOfRotationDistance) {
		this.centerOfRotationDistance = centerOfRotationDistance;
	}

	/**
	* sets the center of rotation angle
	* @param centerOfRotationAngle
	*/
	public void setCenterOfRotationAngel(double centerOfRotationAngle) {
		this.centerOfRotationAngle = centerOfRotationAngle;
	}

	/**
	* sets the speed about
	* @param speedAbout
	*/
	public void setSpeedAbout(double speed) {
		this.speed_about = speed;
	}

	// Getters //
	/**
 	* Returns the center of rotation distance 
	*/ 
	public double getCenterOfRotationDistance() {
		return centerOfRotationDistance;
	}

	/**
 	* Returns the center of rotation angle 
	*/ 
	public double getCenterOfRotationAngel() {
		return centerOfRotationAngle;
	}

	/**
 	* Returns the speed about
	*/ 
	public double getSpeedAbout() {
		return speed_about;
	}
}