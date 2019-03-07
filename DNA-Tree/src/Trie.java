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
    
    Trie(){
        root = Flyweight.getInstance();
    }
    
    public Node insert(String s){
        return root = root.insert(s, 0);
    }
    
    public Node remove(String s){
        return root = root.remove(s, 0);
    }
    
    public void print(){
        root.print();
    }
    
    public Node search(String s, boolean exact) {
        return root = root.search(s, exact);
    }
}
