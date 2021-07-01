package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.CreateUser;

import static io.restassured.RestAssured.given;

public class UserCreationSD {
    CreateUser ob;
    RequestSpecification req;
    RequestSpecification res;

    @Given("Add User Payload for is created")
    public void add_user_payload_for_is_created() {

        ob = new CreateUser();
        ob.setName("Avinash");
        ob.setJob("Test Lead");

        req = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in")
                .addHeader("Content-Type", "application/json")
                .build(); // given

        res=given().spec(req)
                .body(ob);

    }
    @When("user calls {string} with {string} http request")
    public void user_calls_with_http_request(String reqName, String reqType) {


        Response response = res.when().post("api/users"); // when



    }
    @Then("the API call got success with status code “{int}”")
    public void the_api_call_got_success_with_status_code(Integer statusCode) {

        ResponseSpecification resp = new ResponseSpecBuilder().expectStatusCode(statusCode).build();

    }
}
