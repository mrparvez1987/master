package com.projects.templates.testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dashManagement.utilities.BaseClass;
import com.dashManagement.utilities.XLUtils;

public class AllFieldTypeTestCases extends BaseClass {
	
	//Store Template Test Cases
	
	@Test(dataProvider="AllFieldData")
	public void validateStoreAllField(String user,String pass,String desc,String fieldType,String cap,String optional,String minvalue,String maxvalue,String comp,String value,
			String fieldType2,String cap2,String optional2,String loose2,String fieldType3,String cap3,String optional3,String edate,String ldate,String fieldType4,String cap4,String optional4,
			String fieldType5,String cap5,String optional5,String aApprove,String internal,String loose5,String fieldType6,String cap6,String optional6,String maxValue6,String loose6,
			String fieldType7,String cap7,String optional7,String loose7,String fieldType8,String cap8,String optional8,String exceptionType) throws Exception {
	
			TC_StoreTemplatesPageTest_002 testClass=new TC_StoreTemplatesPageTest_002(); 	
		
			testClass.loginFeature(user, pass);
			testClass.commonNumberField(desc,fieldType,cap,optional,minvalue,maxvalue,comp,value);
			testClass.commonStoreElementLooseAttachmentField(fieldType2,cap2,optional2,loose2);
			testClass.coomonDateField(fieldType3,cap3,optional3,edate,ldate);
			testClass.commonInstructionField(fieldType4,cap4,optional4);
			testClass.commonSignatureField(fieldType5,cap5,optional5,aApprove,internal,loose5);
			testClass.commonTextField(fieldType6,cap6,optional6,maxValue6,loose6);
			testClass.commonPictureField(fieldType7,cap7,optional7,loose7);
			testClass.commonExceptionField(fieldType8,cap8,optional8,exceptionType);

}
			
			@DataProvider(name="AllFieldData")
			public Object[][] getAllFieldData() throws IOException {
				Object data[][]=XLUtils.getData("AllFieldData.xlsx");
				return data;
			}
			
	
	
	
	@Test(dataProvider="AllFieldData2")
	public void validateStoreAllField2(String user,String pass,String desc,String fieldType,String cap,String optional,String comp,String value,
			String fieldType2,String cap2,String optional2,String loose2,String resText,String fieldType3,String cap3,String optional3,String minamount,String maxamount,
			String fieldType4,String cap4,String optional4,String hyperadd,String fieldType5,String cap5 ,String optional5,String scanType,String fieldType6,String cap6 ,String optional6,String featurelink,
			String fieldType7,String cap7,String optional7,String fieldType8,String cap8,String optional8) throws Exception {
		
			TC_StoreTemplatesPageTest_002 testClass=new TC_StoreTemplatesPageTest_002(); 	
			
			testClass.loginFeature(user, pass);
			testClass.commonShopcomField(desc, fieldType, cap, optional, comp, value);
			testClass.commonListField(fieldType2,cap2,optional2, loose2, resText);
			testClass.commonCurrencyField(fieldType3,cap3,optional3,minamount,maxamount);
			testClass.commonHyperLinkField(fieldType4,cap4,optional4,hyperadd);
			testClass.commonScanTypeField(fieldType5,cap5,optional5,scanType);
			testClass.commonFeatureLinkType(fieldType6,cap6,optional6,featurelink);
			testClass.commonScreenWrapperField(fieldType7,cap7,optional7);
			testClass.commonInLineField(fieldType8,cap8,optional8);
		
		
	}
	
			@DataProvider(name="AllFieldData2")
			public Object[][] getAllFieldData2() throws IOException {
				Object data[][]=XLUtils.getData("AllFieldData2.xlsx");
				return data;
			}
	
			
			
	//Item template Test Cases
	
	@Test(dataProvider="AllFieldData")
	public void validateItemAllField(String user,String pass,String desc,String fieldType,String cap,String optional,String minvalue,String maxvalue,String comp,String value,
			String fieldType2,String cap2,String optional2,String loose2,String fieldType3,String cap3,String optional3,String edate,String ldate,String fieldType4,String cap4,String optional4,
			String fieldType5,String cap5,String optional5,String aApprove,String internal,String loose5,String fieldType6,String cap6,String optional6,String maxValue6,String loose6,
			String fieldType7,String cap7,String optional7,String loose7,String fieldType8,String cap8,String optional8,String exceptionType) throws Exception {
		
			TC_StoreTemplatesPageTest_002 testClass=new TC_StoreTemplatesPageTest_002(); 
			TC_ItemTemplatesPageTest_003 itemClass=new TC_ItemTemplatesPageTest_003();
			
			itemClass.loginFeature(user, pass);
			testClass.commonNumberField(desc,fieldType,cap,optional,minvalue,maxvalue,comp,value);
			testClass.commonStoreElementLooseAttachmentField(fieldType2,cap2,optional2,loose2);
			testClass.coomonDateField(fieldType3,cap3,optional3,edate,ldate);
			testClass.commonInstructionField(fieldType4,cap4,optional4);
			testClass.commonSignatureField(fieldType5,cap5,optional5,aApprove,internal,loose5);
			testClass.commonTextField(fieldType6,cap6,optional6,maxValue6,loose6);
			testClass.commonPictureField(fieldType7,cap7,optional7,loose7);
			testClass.commonExceptionField(fieldType8,cap8,optional8,exceptionType);


}
	
	
	@Test(dataProvider="AllFieldData2")
	public void validateItemAllField2(String user,String pass,String desc,String fieldType,String cap,String optional,String comp,String value,
			String fieldType2,String cap2,String optional2,String loose2,String resText,String fieldType3,String cap3,String optional3,String minamount,String maxamount,
			String fieldType4,String cap4,String optional4,String hyperadd,String fieldType5,String cap5 ,String optional5,String scanType,String fieldType6,String cap6 ,String optional6,String featurelink,
			String fieldType7,String cap7,String optional7,String fieldType8,String cap8,String optional8) throws Exception {
			
			TC_StoreTemplatesPageTest_002 testClass=new TC_StoreTemplatesPageTest_002(); 
			TC_ItemTemplatesPageTest_003 itemClass=new TC_ItemTemplatesPageTest_003();
			
			
			itemClass.loginFeature(user, pass);
			testClass.commonShopcomField(desc, fieldType, cap, optional, comp, value);
			testClass.commonListField(fieldType2,cap2,optional2, loose2, resText);
			testClass.commonCurrencyField(fieldType3,cap3,optional3,minamount,maxamount);
			testClass.commonHyperLinkField(fieldType4,cap4,optional4,hyperadd);
			testClass.commonScanTypeField(fieldType5,cap5,optional5,scanType);
			testClass.commonFeatureLinkType(fieldType6,cap6,optional6,featurelink);
			testClass.commonScreenWrapperField(fieldType7,cap7,optional7);
			testClass.commonInLineField(fieldType8,cap8,optional8);
			
			
	}
	
	
}