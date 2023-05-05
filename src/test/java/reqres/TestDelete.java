package reqres;

import api.steps.ReqresSteps;
import io.restassured.response.Response;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TestDelete {
    private final ReqresSteps reqresSteps = new ReqresSteps();

    //Позитивный
    @ParameterizedTest
    @ValueSource(strings = {"10"})
    public void successDeleteUser(String user) {

        Response response = reqresSteps.deleteUserSuccess(user);
    }

    //Негативный
    @ParameterizedTest
    @ValueSource(strings = {"50"})
    public void SuccessDeleteNonExistentUser(String user) {

        Response response = reqresSteps.deleteUserSuccess(user);
    }
}

