import java.util.concurrent.ThreadLocalRandom;

public class ClassesEtc {
	
	public static void main(String [] args) {
		//switchDemo();
		int [] iarr = new int[10];
		int x = 10;
		simpleArrays(x, iarr);
		
		System.out.println("x is " + x);
	}
	
	public static int simpleArrays(int x, int [] iarr) {
		
		x++;
		
		iarr = new int[10];

		int [] iarray0 = { 0, 5, 60, 22 };

		//int [] iarray = new int[10];
		int [] iarray = new int[x]; 


		for(int i = 0; i < iarray.length; i++) {
			iarray[i] = i * i;
			System.out.println("iarray[" + i + "] is " + iarray[i]);
		}
		
		String str = "Boo";
		
		int randomInt = ThreadLocalRandom.current().nextInt(100);
				
			
		String [] sarray = { "one", "two", "three" };
		
		for(int i = 0; i < sarray.length; i++) {
			System.out.println(sarray[i]);
		}
		
		return 42;
	}


	public static void switchDemo() {
		int i = 10;
		switch(i) {
		case 10:
			System.out.println("i is 10");
			break;
		case 20:
			System.out.println("i is 20");
			break;
		default:
			System.out.println("none of the above");
		}
	}
	
	public static void variablePlay() {
		
		boolean b = true;

		byte by = 2;
		char aCharacter = 'a';
		short s = 25;
		int i = 500;
		long l = 2345677;
		
		float f = 22.4F;
		double d = 45678.9876;
		
		String str = "hello";
		
		System.out.printf("Value of d is %.2f%n", d);

		System.out.println("Value of d is " + d);
		
		
		if( i < 10) { 
			System.out.println("less than 10");
		}
		else if(i < 60) {
			System.out.println("less than 60");
		}
		else {
			System.out.println("none of the above");
		}
		
		
	}
	
	
	public void loops() {
		int j = 10;
		
		while(j > 0) {
			System.out.println("J is " + j);
			
			j--;
		}
		
		for(int i = 0; i < 10; i++) {
			System.out.println("J is " + j);
		}
	}
	
	public void someMethod() {
		
	}

}
