package things;

import capabilities.Photographer;

public class Artist extends Person implements Photographer {

	public Artist(String name) {
		super(name);
	}
	
	@Override
	public void takePhoto() {
		System.out.println("Hi, I'm " + getName() + " say cheese!");
	}

}
