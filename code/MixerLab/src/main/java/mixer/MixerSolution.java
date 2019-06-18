package mixer;

import java.util.*;

/**
 * Mixer is a stand-alone Java application.
 *
 * Mixer accepts any number of command line arguments.
 * If Mixer receives 3 or less arguments, Mixer sorts the arguments
 * using Arrays.sort and prints the resultant sorted array.
 *
 * If Mixer receives more than 3 arguments, Mixer sorts the arguments,
 * counts the frequency of each argument, and prints the arguments
 * and their frequency in sorted order.
 *
 * This version of the Mixer uses Autoboxing.
 * This version of the Mixer uses foreach syntax.
 *
 * @author developintelligence llc
 * @version 1.0
 */
public class MixerSolution {

  public static void main(String[] args) {
	  
	  args = new String[] { "one", "and", "one", "makes", "some", "amount" };
    //write Mixer logic here
    switch(args.length) {
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
        //Map<String, Integer> frequencyMap = getFrequencyMap(args);
        //Map<String, Integer> frequencyMap = getFrequencyMap3(args);
        Map<String, Integer> frequencyMap = getFrequencyMap4(args);
        printFrequenceMap(frequencyMap);
      break;
    }
  }

  
  private static Map<String, Integer> getFrequencyMap(String[] args) {
    Map<String, Integer> returnMap = new TreeMap<String, Integer>();
    List<String> list = Arrays.asList(args);

    //converted to for-each syntax
    for(String arg : list) {
      if(!returnMap.containsKey(arg)) {
        int freq = Collections.frequency(list, arg);
        //converted to use auto-boxing
        returnMap.put(arg, freq);
      }
    }

    return returnMap;
  }
  
  private static Map<String, Integer> getFrequencyMap2(String[] args) {
    Map<String, Integer> returnMap = new TreeMap<String, Integer>();
    for(String arg : args) {
      if(!returnMap.containsKey(arg)) {
    	 returnMap.put(arg, new Integer(0)); 
      }
      returnMap.put(arg, new Integer(returnMap.get(arg) + 1));
    }

    return returnMap;
  }

  private static Map<String, Integer> getFrequencyMap3(String[] args) {
    Map<String, Integer> returnMap = new TreeMap<String, Integer>();
    for(String arg : args) {
    	returnMap.computeIfAbsent(arg, i -> new Integer(0));
    	returnMap.computeIfPresent(arg, (k, v) -> v + 1);
    	
    }
    return returnMap;
  }
  
  private static Map<String, Integer> getFrequencyMap4(String[] args) {
    Map<String, Integer> returnMap = new TreeMap<String, Integer>();
    for(String arg : args) {
    	returnMap.merge(arg, new Integer(1), (orig, current) -> current + 1);
    }
    return returnMap;
  }
  private static void printFrequenceMapLamda(Map<String, Integer> frequencyMap) {
	  frequencyMap.forEach((k, v) -> System.out.println(k + "=" + v));
  }

  private static void printFrequenceMap(Map<String, Integer> frequencyMap) {
    Iterator<String> keys = frequencyMap.keySet().iterator();
    while(keys.hasNext()) {
      String key = keys.next();
      int value = frequencyMap.get(key);
      System.out.println(key + "=" + value);
    }
  }
}
