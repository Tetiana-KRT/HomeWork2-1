@Regression
Feature: Desktop Checkout for Guest User
  As a customer
  I want to be able proceed to checkout
  So that I can specify my delivery and payment details and place the order

  Scenario: Proceed to checkout, final review and place order as guest user
    Given Anonymous user opens Home page
    And User searches for "Thinking in Java"
    And User is redirected to a Search page
    And Search results contain the book "Thinking in Java"
    And Search results contain the book "Thinking Java Part I"
    And Search results contain the book "Core Java Professional"
    And User applies the following search filters
      | Price range  | Availability     | Language     | Format   |
      | 30 € +       | In Stock         |English       |Paperback |
    And Search results contain the book "Thinking in Java"
    And Search results contain the book "Think Java"
    And Search results contain the book "Thinking Recursively with Java"
    And Search results contain the book "Java and Algorithmic Thinking for the Complete Beginner"
    And Search results contain only 4 books
    And User clicks 'Add to basket' button for product with name "Thinking in Java"
    And User selects 'Basket/Checkout' in basket pop-up
    And User is redirected to a Basket page
    And Basket order summary is as following:
      | Delivery cost | Total   |
      | FREE          | 63,39 € |
    And User clicks 'Checkout' button on 'Basket' page
    And Checkout order summary is as following:
      | Sub-total | Delivery | VAT    | Total   |
      | 63,39 €   | FREE     | 0,00 € | 63,39 € |
    And User populates e-mail address as a new customer: "test@user.com"
    And User clicks 'Set address manually' button
    And User populates full name: "John Dou"
    And User populates country: "Ukraine"
    And User fills delivery address information manually:
      | Address line 1   | Address line 2   | Town/City | County/State | Postcode |
      | Random address 1 | Random address 2 | Kyiv      | Random State | 01001    |
    And 'Payment' section is disabled for editing
    When User clicks 'Continue to payment' button on checkout
    And 'Delivery Address' and 'Billing Address' sections are disabled for editing
    And User enters card details
      | Name On Card  |CardNumber       |Cvv  |
      | RandomName    |4111111111111111 |123  |
    And User enters card expiration date
      | Card Type  | Expiry Year  |Expiry Month |
      | Visa       | 2022         |03           |
