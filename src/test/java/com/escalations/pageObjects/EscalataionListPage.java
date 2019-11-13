package com.escalations.pageObjects;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

	public class EscalataionListPage {
		WebDriver ldriver;
		
	public EscalataionListPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(xpath="//*[@id=\"escalationstablesescalationListing_c1_filter\"]")
	WebElement filterEscalationId;
	
	@FindBy(xpath="//*[@id=\"escalationstablesescalationListing_c1\"]")
	List <WebElement> escalationIdColoumn;
	
	@FindBy(xpath="//*[@id=\"escalationstablesescalationListing_c1\"]/div/span")
	List <WebElement> escalationIdAllValue;
	
	@FindBy(xpath="//*[@id=\"escalationstablesescalationListing_c2_filter\"]")
	WebElement filterEscalationStatus;
	
	@FindBy(xpath="//*[@id=\"escalationstablesescalationListing_c2\"]/div/span")
	List <WebElement> coloumnEscalationStatus;
	
	@FindBy(xpath="//*[@id=\"escalationstablesescalationListing_c3_filter\"]")
	WebElement filteEscalationClient;
	
	@FindBy(xpath="//*[@id=\"escalationstablesescalationListing_c3\"]/div/span")
	List <WebElement> coloumnEscalationClient;
	
	@FindBy(xpath="//*[@id=\"escalationstablesescalationListing_c5_filter\"]")
	WebElement flterEscalationSummary;
	
	@FindBy(xpath="//*[@id=\"escalationstablesescalationListing_c5\"]/div/span")
	List <WebElement> coloumnEscalationSummary;
	
	@FindBy(xpath="//*[@id=\"escalationstablesescalationListing_c4\"]/div[2]/a/img")
	WebElement iconCalenderDueDate;
	
	@FindBy(xpath="//*[@id='body']/div[12]/div[2]/table/thead/tr[1]/td")
	WebElement startMonthYear;
	
	@FindBy(xpath="//*[@id=\"body\"]/div[12]/div[3]/table/thead/tr[2]/td[2]")
	WebElement endLeftAero;
	
	@FindBy(xpath="//*[@id=\"body\"]/div[12]/div[3]/table/thead/tr[2]/td[4]")
	WebElement endRightAero;
	
	@FindBy(xpath="//*[@id=\"body\"]/div[12]/div[3]/table/thead/tr[1]/td")
	WebElement endMonthYear;
	
	@FindBy(xpath="//*[@id=\"body\"]/div[12]/div[2]/table/thead/tr[2]/td[2]")
	WebElement startLeftAero;
	
	@FindBy(xpath="//*[@id=\"body\"]/div[12]/div[2]/table/thead/tr[2]/td[4]")
	WebElement startRightAero;
	
	@FindBy(xpath="//*[@id=\"body\"]/div[12]/div[2]/table/tbody/tr/td")
	List<WebElement> calStartAllDate;
	
	@FindBy(xpath="//*[@id=\"body\"]/div[12]/div[3]/table/tbody/tr/td")
	List <WebElement> calEndAllDate;
	
	@FindBy(xpath="//*[@id=\"escalationstablesescalationListing_c4\"]/div/span")
	List <WebElement> listDueDate;
	
	
	@FindBy(xpath="//*[@id=\"escalationstablesescalationListing_c2\"]/div[3]")
	WebElement listFirstStatus;
	
	@FindBy(xpath="//*[@id=\"escalationstablesescalationListing_c4\"]/div[3]")
	WebElement listFirstDueDate;
	
	@FindBy(id="Summary")
	WebElement txtSummery;
	
	@FindBy(xpath="//*[@id=\"escalationstablesescalationListing_c1\"]/div[1]/div[1]/a")
	WebElement linkescalationId;
	
	@FindBy(xpath="//*[@id=\"escalationstablesescalationListing_c1\"]/div[3]")
	WebElement listFirstId;
	
	@FindBy(linkText="Clear")
	WebElement clear;
	
	@FindBy(linkText="Apply")
	WebElement apply;
	
	@FindBy(xpath="//*[@id=\"body\"]/div[12]/div[4]/a[2]")
	WebElement calApply;
	
	@FindBy(xpath="//*[@id=\"controlA\"]/div[2]/div[2]/ul/li/a")
	WebElement btnNoAction;
	
	@FindBy(xpath="//*[@id=\"controlA\"]/div[2]/div[3]/ul/li[1]/a")
	WebElement btnApproveEscalation;
	
	@FindBy(xpath="/html/body/div[2]/div[1]/div/ul/li[1]/a/span[1]/i")
	WebElement listTab;
	
	
	
	
	public WebElement listTab() {
		return listTab;
	}
	
	public void clickListTab() {
		listTab.clear();
	}
	
	public WebElement getFirstID() {
		return listFirstId;
	}
	
	
	public void clickNoActionButton() {
		btnNoAction.click();
	}
	
	public void clickApproveEscalationButton() {
		btnApproveEscalation.click();
	}
	
	public List<WebElement> getDueDateList() {
		return listDueDate;
	}
	public void clickCalApply() {
		calApply.click();
	}
	
	
	public String getCurrentStartMonthYear() {
		return startMonthYear.getText();
	}
	
	public String getCurrentEndMonthYear() {
		return endMonthYear.getText();
	}
	
	public List <WebElement> getStartAllDate() {
		return calStartAllDate;
	
	}
	
	public List <WebElement> getEndAllDate() {
		return calEndAllDate;
		
	}
	
	public void clickCalenderDueDate() {
		iconCalenderDueDate.click();
	}
	
	public void clickStartLeftAero() {
		startLeftAero.click();
	}
	
	public void clickStartRightAero() {
		startRightAero.click();
	}
	
	public void clickEndLeftAero() {
		endLeftAero.click();
	}
	
	public void clickEndRightAero() {
		endRightAero.click();
	}
	
	public void sendEscId(String escId) {
		filterEscalationId.sendKeys(escId);
	}
	
	public void clickClear () {
		clear.click();
	}
	
	public void clickApply() {
		apply.click();
	}
	
	public void selectStatus(String status) {
		Select select=new Select(filterEscalationStatus);
		select.selectByVisibleText(status);
	}
	
	
	public void selectClient(String client) {
		Select select=new Select(filteEscalationClient);
		select.selectByVisibleText(client);
	}
	
	public void clickFirstElement() {
		listFirstStatus.click();
	}
	
	public void sortEscalationId() {
		linkescalationId.click();
	}
	
	public void sendSummary(String sum) {
		flterEscalationSummary.sendKeys(sum);
	}
	
	public String getText() {
		String dueDate=listFirstDueDate.getText();
		System.out.println(dueDate);
		return dueDate;
	}
	
	public String getSummery() {
	String summery = txtSummery.getText();
	System.out.println(summery);
	return summery;
	
	}
	
	public String getId() {
		String id = listFirstId.getText();
		return id;
		
	}
	
	
	public List <WebElement> getStatus() {
		List<WebElement> statusCol=coloumnEscalationStatus;
		for(WebElement element : coloumnEscalationStatus){
            System.out.println(element.getText());
		}
		return statusCol;
		
	}
	
		public List <WebElement> getSummary() {
		List<WebElement> summarCol=coloumnEscalationSummary;
		for(WebElement element : coloumnEscalationSummary){
            System.out.println(element.getText());
		}
		return summarCol;
		
	}

	
	public List<WebElement> getClient() {
		List <WebElement> web=coloumnEscalationClient;
		for(WebElement element : coloumnEscalationClient){
            System.out.println(element.getText());
		}
		return web;
		
	}
	
	
	public List<Integer> getIdList() {

		List<Integer> idList = new ArrayList<Integer>();
		for(WebElement ele: escalationIdColoumn)  {
			List<WebElement> rows = ele.findElements(By.className("row"));
			for(WebElement row: rows) {
				try {
					System.out.println("---> "+row.getText());
					idList.add(Integer.parseInt(row.getText()));
				}catch(NumberFormatException e) {
					System.out.println(NumberFormatException.class.getSimpleName() + " : "+e.getMessage());
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
			
		}
		
		System.out.println("Total result: "+ idList.size());
		return idList;
	}
	
	}
