import java.io.File;
import java.util.Scanner;

/**
 * 
 * @author Quinton Miller
 * @author Josh Rehm
 * 
 * @version 3/19/2019
 * 
 *          This parses through the file and runs the trie based on the input.
 */
public class Parse {
    /**
     * 
     * @param fileName
     *            name of the file to parse through and run commands
     * 
     *            Runs commands in the file given from fileName and runs the
     *            given commands in trie.
     */
    public void parseFile(String fileName) {
        try {
            Scanner fileScan = new Scanner(new File(fileName));
            Trie tree = new Trie();
            while (fileScan.hasNextLine()) {
                String line = fileScan.nextLine();
                Scanner lineScan = new Scanner(line);
                if (!lineScan.hasNext()) {
                    lineScan.close();
                    continue;
                }
                String command = lineScan.next();
                String sequence;
                switch (command) {

                    case "insert":
                        if (lineScan.hasNext()) {
                            sequence = lineScan.next();
                            tree.insert(sequence);
                        }

                        lineScan.close();
                        break;

                    case "remove":
                        if (lineScan.hasNext()) {
                            sequence = lineScan.next();
                            tree.remove(sequence);
                        }
                        else {
                            System.out.println("no sequence found");
                        }
                        lineScan.close();
                        break;

                    case "search":
                        if (lineScan.hasNext()) {
                            sequence = lineScan.next();
                            tree.search(sequence);
                        }
                        else {
                            System.out.println("# of nodes visited: 0");
                            System.out.println("no sequence found");
                        }
                        lineScan.close();
                        break;

                    case "print":
                        if (lineScan.hasNext()) {
                            String type = lineScan.next();
                            tree.print(type);
                        }
                        else {
                            tree.print("dump");
                        }
                        lineScan.close();
                        break;
                    default:
                        System.out.println("Unrecognized input.");
                }

            }
            fileScan.close();
        }
        catch (Exception FileNotFoundException) {
            // Throw this if you can't find the file.
        }
    }
}
