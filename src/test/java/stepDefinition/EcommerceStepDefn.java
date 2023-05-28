package stepDefinition;

import java.io.IOException;

import com.factory.BaseDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.MobileMenuPg;
import pages.RegisterAccountPage;
import pages.TVMenuPage;

public class EcommerceStepDefn {
	LoginPage loginPage = new LoginPage(BaseDriver.getDriver());
	RegisterAccountPage regAcntPg = new RegisterAccountPage(BaseDriver.getDriver());
	TVMenuPage tvmenuPg = new TVMenuPage(BaseDriver.getDriver());
	@Given("user is at the login page")
	public void user_is_at_the_login_page() {
		BaseDriver.getDriver().get("http://live.techpanda.org/index.php/customer/account/login/");
	
	}

	@When("user provide {string} and {string}")
	public void user_provide_and(String username, String password) {
	    loginPage.sendUserName(username);
	    loginPage.sendPassword(password);
	}

	@When("click on Login button")
	public void click_on_login_button() {
		loginPage.clickOnloginBtn();
	}

	@Then("user should be navigated to Account page")
	public void user_should_be_navigated_to_account_page(DataTable dataTable) {
	    
	}
	
	//Mobile page test 1 Stepdefinitions
	/*
	 * 
	 * 
	 * 
	 * 
	 */
	HomePage homepg = new HomePage(BaseDriver.getDriver());
	MobileMenuPg mblepg = new MobileMenuPg(BaseDriver.getDriver());
	@Given("user is at the home page")
	public void user_is_at_the_home_page() {
		BaseDriver.getDriver().get("https://live.guru99.com");
	}
	
	@Then("verify title of homepage")
	public void verify_title_of_homepage() {
	String homepageTitle =homepg.getHomePgTitle();
	System.out.println("Title of HomePage is "+homepageTitle);
	}

	@When("user clicks on MobileMenu")
	public void user_clicks_on_mobile_menu() {
		homepg.clickOnMobileMenu();
	
	}

	@Then("verify the title of the MobilePage")
	public void verify_the_title_of_the_mobile_page() {
		String mobilepagetitle = mblepg.MobilePgTitle();
		System.out.println("Title of HomePage is "+mobilepagetitle);
	    
	}

	@When("In the list of all Mobile, Select SORT BY as dropdown with Name")
	public void in_the_list_of_all_mobile_select_sort_by_as_dropdown_with_name() {
	   mblepg.selectSortByDDMenu();
	}

	@Then("Verify all the Products are sorted by  name.")
	public void verify_all_the_products_are_sorted_by_name() throws IOException {
	    mblepg.captureScreenshot();
	}
	//test 3 scenario 2
		/*
		 * 
		 * 
		 * 
		 * 
		 */
	


	@When("click on \"ADD TO CART \"for Sony Xperia mobile in the list of all Mobile")
	public void click_on_add_to_cart_for_sony_xperia_mobile_in_the_list_of_all_mobile() {
		mblepg.addToCartSonyMobile();
	}

	@When("Change {string} value to {int}")
	public void change_value_to(String string, Integer int1) throws IOException {
		mblepg.enterQuantitySonyMob("1000");
		
	    
	}

	@When("click  \"UPDATE\"button")
	public void click_update_button() {
	    mblepg.clickOnUpdateBtn();
	}

	@Then("Verify the error message about quantity")
	public void verify_the_error_message_about_quantity() {
		String expectederrorqtymsg ="Some of the products cannot be ordered in requested quantity.";
		String AcualErrorMsgMobQty = mblepg.sonyMobileqtyErrorMsg();
		System.out.println(AcualErrorMsgMobQty);
		Assert.assertEquals(expectederrorqtymsg, AcualErrorMsgMobQty);
	   
	}

	@When("Click on {string} link in the footer of list of all mobiles")
	public void click_on_link_in_the_footer_of_list_of_all_mobiles(String string) {
		mblepg.clickOnEmptycart();
	    
	}

	@Then("Verify Cart is empty")
	public void verify_cart_is_empty() {
	 String ActualMsg=  mblepg.cartEmptyMsg();
	 System.out.println(ActualMsg);
	 String ExpectedEmptyCartMSg = "SHOPPING CART IS EMPTY";
	 Assert.assertEquals(ExpectedEmptyCartMSg, ActualMsg);
	}
	
	//test 3 Compare mobiles

    @When("In Mobile Product List, Click on Add to Compare for 2 Mobiles")
    public void in_mobile_product_list_click_on_add_to_compare_for_2_mobiles() throws Throwable {
        mblepg.selectMobilesForComparison();
    }
    
    @When("user clicks on Compare Button")
    public void user_clicks_on_compare_button() throws Throwable {
    	mblepg.clickonCompareButtonAndSwithWindows();
    }
    
    @Then("Verify the pop up window and check that the products are reflected in it")
    public void verify_the_pop_up_window_and_check_that_the_products_are_reflected_in_it() throws Throwable {
    	mblepg.verifyMobileComparisonWindow();
    
    }
    
    @And("Close the popup window")
    public void close_the_popup_window(){
    	mblepg.closeCompareWindow();
   
    }
    
    
    ///////////////Account Creation///////////////////////
   

        @Then("Account Registration done and wishlist shared succesfully")
        public void account_registration_done_and_wishlist_shared_succesfully() throws IOException{
        	homepg.clickOnMyAccntBtn();
        	loginPage.clickonCreateAccountBtn();
        	regAcntPg.sendUserInformation();
        	String expectedregistrationMsg = "Thank you for registering with Main Website Store.";
    		
        	Assert.assertEquals(expectedregistrationMsg, regAcntPg.getRegitrationMsg());
        	regAcntPg.getScreenshot();
        	
           
        }
        
        @And("Wishlist shared succefully")
        public void wishlist_shared_succefully() throws IOException {
        	homepg.clickTVMenu();
        	tvmenuPg.click_On_AddToWishList();
        	tvmenuPg.click_on_shareWishList();
        	tvmenuPg.sharingInformation("akshaydashpute63@gmail.com");
        	String ExpectedWishListSharedMsg= "Your Wishlist has been shared.";
        	Assert.assertEquals(ExpectedWishListSharedMsg, tvmenuPg.checkWishListSharedSuccessfully());
        	
        	//regAcntPg.getScreenshot();
        	
        	
         
        }

    }


