package schedulerrest;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import dto.DateDto;
import dto.RecordDto;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class AddNewRecordTestsRest {
    String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6Im5vYUBnbWFpbC5jb20ifQ.G_wfK7FRQLRTPu9bs2iDi2fcs69FHmW-0dTY4v8o5Eo";
    @BeforeMethod
    public void precondition(){
        RestAssured.baseURI = "https://super-scheduler-app.herokuapp.com/";
        RestAssured.basePath="api";
    }

    @Test
    public void addNewRecordSuccess(){

        RecordDto recordDto = RecordDto.builder()
                .breaks(2)
                .currency("CRN")
                .date(DateDto.builder().dayOfMonth(1).dayOfWeek("1").month(2).year(2022).build())
                .hours(4)
                .timeFrom("18:00")
                .timeTo("21:00")
                .title("Title")
                .type("type")
                .totalSalary(300)
                .wage(100).build();

        int id = given()
                .body(recordDto)
                .contentType(ContentType.JSON)
                .header("Authorization",token)
                .when()
                .post("record")
                .then()
                .assertThat().statusCode(200)
                .extract().path("id");
        System.out.println(id);




    }
}
