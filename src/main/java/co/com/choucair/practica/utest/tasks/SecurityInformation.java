package co.com.choucair.practica.utest.tasks;

import co.com.choucair.practica.utest.model.PersonalInfo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.List;

import static co.com.choucair.practica.utest.userinterface.SignupStep4Page.*;

public class SecurityInformation implements Task {
    private List<PersonalInfo> personalData;

    public SecurityInformation(List<PersonalInfo> personalData) {
        this.personalData = personalData;
    }

    public static SecurityInformation with(List<PersonalInfo> personalData) {
        return Tasks.instrumented(SecurityInformation.class,
                personalData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(personalData.get(0).getStrPassword()).into(INPUT_PASSWORD),
                Enter.theValue(personalData.get(0).getStrPassword()).into(INPUT_PASSWORD_CONFIRM),
                Click.on(CHECK_TERM),
                Click.on(CHECK_POLICY),
                Click.on(BUTTON_NEXT)
        );
    }
}
