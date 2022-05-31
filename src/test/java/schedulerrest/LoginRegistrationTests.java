package schedulerrest;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import dto.AuthRequestDto;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class LoginRegistrationTests {

    @BeforeMethod
    public void precondition(){
        RestAssured.baseURI = "https://super-scheduler-app.herokuapp.com/";
        RestAssured.basePath="api";
    }

    @Test
    public void loginSuccess(){

        String  token = given()
                .body(AuthRequestDto.builder().email("noa@gmail.com").password("Nnoa12345$").build())
                .contentType(ContentType.JSON)
                .when()
                .post("login")
                .then()
                .assertThat().statusCode(200)
                .assertThat().body("registration", equalTo(false))
                .assertThat().body("status",containsString("Login success"))
                .extract().path("token");
        System.out.println(token);


    }
    @Test
    public void loginWrongPassword(){
        given()
                .body(AuthRequestDto.builder().email("noa@gmail.com").password("Nnoa123").build())
                .contentType(ContentType.JSON)
                .when()
                .post("https://super-scheduler-app.herokuapp.com/api/login")
                .then()
                .assertThat().statusCode(401)
                .assertThat().body("message",containsString("Wrong email or password"));


    }

}
