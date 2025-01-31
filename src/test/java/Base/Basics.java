package Base;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;

public class Basics {
    public static void main(String[] args) {
        System.out.println("Shubham");
        //validate if add place API is working as expected
        //given - all input details
        //when - submit the API - resource and https methood
        //Then - validate the response
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        given()
                .log().all()    //to log input
                .queryParam("key","qaclick123")
                .header("content-type","application/json")
                .body("{\n" +
                        "  \"location\": {\n" +
                        "    \"lat\": -38.3838,\n" +
                        "    \"lng\": 34.4242\n" +
                        "  },\n" +
                        "  \"accuracy\": 50,\n" +
                        "  \"name\": \"Rahul Shetty Academy\",\n" +
                        "  \"phone_number\": \"(+91) 98 239 2387\",\n" +
                        "  \"address\": \"58 Rasul jiwa comp\",\n" +
                        "  \"types\": [\n" +
                        "    \"shoe park\",\n" +
                        "    \"shop\"\n" +
                        "  ],\n" +
                        "  \"website\": \"https://rahulshettyacademy.com\",\n" +
                        "  \"language\": \"french-IN\"\n" +
                        "}")
                .when()
                .post("maps/api/place/add/json")
                .then()
                .log().all()  //to log all response and see it in output
                .assertThat()
                .statusCode(200)
                .body("scope",equalTo("APP"))
                .header("server","Apache/2.4.52 (Ubuntu)");
    }
}
