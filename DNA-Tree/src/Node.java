/**
 * 
 */

/**
 * @author Josh
 *
 */
public interface Node {
    public Node insert(String s, int strIndex);
    public Node remove(String s, int strIndex);
    public void print(int tabIndex, String type);
    public void search(String s, int strIndex, boolean exact, int nodesVisited);
}
