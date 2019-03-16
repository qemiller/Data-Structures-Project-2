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
        Trie.setInsertDepth(depth);
        return new Leaf(s);
    };


    public Node remove(String s, int strIndex) {
        System.out.println("sequence " + s + "does not exsist");
        return this;

    };


    public void print(int tabIndex, String type) {
        String printTabs = "";
        for(int i = 0; i < tabIndex; i++)
        {
            printTabs = printTabs.concat("  ");
        }
        System.out.println(printTabs + "E");
    };


    public void search(String s,int strIndex, boolean exact, int nodesVisited) {
        Trie.nodeVisited();
    };
}
