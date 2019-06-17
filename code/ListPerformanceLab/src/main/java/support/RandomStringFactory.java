package support;

public class RandomStringFactory {
	public static String makeRandomString(int length) {
		char [] chars = new char[length];
		for (int i = 0; i < chars.length; i++) {
			chars[i] = (char)((Math.random() * 26) + 'a');
		}
		return new String(chars);
	}
}
