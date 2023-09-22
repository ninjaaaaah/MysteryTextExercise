import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Parser {
    private final ArrayList<String> tokens = new ArrayList<>();
    private final Iterator<String> curr;
    public Parser(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))){
            while (br.ready()) {
                String line = br.readLine();
                tokens.addAll(Arrays.asList(line.split("\\s+")));
            }
        } catch (IOException e) {
            throw new RuntimeException(String.format("problem reading from file %s.", filename), e);
        }

        curr = tokens.iterator();
    }

    public int getNextNumber() {
        while (curr.hasNext()) {
            String next = curr.next();
            try {
                return Integer.parseInt(next);
            } catch (NumberFormatException e) {
                System.out.printf("%s", next);
            }
        }
        return -1;
    }
}
