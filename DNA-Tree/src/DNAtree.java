/**
 * 
 * @author Quinton Miller
 * @author Josh Rehm
 * 
 *         This will run the DNA Tree functions based on the file input.
 *
 */
public class DNAtree {
    /**
     * 
     * @param args
     *            arguments from the function call
     * 
     *            runs the DNA tree program with the file from args.
     */
    public static void main(String[] args) {
        String fileName = args[0];
        Parse DNAParse = new Parse();
        DNAParse.parseFile(fileName);
    }
}
