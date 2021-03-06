package handle.data;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.PageGeneratorManager;
import pageObjects.TdtPO;

public class Get_Data_From_Web extends BaseTest {
	WebDriver driver;
	static String data;

	@Test
	public void TC_01_Get_Content() throws IOException{
		driver = getDriverBrowsers("Chrome", "https://www.tdtu.edu.vn/tin-tuc/2022-01/dai-hoc-ton-duc-thang-chuc-toa-dam-voi-phai-doan-thuong-truc-nuoc-chxhcn-viet-nam");
		tdtPage = PageGeneratorManager.getTdtPage(driver);
		String a = tdtPage.getContent();
		driver.close();

		driver = getDriverBrowsers("Chrome", "https://www.tdtu.edu.vn/tin-tuc/2022-01/dai-hoc-ton-duc-thang-cong-bo-va-trao-quyet-dinh-bo-nhiem-chuc-danh-pho-giao-su");
		tdtPage = PageGeneratorManager.getTdtPage(driver);
		String b = tdtPage.getContent();
		driver.close();

		driver = getDriverBrowsers("Chrome", "https://www.tdtu.edu.vn/tin-tuc/2022-01/dai-hoc-ton-duc-thang-2021-mot-nam-nhin-lai");
		tdtPage = PageGeneratorManager.getTdtPage(driver);
		String c = tdtPage.getContent();
		driver.close();

		data = a+b+c;
		tdtPage.createSaveDataInFile(this.data);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	TdtPO tdtPage;
}
