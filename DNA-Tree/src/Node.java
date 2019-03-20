/**
 * 
 */

/**
 * @author Josh
 * @author Quinton
 * @version 3/17/2019
 *
 *          This is the declaration of the Node class the implementation of
 *          these functions can be found in the Flyweight, Internal, and Leaf
 *          classes.
 */
public interface Node {
    /**
     * 
     * @param s
     *            The sequence being inserted into the tree.
     * @param strIndex
     *            index of the string being looked at.
     * @return The nodes left after the insertion has been done.
     * 
     *         inserts a sequence into the tree recursively.
     */
    public Node insert(String s, int strIndex);


    /**
     * 
     * @param s
     *            Sequence to be removed from the tree.
     * @param strIndex
     *            Index of the string being looked at.
     * @return Nodes left after the removal of the sequence.
     * 
     *         Removes a sequence from the tree.
     */
    public Node remove(String s, int strIndex);


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
    public void print(int tabIndex, String type);


    /**
     * 
     * @param s
     *            Sequence to search the tree for
     * @param strIndex
     *            index of the string sequence being looked at
     * @param exact
     *            do we want an exact match of the sequence or not
     * 
     *            This will search the tree for the sequence and will look for
     *            the given sequence based on the exact flag.
     *            If exact is true it will look for the exact sequence in the
     *            tree. If exact is false then it will look for all the
     *            sequences that start with the sequence.
     */
    public void search(String s, int strIndex, boolean exact);
}
