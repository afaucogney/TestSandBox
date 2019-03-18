package fr.afaucogney.mobile.android.app.testsandbox.edf.rememberme

import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith


@RunWith(Cucumber::class)
@CucumberOptions(
    features = ["src/test/res/feature/"],
    glue = ["fr.afaucogney.mobile.android.app.testsandbox.edf.rememberme.stepdefinitions"]
)
class IsRememberMeAllowedUseCaseBddRunner