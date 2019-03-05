
import java.io.File;
import java.util.Scanner;

public class parse {
    public void parseFile(String fileName)
    {
        try
        {
            Scanner sc = new Scanner (new File(fileName));
            while(sc.hasNextLine())
            {
                String command = sc.next();
                String sequence;
                switch(command)
                {
                    case "insert":
                        sequence = sc.next();
                        
                        break;
                }
            }
        }
        catch(Exception FileNotFoundException)
        {
            //Throw this if you can't find the file.
        }
    }
}
