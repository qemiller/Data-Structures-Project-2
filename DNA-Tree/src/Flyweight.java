/**
 * 
 */

/**
 * @author Josh Rehm
 * @author Quinton Miller
 * @version 3/17/2019
 * 
 *          This is the implementation of the Flyweight Node inherited from Node
 */
public class Flyweight implements Node {
    private static Flyweight fly = null;


    /**
     * Creates an instance of Flyweight
     */
    Flyweight() {
        // creates a new flyweight
    }

    static {
        try {
            fly = new Flyweight();
        }
        catch (Exception e) {
            throw new RuntimeException("Could not create flyweight!");
        }
    }


    /**
     * 
     * @return value of fly
     * 
     *         gets the value of fly which should be null
     */
    public static Flyweight getInstance() {
        return fly;
    };


    @Override
    public Node insert(String s, int depth) {
        return insertHelper(s, depth);
    };


    /**
     * 
     * @param s
     *            sequence to be inserted
     * @param depth
     *            depth the sequence was inserted into
     * @return the new leaf node
     * 
     *         This creates a new leaf node with the sequence from s and returns
     *         it
     */
    private Node insertHelper(String s, int depth) {
        Trie.setInsertDepth(depth);
        return new Leaf(s);
    }


    @Override
    public Node remove(String s, int strIndex) {
        return removeHelper(s, strIndex);
    };

    

    /**
     * 
     * @param s
     *            sequence to be removed
     * @param strIndex
     *            index of the string being looked at.
     * @return the same node
     * 
     *         This will do output an error to console because if we are trying
     *         to remove a flyweight then the sequence doesn't exist in the
     *         tree.
     */
    private Node removeHelper(String s, int strIndex) {
        System.out.println("sequence " + s + " does not exist");
        return this;
    }


    @Override
    public void print(int tabIndex, String type) {
        printHelper(tabIndex, type);
    };


    /**
     * 
     * @param tabIndex
     *            how many tabs to but before the output
     * @param type
     *            type of print to the console
     * 
     *            This will output the value of the node to the console. This
     *            value will be E because the node is empty.
     */
    private void printHelper(int tabIndex, String type) {
        String printTabs = "";
        for (int i = 0; i < tabIndex; i++) {
            printTabs = printTabs.concat("  ");
        }
        System.out.println(printTabs + "E");
    }


    @Override
    public void search(String s, int strIndex, boolean exact) {
        Trie.nodeVisited();
    };
}
