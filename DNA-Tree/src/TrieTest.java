import junit.framework.TestCase;

public class TrieTest extends TestCase {
    /**
     * test Insert
     */
    
    Trie tree;
    
    public void testInsert()
    {
        tree = new Trie();
        tree.insert("ACGT");
        tree.insert("AAAA");
        tree.insert("AA");
        tree.insert("AAACCCCGGTGAAAACGTA");
        tree.insert("ACTGGGAA");
        tree.remove("ACGT");
        tree.insert("ACCTT");
        tree.insert("ACTTA");
        tree.print("dump");
        tree.insert("TATA");
        tree.insert("TCG");
        tree.print("lengths");
        tree.print("stats");
        tree.search("AAAA$");
        tree.search("AA");
        tree.search("ACGT$");
    }

}
