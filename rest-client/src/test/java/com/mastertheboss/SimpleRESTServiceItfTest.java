package com.mastertheboss;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import javax.inject.Inject;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;

@QuarkusTest
public class SimpleRESTServiceItfTest {

    @Inject
    @InjectMock
    @RestClient 
    SimpleRESTServiceItf simpleRESTServiceItf;

	@BeforeEach
	void setUp() {
		Mockito.when(simpleRESTServiceItf.getHello()).thenReturn("hello world!");
	}

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/proxy/text")
          .then()
             .statusCode(200)
             .body(is("hello world!"));
    }
}