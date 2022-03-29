Feature: NopCommerce Website tests

  Background:
    Given the webpage 'https://demo.nopcommerce.com/' is opened

  @Demo2
  Scenario: 01 Navigate to the website and create a new account
    Then we navigate to Login page
    And we click 'Register' button from Login page
    Then we check if the navigation to Register page was successful
    And we type Eugen in the First name: field in register page
    And we type Lusha in the Last name: field in register page
    And we type eugen7@email.com in the Email: field in register page
    And we type password123 in the Password: field in register page
    And we type password123 in the Confirm password: field in register page
    Then we click the Register from register page
    Then we check if registration was successful
    Then we logout of account

  @Demo2
  Scenario: 02 Login with existing credentials
    Then we navigate to Login page
    And we type eugen7@email.com in the Email: field in login page
    And we type password123 in the Password: field in login page
    Then we click 'Log in' button from Login page
    Then we verify we have logged in successfully
    Then we logout of account

  @Demo2
  Scenario: 03 Verify account credentials
    Then we navigate to Login page
    And we type eugen7@email.com in the Email: field in login page
    And we type password123 in the Password: field in login page
    Then we click 'Log in' button from Login page
    Then we verify we have logged in successfully
    Then we navigate to MyAccount page
    And we verify if credentials are correct first name 'Eugen' last name 'Lusha' email 'eugen7@email.com'
    Then we logout of account

  @Demo2
  Scenario: 04 Navigate to notebooks page and browse through products and change filters
    Then we navigate to Notebooks page
    And we check if the navigation to Notebooks page was successful
    And we choose to show 9 products per page
    Then we verify 6 products are shown
    Then we filter by memory 16 GB
    And we verify 1 products are shown
    Then we remove filter by memory 16 GB
    And we verify 6 products are shown

  @Demo2
  Scenario: 05 Add some products to cart and some to wishlist
    Then we navigate to Login page
    And we type eugen7@email.com in the Email: field in login page
    And we type password123 in the Password: field in login page
    Then we click 'Log in' button from Login page
    Then we verify we have logged in successfully
    Then we navigate to Notebooks page
    And we add products to wishlist
      | 2 | 3 |
    And we add products to cart
      | 4 | 5 | 6 |
    Then we verify number of products added to wishlist is 2
    Then we verify number of products added to cart is 3
    Then we logout of account


  @Demo2
  Scenario: 06 After we login we go to cart page and verify that the sum of the products matches the total sum
    Then we navigate to Login page
    And we type eugen7@email.com in the Email: field in login page
    And we type password123 in the Password: field in login page
    Then we click 'Log in' button from Login page
    Then we verify we have logged in successfully
    Then we navigate to Cart page
    And we check if the navigation to Cart page was successful
    And we check if the cart action buttons are displayed
    Then we logout of account


  @Demo2
  Scenario: 07 After we login we start deleting products we have previously added to cart
    Then we navigate to Login page
    And we type eugen7@email.com in the Email: field in login page
    And we type password123 in the Password: field in login page
    Then we click 'Log in' button from Login page
    Then we verify we have logged in successfully
    Then we navigate to Cart page
    And we delete the first product in cart while verifying the product was deleted
    And we delete all products in cart while verifying the products are deleted
    Then we verify cart is empty
    Then we logout of account


  @Demo2
  Scenario Outline: Create some accounts
    Then we navigate to Register page
    Then we check if the navigation to Register page was successful
    And we type <firstname> in the First name: field in register page
    And we type <lastname> in the Last name: field in register page
    And we type <email> in the Email: field in register page
    And we type <password> in the Password: field in register page
    And we type <password> in the Confirm password: field in register page
    Then we click the Register from register page
    Then we check if registration was successful
    Then we logout of account
    Examples:
      | firstname | lastname  | email           | password |
      | emri1     | mbiemri1  | ab000@email.com | asdnd2   |
      | emri2     | mbiemri2  | ab111@email.com | aasdend2 |
      | emri3     | mbiemri3  | ab222@email.com | adend2   |

