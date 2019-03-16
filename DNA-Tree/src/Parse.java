
import java.io.File;
import java.util.Scanner;

public class Parse {
    public void parseFile(String fileName) {
        try {
            Scanner fileScan = new Scanner(new File(fileName));
            Trie tree = new Trie();
            while (fileScan.hasNextLine()) {
                String line = fileScan.nextLine();
                Scanner lineScan = new Scanner(line);
                if(!lineScan.hasNext())
                {
                    lineScan.close();
                    continue;
                }
                String command = lineScan.next();
                String sequence;
                switch (command) {
                    
                    case "insert":
                        sequence = lineScan.next();
                        tree.insert(sequence);
                        lineScan.close();
                        break;

                    case "remove":
                        sequence = lineScan.next();
                        tree.remove(sequence);
                        lineScan.close();
                        break;
                        
                    case "search":
                        sequence = lineScan.next();
                        if(sequence.charAt(sequence.length() - 1) == '$')
                        {
                            sequence = sequence.substring(0, sequence.length() - 1);
                            tree.search(sequence, 0, true, 0);
                        }
                        else
                        {
                            tree.search(sequence, 0, false, 0);
                        }
                        lineScan.close();
                        break;
                    
                    case "print":
                        if(lineScan.hasNext())
                        {
                            String type = lineScan.next();
                            tree.print(type);
                        }
                        else
                        {
                            tree.print("dump");
                        }
                        lineScan.close();
                        break;    
                }
                
            }
            fileScan.close();
        }
        catch (Exception FileNotFoundException) {
            // Throw this if you can't find the file.
        }
    }
}
