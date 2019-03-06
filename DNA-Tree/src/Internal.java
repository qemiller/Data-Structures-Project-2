/**
 * 
 */

/**
 * @author Josh
 *
 */
public class Internal implements Node {

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

        if (s.length() > curData.length()) {
            insert(s);
            if (s.startsWith(curData)) {
                $ = $.insert(curData);
            }
            else {
                insert(curData);
            }
        }
        else {
            insert(curData);
            if (curData.startsWith(s)) {
                $ = $.insert(s);
            }
            else {
                insert(s);
            }
        }
    }


    /*
     * (non-Javadoc)
     * 
     * @see Node#print()
     */
    @Override
    public void print() {
    }


    @Override
    public Node insert(String s) {
        // Index to keep track of location in string
        int strIndex = 0;
        return insertHelper(s, strIndex);
    }


    public Node insertHelper(String s, int strIndex) {
        if (strIndex < s.length()) {
            Node currChild = getChild(s.charAt(strIndex));

            if ($ instanceof Leaf) {

            }
            // We have found the bottom of the tree, now we must reorganize
            if (currChild instanceof Leaf) {
                // This swaps the two strings and performs a recursive call on
                // the displaced string
                String oldString = ((Leaf)$).getString();
                ((Leaf)$).setString(s);
                insertHelper(oldString, strIndex);

                if (((Leaf)currChild).getString().length() < strIndex) {

                }
            }
            // currChild is not at the bottom of the trie, so we insert new
            // node, either
            // as a new leaf node, or as an internal node
            else {
                setChild(s.charAt(strIndex), currChild.insert(s));
            }
        }
        // If we get down here, we are out of characters in the string
        else {
            if ($ instanceof Flyweight) {
                $ = $.insert(s);
            }
            else {
                // Throw an error, either $ is an internal node(should never
                // happen)
                // Or it is a leaf node, in which case this is a duplicate
                // sequence
            }
        }
        return this;
    }


    public Node getChild(char letter) {
        switch (letter) {
            case 'A':
                return A;
            case 'C':
                return C;
            case 'G':
                return G;
            case 'T':
                return T;
        }
        return null;
    }


    public void setChild(char letter, Node newChild) {
        switch (letter) {
            case 'A':
                A = newChild;
            case 'C':
                C = newChild;
            case 'G':
                G = newChild;
            case 'T':
                T = newChild;
            case '$':
                $ = newChild;
        }
    }


    @Override
    public Node remove(String s) {
        int strIndex = 0;
        return removeHelp(s, strIndex);
    }


    private Node removeHelp(String s, int strIndex) {
        if (strIndex != s.length() - 1) {
            Node curChild = getChild(s.charAt(strIndex));
            setChild(s.charAt(strIndex),curChild.remove(s));
        }
        else
        {
            $ = $.remove(s);
        }
        
        Node collapse = null;
        for(Node Child:getChildNodes())
        {
            if(Child instanceof Internal)
            {
                return this;
            }
            else if(Child instanceof Leaf)
            {
                if(collapse == null)
                {
                    collapse = Child;
                }
                else
                {
                    return this;
                }
            }
        }
        return collapse;
    }


    @Override
    public Node search(String s, boolean exact) {
        int searchPos = 0;
        return searchHelper(s, searchPos, exact);
    }


    public Node searchHelper(String s, int strPos, boolean exact) {
        if (strPos < (s.length() - 1)) {
            // Have not found the bottom of the string, continue
            searchHelper(s, strPos + 1, exact);
        }
        else if (exact) {

        }
        else {

        }
        return this;
    }
    
    private Node[] getChildNodes()
    {
        Node[] array = new Node[5];
        array[0] = A;
        array[1] = C;
        array[2] = G;
        array[3] = T;
        array[4] = $;
        return array;
    }

}
