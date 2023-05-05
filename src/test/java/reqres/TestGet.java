package reqres;

import api.models.FindUser;
import api.models.Support;
import api.models.User;
import api.steps.ReqresSteps;
import io.restassured.response.Response;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class TestGet {
    private final ReqresSteps reqresSteps = new ReqresSteps();

    //Позитивный
    @ParameterizedTest
    @ValueSource(strings = {"5"})
    public void successUpdateUser(String user) {
        User user1 = new User("5","charles.morris@reqres.in","Charles","Morris", "https://reqres.in/img/faces/5-image.jpg");
        Support support = new Support("https://reqres.in/#support-heading","To keep ReqRes free, contributions towards server costs are appreciated!");
        FindUser findUser = new FindUser(user1,support);
        Response response = reqresSteps.getUserFindSuccess(user);

        reqresSteps.checkFindUserSuccess(response,findUser);
    }

    //Негативный
    @ParameterizedTest
    @ValueSource(strings = {"50"})
    public void unSuccessUpdateUser(String user) {

        Response response = reqresSteps.getUserFindUnSuccess(user);


    }
}
