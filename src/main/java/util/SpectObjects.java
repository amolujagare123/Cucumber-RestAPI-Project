package util;

import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static util.ConfigReader.getUrl;

public class SpectObjects {

    static RequestSpecification reqSpecBuilder;
    public static RequestSpecification getLoadedSpecObject() throws IOException {


        if(reqSpecBuilder==null) {
            PrintStream log = new PrintStream(new FileOutputStream("restAssuredLog.txt"));

            PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
            auth.setUserName("admin");
            auth.setPassword("admin123");

            reqSpecBuilder = new RequestSpecBuilder()
                    .setBaseUri(getUrl())
                    .addHeader("Content-Type", "application/json")
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .setAuth(auth).build();
        }
        return reqSpecBuilder;
    }
}
