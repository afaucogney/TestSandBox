package fr.afaucogney.mobile.android.app.testsandbox.edf.rememberme.stepdefinitions

import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

class StepDefinitions {
    private var actionwords = Actionwords()

    @cucumber.api.java.en.Given("^The option RememberMe is set to \"(.*)\"$")
    fun theOptionRememberMeIsSetToSeSouvenirDeMoi(seSouvenirDeMoi: String) {
        actionwords.theOptionRememberMeIsSetToSeSouvenirDeMoi(seSouvenirDeMoi)
    }

    @Given("^The phone is rooted \"(.*)\"$")
    fun thePhoneIsRootedIsRooted(isRooted: String) {
        actionwords.thePhoneIsRootedIsRooted(isRooted)
    }

    @Given("^The phone has security setup \"(.*)\"$")
    fun thePhoneHasSecuritySetupHasSecuritySetup(hasSecuritySetup: String) {
        actionwords.thePhoneHasSecuritySetupHasSecuritySetup(hasSecuritySetup)
    }

    @Given("^The android version is at least Lollipop \"(.*)\"$")
    fun theAndroidVersionIsAtLeastLollipopIsAtLeastLollipop(isAtLeastLollipop: String) {
        actionwords.theAndroidVersionIsAtLeastLollipopIsAtLeastLollipop(isAtLeastLollipop)
    }

    @When("^The IsRememberMeAllowedUseCase is executed$")
    fun theIsRememberMeAllowedUseCaseIsExecuted() {
        actionwords.theIsRememberMeAllowedUseCaseIsExecuted()
    }

    @Then("^The IsRememberMe option availability is \"(.*)\"$")
    fun theIsRememberMeOptionAvailabilityIsIsRememberMeAllowed(isRememberMeAllowed: String) {
        actionwords.theIsRememberMeOptionAvailabilityIsIsRememberMeAllowed(isRememberMeAllowed)
    }
}