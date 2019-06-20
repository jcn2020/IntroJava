package mixer;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * Mixer is a stand-alone Java application.
 *
 * Mixer accepts any number of command line arguments. If Mixer receives 3 or
 * less arguments, Mixer sorts the arguments using Arrays.sort and prints the
 * resultant sorted array.
 *
 * If Mixer receives more than 3 arguments, Mixer sorts the arguments, counts
 * the frequency of each argument, and prints the arguments and their frequency
 * in sorted order.
 *
 * This version of the Mixer uses Autoboxing. This version of the Mixer uses
 * foreach syntax.
 *
 * @author developintelligence llc
 * @version 1.0
 */
public class Mixer {

	public static void main(String[] args) {
		// Fake the args if you want
		args = new String[] { "one", "and", "one", "makes", "some", "amount" };
		// write Mixer logic here
		switch (args.length) {
		case 0:
			break;
		case 1:
		case 2:
		case 3:
			Arrays.sort(args);
			System.out.println(Arrays.toString(args));
			break;
		default:
			Arrays.sort(args);
			Map<String, Integer> frequencyMap = getFrequencyMap(args);
			printFrequenceMap(frequencyMap);
			break;
		}
	}

	private static Map<String, Integer> getFrequencyMap(String[] args) {
		Map<String, Integer> returnMap = new TreeMap<>();

		List<String> list = Arrays.asList(args);

		// converted to for-each syntax
		for (String arg : list) {
			if (!returnMap.containsKey(arg)) {
				int freq = Collections.frequency(list, arg);
				// converted to use auto-boxing
				returnMap.put(arg, freq);
			}
		}

		return returnMap;
	}

	private static Map<String, Integer> getFrequencyMapToo(String[] args) {
		Map<String, Integer> returnMap = new TreeMap<>();

		Instant start = Instant.now();
		for (String arg : args) {
			if (!returnMap.containsKey(arg)) {
				returnMap.put(arg, 0);
			}
			returnMap.put(arg,  new Integer(returnMap.get(arg) + 1));
		}
		
		Instant end = Instant.now();
		System.out.println("getFrequency took " + start.until(end, ChronoUnit.MILLIS));

		return returnMap;
	}

	private static void printFrequenceMap(Map<String, Integer> frequencyMap) {
		Iterator<String> keys = frequencyMap.keySet().iterator();
		while (keys.hasNext()) {
			String key = keys.next();
			int value = frequencyMap.get(key);

			System.out.println(key + "=" + value);
		}
	}
}
