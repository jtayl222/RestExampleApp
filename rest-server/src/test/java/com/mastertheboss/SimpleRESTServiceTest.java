package com.mastertheboss;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

@QuarkusTest
public class SimpleRESTServiceTest {
    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/api/text")
          .then()
             .statusCode(200)
             .body(is("hello world!"));
    }
}