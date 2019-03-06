/**
 * 
 */

/**
 * @author Josh
 *
 */
public class Leaf implements Node {
    private String leafData;
    
    Leaf(String s) {
        this.leafData = s;
    }
    
    /* (non-Javadoc)
     * @see Node#print()
     */
    @Override
    public void print() {
        System.out.print(this.leafData);
    }

    @Override
    public Node insert(String s) {
        //Must create an internal node for leaf node
        return new Internal(s, this.leafData);
    }

    @Override
    public Node remove(String s) {
        if(this.leafData.equals(s)) {
            return this;
        }
        return null;
    }

    @Override
    public Node search(String s, boolean exact) {
        if(this.leafData.equals(s)) {
            return this;
        }
        return null;
    }
    
    public String getString() {
        return leafData;
    }
    
    public void setString(String s) {
        leafData = s;
    }

}
