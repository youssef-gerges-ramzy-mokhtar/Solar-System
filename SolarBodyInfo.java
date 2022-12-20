import java.util.*;

public class SolarBodyInfo {
	private SolarSystem solar_system_belonging_to;
	private double distance;
	private double angel;
	private double diameter;
	private String color;
	private double speed;
	private Vector<SolarBody> orbiting_bodies;
	private String name;

	/**
	* SolarBodyInfo contains all the information about a Solar Body in Solar System.
	*
	* @param solarSystem representing the solarSystem that the solar body exists in.
	* @param distance the distance from this object to the point about which it is orbiting.
	* @param angle the angle (in degrees) that represents how far the object is around its orbit.
	* @param diameter the size of the solar body.
	* @param color the colour of this object, as a string. Case insentive. <p>One of: BLACK, BLUE, CYAN, DARK_GRAY, GRAY, GREEN, LIGHT_GRAY, 
	* MAGENTA, ORANGE, PINK, RED, WHITE, YELLOW. Alternatively, a 24 bit hexadecimal string representation of an RGB colour is also accepted, e.g. "#FF0000"</p>
	* @param speed the speed of orbit of the solar body in the solar system.
	*/
	public SolarBodyInfo(SolarSystem solar_system, double distance, double angel, double diameter, String color, double speed) {
		this(color, diameter, speed);
		this.solar_system_belonging_to = solar_system;
		this.distance = distance;
		this.angel = angel % 360.0;
	}

	/**
	* SolarBodyInfo contains all the information about a Solar Body in Solar System.
	*
	* @param color the colour of this object, as a string. Case insentive. <p>One of: BLACK, BLUE, CYAN, DARK_GRAY, GRAY, GREEN, LIGHT_GRAY, 
	* MAGENTA, ORANGE, PINK, RED, WHITE, YELLOW. Alternatively, a 24 bit hexadecimal string representation of an RGB colour is also accepted, e.g. "#FF0000"</p>
	* @param diameter the size of the solar body.
	* @param speed the speed of orbit of the solar body in the solar system.
	*/
	public SolarBodyInfo(String color, double diameter, double speed) {
		this(color, diameter);
		this.speed = speed;
	}

	/**
	* SolarBodyInfo contains all the information about a Solar Body in Solar System.
	*
	* @param color the colour of this object, as a string. Case insentive. <p>One of: BLACK, BLUE, CYAN, DARK_GRAY, GRAY, GREEN, LIGHT_GRAY, 
	* MAGENTA, ORANGE, PINK, RED, WHITE, YELLOW. Alternatively, a 24 bit hexadecimal string representation of an RGB colour is also accepted, e.g. "#FF0000"</p>
	* @param diameter the size of the solar body.
	*/
	public SolarBodyInfo(String color, double diameter) {
		this.color = color;
		this.diameter = diameter;
		orbiting_bodies = new Vector<SolarBody>();

		this.name = "solar body";
	}

	// Setters //
	/**
 	* sets the solar system that the solar body belongs to
 	* @param solarSystemBelongingTo
	*/
	public void setSolarSystem(SolarSystem solar_system_belonging_to) {
		this.solar_system_belonging_to = solar_system_belonging_to;
	}

	/**
 	* sets the distance of the solar body
 	* @param distance
	*/
	public void setDistance(double distance) {
		this.distance = distance;
	}

	/**
 	* sets the angle of the solar body
 	* @param angle
	*/
	public void setAngel(double angel) {
		this.angel = angel % 360.0;
	}

	/**
 	* sets the size of the solar body
 	* @param diameter
	*/
	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}

	/**
 	* sets the color of the solar body
 	* @param color
	*/
	public void setColor(String color) {
		this.color = color;
	}

	/**
 	* sets the speed of orbit of the solar body
 	* @param speed
	*/
	public void setSpeed(double speed) {
		this.speed = speed;		
	}

	/**
 	* adds a Solar Body that orbits this Solar Body
 	* @param orbitingSolarBody
	*/
	public void addOrbitingBody(SolarBody solar_body) {
		orbiting_bodies.add(solar_body);
	}

	/**
 	* sets the name of the solar body
 	* @param name
	*/
	public void setName(String name) {
		this.name = name;
	}

	// Getters //
	/**
 	* Returns the solar system that the solar body exists in
	*/
	public SolarSystem getSolarSystem() {
		return solar_system_belonging_to;
	}

	/**
 	* Returns the distance of the solar body
	*/
	public double getDistance() {
		return distance;
	}

	/**
 	* Returns the angle of the solar body
	*/
	public double getAngel() {
		return angel;
	}

	/**
 	* Returns the diameter of the solar body
	*/
	public double getDiameter() {
		return diameter;
	}

	/**
 	* Returns the color of the solar body
	*/
	public String getColor() {
		return color;
	}

	/**
 	* Returns the speed of the solar body
	*/
	public double getSpeed() {
		return speed;
	}

	/**
 	* Returns the number of solar bodies that orbits this solar body
	*/
	public int getNumOrbitingBodies() {
		return orbiting_bodies.size();
	}

	/**
 	* Returns the Solar Body that orbits this solar body based on its position
 	* @param pos - position of the orbiting solar body
	*/
	public SolarBody getOrbitingBody(int pos) {
		return orbiting_bodies.get(pos);
	}

	/**
 	* Returns the Solar Body that orbits this solar body based on its name
 	* @param name - name of the orbiting solar body
	*/
	public SolarBody getOrbitingBody(String name) {
		name = name.toLowerCase();

		for (int i = 0; i < orbiting_bodies.size(); i++) {
			SolarBodyInfo solar_body_info = orbiting_bodies.get(i).getSolarBodyInfo();
			if (solar_body_info.getName().equals(name)) return orbiting_bodies.get(i);
		}

		return null;
	}

	/**
 	* Returns the name of the solar body
	*/
	public String getName() {
		return name;
	}
}