@HTInfonova @UI @OrderingMobileOffer @Offer
Feature: MobileOffer1Option
  As a tester, I want to test the functionality of the Mobile offer with 1 option on the HT Infonova.

  @Author:Bernardo_Kopjar @UI
  Scenario Outline: Mobile <Offer> Offer With <Option> Option
    Given I navigate to "HT Infonova" page
    Then I should see "Login" page
    When I enter corresponding string into "Username" textbox
    And I enter corresponding string into "Password" textbox
    And I click on "Log In" button
    Then I should see "Main" page
    When I click on "Menu" button
    And I select "Customers" item in "Menu" list
    Then I should see "Customers" page
    When I enter corresponding string into "Search Customers" textbox
    And I click on "Search" button
    And I select corresponding "customer" in "Search for Customers" table
    Then I should see "Overview" page
    When I select "Account" option in "Customer Menu" list on left part of the page
    Then I should see "Profile" page
    And I should see "Account" list on left part of the page that is "enabled" and "not empty"
    When I select 'Subaccounts' option in "Account" list
    Then I should see "Subaccounts" page
    When I click on "Add ..." button
    And I select "New Account" item in "Add ..." list
    Then I should see "Address Check" page
    When I click on "Next" button
    Then I should see "Ok" button that is "enabled"
    When I click on "Ok" button
    Then I should see "Offer Selection" page
    When I click on Add To Cart button in Offers table for <Offer> offer
    Then I should see "Shopping Cart" button that is "enabled"
    And I should see "Recurring Gross Charge" label for "<Offer>" offer that contains corresponding string
    And I should see "Recurring Net Charge" label for "<Offer>" offer that contains corresponding string
    When I click on "Shopping Cart" button
    Then I should see "Shopping Cart Content" list that contains "<Offer>" string and is "enabled"
    And I should see "Offers Counter" label in "Shopping Cart" section that contains "1" string
    When I click on "Next" button
    Then I should see "Offer Configuration" page for <Offer> offer
    And I should see "Digital Minimal Contract Duration 24 Months" option in "Selected Features" table
    And I should see "Feature Filter" list on left part of the page that is "enabled"
    When I select "<FeatureCategory>" option in "Feature Filter" list on left part of the page
    And I select "<Option>" option in "Feature Group" list on left part of the page
    Then I should see "<Option>" option in "Selected Features" table
    And I should see "Recurring Gross Charge" label for "<Option>" option that contains corresponding string
    And I should see "Recurring Net Charge" label for "<Option>" option that contains corresponding string
    When I open up "Mobile Service [MOBILE_SERVICE]" section
    Then I should see "Get Number" button that is "enabled"
    When I click on "Get Number" button
    Then I should see "Numbers" table in "Select Number" popup that is "enabled" and "not empty"
    And I should see "Cancel" link in "Select Number" popup that is "enabled"
    When I select first option in Phone Number table in Select Number popup
    Then I should see "Phone Number" label that contains corresponding string
    And I should see "Next" button that is "enabled"
    When I click on "Next" button
    Then I should see "Customer Details" page
    When I enter "<Name>" string into "Displayed Name" textbox
    Then I should see "Customer Header" label that contains corresponding string
    And I should see "Next" button that is "enabled"
    When I click on "Next" button
    Then I should see "Payment Details" page
    When I click on "Validate Address" button
    And I select "Contact" item in "Validate Address" list
    Then I should see "Billing Address" label that contains corresponding string
    When I select "No" in "EDI bill media eligible" dropdown menu
    Then I should see "Region" textbox that is "enabled" and "not empty"
    When I enter "<Email>" string into "E-Mail" textbox
    And I enter "222" string into "Frame Contract ID" textbox
    Then I should see "Next" button that is "enabled"
    When I click on "Next" button
    Then I should see "Summary" page for <Offer> offer
    When I select "Terms and Conditions" checkbox
    Then I should see "Create Customer" button that is "enabled"
    When I click on "Create Customer" button
    Then I should see "Subaccounts" page

    @TestCaseCode:TC0025 @Xray:TES-99
    Examples: DL DA International World 120 Voice
      | Name        | Email           | Offer     | FeatureCategory                      | Option                                          |
      | HT Infonova | roxoft@mail.com | Digital L | Mobile Digital International Options | Digital Allowance International World 120 Voice |

    @TestCaseCode:TC0020 @Xray:TES-99
    Examples: DS Roaming World Data 500 MB Monthly Charge
      | Name        | Email           | Offer     | FeatureCategory                     | Option                                           |
      | HT Infonova | roxoft@mail.com | Digital S | Mobile Digital Roaming Data Options | Digital Roaming World Data 500 MB Monthly Charge |

    @TestCaseCode:TC0018 @Xray:TES-99
    Examples: DXS Additional National Data 10 GB Monthly Charge
      | Name        | Email           | Offer      | FeatureCategory      | Option                                            |
      | HT Infonova | roxoft@mail.com | Digital XS | Recurring Allowances | DXS Additional National Data 10 GB Monthly Charge |

    @TestCaseCode:TC0019 @Xray:TES-99
    Examples: DXS PP3 Sales Discount 24 Months
      | Name        | Email           | Offer      | FeatureCategory             | Option                           |
      | HT Infonova | roxoft@mail.com | Digital XS | Contract Sales Discounts 24 | DXS PP3 Sales Discount 24 Months |