package pageObjects;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Hashtable;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import PageUIs.TdtPageUI;
import PageUIs.TransPageUI;
import commons.BasePage;

public class TranslatePO extends BasePage {
    String projectPath = System.getProperty("user.dir");
    WebDriver driver;

    public TranslatePO(WebDriver driver) {
        this.driver = driver;
    }

    public void inputSearchTextBox(String valueText) {
        waitForElementVisible(driver, TransPageUI.INPUT_TEXTBOX);
        sendKeyToElement(driver, TransPageUI.INPUT_TEXTBOX, valueText.toLowerCase());
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

    public void readDicFile(Hashtable<String, String> dic){
//        Read file
        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader(projectPath + "\\dataFile\\dic.txt"))) {

            String line = bufferedReader.readLine();
            while (line != null) {
                System.out.println("doc:" + line);

                // Read key value
                Scanner scan = new Scanner(line);
                //Initialize the string delimiter
                scan.useDelimiter("-");

                dic.put(scan.next(), scan.next());
                //content.replace(scan.next(),scan.next());
                scan.close();

                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("hashtable: " + dic);
    }



    }




