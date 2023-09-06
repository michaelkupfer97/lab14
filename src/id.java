import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
/**
 * Represents an ID with a name and value.
 */
public record id(String name, String id) {
    /**
     * Constructs an ID with the given name and value.
     * @param name the name associated with the ID
     * @param id   the value of the ID
     */
    public id(String name, String id) {
        try {
            if (Integer.parseInt(id) < 1000 || Integer.parseInt(id) > 9999) {
                throw new RuntimeException(name + " invalid id: " + id);
            }
        }catch (RuntimeException e){
            e.printStackTrace();
        }
        this.id = id;
        this.name = name;
    }
    /**
     * Reads ID data from a file and returns a list of IDs.
     * @param fileName the name of the file to read from
     * @return a list of IDs read from the file
     * @throws IOException if an I/O error occurs while reading the file
     */
    public static List<id> readIdDataFromFIle(String fileName) throws IOException {
        Path filePath = Paths.get(fileName);
        List<id> ids = new ArrayList<>();
        List<String> lines = Files.readAllLines(filePath);
        for (String line : lines) {
            String[] data = line.split(" ");
            if (data.length == 2) {
                id id = new id(data[1], data[0]);
                if (id != null)
                    ids.add(id);
            }
        }
        return ids;
    }

    public static void sordId(List<id> ids) {
        for (int i = 0; i < ids.size() - 1; i++) {
            for (int j = i+1; j < ids.size(); j++) {
                if (Integer.parseInt(ids.get(i).id) > Integer.parseInt(ids.get(j).id)) {
                    id temp = ids.get(i);
                    ids.set(i, ids.get(j));
                    ids.set(j, temp);
                }
            }
        }
        for (id id : ids) {
            System.out.println(id.toString());
        }
    }
    /**
     * Sorts the list of IDs in ascending order based on their values and prints them.
     * @param ids the list of IDs to sort and print
     */
    public static void removeId(List<id> ids) {
        for (int i = 0; i < ids.size() - 1; i++) {
            for (int j = i+1; j < ids.size(); j++) {
                if (Integer.parseInt(ids.get(i).id) == Integer.parseInt(ids.get(j).id)) {
                    ids.remove(ids.get(i));
                    j--;
                }
            }
        }
        for (id id : ids) {
            System.out.println(id.toString());
        }
    }
    /**
     * Removes duplicate IDs from the list and prints the remaining IDs.
     * @param ids the list of IDs to remove duplicates from and print
     */
    public static void sordbackId(List<id> ids) {
        for (int i = 0; i < ids.size() - 1; i++) {
            for (int j = i+1; j < ids.size(); j++) {
                if (Integer.parseInt(ids.get(i).id) > Integer.parseInt(ids.get(j).id)) {
                    id temp = ids.get(i);
                    ids.set(i, ids.get(j));
                    ids.set(j, temp);
                }
            }
        }
        for (int i = ids.size() - 1; i >= 0; i--)
            System.out.println(ids.get(i).toString());
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String id() {
        return id;
    }
}
