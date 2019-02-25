/** DnaTree implementation for Dictionary ADT */
/**
 * @author Josh Rehm
 * @version 1.6
 *
 * @param <K> Key value of the tree.
 */
public class DnaTree<K extends Comparable<? super K>>
{
    private DnaNode<K> root; // Root of DnaTree
    private DnaNode<K> flyweight; // Flyweight
    private int nodecount; // Size of DnaTree

    /** Constructor */
    DnaTree()
    {
        root = null;
        nodecount = 0;
    }

    /**
     * Insert a record into the tree.
     * 
     * @param k Key value of the record.
     * @param e The record to insert.
     */
    public void insert(K k)
    {
        root = inserthelp(root, k);
        nodecount++;
    }

    /**
     * @param rt Current node in insert.
     * @param k Key value of the record.
     * @param e The record to insert.
     * @return Returns node inserted
     */
    private DnaNode<K> inserthelp(DnaNode<K> rt, K k)
    {
        if (rt == null)
        {
            return new DnaNode<K>(k);
        }
        if (rt.key().compareTo(k) > 0)
        {
            rt.setLeft(inserthelp(rt.left(), k));
        } 
        else
        {
            rt.setRight(inserthelp(rt.right(), k));
        }
        return rt;
    }
    
    /**
     * Remove a record from the tree.
     * 
     * @param k Key value of record to remove.
     * @return Record removed, or null if there is none.
     */
    public E remove(K k)
    {
        E temp = searchhelp(root, k); // find it
        if (temp != null)
        {
            root = removehelp(root, k); // remove it
            nodecount--;
        }
        return temp;
    }
    
    /**
     * Remove a node with key value k
     * 
     * @return The tree with the node removed
     */
    private DnaNode<K> removehelp(DnaNode<K> rt, K k)
    {
        if (rt == null)
        {
            return null;
        }
        if (rt.key().compareTo(k) > 0)
        {
            rt.setLeft(removehelp(rt.left(), k));
        } 
        else if (rt.key().compareTo(k) < 0)
        {
            rt.setRight(removehelp(rt.right(), k));
        } 
        else
        { // Found it, remove it
            
            if (rt.left() == null)
            {
                return rt.right();
            } 
            else if (rt.right() == null)
            {
                return rt.left();
            } 
            else
            { // Two children
                DnaNode<K> temp = getmin(rt.right());
                rt.setElement(temp.element());
                rt.setKey(temp.key());
                rt.setRight(deletemin(rt.right()));
            }
        }
        return rt;
    }
}