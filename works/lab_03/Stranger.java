
public class Stranger {
    private int age ; 

    Stranger(int age) {
        age = age ; 
    }
    public static void main( String[] args) { 
        System.out.println("start ");
        Stranger s1 = new Stranger(20) ; 
        s1.sayHi() ; 
    }
    public void sayHi() { 
        System.out.println("Hello There");
    }
}
