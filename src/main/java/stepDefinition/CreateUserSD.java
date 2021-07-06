package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;
import static util.POJOPayloads.payLoadUpdateCreateUser;
import static util.POJOPayloads.payLoadUpdateUser;
import static util.SpectObjects.getLoadedSpecObject;

public class CreateUserSD {
    RequestSpecification request;
    Response hitRequest;

    @Given("^Create chat User Payload with (.+) , (.+) , (.+) ,(.+) ,(.+) ,(.+)$")
    public void create_chat_user_payload_with_(String user, String pass, String email, String name, String surname, String nickname) throws Throwable {
        request = given().log().all().spec(getLoadedSpecObject())
                .body(payLoadUpdateCreateUser(user,pass,email,name,surname,nickname));

    }

    @When("^user calls create with POST http request$")
    public void user_calls_create_with_post_http_request() throws Throwable {


         hitRequest = request.when().post("/index.php/site_admin/restapi/user");
    }

    @Then("^the create user API call got success with status code \"([^\"]*)\"$")
    public void the_create_user_api_call_got_success_with_status_code_something(String statusCode) throws Throwable {
        ResponseSpecification responseSpecBuilder
                = new ResponseSpecBuilder().expectStatusCode(Integer.parseInt(statusCode)).build();

      /* String resStr = */ hitRequest.then().log().all().spec(responseSpecBuilder)/*.extract().asString()*/;

     // System.out.println(resStr);
    }
}
