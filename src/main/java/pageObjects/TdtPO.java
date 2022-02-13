package pageObjects;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import PageUIs.TdtPageUI;
import commons.BasePage;
import vn.pipeline.Annotation;
import vn.pipeline.Sentence;
import vn.pipeline.VnCoreNLP;
import vn.pipeline.Word;

public class TdtPO extends BasePage {
	WebDriver driver;

	public TdtPO(WebDriver driver) {
		this.driver = driver;
	}

	public String getContent() {
		return getElementText(driver, TdtPageUI.CONTENT_TDT);
	}

	public void createSaveDataInFile(String content) throws IOException {
		String projectPath = System.getProperty("user.dir");


		try {
			Writer out = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(projectPath + "\\dataFile\\input.txt"), "UTF-8"));
			try {
				out.write(content);
			} finally {
				out.close();
			}

			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}
	

	}

