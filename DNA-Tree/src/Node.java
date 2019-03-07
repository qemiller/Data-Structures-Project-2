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
    public void print();
    public Node search(String s, boolean exact);
}
