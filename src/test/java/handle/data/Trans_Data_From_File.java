package handle.data;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pageObjects.PageGeneratorManager;
import pageObjects.TranslatePO;
import vn.pipeline.Annotation;
import vn.pipeline.VnCoreNLP;
import vn.pipeline.Word;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Random;

public class Trans_Data_From_File extends BaseTest {
    WebDriver driver;
    String data;
    @Test
    public void TC_01_Translate_From_File() throws IOException {
        String data = readInputFile();
        data = BaseTest.readDicFileNoTrans(data);
        BaseTest.saveOutPutFile(data);
    }

}
