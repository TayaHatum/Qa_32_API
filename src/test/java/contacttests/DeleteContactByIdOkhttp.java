package contacttests;

import com.google.gson.Gson;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactByIdOkhttp {

    int id;
    public static final MediaType JSON = MediaType.get("application/json;charset=utf-8");
    Gson gson = new Gson();
    OkHttpClient client = new OkHttpClient();
    String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6Im5vYUBnbWFpbC5jb20ifQ.G_wfK7FRQLRTPu9bs2iDi2fcs69FHmW-0dTY4v8o5Eo";


    @BeforeMethod
    public void preCondition(){
        // add new contact
    }

    @Test
    public void deleteContactByIdSuccess(){

    }
}
