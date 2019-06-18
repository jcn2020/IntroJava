
package com.user.company ; 
import java.util.Random ; 
public class LoopCount {
    public static void main (String [] args ) {

        System.out.println(">>> Start count step");
        int startCount = 5 ; 
        int stopCount = 20 ; 
        int step = 3 ; 
        countByStep( startCount, stopCount, step ) ; 
        System.out.println(">>> Stop count step");

        // create arrays
        // ask template usage
        // List<Integer> list1 = new ArrayList<Integer>() ; 
        Random rand = new Random() ; 
        int size = 0 ;  // initialize value
        int offset =  20 ; 
        int maxValue = 5000 ; 
        int maxSize = rand.nextInt(5) ; 

        // create array 
        size = rand.nextInt(maxSize) ; 
        int[] list1 = new int[size] ; 

        // initialize array 
        initializeArray(list1, maxValue);

        // print Array 
        printArray(list1) ; 

        // Add offset for array
        System.out.println(">>> Start addToAll");
        addToAll( list1, offset ) ; 

        // print Array - double check for offset 
        printArray(list1) ; 
    }

    public static void initializeArray( int [] myArray, int maxValue) {
        Random rand = new Random() ; 
        for ( int i = 0 ; i < myArray.length ; i++ ) {
            myArray[i] = rand.nextInt(maxValue) ; 
        }
    }

    public static void printArray ( int[] myArray ) { 
        for ( int i = 0 ; i < myArray.length ; i++ ) {
            System.out.println (myArray[i]) ; 
        }
    }

    public static void addToAll( int[] myArray, int myOffset ) {
        for ( int i = 0 ; i < myArray.length; i++ ) {
            myArray[i] = myArray[i] + myOffset ; 
        }

    }
    public static void countByStep( int start, int stop, int step ) {
        for( int i = start; i < stop ; i = i + step ) {
            System.out.println( i );
        }
    } ; 

}
