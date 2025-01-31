package Base;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static org.hamcrest.Matchers.*;

public class Basics {
    public static void main(String[] args) {
        System.out.println("Shubham");
        //validate if add place API is working as expected
        //given - all input details
        //when - submit the API - resource and https methood
        //Then - validate the response
        RestAssured.baseURI = "https://rahulshettyacademy.com";

        //add place (POST method) capture its place_id then update place with new address(PUT method)
        //Get place (GET method) to validate if new address is present in response.

        //add place
        String response = given()
                .queryParam("key","qaclick123")
                .header("content-type","application/json")
                .body(PayLoad.addPlace())
                .log().all()
                .when()
                .post("maps/api/place/add/json")
                .then()
                .assertThat()
                .statusCode(200)
                .body("scope",equalTo("APP"))
                .header("server","Apache/2.4.52 (Ubuntu)")
                .extract().response().asString();

        System.out.println(response);
        System.out.println("-------------------------------------------------");
        JsonPath js = new JsonPath(response);   //for parsing JSON
        String place_id = js.getString("place_id");
        System.out.println(place_id);
        System.out.println("-------------------------------------------------");
        String newAdd = "23 Street ABc Complex";
        //update place
        given().queryParam("key","qaclick123")
                .header("content-type","application/json")
                .body("{\n" +
                        "   \"place_id\": \""+place_id+"\" ,\n" +
                        "   \"address\": \""+newAdd+"\",\n" +
                        "   \"key\":\"qaclick123\"\n" +
                        "}")
                .log().all()
                .when()
                .put("maps/api/place/update/json")
                .then()
                .assertThat()
                .log().all()
                .statusCode(200)
                .body("msg",equalTo("Address successfully updated"));

        System.out.println("-------------------------------------------------");
        //get place
        given().queryParam("key","qaclick123")
                .queryParam("place_id",place_id)
                .when()
                .log().all()
                .get("maps/api/place/get/json")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body("address",equalTo(newAdd));
    }
}
