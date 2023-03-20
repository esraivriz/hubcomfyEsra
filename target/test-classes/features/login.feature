@login
Feature: Login Test

  Scenario: TC_001 As a vendor, email, and password must be entered and My Account must appear in the system

    Given User goes to hubcomfyUrl
    And   User clicks Sign In
    And   User enters a valid email in the email box
    And   User enters the valid password in the password box
    And   User click the SIGN IN button
    Then  The user confirms that they went to the My Account page
    And   User quits page
@login_02
  Scenario Outline: : TC_002 As a vendor, email, and password must be entered and My Account must appear in the system(Negative Test)

    Given User goes to hubcomfyUrl
    And User clicks Sign In
    And User enters "<invalid email>" and "<invalid password>" from use cases
    And User click the SIGN IN button
    And User confirms that they cannot go to the My Account page
    Examples:
      | invalid email          | invalid password |
  #    | 16project.qa@gmail.com | 02Team.20        |
      | 16project.qagmail.com |  02Team.2022|
  #  | 16project.qa@.com | Team.2023 |

@login3
Scenario: TC_003 Orders, Downloads, addresses, account information, who list and Checkout should be visible

  Given User goes to hubcomfyUrl
  And   User clicks Sign In
  And   User enters a valid email in the email box
  And   User enters the valid password in the password box
  And   User click the SIGN IN button
  Then  Click on the My Account link
  Then  Verifies the visibility of Orders
  Then  Corrects the visibility of the Downloads text
  Then  Verifies the visibility of Addresses
  Then  Verifies the visibility of Account details
  Then  Verifies the visibility of the Wishlist text
  Then  Verifies the visibility of the Logout text


  @LoginTC_004
  Scenario: TC-004 Under the Dashboard; Store manager, orders, downloads, addresses, account details, appointments, wishlist, Support tickets, follow-ups, and checkout should be available.
    Given User goes to hubcomfyUrl
    And User clicks Sign In
    And User enters a valid email in the email box
    And User enters the valid password in the password box
    And User click the SIGN IN button
    And Click on the My Account link
    Then Store manager confirms that the text is there
    Then Orders confirm that the text is there
    Then Downloads confirm that the text is there
    Then Addresses confirm that there is writing
    Then Confirms the existence of account details
    Then Confirms that there is an Appointments sign
    Then Wishlist confirms that there is writing
    Then Confirms that there are support tickets
    Then Followings confirms that the text exists
    Then Confirms that there is a logout sign
    And User quits page
