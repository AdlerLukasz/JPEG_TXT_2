import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReadSave {


    public static void main(String[] args) throws IOException {


    String line;
try(
    Stream<String> lines = Files.lines(Paths.get("/Users/mac/DEV/LOG.txt")))


    {
        line = lines.skip(10).findFirst().get();
    }
}

}
