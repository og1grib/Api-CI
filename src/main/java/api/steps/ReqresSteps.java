package api.steps;

import api.models.UserDate;
import api.models.FindUser;
import api.models.UserRegister;
import api.models.UserRegisterResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;


import static io.restassured.RestAssured.given;

public class ReqresSteps {

    public static Response postUserRegisterSuccess(UserRegister userRegister) {

        return given()
                .spec(SpecHelper.getRequestSpec())
                .when()
                .body(userRegister)
                .post("register")
                .then()
                .spec(SpecHelper.getResponseSpec(200))
                .extract()
                .response();
    }

    public void checkUserRegisterSuccess(Response response, UserRegisterResponse userRegisterResponse) {
        Assertions.assertEquals(userRegisterResponse.getId(), response.jsonPath().get("id"));
        Assertions.assertEquals(userRegisterResponse.getToken(), response.jsonPath().get("token"));
    }

    public static Response postUserRegisterUnSuccess(UserRegister userRegister) {

        return given()
                .spec(SpecHelper.getRequestSpec())
                .when()
                .body(userRegister)
                .post("register")
                .then()
                .spec(SpecHelper.getResponseSpec(400))
                .extract()
                .response();
    }

    public void checkUserRegisterUnSuccess(Response response, String error) {
        Assertions.assertEquals(error, response.jsonPath().get("error"));
    }

    public static Response putUserUpdateSuccess(UserDate userDate, String user) {

        return given()
                .spec(SpecHelper.getRequestSpec())
                .when()
                .body(userDate)
                .put(String.format("users/%s", user))
                .then()
                .spec(SpecHelper.getResponseSpec(200))
                .extract()
                .response();
    }

    public void checkUserUpdateSuccess(Response response, UserDate userDate) {
        Assertions.assertEquals(userDate.getName(), response.jsonPath().get("name"));
        Assertions.assertEquals(userDate.getJob(), response.jsonPath().get("job"));
    }

    public static Response deleteUserSuccess(String user) {

        return given()
                .spec(SpecHelper.getRequestSpec())
                .when()
                .delete(String.format("users/%s", user))
                .then()
                .spec(SpecHelper.getResponseSpec(204))
                .extract()
                .response();
    }

    public static Response getUserFindSuccess(String user) {

        return given()
                .spec(SpecHelper.getRequestSpec())
                .when()
                .get(String.format("users/%s", user))
                .then()
                .spec(SpecHelper.getResponseSpec(200))
                .extract()
                .response();
    }

    public static Response getUserFindUnSuccess(String user) {

        return given()
                .spec(SpecHelper.getRequestSpec())
                .when()
                .get(String.format("users/%s", user))
                .then()
                .spec(SpecHelper.getResponseSpec(404))
                .extract()
                .response();
    }

    public void checkFindUserSuccess(Response response, FindUser findUser) {
        Assertions.assertTrue(findUser.getData().getAvatar().endsWith(".jpg"));
    }


}
