package ttl.lab5b;

public class Artist implements Photographer {

	@Override
	public void takePhoto() {
		System.out.println("Say Cheese, taking a photo");
	}

}
