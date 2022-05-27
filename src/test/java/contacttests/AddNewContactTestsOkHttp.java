package contacttests;

import com.google.gson.Gson;
import dto.ContactDto;
import okhttp3.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddNewContactTestsOkHttp {
    public static final MediaType JSON = MediaType.get("application/json;charset=utf-8");
    Gson gson = new Gson();
    OkHttpClient client = new OkHttpClient();
    String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6Im5vYUBnbWFpbC5jb20ifQ.G_wfK7FRQLRTPu9bs2iDi2fcs69FHmW-0dTY4v8o5Eo";

    @Test
    public void  addNewContactSuccess() throws IOException {
        int i = (int) (System.currentTimeMillis()/1000);
        ContactDto contactDto = ContactDto.builder()
                .name("Maya")
                .lastName("Dow")
                .email("maya"+i+"@mail.com")
                .address("Haifa")
                .phone("8888"+i)
                .description("Friend").build();

        RequestBody body = RequestBody.create(gson.toJson(contactDto),JSON);

        Request request = new Request.Builder()
                .url("https://contacts-telran.herokuapp.com/api/contact")
                .post(body)
                .addHeader("Authorization",token)
                .build();

        Response response = client.newCall(request).execute();
        Assert.assertTrue(response.isSuccessful());
        Assert.assertEquals(response.code(),200);

        ContactDto contact = gson.fromJson(response.body().string(),ContactDto.class);
        System.out.println(contact.getId());
       // id=contact.getId()

        Assert.assertEquals(contactDto.getName(),contact.getName());
        Assert.assertEquals(contactDto.getLastName(),contact.getLastName());
        Assert.assertNotEquals(contactDto.getId(),contact.getId());
        Assert.assertEquals(contactDto.getEmail(),contact.getEmail());
        Assert.assertEquals(contactDto.getPhone(),contact.getPhone());
        Assert.assertNotEquals(contactDto,contact);

    }
}
