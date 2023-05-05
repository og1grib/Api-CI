package reqres;

import api.models.UserDate;
import api.steps.ReqresSteps;
import io.restassured.response.Response;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TestPut {
    private final ReqresSteps reqresSteps = new ReqresSteps();

    //Позитивный
    @ParameterizedTest
    @ValueSource(strings = {"3"})
    public void successUpdateUser(String user) {
        UserDate userDate = new UserDate("Maxim", "CEO");

        Response response = reqresSteps.putUserUpdateSuccess(userDate, user);

        reqresSteps.checkUserUpdateSuccess(response,userDate);
    }

    //Негативный
    @ParameterizedTest
    @ValueSource(strings = {"50"})
    public void unsuccessUpdateNonExistentUser(String user) {
        UserDate userDate = new UserDate("Artem", "engineer");

        Response response = reqresSteps.putUserUpdateSuccess(userDate, user);

        reqresSteps.checkUserUpdateSuccess(response,userDate);
    }
}

