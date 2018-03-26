package pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;
import lib.Global;
import lib.TestData;
import lib.Utility;

public class LoginLogout {         
    
    @FindBy(xpath="//input[@id='userid']")
    WebElement edtUserName;    
    @FindBy(xpath="//input[@id='password']")
    WebElement edtPassword;    
    @FindBy(xpath="//button[contains(text(),'Sign In')]")
    WebElement btnLogIn;    
    @FindBy(xpath="//img[@id='_FOpt1:_UIScmil1u::icon']")
    WebElement imgCaret;    
    @FindBy(xpath="//a//span[contains(@class,'xjh')]")
    WebElement lnkUserName;    
    @FindBy(xpath="//a[contains(text(),'Sign Out')]")
    WebElement elmSighOut;        
    @FindBy(xpath="//button[@id='Confirm']")
    WebElement btnLogoutConfirm;    
    @FindBy(xpath="//button[text()='Yes']")
    WebElement btnWarning;
    
    
    @FindBy(xpath="//input[@id='username']")
    WebElement edtUserName_Move;    
    @FindBy(xpath="//input[@id='password']")
    WebElement edtPassword_Move;    
    @FindBy(xpath="//input[@id='Login']")
    WebElement btnLogIn_Move; 
  
  
    
    public LoginLogout(Utility util) throws Exception{
        //this.driver = driver;
        PageFactory.initElements(util.ng_returnDriver(), this);        
    }
    /*----------------------------------------------------------------------------
    Function Name    	: applicationURL
    Description     	: This function used to launch the application URL.    
    Author				:  
    Date of creation	:
	Date of modification:   
    ----------------------------------------------------------------------------*/        
    public void applicationURL( ) throws Exception {    	
        if(Global.objErr == "11"){
            return;
        }
    	try {    	
			TestData td = new TestData ();
			Global.objData = (HashMap) td.readTestData (Global.gTCID, Global.gstrClassName, Global.gstrMethodName);						
			Global.test.log(LogStatus.INFO,"Class and Method : "+ Global.gstrClassName +" . "+Global.gstrMethodName);
			Utility.ng_invokeBrowser("URL");
		} catch (Exception e) {
			Global.objErr = "11";			
		}		    
    }
    
    /*----------------------------------------------------------------------------
    Function Name    	: login
    Description     	: This function used to login to the application. 
    Author				:  
    Date of creation	:
	Date of modification:   
    ----------------------------------------------------------------------------*/ 
    public void login() throws Exception {
        if(Global.objErr == "11"){
            return;
        }   
    	try {
			TestData td = new TestData ();
			Global.objData = (HashMap) td.readTestData (Global.gTCID, Global.gstrClassName, Global.gstrMethodName);	    			
			Global.test.log(LogStatus.INFO,"Class and Method : "+ Global.gstrClassName +" . "+Global.gstrMethodName);    
			
			Utility.ng_verifyPage("Login","LoginCheck");
			Utility.ng_enterText(edtUserName,"User Name","UserNameSet");
			Utility.ng_enterTextPwd(edtPassword,"Password","PasswordSet");
			Utility.ng_clickWebElement(btnLogIn,"LogIn","LogInClick");	
			
		} catch (Exception e) {
			Global.objErr = "11";			
		}     
    }
    
    /*----------------------------------------------------------------------------
    Function Name    	: logout
    Description     	: This function used to logout the application.  
    Author				:  
    Date of creation	:
	Date of modification:
    ----------------------------------------------------------------------------*/
    public void logout() throws Exception {
		if(Global.objErr == "11"){			
		    return;
		} 
		try {
			TestData td = new TestData ();
			Global.objData = (HashMap) td.readTestData (Global.gTCID, Global.gstrClassName, Global.gstrMethodName);	    			
			Global.test.log(LogStatus.INFO,"Class and Method : "+ Global.gstrClassName +" . "+Global.gstrMethodName);
			
			Utility.ng_clickWebElement(lnkUserName, "User Name", "UserNameClick");
			//Utility.ng_waitImplicitly(5);
			//Utility.ng_clickWebElement(elmSighOut,"Sign Off","SignOffClick");
			Utility.ng_clickElementUsingJS(elmSighOut,"Sign Off","SignOffClick");			
			Utility.clickWarning(btnWarning);					    
			Utility.ng_clickWebElement(btnLogoutConfirm, "Logout Confirm", "LogoutConfirmClick");
			Utility.quitdriver();
		} catch (Exception e) {
			Global.objErr = "11";			
		}		   	    
	}
        
}
