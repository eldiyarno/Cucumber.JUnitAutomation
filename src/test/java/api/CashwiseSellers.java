package api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.CashwiseAuthorization;
import utilities.Config;

import java.util.HashMap;
import java.util.Map;

public class CashwiseSellers {
    Faker faker = new Faker();
    @Test
    public void getSingleSeller(){
        String token = CashwiseAuthorization.getToken();
        String url = Config.getValue("apiCashWiseURL")+"/api/myaccount/sellers/63";
        Response response = RestAssured.given().auth().oauth2(token).get(url);
        System.out.println(response.statusCode());
        response.prettyPrint();
    }
    @Test
    public void getAllSellers() throws JsonProcessingException {
        String token = CashwiseAuthorization.getToken();
        String url = Config.getValue("apiCashWiseURL")+"/api/myaccount/sellers";
        Map<String, Object> params =new HashMap<>();
        params.put("page",1);
        params.put("size",27);
        params.put("isArchived",false);
        Response response = RestAssured.given().auth().oauth2(token).params(params).get(url);
        System.out.println(response.statusCode());
        ObjectMapper objectMapper =new ObjectMapper();
        CustomResponse customResponse = objectMapper.readValue(response.asString(), CustomResponse.class);
       int size = customResponse.getResponses().size();
       for (int i = 0; i<size ; i++){
           System.out.println(customResponse.getResponses().get(i).getEmail());
       }
    }

    @Test
    public void createSeller() throws JsonProcessingException {

        String token = CashwiseAuthorization.getToken();
        String url = Config.getValue("apiCashWiseURL")+"/api/myaccount/sellers/";
        RequestBody requestBody = new RequestBody();
        requestBody.setCompany_name(faker.company().name());
        requestBody.setSeller_name(faker.name().fullName());
        requestBody.setEmail(faker.internet().emailAddress());
        requestBody.setPhone_number(faker.phoneNumber().cellPhone());
        requestBody.setAddress(faker.address().fullAddress());

        Response response = RestAssured.given().auth().oauth2(token).contentType(ContentType.JSON).body(requestBody).post(url);
        response.prettyPrint();
        System.out.println(response.statusCode());

        String seller_id = response.jsonPath().getString("seller_id");
        System.out.println(seller_id);

        ObjectMapper objectMapper =new ObjectMapper();
        CustomResponse customResponse = objectMapper.readValue(response.asString(), CustomResponse.class);
        System.out.println(customResponse.getSeller_id());

        int id = customResponse.getSeller_id();

        Response response1 = RestAssured.given().auth().oauth2(token).contentType(ContentType.JSON).get(url+id);
        response1.prettyPrint();

    }

    @Test
    public void createManySellers() throws JsonProcessingException {
        String token = CashwiseAuthorization.getToken();
        String url = Config.getValue("apiCashWiseURL")+"/api/myaccount/sellers/";

        for (int i = 0; i<15; i++){
            RequestBody requestBody = new RequestBody();
            requestBody.setCompany_name(faker.company().name());
            requestBody.setSeller_name(faker.name().fullName());
            requestBody.setEmail(faker.internet().emailAddress());
            requestBody.setPhone_number(faker.phoneNumber().cellPhone());
            requestBody.setAddress(faker.address().fullAddress());

            Response response = RestAssured.given().auth().oauth2(token).contentType(ContentType.JSON).body(requestBody).post(url);

        }

    }

    @Test
    public void deleteSellers() throws JsonProcessingException {
        String token = CashwiseAuthorization.getToken();
        String url = Config.getValue("apiCashWiseURL")+"/api/myaccount/sellers/";
        Map<String, Object> params =new HashMap<>();
        params.put("page",1);
        params.put("size",27);
        params.put("isArchived",false);
        Response response = RestAssured.given().auth().oauth2(token).params(params).get(url);
        ObjectMapper objectMapper =new ObjectMapper();
        CustomResponse customResponse = objectMapper.readValue(response.asString(), CustomResponse.class);
        int size =customResponse.getResponses().size();
        for (int i = 0; i<size; i++){
            String email = customResponse.getResponses().get(i).getEmail();
            if (email.endsWith("hotmail.com")){
                int id = customResponse.getResponses().get(i).getSeller_id();
               String urlForArchive = Config.getValue("apiCashWiseURL")+"/api/myaccount/sellers/archive/unarchive";
               Map<String, Object> paramsArchive = new HashMap<>();
               paramsArchive.put("sellersIdsForArchive", id);
               paramsArchive.put("archive", true);
               Response response1 = RestAssured.given().auth().oauth2(token).params(paramsArchive).post(urlForArchive);
                System.out.println(response1);
            }

        }


        }



}
