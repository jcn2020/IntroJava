package test;

import things.Artist;
import things.SpySatellite;
import capabilities.Photographer;

public class TestInterfaces {

	public static void main(String[] args) {
		Photographer [] photogs = {
				new Artist("Henri"), new SpySatellite()
		};
		
		for (Photographer p : photogs) {
			p.takePhoto();
		}
	}

}
