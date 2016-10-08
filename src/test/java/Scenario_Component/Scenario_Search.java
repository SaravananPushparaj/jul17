package Scenario_Component;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic_Component.Base_Class;
import PageObject_Component.PageObject_Search;

public class Scenario_Search extends Base_Class {
	
	static Logger log=Logger.getLogger(Scenario_Search.class);
	SoftAssert sAssert= new SoftAssert();
	
	
	@Test(dataProvider="dp_InvalidSearch", dataProviderClass=DataProvider_Component.DataProvider_Search.class,groups={"smoke"})
	public void testInvalidSearch(String TC_ID, String Order,String Search_Item, String Exp_Result) throws IOException, InterruptedException
	{
		log.info("Executing the Testcase " + TC_ID +"Order is "+Order);
		
		Start_Server();
		Init_app();
		
		PageObject_Search BS_Pob=new PageObject_Search(driver);
		
		Explicit_wait(BS_Pob.Searchbtn, 25);
		BS_Pob.Click_Searchbtn();
		
		Explicit_wait(BS_Pob.Searchtxtbox, 25);
		BS_Pob.Enter_Searchtxtbox(Search_Item);
				
		Explicit_wait(BS_Pob.Invalid_msg, 25);
		String Actual_Result = BS_Pob.get_Invalidmsg();
		
		if(Actual_Result.equals(Exp_Result))
		{
			log.info("Passed as Expected Result is "+Exp_Result+ " Actual Result is "+Actual_Result);
			Snapshot1(TC_ID,Order);
		}
		else
		{
			log.info("Failed as Expected Result is "+Exp_Result+ " Actual Result is "+Actual_Result);
			sAssert.fail("Failed as Expected Result is "+Exp_Result+ " Actual Result is "+Actual_Result);
			Snapshot1(TC_ID,Order);
		}
		
		Stop_Server();
		sAssert.assertAll();
		
		
		
	}
	
	@Test(dataProvider="dp_ValidSearch", dataProviderClass=DataProvider_Component.DataProvider_Search.class,groups={"regression"})
	public void testValidSearch(String TC_ID, String Order,String Search_Item, String Exp_Result) throws IOException, InterruptedException
	{
		log.info("Executing the Testcase " + TC_ID +"Order is "+Order);
		
		Start_Server();
		Init_app();
		
		PageObject_Search BS_Pob=new PageObject_Search(driver);
		
		Explicit_wait(BS_Pob.Searchbtn, 25);
		BS_Pob.Click_Searchbtn();
		
		Explicit_wait(BS_Pob.Searchtxtbox, 25);
		BS_Pob.Enter_Searchtxtbox(Search_Item);
				
		Explicit_wait(BS_Pob.Valid_msg, 25);
		String Output = BS_Pob.get_Validmsg();
		
		String Actual_Result = Output.replace(" products", "");
		
		if(Actual_Result.equals(Exp_Result))
		{
			log.info("Passed as Expected Result is "+Exp_Result+ " Actual Result is "+Actual_Result);
			Snapshot1(TC_ID,Order);
		}
		else
		{
			log.info("Failed as Expected Result is "+Exp_Result+ " Actual Result is "+Actual_Result);
			sAssert.fail("Failed as Expected Result is "+Exp_Result+ " Actual Result is "+Actual_Result);
			Snapshot1(TC_ID,Order);
		}
		
		Stop_Server();
		sAssert.assertAll();
		
		
		
	}

}
