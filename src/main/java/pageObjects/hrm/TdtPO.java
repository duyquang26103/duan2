package pageObjects.hrm;

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

//		try {
//			File myObj = new File(projectPath + "\\dataFile\\input.txt");
//			if (myObj.createNewFile()) {
//				System.out.println("File created: " + myObj.getName());
//			} else {
//				System.out.println("File already exists.");
//			}
//		} catch (IOException e) {
//			System.out.println("An error occurred.");
//			e.printStackTrace();
//		}

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

//		String[] annotators = { "wseg"};
//		VnCoreNLP pipeline = new VnCoreNLP(annotators);
//		String str = null;
//		BufferedReader br = new BufferedReader(new FileReader("dataFile/input.txt"));
//		try {
//			StringBuilder sb = new StringBuilder();
//			String line = br.readLine();
//
//			while (line != null) {
//				sb.append(line);
//				sb.append(System.lineSeparator());
//				line = br.readLine();
//			}
//			str = sb.toString();
//		} finally {
//			br.close();
//		}

//		Annotation annotation = new Annotation(str);
//		pipeline.annotate(annotation);
//
//		// Write to file
//		PrintStream outputPrinter = new PrintStream("dataFile/output.txt");
//		pipeline.printToFile(annotation, outputPrinter);
//
//		// You can also get a single sentence to analyze individually
//		Sentence firstSentence = annotation.getSentences().get(0);

	}
	

	}

