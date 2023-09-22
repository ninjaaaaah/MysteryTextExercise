import java.io.*;

public class Main {
    private static final File FILE = new File("out.txt");

    public static void main(String[] args) throws IOException {
        Parser left = new Parser("left.txt");
        Parser right = new Parser("right.txt");
        Writer writer = new BufferedWriter(new FileWriter(FILE));
        int nextLeft, nextRight;

        while (true) {
            nextLeft = left.getNextNumber();
            nextRight = right.getNextNumber();
            if (nextLeft + nextRight < 0) break;

            writer.write((char) nextLeft+nextRight);
        }
        writer.flush();
    }
}