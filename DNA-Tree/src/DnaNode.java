/**

 * @author Josh Rehm jrehm135
 * @author Quinton Miller qemiller
 * @version 1.6
 *
 * @param <K> Key value of the element.
 * @param <E> Element value of the element.
 */
public class DnaNode<K, E>
{
    private K key;
    private E element;
    private DnaNode<K, E> left;
    private DnaNode<K, E> right;
    private DnaNode<K, E> parent;

    /**
     * Constructor
     */
    public DnaNode()
    {
        left = null;
        right = null;
        parent = null;
    }
    
    /**
     * make a new Node with key k and value val
     * @param k Key value of the element
     * @param val Element value of the element
     */
    public DnaNode(K k, E val)
    {
        left = null;
        right = null;
        parent = null;
        key = k;
        element = val;
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
     * get element
     * @return Element value
     */
    public E element()
    {
        return element;
    }
    
  
    /**
     * set element of node
     * @param v New element value
     * @return New element value
     */
    public E setElement(E v)
    {
        element = v;
        return element;
    }

    /**
     * get left child of current node
     * @return Left node
     */
    public DnaNode<K, E> left()
    {
        return left;
    }

    /**
     * set left child of current node
     * @param p Parent node
     * @return Parent node's new left node
     */
    public DnaNode<K, E> setLeft(DnaNode<K, E> p)
    {
        if (p != null) {
            p.parent = this;
        }
        left = p;
        return left;
    }

    /**
     * get right child of current node
     * @return Right node
     */
    public DnaNode<K, E> right()
    {
        return right;
    }

    /**
     * set the right child of current node
     * @param p Parent node
     * @return Parent node's new right node
     */
    public DnaNode<K, E> setRight(DnaNode<K, E> p)
    {
        if (p != null) {
            p.parent = this;
        }
        right = p;
        return right;
    }

    /**
     * return parent of left node. 
     *@return Parent node
     */
    public DnaNode<K, E> parent()
    {
        return parent;
    }
}