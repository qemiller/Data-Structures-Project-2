/**
 * 
 */

/**
 * @author Josh
 *
 */
public interface Node {
    public Node insert(String s);
    public Node remove(String s);
    public void print();
    public Node search(String s, boolean exact);
}
