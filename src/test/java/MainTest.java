import org.junit.Test;
import ru.vyatsu.Main;
import java.io.File;
import static org.junit.Assert.*;
public class MainTest {
    @Test
    public void testConvert() {
        String inputFile = System.getProperty("user.dir")+"\\src\\test\\resources\\data.xml";
        String outputFile = System.getProperty("user.dir")+"\\src\\test\\resources\\output.json";
        Main main = new Main();
        main.Convert(inputFile, outputFile);
        assertTrue("Выходной файл не создан", new File(outputFile).exists());
    }
}
