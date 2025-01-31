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
                .body(PayLoad.addPlace())
                .when()
                .post("maps/api/place/add/json")
                .then()
                .log().all()  //to log all response and see it in output
                .assertThat()
                .statusCode(200)
                .body("scope",equalTo("APP"))
                .header("server","Apache/2.4.52 (Ubuntu)");

        //add place (POST method) capture its place_id then update place with new address(PUT method)
        //Get place (GET method) to validate if new address is present in response.
    }
}
