import java.util.Stack;

/**
 * 
 */

/**
 * @author Josh
 * @author Quinton
 * @version 3/17/2019
 */
public class Trie {
    /**
     * The root node of the tree.
     */
    private Node root;

    /**
     * This is a stack that stores the sequences found during a search.
     */
    private static Stack<String> searchStrings = new Stack<String>();

    /**
     * This counts the number of nodes visited during a search.
     */
    private static int nodesVisited = 0;

    /**
     * This is the depth of the node inserted into the tree. If the depth is -1,
     * then there was an error in insertion.
     */
    private static int insertDepth = -1;


    /**
     * Creates the tree
     */
    Trie() {
        root = Flyweight.getInstance();
    }


    /**
     * 
     * @param s
     *            Sequence to be inserted into the tree.
     * @return returns the root node after the insertion takes place.
     * 
     *         This inserts a node into the tree.
     */
    public Node insert(String s) {
        root = root.insert(s, 0);
        if (getInsertDepth() != -1) {
            System.out.println("sequence " + s + " inserted at level " + Integer
                .toString(getInsertDepth()));
        }
        setInsertDepth(-1);
        return root;
    }


    /**
     * 
     * @param s
     *            The sequence to be removed from the tree.
     * @return The root node after the remove occurs
     * 
     *         Removes a sequence from the tree.
     */
    public Node remove(String s) {
        return root = root.remove(s, 0);
    }


    /**
     * 
     * @param type
     *            the type of print for the tree to do
     * 
     *            Prints the tree to standard output based on type.
     */
    public void print(String type) {
        System.out.println("tree dump:");
        root.print(0, type);
    }


    /**
     * 
     * @param s
     *            sequence with possible flag at end for an exact match.
     * 
     *            This searches through the tree for the sequence. If the
     *            sequence contains a $ flag at the end, it will search for the
     *            exact sequence
     */
    public void search(String s) {
        boolean exact;
        if (s.charAt(s.length() - 1) == '$') {
            s = s.substring(0, s.length() - 1);
            exact = true;
        }
        else {
            exact = false;
        }
        root.search(s, 0, exact);
        System.out.println("# of nodes visted: " + Integer.toString(
            getNodesVisited()));
        if (!searchStrings.empty()) {
            while (!searchStrings.empty()) {
                String top = searchStrings.pop();
                System.out.println("sequence: " + top);
            }
        }
        else {
            System.out.println("no sequence found");
        }
        setNodesVisited(0);
    }


    /**
     * 
     * @param s
     *            sequence to be put into stack
     * 
     *            pushes a string into the searchStrings stack to help with
     *            searching for a sequence in the tree.
     */
    public static void matchFound(String s) {
        searchStrings.push(s);
    }


    /**
     * increments the nodesVisited parameter
     */
    public static void nodeVisited() {
        setNodesVisited(getNodesVisited() + 1);
    }


    /**
     * 
     * @return the value of nodesVisited
     * 
     *         gets the value of nodesVisited.
     */
    public static int getNodesVisited() {
        return nodesVisited;
    }


    /**
     * 
     * @param nodesVisited
     *            The value to set nodesVisited to
     * 
     *            sets the value of nodesVisited to the input.
     */
    public static void setNodesVisited(int nodesVisited) {
        Trie.nodesVisited = nodesVisited;
    }


    /**
     * 
     * @return the value of insertDepth
     * 
     *         gets the value of insertDepth
     */
    public static int getInsertDepth() {
        return insertDepth;
    }


    /**
     * 
     * @param insertDepth
     *            value to set insertDepth to.
     * 
     *            sets the value of insertDepth to the input.
     */
    public static void setInsertDepth(int insertDepth) {
        Trie.insertDepth = insertDepth;
    }
}
