package things;

import capabilities.Photographer;

public class SpySatellite implements Photographer {

	@Override
	public void takePhoto() {
		System.out.println("Click! I can read your license plate!");
	}

}
