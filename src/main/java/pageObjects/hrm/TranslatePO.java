package pageObjects.hrm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import PageUIs.TdtPageUI;
import PageUIs.TransPageUI;
import commons.BasePage;

public class TranslatePO extends BasePage {
    WebDriver driver;

    public TranslatePO(WebDriver driver) {
        this.driver = driver;
    }

    public void inputSearchTextBox(String valueText) {
        waitForElementVisible(driver, TransPageUI.INPUT_TEXTBOX);
        sendKeyToElement(driver, TransPageUI.INPUT_TEXTBOX, valueText);
    }

    public void clickOnTraHanVietButton() {
//        scrollToElement(driver,TransPageUI.TRA_HV_BUTTON);
        waitForElementVisible(driver, TransPageUI.TRA_HV_BUTTON);
        clickToElement(driver, TransPageUI.TRA_HV_BUTTON);
    }

    public void getKQHVText(String word, Hashtable<String, String> dic) {

        try {
            String translatedWord = getElementText(driver, TransPageUI.KQ_HV_TEXT);
            dic.put(word, translatedWord);
            System.out.println(" - 1");
        } catch (Exception ex) {
            System.out.println(" - 0");
        }

    }



    public void saveOutPutFile(String data) {
    	String projectPath = System.getProperty("user.dir");
        try{
//            FileWriter fstream = new FileWriter(System.currentTimeMillis() + "out.txt");
            FileWriter fstream = new FileWriter(projectPath + "\\dataFile\\output.txt");
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(data);
            out.close();
        }catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }
    }

}


