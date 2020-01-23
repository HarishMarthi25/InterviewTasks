@HoverImages
Feature: Hover images and read user details

  @HoverImages
  Scenario Outline: Verify user details when user hover the images
    Given User launch the hover application
    When The page is loaded successfully
    Then User verify the hovers header text as <hoverHeader>
    And User Verify the hovers description text as <descriptionText>
    And User hovers the mouse on image one
    Then User Verify the user one name as <userNameOne>
    And User hovers the mouse on image two
    Then User Verify the user two name as <userNameTwo>
    And User hovers the mouse on image three
    Then User Verify the user three  name as <userNameThree>
    And User Verify powered by text as <poweredByText> below the images section

    Examples: 
      | hoverHeader | descriptionText                                 | userNameOne | userNameTwo | userNameThree | poweredByText                 |
      | Hovers      | Hover over the image for additional information | name: user1 | name: user2 | name: user3   | Powered by Elemental Selenium |
