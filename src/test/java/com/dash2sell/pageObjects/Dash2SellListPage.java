package com.dash2sell.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Dash2SellListPage {
	WebDriver ldriver;
	
	public Dash2SellListPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	
	}
	
	@FindBy(xpath="//img[@ src='/public/images/homepage/icons/dash2sell.png']")
	WebElement lnkDash2Sell;
	
	@FindBy(linkText="Clear")
	WebElement clear;
	
	@FindBy(linkText="Apply")
	WebElement apply;

	@FindBy(id="dash2selltablesdash2sellListing_c1_filter")
	WebElement textId;

	@FindBy(id="dash2selltablesdash2sellListing_c1")
	List<WebElement> idColoumn;

	
	@FindBy(id="dash2selltablesdash2sellListing_c2_filter")
	WebElement textDesc;
	
	@FindBy(id="dash2selltablesdash2sellListing_c2")
	List<WebElement> idDescription;
	
	
	
	public void clickDash2Sell() {
		lnkDash2Sell.click();		
	}
	
	public void clickClear() {
		clear.click();
	}
	
	public void clickApply() {
		apply.click();
	}
	
	public void sendID(String id) {
		
		textId.sendKeys(id);
		
		
	}
	public void clickEnter() {
		textId.sendKeys(Keys.ENTER);
	}
	

	public List<Integer> getIdList() {

		List<Integer> idList = new ArrayList<Integer>();
		for(WebElement ele: idColoumn)  {
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
	
	public List<String> getDateList() {

		List<String> dateList = new ArrayList<String>();
		for(WebElement ele: idColoumn)  {
			List<WebElement> rows = ele.findElements(By.className("row"));
			for(WebElement row: rows) {
					System.out.println("---> "+row.getText());
					dateList.add(row.getText());
			}
			
		}
		System.out.println("Total Date result: "+ dateList.size());
		return dateList;
	
	}

	/*public void sendDescription(String desc) {
		
			textDesc.sendKeys(desc);
		
	}
	
	public void getDescriptionList() {
		
		for(WebElement ele: idDescription)  {
		    System.out.println(ele.getText()); 
		  
		}
	}*/
	
	}
