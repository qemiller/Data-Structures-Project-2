/**
 * 
 */

/**
 * @author Josh
 *
 */
public class Flyweight implements Node {

    private static Flyweight fly;


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


    public Node insert(String s, int strIndex) {
        return new Leaf(s);
    };


    public Node remove(String s) {
        System.out.println("Can not remove a flyweight node!");
        return this;

    };


    public void print() {

    };


    public Node search(String s, boolean exact) {
        return fly;
    };
}
