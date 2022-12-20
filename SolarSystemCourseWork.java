class SolarSystemCourseWork {
	SolarSystem solar_system;
	Star sun;
	SolarSystemData solar_system_data;
	UserOptions userExperienceWindow;
	
	public SolarSystemCourseWork() {
		// Creating the Solar System
		solar_system = new SolarSystem(1500, 900);
		
		// Creating the solar_system_data object which stores all the data about our solar system
		solar_system_data = SolarSystemData.getSolarSystemData(solar_system);

		// Creating the Sun in the Solar System
		sun = new Star(solar_system_data.getSunInfo());
	
		// Adding Some User Functionaliy
		userExperienceWindow = new UserOptions(sun);
	}

	public static void main(String[] args) {
		SolarSystemCourseWork main_program = new SolarSystemCourseWork();
		main_program.continuousOrbit();
	}

	private void continuousOrbit() {
		while (true) {
			orbitOnce(sun);
			solar_system.finishedDrawing();
		}
	}

	private void orbitOnce(SolarBody solarBody) {
		SolarBodyInfo solarBodyInfo = solarBody.getSolarBodyInfo();
		solarBody.moveSolarBody();

		int orbitingSolarBodies = solarBodyInfo.getNumOrbitingBodies();
		for (int i = 0; i < orbitingSolarBodies; i++)
			orbitOnce(solarBodyInfo.getOrbitingBody(i));
	}
}