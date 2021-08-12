package tests.api;


import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static java.lang.Math.log;

public class ApiSimpleTest {

    @Test
    public void test() {
        String endpoint = "/api/users?page=2";

//    Настройка RestAssured
        RestAssured.baseURI = "https://reqres.in";

//    Настройка Setup Request
        RequestSpecification httpRequest = given();

//       Настройка Setup Response
//        Response response = httpRequest.request("https://reqres.in/api/users?page=2");
        Response response = httpRequest.request(Method.GET, endpoint);

        System.out.println(response.asString());
//        Get Response Body
        String responseBody = response.getBody().asString();
        System.out.println(responseBody);

//        Get Response Status
        int statusCode = response.getStatusCode();
        System.out.println(statusCode);
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void test1() {
        given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }


}
