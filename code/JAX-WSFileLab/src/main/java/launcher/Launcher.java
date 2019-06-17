package launcher;

import javax.xml.ws.Endpoint;

import jaxwser.FileInfoJAXWSService;

public class Launcher {

	public static void main(String[] args) {
		String address = "http://localhost:8080/fileInfoService";
		Endpoint.publish(address,
				new FileInfoJAXWSService());		
		System.out.println("Server ready to go at " + address);
	}
}
