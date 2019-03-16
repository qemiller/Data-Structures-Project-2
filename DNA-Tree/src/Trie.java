import java.util.Stack;

/**
 * 
 */

/**
 * @author Josh
 * @author Quinton
 *
 */
public class Trie {
    private Node root;
    private static Stack<String> searchStrings = new Stack<String>();
    private static int nodesVisited = 0;
    private static int insertDepth = -1;


    Trie() {
        root = Flyweight.getInstance();
    }


    public Node insert(String s) {
        root = root.insert(s, 0);
        if (getInsertDepth() != -1) {
            System.out.println("sequence " + s + " inserted at level " + 
                Integer.toString(getInsertDepth()));
        }
        setInsertDepth(-1);
        return root;
    }


    public Node remove(String s) {
        return root = root.remove(s, 0);
    }


    public void print(String type) {
        System.out.println("tree dump:");
        root.print(0, type);
    }


    public void search(
        String s,
        int strIndex,
        boolean exact,
        int nodesVisited) {
        root.search(s, strIndex, exact, nodesVisited);
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


    public static void matchFound(String s) {
        searchStrings.push(s);
    }


    public static void nodeVisited() {
        setNodesVisited(getNodesVisited() + 1);
    }


    public static int getNodesVisited() {
        return nodesVisited;
    }


    public static void setNodesVisited(int nodesVisited) {
        Trie.nodesVisited = nodesVisited;
    }


    public static int getInsertDepth() {
        return insertDepth;
    }


    public static void setInsertDepth(int insertDepth) {
        Trie.insertDepth = insertDepth;
    }
}
