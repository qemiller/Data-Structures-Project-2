/**
 * 
 */

/**
 * @author Josh
 *
 */
public class Flyweight implements Node {

    private static Flyweight fly = null;


    Flyweight() {
        
    }

    static {
        try {
            fly = new Flyweight();
        }
        catch (Exception e) {
            throw new RuntimeException("Could not create flyweight!");
        }
    }


    public static Flyweight getInstance() {
        return fly;
    };


    public Node insert(String s, int depth) {
        System.out.println("sequence " + s + " inserted at level " + Integer.toString(depth));
        return new Leaf(s);
    };


    public Node remove(String s, int strIndex) {
        System.out.println("sequence " + s + "does not exsist");
        return this;

    };


    public void print() {
        System.out.println("E");
    };


    public Node search(String s, boolean exact) {
        return fly;
    };
}
