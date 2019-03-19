import java.util.Random;
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
        assertTrue(dna.insert("AAAA") instanceof Internal);
        dna.insert("AA");
        dna.insert("AAA");
        dna.insert("AAACCCCGGTGAAAACGTA");
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
        dna.search("AAACCCCGGTGAAAACGTAT$");
        dna.insert("AAACCCCG");
        dna.insert("AAACCC");
        dna.insert("AAAAT");
        
    }


    /**
     * This tests the insert method of the trie
     */

    public void testBasics() {
        Trie dna = new Trie();
        // Test empty dumps
        dna.print("dump");
        dna.print("lengths");
        dna.print("stats");
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


    /**
     * tests the insert method again
     */

    public void testInserts1() {
        Trie dna = new Trie();
        assertTrue(dna.insert("AAA") instanceof Leaf);
        dna.insert("ACA");
        // AA properly placed, but when AC added it is placed wrong
        dna.insert("AC");
        assertTrue(dna.insert("AC") instanceof Internal);
    }


    /**
     * tests insert again.
     */

    public void testInserts2() {
        Trie dna = new Trie();
        assertTrue(dna.insert("AA") instanceof Leaf);
        dna.insert("AA");
        dna.insert("C");
        dna.insert("A");
        dna.insert("AA");
        dna.remove("A");
        dna.insert("AA");
        dna.insert("AAA");
        dna.insert("AA");
        dna.insert("A");
        dna.insert("AA");
    }
    
    /**
     * This will randomly generate sequences to be inserted into the tree.
     */
    public void testRandomSeq() {
        Trie dna = new Trie();
        Random randy = new Random();
        String alphabet = "ACGT";
        char arr1[] = new char[1];
        char arr2[] = new char[2];
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 1; j++) {
                arr1[j] = alphabet.charAt(randy.nextInt(alphabet.length()));
            }
            String dnaString1 = new String(arr1);
            dna.insert(dnaString1);
            for (int k = 0; k < 2; k++) {
                arr2[k] = alphabet.charAt(randy.nextInt(alphabet.length()));
            }
            String dnaString2 = new String(arr2);
            assertTrue(dna.insert(dnaString2) instanceof Internal);
        }
        dna.print("stats");
    }
    
    /**
     * Tests the insert function against random inputs.
     */
    public void testRandom()
    {
        Trie dna = new Trie();
        dna.insert("T");
        dna.insert("TG");
        dna.insert("G");
        dna.insert("CG");
        dna.insert("C");
        assertTrue(dna.insert("CG") instanceof Internal);
        
    }
}
