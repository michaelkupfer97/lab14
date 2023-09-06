import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
/**
 * The main class that demonstrates the usage of the 'id' class and its methods.
 */
public class Main1 {
    /**
     * The entry point of the program.
     * @param args the command-line arguments
     * @throws IOException if an I/O error occurs while reading or writing the file
     */
    public static void main(String[] args) throws IOException {
        id one = new id("michael","2345");
        id two = new id("daniel","5933");
        id three = new id("oleg","1266");
        id five = new id("zohar","6678");
        id six = new id("ronen","998");
        id seven = new id("gal","5555");
        System.out.println(seven);
        File file = new File("myfile.txt");

        String data = """
                5933 daniel 
                1266 oleg 
                6678 zohar 
                5555 gal 
                2345 michael 
                2345 michael 
                2345 michael 
                """;
        Files.write(Path.of("myfile.txt"),data.getBytes());
        System.out.println("\noriginal data:---------------------");
        List<id> ids= id.readIdDataFromFIle("myfile.txt");
        for (id id : ids) {
            System.out.println(id.toString());
        }

        System.out.println("\nsorted data:---------------------");
        id.sordId(ids);

        System.out.println("\nremoved data:---------------------");
        id.removeId(ids);

        System.out.println("\nsorted reverse data:---------------------");
        id.sordbackId(ids);


    }
}