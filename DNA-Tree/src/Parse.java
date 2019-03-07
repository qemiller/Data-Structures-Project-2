
import java.io.File;
import java.util.Scanner;

public class Parse {
    public void parseFile(String fileName) {
        try {
            Scanner sc = new Scanner(new File(fileName));
            Trie tree = new Trie();
            while (sc.hasNextLine()) {
                String command = sc.next();
                String sequence;
                switch (command) {
                    
                    case "insert":
                        sequence = sc.next();
                        tree.insert(sequence);
                        break;

                    case "remove":
                        sequence = sc.next();
                        tree.remove(sequence);
                        break;
                }
            }
            sc.close();
        }
        catch (Exception FileNotFoundException) {
            // Throw this if you can't find the file.
        }
    }
}
