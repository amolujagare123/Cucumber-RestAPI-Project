package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.UpdateChatUser;


import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static util.POJOPayloads.payLoadUpdateUser;

public class UpdateChatUserSD {

    RequestSpecification request;
    RequestSpecification reqSpecBuilder;
    Response hitRequest;
    @Given("^update User Payload for is created$")
    public void update_user_payload_for_is_created() throws Throwable {


        PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
        auth.setUserName("admin");
        auth.setPassword("admin123");

         reqSpecBuilder = new RequestSpecBuilder()
                .setBaseUri("http://chat.cookingwithamol.in")
                .addHeader("Content-Type", "application/json")
                .setAuth(auth).build();

        request = given().log().all().spec(reqSpecBuilder).body(payLoadUpdateUser());


    }

    @When("^user calls UpdateUser with \"([^\"]*)\" http request$")
    public void user_calls_updateuser_with_something_http_request(String strArg1) throws Throwable {


        String userid = "13";

         hitRequest = request.when().put("/index.php/site_admin/restapi/user/" + userid);

    }


    @Then("^the update user API call got success with status code \"([^\"]*)\"$")
    public void the_update_user_api_call_got_success_with_status_code_something(String statusCode) throws Throwable {
        ResponseSpecification responseSpecBuilder
                = new ResponseSpecBuilder().expectStatusCode(Integer.parseInt(statusCode)).build();

        hitRequest.then().log().all().spec(responseSpecBuilder);

    }

    @Then("^\"([^\"]*)\" should be \"([^\"]*)\";$")
    public void something_should_be_something(String jsonPath, String expectedValue)  {

        String responseStr = hitRequest.asString();

        JsonPath js = new JsonPath(responseStr);

        String actual =  js.get(jsonPath).toString();

        System.out.println("expectedValue="+expectedValue);
        System.out.println("actual="+actual);

        assertEquals("the value is different",expectedValue,actual);
    }

}
