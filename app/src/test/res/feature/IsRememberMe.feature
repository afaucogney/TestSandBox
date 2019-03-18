Feature: IsRememberMe


  Scenario Outline: IsRememberMeAllowedUseCase (<hiptest-uid>)
    Given The option RememberMe is set to "<seSouvenirDeMoi>"
    Given The phone is rooted "<isRooted>"
    Given The phone has security setup "<hasSecuritySetup>"
    Given The android version is at least Lollipop "<isAtLeastLollipop>"
    When The IsRememberMeAllowedUseCase is executed
    Then The IsRememberMe option availability is "<isRememberMeAllowed>"

    Examples:
      | seSouvenirDeMoi | isRooted | hasSecuritySetup | isAtLeastLollipop | isRememberMeAllowed | hiptest-uid |
      | true | true | true | true | false |  |
      | true | false | false | true | false |  |
      | true | false | true | false | false |  |
      | false | false | true | true | false |  |
      | true | false | true | true | true |  |
