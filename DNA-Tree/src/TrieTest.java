import junit.framework.TestCase;

public class TrieTest extends TestCase {
    public void testGiven(){
        Trie DNA = new Trie();
        assertTrue(DNA.insert("ACGT") instanceof Leaf);
        DNA.print("dump");
        assertTrue(DNA.insert("AAAA") instanceof Internal);
        DNA.print("dump");
        DNA.insert("AA");
        DNA.print("dump");
        DNA.insert("AAACCCCGGTGAAAACGTA");
        DNA.print("dump");
        DNA.insert("ACTGGGAA");
        DNA.print("dump");
        DNA.remove("ACGT");
        DNA.print("dump");
        DNA.insert("ACCTT");
        DNA.print("dump");
        DNA.insert("ACTTA");
        DNA.print("dump");
        DNA.insert("TATA");
        DNA.print("dump");
        DNA.insert("TCG");
        DNA.print("dump");
        DNA.print("lengths");
        DNA.print("stats");
        DNA.search("AAAA$");
        DNA.search("AA");
        DNA.search("ACGT$");
    }
    
    public void testInserts(){
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
}