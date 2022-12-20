import java.util.*;

class SolarSystemData {
	private SolarBodyInfo sun_info;

	// Solar System that all this data belongs to
	private SolarSystem solar_system_belonging_to;

	// Singelton Design Pattern
	private static SolarSystemData solar_system_data;

	private SolarSystemData(SolarSystem solar_system_belonging_to) {
		this.solar_system_belonging_to = solar_system_belonging_to;

		// Defining the Data of the Sun in the Solar System //
		create_sun();

		// Defining the Data of the Planets in the Solar System //
		create_planets();

		// Defining the Data of the Moons in the Solar System //
		create_moons();

		// Defining the Data of the Rings of Saturn in the Solar System //
		create_rings_of_saturn();

		// Defining the Asteroid Belt in the Solar System //
		create_asteroid_belt();

		// Defining Commets: I didn't create the commets beccause it was moving in a weird way it was sort of bouncing while orbiting //
		// create_commets();

		// Singelton Design Pattern
		solar_system_belonging_to = null;
	}

	private void create_sun() {
		double distance = 0;
		double angel = 0;
		double diameter = 100;
		String color = "YELLOW";
		double speed = 0;
		String name = "Sun";

		sun_info = new SolarBodyInfo(
			solar_system_belonging_to,
			distance,
			angel,
			diameter, 
			color,
			speed
		);

		sun_info.setName(name);
	}

	private void create_planets() {
		String[] planet_names = {"mercury", "venus", "earth", "mars", "jupiter", "saturn", "uranus", "neptune"};

		// Defining the Data of the Planets //
		SolarBodyInfo earth_info = new SolarBodyInfo("BLUE", 10, 2.0);
		double earth_speed = earth_info.getSpeed();
		double earth_diameter = earth_info.getDiameter();

		SolarBodyInfo mars_info = new SolarBodyInfo("RED", earth_diameter / 2, earth_speed / 2);

		SolarBodyInfo jupiter_info = new SolarBodyInfo("#A28968", 4 * earth_diameter, earth_speed / 4);
		SolarBodyInfo saturn_info = new SolarBodyInfo("#E0C077", 3 * earth_diameter, earth_speed / 29);
		SolarBodyInfo mercury_info = new SolarBodyInfo("#6C6667", 0.5 * earth_diameter, 4 * earth_speed);
		SolarBodyInfo venus_info = new SolarBodyInfo("#C4985F", earth_diameter, 1.6 * earth_speed);
		SolarBodyInfo neptune_info = new SolarBodyInfo("#80A0D7", 2 * earth_diameter, earth_speed / 165);
		SolarBodyInfo uranus_info = new SolarBodyInfo("#D3E5F1", 2 * earth_diameter, earth_speed / 84);

		sun_info.addOrbitingBody(new Planet(mercury_info));
		sun_info.addOrbitingBody(new Planet(venus_info));
		sun_info.addOrbitingBody(new Planet(earth_info));
		sun_info.addOrbitingBody(new Planet(mars_info));
		sun_info.addOrbitingBody(new Planet(jupiter_info));
		sun_info.addOrbitingBody(new Planet(saturn_info));
		sun_info.addOrbitingBody(new Planet(uranus_info));
		sun_info.addOrbitingBody(new Planet(neptune_info));

		int distance = 80;
		for (int i = 0; i < sun_info.getNumOrbitingBodies(); i++) {
			SolarBodyInfo planet = sun_info.getOrbitingBody(i).getSolarBodyInfo();
			
			planet.setDistance(distance);
			planet.setAngel(0);
			planet.setSolarSystem(solar_system_belonging_to);
			planet.setName(planet_names[i]);
			
			distance += 40;
		}
	}

	private void create_moons() {
		// Earth Moon
		SolarBodyInfo earth_info = sun_info.getOrbitingBody("earth").getSolarBodyInfo();
		SolarBodyInfo moon_info = new SolarBodyInfo(
			"WHITE",
			earth_info.getDiameter() / 4
		);
		earth_info.addOrbitingBody(new Moon(moon_info, 10, 10));

		// Mars Moons
		SolarBodyInfo mars_info = sun_info.getOrbitingBody("mars").getSolarBodyInfo();
		SolarBodyInfo phobos_info = new SolarBodyInfo(
			"#8D7D75",
			mars_info.getDiameter() / 3
		);

		SolarBodyInfo deimos_info = new SolarBodyInfo(
			"#A09D94",
			mars_info.getDiameter() / 2
		);
		mars_info.addOrbitingBody(new Moon(phobos_info, 10, 5));
		mars_info.addOrbitingBody(new Moon(deimos_info, 15, 7));

		// Jupiter Moons
		SolarBodyInfo jupiter_info = sun_info.getOrbitingBody("jupiter").getSolarBodyInfo();
		SolarBodyInfo io_info = new SolarBodyInfo(
			"#A3A142",
			jupiter_info.getDiameter() / (2 * 3.8)
		);
		SolarBodyInfo europa_info = new SolarBodyInfo(
			"#AD8B65",
			jupiter_info.getDiameter() / (2 * 4.4)
		);
		SolarBodyInfo ganymede_info = new SolarBodyInfo(
			"#5A3C1F",
			jupiter_info.getDiameter() / (2 * 2.6)
		);
		SolarBodyInfo callisto_info = new SolarBodyInfo(
			"#6E7E77",
			jupiter_info.getDiameter() / (2 * 2.9)
		);
		jupiter_info.addOrbitingBody(new Moon(io_info, 25, 3));
		jupiter_info.addOrbitingBody(new Moon(europa_info, 30, 8));
		jupiter_info.addOrbitingBody(new Moon(ganymede_info, 35, 6));
		jupiter_info.addOrbitingBody(new Moon(callisto_info, 45, 10));

		// Uranus Moons
		SolarBodyInfo uranus_info = sun_info.getOrbitingBody("uranus").getSolarBodyInfo();
		SolarBodyInfo titania_info = new SolarBodyInfo(
			"#AFA69C",
			uranus_info.getDiameter() / 6.3 
		);
		SolarBodyInfo oberon_info = new SolarBodyInfo(
			"#EFEDDB",
			uranus_info.getDiameter() / 6.5
		);
		uranus_info.addOrbitingBody(new Moon(titania_info, 15, 3));
		uranus_info.addOrbitingBody(new Moon(oberon_info, 20, 1));

		// Neptune Moons
		SolarBodyInfo neptune_info = sun_info.getOrbitingBody("neptune").getSolarBodyInfo();
		SolarBodyInfo triton_info = new SolarBodyInfo(
			"#7A5D66",
			neptune_info.getDiameter() / (2 * 1.8)
		);
		neptune_info.addOrbitingBody(new Moon(triton_info, 15, 2));

		// Adding Common Properties to all moons
		for (int i = 0; i < sun_info.getNumOrbitingBodies(); i++) {
			SolarBodyInfo curent_planet_info = sun_info.getOrbitingBody(i).getSolarBodyInfo();
			
			for (int j = 0; j < curent_planet_info.getNumOrbitingBodies(); j++) {
				SolarBodyInfo current_moon_info = curent_planet_info.getOrbitingBody(j).getSolarBodyInfo();

				current_moon_info.setSolarSystem(solar_system_belonging_to);
				current_moon_info.setDistance(curent_planet_info.getDistance());
				current_moon_info.setAngel(0);
				current_moon_info.setSpeed(curent_planet_info.getSpeed());
			}
		}
	}

	private void create_rings_of_saturn() {
		// Saturn Moons
		SolarBodyInfo saturn_info = sun_info.getOrbitingBody("saturn").getSolarBodyInfo();
		for (int i = 0; i < 360; i += 2) {
			double random_diameter = new Random().nextDouble(2) + 2;
			SolarBodyInfo rock_info = new SolarBodyInfo(
				solar_system_belonging_to,
				saturn_info.getDistance(),
				0,
				random_diameter,
				"#8B8B8B",
				saturn_info.getSpeed()
			);

			double random_dist = new Random().nextDouble(4) + 22;
			double random_speed = new Random().nextDouble(4) + 16;

			Moon rock = new Moon(rock_info, random_dist, random_speed);
			rock.setCenterOfRotationAngel(i);
			
			saturn_info.addOrbitingBody(rock);
		}
	}

	private void create_asteroid_belt() {
		double distance_of_mars = sun_info.getOrbitingBody("mars").getSolarBodyInfo().getDistance();
		double distance_of_jupiter = sun_info.getOrbitingBody("jupiter").getSolarBodyInfo().getDistance();

		double distance = (distance_of_mars + distance_of_jupiter) / 2 - 30;
		double distance_of_asteroid_belt;
		String color = "WHITE";

		for (int i = 0; i < 3000; i += 5) {
			distance_of_asteroid_belt = new Random().nextDouble(30) + distance;
			double random_speed = new Random().nextDouble(3);
			double random_diameter = new Random().nextDouble(3);
			SolarBodyInfo asteroid = new SolarBodyInfo(
				solar_system_belonging_to,
				distance_of_asteroid_belt,
				i,
				random_diameter,
				color,
				random_speed
			);

			sun_info.addOrbitingBody(new Planet(asteroid));
		}
	}

	private void create_commets() {
		for (double i = 1; i <= 10; i++) {
			SolarBodyInfo commet_info = new SolarBodyInfo(
				solar_system_belonging_to,
				40 * i,
				0,
				3 * i,
				"AQUA",
				i / 2
			);
	
			sun_info.addOrbitingBody(new Commet(commet_info, i * 2));
		}
	}

	public static SolarSystemData getSolarSystemData(SolarSystem solar_system_belonging_to) {
		if (solar_system_data == null) solar_system_data = new SolarSystemData(solar_system_belonging_to);

		return solar_system_data;
	}

	public SolarBodyInfo getSunInfo() {
		return sun_info;
	}
}