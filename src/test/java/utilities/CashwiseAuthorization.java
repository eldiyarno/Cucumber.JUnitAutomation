package utilities;

import api.RequestBody;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.Config;
import utilities.Driver;

public class CashwiseAuthorization {
    public static String getToken (){
        RequestBody requestBody = new RequestBody();
        requestBody.setEmail(Config.getValue("loginforCashwise"));
        requestBody.setPassword(Config.getValue("passwordforCashwise"));
        Response response = RestAssured.given().contentType(ContentType.JSON).body(requestBody).post(Config.getValue("apiCashWiseURL")+("/api/myaccount/auth/login"));
        System.out.println(response.statusCode());
        response.prettyPrint();

        String token =response.jsonPath().getString("jwt_token");
        return token;
    }
}
