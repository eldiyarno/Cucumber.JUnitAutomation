package api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.Data;
import org.junit.Test;
import utilities.CashwiseAuthorization;
import utilities.Config;

public class CashwiseCategoriesTest {
    @Test
    public void createCategory() throws JsonProcessingException {
        RequestBody requestBody = new RequestBody();
        requestBody.setCategory_title("Rumble");
        requestBody.setCategory_description("Dumble");
        requestBody.setFlag(false);
        String token = CashwiseAuthorization.getToken();

        Response response = RestAssured.given().contentType(ContentType.JSON).
                body(requestBody).auth().oauth2(token).
                post(Config.getValue("apiCashWiseURL")+"/api/myaccount/categories");
        String jsonResponse = response.asString();
        ObjectMapper mapper =new ObjectMapper();
      CustomResponse customResponse =  mapper.readValue(jsonResponse, CustomResponse.class);
        System.out.println(customResponse.getCategory_id());
        System.out.println(customResponse.getCreated());
    }
}
