
public class MyWork{ 
    public static void main (String[] args) { 
        Stranger s1 = new Stranger(20) ; 
        s1.sayHi();
        Person neighbor = new Person("John", "Smith", "male", 20, 30) ; 
        System.out.println(neighbor.getFormalAddress() );

    }
}