import javax.swing.*;
import java.awt.event.*;

class UserOptions extends JFrame implements ActionListener {
	JPanel btnsPanel;
	SolarBody parentSolarBody;

	public UserOptions(SolarBody parentSolarBody) {
		btnsPanel = new JPanel();
		createBtnsPanel();
		
		setSize(250, 100);
		add(btnsPanel);
		setVisible(true);

		this.parentSolarBody = parentSolarBody;
	}

	private void createBtnsPanel() {
		JButton zoom = new JButton("Zoom");
		JButton minimize = new JButton("Minimize");
		JButton accelerate = new JButton("Speed Up");
		JButton decelerate = new JButton("Slow Down");

		zoom.addActionListener(this);
		minimize.addActionListener(this);
		accelerate.addActionListener(this);
		decelerate.addActionListener(this);

		btnsPanel.add(zoom);
		btnsPanel.add(minimize);
		btnsPanel.add(accelerate);
		btnsPanel.add(decelerate);
	}

	public void actionPerformed(ActionEvent e) {
		String btnClicked = e.getActionCommand();

		if (btnClicked.equals("Zoom")) changeSize(parentSolarBody, 1.05);
		else if (btnClicked.equals("Minimize")) changeSize(parentSolarBody, 0.95);
		else if (btnClicked.equals("Speed Up")) changeSpeed(parentSolarBody, 1.05);
		else changeSpeed(parentSolarBody, 0.95);
	}

	// changeSpeed() changes the speed of every Solar Body in the Solar System based on the rate
	private void changeSpeed(SolarBody solarBody, double rate) {
		// Changing the Speed of the current Solar Body //
		solarBody.changeSpeed(rate);

		// Applaying the same affect to all the Solar Bodies Orbiting the current Solar Body //
		SolarBodyInfo solarBodyInfo = solarBody.getSolarBodyInfo();
		int numOrbitingBodies = solarBodyInfo.getNumOrbitingBodies();
		for (int i = 0; i < numOrbitingBodies; i++)
			changeSpeed(solarBodyInfo.getOrbitingBody(i), rate);
	}

	// changeSize() changes the size of every Solar Body in the Solar System based on the rate
	private void changeSize(SolarBody solarBody, double rate) {		
		// Changing the Size and Distance of the current Solar Body //
		solarBody.changeSize(rate);

		// Applaying the same affect to all the Solar Bodies Orbiting the current Solar Body //
		SolarBodyInfo solarBodyInfo = solarBody.getSolarBodyInfo();
		int numOrbitingBodies = solarBodyInfo.getNumOrbitingBodies();
		for (int i = 0; i < numOrbitingBodies; i++)
			changeSize(solarBodyInfo.getOrbitingBody(i), rate);
	}
}