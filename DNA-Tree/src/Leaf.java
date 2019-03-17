/**
 * @author Josh
 * @author Quinton
 * 
 * @version 3/17/2019
 *
 *          This is the implementation the Leaf Node inherited from Node
 */
public class Leaf implements Node {
    private String leafData;


    /**
     * 
     * @param s
     *            New value of leaf data
     * 
     *            This constructs a new leaf data with the value s.
     */
    Leaf(String s) {
        this.leafData = s;
    }


    /*
     * (non-Javadoc)
     * 
     * @see Node#print()
     */
    @Override
    public void print(int tabIndex, String type) {
        printHelper(tabIndex, type);
    }


    /**
     * 
     * @param tabIndex
     *            How many tabs to put before the sequence when it's being
     *            printed
     * @param type
     *            How to output the tree.
     * 
     *            Prints the tree based on the type.
     *            Dump for a dump of the tree.
     *            Lengths to print the length of the sequence as well as the
     *            sequence.
     *            Stats to print the statistics of the sequence along with the
     *            sequence.
     */
    private void printHelper(int tabIndex, String type) {
        String printTabs = "";
        for (int i = 0; i < tabIndex; i++) {
            printTabs = printTabs.concat("  ");
        }
        if (type.equals("dump")) {
            System.out.println(printTabs + this.leafData);
        }
        else if (type.equals("lengths")) {
            System.out.println(printTabs + this.leafData + " " + leafData
                .length());
        }
        else if (type.equals("stats")) {
            int aCount = 0;
            int cCount = 0;
            int gCount = 0;
            int tCount = 0;
            for (int i = 0; i < this.leafData.length(); i++) {
                if (this.leafData.charAt(i) == 'A') {
                    aCount++;
                }
                else if (this.leafData.charAt(i) == 'C') {
                    cCount++;
                }
                else if (this.leafData.charAt(i) == 'G') {
                    gCount++;
                }
                else if (this.leafData.charAt(i) == 'T') {
                    tCount++;
                }
            }

            double aRatio = 100 * ((double)aCount / this.leafData.length());
            double cRatio = 100 * ((double)cCount / this.leafData.length());
            double gRatio = 100 * ((double)gCount / this.leafData.length());
            double tRatio = 100 * ((double)tCount / this.leafData.length());

            String aString = String.format("%2.02f", aRatio);
            String cString = String.format("%2.02f", cRatio);
            String gString = String.format("%2.02f", gRatio);
            String tString = String.format("%2.02f", tRatio);

            System.out.println(printTabs + this.leafData + " A:" + aString
                + " C:" + cString + " G:" + gString + " T:" + tString);
        }
    }


    @Override
    public Node insert(String s, int strIndex) {
        return insertHelper(s, strIndex);
    }


    /**
     * 
     * @param s
     *            sequence to be inserted
     * @param strIndex
     *            index of the string being looked at
     * @return the new internal node made or the current leaf node
     * 
     *         This will construct a new internal node with the new data and the
     *         current leaf data if the sequences arent the same. Otherwise it
     *         returns the current leaf node and outputs an error.
     */
    private Node insertHelper(String s, int strIndex) {
        if (!this.leafData.equals(s)) {
            Trie.setInsertDepth(strIndex);
            return new Internal(s, strIndex, this.leafData);
        }
        else {
            System.out.println("Cannot insert a leaf node with the"
                + " exact same data of another node");
            Trie.setInsertDepth(-1);
            return this;
        }
    }


    @Override
    public Node remove(String s, int strIndex) {
        return removeHelper(s, strIndex);
    }


    /**
     * 
     * @param s
     *            sequence to be removed
     * @param strIndex
     *            index of the string being looked at.
     * @return the current node or the flyweight node.
     * 
     *         This removes the node if the sequences are the same, otherwise it
     *         outputs an error saying that the sequence doesn't exist and
     *         returns the current leaf node.
     */
    private Node removeHelper(String s, int strIndex) {
        if (this.leafData.equals(s)) {
            System.out.println("sequence " + s + " removed");
            return Flyweight.getInstance();
        }
        else {
            System.out.println("sequence" + s + "doesn't exist");
            return this;
        }
    }


    @Override
    public void search(String s, int strIndex, boolean exact) {
        searchHelper(s, strIndex, exact);
    }


    /**
     * 
     * @param s
     *            sequence being searched for.
     * @param strIndex
     *            index of the string being looked at
     * @param exact
     *            are we looking for an exact match or not
     * 
     *            This checks if the data in the node is the same as the
     *            sequence being searched for if exact is true. Otherwise, it
     *            checks to see if the leaf data at strIndex - 1 is the same as
     *            the last character of the search sequence
     */
    private void searchHelper(String s, int strIndex, boolean exact) {
        Trie.nodeVisited();
        if (exact) {
            if (this.leafData.equals(s)) {
                Trie.matchFound(s);
            }
        }
        else {
            if (this.leafData.charAt(strIndex - 1) == s.charAt(strIndex - 1)) {
                Trie.matchFound(this.leafData);
            }
        }
    }


    /**
     * 
     * @return The string stored in the leaf node.
     * 
     *         This gets the data in the leaf node.
     */
    public String getString() {
        return leafData;
    }


    /**
     * 
     * @param s
     *            new value of the node
     * 
     *            This sets the data of the leaf node to s.
     */
    public void setString(String s) {
        leafData = s;
    }

}
