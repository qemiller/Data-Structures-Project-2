/**
 * 
 */

/**
 * @author Josh
 *
 */
public class Internal implements Node {
    private String internalData;
    
    private Node A;
    private Node C;
    private Node G;
    private Node T;
    private Node $;
    
    Internal(String s, String curData) {
        Node A = Flyweight.getInstance();
        Node C = Flyweight.getInstance();
        Node G = Flyweight.getInstance();
        Node T = Flyweight.getInstance();
        Node $ = Flyweight.getInstance();
        
        this.internalData = s;
        
        String temp;
        
        if(s.length() > curData.length()) {
            insert(s);
            if(s.startsWith(curData)) {
                
            }
            else {
                insert(curData);
            }
        }
        else {
            insert(curData);
            if(curData.startsWith(s)) {
                
            }
            else {
                insert(s);
            }
        }
    }
    
    /* (non-Javadoc)
     * @see Node#print()
     */
    @Override
    public void print() {
        // TODO Auto-generated method stub

    }

    @Override
    public Node insert(String s) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Node remove(String s) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Node search(String s, boolean exact) {
        // TODO Auto-generated method stub
        int searchPos = 0;
        return searchHelper(s, searchPos, exact);
    }
    
    public Node searchHelper(String s, int strPos, boolean exact) {
        if(strPos < (s.length() - 1)) {
            //Have not found the bottom of the string, continue
            searchHelper(s, strPos + 1, exact);
        }
        else if(exact) {
            
        }
        else {
            
        }
        return this;
    }

}
