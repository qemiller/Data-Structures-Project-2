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
    public void print(int tabIndex, String type) {
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
    public void search(
        String s,
        int strIndex,
        boolean exact,
        int nodesVisited) {
        Trie.nodeVisited();
        if (exact) {
            if (this.leafData.equals(s)) {
                Trie.matchFound(s);
            }
        }
        else {
            if (this.leafData.charAt(strIndex - 1) == s.charAt(strIndex - 1))
                Trie.matchFound(this.leafData);
        }

    }


    public String getString() {
        return leafData;
    }


    public void setString(String s) {
        leafData = s;
    }

}
