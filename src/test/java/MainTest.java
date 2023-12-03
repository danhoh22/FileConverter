import org.junit.Test;
import ru.vyatsu.Main;

import java.io.File;

import static org.junit.Assert.*;

public class MainTest {
    @Test
    public void testConvert() {
        String inputFile = String.valueOf(getClass().getClassLoader().getResource("data.xml")).replace("file:/", "");
        String outputFile = String.valueOf(getClass().getClassLoader().getResource("output.json")).replace("file:/", "");
        Main main = new Main();
        main.convert(inputFile, outputFile);
        assertTrue("Выходной файл не создан", new File(outputFile).exists());
    }
}
