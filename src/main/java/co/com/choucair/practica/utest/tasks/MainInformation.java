package co.com.choucair.practica.utest.tasks;

import co.com.choucair.practica.utest.model.PersonalInfo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import org.openqa.selenium.Keys;

import java.util.List;

import static co.com.choucair.practica.utest.userinterface.SignupStep2Page.*;

public class MainInformation implements Task {
    private List<PersonalInfo> personalData;

    public MainInformation(List<PersonalInfo> personalData) {
        this.personalData = personalData;
    }

    public static MainInformation with(List<PersonalInfo> personalData) {
        return Tasks.instrumented(MainInformation.class,
                                    personalData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(personalData.get(0).getStrCity()).into(INPUT_CITY),
                Hit.the(Keys.ARROW_DOWN).into(INPUT_CITY),
                Hit.the(Keys.ENTER).into(INPUT_CITY),
                Enter.theValue(personalData.get(0).getStrPostalCode()).into(INPUT_POSTALCODE),
                Click.on(SELECT_COUNTRY),
                Enter.theValue(personalData.get(0).getStrCountry()).into(INPUT_COUNTRY),
                Hit.the(Keys.ARROW_DOWN).into(INPUT_COUNTRY),
                Hit.the(Keys.ENTER).into(INPUT_COUNTRY),
                Click.on(BUTTON_NEXT)
        );
    }
}
