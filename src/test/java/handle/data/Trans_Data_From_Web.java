package handle.data;

import java.io.*;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.PageGeneratorManager;
import pageObjects.TranslatePO;
import vn.pipeline.Annotation;
import vn.pipeline.VnCoreNLP;
import vn.pipeline.Word;

public class Trans_Data_From_Web extends BaseTest {
    WebDriver driver;
    String data;
    String projectPath = System.getProperty("user.dir");

    @Test
    public void TC_01_Translate() throws IOException, InterruptedException {

        // Check file exist
        File yourFile = new File(projectPath + "\\dataFile\\dic.txt");
        try {
            yourFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Random rand = new Random();
        int randomNum = rand.nextInt(3);

        String data = readInputFile();

        String[] annotators = {"wseg"};
        VnCoreNLP pipeline = new VnCoreNLP(annotators);
        Annotation annotation = new Annotation(data);
        pipeline.annotate(annotation);

        driver = getDriverBrowsers("chrome", "https://hvdic.thivien.net/hv");
        TranslatePage = PageGeneratorManager.getTranslatePage(driver);
        Hashtable<String, String> dic = new Hashtable<String, String>();

        //read file
        TranslatePage.readDicFile(dic);

        // dic.txt rong
        try (FileWriter writer = new FileWriter(projectPath + "\\dataFile\\dic.txt");
             BufferedWriter bw = new BufferedWriter(writer)) {
            bw.write("");
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }


        for (Word w : annotation.getWords()) {
            String word = w.getForm().replace("_", " ");
            System.out.print(word);
            TranslatePage.inputSearchTextBox(word.toLowerCase());
            Thread.sleep(randomNum);
            TranslatePage.clickOnTraHanVietButton();
            TranslatePage.getKQHVText(word, dic);
        }

        driver.quit();


        System.out.println("\n" + dic);

        Enumeration<String> e = dic.keys();
        while (e.hasMoreElements()) {
            // Getting the key of a particular entry
            String key = e.nextElement();
            data = data.replace(key, dic.get(key));

            try (FileWriter writer = new FileWriter(projectPath + "\\dataFile\\dic.txt", true);
                 BufferedWriter bw = new BufferedWriter(writer)) {

                bw.write(key + "-" + dic.get(key) + "\n");

            } catch (IOException ex) {
                System.err.format("IOException: %s%n", ex);
            }

        }

//        System.out.println("\n" + data);
//        TranslatePage.saveOutPutFile(data);
    }

    TranslatePO TranslatePage;
}
