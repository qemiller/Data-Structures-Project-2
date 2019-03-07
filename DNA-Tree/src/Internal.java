/**
 * 
 */

/**
 * @author Josh
 * @author Quinton
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
            insert(s, 0);
            if (s.startsWith(curData)) {
                $$$insert$$$(s);
            }
            else {
                insert(curData, 0);
            }
        }
        else {
            insert(curData, 0);
            if (curData.startsWith(s)) {
                $$$insert$$$(s);
            }
            else {
                insert(s, 0);
            }
        }
    }

    @Override
    public Node insert(String s, int strIndex) {
        // Index to keep track of location in string
        return insertHelper(s, strIndex);
    }


    public Node insertHelper(String s, int strIndex) {
        if (strIndex < s.length()) {
            Node currChild = getChild(s.charAt(strIndex));

            if($ instanceof Leaf && s.length() < ((Leaf) $).getString().length() &&
                    ((Leaf) $).getString().startsWith(s)) {
                String temp = ((Leaf) $).getString();
                ((Leaf) $).setString(s);
                insert(temp, 0);
            }
            // We have found the bottom of the tree, now we must reorganize
            else if (currChild instanceof Leaf && strIndex + 1 == s.length()) {
                $$$insert$$$(s);
            }
            // currChild is not at the bottom of the trie, so we insert new
            // node, either
            // as a new leaf node, or as an internal node
            else {
                setChild(s.charAt(strIndex), currChild.insert(s, strIndex + 1));
            }
        }
        // If we get down here, we are out of characters in the string
        else {
            $$$insert$$$(s);
        }
        return this;
    }

    private void $$$insert$$$(String s){
        if ($ instanceof Flyweight) {
            $ = $.insert(s, 0);
        } 
        else if (((Leaf) $).getString().contentEquals(s)) {
            //Throw error, we have duplicate node
        } 
        else {
            //Swap and continue
            String temp = ((Leaf) $).getString();
            ((Leaf) $).setString(s);
            insert(temp, 0);
        }
    }

    private Node getChild(char letter) {
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
        Node internalNode = getChild('$');
        String internalData = internalNode.toString();
        if (s.charAt(strIndex) == internalData.charAt(strIndex))
        {
            if(strIndex == s.length() - 1)
            {
                Node removeNode = getChild(s.charAt(strIndex));
                 removeNode = removeNode.remove(s);
            }
            else
            {
                removeHelp(s,strIndex++);
            }
        }
        else
        {
           return this;
        }
        
        Node collapse = Flyweight.getInstance();
        for(Node Child:getChildNodes())
        {
            if(Child instanceof Internal)
            {
                return this;
            }
            else if(Child instanceof Leaf)
            {
                if(collapse == Flyweight.getInstance())
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
    
    /*
     * (non-Javadoc)
     * 
     * @see Node#print()
     */
    @Override
    public void print() {
    }


}
