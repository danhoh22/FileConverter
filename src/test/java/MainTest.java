import org.junit.Test;
import ru.vyatsu.Main;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;
import static ru.vyatsu.service.InputHandler.convert;

public class MainTest {
    @Test
    public void testConvert() throws IOException {
        String inputFile = String.valueOf(getClass().getClassLoader().getResource("data.xml")).replace("file:/", "");
        String outputFile = String.valueOf(getClass().getClassLoader().getResource("output.json")).replace("file:/", "");
        Main main = new Main();
        convert(inputFile, outputFile);
        assertTrue("Выходной файл не создан", new File(outputFile).exists());
    }
}
