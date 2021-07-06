package util;

import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class SpectObjects {


    public static RequestSpecification getLoadedSpecObject()
    {
        PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
        auth.setUserName("admin");
        auth.setPassword("admin123");

        RequestSpecification reqSpecBuilder = new RequestSpecBuilder()
                .setBaseUri("http://chat.cookingwithamol.in")
                .addHeader("Content-Type", "application/json")
                .setAuth(auth).build();

        return reqSpecBuilder;
    }
}
