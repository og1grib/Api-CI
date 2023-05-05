package reqres;

import api.models.UserRegister;
import api.models.UserRegisterResponse;
import api.steps.ReqresSteps;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class TestPost {

    private final ReqresSteps reqresSteps = new ReqresSteps();

    //Позитивный
    @Test
    public void successRegisterUser() {
        UserRegister userRegister = new UserRegister("george.bluth@reqres.in", "12345");
        UserRegisterResponse userRegisterResponse = new UserRegisterResponse(1, "QpwL5tke4Pnpja7X1");

        Response response = reqresSteps.postUserRegisterSuccess(userRegister);

        reqresSteps.checkUserRegisterSuccess(response, userRegisterResponse);
    }

    //Негативный
    @Test
    public void unSuccessRegisterUser() {
        UserRegister userRegister = new UserRegister(null, null);

        Response response = reqresSteps.postUserRegisterUnSuccess(userRegister);

        reqresSteps.checkUserRegisterUnSuccess(response,"Missing email or username");
    }

}
