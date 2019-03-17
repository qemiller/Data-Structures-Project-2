import junit.framework.TestCase;

/**
 * 
 * @author Quinton Miller
 * @author Josh Rehm
 * @version 3/17/2019
 *
 *          This will test the Trie class.
 */
public class TrieTest extends TestCase {

    /**
     * This tests the tree against the given text document.
     */
    public void testGiven() {
        Trie dna = new Trie();
        assertTrue(dna.insert("ACGT") instanceof Leaf);
        dna.print("dump");
        assertTrue(dna.insert("AAAA") instanceof Internal);
        dna.print("dump");
        dna.insert("AA");
        dna.print("dump");
        dna.insert("AAACCCCGGTGAAAACGTA");
        dna.print("dump");
        dna.insert("ACTGGGAA");
        dna.print("dump");
        dna.remove("ACGT");
        dna.print("dump");
        dna.insert("ACCTT");
        dna.print("dump");
        dna.insert("ACTTA");
        dna.print("dump");
        dna.insert("TATA");
        dna.print("dump");
        dna.insert("TCG");
        dna.print("dump");
        dna.print("lengths");
        dna.print("stats");
        dna.search("AAAA$");
        dna.search("AA");
        dna.search("ACGT$");
    }


    /**
     * This tests the insert method of the trie
     */
    public void testInserts() {
        Trie dna = new Trie();
        // Test against bad sequences
        assertTrue(dna.insert("BBBB") instanceof Flyweight);
        assertTrue(dna.insert("ABBB") instanceof Flyweight);
        // Attempt to remove empty
        assertTrue(dna.remove("ACGT") instanceof Flyweight);
        // Add and test for multiple error
        assertTrue(dna.insert("ACGT") instanceof Leaf);
        assertTrue(dna.insert("ACGT") instanceof Leaf);
        // Remove after add
        assertTrue(dna.remove("ACGT") instanceof Flyweight);
        dna.insert("ACGT");
        // Add multiple and remove both
        assertTrue(dna.insert("AAGT") instanceof Internal);
        assertTrue(dna.remove("ACGT") instanceof Leaf);
        assertTrue(dna.remove("AAGT") instanceof Flyweight);
        dna.insert("ACGT");
        dna.insert("AAAA");
        dna.insert("AAGT");
        assertTrue(dna.remove("ACGT") instanceof Internal);
    }
}
