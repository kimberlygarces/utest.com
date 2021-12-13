package co.com.choucair.practica.utest.stepdefinitions;

import co.com.choucair.practica.utest.model.*;
import co.com.choucair.practica.utest.questions.Answer;
import co.com.choucair.practica.utest.tasks.*;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class SignupUtestStepDefinitions {
    @Before
    public void setStage(){
        setTheStage(new OnlineCast());
    }

    @Given("^that Kim get the utest page$")
    public void thatKGetTheUtestPage (  ){

        theActorCalled("Kim").wasAbleTo(OpenUp.thePage());
    }

    @When("^he registers$")
    public void heRegisters ( List<PersonalInfo> data ){
        theActorInTheSpotlight().attemptsTo(PersonalInformation.with(data),
                MainInformation.with(data),
                DeviceInformation.with(data),
                SecurityInformation.with(data)
        );
    }

    @Then("^he has registered$")
    public void heHasRegistered (List<Welcome> welcomeData) {
        theActorInTheSpotlight().should(seeThat(Answer.toThe(welcomeData)));
    }
}
