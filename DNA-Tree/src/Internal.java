/**
 * 
 */

/**
 * @author Josh Rehm
 * @author Quinton Miller
 * @version 3/17/2019
 *
 */
public class Internal implements Node {

    private Node a;
    private Node c;
    private Node g;
    private Node t;
    private Node dollar;


    /**
     * default constructor for internal.
     */
    Internal() {
        a = Flyweight.getInstance();
        c = Flyweight.getInstance();
        g = Flyweight.getInstance();
        t = Flyweight.getInstance();
        dollar = Flyweight.getInstance();
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
        a = Flyweight.getInstance();
        c = Flyweight.getInstance();
        g = Flyweight.getInstance();
        t = Flyweight.getInstance();
        dollar = Flyweight.getInstance();

        insert(curData, strIndex);
        insert(s, strIndex);
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
     * @return Node left after the insertion.
     * 
     *         inserts a sequence into an internal node
     */

    public Node insertHelper(String s, int strIndex) {
        if (strIndex < s.length()) {
            Node currChild = getChild(s.charAt(strIndex));
            // We have found the bottom of the tree, now we must reorganize
            if (currChild instanceof Leaf && strIndex + 1 == s.length()) {
                if (((Leaf)currChild).getString().equals(s)) {
                    ((Leaf)currChild).insert(s, strIndex);
                }
                else {
                    Internal newChild = new Internal();
                    newChild.setChild(((Leaf)currChild).getString().charAt(
                        strIndex + 1), currChild);
                    newChild.setChild('$', ((Internal)newChild).dollar.insert(s,
                        strIndex + 2));
                    setChild(s.charAt(strIndex), newChild);
                }
            }
            // currChild is not at the bottom of the trie, so we insert new
            // node, either
            // as a new leaf node, or as an internal node
            else {
                setChild(s.charAt(strIndex), currChild.insert(s, strIndex + 1));
            }
        }
        else {
            insertDollar(s, strIndex);
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
    private void insertDollar(String s, int strIndex) {
        if (dollar instanceof Flyweight) {
            dollar = dollar.insert(s, strIndex + 1);
        }
        else if (((Leaf)dollar).getString().equals(s)) {
            ((Leaf)dollar).insert(s, strIndex);
        }
        else {
            // Swap and continue
            String temp = ((Leaf)dollar).getString();
            ((Leaf)dollar).setString(s);
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
                return a;
            case 'C':
                return c;
            case 'G':
                return g;
            case 'T':
                return t;
            default:
                // No action intended otherwise.
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
                a = newChild;
                break;
            case 'C':
                c = newChild;
                break;
            case 'G':
                g = newChild;
                break;
            case 'T':
                t = newChild;
                break;
            case '$':
                dollar = newChild;
                break;
            default:
                // No action intended otherwise
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
                a = a.remove(sequence, 0);
            }

            else if (sequence.charAt(strIndex) == 'C') {
                c = c.remove(sequence, 0);
            }

            else if (sequence.charAt(strIndex) == 'G') {
                g = g.remove(sequence, 0);
            }

            else if (sequence.charAt(strIndex) == 'T') {
                t = t.remove(sequence, 0);
            }
        }
        else if (child == Flyweight.getInstance()) {
            System.out.println("sequence " + sequence + " does not exist");
            return this;
        }
        else if (strIndex == sequence.length() - 1) {
            setChild(sequence.charAt(strIndex), ((Internal)child).dollar.remove(
                sequence, 0));
            
            Node collapse = Flyweight.getInstance();
            for (Node childNode : ((Internal)child).getChildNodes()) {
                if (childNode instanceof Internal) {
                    child = this;
                }
                else if (childNode instanceof Leaf) {
                    if (collapse == Flyweight.getInstance()) {
                        collapse = childNode;
                    }
                    else {
                        child = this;
                    }
                }
            }
            child = collapse;
        }
        else {
            setChild(sequence.charAt(strIndex), child.remove(sequence, strIndex
                + 1));
        }

        Node collapse = Flyweight.getInstance();
        for (Node childNode : getChildNodes()) {
            if (childNode instanceof Internal) {
                return this;
            }
            else if (childNode instanceof Leaf) {
                if (collapse == Flyweight.getInstance()) {
                    collapse = childNode;
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
            Node childNode = getChild(s.charAt(strPos - 1));
            if (childNode instanceof Internal) {
                ((Internal)this).dollar.search(s, strPos - 1, exact);
            }
            else {
                childNode.search(s, strPos - 1, exact);
            }
        }
        else {
            a.search(s, strPos, exact);
            c.search(s, strPos, exact);
            g.search(s, strPos, exact);
            t.search(s, strPos, exact);
            dollar.search(s, strPos, exact);
        }
    }


    /**
     * 
     * @return an array of the child nodes.
     * 
     *         This method creates and returns an array of the child nodes.
     */
    private Node[] getChildNodes() {
        Node[] array = new Node[5];
        array[0] = a;
        array[1] = c;
        array[2] = g;
        array[3] = t;
        array[4] = dollar;
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
        a.print(tabIndex + 1, type);
        c.print(tabIndex + 1, type);
        g.print(tabIndex + 1, type);
        t.print(tabIndex + 1, type);
        dollar.print(tabIndex + 1, type);

    }
}
