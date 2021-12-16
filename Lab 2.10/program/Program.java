
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Program {
    public static void main(String[] argv) {
        try {
            if (argv.length != 1)
                throw new Exception("You must provide a program as input.");

            Reader reader = new InputStreamReader(new FileInputStream(argv[0]));
            SyntaxAnalyzer sa = new SyntaxAnalyzer(reader);

            System.out.println(sa.SA_LR());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}