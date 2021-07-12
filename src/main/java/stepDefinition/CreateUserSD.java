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
import util.APIResources;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static util.POJOPayloads.payLoadUpdateCreateUser;
import static util.POJOPayloads.payLoadUpdateUser;
import static util.SpectObjects.getLoadedSpecObject;

public class CreateUserSD {
    RequestSpecification request;
    Response hitRequest;
    String id;
    JsonPath js;
    @Given("^Create chat User Payload with (.+) , (.+) , (.+) ,(.+) ,(.+) ,(.+)$")
    public void create_chat_user_payload_with_(String user, String pass, String email, String name, String surname, String nickname) throws Throwable {

         request = given().log().all().spec(getLoadedSpecObject())
                .body(payLoadUpdateCreateUser(user,pass,email,name,surname,nickname));


    }
    @Given("^update User Payload for is created$")
    public void update_user_payload_for_is_created() throws Throwable {


        request = given().log().all().spec(getLoadedSpecObject()).body(payLoadUpdateUser());


    }

   /* @When("^user calls create with POST http request$")
    public void user_calls_create_with_post_http_request() throws Throwable {


         hitRequest = request.when().post("/index.php/site_admin/restapi/user");
    }*/

    @When("^user calls \"([^\"]*)\" with \"([^\"]*)\" http request  with pathParam \"([^\"]*)\"$")
    public void user_calls_something_with_something_http_request_with_pathparam_something(String resource, String requestType,String pathParam)
            {

                APIResources resourceAPI = APIResources.valueOf(resource);

                System.out.println(resourceAPI.getResource());

                String resourceUrl = resourceAPI.getResource() + pathParam;

                switch (requestType)
                {
                    case "POST" : hitRequest = request.when().post(resourceUrl);break;
                    case "GET" :  hitRequest = request.when().get(resourceUrl);break;
                    case "PUT" :  hitRequest = request.when().put(resourceUrl);break;
                    case "DELETE" :  hitRequest = request.when().delete(resourceUrl);break;
                }


    }

    @Then("^the API call got success with status code \"([^\"]*)\"$")
    public void the_api_call_got_success_with_status_code_something(String statusCode) throws Throwable {
        ResponseSpecification responseSpecBuilder
                = new ResponseSpecBuilder().expectStatusCode(Integer.parseInt(statusCode)).build();

      /* String resStr = */ hitRequest.then().log().all().spec(responseSpecBuilder)/*.extract().asString()*/;

     // System.out.println(resStr);
    }

    @Then("^\"([^\"]*)\" should be \"([^\"]*)\";$")
    public void something_should_be_something(String jsonPath, String expectedValue)  {

        String responseStr = hitRequest.asString();

         js = new JsonPath(responseStr);

        String actual =  js.get(jsonPath).toString();



        System.out.println("expectedValue="+expectedValue);
        System.out.println("actual="+actual);

        assertEquals("the value is different",expectedValue,actual);
    }

    @Given("^Get User request is created$")
    public void get_user_request_is_created() throws IOException {

        request = given().log().all().spec(getLoadedSpecObject());
    }

    @Given("^delete User request is created$")
    public void delete_user_request_is_created() throws Throwable {
        request = given().log().all().spec(getLoadedSpecObject());
    }


    @When("^user calls \"([^\"]*)\" with \"([^\"]*)\" http request with same user$")
    public void user_calls_something_with_something_http_request_with_same_user(String resource, String requestType) throws Throwable {

        id = js.get("result.id").toString();

        user_calls_something_with_something_http_request_with_pathparam_something(resource,requestType,id);
    }
}
