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


    Internal(String s, int strIndex, String curData) {
        A = Flyweight.getInstance();
        C = Flyweight.getInstance();
        G = Flyweight.getInstance();
        T = Flyweight.getInstance();
        $ = Flyweight.getInstance();

        if (s.length() > curData.length()) {
            insert(s, strIndex);
            if (s.startsWith(curData)) {
                $$$insert$$$(s, strIndex);
            }
            else {
                insert(curData, strIndex);
            }
        }
        else {
            insert(curData, strIndex);
            if (curData.startsWith(s)) {
                $$$insert$$$(s, strIndex);
            }
            else {
                insert(s, strIndex);
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

            if ($ instanceof Leaf && s.length() < ((Leaf)$).getString().length()
                && ((Leaf)$).getString().startsWith(s)) {
                String temp = ((Leaf)$).getString();
                ((Leaf)$).setString(s);
                insert(temp, 0);
            }
            // We have found the bottom of the tree, now we must reorganize
            else if (currChild instanceof Leaf && strIndex + 1 == s.length()) {
                $$$insert$$$(s, strIndex);
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
            $$$insert$$$(s, strIndex);
        }
        return this;
    }


    private void $$$insert$$$(String s, int strIndex) {
        if ($ instanceof Flyweight) {
            $ = $.insert(s, strIndex);
        }
        else if (((Leaf)$).getString().contentEquals(s)) {
            // Throw error, we have duplicate node
        }
        else {
            // Swap and continue
            String temp = ((Leaf)$).getString();
            ((Leaf)$).setString(s);
            insert(temp, strIndex);
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
                break;
            case 'C':
                C = newChild;
                break;
            case 'G':
                G = newChild;
                break;
            case 'T':
                T = newChild;
                break;
            case '$':
                $ = newChild;
                break;
        }
    }


    @Override
    public Node remove(String s, int strIndex) {
        return removeHelp(s, strIndex);
    }


    private Node removeHelp(String sequence, int strIndex) {
        Node child = getChild(sequence.charAt(strIndex));
        if (child instanceof Leaf){
            if (sequence.charAt(strIndex) == 'A') {
                A = A.remove(sequence, 0);
            }

            else if (sequence.charAt(strIndex) == 'C') {
                C = C.remove(sequence, 0);
            }

            else if (sequence.charAt(strIndex) == 'G') {
                G = G.remove(sequence, 0);
            }

            else if (sequence.charAt(strIndex) == 'T') {
                T = T.remove(sequence, 0);
            }
        }
        else if(child == Flyweight.getInstance())
        {
            System.out.println("sequence" + sequence + "doesn't exsist");
            return this;
        }
        else {
            setChild(sequence.charAt(strIndex), child.remove(sequence, strIndex
                + 1));
        }
        
        Node collapse = Flyweight.getInstance();
        for (Node Child : getChildNodes()) {
            if (Child instanceof Internal) {
                return this;
            }
            else if (Child instanceof Leaf) {
                if (collapse == Flyweight.getInstance()) {
                    collapse = Child;
                }
                else {
                    return this;
                }
            }
        }
        return collapse;
    }


    @Override
    public void search(String s, int strPos, boolean exact, int nodesVisited) {
        searchHelper(s, strPos, exact, nodesVisited);
    }


    public void searchHelper(String s, int strPos, boolean exact, int nodesVisited) {
        nodesVisited++;
        if (strPos < (s.length() - 1)) {
            char childChar = s.charAt(strPos);
            Node child = getChild(childChar);
            child.search(s, strPos, exact, nodesVisited);
        }
        else if (exact) {
            Node child = getChild(s.charAt(strPos));
            child.search(s, strPos, exact, nodesVisited);
        }
        else {
            A.search(s, strPos, exact, nodesVisited);
            C.search(s, strPos, exact, nodesVisited);
            G.search(s, strPos, exact, nodesVisited);
            T.search(s, strPos, exact, nodesVisited);
            $.search(s, strPos, exact, nodesVisited);
        }
    }


    private Node[] getChildNodes() {
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
