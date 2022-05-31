package contacttests;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import dto.ContactDto;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class AddNewContactRest {
    String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6Im5vYUBnbWFpbC5jb20ifQ.G_wfK7FRQLRTPu9bs2iDi2fcs69FHmW-0dTY4v8o5Eo";

    @BeforeMethod
    public void preCondition(){
        RestAssured.baseURI = "https://contacts-telran.herokuapp.com/";
        RestAssured.basePath="api";
    }

    @Test
    public void addNewContactSuccess(){

        int i = (int) (System.currentTimeMillis()/1000);
        ContactDto contactDto = ContactDto.builder()
                .name("Maya")
                .lastName("Dow")
                .email("maya"+i+"@mail.com")
                .address("Haifa")
                .phone("8888"+i)
                .description("Friend").build();

        ContactDto contact = given()
                .header("Authorization",token)
                .body(contactDto)
                .contentType(ContentType.JSON)
                .when()
                .post("contact")
                .then()
                .assertThat().statusCode(200)
                .extract()
                .response()
                .as(ContactDto.class);
        System.out.println(contact.getId());

        Assert.assertEquals(contactDto.getName(),contact.getName());
        Assert.assertEquals(contactDto.getLastName(),contact.getLastName());
        Assert.assertNotEquals(contactDto.getId(),contact.getId());
        Assert.assertEquals(contactDto.getEmail(),contact.getEmail());
        Assert.assertEquals(contactDto.getPhone(),contact.getPhone());
        Assert.assertNotEquals(contactDto,contact);
    }
}
