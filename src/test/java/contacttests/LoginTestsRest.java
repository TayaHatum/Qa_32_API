package contacttests;

import com.jayway.restassured.RestAssured;
import dto.AuthRequestDto;
import dto.AuthResponseDto;
import dto.ErrorDto;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class LoginTestsRest {

    @BeforeMethod
    public void preCondition(){
        RestAssured.baseURI = "https://contacts-telran.herokuapp.com/";
        RestAssured.basePath="api";
    }

    @Test
    public void loginSuccess(){


        AuthResponseDto responseDto = given()
                .body(AuthRequestDto.builder()
                        .email("noa@gmail.com")
                        .password("Nnoa12345$").build())
                .contentType("application/json")
                .when()
                .post("login")
                .then()
                .assertThat().statusCode(200)
                .extract()
                .response()
                .as(AuthResponseDto.class);
        System.out.println(responseDto.getToken());

    }
    @Test
    public void loginWrongEmail(){
        ErrorDto errorDto =given()
                .body(AuthRequestDto.builder().
                        email("noagmail.com")
                        .password("Nnoa12345$").build())
                .contentType("application/json")
                .when()
                .post("login")
                .then()
                .assertThat().statusCode(400)
                .extract()
                .response()
                .as(ErrorDto.class);
        Assert.assertEquals(errorDto.getMessage(),"Wrong email format! Example: name@mail.com");



    }
}
