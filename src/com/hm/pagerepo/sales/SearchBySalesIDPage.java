package com.hm.pagerepo.sales;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hm.generic.GenericUtils;

/**
 * @author ab63599
 * 
 */
public class SearchBySalesIDPage {
	WebDriver driver;

	@FindBy(xpath = "//a[@href='/ccshms/hmsessionparamservlet?Role_HierId=ADMIN_2078_ABM']")
	private WebElement abmLink;
	@FindBy(xpath = "//input[@name='agentid']")
	private WebElement salesIdTxtBx;
	@FindBy(name = "Submit")
	private WebElement searchBtn;
	@FindBy(css = "html>body>table>tbody>tr>td>table>tbody>tr>td>table>tbody>tr>td>table>tbody>tr>td>a>font>b")
	private WebElement rmgConsumerLink;

	public SearchBySalesIDPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	/**
	 * Method for clicking on ABMLink
	 */
	public void clickonABMLink() {
		abmLink.click();
		driver.switchTo().frame("Menu");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("agent_main");
	}

	/**
	 * Method for Entering Sales Id
	 * 
	 * @param sid
	 */
	public void enterSalesId(String sid) {

		salesIdTxtBx.sendKeys(sid);
	}

	/**
	 * Method for Clicking on Search Button
	 */
	public void clickonsearch() {
		searchBtn.click();
	}

	/**
	 * Method for clicking on Selected Agent RMG
	 */
	public void clickOnRMGLink() {
		rmgConsumerLink.click();
		GenericUtils.takeScreenshot(driver, "detailsOfSearch");

	}
}
