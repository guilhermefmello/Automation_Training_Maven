Feature: Login

Scenario Outline: Login saucedemo.com Test Scenario

//Saucedemo Demo Website UI for training automation 

Given that the user is already on the saucedemo Login Page
And the title of saucedemo Login page is SWAGLABS
When the user enters the User name "<username>"
And the user enters the Password "<password>"
And the user clicks on Login button
Then the user is brought to Products page  
And the user is logged in


Examples:
#Diferent users for saucedemo login. The password is the same for all users.

	|    username   |   password   |
	| standard_user | secret_sauce |
#	|locked_out_user| secret_sauce |
#	| problem_user  | secret_sauce |
# | performance_glitch_user | secret_sauce |