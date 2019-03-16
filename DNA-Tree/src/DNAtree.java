
public class DNAtree {
    public static void main(String[] args)
    {
        String fileName = args[0];
        Parse DNAParse = new Parse();
        DNAParse.parseFile(fileName);
    }
}
