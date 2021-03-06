package org.acme.lambda;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

@QuarkusTest
public class LambdaHandlerTest {

    @Test
    public void testSimpleLambdaSuccess() throws Exception {
        Person person = new Person();
        person.setName("test");
        given()
                .contentType("application/json")
                .accept("application/json")
                .body(person)
                .when()
                .post()
                .then()
                .statusCode(200)
                .body(containsString("Hello test"));
    }

}
