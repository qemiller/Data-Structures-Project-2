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


    Trie() {
        root = Flyweight.getInstance();
    }


    public Node insert(String s) {
        return root = root.insert(s, 0);
    }


    public Node remove(String s) {
        return root = root.remove(s, 0);
    }


    public void print() {
        root.print();
    }


    public void search(
        String s,
        int strIndex,
        boolean exact,
        int nodesVisited) {
        root.search(s, strIndex, exact, nodesVisited);
    }
}
