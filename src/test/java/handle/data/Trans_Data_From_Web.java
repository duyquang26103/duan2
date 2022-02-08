package handle.data;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.hrm.PageGeneratorManager;
import pageObjects.hrm.TdtPO;
import pageObjects.hrm.TranslatePO;
import vn.pipeline.Annotation;
import vn.pipeline.VnCoreNLP;
import vn.pipeline.Word;

public class Trans_Data_From_Web extends BaseTest {
    WebDriver driver;
    String data;


    @Test
    public void TC_01_Translate() throws IOException {
//		File folder = new File(projectPath+ "\\dataFile");
//		File[] listOfFiles = folder.listFiles();
//
//		for (int i = 0; i < listOfFiles.length; i++) {
//			File file = listOfFiles[i];
//			if (file.isFile() && file.getName().contains("input")) {
//				String content = FileUtils.readFileToString(file);
//				 data = content;
//			}
//		}

        String data = readInputFile();

        String[] annotators = {"wseg"};
        VnCoreNLP pipeline = new VnCoreNLP(annotators);
        Annotation annotation = new Annotation(data);
        pipeline.annotate(annotation);

        driver = getDriverBrowsers("hchrome", "https://hvdic.thivien.net/hv");
        TranslatePage = PageGeneratorManager.getTranslatePage(driver);
        Hashtable<String, String> dic = new Hashtable<String, String>();

        for (Word w : annotation.getWords()) {
            String word = w.getForm().replace("_", " ");
            System.out.print(word);
            TranslatePage.inputSearchTextBox(word);
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
        }

        System.out.println("\n" + data);
        TranslatePage.saveOutPutFile(data);
    }

    TranslatePO TranslatePage;
    TdtPO tdtPage;
}
