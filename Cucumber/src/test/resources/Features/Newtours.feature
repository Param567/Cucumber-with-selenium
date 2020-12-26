Feature: To test Users are registered successfully

  Scenario Outline: Validate Registration is working properly
    Given User is on browser and is on Register page
    When User enters <FirstName> , <LastName> , <Phone> , <UserName> , <Address1> , <City> , <State> , <Postalcode>
    And Selects Country
    And Enters Email , Password , ConfirmPassword
    And Clicks on Submit
    Then USer is created succesfully
    
 Examples:
 
 | FirstName | LastName | Phone | UserName | Address1 | City | State | Postalcode |
 | Param004 | Baranwal | 9876543210 | Param@gmail.com | Boisar | Mumbai | Maharashtra | 401501 |
 