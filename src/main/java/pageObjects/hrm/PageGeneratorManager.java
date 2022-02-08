package pageObjects.hrm;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

	private static TdtPO tdtPage;
	private static TranslatePO translatePage;


	private PageGeneratorManager() {

	}

	public static TdtPO getTdtPage(WebDriver driver) {
		return new TdtPO(driver);
	}
	
	public static TranslatePO getTranslatePage(WebDriver driver) {
		return new TranslatePO(driver);
	}
	
}
