/**
 * 
 */

/**
 * @author Josh
 * @author Quinton
 * 
 * @version 3/5/2019
 *
 */
public class Leaf implements Node {
    private String leafData;


    Leaf(String s) {
        this.leafData = s;
    }


    /*
     * (non-Javadoc)
     * 
     * @see Node#print()
     */
    @Override
    public void print() {
        System.out.print(this.leafData);
    }


    @Override
    public Node insert(String s, int strIndex) {
        if (!this.leafData.equals(s)) {
            return new Internal(s, strIndex, this.leafData);
        }
        else {
            System.out.println("Cannot insert a leaf node with the"
                + " exact same data of another node");
            return this;
        }
    }


    @Override
    public Node remove(String s, int strIndex) {
        if (this.leafData.equals(s)) {
            System.out.println("sequnce " + s + " removed");
            return Flyweight.getInstance();
        }
        else {
            System.out.println("sequence" + s + "doesn't exsist");
            return this;
        }
    }


    @Override
    public void search(String s, int strIndex, boolean exact, int nodesVisited) {
        nodesVisited++;
        
    }
    
    public String getString() {
        return leafData;
    }
    
    public void setString(String s) {
        leafData = s;
    }

}
