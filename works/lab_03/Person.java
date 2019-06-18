// package com.sbux.buildpipeline ; 

// import Person

public class Person {
    private String firstName ;
    private String lastName  ; 
    private String gender; 
    private int birthDay;
    private int birthMonth ; 
    public static void main ( String[] args ) {
        System.out.println("new class instance");
    
    }

    Person (String aFirstName, String aLastName, String aGender) {
        this(aFirstName, aLastName, aGender, 99, 99) ; 
    }

    Person (String aFirstName, String aLastName, String aGender, int day, int month) {
        firstName = aFirstName; 
        lastName = aLastName ; 
        gender = aGender ; 
        birthDay = day ; 
        birthMonth = month ; 
    }

    public String concatFirstLastName() {
        return( firstName + " " + lastName ) ; 
    }

    public String getTitle() {
        switch (gender) {
            case "male" : 
                return ("Mr. ") ; 
            case "female" :
                return ("Mrs") ; 
            default :
                return (" ") ; 
        } // gender
    } // function

    public String getFormalAddress() {
        return ( getTitle() + " " + concatFirstLastName() ) ; 
    }

} ;   

/* 
System.out.println("testing") ; 
Person stranger = new Person( "james", "Bond", "male", 03, 30) ; 
System.out.println(stranger.getTitle()) ; 
*/

