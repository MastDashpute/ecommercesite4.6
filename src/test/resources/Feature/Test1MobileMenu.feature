Feature: Test Verify Item in Mobile List Page can be sorted by 'Name'

@MobileListSort
Scenario: Verify Item in Mobile List Page can be sorted by 'Name'
Given user is at the home page
Then verify title of homepage
When user clicks on MobileMenu
Then verify the title of the MobilePage
When In the list of all Mobile, Select SORT BY as dropdown with Name
Then Verify all the Products are sorted by  name.

@SonyExperia
Scenario: Verify that you cannot add more Product in cart than the product available in store(Error validation)
Given user is at the home page
When user clicks on MobileMenu
Then verify the title of the MobilePage
When click on "ADD TO CART "for Sony Xperia mobile in the list of all Mobile
And Change "QTY" value to 1000
And click  "UPDATE"button 
Then Verify the error message about quantity
When Click on "EMPTY CART" link in the footer of list of all mobiles
Then Verify Cart is empty

@compareMobiles
Scenario: Verify that you are ableto Copare two product
Given user is at the home page
When user clicks on MobileMenu
Then verify the title of the MobilePage
When In Mobile Product List, Click on Add to Compare for 2 Mobiles
When user clicks on Compare Button
Then Verify the pop up window and check that the products are reflected in it
And Close the popup window