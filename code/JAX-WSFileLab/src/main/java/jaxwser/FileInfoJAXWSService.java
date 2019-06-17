
package jaxwser;

import java.io.File;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class FileInfoJAXWSService 
{
	@WebMethod
	public String getFileInfo(String fileName) {
		File file = new File(fileName);
		StringBuffer result = new StringBuffer();
		if(file.exists()) {
			result.append(file.getAbsolutePath() + ": size = " + file.length() + ", readable:" + file.canRead());
		}
		else {
			result.append("File " + fileName + " does not Exist");
		}
		
		return result.toString();
	}
}
