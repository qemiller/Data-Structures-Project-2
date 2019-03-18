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
    public void testBasics(){
        Trie DNA = new Trie();
        //Test empty dumps
        DNA.print("dump");
        DNA.print("lengths");
        DNA.print("stats");
        //Test against bad sequences
        assertTrue(DNA.insert("BBBB") instanceof Flyweight);
        assertTrue(DNA.insert("ABBB") instanceof Flyweight);
        //Attempt to remove empty
        assertTrue(DNA.remove("ACGT") instanceof Flyweight);
        //Add and test for multiple error
        assertTrue(DNA.insert("ACGT") instanceof Leaf);
        assertTrue(DNA.insert("ACGT") instanceof Leaf);
        //Remove after add
        assertTrue(DNA.remove("ACGT") instanceof Flyweight);
        DNA.insert("ACGT");
        //Add multiple and remove both
        assertTrue(DNA.insert("AAGT") instanceof Internal);
        assertTrue(DNA.remove("ACGT") instanceof Leaf);
        assertTrue(DNA.remove("AAGT") instanceof Flyweight);
        DNA.insert("ACGT");
        DNA.insert("AAAA");
        DNA.insert("AAGT");
        assertTrue(DNA.remove("ACGT") instanceof Internal);
    }
    
    public void testInserts1() {
        Trie DNA = new Trie();
        DNA.insert("A");
        DNA.insert("AA");
        //AA properly placed, but when AC added it is placed wrong
        DNA.insert("AC");
    }
    
    public void testInserts2() {
        Trie DNA = new Trie();
        DNA.insert("A");
        DNA.insert("AA");
        DNA.insert("AC");
        DNA.insert("AG");
        DNA.insert("AT");
        //Further example where AA gets deleted
        DNA.insert("AAA");
        DNA.insert("AAC");
        DNA.insert("AAG");
        DNA.insert("AAT");
    }
}
