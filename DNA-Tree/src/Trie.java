import java.util.Stack;

/**
 * @author Josh
 * @author Quinton
 * @version 3/19/2019
 * 
 *          This is the file that instantiates a tree and will run the functions
 *          created in the inherited Node classes.
 */
public class Trie {
    /**
     * The root node of the tree.
     */
    private Node root;

    /**
     * This is a list that stores the sequences found during a search.
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
        if (s.matches("[ACGT]+")) {
            root = root.insert(s, 0);
            if (getInsertDepth() != -1) {
                System.out.println("sequence " + s + " inserted at level "
                    + Integer.toString(getInsertDepth()));
            }
            else {
                System.out.println("sequence " + s + " already exists");
            }
            setInsertDepth(-1);
            return root;
        }
        return Flyweight.getInstance();
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
        root = root.remove(s, 0);
        return root;
    }


    /**
     * 
     * @param type
     *            Offers different options for the print command,
     *            the default is dump, but allows lengths and stats
     *            as well
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
     *            sequence with possible flag at the end for an exact match.
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
        System.out.println("# of nodes visited: " + Integer.toString(
            getNodesVisited()));
        if (searchStrings.isEmpty()) {
            System.out.println("no sequence found");
        }
        else {
            Stack<String> outputStack = new Stack<String>();
            while (!searchStrings.empty()) {
                outputStack.push(searchStrings.pop());
            }
            while (!outputStack.empty()) {
                String top = outputStack.pop();
                System.out.println("sequence: " + top);
            }
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
