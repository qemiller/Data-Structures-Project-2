/**
 * 
 */

/**
 * @author Josh Rehm
 * @author Quinton Miller
 * @version 3/17/2019
 * 
 * This is the implementation of internal node inherited from Node.
 *
 */
public class Internal implements Node {

    /**
     * A Node
     */
    private Node A;

    /**
     * C Node
     */
    private Node C;

    /**
     * G Node
     */
    private Node G;

    /**
     * T Node
     */
    private Node T;

    /**
     * $ Node
     */
    private Node $;


    /**
     * default constructor for internal.
     */
    Internal() {
        A = Flyweight.getInstance();
        C = Flyweight.getInstance();
        G = Flyweight.getInstance();
        T = Flyweight.getInstance();
        $ = Flyweight.getInstance();
    }


    /**
     * 
     * @param s
     *            String of the sequence the tree is dealing with
     * @param strIndex
     *            Index of the String the node is dealing with
     * @param curData
     *            The current string in the tree
     * 
     *            This creates a new internal node from the current sequence in
     *            the tree and the new sequence
     */
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


    /**
     * @param s
     *            sequence to be inserted into the tree
     * @param strIndex
     *            index of the string that the internal node is looking at.
     * 
     *            inserts a sequence into an internal node
     */
    @Override
    public Node insert(String s, int strIndex) {
        // Index to keep track of location in string
        return insertHelper(s, strIndex);
    }


    /**
     * @param s
     *            sequence to be inserted into the tree
     * @param strIndex
     *            index of the string that the internal node is looking at.
     * 
     *            inserts a sequence into an internal node
     */

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
                Internal newChild = new Internal();
                newChild.setChild(((Leaf)currChild).getString().charAt(
                    strIndex), currChild);
                newChild.setChild('$', ((Internal)newChild).$.insert(s, strIndex
                    + 2));
                setChild(s.charAt(strIndex), newChild);
            }
            // currChild is not at the bottom of the trie, so we insert new
            // node, either
            // as a new leaf node, or as an internal node
            else {
                setChild(s.charAt(strIndex), currChild.insert(s, strIndex + 1));
            }
        }
        // If we get down here, we are out of characters in the string
        return this;
    }


    /**
     * @param s
     *            sequence to be inserted into the tree
     * @param strIndex
     *            index of the string that the internal node is looking at.
     * 
     *            inserts a sequence into the dollar node of the internal node
     *            or shuffles nodes in the dollar node.
     */
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


    /**
     * 
     * @param letter
     *            letter of the node you want to get
     * @return the node corresponding to the char inputed
     * 
     *         gets the child node based on the char inputed.
     */
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


    /**
     * 
     * @param letter
     *            Node to set the newChild to
     * @param newChild
     *            Node to set the letter node to
     * 
     *            Gets a new node as input and sets the node corresponding to
     *            the input char to the inputed node.
     */
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


    /**
     * @param s
     *            Sequence to be removed from the tree.
     * @param strIndex
     *            Index of the string we are looking at.
     * 
     *            removes the sequence from the tree.
     */
    @Override
    public Node remove(String s, int strIndex) {
        return removeHelp(s, strIndex);
    }


    /**
     * 
     * @param sequence
     *            Sequence being removed from the internal node
     * @param strIndex
     *            Index of the sequence we are looking at.
     * @return The node left after the sequence is removed
     * 
     *         recursively removes the sequence from the internal node of the
     *         tree.
     */
    private Node removeHelp(String sequence, int strIndex) {
        Node child = getChild(sequence.charAt(strIndex));
        if (child instanceof Leaf) {
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
        else if (child == Flyweight.getInstance()) {
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
    public void search(String s, int strPos, boolean exact) {
        searchHelper(s, strPos, exact);
    }


    /**
     * 
     * @param s
     *            string we are looking for in the tree
     * @param strPos
     *            index of the char in the sequence we are looking at.
     * @param exact
     *            true if looking for an exact match in the tree, false if we
     *            aren't
     */
    public void searchHelper(String s, int strPos, boolean exact) {
        Trie.nodeVisited();
        if (strPos < s.length()) {
            char childChar = s.charAt(strPos);
            Node child = getChild(childChar);
            child.search(s, strPos + 1, exact);
        }
        else if (exact) {
            Node Child = getChild(s.charAt(strPos));
            Child.search(s, strPos++, exact);
        }
        else {
            A.search(s, strPos, exact);
            C.search(s, strPos, exact);
            G.search(s, strPos, exact);
            T.search(s, strPos, exact);
            $.search(s, strPos, exact);
        }
    }


    /**
     * 
     * @return an array of the child nodes.
     * 
     *         Gets the child nodes of the internal nodes and returns them in an
     *         array
     */
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
    public void print(int tabIndex, String type) {
        String printTabs = "";
        for (int i = 0; i < tabIndex; i++) {
            printTabs = printTabs.concat("  ");
        }

        System.out.println(printTabs + "I");
        A.print(tabIndex + 1, type);
        C.print(tabIndex + 1, type);
        G.print(tabIndex + 1, type);
        T.print(tabIndex + 1, type);
        $.print(tabIndex + 1, type);

    }
}
