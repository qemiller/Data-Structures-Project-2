/**

 * @author Josh Rehm jrehm135
 * @author Quinton Miller qemiller
 * @version 1.6
 *
 * @param <K> Key value of the element.
 * @param <E> Element value of the element.
 */
public class DnaNode<K>
{
    private K key;
    private DnaNode<K> parent;
    
    enum nodeType {FLYWEIGHT, LEAF, INTERNAL};
    private nodeType nodeT;

    /**
     * Constructor
     */
    public DnaNode()
    {
        parent = null;
        nodeT = nodeType.FLYWEIGHT;
    }
    
    /**
     * make a new Node with key k and value val
     * @param k Key value of the element
     * @param val Element value of the element
     */
    public DnaNode(K k)
    {
        parent = null;
        key = k;
        nodeT = nodeType.FLYWEIGHT;
    }

    /**
     * key getter
     * @return Key value
     */
    public K key()
    {
        return key;
    }

    /**
     * set key value
     * @param k New key value
     * @return New key value
     */
    public K setKey(K k)
    {
        key = k;
        return key;
    }

    /**
     * return parent of left node. 
     *@return Parent node
     */
    public DnaNode<K> parent()
    {
        return parent;
    }
    
    /**
     * return parent of left node. 
     *@return Parent node
     */
    public nodeType getNode()
    {
        return nodeT;
    }
    
    /**
     * return parent of left node. 
     *@return Parent node
     */
    public void setAsLeaf()
    {
        nodeT = nodeType.LEAF;
    }
    
    /**
     * return parent of left node. 
     *@return Parent node
     */
    public void setAsInternal()
    {
        nodeT = nodeType.INTERNAL;
    }
    
    /**
     * return parent of left node. 
     *@return Parent node
     */
    public void setAsFlyweight()
    {
        nodeT = nodeType.FLYWEIGHT;
    }
}