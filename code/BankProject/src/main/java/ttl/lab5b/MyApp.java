package ttl.lab5b;

public class MyApp {
	public static void main(String[] args) {
		Photographer [] ps = new Photographer[2];
		
		ps[0] = new Artist();
		ps[1] = new SpySatellite();
		
		for(Photographer p : ps) {
			p.takePhoto();
		}
	}

}
